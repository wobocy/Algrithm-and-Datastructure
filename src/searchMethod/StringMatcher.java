package searchMethod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class used to searchMethod string, the method is kmp.
 */

public class StringMatcher {
    private char[] data;

    public StringMatcher(char[] data) {
        this.data = data;
    }
    public StringMatcher() {

    }

    public void setData(char[] data) {
        this.data = data;
    }

    public char[] getData() {
        return this.data;
    }

    /**
     * match searchMethod
     */
    public void match(char[] key) {
        ArrayList<Integer> patialList = getAllPartialValues(key);
        int startPos = 0, count = 0, step = 0, keyLength = key.length, dataLength = data.length;
        while( startPos + keyLength < dataLength && count != keyLength) {
            count = 0;
            for(int i = 0; i < keyLength; i ++) {
                if (key[i] == data[startPos + i] ) {
                    count ++;
                } else {
                    break;
                }
            }
            step = patialList.get(count);
            startPos += count - step;
        }
        if(count == keyLength) {
            System.out.println("searchMethod success. the position starts form:" + (startPos - (count - step)));
        }else {
            System.out.println("no math.");
        }
    }

    /**
     * get all parital values of the data sequece from zero to n
     * @param data char sequences
     * @return array list of integer
     */
    public ArrayList<Integer> getAllPartialValues(char[] data) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0, -1);
        StringMatcher matcher = new StringMatcher();
        for(int i = 0; i < data.length; i ++) {
            int value = matcher.getPartialValue(Arrays.copyOfRange(data, 0,i + 1));
            list.add(i + 1, value);
        }
        return list;
    }

    /**
     * get the patial value of a char sequences
     * @param data char sequences
     * @return a patial value
     */
    private int getPartialValue(char[] data) {
        int length = data.length;
        int patialValue = -1;
        if (length == 1) {
            return patialValue;
        } else {
            for(int i = 0; i < length - 1; i ++) {
                char[] pre = Arrays.copyOfRange(data, 0, i + 1);
                char[] append = Arrays.copyOfRange(data, length - 1 - i, length);
                if (Arrays.equals(pre, append)) {
                    patialValue = i + 1;
                }
            }
            return patialValue;
        }
    }
}
