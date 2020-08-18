/*
        Written & Developed by KAJAL Kiran
*/
package core.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertyReaders {
    private static HashMap<String, String> propertyMap = new PropertyReaders().getProperties();

    private PropertyReaders()
    {
        propertyMap = getPropValues();
    }

    public static synchronized HashMap<String, String> getProperties()
    {
        return propertyMap;
    }

    /**
     * get all the properties value present in config.properties
     * @return hash map consisting all properties in key.value pair
     */
    private HashMap<String, String> getPropValues()
    {
        HashMap<String, String> result = new HashMap<String, String>();

        try
        {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            InputStream inputStream= getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
            {
                prop.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

            // get the property values
            Set propNames = prop.stringPropertyNames();
            Iterator<String> iterator = propNames.iterator();
            while (iterator.hasNext())
            {
                String key = iterator.next();
                result.put(key , prop.getProperty(key));
            }

            inputStream.close();

            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
