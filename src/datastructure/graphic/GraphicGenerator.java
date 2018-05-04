import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * this clas read txt file and generate an adjacency list as a graphic
 */
public class GraphicGenerator {
    public static ArrayList<LinkedList<Node>> getGraphicFromTxt(String path) {
        File file = new File(path);
        ArrayList<LinkedList<Node>> arrayList = null;
        try {
            FileReader inputStream = new FileReader(file);
            BufferedReader reader = new BufferedReader(inputStream);
            String line = reader.readLine();
            if(line != null) { arrayList = new ArrayList<LinkedList<Node>>(); }
            while(line != null ) {
                LinkedList<Node> linkedList = null;
                String[] splitedLine = line.split(" ");
                int length = splitedLine.length;
                if (length > 1) {
                    linkedList = new LinkedList<Node>();
                    for(int i = 0; i < (length-1)/2; i++  ) {
                        Node node = new Node(Integer.valueOf(splitedLine[2*i+1]),Integer.valueOf(splitedLine[2*i+2]));
                        linkedList.add(node);
                    }
                }
                arrayList.add(linkedList);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}