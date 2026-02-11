package com.hospital.Ultracare.exception;

import com.hospital.Ultracare.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNoDataFoundException(NoDataFoundException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DoctorNotAvailableException.class)
    public ResponseEntity<ResponseStructure<String>> handleDoctorNotAvailableException(DoctorNotAvailableException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PatientAlreadyHasAppointmentException.class)
    public ResponseEntity<ResponseStructure<String>> handlePatientAlreadyHasAppointmentException(PatientAlreadyHasAppointmentException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AppointmentNotCompletedException.class)
    public ResponseEntity<ResponseStructure<String>> handleAppointmentNotCompletedException(AppointmentNotCompletedException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseStructure<String>> handleRuntimeException(RuntimeException exception){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
    }

}
