package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyFactoryTestCase {
    private MoneyFactory mf;

    @Before
    public void init() {
        mf = MoneyFactory.getDefaultFactory();
    }

    @Test
    public void createCorrectMoney() throws UnexistingCurrencyException {
        Money newMoney = mf.createMoney(26, "EUR");
        assertEquals(newMoney.getCurrency(), "EUR");
        assertEquals(newMoney.getValue(), 26);
    }

    @Test(expected = UnexistingCurrencyException.class)
    public void createMoneyWithUnexistingCurrency() throws UnexistingCurrencyException {
        mf.createMoney(26, "ANYTHING");
    }
}
