package org.scars.StudentInfoSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentInfoSystem extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student04?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    private static final String TABLE_NAME = "student";
    private JPanel buttonPanel;  // 将buttonPanel变量提升为类级别
    private JScrollPane scrollPane;  // 将scrollPane变量提升为类级别

    private DefaultTableModel tableModel;
    private JTable studentTable;

    public StudentInfoSystem() {
        initUI();
        initData();
    }

    private void initUI() {
        setTitle("学生信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // 创建表格模型和表格组件
        tableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"学号", "姓名", "班级"});
        studentTable = new JTable(tableModel);
        scrollPane = new JScrollPane(studentTable);

        // 创建按钮面板和按钮组件
        buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("新增学生");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        JButton updateButton = new JButton("修改学生");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        JButton deleteButton = new JButton("删除学生");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        JButton classInfoButton = new JButton("查看班级");
        classInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClassInfoOfStudent();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(classInfoButton);

        // 将表格和按钮面板添加到容器中
        Container contentPane = getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("学生信息操作");
        JMenuItem menuItem1 = new JMenuItem("查看学生");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 移除班级表格和相关的按钮
                Container contentPane = getContentPane();
                contentPane.removeAll();

                // 重新创建学生表格和相关的按钮
                tableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"学号", "姓名", "班级"});
                studentTable = new JTable(tableModel);
                scrollPane = new JScrollPane(studentTable);
                contentPane.add(scrollPane, BorderLayout.CENTER);
                contentPane.add(buttonPanel, BorderLayout.NORTH);

                // 刷新界面
                contentPane.revalidate();
                contentPane.repaint();

                // 刷新学生表格
                tableModel.setRowCount(0);
                initData();
            }
        });
        menu1.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("新增学生");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        menu1.add(menuItem2);
        menuBar.add(menu1);

        JMenu menu2 = new JMenu("班级信息操作");
        JMenuItem menuItem3 = new JMenuItem("查看班级信息");
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClassInfo();
            }
        });
        menu2.add(menuItem3);


        // 创建班级表格模型和表格组件
        DefaultTableModel classTableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"班级ID", "班级名称"});
        JTable classTable = new JTable(classTableModel);

        JMenuItem menuItem4 = new JMenuItem("修改班级信息");
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 移除学生表格和相关的按钮
                contentPane.remove(scrollPane);
                contentPane.remove(buttonPanel);

                // 添加班级表格
                JScrollPane classScrollPane = new JScrollPane(classTable);
                contentPane.add(classScrollPane, BorderLayout.CENTER);

                // 刷新界面
                contentPane.revalidate();
                contentPane.repaint();

                int rowIndex = studentTable.getSelectedRow();
                if (rowIndex < 0) {
                    JOptionPane.showMessageDialog(null, "请先选择学生");
                    return;
                }

                String classId = (String) tableModel.getValueAt(rowIndex, 2);
                String newClassName = JOptionPane.showInputDialog("请输入新的班级名称");

                if (newClassName != null && !newClassName.trim().isEmpty()) {
                    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                        PreparedStatement statement = connection.prepareStatement("UPDATE class SET class_name = ? WHERE class_id = ?");
                        statement.setString(1, newClassName);
                        statement.setString(2, classId);
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "班级信息更新成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "班级信息更新失败");
                        }
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "数据库操作失败：" + sqlException.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "班级名称不能为空");
                }
            }
        });
        menu2.add(menuItem4);

        menuBar.add(menu2);

        setJMenuBar(menuBar);
    }

    private void showClassInfoOfStudent() {
        int rowIndex = studentTable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "请先选择学生");
            return;
        }

        String classId = (String) tableModel.getValueAt(rowIndex, 2);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT class_name FROM class WHERE  class_id = ?");
            statement.setString(1, classId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String className = resultSet.getString("class_name");
                JOptionPane.showMessageDialog(this, "班级信息：" + className);
            } else {
                JOptionPane.showMessageDialog(this, "没有找到班级信息");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "班级信息查询失败：" + e.getMessage());
        }

    }

    private void showClassInfo() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM class");
            ResultSet resultSet = statement.executeQuery();

            // 移除滚动面板和相关的按钮
            Container contentPane = getContentPane();
            contentPane.remove(scrollPane);  // 修改这里，移除滚动面板
            contentPane.remove(buttonPanel);

            // 创建班级表格模型和表格组件
            DefaultTableModel classTableModel = new DefaultTableModel(new Object[][]{}, new Object[]{"班级ID", "班级名称"});
            JTable classTable = new JTable(classTableModel);
            JScrollPane classScrollPane = new JScrollPane(classTable);
            contentPane.add(classScrollPane, BorderLayout.CENTER);

            // 刷新界面
            contentPane.revalidate();
            contentPane.repaint();

            // 添加班级信息到表格
            while (resultSet.next()) {
                String classId = resultSet.getString("class_id");
                String className = resultSet.getString("class_name");
                classTableModel.addRow(new Object[]{classId, className});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, class FROM " + TABLE_NAME);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String clazz = rs.getString("class");
                tableModel.addRow(new Object[]{id, name, clazz});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        StudentDialog dialog = new StudentDialog(this, "新增学生", true);
        dialog.setVisible(true);

        if (dialog.isOk()) {
            String id = dialog.getId();
            String name = dialog.getName();
            String clazz = dialog.getClazz();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME + " (id, name, class) VALUES (?, ?, ?)");
                stmt.setString(1, id);
                stmt.setString(2, name);
                stmt.setString(3, clazz);
                stmt.executeUpdate();
                tableModel.addRow(new Object[]{id, name, clazz});
                JOptionPane.showMessageDialog(this, "新增记录成功");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "新增记录失败：" + e.getMessage());
            }
        }
    }

    private void updateStudent() {
        int rowIndex = studentTable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "请先选择要修改的记录");
            return;
        }
        String id = (String) tableModel.getValueAt(rowIndex, 0);
        String name = (String) tableModel.getValueAt(rowIndex, 1);
        String clazz = (String) tableModel.getValueAt(rowIndex, 2);

        StudentDialog dialog = new StudentDialog(this, "修改学生记录", true, id, name, clazz);
        dialog.setVisible(true);

        if (dialog.isOk()) {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE " + TABLE_NAME + " SET name = ?, class = ? WHERE id = ?");
                stmt.setString(1, dialog.getName());
                stmt.setString(2, dialog.getClazz());
                stmt.setString(3, id);
                stmt.executeUpdate();
                tableModel.setValueAt(dialog.getName(), rowIndex, 1);
                tableModel.setValueAt(dialog.getClazz(), rowIndex, 2);
                JOptionPane.showMessageDialog(this, "修改记录成功");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "修改记录失败：" + e.getMessage());
            }
        }
    }

    private void deleteStudent() {
        int rowIndex = studentTable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的记录");
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "确定要删除选中的记录吗？", "删除学生记录", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            String id = (String) tableModel.getValueAt(rowIndex, 0);
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?");
                stmt.setString(1, id);
                stmt.executeUpdate();
                tableModel.removeRow(rowIndex);
                JOptionPane.showMessageDialog(this, "删除记录成功");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "删除记录失败：" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentInfoSystem frame = new StudentInfoSystem();
                frame.setVisible(true);
            }
        });
    }
}
