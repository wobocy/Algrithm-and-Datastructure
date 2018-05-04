
public class Node {
    private int index = -1;
    private int weight;
    private int path;

    public Node() { }
    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        if(this.path == node.path && this.index == node.index) {
            return true;
        } else {
            return false;
        }
    }

    public int getIndex() {
        return this.index;
    }
    public int getWeight() {
        return this.weight;
    }
    public int getPath() {
        return this.path;
    }

    public Node setIndex(int index) {
        this.index = index;
        return this;
    }
    public Node setWeight(int weight) {
        this.weight = weight;
        return this;
    }
    public Node setPath(int path) {
        this.path = path;
        return this;
    }



}