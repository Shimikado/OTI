package fr.ulille1.fil.odeva;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class MoneyMock {

    @Test
    public void simpleAdd_Mock() throws IncompatibleCurrencyException, UnexistingCurrencyException {
        Money m12EURm = mock(Money.class);
        doReturn(12).when(m12EURm).getValue();
        doReturn("EUR").when(m12EURm).getCurrency();

        Money m14EURm = mock(Money.class);
        doReturn(14).when(m14EURm).getValue();
        doReturn("EUR").when(m14EURm).getCurrency();

        Money result = MoneyOps.simpleAdd(m12EURm, m14EURm);
        assertEquals(result.getValue(), 26);
    }


    @Test
    public void simpleAddWithSameValueAndSameCurrency() throws UnexistingCurrencyException {
        Money expected = mock(Money.class);
        doReturn(24).when(expected).getValue();
        doReturn("EUR").when(expected).getCurrency();

        Money m12EURm = mock(Money.class);
        doReturn(12).when(m12EURm).getValue();
        doReturn("EUR").when(m12EURm).getCurrency();

        Money result = MoneyOps.simpleAdd(m12EURm, m12EURm);
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
