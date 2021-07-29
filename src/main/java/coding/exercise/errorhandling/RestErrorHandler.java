package coding.exercise.errorhandling;

import coding.exercise.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(BreedsIOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO handleIOException(BreedsIOException ex) {
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage(ex.getLocalizedMessage());
        dto.setStatus("error");
        return dto;
    }
}
