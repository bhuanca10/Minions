package stack;

import java.util.Arrays;

public class Stack {
    private static final int STACK_LIMIT = 100;
    private String[] array = new String[STACK_LIMIT];
    private int top = -1;

    public boolean isEmpty() {
        return top < 0;
    }

    public void add(String dato) {array[++top] = dato;}

    public String pop() {
        return array[top--];
    }

    public String[] print() {
        return isEmpty() ? new String[0] : Arrays.copyOf(array, top + 1);
    }
}
