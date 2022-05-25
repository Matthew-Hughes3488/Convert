package com.bham.pij.assignments.converters;

public abstract class Converters {
	
	// used in classes BIN2HEX and HEX2BIN
	protected static final String[] hexValues = {"0","1","2","3","4","5","6","7","8"
			,"9","A","B","C","D","E","F"};
	
	protected String input;

	public abstract String convert();
	public abstract boolean isValid(String input) throws InvalidFormatException;

	// used in classes BIN2DEC and BIN2HEX
	public String binaryToDecimal(String input) {

		String[] binaryNumber = input.split("");
		int decimalValue = 0;
		int count = 0;

		for (int i = binaryNumber.length - 1; i >= 0; i--) {

			if (binaryNumber[i].equals("1")) {
				decimalValue += Math.pow(2, count);
			}

			count++;
		}
		
		return Integer.toString(decimalValue);
	}

	// used in classes BIN2DEC and BIN2HEX
	public  boolean isValidBinary(String input) throws InvalidFormatException {
		String[] binaryNumber = input.split("");

		if (!(binaryNumber.length == 8)) {
			throw new InvalidFormatException();
		}

		for (int i = 0; i < binaryNumber.length; i++) {

			if (!(binaryNumber[i].equals("1") || binaryNumber[i].equals("0"))) {
				throw new InvalidFormatException();
			}
		}

		return true;
	}
	
	// used in classes DEC2BIN and HEX2BIN
	public String decimalToBinary (String input) {

		int inputInteger = Integer.valueOf(input);
		String binaryNumber = "";

		while (inputInteger > 0) {

			binaryNumber += String.valueOf(inputInteger % 2);
			inputInteger = inputInteger / 2;
		}

		while (binaryNumber.length() != 8) {

			binaryNumber += "0";
		}

		String[] splitBinaryNumber = binaryNumber.split("");
		String reversedBinaryNumber = "";

		for (int i = splitBinaryNumber.length - 1; i >= 0; i--) {

			reversedBinaryNumber += splitBinaryNumber[i];
		}

		return reversedBinaryNumber;
	}

}
