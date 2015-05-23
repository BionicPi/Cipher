package Cipher;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class CipherGUI {

	private JFrame frmCipher;
	private JTextArea input;
	private JTextArea outputField;
	private JScrollPane scrollPane;
	private JButton btnDecode;
	private JScrollPane scrollPane_1;
	private Component rigidArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CipherGUI window = new CipherGUI();
					window.frmCipher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CipherGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCipher = new JFrame();
		frmCipher.getContentPane().setFont(new Font("Serpentine Std", Font.PLAIN, 13));
		frmCipher.setFont(new Font("Serpentine Std", Font.PLAIN, 12));
		frmCipher.setTitle("Cipher");
		frmCipher.setBounds(100, 100, 620, 260);
		frmCipher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 170, 50, 170, 0};
		gridBagLayout.rowHeights = new int[] {40, 30, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		frmCipher.getContentPane().setLayout(gridBagLayout);
		
		JButton encode = new JButton("Encode");
		encode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outputField.setText(Cipher.uiEncode(input.getText()));
			}
		});
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		frmCipher.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		input = new JTextArea();
		scrollPane_1.setViewportView(input);
		input.setFont(UIManager.getFont("TextArea.font"));
		input.setColumns(10);
		

		GridBagConstraints gbc_btnEncode = new GridBagConstraints();
		gbc_btnEncode.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncode.gridx = 1;
		gbc_btnEncode.gridy = 1;
		frmCipher.getContentPane().add(encode, gbc_btnEncode);
		
		btnDecode = new JButton("Decode");
		btnDecode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outputField.setText(Cipher.uiDecode(input.getText()));
			}
		});
		
		rigidArea = Box.createRigidArea(new Dimension(50, 30));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 1;
		frmCipher.getContentPane().add(rigidArea, gbc_rigidArea);
		GridBagConstraints gbc_btnExponents = new GridBagConstraints();
		gbc_btnExponents.insets = new Insets(0, 0, 5, 5);
		gbc_btnExponents.gridx = 3;
		gbc_btnExponents.gridy = 1;
		frmCipher.getContentPane().add(btnDecode, gbc_btnExponents);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		frmCipher.getContentPane().add(scrollPane, gbc_scrollPane);
		
		outputField = new JTextArea();
		outputField.setFont(UIManager.getFont("TextField.font"));
		scrollPane.setViewportView(outputField);
		outputField.setLineWrap(true);
		outputField.setColumns(10);
		
	}

}
