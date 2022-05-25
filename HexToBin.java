package com.bham.pij.assignments.converters;

public class HexToBin extends Converters {
	
	private String hexVals = ("0123456789ABCDEF");
	
	public HexToBin(String input) {
		
		if (isValid(input)) {
			this.input = input;
		}
	}
	
	@Override
	public String convert() {
		
		String[] splitInput = input.split("");
		boolean multiplied = false;
		int decimalValue = 0;
		int temp = 0;
		
		for (int i = 0; i < splitInput.length; i++) {
			
			
			for (int j = 0; j < hexValues.length; j++) {
				if (splitInput[i].equals(hexValues[j])) {
					temp = j;
				}
				
			}
			
			if (!multiplied) {
				decimalValue += (16 * temp);
				multiplied = true;
			}
			
			else {
				decimalValue += temp;
			}
		}
		
		return super.decimalToBinary(String.valueOf(decimalValue));
	}

	@Override
	public boolean isValid(String input) throws InvalidFormatException {
		
		String[] hex = input.split("");
		
		if (!(hex.length == 2)) {
			throw new InvalidFormatException();
		}
		
		for (int i = 0; i < hex.length; i++) {
			
			if(!(hexVals.contains(hex[i]))) {
				throw new InvalidFormatException();
				
			}
		}
		
		return true;
	}
}
