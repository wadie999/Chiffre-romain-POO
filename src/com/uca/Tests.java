package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

    // ***********************************************************Tests de réussite*************************************
    @Test
    public void testKnownRomanToDecimalSuccess() {
        // Test de conversion des chiffres romains connus en valeurs décimales
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
        assertThat(RomanConverter.getNumberFromRoman("IX"), equalTo(9));
        assertThat(RomanConverter.getNumberFromRoman("X"), equalTo(10));
        assertThat(RomanConverter.getNumberFromRoman("MCMXCIX"), equalTo(1999));
        assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));
    }

    @Test
    public void testKnownDecimalToRomanSuccess() {
        // test de conversion des valeurs décimales connues en chiffres romains
        assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(9), equalTo("IX"));
        assertThat(RomanConverter.getRomanFromNumber(10), equalTo("X"));
        assertThat(RomanConverter.getRomanFromNumber(1999), equalTo("MCMXCIX"));
        assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
    }

    @Test
    public void testNegativeValueFailure() {
        // Test de l'échec de la conversion pour les valeurs négatives
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-1)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("-I")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testOutOfRangeValueFailure() {
        // Test de l'échec de la conversion pour les valeurs en dehors de la plage valide
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testExcessiveSymbolRepetitionFailure() {
        // test de l'échec de la conversion pour les chiffres romains avec une répétition excessive de symboles
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("MMMM")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testIncorrectPairRepetitionFailure() {
        // Test de l'échec de la conversion pour les chiffres romains avec une répétition incorrecte de paires
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XXC")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testIncorrectPrecedenceFailure() {
        // Test de l'échec de la conversion pour les chiffres romains avec une prépondérance incorrecte
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IC")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IM")), instanceOf(IllegalArgumentException.class));
    }


	@Test
    public void testDoubleValue() {
        RomanNumber number = new RomanNumber("XX");
        assertThat(number.doubleValue(), equalTo(20.0));

        number = new RomanNumber("IV");
        assertThat(number.doubleValue(), equalTo(4.0));
    }

    @Test
    public void testFloatValue() {
        RomanNumber number = new RomanNumber("XVIII");
        assertThat(number.floatValue(), equalTo(18.0f));

        number = new RomanNumber("IX");
        assertThat(number.floatValue(), equalTo(9.0f));
    }

   @Test
    public void testLongValue() {
        RomanNumber number = new RomanNumber("CCC");
        assertThat(number.longValue(), equalTo(300L));

        number = new RomanNumber("XCI");
        assertThat(number.longValue(), equalTo(91L));
    }
    // *************************************Tests d'echec : j'ai fait expret de voir ces test failed ******************
    @Test
    public void testNegativeValueFailure2() {
        // Échoue pour les valeurs négatives
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(-4));
    }

    @Test
    public void testOutOfRangeValueFailure2() {
        // Échoue pour des valeurs hors de l'intervalle [1;3999]
        assertThat(RomanConverter.getRomanFromNumber(4000), equalTo("MMMM"));
    }

    @Test
    public void testExcessiveSymbolRepetitionFailure2() {
        // Échoue pour des valeurs avec trop de répétitions de symboles
        assertThat(RomanConverter.getNumberFromRoman("IIII"), equalTo(4));
    }

    @Test
    public void testIncorrectPairRepetitionFailure2() {
        // Échoue pour des valeurs avec des répétitions de paires
        assertThat(RomanConverter.getNumberFromRoman("XXC"), equalTo(90));
    }

    @Test
    public void testIncorrectPrecedenceFailure2() {
        // Échoue pour des valeurs avec des antécédents incorrects
        assertThat(RomanConverter.getNumberFromRoman("IC"), equalTo(99));
    }


    @Test
    public void testCompareTo() {
        RomanNumber number1 = new RomanNumber("XII");
        RomanNumber number2 = new RomanNumber("VIII");
        assertThat(number1.compareTo(number2), greaterThan(0));

        RomanNumber number3 = new RomanNumber("IV");
        assertThat(number1.compareTo(number3), equalTo(0));

        RomanNumber number4 = new RomanNumber("XX");
        assertThat(number1.compareTo(number4), lessThan(0));
}



// **************************************** tests de validite ******************************
    @Test
    public void testValidity() {
        // Test de conversion de la valeur decimale vers Romain avec sa valeur originale
        for (int i = 1; i <= 3999; i++) {
            assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)), equalTo(i));
        }
    }
   
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
