package edu.badpals;

public enum RomanSymbols {
	
	I(1), V(5), X(10), L(50), C(100), D(500), M(1000),
	IV(4), IX(9), XL(40), XC(90), CD(400), CM(900);
	
	private final int valorDecimal;

	RomanSymbols(int valorDecimal) {
		this.valorDecimal = valorDecimal;
	}
	
	public int getDecimalValue(){
		return this.valorDecimal;
	}

}
