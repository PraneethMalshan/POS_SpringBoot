package lk.kdpm.pos_backend.adviser;

import lk.kdpm.pos_backend.exception.NotFoundException;
import lk.kdpm.pos_backend.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e){
          return new ResponseEntity<StandardResponse>(
                  new StandardResponse(404, "Error Comming", e.getMessage() + "Pky"),
                  HttpStatus.NOT_FOUND
          );
    }

}
