package com.fengbaoxp.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author Eugene Wang
 * @since 16/10/25
 */
@DisplayName("Assume Test")
public class AssumeTest {
    @Test
    void exitIfFalseIsTrue() {
        assumeTrue(false);
        System.exit(1);
    }

    @Test
    void exitIfTrueIsFalse() {
        assumeFalse(((BooleanTest) () -> true).truism());
        System.exit(1);
    }

    @Test
    void exitIfNullEqualsString() {
        assumingThat("null".equals(null),
                     () -> System.exit(1));
    }
}
