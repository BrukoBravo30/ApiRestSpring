package mx.unam.aragon.ico.ings.videojuegos.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManejadorGlobalErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<HashMap<String,String>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        HashMap<String,String> errores = new HashMap<>();
        errores.put("Tiempo:", LocalDateTime.now().toString());
        errores.put("mensaje","Error al validar el argumeto");
        errores.put("codigo","4300");
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<String>
    HttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return ResponseEntity.ok("la peticion tiene un formato invalido");
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<Map<String, String>> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("codigo", "405");
        error.put("mensaje", "Método HTTP no permitido. Usa: " + ex.getSupportedHttpMethods());
        error.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errores = new HashMap<>();
        errores.put("tiempo", LocalDateTime.now().toString());
        errores.put("mensaje", "Error de validación al guardar/actualizar en la base de datos");

        ex.getConstraintViolations().forEach(violation -> {
            String campo = violation.getPropertyPath().toString();
            errores.put(campo, violation.getMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }


}
