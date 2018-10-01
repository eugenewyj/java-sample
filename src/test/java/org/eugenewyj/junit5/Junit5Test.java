package org.eugenewyj.junit5;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


/**
 * Junit5测试类样例
 * @author Eugene Wang
 * @since 16/10/25
 */
@RunWith(JUnitPlatform.class)
public class Junit5Test {
    @BeforeAll
    static void initializeExternalResources() {
        System.out.println("Initializing external resources...");
    }

    @BeforeEach
    void initializeMockObjects() {
        System.out.println("Initializing mock objects...");
    }

    @Test
    void someTest() {
        System.out.println("Running some test...");
        assertTrue(true);
    }

    @Test
    void otherTest() {
        assumeTrue(true);
        System.out.println("Running other test...");
        assertNotEquals(1, 42, "Why wouldn't these be the same?");
    }

    /**
     * 禁用测试
     */
    @Test
    @Disabled
    void disabledTest() {
        System.exit(1);
    }

    @Test
    void assertRelatedProperties() {
        Developer dev = new Developer("Johannes", "Link");
        assertAll("developer",
                  () -> assertEquals("Marc", dev.getFirst()),
                  () -> assertEquals("Philipp", dev.getLast()));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down...");
    }

    @AfterAll
    static void freeExternalResources() {
        System.out.println("Freeing external resources...");
    }
}
