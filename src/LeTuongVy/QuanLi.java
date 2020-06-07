package LeTuongVy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bean.NhanVien;

public class QuanLi {

	private JFrame frame;
	private JTextField textMa;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textEmail;
	private JTextField textLuong;
	private ArrayList<NhanVien> arrNhanVien = new ArrayList<>(); 
	private static String header[]= new String [] {"Ma Nhan Vien","Ten","Tuoi","Email","Luong"};
	static DefaultTableModel dtm = new DefaultTableModel(header,0); 
	private JTable table;

	/**
	 * Launch the application.
	 */	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLi window = new QuanLi();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUAN LY NHAN VIEN");
		lblNewLabel.setBounds(174, 11, 135, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ma Nhan Vien");
		lblNewLabel_1.setBounds(10, 55, 128, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textMa = new JTextField();
		textMa.setBounds(131, 60, 156, 20);
		frame.getContentPane().add(textMa);
		textMa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ho Ten");
		lblNewLabel_2.setBounds(10, 96, 83, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tuoi");
		lblNewLabel_3.setBounds(10, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(10, 166, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textName = new JTextField();
		textName.setBounds(131, 91, 156, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(131, 127, 156, 20);
		frame.getContentPane().add(textAge);
		textAge.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(131, 163, 156, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Luong");
		lblNewLabel_5.setBounds(10, 195, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textLuong = new JTextField();
		textLuong.setBounds(131, 194, 156, 20);
		frame.getContentPane().add(textLuong);
		textLuong.setColumns(10);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(433, 39, 89, 23);
		frame.getContentPane().add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//handle();
					String maNhanVien = textMa.getText();
					String name = textName.getText() ;
					int age =Integer.parseInt(textAge.getText());
					String email = textEmail.getText();
					String luong = textLuong.getText();
					NhanVien nhanVien = new NhanVien(maNhanVien, name, age, email, luong);
					arrNhanVien.add(nhanVien);
					reload();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "them day du thong tin");
				}
				
			}
		});
		
		
		btnSave.setBounds(433, 73, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int select = table.getSelectedRow();
					arrNhanVien.remove(select);
					reload();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnDelete.setBounds(433, 107, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFind.setBounds(433, 132, 89, 23);
		frame.getContentPane().add(btnFind);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(433, 166, 89, 23);
		frame.getContentPane().add(btnOpen);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(433, 204, 89, 23);
		frame.getContentPane().add(btnExit);
		
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(10, 237, 531, 164);
		frame.getContentPane().add(table);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 238, 531, 163);
//		scrollPane.setViewportView(table);
//		
	//	frame.getContentPane().add(scrollPane);
	
	}
	private void clear() {
		textMa.setText("");
		textEmail.setText("");
		textAge.setText("");
		textName.setText("");
		textLuong.setText("");
	}
	private void reload() {
		dtm.setRowCount(0);
		for (NhanVien nhanVien : arrNhanVien) {
			Object[] objs = {nhanVien.getMaNhanVien(),
					nhanVien.getName(),
					nhanVien.getAge(),
					nhanVien.getEmail(),
					nhanVien.getLuong()};
			dtm.addRow(objs);
		}
		clear();
	}
}
