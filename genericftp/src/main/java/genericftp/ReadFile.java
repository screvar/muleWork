package genericftp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class ReadFile {
	
	
	
	
	
	
	
	
	
	
	public List<List<String>> readFileFromClasspath() throws IOException {
		String line = "";  
		String splitBy = ",";  
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Devoteam\\AnypointStudio\\studio-workspace\\genericftp\\src\\main\\resources\\server.csv"));  
		List<List<String>> records = new ArrayList();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] server = line.split(splitBy);    // use comma as separator  
		records.add(Arrays.asList(server));
		}
		br.close();
		return records;  
	
	}
	
	
	
	
	
	
	
	
	/*
	
	public ArrayList <String> readFileFromClasspath() throws IOException {
	     URL fileUrl = getClass().getResource("/server.csv");
	     File file =  new File(fileUrl.getFile()); 
	   //Read File Content
		ArrayList <String> content =  (ArrayList<String>) Files.readAllLines(file.toPath());
	      return content;  
	      
	         
	} 
	
	
	public  List<ReadFile> readBooksFromCSV() {
        List<ReadFile> books = new ArrayList<>();
        Path pathToFile = Paths.get("server.csv");

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                ReadFile book = createBook(attributes);

                // adding book into ArrayList
                books.add(book);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        

        return books;
    }
	
	public static ReadFile createBook(String[] metadata) {
		
		String id = metadata[0];
		String transferType = metadata[1];
         String workingDir = metadata[2];
    	 String workingDirList = metadata[3];
    	 String hostS  = metadata[4];
    	 String portS = metadata[5];
    	 String userS = metadata[6];
    	 String passwordS = metadata[7];
    	 String hostT =metadata[8];
    	 String portT = metadata[9];
    	 String userT = metadata[10];
    	 String passwordT = metadata[11];
    	 String workingDirT = metadata[12];

        // create and return book of this metadata
        return new ReadFile(id, transferType,workingDir, workingDirList,hostS, portS, userS, passwordS, hostT, portT, userT,passwordT,workingDirT);
    }

	
	

	
	 // get file from classpath, resources folder
    public File getFileFromResources() {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("/server.csv");
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    } 

    public String readFileFromClasspath() throws IOException {
    	ClassLoader classLoader = getClass().getClassLoader();
    	URL resource = classLoader.getResource("server.csv");
    	File file = new File(resource.getFile());
    	FileReader reader = new FileReader(file);
    	
    	BufferedReader br = new BufferedReader(reader);
    	List<String> line = br.readLine();
    	while (line != null) 
    	{
           line = br.readLine();
        }
    	br.close();
    	return line;
           
        
	
    
    
    
    
}	**/
}
	

	


