package stack;

public class NavigationStack implements INavigationStack {
    private Stack redoStack;

    private Stack undoStack;

    public NavigationStack() {
        redoStack = new Stack();
        undoStack = new Stack();
    }

    public Stack getRedoStack() {
        return redoStack;
    }

    @Override
    public boolean can_undo() {
        return !redoStack.isEmpty();
    }

    @Override
    public boolean can_redo() {
        return !undoStack.isEmpty();
    }

    @Override
    public void undo() {
        if (can_undo()) {
            String item = redoStack.pop();
            undoStack.add(item);
        }
    }

    @Override
    public void redo() {
        if (can_redo()){
            String item = undoStack.pop();
            redoStack.add(item);
        }
    }

    public void add(String item) {
        redoStack.add(item);
    }
}
