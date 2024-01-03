package org.scars.StudentInfoSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDialog extends JDialog {
    private boolean isOk = false;
    private JTextField idField;
    private JTextField nameField;
    private JTextField clazzField;

    public StudentDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initUI();
    }

    public StudentDialog(JFrame parent, String title, boolean modal, String id, String name, String clazz) {
        super(parent, title, modal);
        initUI();
        idField.setText(id);
        nameField.setText(name);
        clazzField.setText(clazz);
    }

    private void initUI() {
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("学号："));
        idField = new JTextField(10);
        inputPanel.add(idField);
        inputPanel.add(new JLabel("姓名："));
        nameField = new JTextField(10);
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("班级："));
        clazzField = new JTextField(10);
        inputPanel.add(clazzField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton okButton = new JButton("确定");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOk = true;
                dispose();
            }
        });
        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOk = false;
                dispose();
            }
        });
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public boolean isOk() {
        return isOk;
    }

    public String getId() {
        return idField.getText();
    }

    public String getName() {
        return nameField.getText();
    }

    public String getClazz() {
        return clazzField.getText();
    }
}
