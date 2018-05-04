package searchMethod;

import org.junit.Test;
import searchMethod.StringMatcher;

public class StringMatcherTest {

    @Test
    public void getPartialValue() {
        char[] key = {'A','B', 'C', 'D', 'A','B'};
        char[] data = {'B','B', 'C', ' ', 'A','B', 'C','D','A', 'B', ' ', 'A','B', 'C','D','A', 'B', 'C', 'D','A', 'B', 'D', 'E'};
        StringMatcher matcher = new StringMatcher(data);
        matcher.match(key);
    }
}