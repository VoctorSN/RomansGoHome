package edu.badpals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NumeroRomanoTest {

    public RomanNumber numeroRomano;

    /**
     * Grupos sumatorios M, C, X, I
     */

    @ParameterizedTest
    @CsvSource({
            "1000,  M",
            "2000,  MM",
            "3000,  MMM"
    })
    @Tag("sumatorio")
    public void grupo_M_test(Short decimal, String roman) {

        //String testCase = "M";
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.toDecimal());

        /**
         * El caso MMMM es control de errores 
         * y no puede estar en el test de la logica
         * Asumimos que la entrada es correcta.
         * Sino, hay que programar la gestion de errores
         */
    }

    @Test
    @Tag("sumatorio")
    public void tres_repeticiones_C_test() {

        String testCase = "MMMCCC";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(3300, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sumatorio")
    public void tres_repeticiones_X_test() {

        String testCase = "MMMXXX";
        numeroRomano = new RomanNumber(testCase);

        assertEquals(3030, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sumatorio")
    public void tres_repeticiones_I_test() {

        String testCase = "MMMIII";
        numeroRomano = new RomanNumber(testCase);

        assertEquals(3003, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sumatorio")
    public void una_D_test() {

        String testCase = "MMMDIII";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(3503, numeroRomano.toDecimal());

        testCase = "MMMCDIII";
        numeroRomano = new RomanNumber(testCase);
        assertNotEquals(3503, numeroRomano.toDecimal());
    }

    /**
     * Grupos sustractivos
     * IV(4), IX(9),
     * XL(40), XC(90),
     * CD(400), CM(900)
     */

    @Test
    @Tag("sustractivo")
    public void grupo_C_DM_test() {

        String testCase = "CD";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(400, numeroRomano.toDecimal());

        testCase = "CM";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(900, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sustractivo")
    public void grupo_X_LC_test() {

        String testCase = "XL";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(40, numeroRomano.toDecimal());

        testCase = "XC";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(90, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sustractivo")
    public void grupo_I_VX_test() {

        String testCase = "IV";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(4, numeroRomano.toDecimal());

        testCase = "IX";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(9, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sustractivo")
    public void grupos_sumatorios_tres_digitos_test() {
        String testCase = "MMMDCCCLXXXVIII"; // 3888
        numeroRomano = new RomanNumber(testCase);
        assertEquals(3888, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sustractivo")
    public void grupos_sumatorios_test() {
        String testCase = "MMDCCLXXVII"; // 2777
        numeroRomano = new RomanNumber(testCase);
        assertEquals(2777, numeroRomano.toDecimal());
    }

    @Test
    @Tag("sustractivo")
    public void grupos_substractivos_test() {
        String testCase = "CDXLIV"; // 444
        numeroRomano = new RomanNumber(testCase);
        assertEquals(444, numeroRomano.toDecimal());

        testCase = "CDXXXIX"; // 439
        numeroRomano = new RomanNumber(testCase);
        assertEquals(439, numeroRomano.toDecimal());
    }


    /**
     * Test del tipo enumerado
     * RomanSymbols
     */
    @ParameterizedTest
    @Tag("enumerado")
    @CsvSource({
            "5,   V",
            "4,   IV",
            "900, CM"
    })
    public void valor_decimal_test(Short decimal, String roman) {
        RomanSymbols romanSymbol = RomanSymbols.valueOf(roman);
        assertEquals(decimal, (short) romanSymbol.getDecimalValue());
    }
}