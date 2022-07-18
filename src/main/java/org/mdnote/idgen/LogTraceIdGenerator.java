package org.mdnote.idgen;


/**
 * @author Rhythm-2019
 * <p>This interface extends (@link IdGenerator), to generate log trace id</p>
 *
 * <p>When you want to locate all logs related to an interface, generating the
 * same id for each log can improve your efficiency</p>
 *
 * <p>You can make all classes related to log id generation implement this interface</p>
 */
public interface LogTraceIdGenerator extends IdGenerator {
}
