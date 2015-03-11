package org.zoo.hippo.exception;
/**
 * 
 * @author yankai913@gmail.com
 * @date 2015-1-13
 */
public class HippoException extends Exception {

    private static final long serialVersionUID = 652282572120068047L;


    public HippoException() {
        super();
    }


    public HippoException(String message) {
        super(message);
    }


    public HippoException(String message, Throwable cause) {
        super(message, cause);
    }


    public HippoException(Throwable cause) {
        super(cause);
    }
}
