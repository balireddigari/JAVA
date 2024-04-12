package com.PolicyManagement.exception;


public class PolicyMaturedException extends RuntimeException {

    public PolicyMaturedException() {
        super();
    }

    public PolicyMaturedException(String message) {
        super(message);
    }

    public PolicyMaturedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PolicyMaturedException(Throwable cause) {
        super(cause);
    }
}

