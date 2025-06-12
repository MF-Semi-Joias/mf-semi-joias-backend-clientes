package com.api.mfsemijoias_cadastracliente.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad Request");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("path", "/cliente"); // Ajuste conforme o endpoint

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CustomErrorResponse> handleException(Exception ex, HttpServletRequest request) {
      // Log detalhado do erro
      logger.error("Erro ocorrido na URL: {} - Mensagem: {} - Causa: {}",
              request.getRequestURL(),
              ex.getMessage(),
              ex.getCause(),
              ex);

      // Construir a resposta de erro personalizada
      CustomErrorResponse errorResponse = CustomErrorResponse.builder()
              .timestamp(LocalDateTime.now())
              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .error("Internal Server Error")
              .message(ex.getMessage())
              .path(request.getRequestURI())
              .build();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

}