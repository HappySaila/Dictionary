import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//
import java.util.ArrayList;
import java.util.List;

/**
 * Class for reading a text file into a list or array.
 * 
 * @author Stephan Jamieson
 * @version 20/3/2016
 */
public class DataReader {

    private final List<String> data;

    /**
     * Create a DataReader that reads from the given file.
     */
    public DataReader(final File file) throws FileNotFoundException, IOException {
        final BufferedReader reader=new BufferedReader(new java.io.FileReader(file));
        data=new ArrayList<String>();
        String line = reader.readLine();
        while (line!=null) {
            data.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Return the content of the file in a list.
     * </br>
     */
    public List<String> asList() { return data; }
    
    /**
     * Return the content of the file in an array.
     */
    public String[] asArray() { return data.toArray(new String[0]);}

}
