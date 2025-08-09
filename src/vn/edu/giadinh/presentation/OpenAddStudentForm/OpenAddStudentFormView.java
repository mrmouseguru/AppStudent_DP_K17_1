package vn.edu.giadinh.presentation.OpenAddStudentForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vn.edu.giadinh.presentation.Subscriber;

public class OpenAddStudentFormView extends JFrame implements Subscriber {
    
    // Form input fields
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtBirthDate;
    private JComboBox<MajorItem> cboMajor;
    
    // Score input panels and fields
    private JPanel pnlSoftwareScores;
    private JPanel pnlEconomicsScores;
    private JTextField txtJavaScore;
    private JTextField txtHtmlScore;
    private JTextField txtCssScore;
    private JTextField txtMarketingScore;
    private JTextField txtSalesScore;
    
    // Action buttons
    private JButton btnSave;
    private JButton btnCancel;
    
    // Model and dialog references
    private OpenAddStudentFormModel model;
   // private AddStudentResultDialog resultDialog;
    
    public OpenAddStudentFormView() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        loadMajors();
    }
    
    private void initializeComponents() {
        txtId = new JTextField(20);
        txtName = new JTextField(20);
        txtBirthDate = new JTextField(20);
        cboMajor = new JComboBox<MajorItem>();
        
        // Set custom renderer to display only name
        cboMajor.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof MajorItem) {
                    MajorItem major = (MajorItem) value;
                    setText(major.name);
                }
                return this;
            }
        });
        
        // Software scores
        txtJavaScore = new JTextField(10);
        txtHtmlScore = new JTextField(10);
        txtCssScore = new JTextField(10);
        
        // Economics scores
        txtMarketingScore = new JTextField(10);
        txtSalesScore = new JTextField(10);
        
        btnSave = new JButton("Lưu");
        btnCancel = new JButton("Hủy");
        
        pnlSoftwareScores = new JPanel();
        pnlEconomicsScores = new JPanel();
    }
    
    private void setupLayout() {
        setTitle("Thêm Sinh Viên Mới");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Basic information
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Mã SV:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Họ tên:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtName, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Ngày sinh (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtBirthDate, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Ngành:"), gbc);
        gbc.gridx = 1;
        formPanel.add(cboMajor, gbc);
        
        // Software scores panel
        pnlSoftwareScores.setLayout(new GridBagLayout());
        pnlSoftwareScores.setBorder(BorderFactory.createTitledBorder("Điểm môn học (Software)"));
        
        GridBagConstraints gbcSoftware = new GridBagConstraints();
        gbcSoftware.insets = new Insets(5, 5, 5, 5);
        gbcSoftware.anchor = GridBagConstraints.WEST;
        
        gbcSoftware.gridx = 0; gbcSoftware.gridy = 0;
        pnlSoftwareScores.add(new JLabel("Java:"), gbcSoftware);
        gbcSoftware.gridx = 1;
        pnlSoftwareScores.add(txtJavaScore, gbcSoftware);
        
        gbcSoftware.gridx = 0; gbcSoftware.gridy = 1;
        pnlSoftwareScores.add(new JLabel("HTML:"), gbcSoftware);
        gbcSoftware.gridx = 1;
        pnlSoftwareScores.add(txtHtmlScore, gbcSoftware);
        
        gbcSoftware.gridx = 0; gbcSoftware.gridy = 2;
        pnlSoftwareScores.add(new JLabel("CSS:"), gbcSoftware);
        gbcSoftware.gridx = 1;
        pnlSoftwareScores.add(txtCssScore, gbcSoftware);
        
        // Economics scores panel
        pnlEconomicsScores.setLayout(new GridBagLayout());
        pnlEconomicsScores.setBorder(BorderFactory.createTitledBorder("Điểm môn học (Economics)"));
        
        GridBagConstraints gbcEconomics = new GridBagConstraints();
        gbcEconomics.insets = new Insets(5, 5, 5, 5);
        gbcEconomics.anchor = GridBagConstraints.WEST;
        
        gbcEconomics.gridx = 0; gbcEconomics.gridy = 0;
        pnlEconomicsScores.add(new JLabel("Marketing:"), gbcEconomics);
        gbcEconomics.gridx = 1;
        pnlEconomicsScores.add(txtMarketingScore, gbcEconomics);
        
        gbcEconomics.gridx = 0; gbcEconomics.gridy = 1;
        pnlEconomicsScores.add(new JLabel("Sales:"), gbcEconomics);
        gbcEconomics.gridx = 1;
        pnlEconomicsScores.add(txtSalesScore, gbcEconomics);
        
        // Add score panels to form
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(pnlSoftwareScores, gbc);
        
        gbc.gridy = 5;
        formPanel.add(pnlEconomicsScores, gbc);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
        
        // Initially hide score panels
        pnlSoftwareScores.setVisible(false);
        pnlEconomicsScores.setVisible(false);
    }
    
    private void setupEventHandlers() {
        cboMajor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MajorItem selectedMajor = (MajorItem) cboMajor.getSelectedItem();
                if (selectedMajor != null) {
                    if ("1".equals(selectedMajor.id)) {
                        pnlSoftwareScores.setVisible(true);
                        pnlEconomicsScores.setVisible(false);
                    } else if ("2".equals(selectedMajor.id)) {
                        pnlSoftwareScores.setVisible(false);
                        pnlEconomicsScores.setVisible(true);
                    } else {
                        pnlSoftwareScores.setVisible(false);
                        pnlEconomicsScores.setVisible(false);
                    }
                }
                revalidate();
                repaint();
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveStudent();
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void loadMajors() {
        cboMajor.removeAllItems();
        
        if (model != null && model.majorItems != null) {
            for (MajorItem major : model.majorItems) {
                cboMajor.addItem(major);
            }
        }
    }
    
    private void saveStudent() {
        // Basic UI validation
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtBirthDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (cboMajor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngành!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Get selected major
      //  this.resultDialog = new AddStudentResultDialog(this);
        MajorItem selectedMajor = (MajorItem) cboMajor.getSelectedItem();
        
//        ReqStudent reqStudent = new ReqStudent(
//            txtId.getText(),
//            txtName.getText(),
//            txtBirthDate.getText(),
//            selectedMajor.id,
//            txtJavaScore.getText(),
//            txtHtmlScore.getText(),
//            txtCssScore.getText(),
//            txtMarketingScore.getText(),
//            txtSalesScore.getText()
//        );
//
//        boolean success = AddStudentMain.run(new AddStudentFactoryImpl(), reqStudent, resultDialog);
//        
//        if (success) {
//            // Show result dialog instead of JOptionPane
//            if (resultDialog != null) {
//                resultDialog.showResult();
//            } else {
//                JOptionPane.showMessageDialog(this, "Lưu thông tin sinh viên thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
//            }
//            clearForm();
//        } else {
//            // Show result dialog for error too
//            if (resultDialog != null) {
//                resultDialog.showResult();
//            } else {
//                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi lưu thông tin sinh viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }
    
    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtBirthDate.setText("");
        cboMajor.setSelectedIndex(-1);
        txtJavaScore.setText("");
        txtHtmlScore.setText("");
        txtCssScore.setText("");
        txtMarketingScore.setText("");
        txtSalesScore.setText("");
        pnlSoftwareScores.setVisible(false);
        pnlEconomicsScores.setVisible(false);
    }
    
    public void setModel(OpenAddStudentFormModel model) {
        this.model = model;
        model.addSubscriber(this);
    }

    @Override
    public void update() {
        loadMajors();
        this.setVisible(true);
    }
}
