package com.bham.pij.assignments.converters;

public class DecToBin extends Converters {
	
	public DecToBin(String input) {
		
		if (isValid(input)) {
			this.input = input;
		}
	}

	@Override
	public String convert() {
		
		return super.decimalToBinary(input);
	}

	@Override
	public boolean isValid(String input) throws InvalidFormatException {
		
		if (Integer.valueOf(input) > 255) {
			throw new InvalidFormatException();
		}
		
		return true;
	}

}
