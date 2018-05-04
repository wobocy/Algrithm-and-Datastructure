package sortMethod;

import java.util.*;

public class SortMain {

    /**
     * the bubble sortMethod method
     * @param data
     * @return
     */
    public int[] bubbleSort(int[] data) {
        int length = data.length;
        int count = 0, round = 0;
        while (count != length - 1) {
            count = 0;
            for(int i = 0; i < length - 1; i ++) {
                if(data[i] > data[i + 1]) {
                    int mid = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = mid;
                } else {
                    count ++;
                }
            }
            round ++;
            System.out.println("round:" + round);
            System.out.println(Arrays.toString(data));
        }
        return data;
    }

    /**
     * the selection sortMethod method
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        int startPos = 0, round = 0;
        while (startPos < data.length - 1) {
            int min = data[startPos], indexMin = startPos;
            for(int i = startPos + 1; i < data.length; i ++) {
                if (min > data[i]) {
                    min = data[i];
                    indexMin = i;
                }
            }
            data[indexMin] = data[startPos];
            data[startPos] = min;
            startPos ++;
            round ++;
            System.out.println("round:" + round);
            System.out.println(Arrays.toString(data));
        }
        return data;
    }

    /**
     * the insersion sortMethod method
     * @param data
     */
    public void insersionSort(int[] data) {
        ArrayList<Integer> list = new ArrayList();
        if (data[0] < data[1]) { list.add(data[0]); list.add(data[1]);}
        else { list.add(data[1]); list.add(data[0]);}
        int startPos = 1, round = 0;
        while(startPos < data.length - 1) {
            System.out.println("round:" + round);
            System.out.println(Arrays.toString(list.toArray()));
            startPos ++;
            round ++;
            int insertData = data[startPos];
            if(insertData <= list.get(0)) {
                list.add(0, insertData);
                continue;
            }
            if(insertData >= list.get(list.size() - 1)) {
                list.add(insertData);
                continue;
            } else {
                for(int i = 1; i < list.size(); i ++) {
                    if(insertData <= list.get(i) && insertData >= list.get(i - 1)) {
                        list.add(i, insertData);
                        break;
                    }
                }
            }
        }
    }

    /**
     * the heap sortMethod method
     * @param data
     */
    public void heapSort(int[] data) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i =0; i < data.length; i ++) {
            heap.add(data[i]);
        }
        while(heap.size() > 0) {
           System.out.println(heap.poll());
        }
    }

    /**
     * the merge sortMethod method
     * @param data
     * @return
     */

    public int[] mergeSort(int[] data) {
        if(data.length == 1) {
            return data;
        } else {
            int length = data.length;
            int indexMid = length / 2 - 1;
            int[] leftData = Arrays.copyOfRange(data, 0, indexMid + 1);
            int[] rightData = Arrays.copyOfRange(data, indexMid + 1, length);
            leftData = mergeSort(leftData);
            rightData = mergeSort(rightData);
            int j = 0;
            for(int i =0; i < length; i ++) {
                if(i < leftData.length) {
                    data[i] = leftData[i];
                } else {
                    data[i] = rightData[j];
                    j ++;
                }
            }
            return selectionSort(data);
        }
    }


    public Integer[] quickSort(Integer[] data) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(data.length == 1 || data.length == 0) {
            return data;
        } else {
            int ref = data[0], index = 0; list.add(ref);
            for(int i =1; i < data.length; i ++) {
                if(data[i] <= ref) {
                    list.add(0, data[i]);
                    index ++;
                } else {
                    list.add(data[i]);
                }
            }
            // get sub list
            Integer[] leftData = new Integer[index];
            Integer[] rightData = new Integer[data.length - index - 1];
            list.subList(0, index).toArray(leftData);
            list.subList(index + 1, data.length).toArray(rightData);
            leftData = quickSort(leftData);
            rightData = quickSort(rightData);
            // merge data
            data[index] = ref;
            int j = 0;
            for(int i =0; i < leftData.length; i ++) {
                data[i] = leftData[i];
            }
            int pos = index + 1;
            for(int i = 0; i < rightData.length; i ++) {
                data[pos] = rightData[i];
                pos ++;
            }
            return data;
        }
    }
}