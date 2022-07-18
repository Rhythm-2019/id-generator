package org.mdnote.idgen;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class RandomLogTraceIdGeneratorTest {

    @Test
    public void testNormal() throws IdGeneratorFailureException, InterruptedException {
        LogTraceIdGenerator randomLogTraceIdGenerator = new RandomLogTraceIdGenerator();
        Set<String> idSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            Thread.sleep(1);
            String id = randomLogTraceIdGenerator.generate();
            if (idSet.contains(id)) {
                Assert.fail("repeat id");
            }
            idSet.add(id);
        }
    }

    @Test
    public void testThreePart() throws IdGeneratorFailureException {
        LogTraceIdGenerator randomLogTraceIdGenerator = new RandomLogTraceIdGenerator();
        String id = randomLogTraceIdGenerator.generate();
        assert id.split("-").length >= 3;
    }

    @Test
    public void testRandomSection() throws InterruptedException, IdGeneratorFailureException {
        LogTraceIdGenerator randomLogTraceIdGenerator = new RandomLogTraceIdGenerator();
        Set<String> idSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            Thread.sleep(1);
            String id = randomLogTraceIdGenerator.generate();
            String[] idSpilt = id.split("-");
            if (!this.isOnlyLetterAndNumber(idSpilt[idSpilt.length - 1])) {
                Assert.fail(String.format("random section %s no only contain letter and number", idSpilt[idSpilt.length - 1]));
            }
            idSet.add(id);
        }
    }

    private boolean isOnlyLetterAndNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
}