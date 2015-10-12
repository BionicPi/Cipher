package Cipher;

import java.awt.EventQueue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CipherGUI
{

	private JFrame frmCipher;
	private JTextArea input;
	private JTextArea outputField;
	private JScrollPane scrollPane;
	private JButton btnDecode;
	private JButton btnEncode;
	private JScrollPane scrollPane_1;
	private Component rigidArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CipherGUI window = new CipherGUI();
					window.frmCipher.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CipherGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmCipher = new JFrame();
		frmCipher.getContentPane().setFont(new Font("Serpentine Std", Font.PLAIN, 13));
		frmCipher.setFont(new Font("Serpentine Std", Font.PLAIN, 12));
		frmCipher.setTitle("Cipher");
		frmCipher.setBounds(100, 100, 620, 260);
		frmCipher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 85, 85, 50, 170, 30 };
		gridBagLayout.rowHeights = new int[] { 30, 40, 30, 40 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0 };
		frmCipher.getContentPane().setLayout(gridBagLayout);

		btnEncode = new JButton("Encode");

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		frmCipher.getContentPane().add(scrollPane_1, gbc_scrollPane_1);

		input = new JTextArea();
		scrollPane_1.setViewportView(input);
		input.setFont(UIManager.getFont("TextArea.font"));
		input.setColumns(10);

		GridBagConstraints gbc_btnEncode = new GridBagConstraints();
		gbc_btnEncode.gridwidth = 2;
		gbc_btnEncode.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncode.gridx = 1;
		gbc_btnEncode.gridy = 2;
		frmCipher.getContentPane().add(btnEncode, gbc_btnEncode);

		btnDecode = new JButton("Decode");

		rigidArea = Box.createRigidArea(new Dimension(50, 30));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 3;
		gbc_rigidArea.gridy = 2;
		frmCipher.getContentPane().add(rigidArea, gbc_rigidArea);

		GridBagConstraints gbc_btnDecode = new GridBagConstraints();
		gbc_btnDecode.insets = new Insets(0, 0, 5, 5);
		gbc_btnDecode.gridx = 4;
		gbc_btnDecode.gridy = 2;
		frmCipher.getContentPane().add(btnDecode, gbc_btnDecode);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frmCipher.getContentPane().add(scrollPane, gbc_scrollPane);

		outputField = new JTextArea();
		outputField.setFont(UIManager.getFont("TextField.font"));
		scrollPane.setViewportView(outputField);
		outputField.setLineWrap(true);
		outputField.setColumns(10);

		JLabel lblKey = new JLabel();
		GridBagConstraints gbc_lblKey = new GridBagConstraints();
		gbc_lblKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKey.gridx = 0;
		gbc_lblKey.gridy = 0;
		lblKey.setText("Specify a Key?:");
		frmCipher.getContentPane().add(lblKey, gbc_lblKey);

		JCheckBox specifyKey = new JCheckBox();
		GridBagConstraints gbc_specifyKey = new GridBagConstraints();
		gbc_specifyKey.gridx = 1;
		gbc_specifyKey.gridy = 0;
		frmCipher.getContentPane().add(specifyKey, gbc_specifyKey);

		final JTextField keyName = new JTextField();
		final GridBagConstraints gbc_keyName = new GridBagConstraints();
		gbc_keyName.fill = GridBagConstraints.HORIZONTAL;
		gbc_keyName.gridx = 2;
		gbc_keyName.gridy = 0;
		frmCipher.getContentPane().add(keyName, gbc_keyName);
		keyName.setEnabled(false);

		specifyKey.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{// checkbox has been selected
					keyName.setEnabled(true);
				} else
				{// checkbox has been deselected
					keyName.setEnabled(false);
				}
				;
			}
		});

		btnEncode.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (keyName.isEnabled() && !keyName.getText().equals(""))
					Cipher.defaultInput();
				else
					Cipher.basic = new Cipher(keyName.getText());
				outputField.setText(Cipher.uiEncode(input.getText()));
			}
		});

		btnDecode.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (keyName.isEnabled() && !keyName.getText().equals(""))
					Cipher.defaultInput();
				else
					Cipher.basic = new Cipher(keyName.getText());
				outputField.setText(Cipher.uiDecode(input.getText()));
			}
		});

	}
}
