
import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

    @Override
    public int compare(Node node1, Node node2) {
        if(node1.getPath() < node2.getPath()) {
            return -1;
        }
        if(node1.getPath() > node2.getPath()) {
            return 1;
        } else {
            return 0;
        }
    }
}
