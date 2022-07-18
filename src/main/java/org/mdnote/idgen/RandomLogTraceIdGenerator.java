package org.mdnote.idgen;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author Rhythm-2019
 *
 * <p>Randomly generate a unique number, the number is the same within
 * the same millisecond, please pause for a while when using</p>
 */
@Slf4j
public class RandomLogTraceIdGenerator implements LogTraceIdGenerator {
    /**
     *  <p>You can call the method to generate an id. The id is divided into three parts
     *  (@code hostname-timestamp(s)-[8-bit random number and letter])</p>
     *
     * @return identify string
     * @throws IdGeneratorFailureException the hostname acquisition fails
     */
    @Override
    public String generate() throws IdGeneratorFailureException {
        try {
            return String.format("%s-%s-%s",
                    this.getLastFieldOfHostName(), this.getTimestamp(), this.generateRandomAlphameric(8));
        } catch (UnknownHostException e) {
            log.error("get hostname failed");
            throw new IdGeneratorFailureException("failed to get hostname", e);
        }
    }

    /**
     * get hostname
     * @return hostname
     * @throws UnknownHostException hostname is empty or get failed
     */
    private String getHostname() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        if (hostname == null || hostname.isEmpty()) {
            throw new UnknownHostException();
        }
        return hostname;
    }

    /**
     * get timestamp section in id
     * @return current timestamp, unit is millisecond
     */
    @VisibleForTesting
    protected String getTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * get hostname slat dot section
     *
     * for example, hostname is (@code hello.world), return world
     * if dot is no found in hostname, return full hostname
     *
     * @return hostname last field
     * @throws UnknownHostException hostname is empty or get failed
     */
    @VisibleForTesting
    protected String getLastFieldOfHostName() throws UnknownHostException {
        String hostname = getHostname();
        String[] tokens = hostname.split("\\.");
        if (tokens.length > 0) {
            hostname = tokens[tokens.length - 1];
        }
        return hostname;
    }

    /**
     * generate a string of length (@param len)
     *
     * @param len string length you want, throwing (@code IllegalArgumentException) if len is negative
     * @return a random string containing uppercase and lowercase letters and numbers
     */
    @VisibleForTesting
    protected String generateRandomAlphameric(int len) {
        if (len < 0) {
            throw new IllegalArgumentException("len can not be zero");
        }
        char[] result = new char[len];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < len; i++) {
            int rdNum = random.nextInt(10 + 26 + 26);
            if (rdNum < 10) {
                result[i] = (char) ('0' + rdNum);
            } else if (rdNum < 36) {
                result[i] = (char) ('a' + rdNum - 10);
            } else {
                result[i] = (char) ('A' + rdNum - 36);
            }
        }
        return new String(result);
    }
}
