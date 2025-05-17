package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils
{
	private JsonUtils()
	{

	}

	public static <T> List<T> convertJsonListDataModel(String fileData, String section, Class<T> clazz)
	{
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();

			// Read the file into a tree
			JsonNode rootNode = objectMapper.readTree(fileData);
			JsonNode targetNode = rootNode.get(section);

			if (targetNode == null || !targetNode.isArray())
			{
				return Collections.emptyList();
			}

			// Deserialize into list of target class
			List<T> resultList = new ArrayList<>();
			for (JsonNode node : targetNode)
			{
				T obj = objectMapper.treeToValue(node, clazz);
				resultList.add(obj);
			}

			return resultList;
		} catch (Exception e)
		{
			throw new RuntimeException("Failed to parse JSON list data model", e);
		}
	}

//	public static <T> List<T> convertJsonListDataModel(String fileData, String section)
//	{
//		try
//		{
//			ObjectMapper objectMapper = new ObjectMapper();
//			Map<String, List<T>> jsonData = objectMapper.readValue(fileData, new TypeReference<Map<String, List<T>>>()
//			{
//			});
//			return jsonData.containsKey(section) ? jsonData.get(section) : Collections.emptyList();
//		} catch (Exception e)
//		{
//			throw new RuntimeException("Failed to parse JSON list data model", e);
//		}
//	}
//
//	public static <T> T convertJsonDataModel(String fileData, Class<T> clazz)
//	{
//		try
//		{
//			ObjectMapper objectMapper = new ObjectMapper();
//			return objectMapper.readValue(fileData, clazz);
//		} catch (Exception e)
//		{
//			throw new RuntimeException("Failed to parse JSON data model", e);
//		}
//	}

}
