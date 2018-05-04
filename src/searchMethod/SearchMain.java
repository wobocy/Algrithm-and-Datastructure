package searchMethod;

public class SearchMain {
    public static void main(String[] args) {
        int key = 11; // need searched
        int[] data = {1,2,4,7,9,10,11,14}; // data
        int low = 0, high = data.length - 1;
        int index = getIndexGoldSearch(low, high);
        while(data[index] != key) {
            if(key > data[index]) {
                low = index + 1;
                index = getIndexGoldSearch(low, high);
            } else {
                high = index - 1;
                index = getIndexGoldSearch(low, high);
            }
        }
        System.out.println("the index is:" + index);
    }

    /**
     * Binary searchMethod method
     * @param low
     * @param high
     * @return
     */
    private static int getIndexBinarySearch(int low, int high) {
        return (low + high)/2;
    }

    /**
     * Inter searchMethod method
     * @param low
     * @param high
     * @param key
     * @param data
     * @return
     */
    private static int getIndexInterSearch(int low, int high, int key, int[] data) {
        return low + (key - data[low])/(data[high] - data[low]) * (high - low);
    }

    /**
     * gold searchMethod method
     * @param low
     * @param high
     * @return
     */
    private static int getIndexGoldSearch(int low, int high) {
        int[] gold = {1, 1, 2, 3, 5, 8, 13, 21, 34};
        int n = high - low + 1;
        int index = -1;
        for (int i = 0; i < gold.length; i ++) {
            if (gold[i] > n) {
                index = low + gold[i - 1] - 1;
                break;
            }
        }
        return index;
    }
}
