package org.demis.family.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: kermabon
 * Date: 28/11/12
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ModelAndView();
    }

    public ExceptionHandler getHandler() {
        return new ExceptionHandler();
    }
}
