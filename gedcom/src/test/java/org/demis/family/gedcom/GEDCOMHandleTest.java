package org.demis.family.gedcom;

import org.demis.family.core.family.FamilyEntity;
import org.testng.annotations.*;

public class GEDCOMHandleTest {

    @Test (groups={"spec"})
    public void testUTF8() {
        GEDCOMParser parser = new GEDCOMParser();
        GEDCOMHandler handler = new GEDCOMHandler();
        parser.parse("src/test/resources/gedcom/gedcom-utf-8.ged", handler);
        assert handler.getFamilyTree() != null : "Expected non null family tree";
        assert handler.getFamilyTree().getIndividuals().size() == 488 : "Expected 488 individuals " + handler.getFamilyTree().getIndividuals().size();
        assert handler.getFamilyTree().getFamilies().size() == 199 : "Expected 199 families " + handler.getFamilyTree().getFamilies().size();
//        assert handler.getFamilyTree().getMultimedia().size() == 0 : "Expected 0 multimedia " + handler.getFamilyTree().getMultimedia().size();
//        assert handler.getFamilyTree().getNotes().size() == 1 : "Expected 1 notes " + handler.getFamilyTree().getNotes().size();
//        assert handler.getFamilyTree().getRepositories().size() == 0 : "Expected 1 repositories " + handler.getFamilyTree().getRepositories().size();
//        assert handler.getFamilyTree().getSources().size() == 3 : "Expected 3 sources " + handler.getFamilyTree().getSources().size();
//        assert handler.getFamilyTree().getSubmitters().size() == 1 : "Expected 1 submitters " + handler.getFamilyTree().getSubmitters().size();
//        assert handler.getFamilyTree().getSubmissions().size() == 0 : "Expected 0 submissions " + handler.getFamilyTree().getSubmissions().size();
    }

    @Test()
    public void testHeaderUTF8() {
        GEDCOMParser parser = new GEDCOMParser();
        GEDCOMHandler handler = new GEDCOMHandler();
        parser.parse("src/test/resources/gedcom/gedcom-header-utf-8.ged", handler);
    }
}
