package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NavigationStackTest {

    private NavigationStack navigationStack;

    @Before
    public void setUp() throws Exception {
        navigationStack = new NavigationStack();
    }

    @Test
    public void testNavigationStackCanRedoWhenIsEmpty() {
        assertFalse(navigationStack.can_redo());
    }

    @Test
    public void testNavigationStackCanUndoWhenIsEmpty() {
        assertFalse(navigationStack.can_undo());
    }

    @Test
    public void testNavigationStackCanRedoAndCanUndoWhenIsNotEmpty() {
        navigationStack.add("item");
        assertFalse(navigationStack.can_redo());
        assertTrue(navigationStack.can_undo());
    }

    @Test
    public void testNavigationStackCanUndoWhenIsNotEmpty() {
        navigationStack.add("item");
        navigationStack.undo();
        assertFalse(navigationStack.can_undo());
        assertTrue(navigationStack.can_redo());
    }

    @Test
    public void testNavigationStackCanRedoWhenIsNotEmpty() {
        navigationStack.add("item");
        navigationStack.undo();
        navigationStack.redo();
        assertTrue(navigationStack.can_undo());
        assertFalse(navigationStack.can_redo());
    }

    @Test
    public void testNavigationStackCanUndoAndCanRedoAreNotEmpty() {
        navigationStack.add("item");
        navigationStack.add("item1");
        navigationStack.undo();
        assertTrue(navigationStack.can_undo());
        assertTrue(navigationStack.can_redo());
    }
}
