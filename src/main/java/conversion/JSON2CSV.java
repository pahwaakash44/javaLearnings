package conversion;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class JSON2CSV
{
    public static void main(String[] args) throws IOException
    {
        generateCSVFfromJson();
    }
    
    private static void generateCSVFfromJson() throws IOException
    {
        String[] names = {"akamath", "apahwa", "mgd", "pohegde", "ashankar"};
        for (String name : names)
        {
            System.out.printf("Procssing file for user: %s", name);
            System.out.println("");
            File jsonFile = getFile(name, ".json");
            if (jsonFile.exists())
            {
                JsonNode jsonTree = new ObjectMapper().readTree(getFile(name, ".json"));
    
                List<String> allowedColumnNames = Arrays.asList("key", "assignee", "component", "message", "type", "severity", "creationDate");
                CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
                JsonNode convertToCSVObject = jsonTree.get("issues");
                JsonNode firstObject = convertToCSVObject.elements().next();
                firstObject.fieldNames().forEachRemaining(fieldName -> {
                    if(allowedColumnNames.contains(fieldName))
                        csvSchemaBuilder.addColumn(fieldName);
                });
                for(JsonNode node : convertToCSVObject)
                {
                    for(Iterator<Map.Entry<String,JsonNode>> it = node.fields(); it.hasNext(); )
                    {
                        Map.Entry<String,JsonNode> entry = it.next();
                        if(!allowedColumnNames.contains(entry.getKey()))
                            it.remove();
                    }
                }
                CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
    
                CsvMapper csvMapper = new CsvMapper();
                csvMapper.writerFor(JsonNode.class)
                        .with(csvSchema)
                        .writeValue(getFile(name, ".csv"), convertToCSVObject);
            }
            else
                System.out.printf("file doesn't exists: %s.%s%n", name, "json");
        }
    }
    
    private static File getFile(String name, String extension)
    {
        return new File("src/main/resources/" + name + extension);
    }
}