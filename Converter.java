import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Converter {
	
	private ConvertMode cm;
	private ArrayList<String> inputValues = new ArrayList<String>();
	private ArrayList<String> outputValues = new ArrayList<String>();

	
	public static enum ConvertMode {BIN2HEX, HEX2BIN, BIN2DEC, DEC2BIN};
	
	public Converter(Converter.ConvertMode cm) {
		
		this.cm = cm;
	}
	
	public String convert(String value) throws InvalidFormatException {
		
		switch(cm) {
			case BIN2HEX:
				BinToHex bh = new BinToHex(value);
				return bh.convert();
			
			case HEX2BIN:
				HexToBin hb = new HexToBin(value);
				return hb.convert();
			
			case BIN2DEC:
				BinToDec bd = new BinToDec(value);
				return bd.convert();
				
			case DEC2BIN:
				DecToBin db = new DecToBin(value);
				return db.convert();
			}
		
		return null;
	}
	
	public void fromFile(String fileName) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		String line = reader.readLine();
		
		while (line != null) {
			
			inputValues.add(line);
			line = reader.readLine();
		}
		
		reader.close();
		
		for (int i = 0; i < inputValues.size(); i++) {
			
			outputValues.add(convert(inputValues.get(i)));
		}
	}
	
	public ArrayList<String> getInputValues() {
		
		return inputValues;
		
	}
	
	public ArrayList<String> getOutputValues(){
		
		return outputValues;
		
	}
	
	
	
}
