package by.netcracker.web.controller;

import by.netcracker.web.exceptions.WebErrorCode;
import by.netcracker.web.exceptions.WebException;
import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is controller advice. It is processing exception.
 * @author Hromenkov Ilya
 * @version 1.0
 */

@ControllerAdvice
public class ExceptionController {
    private static Logger log = Logger.getLogger(ExceptionController.class);

    /**
     * This method processing WebException and
     * return "error" page and error message.
     * @param ex Get WebException.
     * @return ModelAndView - "error" page and error message.
     */
    @ExceptionHandler(WebException.class)
    public ModelAndView customException(WebException ex) {
        ModelAndView model = new ModelAndView("error", "errMsg", ex.getMessage());
        log.info(ex.getMessage());
        return model;
    }

    /**
     * This method work when incoming Not Supported Exception in Http Request.
     * Example: 405 error.
     * @return ModelAndView - "error" page and error message
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView statusCustomException() {
        ModelAndView model = new ModelAndView("error", "errMsg", WebErrorCode.NC_WEB_007.toString());
        log.info(WebErrorCode.NC_WEB_007.toString());
        return model;
    }

}
