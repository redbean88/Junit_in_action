package me.redbean.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)  // 1. 스위트 러너
@Suite.SuiteClasses(value = TestCase2Test.class)
public class TestSuiteB {
}
