package com.dant.exception;

/**
 * InvalidIndexException is an exception for invalid indexes,
 * extends Exception.
 */
public class InvalidIndexException
        extends Exception {

    /**
     * MESSAGE : default message that raises the InvalidIndexException
     */
    private static final String MESSAGE = " invalid index(es) ";

    /**
     * default constructor that initialize instance
     * of InvalidIndexException with MESSAGE through its direct
     * super class Exception, using its string parameterized
     * constructor.
     */
    public InvalidIndexException(){
        super(MESSAGE);
    }

    /**
     * default constructor that initialize instance
     * of InvalidIndexException with message through its direct
     * super class Exception, using its string parameterized
     * constructor.
     * @param message String custom message to pass to raise
     */
    public InvalidIndexException(String message){
        super(MESSAGE + message);
    }
}
