/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.duan1.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BA KHANG
 */
public class quanlynhanvien extends JFrame {

    private JTable table;
    private JTextField txtTim, txtMaNV, txtTenNV, txtTaiKhoan, txtMatKhau, txtSDT;
    private JButton btnTimKiem, btnThem, btnXoa, btnSua, btnNhapLai;
    private JRadioButton rdoNhanVien, rdoQuanLy;
    private ButtonGroup chucVuGroup;

    public quanlynhanvien() {
        setTitle("Quản lý nhân viên");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font fontTitle = new Font("Segoe UI", Font.BOLD, 26);
        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 14);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontBtn = new Font("Segoe UI", Font.PLAIN, 13);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(245, 250, 255));

        // ===== Title =====
        JLabel lblTitle = new JLabel("Quản lý nhân viên", SwingConstants.CENTER);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(new Color(20, 50, 90));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // ===== Center Panel =====
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        centerPanel.setOpaque(false);

        // === Left Panel (Table + Search) ===
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setOpaque(false);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);
        JLabel lblSearch = new JLabel("Tìm nhân viên:");
        lblSearch.setFont(fontLabel);
        txtTim = new JTextField(20);
        txtTim.setFont(fontInput);
        btnTimKiem = new JButton("Tìm");
        btnTimKiem.setFont(fontBtn);
        searchPanel.add(lblSearch);
        searchPanel.add(txtTim);
        searchPanel.add(btnTimKiem);

        leftPanel.add(searchPanel, BorderLayout.NORTH);

        String[] columnNames = {"Mã NV", "Tên NV", "Tài khoản", "Mật khẩu", "Chức vụ", "SĐT"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(fontInput);
        table.getTableHeader().setFont(fontLabel);
        table.setGridColor(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(table);

        leftPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel pagingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pagingPanel.setOpaque(false);
        String[] pagingBtns = {"<<", "<", ">", ">>"};
        for (String label : pagingBtns) {
            JButton btn = new JButton(label);
            btn.setPreferredSize(new Dimension(50, 28));
            btn.setFont(fontBtn);
            pagingPanel.add(btn);
        }
        leftPanel.add(pagingPanel, BorderLayout.SOUTH);

        centerPanel.add(leftPanel);

        // === Right Panel (Form) ===
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Mã NV
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Mã nhân viên:"), gbc);
        txtMaNV = new JTextField(20); txtMaNV.setFont(fontInput);
        gbc.gridx = 1; rightPanel.add(txtMaNV, gbc);

        // Tên NV
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Tên nhân viên:"), gbc);
        txtTenNV = new JTextField(20); txtTenNV.setFont(fontInput);
        gbc.gridx = 1; rightPanel.add(txtTenNV, gbc);

        // Tài khoản
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Tài khoản:"), gbc);
        txtTaiKhoan = new JTextField(20); txtTaiKhoan.setFont(fontInput);
        gbc.gridx = 1; rightPanel.add(txtTaiKhoan, gbc);

        // Mật khẩu
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Mật khẩu:"), gbc);
        txtMatKhau = new JTextField(20); txtMatKhau.setFont(fontInput);
        gbc.gridx = 1; rightPanel.add(txtMatKhau, gbc);

        // Chức vụ
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Chức vụ:"), gbc);
        JPanel chucVuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chucVuPanel.setOpaque(false);
        rdoNhanVien = new JRadioButton("Nhân viên");
        rdoQuanLy = new JRadioButton("Quản lý");
        chucVuGroup = new ButtonGroup();
        chucVuGroup.add(rdoNhanVien);
        chucVuGroup.add(rdoQuanLy);
        rdoNhanVien.setSelected(true);
        for (JRadioButton rdo : new JRadioButton[]{rdoNhanVien, rdoQuanLy}) {
            rdo.setOpaque(false);
            rdo.setFont(fontInput);
            chucVuPanel.add(rdo);
        }
        gbc.gridx = 1; rightPanel.add(chucVuPanel, gbc);

        // SĐT
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        rightPanel.add(new JLabel("Số điện thoại:"), gbc);
        txtSDT = new JTextField(20); txtSDT.setFont(fontInput);
        gbc.gridx = 1; rightPanel.add(txtSDT, gbc);

        // Nút chức năng
        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnPanel.setOpaque(false);
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnSua = new JButton("Sửa");
        btnNhapLai = new JButton("Nhập lại");
        for (JButton btn : new JButton[]{btnThem, btnXoa, btnSua, btnNhapLai}) {
            btn.setFont(fontBtn);
            btn.setPreferredSize(new Dimension(100, 32));
            btnPanel.add(btn);
        }
        rightPanel.add(btnPanel, gbc);

        centerPanel.add(rightPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);

        setVisible(true);
    }
        
        
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlynhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
