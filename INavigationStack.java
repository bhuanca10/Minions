package stack;

public interface INavigationStack extends IAction {
    boolean can_undo();
    boolean can_redo();
    void undo();
    void redo();
}
