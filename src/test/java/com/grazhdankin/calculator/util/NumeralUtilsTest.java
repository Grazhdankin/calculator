package com.grazhdankin.calculator.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class NumeralUtilsTest {

    @Test
    public void given1999Arabic_WhenConvertingToRoman_ThenReturnMCMXCIX() {
        int arabic1999 = 1999;

        String result = NumeralUtils.convertArabicToRoman(arabic1999);

        assertThat(result).isEqualTo("MCMXCIX");
    }

    @Test
    public void given2018Roman_WhenConvertingToArabic_ThenReturn2018() {
        String roman2018 = "MMXVIII";

        int result = NumeralUtils.convertRomanToArabic(roman2018);

        assertThat(result).isEqualTo(2018);
    }

    @Test
    public void givenArabicString_IsPositiveArabic() {
        String arabic = "12345";

        boolean result = NumeralUtils.isPositiveArabic(arabic);

        assertThat(result).isTrue();
    }

    @Test
    public void givenRomanString_IsNotPositiveArabic() {
        String roman = "IV";

        boolean result = NumeralUtils.isPositiveArabic(roman);

        assertThat(result).isFalse();
    }

    @Test
    public void givenStringWithNegativeArabic_IsNotPositiveArabic() {
        String negativeArabic = "-12345";

        boolean result = NumeralUtils.isPositiveArabic(negativeArabic);

        assertThat(result).isFalse();
    }

    @Test
    public void givenRomanString_IsRoman() {
        String roman = "MMMCMXCIX";

        boolean result = NumeralUtils.isRoman(roman);

        assertThat(result).isTrue();
    }

    @Test
    public void givenArabicString_IsNotRoman() {
        String arabic = "12345";

        boolean result = NumeralUtils.isRoman(arabic);

        assertThat(result).isFalse();
    }
}
