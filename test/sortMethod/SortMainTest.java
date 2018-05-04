package sortMethod;

import org.junit.Test;

import java.util.Arrays;

public class SortMainTest {

    @Test
    public void bubbleSort() {
        SortMain sortMain = new SortMain();
        Integer[] data = {3,4,10,45,12,11,5,2,66,101,1,127,14};
        Integer[] result = sortMain.quickSort(data);
        System.out.println(Arrays.toString(result));
    }
}