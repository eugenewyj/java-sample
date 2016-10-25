package com.fengbaoxp.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Eugene Wang
 * @since 16/10/25
 */
@DisplayName("Exception Test")
public class ExceptionTest {
    /**
     * 异常相关测试及断言。
     */
    @Test
    void assertExceptions() {
        TestExampler testExampler = new TestExampler();
        assertThrows(RuntimeException.class, testExampler::throwRuntimeException);

        Exception exception = expectThrows(RuntimeException.class, testExampler::throwRuntimeException);
        assertEquals("throw RuntimeException...", exception.getMessage());
    }
}
