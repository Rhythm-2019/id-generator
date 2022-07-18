package org.mdnote.idgen;


/**
 * @author Rhythm-2019
 *
 * <p>This is an Ud Generator Interface, define feberate method</p>
 *
 * <o>Define this interface is order to standardlize how to use id generator</o>
 *
 * <p>You can defind a class and implement this interface to custonmize your generate logic</p>
 */
public interface IdGenerator {

    /**
     * generate a identify string
     * @return identify string
     * @throws IdGeneratorFailureException exception meeting in method
     */
    String generate() throws IdGeneratorFailureException;
}
