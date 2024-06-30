package DataHandlingRepo;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

	// Read file and scan then convert it into JSOn file

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{// json to String 
		String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") +"//src//test//java//DataHandlingRepo//Data.json"),StandardCharsets.UTF_8);
		// // string to Hashmap using jackson data bind 
		
		ObjectMapper Mapper = new ObjectMapper();
		List<HashMap<String,String>> data = Mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){
			});
		return data ;
		
			
	}
}
