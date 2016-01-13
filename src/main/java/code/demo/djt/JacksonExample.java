package code.demo.djt;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;

/**
 * Created by djt on 1/7/16.
 */
public class JacksonExample {
    @Test
    public void string_to_jsonobject() {
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode node = objectMapper.readValue(carJson, JsonNode.class);
            System.out.println(node.get("brand").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void generate_json_string() throws IOException {
        JsonFactory factory = new JsonFactory();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JsonGenerator generator = factory.createGenerator(outputStream, JsonEncoding.UTF8);

        generator.writeStartObject();
        generator.writeStringField("brand", "Mercedes");
        generator.writeNumberField("doors", 5);
        generator.writeEndObject();

        generator.close();
        System.out.println(outputStream.toString());
    }

    @Test
    public void string_to_bean() {
        String carJson =
                "{ \"name\" : \"djt\", \"vaild\" : false,\"age\":17,\"scores\":[43,76,87,94]}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Bean bean = objectMapper.readValue(carJson, Bean.class);
            System.out.println("name = " + bean.name);
            System.out.println("age = " + bean.age);
            System.out.println("valid = " + bean.vaild);
            System.out.println("scores' length = " + bean.scores.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bean_to_string() throws JsonProcessingException {

        Bean bean = new Bean();
        bean.name = "djt";
        bean.age = 4;
        bean.vaild = false;
        bean.scores = new int[3];
        bean.scores[0] = 1;
        bean.scores[1] = 2;

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(bean);
        System.out.println(json);
    }

    @Test
    public void parse_string() throws IOException {
        String beanJson =
                "{ \"name\" : \"djt\", \"vaild\" : false,\"age\":17,\"scores\":[43,76,87,94]}";

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(beanJson);

        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();
//            System.out.println(jsonToken);
            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                parser.nextToken();
                String fieldName = parser.getCurrentName();
                System.out.print("fieldName = " + fieldName);
                System.out.println(",value = " + parser.getValueAsString());
            }
        }
    }

}
