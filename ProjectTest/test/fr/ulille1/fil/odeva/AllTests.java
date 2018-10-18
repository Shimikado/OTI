package fr.ulille1.fil.odeva;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MoneyAddTestCase.class, MoneyFactoryTestCase.class, MoneyMock.class})
public class AllTests {
}