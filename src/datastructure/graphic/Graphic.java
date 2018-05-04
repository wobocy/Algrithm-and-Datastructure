import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graphic {
    private int currentNode = 0, nodeCount = 0, visitedCount = 0;
    private ArrayList<LinkedList<Node>> graphic;
    private int[][] store;
    private int[] visitStatus;
    private PriorityQueue<Node> unvisitedNodes;
    private Node delNode;

    public Graphic() { }

    /**
     * get the optimal path to every node from the source node
     * @param graphic represents the whole graphic
     * @param srcNode the source node, default is zero
     */
    public void getOptimalPath(ArrayList<LinkedList<Node>> graphic, int srcNode) {
        this.currentNode = srcNode;
        this.graphic = graphic;
        init();
        while(visitedCount < nodeCount) {
            System.out.println("访问结点：" + currentNode);
            visitStatus[currentNode] = 1;
            int[][] apArray = getApNodes();
            updateStore(apArray);
            currentNode = getNextNode();
        }
        printResult();
    }
    public void getOptimalPath(ArrayList<LinkedList<Node>> graphic) {
        getOptimalPath(graphic, 0);
    }

    private void init() {
        int max = 65525;
        nodeCount = graphic.size();
        store = new int[2][nodeCount];
        visitStatus = new int[nodeCount];
        for (int i = 1; i < nodeCount; i++) {
            store[0][0] = 0;
            store[0][i] = max;
            store[1][i] = -1;
            visitStatus[i] = -1;
        }
        unvisitedNodes = new PriorityQueue<Node>(new NodeComparator());
        delNode = new Node();
    }

    private int[][] getApNodes() {
        LinkedList<Node> list = graphic.get(currentNode);
        int[][] apArray = null;
        if(list != null) {
            apArray = new int[2][list.size()];
            for(int i = 0; i < list.size(); i++) {
                int index = list.get(i).getIndex();
                if (visitStatus[index] == -1) {
                    apArray[0][i] = index;
                    apArray[1][i] = list.get(i).getWeight();
                }
            }
        }
        return apArray;
    }

    private void updateStore(int[][] apArray) {
        for(int i = 0; apArray != null && i < apArray[0].length; i++) {
            int index = apArray[0][i];
            int weight = apArray[1][i];
            int path = weight + store[0][currentNode];
            if (path < store[0][index]) {
                unvisitedNodes.remove(delNode.setIndex(index).setPath(store[0][index])); // remove old one
                store[0][index] = path;
                store[1][index] = currentNode;
            }
            unvisitedNodes.add(new Node().setIndex(index).setPath(path)); // add new one
        }
        visitedCount ++;
    }

    private int getNextNode() {
        Node node = unvisitedNodes.poll();
        if (node != null) {
            return node.getIndex();
        } else {
            return -1;
        }
    }

    private void printResult() {
        System.out.print("path:");
        for (int i = 0; i < store[0].length; i++) {
            System.out.print(store[0][i] + " ");
        }
    }
}
