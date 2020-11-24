package com.interview.questions.exception;

/**
 * Error thrown when a record is not found in the repository
 */
public class RecordNotFoundException extends Exception {

    /**
     * Record Not Found Exception
     * @param msg Message sent with exception
     */
    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
