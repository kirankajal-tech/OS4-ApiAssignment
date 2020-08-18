/*
        Written & Developed by KAJAL Kiran
*/

package core.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import core.utils.PropertyReaders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;

public class Constants {
    public static final String contentTypeHeader = "Content-Type:application/json";
    public static final String authorizationHeader = "Authorization:bearer pag4nt1stoken";

    public static String createBody(String file){
        FileReader reader = null;
        String f = System.getProperty("user.dir")+"/src/main/java/activities"+file;
        try {
            reader = new FileReader(f);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode object = objectMapper.readValue(reader,ObjectNode.class);
            return objectMapper.writeValueAsString(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
     public static String readPropData(String value)
    {
        HashMap<String,String> prop = PropertyReaders.getProperties();
      return prop.get(value);
    }
    public static Formatter getFormatter(){
        return new Formatter();
    }
}