package kbe.aw.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HardwareComponentNotFoundAdvice
{
   @ResponseBody
   @ExceptionHandler(HardwareComponentNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   String hardwareComponentNotFoundHandler(HardwareComponentNotFoundException exception)
   {
      return exception.getMessage();
   }
}
