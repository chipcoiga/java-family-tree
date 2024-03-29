package org.demis.family.gedcom;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;

public class GEDCOMParser {

    private static final Logger logger = Logger.getLogger(GEDCOMParser.class);

    public void parse(Reader input, GEDCOMHandler handler) {
        String line;
        int lineNumber = 1;
        BufferedReader reader = new BufferedReader(input);
        try {
            while (!(line = reader.readLine()).contains("0 " + "TRLR")) {
                logger.debug("read line : " + line);
                handler.handle(parseLine(line, lineNumber++));
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error in parsing", e);
        }
    }

    public void parse(InputStream input, GEDCOMHandler handler) {
        parse(input, Charset.forName("UTF-8"), handler);
    }

    public void parse(InputStream input, Charset charset, GEDCOMHandler handler) {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler is null");
        }

        InputStreamReader reader = new InputStreamReader(input, charset);
        parse(reader, handler);
    }

    public void parse(File input, Charset charset, GEDCOMHandler handler) {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler is null");
        }
        Reader stream;
        try {
            stream = new InputStreamReader(new FileInputStream(input), charset);
            parse(stream, handler);
        } catch (FileNotFoundException ex) {
            logger.error(null, ex);
        }
    }

    public void parse(File input, GEDCOMHandler handler) {
        parse(input, Charset.forName("UTF-8"), handler);
    }


    public void parse(String input, GEDCOMHandler handler) {
        parse(input, Charset.forName("UTF-8"), handler);
    }

    public void parse(String input, Charset charset, GEDCOMHandler handler) {
        Reader stream;
        try {
            stream = new InputStreamReader(new FileInputStream(new File(input)), charset);
            parse(stream, handler);
        } catch (FileNotFoundException ex) {
            logger.error(null, ex);
        }
    }

    public GEDCOMTuple parseLine(String line, int lineNumber) {
        if (line != null && line.length() > 0 && line.endsWith("\n")) {
            line = line.substring(0, line.length() - 1);
        }
        GEDCOMTuple tuple = new GEDCOMTuple();
        tuple.setLineNumber(lineNumber);
        tuple.setLevel(Integer.parseInt(line.substring(0,1)));
        // line kind '<level> @<ref>@ <code> <info>'
        if (line.matches("[0-9]{1} @[a-zA-Z0-9]*@ [a-zA-Z0-9]+ .*")) {
            String subline = line.substring(line.indexOf('@') + 1);
            String code = subline.substring(subline.indexOf('@') + 2);
            tuple.setInfo(code.substring(code.indexOf(' ') + 1));
            tuple.setCode(code.substring(0, code.indexOf(' ')));
            tuple.setRef(subline.substring(0, subline.indexOf('@')));
        }
        // line kind '<level> @<ref>@ <code>'
        else if (line.matches("[0-9]{1} @[a-zA-Z0-9]*@ [a-zA-Z0-9]+")) {
            String subline = line.substring(line.indexOf('@') + 1);
            String code = subline.substring(subline.indexOf('@') + 2);
            tuple.setCode(code);
            tuple.setRef(subline.substring(0, subline.indexOf('@')));
        }
        // line kind '<level> <code> @<ref>@'
        else if (line.matches("[0-9]{1} [a-zA-Z]{4} @[a-zA-Z0-9]+@")) {
            tuple.setCode(line.substring(2,6));
            tuple.setRef(line.substring(8, line.length() -1));
        }
        // line kind '<level> <code> <info>'
        else if (line.matches("[0-9]{1} [a-zA-Z]+ .*")) {
            tuple.setCode(line.substring(2, line.substring(2).indexOf(' ') + 2));
            tuple.setInfo(line.substring(7));
        }
        // line kind '<level> <code>'
        else {
            tuple.setCode(line.substring(2));
        }
        return tuple;
    }

}
