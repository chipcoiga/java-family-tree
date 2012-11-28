package org.demis.family.core.familytree;

import org.demis.family.ResourceNotFound;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: kermabon
 * Date: 28/11/12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class CustomizedDispatcherServlet extends DispatcherServlet {

    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new ResourceNotFound("There is no resource for path : " + request.getRequestURI());
    }
}