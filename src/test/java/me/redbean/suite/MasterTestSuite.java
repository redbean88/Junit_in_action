package me.redbean.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {TestCase1Test.class,TestCase2Test.class})
public class MasterTestSuite {
}
