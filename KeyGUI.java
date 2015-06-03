package Cipher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyGUI
{

	private JFrame frame;
	private JTextField tfFileName;
	private JTextField tfFirst;
	private JTextField tfSecond;
	private JTextField tfThird;
	private JTextField tfFourth;
	private JTextField tfFifth;
	private JTextField tfSixth;

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
					KeyGUI window = new KeyGUI();
					window.frame.setVisible(true);
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
	public KeyGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 10, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		JLabel lblName = new JLabel("File Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		tfFileName = new JTextField();
		GridBagConstraints gbc_tfFileName = new GridBagConstraints();
		gbc_tfFileName.insets = new Insets(0, 0, 5, 5);
		gbc_tfFileName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFileName.gridx = 2;
		gbc_tfFileName.gridy = 1;
		frame.getContentPane().add(tfFileName, gbc_tfFileName);
		tfFileName.setColumns(10);
		
		
		Component verticalStrut = Box.createVerticalStrut(15);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 3;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		
		JLabel lblFirst = new JLabel("First Word");
		GridBagConstraints gbc_lblFirst = new GridBagConstraints();
		gbc_lblFirst.anchor = GridBagConstraints.EAST;
		gbc_lblFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirst.gridx = 1;
		gbc_lblFirst.gridy = 3;
		frame.getContentPane().add(lblFirst, gbc_lblFirst);
		
		tfFirst = new JTextField();
		GridBagConstraints gbc_tfFirst = new GridBagConstraints();
		gbc_tfFirst.insets = new Insets(0, 0, 5, 5);
		gbc_tfFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFirst.gridx = 2;
		gbc_tfFirst.gridy = 3;
		frame.getContentPane().add(tfFirst, gbc_tfFirst);
		tfFirst.setColumns(10);
		
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 3;
		frame.getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		
		JLabel lblSecond = new JLabel("New label");
		GridBagConstraints gbc_lblSecond = new GridBagConstraints();
		gbc_lblSecond.anchor = GridBagConstraints.EAST;
		gbc_lblSecond.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecond.gridx = 1;
		gbc_lblSecond.gridy = 4;
		frame.getContentPane().add(lblSecond, gbc_lblSecond);
		
		tfSecond = new JTextField();
		tfSecond.setColumns(10);
		GridBagConstraints gbc_tfSecond = new GridBagConstraints();
		gbc_tfSecond.insets = new Insets(0, 0, 5, 5);
		gbc_tfSecond.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSecond.gridx = 2;
		gbc_tfSecond.gridy = 4;
		frame.getContentPane().add(tfSecond, gbc_tfSecond);
		
		
		JLabel lblThird = new JLabel("Third Word");
		GridBagConstraints gbc_lblThird = new GridBagConstraints();
		gbc_lblThird.anchor = GridBagConstraints.EAST;
		gbc_lblThird.insets = new Insets(0, 0, 5, 5);
		gbc_lblThird.gridx = 1;
		gbc_lblThird.gridy = 5;
		frame.getContentPane().add(lblThird, gbc_lblThird);
		
		tfThird = new JTextField();
		GridBagConstraints gbc_tfThird = new GridBagConstraints();
		gbc_tfThird.insets = new Insets(0, 0, 5, 5);
		gbc_tfThird.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfThird.gridx = 2;
		gbc_tfThird.gridy = 5;
		frame.getContentPane().add(tfThird, gbc_tfThird);
		tfThird.setColumns(10);
		
		
		JLabel lblFourth = new JLabel("Fourth Word");
		GridBagConstraints gbc_lblFourth = new GridBagConstraints();
		gbc_lblFourth.anchor = GridBagConstraints.EAST;
		gbc_lblFourth.insets = new Insets(0, 0, 5, 5);
		gbc_lblFourth.gridx = 1;
		gbc_lblFourth.gridy = 6;
		frame.getContentPane().add(lblFourth, gbc_lblFourth);
		
		tfFourth = new JTextField();
		GridBagConstraints gbc_tfFourth = new GridBagConstraints();
		gbc_tfFourth.insets = new Insets(0, 0, 5, 5);
		gbc_tfFourth.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFourth.gridx = 2;
		gbc_tfFourth.gridy = 6;
		frame.getContentPane().add(tfFourth, gbc_tfFourth);
		tfFourth.setColumns(10);
		
		
		JLabel lblFifth = new JLabel("Fifth Word");
		GridBagConstraints gbc_lblFifth = new GridBagConstraints();
		gbc_lblFifth.anchor = GridBagConstraints.EAST;
		gbc_lblFifth.insets = new Insets(0, 0, 5, 5);
		gbc_lblFifth.gridx = 1;
		gbc_lblFifth.gridy = 7;
		frame.getContentPane().add(lblFifth, gbc_lblFifth);
		
		tfFifth = new JTextField();
		GridBagConstraints gbc_tfFifth = new GridBagConstraints();
		gbc_tfFifth.insets = new Insets(0, 0, 5, 5);
		gbc_tfFifth.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFifth.gridx = 2;
		gbc_tfFifth.gridy = 7;
		frame.getContentPane().add(tfFifth, gbc_tfFifth);
		tfFifth.setColumns(10);
		
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 8;
		frame.getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);
		
		JButton btnConfirm = new JButton("Confirm Key");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Key.makeKey(tfFileName.getText(), tfFirst.getText(), tfSecond.getText(), tfThird.getText(), tfFourth.getText(), tfFifth.getText());
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.WEST;
		gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirm.gridx = 2;
		gbc_btnConfirm.gridy = 8;
		frame.getContentPane().add(btnConfirm, gbc_btnConfirm);
	}

}
