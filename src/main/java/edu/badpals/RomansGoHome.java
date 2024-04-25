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
                .map(RomanNumber::new)
                .forEach(n -> System.out.println(n + " = " + n.toDecimal()));
        System.out.print("\n");
        Stream.of("MMMDCCCLXXXVIII", // 3888
                        "MMDCCLXXVII",  // 2777
                        "CDXLIV", // 444
                        "CDXXXIX"// 439
                )
                .map(RomanNumber::new)
                .forEach(n -> System.out.println(n.toString() + " = " + n.toDecimal()));
        System.out.print("\n");
        List<RomanNumber> numerosASumar = Stream.of("MMMDCCCLXXXVIII","MMDCCLXXVII","CDXLIV","CDXXXIX").map(RomanNumber::new).toList();
        for (RomanNumber romanNumber : numerosASumar){
            Stream.of(3888, // MMMDCCCLXXXVIII
                        2777,  // MMDCCLXXVII
                        444, //CDXLIV
                        439// CDXXXIX
                )
                .map(RomanNumber::new)
                .forEach(n -> System.out.println(n.toString()  + " + " + romanNumber.toString() + " = " + n.suma(romanNumber) + "\n"
                                             +   n.toDecimal() + " + " + romanNumber.toDecimal() + " = " + n.suma(romanNumber).toDecimal()));
        }
    }
}
