package fr.ulille1.fil.odeva;

import java.util.Objects;

public class Money {
    private int value;
    private String currency;


    Money(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String toString() {
        return this.getValue() + " (" + this.getCurrency() + ")";
    }

    @Override
    public boolean equals(Object o) {
        // Ajouté à la Version 1
        if (this == o) return true;
        // Ajouté à la Version 2
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        // Value Ajoutée à la Version 3 puis currency à la version 4
        return value == money.value &&
                Objects.equals(currency, money.currency);
    }
}
