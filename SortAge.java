package assignment1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;



public class SortAge
{

	public static void main(String[] args) throws IOException   
	{
		Properties prop= new Properties();
		InputStream inStream= new FileInputStream("case.properties");                                     //created properties file
		prop.load(inStream);
		BufferedReader reader=new BufferedReader(new FileReader(prop.getProperty("file")));               //file is key ie path given in properties file
		
		Map<String, List<String>> map = new TreeMap<String, List<String>>();
		
		String line = reader.readLine();
		while ((line = reader.readLine()) != null)
		{

			String key = getField(line);
			List<String> l = map.get(key);

			if (l == null) 
			{
				l = new LinkedList<String>();
				map.put(key, l);
			}
			l.add(line);
		}
		reader.close();
		

		FileWriter writer1 = new FileWriter(prop.getProperty("file1"));
		for (List<String> list : map.values())
		{
			for (String val : list) 
			{
				writer1.write(val);
				writer1.write("\n");
			}
		}
		writer1.close();
		System.out.println("done sorting");
	}

	private static String getField(String line) 
	{
		return line.split(",")[3];

	}

}



