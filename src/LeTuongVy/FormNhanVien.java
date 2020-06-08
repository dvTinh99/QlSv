package LeTuongVy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormNhanVien extends JFrame {

	private JPanel contentPane;
	public JTextField txtMa;
	public JTextField txtName;
	public JTextField txtAge;
	public JTextField txtEmail;
	public JTextField txtLuong;
	public int position ;
	public static FormNhanVien frame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new FormNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormNhanVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
		lblNewLabel.setBounds(28, 65, 131, 14);
		contentPane.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setBounds(188, 62, 151, 20);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_1.setBounds(28, 103, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(188, 100, 151, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tuổi Nhân Viên");
		lblNewLabel_2.setBounds(28, 141, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		txtAge = new JTextField();
		txtAge.setBounds(188, 138, 151, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email Nhân Viên");
		lblNewLabel_3.setBounds(28, 180, 131, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(188, 177, 151, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Lương Nhân Viên");
		lblNewLabel_4.setBounds(28, 223, 121, 14);
		contentPane.add(lblNewLabel_4);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(188, 220, 151, 20);
		contentPane.add(txtLuong);
		txtLuong.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NhanVien nhanVien = new NhanVien(
							txtMa.getText(),
							txtName.getText(),
							Integer.parseInt(txtAge.getText()),
							txtEmail.getText(),
							txtLuong.getText());
					QuanLi quanLi = new QuanLi();
					quanLi.UpdateNhanVien(nhanVien);
					quanLi.reload();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(125, 293, 159, 50);
		contentPane.add(btnNewButton);
	}
	public boolean Validate(JTextField ma, JTextField name, JTextField age, JTextField email, JTextField luong) {
		if (ma.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "nhap ma nhan vien = int");
			return false;
		}else {
			try {
				Integer.parseInt(ma.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "nhap ma nhan vien = int");
				return false;
			}
		}
		if(name.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "them thong tin name");
			return false;
		}
		if(age.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "them day du thong tin");
			return false;
		}else {
			try {
				Integer.parseInt(age.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "nhap tuoi = int");
				return false;
			}
			
		}
		if(email.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "them thong tin email");
			return false ;
		}else {
			String emailNV = email.getText() ;
			char [] mail = emailNV.toCharArray();
			for (int i =0; i< mail.length;i++) {
				if (mail[i] == '@') {
					break;
				}else if(i== mail.length-1) {
					JOptionPane.showMessageDialog(frame, "email khong hop le");
					return false;
				}else {
					continue ;
				}
				
			}
		}
		if(luong.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "them thong tin luong");
			return false;
		}else {
			try {
				Integer.parseInt(luong.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "nhap luong = int");
				return false;
			}
		}
		return true ;
		
	}
}
