package utilities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils
{
	private JsonUtils()
	{

	}

	public static <T> List<T> convertJsonListDataModel(String fileData, String section)
	{
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, List<T>> jsonData = objectMapper.readValue(fileData, new TypeReference<Map<String, List<T>>>()
			{
			});
			return jsonData.containsKey(section) ? jsonData.get(section) : Collections.emptyList();
		} catch (Exception e)
		{
			throw new RuntimeException("Failed to parse JSON list data model", e);
		}
	}

	public static <T> T convertJsonDataModel(String fileData, Class<T> clazz)
	{
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(fileData, clazz);
		} catch (Exception e)
		{
			throw new RuntimeException("Failed to parse JSON data model", e);
		}
	}
}
