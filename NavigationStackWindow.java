package stack.gui;

import stack.NavigationStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationStackWindow extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton addButton;
    private JButton redoButton;
    private JButton undoButton;
    private JList printStack;
    private JTextField textField;
    private JScrollPane displayStack;
    private NavigationStack navigationStack;
    private JLabel inputLabel;
    private JLabel stackLabel;


    public NavigationStackWindow() {
        super("Navigation Stack");
        navigationStack = new NavigationStack();
        this.panel = new JPanel();
        panel.setBackground(new Color(45, 104, 106));
        panel.setLayout(null);

        inputLabel= new JLabel("Enter a string:");
        inputLabel.setBounds(60,400,220,30);
        inputLabel.setLocation(5,5);
        inputLabel.setForeground(new Color(255, 255, 255));
        panel.add(inputLabel);

        stackLabel= new JLabel(">> Stack:");
        stackLabel.setBounds(60,400,220,30);
        stackLabel.setLocation(235,5);
        stackLabel.setForeground(new Color(255, 255, 255));
        panel.add(stackLabel);

        addButton = new JButton();
        addButton.setText("ADD");
        addButton.addActionListener(this);
        addButton.setBounds(60, 400, 220, 30);
        addButton.setLocation(5,65);
        panel.add(addButton);

        redoButton = new JButton();
        redoButton.setText("REDO");
        redoButton.addActionListener(this);
        redoButton.setBounds(60, 400, 220, 30);
        redoButton.setLocation(5,125);
        panel.add(redoButton);

        undoButton = new JButton();
        undoButton.setText("UNDO");
        undoButton.addActionListener(this);
        undoButton.setBounds(60, 400, 220, 30);
        undoButton.setLocation(5,95);
        panel.add(undoButton);

        textField = new JTextField();
        textField.setBounds(5,35,220,30);
        textField.requestFocus();
        panel.add(textField);

        printStack = new JList();
        printStack.setLayoutOrientation(JList.VERTICAL_WRAP);
        printStack.setVisibleRowCount(-1);
        panel.add(printStack);

        displayStack = new JScrollPane();
        displayStack.setBounds(235, 35,220,120);
        displayStack.setPreferredSize(new Dimension(250, 80));
        displayStack.setBackground(new Color(208,207,207));
        panel.add(displayStack);

        setSize(500, 300);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String data = textField.getText();
            navigationStack.add(data);
            textField.setText("");

        }else if(e.getSource() == undoButton){
            navigationStack.undo();
        }else if(e.getSource() == redoButton){
            navigationStack.redo();
        }
        printStack = new JList(navigationStack.getRedoStack().print());
        displayStack.setViewportView(printStack);
    }

    public static void main(String args[]) {
        NavigationStackWindow window = new NavigationStackWindow();
        window.setVisible(true);
    }
}
