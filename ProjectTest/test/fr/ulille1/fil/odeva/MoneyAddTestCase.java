package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/*
 * Unit test for simple App.
 */
public class MoneyAddTestCase {
    private Money f12EUR, f14EUR, f14CHF;
    private MoneyFactory mf;

    @Before
    public void init() throws UnexistingCurrencyException {
        mf = MoneyFactory.getDefaultFactory();
        f12EUR = mf.createMoney(12, "EUR");
        f14EUR = mf.createMoney(14, "EUR");
        f14CHF = mf.createMoney(14, "CHF");
    }

    /**
     * simpleAdd
     */
    @Test
    public void simpleAdd() throws UnexistingCurrencyException {
        Money expected = mf.createMoney(26, "EUR");
        Money result = MoneyOps.simpleAdd(f12EUR, f14EUR);
        assertEquals(expected, result);
    }

    @Test
    public void simpleAddWithSameValueAndSameCurrency() throws UnexistingCurrencyException {
        Money expected = mf.createMoney(24, "EUR");
        Money result = MoneyOps.simpleAdd(f12EUR, f12EUR);
        assertEquals(expected, result);
    }

    @Test(expected = IncompatibleCurrencyException.class)
    public void simpleAddWithSameValueAndDifferentCurrencies() throws IncompatibleCurrencyException, UnexistingCurrencyException {
        MoneyOps.simpleAdd(f14EUR, f14CHF);
    }

    @Test(expected = IncompatibleCurrencyException.class)
    public void simpleAddWithDifferentValueAndDifferentCurrencies() throws IncompatibleCurrencyException, UnexistingCurrencyException {
        MoneyOps.simpleAdd(f12EUR, f14CHF);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(f12EUR, new Integer(4));
    }

}
