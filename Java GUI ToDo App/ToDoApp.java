import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private ArrayList<Task> tasks;
    private JPanel taskPanel;
    private JTextField taskInput;

    public ToDoApp() {
        tasks = new ArrayList<>();
        setTitle("📝 Modern ToDo App - Java Swing");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245));

        // Header
        JLabel header = new JLabel("My Tasks ✅", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 24));
        header.setOpaque(true);
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);
        header.setBorder(new EmptyBorder(15, 10, 15, 10));
        add(header, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(245, 245, 245));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        taskInput = new JTextField();
        taskInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton addButton = new JButton("Add ➕");
        styleButton(addButton, new Color(46, 204, 113));

        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Task panel
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // Action listener for Add
        addButton.addActionListener(e -> addTask());

        setVisible(true);
    }

    private void addTask() {
        String description = taskInput.getText().trim();
        if (!description.isEmpty()) {
            Task newTask = new Task(description);
            tasks.add(newTask);

            JPanel taskItem = new JPanel(new BorderLayout());
            taskItem.setBackground(Color.WHITE);
            taskItem.setBorder(new EmptyBorder(5, 10, 5, 10));

            JCheckBox checkBox = new JCheckBox(description);
            checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            checkBox.setBackground(Color.WHITE);
            checkBox.addItemListener(e -> newTask.setCompleted(checkBox.isSelected()));

            JButton deleteButton = new JButton("🗑️");
            styleButton(deleteButton, new Color(231, 76, 60));
            deleteButton.setPreferredSize(new Dimension(50, 30));
            deleteButton.addActionListener(e -> {
                tasks.remove(newTask);
                taskPanel.remove(taskItem);
                taskPanel.revalidate();
                taskPanel.repaint();
            });

            taskItem.add(checkBox, BorderLayout.CENTER);
            taskItem.add(deleteButton, BorderLayout.EAST);

            taskPanel.add(taskItem);
            taskPanel.revalidate();
            taskPanel.repaint();

            taskInput.setText("");
        }
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setFocusPainted(false);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
