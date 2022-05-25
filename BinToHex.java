package com.bham.pij.assignments.converters;

public class BinToHex extends Converters{
	
	
	
	public BinToHex(String input) {
		
		if (isValid(input)) {
			
			this.input = input;
		}
	}

	@Override
	public String convert() {
		
		String hexValue = "";
		int decimalValue = Integer.valueOf(super.binaryToDecimal(input));
		
		hexValue += hexValues[decimalValue / 16];
		hexValue += hexValues[decimalValue % 16];
		
		return hexValue;
		
	}

	@Override
	public boolean isValid(String input) throws InvalidFormatException {
		
		return super.isValidBinary(input);
	}
}
