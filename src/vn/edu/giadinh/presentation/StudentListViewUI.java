package vn.edu.giadinh.presentation;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import vn.edu.giadinh.business.Student;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;

public class StudentListViewUI extends JFrame {
    private JTextField txtSearch;
    private JButton btnAdd;
    private JTable table;
    private DefaultTableModel model;
    private SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public StudentListViewUI() {
        super("Danh sách sinh viên");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);
        setLocationRelativeTo(null);

        // Panel top
        JPanel top = new JPanel(new BorderLayout(5,5));
        txtSearch = new JTextField();
        btnAdd = new JButton("Thêm");
        top.add(txtSearch, BorderLayout.CENTER);
        top.add(btnAdd, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // Table
        String[] cols = {"STT","ID","Họ & tên","Ngày sinh","Chuyên ngành","Điểm TB","Xếp loại"};
        model = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

       

       
    }

    public void showList(List<Student> students) {
        model.setRowCount(0);
        int stt = 1;
        for (Student s : students) {
            Object[] row = {
                stt++,
                s.getId(),
                s.getName(),
                fmt.format(s.getBirthDate()),
                s.getMajor(),
                String.format("%.2f", s.calculateGPA()),
                s.classifyAcademic()
            };
            model.addRow(row);
        }
    }

   
}