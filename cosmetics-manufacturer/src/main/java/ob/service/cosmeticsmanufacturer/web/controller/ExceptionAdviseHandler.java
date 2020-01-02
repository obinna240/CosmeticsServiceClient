package ob.service.cosmeticsmanufacturer.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdviseHandler {

    /**
     * Handle Consttraint Exception
     * @param exception
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> errorHandlers(ConstraintViolationException exception){

        List<String> errors = new ArrayList<>(exception.getConstraintViolations().size());

        exception.getConstraintViolations().forEach(constraintViolation ->  {
            errors.add(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle Bind Exception
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> bindExceptionHandlers(BindException exception){
        return new ResponseEntity<>(exception.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
