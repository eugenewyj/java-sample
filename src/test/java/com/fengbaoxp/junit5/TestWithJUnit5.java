package com.fengbaoxp.junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @author Eugene Wang
 * @since 16/10/25
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({"com.fengbaoxp.junit5"})
public class TestWithJUnit5 {
}
