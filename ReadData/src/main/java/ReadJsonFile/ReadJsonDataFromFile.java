package ReadJsonFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BankData.BankData;

public class ReadJsonDataFromFile {

	
	public static final ObjectMapper objectmapper = new ObjectMapper();
	private static final ObjectMapper Objectmapper = null;

	public static List<BankData> getBankDataFromJson() throws JsonParseException, JsonMappingException, IOException{
		InputStream inputstream=new FileInputStream(new File("/ReadData/src/main/resources/BankData.json"));
		
		TypeReference<List<BankData>> typeReference=new TypeReference<List<BankData>>() {};
		
		return Objectmapper.readValue(inputstream,typeReference);
		
	}	
void getBankDataFromJsonTest() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
	
	System.out.println(Objectmapper.writeValueAsString(getBankDataFromJson()));
}
}
