public class BinToDec extends Converters {

	public BinToDec (String input) {

		if (isValid(input)) {

			this.input = input;
		}
	}

	@Override
	public String convert() {

		return super.binaryToDecimal(input);
	}

	@Override
	public boolean isValid(String input) throws InvalidFormatException {

		return super.isValidBinary(input);
	}
}
