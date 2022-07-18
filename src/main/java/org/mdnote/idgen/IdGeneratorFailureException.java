package org.mdnote.idgen;


/**
 * @author Rhythm-2019
 * <p> Exception uniformly thrown when id generation fails </p>
 *
 * <p> When the caller calls (@link org.mdnote.idgen.IdGenerator#generate.) method,
 * it can perceive the generation failure and handle it</p>
 *
 */
public class IdGeneratorFailureException extends Exception {

    private String msg;

    public IdGeneratorFailureException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public IdGeneratorFailureException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
