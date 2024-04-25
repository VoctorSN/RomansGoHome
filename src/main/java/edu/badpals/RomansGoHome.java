package edu.badpals;

import java.util.List;
import java.util.stream.Stream;

public class RomansGoHome {

    public static void main(String[] args) {

        Stream.of(3888, // MMMDCCCLXXXVIII
                        2777,  // MMDCCLXXVII
                        444, //CDXLIV
                        439// CDXXXIX
                )
                .map(RomanNumber::toRoman)
                .forEach(n -> System.out.println(n + " = " + new RomanNumber(n).toDecimal()));
        System.out.print("\n");
        Stream.of("MMMDCCCLXXXVIII", // 3888
                        "MMDCCLXXVII",  // 2777
                        "CDXLIV", // 444
                        "CDXXXIX"// 439
                )
                .map(RomanNumber::new)
                .forEach(n -> System.out.println(n.toString() + " = " + n.toDecimal()));
    }
}
