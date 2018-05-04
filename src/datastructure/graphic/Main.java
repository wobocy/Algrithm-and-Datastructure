import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<LinkedList<Node>> graphicData = GraphicGenerator.getGraphicFromTxt("./graphic.txt");
        Graphic graphic = new Graphic();
        graphic.getOptimalPath(graphicData);
    }
}
