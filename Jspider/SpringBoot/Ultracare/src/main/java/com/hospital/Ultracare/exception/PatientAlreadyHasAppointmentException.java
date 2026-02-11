package com.hospital.Ultracare.exception;

public class PatientAlreadyHasAppointmentException extends RuntimeException {
    public PatientAlreadyHasAppointmentException(String message) {
        super(message);
    }
}
