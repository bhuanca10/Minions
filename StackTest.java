package stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    public static final String ONE = "one";
    public static final String TWO = "two";
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackAdd() {
        stack.add("Dato");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testStackPop() {
        String expected = "Dato";
        stack.add(expected);
        String actual = stack.pop();
        assertEquals(expected, actual);
        assertTrue(stack.isEmpty());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackPopWhenStackIsEmpty() {
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackPopWhenStackIsFull() {
        for(int i = 0; i <=100 ; i++){
            stack.add("item");
        }
    }

    @Test
    public void testStackPrintWhenIsEmpty() {
        String[] expected = {};
        String[] actual = stack.print();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testStackPrintWhenStackIsNotEmpty() {
        String[] expected = {ONE, TWO};
        stack.add(ONE);
        stack.add(TWO);
        String[] actual = stack.print();
        assertArrayEquals(expected, actual);
    }
}
