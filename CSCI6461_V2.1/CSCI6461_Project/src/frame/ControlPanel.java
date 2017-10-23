package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import constant.Constant;
import memory.Memory;

public class ControlPanel extends JFrame {

	/**
	 * will occur Exception without this ID, keep it.
	 */
	private static final long serialVersionUID = -1621271909752534275L;

	//GPR_0 text field
	private JTextField textFieldGPR_0;
	
	//GPR_1 text field
	private JTextField textFieldGPR_1;
	
	//GPR_2 text field
	private JTextField textFieldGPR_2;
	
	//GPR_3 text field
	private JTextField textFieldGPR_3;
	
	//IX_1 text field
	private JTextField textFieldIX_1;
	
	//IX_2 text field
	private JTextField textFieldIX_2;
	
	//IX_3 text field
	private JTextField textFieldIX_3;
	
	//MAR text field
	private JTextField textFieldMAR;
	
	//MBR text field
	private JTextField textFieldMBR;
	
	//IR text field
	private JTextField textFieldIR;
	
	//PC text field
	private JTextField textFieldPC;
	
	//Load Address text field
	private JTextField textFieldADD;
	
	//Store Data text field
	private JTextField textFieldDATA;
	
	//input instruction
	private JTextField textFieldINSTRUCTION;

	//GPR_0 JRadioButton
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_10;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_13;
	private JRadioButton radioButton_14;
	
	//GPR_1 JRadioButton
	private JRadioButton radioButton_15;
	private JRadioButton radioButton_16;
	private JRadioButton radioButton_17;
	private JRadioButton radioButton_18;
	private JRadioButton radioButton_19;
	private JRadioButton radioButton_20;
	private JRadioButton radioButton_21;
	private JRadioButton radioButton_22;
	private JRadioButton radioButton_23;
	private JRadioButton radioButton_24;
	private JRadioButton radioButton_25;
	private JRadioButton radioButton_26;
	private JRadioButton radioButton_27;
	private JRadioButton radioButton_28;
	private JRadioButton radioButton_29;
	private JRadioButton radioButton_30;
	
	//GPR_2 JRadioButton
	private JRadioButton radioButton_31;
	private JRadioButton radioButton_32;
	private JRadioButton radioButton_33;
	private JRadioButton radioButton_34;
	private JRadioButton radioButton_35;
	private JRadioButton radioButton_36;
	private JRadioButton radioButton_37;
	private JRadioButton radioButton_38;
	private JRadioButton radioButton_39;
	private JRadioButton radioButton_40;
	private JRadioButton radioButton_41;
	private JRadioButton radioButton_42;
	private JRadioButton radioButton_43;
	private JRadioButton radioButton_44;
	private JRadioButton radioButton_45;
	private JRadioButton radioButton_46;
	
	//GPR_3 JRadioButton
	private JRadioButton radioButton_47;
	private JRadioButton radioButton_48;
	private JRadioButton radioButton_49;
	private JRadioButton radioButton_50;
	private JRadioButton radioButton_51;
	private JRadioButton radioButton_52;
	private JRadioButton radioButton_53;
	private JRadioButton radioButton_54;
	private JRadioButton radioButton_55;
	private JRadioButton radioButton_56;
	private JRadioButton radioButton_57;
	private JRadioButton radioButton_58;
	private JRadioButton radioButton_59;
	private JRadioButton radioButton_60;
	private JRadioButton radioButton_61;
	private JRadioButton radioButton_62;
	
	//GPR set JButton
	private JButton buttonGPR_0;
	private JButton buttonGPR_1;
	private JButton buttonGPR_2;
	private JButton buttonGPR_3;
	
	//IX_1
	private JRadioButton radioButton_63;
	private JRadioButton radioButton_64;
	private JRadioButton radioButton_65;
	private JRadioButton radioButton_66;
	private JRadioButton radioButton_67;
	private JRadioButton radioButton_68;
	private JRadioButton radioButton_69;
	private JRadioButton radioButton_70;
	private JRadioButton radioButton_71;
	private JRadioButton radioButton_72;
	private JRadioButton radioButton_73;
	private JRadioButton radioButton_74;
	private JRadioButton radioButton_75;
	private JRadioButton radioButton_76;
	private JRadioButton radioButton_77;
	private JRadioButton radioButton_78;
	
	//IX_2
	private JRadioButton radioButton_79;
	private JRadioButton radioButton_80;
	private JRadioButton radioButton_81;
	private JRadioButton radioButton_82;
	private JRadioButton radioButton_83;
	private JRadioButton radioButton_84;
	private JRadioButton radioButton_85;
	private JRadioButton radioButton_86;
	private JRadioButton radioButton_87;
	private JRadioButton radioButton_88;
	private JRadioButton radioButton_89;
	private JRadioButton radioButton_90;
	private JRadioButton radioButton_91;
	private JRadioButton radioButton_92;
	private JRadioButton radioButton_93;
	private JRadioButton radioButton_94;
	
	//IX_3
	private JRadioButton radioButton_95;
	private JRadioButton radioButton_96;
	private JRadioButton radioButton_97;
	private JRadioButton radioButton_98;
	private JRadioButton radioButton_99;
	private JRadioButton radioButton_100;
	private JRadioButton radioButton_101;
	private JRadioButton radioButton_102;
	private JRadioButton radioButton_103;
	private JRadioButton radioButton_104;
	private JRadioButton radioButton_105;
	private JRadioButton radioButton_106;
	private JRadioButton radioButton_107;
	private JRadioButton radioButton_108;
	private JRadioButton radioButton_109;
	private JRadioButton radioButton_110;
	
	//IX set JButton
	private JButton buttonIX_1;
	private JButton buttonIX_2;
	private JButton buttonIX_3;
	
	//CPU set JButton
	private JButton buttonMAR;
	private JButton buttonMBR;
	private JButton buttonIR;
	private JButton buttonPC;
	
	//CONTROL JButton
	private JButton buttonIPL;
	private JButton buttonRUN;
	private JButton buttonSTEP;
	private JButton buttonHLT;
	private JButton buttonLOAD;
	private JButton buttonSTORE;
	
	//ControlButton class
	private ControlButton ctrlButton;
	
	//memory
	private Memory memory;
	
	//flag for IPL
	private boolean flagIPL;
	private JLabel lblInstruction;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
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
	public ControlPanel() {
		super("TEST MACHINE 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 980, 750);
		getContentPane().setLayout(null);
		
		JPanel pTitle = new JPanel();
		pTitle.setForeground(Color.BLACK);
		pTitle.setBounds(10, 10, 944, 692);
		Border titleBorder = BorderFactory.createTitledBorder("TEST¡¡MACHINE 1.0");
		pTitle.setBorder(titleBorder);
		getContentPane().add(pTitle);
		pTitle.setLayout(null);
		Border titleBorder3 = BorderFactory.createTitledBorder("CPU");
		Border titleBorder4 = BorderFactory.createTitledBorder("CONTROL");
		
		JPanel pGpr = new JPanel();
		pGpr.setBounds(10, 111, 620, 200);
		pTitle.add(pGpr);
		pGpr.setBorder(new TitledBorder(null, "GPR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SpringLayout sl_pGpr = new SpringLayout();
		pGpr.setLayout(sl_pGpr);
		
		JLabel lblR = new JLabel("R0");
		sl_pGpr.putConstraint(SpringLayout.NORTH, lblR, 10, SpringLayout.NORTH, pGpr);
		sl_pGpr.putConstraint(SpringLayout.WEST, lblR, 10, SpringLayout.WEST, pGpr);
		pGpr.add(lblR);
		
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 6, SpringLayout.EAST, lblR);
		pGpr.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("");
		radioButton.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton, 0, SpringLayout.EAST, rdbtnNewRadioButton);
		pGpr.add(radioButton);
		
		radioButton_1 = new JRadioButton("");
		radioButton_1.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_1, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_1, 0, SpringLayout.EAST, radioButton);
		pGpr.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("");
		radioButton_2.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_2, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_2, 0, SpringLayout.EAST, radioButton_1);
		pGpr.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("");
		radioButton_3.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_3, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_3, 0, SpringLayout.EAST, radioButton_2);
		pGpr.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("");
		radioButton_4.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_4, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_4, 0, SpringLayout.EAST, radioButton_3);
		pGpr.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("");
		radioButton_5.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_5, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_5, 0, SpringLayout.EAST, radioButton_4);
		pGpr.add(radioButton_5);
		
		radioButton_6 = new JRadioButton("");
		radioButton_6.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_6, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_6, 0, SpringLayout.EAST, radioButton_5);
		pGpr.add(radioButton_6);
		
		radioButton_7 = new JRadioButton("");
		radioButton_7.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_7, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_7, 0, SpringLayout.EAST, radioButton_6);
		pGpr.add(radioButton_7);
		
		radioButton_8 = new JRadioButton("");
		radioButton_8.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_8, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_8, 0, SpringLayout.EAST, radioButton_7);
		pGpr.add(radioButton_8);
		
		radioButton_9 = new JRadioButton("");
		radioButton_9.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_9, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_9, 0, SpringLayout.EAST, radioButton_8);
		pGpr.add(radioButton_9);
		
		radioButton_10 = new JRadioButton("");
		radioButton_10.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_10, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_10, 0, SpringLayout.EAST, radioButton_9);
		pGpr.add(radioButton_10);
		
		radioButton_11 = new JRadioButton("");
		radioButton_11.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_11, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_11, 0, SpringLayout.EAST, radioButton_10);
		pGpr.add(radioButton_11);
		
		radioButton_12 = new JRadioButton("");
		radioButton_12.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_12, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_12, 0, SpringLayout.EAST, radioButton_11);
		pGpr.add(radioButton_12);
		
		radioButton_13 = new JRadioButton("");
		radioButton_13.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_13, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_13, 0, SpringLayout.EAST, radioButton_12);
		pGpr.add(radioButton_13);
		
		radioButton_14 = new JRadioButton("");
		radioButton_14.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_14, 0, SpringLayout.NORTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_14, 0, SpringLayout.EAST, radioButton_13);
		pGpr.add(radioButton_14);
		
		textFieldGPR_0 = new JTextField();
		textFieldGPR_0.setEnabled(false);
		textFieldGPR_0.setVisible(false);
		textFieldGPR_0.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pGpr.putConstraint(SpringLayout.WEST, textFieldGPR_0, 6, SpringLayout.EAST, radioButton_14);
		sl_pGpr.putConstraint(SpringLayout.NORTH, textFieldGPR_0, 0, SpringLayout.NORTH, lblR);
		pGpr.add(textFieldGPR_0);
		textFieldGPR_0.setColumns(7);
		
		buttonGPR_0 = new JButton("Set");
		buttonGPR_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldGPR_0.getText(), Constant.CONST_GPR_0);
			}
		});
		buttonGPR_0.setEnabled(false);
		buttonGPR_0.setVisible(false);
		sl_pGpr.putConstraint(SpringLayout.EAST, textFieldGPR_0, -6, SpringLayout.WEST, buttonGPR_0);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, buttonGPR_0, 0, SpringLayout.SOUTH, rdbtnNewRadioButton);
		sl_pGpr.putConstraint(SpringLayout.EAST, buttonGPR_0, -10, SpringLayout.EAST, pGpr);
		pGpr.add(buttonGPR_0);
		
		JLabel lblR_1 = new JLabel("R1");
		sl_pGpr.putConstraint(SpringLayout.NORTH, lblR_1, 25, SpringLayout.SOUTH, lblR);
		sl_pGpr.putConstraint(SpringLayout.WEST, lblR_1, 0, SpringLayout.WEST, lblR);
		pGpr.add(lblR_1);
		
		radioButton_15 = new JRadioButton("");
		radioButton_15.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_15, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_15, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		pGpr.add(radioButton_15);
		
		radioButton_16 = new JRadioButton("");
		radioButton_16.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_16, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_16, 0, SpringLayout.WEST, radioButton);
		pGpr.add(radioButton_16);
		
		radioButton_17 = new JRadioButton("");
		radioButton_17.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_17, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_17, 0, SpringLayout.WEST, radioButton_1);
		pGpr.add(radioButton_17);
		
		radioButton_18 = new JRadioButton("");
		radioButton_18.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_18, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_18, 0, SpringLayout.WEST, radioButton_2);
		pGpr.add(radioButton_18);
		
		radioButton_19 = new JRadioButton("");
		radioButton_19.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_19, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_19, 0, SpringLayout.WEST, radioButton_3);
		pGpr.add(radioButton_19);
		
		radioButton_20 = new JRadioButton("");
		radioButton_20.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_20, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_20, 0, SpringLayout.WEST, radioButton_4);
		pGpr.add(radioButton_20);
		
		radioButton_21 = new JRadioButton("");
		radioButton_21.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_21, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_21, 0, SpringLayout.WEST, radioButton_5);
		pGpr.add(radioButton_21);
		
		radioButton_22 = new JRadioButton("");
		radioButton_22.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_22, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_22, 0, SpringLayout.WEST, radioButton_6);
		pGpr.add(radioButton_22);
		
		radioButton_23 = new JRadioButton("");
		radioButton_23.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_23, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_23, 0, SpringLayout.WEST, radioButton_7);
		pGpr.add(radioButton_23);
		
		radioButton_24 = new JRadioButton("");
		radioButton_24.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_24, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_24, 0, SpringLayout.WEST, radioButton_8);
		pGpr.add(radioButton_24);
		
		radioButton_25 = new JRadioButton("");
		radioButton_25.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_25, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_25, 0, SpringLayout.WEST, radioButton_9);
		pGpr.add(radioButton_25);
		
		radioButton_26 = new JRadioButton("");
		radioButton_26.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_26, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_26, 0, SpringLayout.WEST, radioButton_10);
		pGpr.add(radioButton_26);
		
		radioButton_27 = new JRadioButton("");
		radioButton_27.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_27, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_27, 0, SpringLayout.WEST, radioButton_11);
		pGpr.add(radioButton_27);
		
		radioButton_28 = new JRadioButton("");
		radioButton_28.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_28, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_28, 0, SpringLayout.WEST, radioButton_12);
		pGpr.add(radioButton_28);
		
		radioButton_29 = new JRadioButton("");
		radioButton_29.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_29, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_29, 0, SpringLayout.WEST, radioButton_13);
		pGpr.add(radioButton_29);
		
		radioButton_30 = new JRadioButton("");
		radioButton_30.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_30, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_30, 0, SpringLayout.WEST, radioButton_14);
		pGpr.add(radioButton_30);
		
		textFieldGPR_1 = new JTextField();
		textFieldGPR_1.setEnabled(false);
		textFieldGPR_1.setVisible(false);
		textFieldGPR_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pGpr.putConstraint(SpringLayout.NORTH, textFieldGPR_1, 0, SpringLayout.NORTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, textFieldGPR_1, 6, SpringLayout.EAST, radioButton_30);
		sl_pGpr.putConstraint(SpringLayout.EAST, textFieldGPR_1, 0, SpringLayout.EAST, textFieldGPR_0);
		textFieldGPR_1.setColumns(7);
		pGpr.add(textFieldGPR_1);
		
		buttonGPR_1 = new JButton("Set");
		buttonGPR_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldGPR_1.getText(), Constant.CONST_GPR_1);
			}
		});
		buttonGPR_1.setEnabled(false);
		buttonGPR_1.setVisible(false);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, buttonGPR_1, 0, SpringLayout.SOUTH, radioButton_15);
		sl_pGpr.putConstraint(SpringLayout.EAST, buttonGPR_1, 0, SpringLayout.EAST, buttonGPR_0);
		pGpr.add(buttonGPR_1);
		
		JLabel lblR_2 = new JLabel("R2");
		sl_pGpr.putConstraint(SpringLayout.NORTH, lblR_2, 25, SpringLayout.SOUTH, lblR_1);
		sl_pGpr.putConstraint(SpringLayout.WEST, lblR_2, 0, SpringLayout.WEST, lblR);
		pGpr.add(lblR_2);
		
		radioButton_31 = new JRadioButton("");
		radioButton_31.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_31, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_31, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		pGpr.add(radioButton_31);
		
		radioButton_32 = new JRadioButton("");
		radioButton_32.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_32, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.EAST, radioButton_32, 0, SpringLayout.EAST, radioButton);
		pGpr.add(radioButton_32);
		
		radioButton_33 = new JRadioButton("");
		radioButton_33.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, radioButton_33, 0, SpringLayout.SOUTH, radioButton_31);
		sl_pGpr.putConstraint(SpringLayout.EAST, radioButton_33, 0, SpringLayout.EAST, radioButton_1);
		pGpr.add(radioButton_33);
		
		radioButton_34 = new JRadioButton("");
		radioButton_34.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_34, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_34, 0, SpringLayout.WEST, radioButton_2);
		pGpr.add(radioButton_34);
		
		radioButton_35 = new JRadioButton("");
		radioButton_35.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_35, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_35, 0, SpringLayout.WEST, radioButton_3);
		pGpr.add(radioButton_35);
		
		radioButton_36 = new JRadioButton("");
		radioButton_36.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_36, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_36, 0, SpringLayout.WEST, radioButton_4);
		pGpr.add(radioButton_36);
		
		radioButton_37 = new JRadioButton("");
		radioButton_37.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_37, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_37, 0, SpringLayout.WEST, radioButton_5);
		pGpr.add(radioButton_37);
		
		radioButton_38 = new JRadioButton("");
		radioButton_38.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_38, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_38, 0, SpringLayout.WEST, radioButton_6);
		pGpr.add(radioButton_38);
		
		radioButton_39 = new JRadioButton("");
		radioButton_39.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_39, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_39, 0, SpringLayout.WEST, radioButton_7);
		pGpr.add(radioButton_39);
		
		radioButton_40 = new JRadioButton("");
		radioButton_40.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_40, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_40, 0, SpringLayout.WEST, radioButton_8);
		pGpr.add(radioButton_40);
		
		radioButton_41 = new JRadioButton("");
		radioButton_41.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_41, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_41, 0, SpringLayout.WEST, radioButton_9);
		pGpr.add(radioButton_41);
		
		radioButton_42 = new JRadioButton("");
		radioButton_42.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_42, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_42, 0, SpringLayout.WEST, radioButton_10);
		pGpr.add(radioButton_42);
		
		radioButton_43 = new JRadioButton("");
		radioButton_43.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_43, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_43, 0, SpringLayout.WEST, radioButton_11);
		pGpr.add(radioButton_43);
		
		radioButton_44 = new JRadioButton("");
		radioButton_44.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_44, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_44, 0, SpringLayout.WEST, radioButton_12);
		pGpr.add(radioButton_44);
		
		radioButton_45 = new JRadioButton("");
		radioButton_45.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_45, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_45, 0, SpringLayout.WEST, radioButton_13);
		pGpr.add(radioButton_45);
		
		radioButton_46 = new JRadioButton("");
		radioButton_46.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_46, 0, SpringLayout.NORTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.EAST, radioButton_46, 0, SpringLayout.EAST, radioButton_14);
		pGpr.add(radioButton_46);
		
		textFieldGPR_2 = new JTextField();
		textFieldGPR_2.setEnabled(false);
		textFieldGPR_2.setVisible(false);
		sl_pGpr.putConstraint(SpringLayout.WEST, textFieldGPR_2, 0, SpringLayout.WEST, textFieldGPR_0);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, textFieldGPR_2, 0, SpringLayout.SOUTH, radioButton_31);
		sl_pGpr.putConstraint(SpringLayout.EAST, textFieldGPR_2, 0, SpringLayout.EAST, textFieldGPR_0);
		textFieldGPR_2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGPR_2.setColumns(7);
		pGpr.add(textFieldGPR_2);
		
		buttonGPR_2 = new JButton("Set");
		buttonGPR_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldGPR_2.getText(), Constant.CONST_GPR_2);
			}
		});
		buttonGPR_2.setEnabled(false);
		buttonGPR_2.setVisible(false);
		sl_pGpr.putConstraint(SpringLayout.WEST, buttonGPR_2, 0, SpringLayout.WEST, buttonGPR_0);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, buttonGPR_2, 0, SpringLayout.SOUTH, radioButton_31);
		pGpr.add(buttonGPR_2);
		
		JLabel lblR_3 = new JLabel("R3");
		sl_pGpr.putConstraint(SpringLayout.NORTH, lblR_3, 25, SpringLayout.SOUTH, lblR_2);
		sl_pGpr.putConstraint(SpringLayout.WEST, lblR_3, 0, SpringLayout.WEST, lblR);
		pGpr.add(lblR_3);
		
		radioButton_47 = new JRadioButton("");
		radioButton_47.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_47, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_47, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		pGpr.add(radioButton_47);
		
		radioButton_48 = new JRadioButton("");
		radioButton_48.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_48, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_48, 0, SpringLayout.WEST, radioButton);
		pGpr.add(radioButton_48);
		
		radioButton_49 = new JRadioButton("");
		radioButton_49.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_49, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_49, 0, SpringLayout.WEST, radioButton_1);
		pGpr.add(radioButton_49);
		
		radioButton_50 = new JRadioButton("");
		radioButton_50.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_50, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_50, 0, SpringLayout.WEST, radioButton_2);
		pGpr.add(radioButton_50);
		
		radioButton_51 = new JRadioButton("");
		radioButton_51.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_51, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_51, 0, SpringLayout.WEST, radioButton_3);
		pGpr.add(radioButton_51);
		
		radioButton_52 = new JRadioButton("");
		radioButton_52.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_52, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_52, 0, SpringLayout.WEST, radioButton_4);
		pGpr.add(radioButton_52);
		
		radioButton_53 = new JRadioButton("");
		radioButton_53.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_53, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_53, 0, SpringLayout.WEST, radioButton_5);
		pGpr.add(radioButton_53);
		
		radioButton_54 = new JRadioButton("");
		radioButton_54.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_54, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_54, 0, SpringLayout.WEST, radioButton_6);
		pGpr.add(radioButton_54);
		
		radioButton_55 = new JRadioButton("");
		radioButton_55.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_55, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_55, 0, SpringLayout.WEST, radioButton_7);
		pGpr.add(radioButton_55);
		
		radioButton_56 = new JRadioButton("");
		radioButton_56.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_56, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_56, 0, SpringLayout.WEST, radioButton_8);
		pGpr.add(radioButton_56);
		
		radioButton_57 = new JRadioButton("");
		radioButton_57.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_57, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_57, 0, SpringLayout.WEST, radioButton_9);
		pGpr.add(radioButton_57);
		
		radioButton_58 = new JRadioButton("");
		radioButton_58.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_58, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_58, 0, SpringLayout.WEST, radioButton_10);
		pGpr.add(radioButton_58);
		
		radioButton_59 = new JRadioButton("");
		radioButton_59.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_59, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_59, 0, SpringLayout.WEST, radioButton_11);
		pGpr.add(radioButton_59);
		
		radioButton_60 = new JRadioButton("");
		radioButton_60.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_60, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_60, 0, SpringLayout.WEST, radioButton_12);
		pGpr.add(radioButton_60);
		
		radioButton_61 = new JRadioButton("");
		radioButton_61.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_61, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_61, 0, SpringLayout.WEST, radioButton_13);
		pGpr.add(radioButton_61);
		
		radioButton_62 = new JRadioButton("");
		radioButton_62.setEnabled(false);
		sl_pGpr.putConstraint(SpringLayout.NORTH, radioButton_62, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, radioButton_62, 0, SpringLayout.WEST, radioButton_14);
		pGpr.add(radioButton_62);
		
		textFieldGPR_3 = new JTextField();
		textFieldGPR_3.setEnabled(false);
		textFieldGPR_3.setVisible(false);
		textFieldGPR_3.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pGpr.putConstraint(SpringLayout.NORTH, textFieldGPR_3, 0, SpringLayout.NORTH, lblR_3);
		sl_pGpr.putConstraint(SpringLayout.WEST, textFieldGPR_3, 6, SpringLayout.EAST, radioButton_62);
		sl_pGpr.putConstraint(SpringLayout.EAST, textFieldGPR_3, 0, SpringLayout.EAST, textFieldGPR_0);
		textFieldGPR_3.setColumns(7);
		pGpr.add(textFieldGPR_3);
		
		buttonGPR_3 = new JButton("Set");
		buttonGPR_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldGPR_3.getText(), Constant.CONST_GPR_3);
			}
		});
		buttonGPR_3.setEnabled(false);
		buttonGPR_3.setVisible(false);
		sl_pGpr.putConstraint(SpringLayout.SOUTH, buttonGPR_3, 0, SpringLayout.SOUTH, radioButton_47);
		sl_pGpr.putConstraint(SpringLayout.EAST, buttonGPR_3, 0, SpringLayout.EAST, buttonGPR_0);
		pGpr.add(buttonGPR_3);
		
		JPanel pIx = new JPanel();
		pIx.setBounds(10, 320, 620, 160);
		pTitle.add(pIx);
		Border titleBorder2 = BorderFactory.createTitledBorder("IX");
		pIx.setBorder(titleBorder2);
		SpringLayout sl_pIx = new SpringLayout();
		pIx.setLayout(sl_pIx);
		
		JLabel lblX = new JLabel("X1");
		sl_pIx.putConstraint(SpringLayout.NORTH, lblX, 10, SpringLayout.NORTH, pIx);
		sl_pIx.putConstraint(SpringLayout.WEST, lblX, 10, SpringLayout.WEST, pIx);
		pIx.add(lblX);
		
		radioButton_63 = new JRadioButton("");
		radioButton_63.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_63, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_63, 6, SpringLayout.EAST, lblX);
		pIx.add(radioButton_63);
		
		radioButton_64 = new JRadioButton("");
		radioButton_64.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_64, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_64, 0, SpringLayout.EAST, radioButton_63);
		pIx.add(radioButton_64);
		
		radioButton_65 = new JRadioButton("");
		radioButton_65.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_65, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_65, 0, SpringLayout.EAST, radioButton_64);
		pIx.add(radioButton_65);
		
		radioButton_66 = new JRadioButton("");
		radioButton_66.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_66, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_66, 0, SpringLayout.EAST, radioButton_65);
		pIx.add(radioButton_66);
		
		radioButton_67 = new JRadioButton("");
		radioButton_67.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_67, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_67, 0, SpringLayout.EAST, radioButton_66);
		pIx.add(radioButton_67);
		
		radioButton_68 = new JRadioButton("");
		radioButton_68.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_68, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_68, 0, SpringLayout.EAST, radioButton_67);
		pIx.add(radioButton_68);
		
		radioButton_69 = new JRadioButton("");
		radioButton_69.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_69, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_69, 0, SpringLayout.EAST, radioButton_68);
		pIx.add(radioButton_69);
		
		radioButton_70 = new JRadioButton("");
		radioButton_70.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_70, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_70, 0, SpringLayout.EAST, radioButton_69);
		pIx.add(radioButton_70);
		
		radioButton_71 = new JRadioButton("");
		radioButton_71.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_71, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_71, 0, SpringLayout.EAST, radioButton_70);
		pIx.add(radioButton_71);
		
		radioButton_72 = new JRadioButton("");
		radioButton_72.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_72, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_72, 0, SpringLayout.EAST, radioButton_71);
		pIx.add(radioButton_72);
		
		radioButton_73 = new JRadioButton("");
		radioButton_73.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_73, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_73, 0, SpringLayout.EAST, radioButton_72);
		pIx.add(radioButton_73);
		
		radioButton_74 = new JRadioButton("");
		radioButton_74.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_74, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_74, 0, SpringLayout.EAST, radioButton_73);
		pIx.add(radioButton_74);
		
		radioButton_75 = new JRadioButton("");
		radioButton_75.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_75, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_75, 0, SpringLayout.EAST, radioButton_74);
		pIx.add(radioButton_75);
		
		radioButton_76 = new JRadioButton("");
		radioButton_76.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_76, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_76, 0, SpringLayout.EAST, radioButton_75);
		pIx.add(radioButton_76);
		
		radioButton_77 = new JRadioButton("");
		radioButton_77.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_77, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_77, 0, SpringLayout.EAST, radioButton_76);
		pIx.add(radioButton_77);
		
		radioButton_78 = new JRadioButton("");
		radioButton_78.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_78, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_78, 0, SpringLayout.EAST, radioButton_77);
		pIx.add(radioButton_78);
		
		textFieldIX_1 = new JTextField();
		textFieldIX_1.setEnabled(false);
		textFieldIX_1.setVisible(false);
		textFieldIX_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pIx.putConstraint(SpringLayout.NORTH, textFieldIX_1, 0, SpringLayout.NORTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, textFieldIX_1, 6, SpringLayout.EAST, radioButton_78);
		sl_pIx.putConstraint(SpringLayout.EAST, textFieldIX_1, -67, SpringLayout.EAST, pIx);
		textFieldIX_1.setColumns(7);
		pIx.add(textFieldIX_1);
		
		buttonIX_1 = new JButton("Set");
		buttonIX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldIX_1.getText(), Constant.CONST_IX_1);
			}
		});
		buttonIX_1.setEnabled(false);
		buttonIX_1.setVisible(false);
		sl_pIx.putConstraint(SpringLayout.WEST, buttonIX_1, 6, SpringLayout.EAST, textFieldIX_1);
		sl_pIx.putConstraint(SpringLayout.SOUTH, buttonIX_1, 0, SpringLayout.SOUTH, radioButton_63);
		pIx.add(buttonIX_1);
		
		JLabel lblX_1 = new JLabel("X2");
		sl_pIx.putConstraint(SpringLayout.NORTH, lblX_1, 25, SpringLayout.SOUTH, lblX);
		sl_pIx.putConstraint(SpringLayout.WEST, lblX_1, 0, SpringLayout.WEST, lblX);
		pIx.add(lblX_1);
		
		radioButton_79 = new JRadioButton("");
		radioButton_79.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_79, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_79, 0, SpringLayout.WEST, radioButton_63);
		pIx.add(radioButton_79);
		
		radioButton_80 = new JRadioButton("");
		radioButton_80.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_80, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_80, 0, SpringLayout.WEST, radioButton_64);
		pIx.add(radioButton_80);
		
		radioButton_81 = new JRadioButton("");
		radioButton_81.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_81, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_81, 0, SpringLayout.WEST, radioButton_65);
		pIx.add(radioButton_81);
		
		radioButton_82 = new JRadioButton("");
		radioButton_82.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_82, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_82, 0, SpringLayout.WEST, radioButton_66);
		pIx.add(radioButton_82);
		
		radioButton_83 = new JRadioButton("");
		radioButton_83.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_83, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_83, 0, SpringLayout.WEST, radioButton_67);
		pIx.add(radioButton_83);
		
		radioButton_84 = new JRadioButton("");
		radioButton_84.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_84, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_84, 0, SpringLayout.WEST, radioButton_68);
		pIx.add(radioButton_84);
		
		radioButton_85 = new JRadioButton("");
		radioButton_85.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_85, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_85, 0, SpringLayout.WEST, radioButton_69);
		pIx.add(radioButton_85);
		
		radioButton_86 = new JRadioButton("");
		radioButton_86.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_86, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_86, 0, SpringLayout.WEST, radioButton_70);
		pIx.add(radioButton_86);
		
		radioButton_87 = new JRadioButton("");
		radioButton_87.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_87, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_87, 0, SpringLayout.WEST, radioButton_71);
		pIx.add(radioButton_87);
		
		radioButton_88 = new JRadioButton("");
		radioButton_88.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_88, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_88, 0, SpringLayout.WEST, radioButton_72);
		pIx.add(radioButton_88);
		
		radioButton_89 = new JRadioButton("");
		radioButton_89.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_89, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_89, 0, SpringLayout.WEST, radioButton_73);
		pIx.add(radioButton_89);
		
		radioButton_90 = new JRadioButton("");
		radioButton_90.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_90, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_90, 0, SpringLayout.WEST, radioButton_74);
		pIx.add(radioButton_90);
		
		radioButton_91 = new JRadioButton("");
		radioButton_91.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_91, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_91, 0, SpringLayout.WEST, radioButton_75);
		pIx.add(radioButton_91);
		
		radioButton_92 = new JRadioButton("");
		radioButton_92.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_92, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_92, 0, SpringLayout.WEST, radioButton_76);
		pIx.add(radioButton_92);
		
		radioButton_93 = new JRadioButton("");
		radioButton_93.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_93, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_93, 0, SpringLayout.WEST, radioButton_77);
		pIx.add(radioButton_93);
		
		radioButton_94 = new JRadioButton("");
		radioButton_94.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_94, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_94, 0, SpringLayout.WEST, radioButton_78);
		pIx.add(radioButton_94);
		
		textFieldIX_2 = new JTextField();
		textFieldIX_2.setEnabled(false);
		textFieldIX_2.setVisible(false);
		textFieldIX_2.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pIx.putConstraint(SpringLayout.NORTH, textFieldIX_2, 0, SpringLayout.NORTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, textFieldIX_2, 6, SpringLayout.EAST, radioButton_94);
		sl_pIx.putConstraint(SpringLayout.EAST, textFieldIX_2, 0, SpringLayout.EAST, textFieldIX_1);
		textFieldIX_2.setColumns(7);
		pIx.add(textFieldIX_2);
		
		buttonIX_2 = new JButton("Set");
		buttonIX_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldIX_2.getText(), Constant.CONST_IX_2);
			}
		});
		buttonIX_2.setEnabled(false);
		buttonIX_2.setVisible(false);
		sl_pIx.putConstraint(SpringLayout.WEST, buttonIX_2, 0, SpringLayout.WEST, buttonIX_1);
		sl_pIx.putConstraint(SpringLayout.SOUTH, buttonIX_2, 0, SpringLayout.SOUTH, radioButton_79);
		pIx.add(buttonIX_2);
		
		JLabel label = new JLabel("X3");
		sl_pIx.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.SOUTH, lblX_1);
		sl_pIx.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblX);
		pIx.add(label);
		
		radioButton_95 = new JRadioButton("");
		radioButton_95.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_95, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_95, 0, SpringLayout.WEST, radioButton_63);
		pIx.add(radioButton_95);
		
		radioButton_96 = new JRadioButton("");
		radioButton_96.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_96, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_96, 0, SpringLayout.WEST, radioButton_64);
		pIx.add(radioButton_96);
		
		radioButton_97 = new JRadioButton("");
		radioButton_97.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_97, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_97, 0, SpringLayout.WEST, radioButton_65);
		pIx.add(radioButton_97);
		
		radioButton_98 = new JRadioButton("");
		radioButton_98.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_98, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_98, 0, SpringLayout.WEST, radioButton_66);
		pIx.add(radioButton_98);
		
		radioButton_99 = new JRadioButton("");
		radioButton_99.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_99, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_99, 0, SpringLayout.WEST, radioButton_67);
		pIx.add(radioButton_99);
		
		radioButton_100 = new JRadioButton("");
		radioButton_100.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_100, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_100, 0, SpringLayout.WEST, radioButton_68);
		pIx.add(radioButton_100);
		
		radioButton_101 = new JRadioButton("");
		radioButton_101.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_101, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_101, 0, SpringLayout.WEST, radioButton_69);
		pIx.add(radioButton_101);
		
		radioButton_102 = new JRadioButton("");
		radioButton_102.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_102, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_102, 0, SpringLayout.WEST, radioButton_70);
		pIx.add(radioButton_102);
		
		radioButton_103 = new JRadioButton("");
		radioButton_103.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_103, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_103, 0, SpringLayout.WEST, radioButton_71);
		pIx.add(radioButton_103);
		
		radioButton_104 = new JRadioButton("");
		radioButton_104.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_104, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_104, 0, SpringLayout.WEST, radioButton_72);
		pIx.add(radioButton_104);
		
		radioButton_105 = new JRadioButton("");
		radioButton_105.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_105, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_105, 0, SpringLayout.WEST, radioButton_73);
		pIx.add(radioButton_105);
		
		radioButton_106 = new JRadioButton("");
		radioButton_106.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_106, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_106, 0, SpringLayout.WEST, radioButton_74);
		pIx.add(radioButton_106);
		
		radioButton_107 = new JRadioButton("");
		radioButton_107.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_107, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_107, 0, SpringLayout.WEST, radioButton_75);
		pIx.add(radioButton_107);
		
		radioButton_108 = new JRadioButton("");
		radioButton_108.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_108, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_108, 0, SpringLayout.WEST, radioButton_76);
		pIx.add(radioButton_108);
		
		radioButton_109 = new JRadioButton("");
		radioButton_109.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_109, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_109, 0, SpringLayout.WEST, radioButton_77);
		pIx.add(radioButton_109);
		
		radioButton_110 = new JRadioButton("");
		radioButton_110.setEnabled(false);
		sl_pIx.putConstraint(SpringLayout.NORTH, radioButton_110, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, radioButton_110, 0, SpringLayout.WEST, radioButton_78);
		pIx.add(radioButton_110);
		
		textFieldIX_3 = new JTextField();
		textFieldIX_3.setEnabled(false);
		textFieldIX_3.setVisible(false);
		textFieldIX_3.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pIx.putConstraint(SpringLayout.NORTH, textFieldIX_3, 0, SpringLayout.NORTH, label);
		sl_pIx.putConstraint(SpringLayout.WEST, textFieldIX_3, 6, SpringLayout.EAST, radioButton_110);
		sl_pIx.putConstraint(SpringLayout.EAST, textFieldIX_3, 0, SpringLayout.EAST, textFieldIX_1);
		textFieldIX_3.setColumns(7);
		pIx.add(textFieldIX_3);
		
		buttonIX_3 = new JButton("Set");
		buttonIX_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.Set(textFieldIX_3.getText(), Constant.CONST_IX_3);
			}
		});
		buttonIX_3.setEnabled(false);
		buttonIX_3.setVisible(false);
		sl_pIx.putConstraint(SpringLayout.WEST, buttonIX_3, 6, SpringLayout.EAST, textFieldIX_3);
		sl_pIx.putConstraint(SpringLayout.SOUTH, buttonIX_3, 0, SpringLayout.SOUTH, radioButton_95);
		pIx.add(buttonIX_3);
		
		JPanel pControl = new JPanel();
		pControl.setBounds(10, 490, 924, 192);
		pTitle.add(pControl);
		pControl.setBorder(titleBorder4);
		pControl.setLayout(null);
		
		buttonIPL = new JButton("IPL");
		buttonIPL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flagIPL = ctrlButton.IPL(flagIPL);
			}
		});
		buttonIPL.setBounds(10, 40, 122, 39);
		pControl.add(buttonIPL);
		
		buttonRUN = new JButton("RUN");
		buttonRUN.setEnabled(false);
		buttonRUN.setBounds(190, 40, 122, 39);
		pControl.add(buttonRUN);
		
		buttonSTEP = new JButton("STEP");
		buttonSTEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlButton.STEP(textFieldINSTRUCTION.getText());
			}
		});
		buttonSTEP.setEnabled(false);
		buttonSTEP.setBounds(370, 40, 122, 39);
		pControl.add(buttonSTEP);
		
		buttonHLT = new JButton("HLT");
		buttonHLT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlButton.HLT();
			}
		});
		buttonHLT.setEnabled(false);
		buttonHLT.setBounds(550, 40, 122, 39);
		pControl.add(buttonHLT);
		
		buttonLOAD = new JButton("LOAD");
		buttonLOAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldDATA.setText(memory.load(textFieldADD.getText()));
			}
		});
		buttonLOAD.setEnabled(false);
		buttonLOAD.setBounds(190, 117, 122, 39);
		pControl.add(buttonLOAD);
		
		buttonSTORE = new JButton("STORE");
		buttonSTORE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory.store(textFieldADD.getText(), textFieldDATA.getText());
			}
		});
		buttonSTORE.setEnabled(false);
		buttonSTORE.setBounds(550, 117, 122, 39);
		pControl.add(buttonSTORE);
		
		JLabel lblNewLabel_2 = new JLabel("ADD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 98, 54, 15);
		pControl.add(lblNewLabel_2);
		
		textFieldADD = new JTextField();
		textFieldADD.setEnabled(false);
		textFieldADD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldADD.setColumns(7);
		textFieldADD.setBounds(10, 126, 122, 21);
		pControl.add(textFieldADD);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(370, 98, 54, 15);
		pControl.add(lblData);
		
		textFieldDATA = new JTextField();
		textFieldDATA.setEnabled(false);
		textFieldDATA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDATA.setColumns(7);
		textFieldDATA.setBounds(370, 126, 122, 21);
		pControl.add(textFieldDATA);
		
		lblInstruction = new JLabel("INSTRUCTION");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(764, 52, 77, 15);
		pControl.add(lblInstruction);
		
		textFieldINSTRUCTION = new JTextField();
		textFieldINSTRUCTION.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldINSTRUCTION.setEnabled(false);
		textFieldINSTRUCTION.setColumns(10);
		textFieldINSTRUCTION.setBounds(720, 77, 165, 21);
		pControl.add(textFieldINSTRUCTION);
		
		JPanel pCpu = new JPanel();
		pCpu.setBounds(640, 111, 294, 369);
		pTitle.add(pCpu);
		pCpu.setBorder(titleBorder3);
		pCpu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAR");
		lblNewLabel.setBounds(10, 28, 54, 15);
		pCpu.add(lblNewLabel);
		
		textFieldMAR = new JTextField();
		textFieldMAR.setEnabled(false);
		textFieldMAR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMAR.setBounds(10, 53, 165, 21);
		pCpu.add(textFieldMAR);
		textFieldMAR.setColumns(10);
		
		buttonMAR = new JButton("Set");
		buttonMAR.setEnabled(false);
		buttonMAR.setBounds(185, 52, 93, 23);
		buttonMAR.setVisible(false);
		pCpu.add(buttonMAR);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setBounds(10, 100, 54, 15);
		pCpu.add(lblMbr);
		
		textFieldMBR = new JTextField();
		textFieldMBR.setEnabled(false);
		textFieldMBR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMBR.setColumns(10);
		textFieldMBR.setBounds(10, 125, 165, 21);
		pCpu.add(textFieldMBR);
		
		buttonMBR = new JButton("Set");
		buttonMBR.setEnabled(false);
		buttonMBR.setBounds(185, 124, 93, 23);
		buttonMBR.setVisible(false);
		pCpu.add(buttonMBR);
		
		JLabel lblNewLabel_1 = new JLabel("IR");
		lblNewLabel_1.setBounds(10, 172, 54, 15);
		pCpu.add(lblNewLabel_1);
		
		textFieldIR = new JTextField();
		textFieldIR.setEnabled(false);
		textFieldIR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIR.setColumns(10);
		textFieldIR.setBounds(10, 197, 165, 21);
		pCpu.add(textFieldIR);
		
		buttonIR = new JButton("Set");
		buttonIR.setEnabled(false);
		buttonIR.setBounds(185, 196, 93, 23);
		buttonIR.setVisible(false);
		pCpu.add(buttonIR);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(10, 244, 54, 15);
		pCpu.add(lblPc);
		
		textFieldPC = new JTextField();
		textFieldPC.setEnabled(false);
		textFieldPC.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPC.setColumns(10);
		textFieldPC.setBounds(10, 269, 165, 21);
		pCpu.add(textFieldPC);
		
		buttonPC = new JButton("Set");
		buttonPC.setEnabled(false);
		buttonPC.setBounds(185, 268, 93, 23);
		buttonPC.setVisible(false);
		pCpu.add(buttonPC);
		

		//IPL flag
		flagIPL = false;
		
		//memory
		memory = new Memory();
		
		//ControlButton
		ctrlButton = new ControlButton(this, memory);
	}

	public JTextField getTextFieldGPR_0() {
		return textFieldGPR_0;
	}

	public void setTextFieldGPR_0(JTextField textFieldGPR_0) {
		this.textFieldGPR_0 = textFieldGPR_0;
	}

	public JTextField getTextFieldGPR_1() {
		return textFieldGPR_1;
	}

	public void setTextFieldGPR_1(JTextField textFieldGPR_1) {
		this.textFieldGPR_1 = textFieldGPR_1;
	}

	public JTextField getTextFieldGPR_2() {
		return textFieldGPR_2;
	}

	public void setTextFieldGPR_2(JTextField textFieldGPR_2) {
		this.textFieldGPR_2 = textFieldGPR_2;
	}

	public JTextField getTextFieldGPR_3() {
		return textFieldGPR_3;
	}

	public void setTextFieldGPR_3(JTextField textFieldGPR_3) {
		this.textFieldGPR_3 = textFieldGPR_3;
	}

	public JTextField getTextFieldIX_1() {
		return textFieldIX_1;
	}

	public void setTextFieldIX_1(JTextField textFieldIX_1) {
		this.textFieldIX_1 = textFieldIX_1;
	}

	public JTextField getTextFieldIX_2() {
		return textFieldIX_2;
	}

	public void setTextFieldIX_2(JTextField textFieldIX_2) {
		this.textFieldIX_2 = textFieldIX_2;
	}

	public JTextField getTextFieldIX_3() {
		return textFieldIX_3;
	}

	public void setTextFieldIX_3(JTextField textFieldIX_3) {
		this.textFieldIX_3 = textFieldIX_3;
	}

	public JTextField getTextFieldMAR() {
		return textFieldMAR;
	}

	public void setTextFieldMAR(JTextField textFieldMAR) {
		this.textFieldMAR = textFieldMAR;
	}

	public JTextField getTextFieldMBR() {
		return textFieldMBR;
	}

	public void setTextFieldMBR(JTextField textFieldMBR) {
		this.textFieldMBR = textFieldMBR;
	}

	public JTextField getTextFieldIR() {
		return textFieldIR;
	}

	public void setTextFieldIR(JTextField textFieldIR) {
		this.textFieldIR = textFieldIR;
	}

	public JTextField getTextFieldPC() {
		return textFieldPC;
	}

	public void setTextFieldPC(JTextField textFieldPC) {
		this.textFieldPC = textFieldPC;
	}

	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	public void setRdbtnNewRadioButton(JRadioButton rdbtnNewRadioButton) {
		this.rdbtnNewRadioButton = rdbtnNewRadioButton;
	}

	public JRadioButton getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}

	public JRadioButton getRadioButton_1() {
		return radioButton_1;
	}

	public void setRadioButton_1(JRadioButton radioButton_1) {
		this.radioButton_1 = radioButton_1;
	}

	public JRadioButton getRadioButton_2() {
		return radioButton_2;
	}

	public void setRadioButton_2(JRadioButton radioButton_2) {
		this.radioButton_2 = radioButton_2;
	}

	public JRadioButton getRadioButton_3() {
		return radioButton_3;
	}

	public void setRadioButton_3(JRadioButton radioButton_3) {
		this.radioButton_3 = radioButton_3;
	}

	public JRadioButton getRadioButton_4() {
		return radioButton_4;
	}

	public void setRadioButton_4(JRadioButton radioButton_4) {
		this.radioButton_4 = radioButton_4;
	}

	public JRadioButton getRadioButton_5() {
		return radioButton_5;
	}

	public void setRadioButton_5(JRadioButton radioButton_5) {
		this.radioButton_5 = radioButton_5;
	}

	public JRadioButton getRadioButton_6() {
		return radioButton_6;
	}

	public void setRadioButton_6(JRadioButton radioButton_6) {
		this.radioButton_6 = radioButton_6;
	}

	public JRadioButton getRadioButton_7() {
		return radioButton_7;
	}

	public void setRadioButton_7(JRadioButton radioButton_7) {
		this.radioButton_7 = radioButton_7;
	}

	public JRadioButton getRadioButton_8() {
		return radioButton_8;
	}

	public void setRadioButton_8(JRadioButton radioButton_8) {
		this.radioButton_8 = radioButton_8;
	}

	public JRadioButton getRadioButton_9() {
		return radioButton_9;
	}

	public void setRadioButton_9(JRadioButton radioButton_9) {
		this.radioButton_9 = radioButton_9;
	}

	public JRadioButton getRadioButton_10() {
		return radioButton_10;
	}

	public void setRadioButton_10(JRadioButton radioButton_10) {
		this.radioButton_10 = radioButton_10;
	}

	public JRadioButton getRadioButton_11() {
		return radioButton_11;
	}

	public void setRadioButton_11(JRadioButton radioButton_11) {
		this.radioButton_11 = radioButton_11;
	}

	public JRadioButton getRadioButton_12() {
		return radioButton_12;
	}

	public void setRadioButton_12(JRadioButton radioButton_12) {
		this.radioButton_12 = radioButton_12;
	}

	public JRadioButton getRadioButton_13() {
		return radioButton_13;
	}

	public void setRadioButton_13(JRadioButton radioButton_13) {
		this.radioButton_13 = radioButton_13;
	}

	public JRadioButton getRadioButton_14() {
		return radioButton_14;
	}

	public void setRadioButton_14(JRadioButton radioButton_14) {
		this.radioButton_14 = radioButton_14;
	}

	public JRadioButton getRadioButton_15() {
		return radioButton_15;
	}

	public void setRadioButton_15(JRadioButton radioButton_15) {
		this.radioButton_15 = radioButton_15;
	}

	public JRadioButton getRadioButton_16() {
		return radioButton_16;
	}

	public void setRadioButton_16(JRadioButton radioButton_16) {
		this.radioButton_16 = radioButton_16;
	}

	public JRadioButton getRadioButton_17() {
		return radioButton_17;
	}

	public void setRadioButton_17(JRadioButton radioButton_17) {
		this.radioButton_17 = radioButton_17;
	}

	public JRadioButton getRadioButton_18() {
		return radioButton_18;
	}

	public void setRadioButton_18(JRadioButton radioButton_18) {
		this.radioButton_18 = radioButton_18;
	}

	public JRadioButton getRadioButton_19() {
		return radioButton_19;
	}

	public void setRadioButton_19(JRadioButton radioButton_19) {
		this.radioButton_19 = radioButton_19;
	}

	public JRadioButton getRadioButton_20() {
		return radioButton_20;
	}

	public void setRadioButton_20(JRadioButton radioButton_20) {
		this.radioButton_20 = radioButton_20;
	}

	public JRadioButton getRadioButton_21() {
		return radioButton_21;
	}

	public void setRadioButton_21(JRadioButton radioButton_21) {
		this.radioButton_21 = radioButton_21;
	}

	public JRadioButton getRadioButton_22() {
		return radioButton_22;
	}

	public void setRadioButton_22(JRadioButton radioButton_22) {
		this.radioButton_22 = radioButton_22;
	}

	public JRadioButton getRadioButton_23() {
		return radioButton_23;
	}

	public void setRadioButton_23(JRadioButton radioButton_23) {
		this.radioButton_23 = radioButton_23;
	}

	public JRadioButton getRadioButton_24() {
		return radioButton_24;
	}

	public void setRadioButton_24(JRadioButton radioButton_24) {
		this.radioButton_24 = radioButton_24;
	}

	public JRadioButton getRadioButton_25() {
		return radioButton_25;
	}

	public void setRadioButton_25(JRadioButton radioButton_25) {
		this.radioButton_25 = radioButton_25;
	}

	public JRadioButton getRadioButton_26() {
		return radioButton_26;
	}

	public void setRadioButton_26(JRadioButton radioButton_26) {
		this.radioButton_26 = radioButton_26;
	}

	public JRadioButton getRadioButton_27() {
		return radioButton_27;
	}

	public void setRadioButton_27(JRadioButton radioButton_27) {
		this.radioButton_27 = radioButton_27;
	}

	public JRadioButton getRadioButton_28() {
		return radioButton_28;
	}

	public void setRadioButton_28(JRadioButton radioButton_28) {
		this.radioButton_28 = radioButton_28;
	}

	public JRadioButton getRadioButton_29() {
		return radioButton_29;
	}

	public void setRadioButton_29(JRadioButton radioButton_29) {
		this.radioButton_29 = radioButton_29;
	}

	public JRadioButton getRadioButton_30() {
		return radioButton_30;
	}

	public void setRadioButton_30(JRadioButton radioButton_30) {
		this.radioButton_30 = radioButton_30;
	}

	public JRadioButton getRadioButton_31() {
		return radioButton_31;
	}

	public void setRadioButton_31(JRadioButton radioButton_31) {
		this.radioButton_31 = radioButton_31;
	}

	public JRadioButton getRadioButton_32() {
		return radioButton_32;
	}

	public void setRadioButton_32(JRadioButton radioButton_32) {
		this.radioButton_32 = radioButton_32;
	}

	public JRadioButton getRadioButton_33() {
		return radioButton_33;
	}

	public void setRadioButton_33(JRadioButton radioButton_33) {
		this.radioButton_33 = radioButton_33;
	}

	public JRadioButton getRadioButton_34() {
		return radioButton_34;
	}

	public void setRadioButton_34(JRadioButton radioButton_34) {
		this.radioButton_34 = radioButton_34;
	}

	public JRadioButton getRadioButton_35() {
		return radioButton_35;
	}

	public void setRadioButton_35(JRadioButton radioButton_35) {
		this.radioButton_35 = radioButton_35;
	}

	public JRadioButton getRadioButton_36() {
		return radioButton_36;
	}

	public void setRadioButton_36(JRadioButton radioButton_36) {
		this.radioButton_36 = radioButton_36;
	}

	public JRadioButton getRadioButton_37() {
		return radioButton_37;
	}

	public void setRadioButton_37(JRadioButton radioButton_37) {
		this.radioButton_37 = radioButton_37;
	}

	public JRadioButton getRadioButton_38() {
		return radioButton_38;
	}

	public void setRadioButton_38(JRadioButton radioButton_38) {
		this.radioButton_38 = radioButton_38;
	}

	public JRadioButton getRadioButton_39() {
		return radioButton_39;
	}

	public void setRadioButton_39(JRadioButton radioButton_39) {
		this.radioButton_39 = radioButton_39;
	}

	public JRadioButton getRadioButton_40() {
		return radioButton_40;
	}

	public void setRadioButton_40(JRadioButton radioButton_40) {
		this.radioButton_40 = radioButton_40;
	}

	public JRadioButton getRadioButton_41() {
		return radioButton_41;
	}

	public void setRadioButton_41(JRadioButton radioButton_41) {
		this.radioButton_41 = radioButton_41;
	}

	public JRadioButton getRadioButton_42() {
		return radioButton_42;
	}

	public void setRadioButton_42(JRadioButton radioButton_42) {
		this.radioButton_42 = radioButton_42;
	}

	public JRadioButton getRadioButton_43() {
		return radioButton_43;
	}

	public void setRadioButton_43(JRadioButton radioButton_43) {
		this.radioButton_43 = radioButton_43;
	}

	public JRadioButton getRadioButton_44() {
		return radioButton_44;
	}

	public void setRadioButton_44(JRadioButton radioButton_44) {
		this.radioButton_44 = radioButton_44;
	}

	public JRadioButton getRadioButton_45() {
		return radioButton_45;
	}

	public void setRadioButton_45(JRadioButton radioButton_45) {
		this.radioButton_45 = radioButton_45;
	}

	public JRadioButton getRadioButton_46() {
		return radioButton_46;
	}

	public void setRadioButton_46(JRadioButton radioButton_46) {
		this.radioButton_46 = radioButton_46;
	}

	public JRadioButton getRadioButton_47() {
		return radioButton_47;
	}

	public void setRadioButton_47(JRadioButton radioButton_47) {
		this.radioButton_47 = radioButton_47;
	}

	public JRadioButton getRadioButton_48() {
		return radioButton_48;
	}

	public void setRadioButton_48(JRadioButton radioButton_48) {
		this.radioButton_48 = radioButton_48;
	}

	public JRadioButton getRadioButton_49() {
		return radioButton_49;
	}

	public void setRadioButton_49(JRadioButton radioButton_49) {
		this.radioButton_49 = radioButton_49;
	}

	public JRadioButton getRadioButton_50() {
		return radioButton_50;
	}

	public void setRadioButton_50(JRadioButton radioButton_50) {
		this.radioButton_50 = radioButton_50;
	}

	public JRadioButton getRadioButton_51() {
		return radioButton_51;
	}

	public void setRadioButton_51(JRadioButton radioButton_51) {
		this.radioButton_51 = radioButton_51;
	}

	public JRadioButton getRadioButton_52() {
		return radioButton_52;
	}

	public void setRadioButton_52(JRadioButton radioButton_52) {
		this.radioButton_52 = radioButton_52;
	}

	public JRadioButton getRadioButton_53() {
		return radioButton_53;
	}

	public void setRadioButton_53(JRadioButton radioButton_53) {
		this.radioButton_53 = radioButton_53;
	}

	public JRadioButton getRadioButton_54() {
		return radioButton_54;
	}

	public void setRadioButton_54(JRadioButton radioButton_54) {
		this.radioButton_54 = radioButton_54;
	}

	public JRadioButton getRadioButton_55() {
		return radioButton_55;
	}

	public void setRadioButton_55(JRadioButton radioButton_55) {
		this.radioButton_55 = radioButton_55;
	}

	public JRadioButton getRadioButton_56() {
		return radioButton_56;
	}

	public void setRadioButton_56(JRadioButton radioButton_56) {
		this.radioButton_56 = radioButton_56;
	}

	public JRadioButton getRadioButton_57() {
		return radioButton_57;
	}

	public void setRadioButton_57(JRadioButton radioButton_57) {
		this.radioButton_57 = radioButton_57;
	}

	public JRadioButton getRadioButton_58() {
		return radioButton_58;
	}

	public void setRadioButton_58(JRadioButton radioButton_58) {
		this.radioButton_58 = radioButton_58;
	}

	public JRadioButton getRadioButton_59() {
		return radioButton_59;
	}

	public void setRadioButton_59(JRadioButton radioButton_59) {
		this.radioButton_59 = radioButton_59;
	}

	public JRadioButton getRadioButton_60() {
		return radioButton_60;
	}

	public void setRadioButton_60(JRadioButton radioButton_60) {
		this.radioButton_60 = radioButton_60;
	}

	public JRadioButton getRadioButton_61() {
		return radioButton_61;
	}

	public void setRadioButton_61(JRadioButton radioButton_61) {
		this.radioButton_61 = radioButton_61;
	}

	public JRadioButton getRadioButton_62() {
		return radioButton_62;
	}

	public void setRadioButton_62(JRadioButton radioButton_62) {
		this.radioButton_62 = radioButton_62;
	}

	public JButton getButtonGPR_0() {
		return buttonGPR_0;
	}

	public void setButtonGPR_0(JButton buttonGPR_0) {
		this.buttonGPR_0 = buttonGPR_0;
	}

	public JButton getButtonGPR_1() {
		return buttonGPR_1;
	}

	public void setButtonGPR_1(JButton buttonGPR_1) {
		this.buttonGPR_1 = buttonGPR_1;
	}

	public JButton getButtonGPR_2() {
		return buttonGPR_2;
	}

	public void setButtonGPR_2(JButton buttonGPR_2) {
		this.buttonGPR_2 = buttonGPR_2;
	}

	public JButton getButtonGPR_3() {
		return buttonGPR_3;
	}

	public void setButtonGPR_3(JButton buttonGPR_3) {
		this.buttonGPR_3 = buttonGPR_3;
	}

	public JRadioButton getRadioButton_63() {
		return radioButton_63;
	}

	public void setRadioButton_63(JRadioButton radioButton_63) {
		this.radioButton_63 = radioButton_63;
	}

	public JRadioButton getRadioButton_64() {
		return radioButton_64;
	}

	public void setRadioButton_64(JRadioButton radioButton_64) {
		this.radioButton_64 = radioButton_64;
	}

	public JRadioButton getRadioButton_65() {
		return radioButton_65;
	}

	public void setRadioButton_65(JRadioButton radioButton_65) {
		this.radioButton_65 = radioButton_65;
	}

	public JRadioButton getRadioButton_66() {
		return radioButton_66;
	}

	public void setRadioButton_66(JRadioButton radioButton_66) {
		this.radioButton_66 = radioButton_66;
	}

	public JRadioButton getRadioButton_67() {
		return radioButton_67;
	}

	public void setRadioButton_67(JRadioButton radioButton_67) {
		this.radioButton_67 = radioButton_67;
	}

	public JRadioButton getRadioButton_68() {
		return radioButton_68;
	}

	public void setRadioButton_68(JRadioButton radioButton_68) {
		this.radioButton_68 = radioButton_68;
	}

	public JRadioButton getRadioButton_69() {
		return radioButton_69;
	}

	public void setRadioButton_69(JRadioButton radioButton_69) {
		this.radioButton_69 = radioButton_69;
	}

	public JRadioButton getRadioButton_70() {
		return radioButton_70;
	}

	public void setRadioButton_70(JRadioButton radioButton_70) {
		this.radioButton_70 = radioButton_70;
	}

	public JRadioButton getRadioButton_71() {
		return radioButton_71;
	}

	public void setRadioButton_71(JRadioButton radioButton_71) {
		this.radioButton_71 = radioButton_71;
	}

	public JRadioButton getRadioButton_72() {
		return radioButton_72;
	}

	public void setRadioButton_72(JRadioButton radioButton_72) {
		this.radioButton_72 = radioButton_72;
	}

	public JRadioButton getRadioButton_73() {
		return radioButton_73;
	}

	public void setRadioButton_73(JRadioButton radioButton_73) {
		this.radioButton_73 = radioButton_73;
	}

	public JRadioButton getRadioButton_74() {
		return radioButton_74;
	}

	public void setRadioButton_74(JRadioButton radioButton_74) {
		this.radioButton_74 = radioButton_74;
	}

	public JRadioButton getRadioButton_75() {
		return radioButton_75;
	}

	public void setRadioButton_75(JRadioButton radioButton_75) {
		this.radioButton_75 = radioButton_75;
	}

	public JRadioButton getRadioButton_76() {
		return radioButton_76;
	}

	public void setRadioButton_76(JRadioButton radioButton_76) {
		this.radioButton_76 = radioButton_76;
	}

	public JRadioButton getRadioButton_77() {
		return radioButton_77;
	}

	public void setRadioButton_77(JRadioButton radioButton_77) {
		this.radioButton_77 = radioButton_77;
	}

	public JRadioButton getRadioButton_78() {
		return radioButton_78;
	}

	public void setRadioButton_78(JRadioButton radioButton_78) {
		this.radioButton_78 = radioButton_78;
	}

	public JRadioButton getRadioButton_79() {
		return radioButton_79;
	}

	public void setRadioButton_79(JRadioButton radioButton_79) {
		this.radioButton_79 = radioButton_79;
	}

	public JRadioButton getRadioButton_80() {
		return radioButton_80;
	}

	public void setRadioButton_80(JRadioButton radioButton_80) {
		this.radioButton_80 = radioButton_80;
	}

	public JRadioButton getRadioButton_81() {
		return radioButton_81;
	}

	public void setRadioButton_81(JRadioButton radioButton_81) {
		this.radioButton_81 = radioButton_81;
	}

	public JRadioButton getRadioButton_82() {
		return radioButton_82;
	}

	public void setRadioButton_82(JRadioButton radioButton_82) {
		this.radioButton_82 = radioButton_82;
	}

	public JRadioButton getRadioButton_83() {
		return radioButton_83;
	}

	public void setRadioButton_83(JRadioButton radioButton_83) {
		this.radioButton_83 = radioButton_83;
	}

	public JRadioButton getRadioButton_84() {
		return radioButton_84;
	}

	public void setRadioButton_84(JRadioButton radioButton_84) {
		this.radioButton_84 = radioButton_84;
	}

	public JRadioButton getRadioButton_85() {
		return radioButton_85;
	}

	public void setRadioButton_85(JRadioButton radioButton_85) {
		this.radioButton_85 = radioButton_85;
	}

	public JRadioButton getRadioButton_86() {
		return radioButton_86;
	}

	public void setRadioButton_86(JRadioButton radioButton_86) {
		this.radioButton_86 = radioButton_86;
	}

	public JRadioButton getRadioButton_87() {
		return radioButton_87;
	}

	public void setRadioButton_87(JRadioButton radioButton_87) {
		this.radioButton_87 = radioButton_87;
	}

	public JRadioButton getRadioButton_88() {
		return radioButton_88;
	}

	public void setRadioButton_88(JRadioButton radioButton_88) {
		this.radioButton_88 = radioButton_88;
	}

	public JRadioButton getRadioButton_89() {
		return radioButton_89;
	}

	public void setRadioButton_89(JRadioButton radioButton_89) {
		this.radioButton_89 = radioButton_89;
	}

	public JRadioButton getRadioButton_90() {
		return radioButton_90;
	}

	public void setRadioButton_90(JRadioButton radioButton_90) {
		this.radioButton_90 = radioButton_90;
	}

	public JRadioButton getRadioButton_91() {
		return radioButton_91;
	}

	public void setRadioButton_91(JRadioButton radioButton_91) {
		this.radioButton_91 = radioButton_91;
	}

	public JRadioButton getRadioButton_92() {
		return radioButton_92;
	}

	public void setRadioButton_92(JRadioButton radioButton_92) {
		this.radioButton_92 = radioButton_92;
	}

	public JRadioButton getRadioButton_93() {
		return radioButton_93;
	}

	public void setRadioButton_93(JRadioButton radioButton_93) {
		this.radioButton_93 = radioButton_93;
	}

	public JRadioButton getRadioButton_94() {
		return radioButton_94;
	}

	public void setRadioButton_94(JRadioButton radioButton_94) {
		this.radioButton_94 = radioButton_94;
	}

	public JRadioButton getRadioButton_95() {
		return radioButton_95;
	}

	public void setRadioButton_95(JRadioButton radioButton_95) {
		this.radioButton_95 = radioButton_95;
	}

	public JRadioButton getRadioButton_96() {
		return radioButton_96;
	}

	public void setRadioButton_96(JRadioButton radioButton_96) {
		this.radioButton_96 = radioButton_96;
	}

	public JRadioButton getRadioButton_97() {
		return radioButton_97;
	}

	public void setRadioButton_97(JRadioButton radioButton_97) {
		this.radioButton_97 = radioButton_97;
	}

	public JRadioButton getRadioButton_98() {
		return radioButton_98;
	}

	public void setRadioButton_98(JRadioButton radioButton_98) {
		this.radioButton_98 = radioButton_98;
	}

	public JRadioButton getRadioButton_99() {
		return radioButton_99;
	}

	public void setRadioButton_99(JRadioButton radioButton_99) {
		this.radioButton_99 = radioButton_99;
	}

	public JRadioButton getRadioButton_100() {
		return radioButton_100;
	}

	public void setRadioButton_100(JRadioButton radioButton_100) {
		this.radioButton_100 = radioButton_100;
	}

	public JRadioButton getRadioButton_101() {
		return radioButton_101;
	}

	public void setRadioButton_101(JRadioButton radioButton_101) {
		this.radioButton_101 = radioButton_101;
	}

	public JRadioButton getRadioButton_102() {
		return radioButton_102;
	}

	public void setRadioButton_102(JRadioButton radioButton_102) {
		this.radioButton_102 = radioButton_102;
	}

	public JRadioButton getRadioButton_103() {
		return radioButton_103;
	}

	public void setRadioButton_103(JRadioButton radioButton_103) {
		this.radioButton_103 = radioButton_103;
	}

	public JRadioButton getRadioButton_104() {
		return radioButton_104;
	}

	public void setRadioButton_104(JRadioButton radioButton_104) {
		this.radioButton_104 = radioButton_104;
	}

	public JRadioButton getRadioButton_105() {
		return radioButton_105;
	}

	public void setRadioButton_105(JRadioButton radioButton_105) {
		this.radioButton_105 = radioButton_105;
	}

	public JRadioButton getRadioButton_106() {
		return radioButton_106;
	}

	public void setRadioButton_106(JRadioButton radioButton_106) {
		this.radioButton_106 = radioButton_106;
	}

	public JRadioButton getRadioButton_107() {
		return radioButton_107;
	}

	public void setRadioButton_107(JRadioButton radioButton_107) {
		this.radioButton_107 = radioButton_107;
	}

	public JRadioButton getRadioButton_108() {
		return radioButton_108;
	}

	public void setRadioButton_108(JRadioButton radioButton_108) {
		this.radioButton_108 = radioButton_108;
	}

	public JRadioButton getRadioButton_109() {
		return radioButton_109;
	}

	public void setRadioButton_109(JRadioButton radioButton_109) {
		this.radioButton_109 = radioButton_109;
	}

	public JRadioButton getRadioButton_110() {
		return radioButton_110;
	}

	public void setRadioButton_110(JRadioButton radioButton_110) {
		this.radioButton_110 = radioButton_110;
	}

	public JButton getButtonIX_1() {
		return buttonIX_1;
	}

	public void setButtonIX_1(JButton buttonIX_1) {
		this.buttonIX_1 = buttonIX_1;
	}

	public JButton getButtonIX_2() {
		return buttonIX_2;
	}

	public void setButtonIX_2(JButton buttonIX_2) {
		this.buttonIX_2 = buttonIX_2;
	}

	public JButton getButtonIX_3() {
		return buttonIX_3;
	}

	public void setButtonIX_3(JButton buttonIX_3) {
		this.buttonIX_3 = buttonIX_3;
	}

	public JButton getButtonMAR() {
		return buttonMAR;
	}

	public void setButtonMAR(JButton buttonMAR) {
		this.buttonMAR = buttonMAR;
	}

	public JButton getButtonMBR() {
		return buttonMBR;
	}

	public void setButtonMBR(JButton buttonMBR) {
		this.buttonMBR = buttonMBR;
	}

	public JButton getButtonIR() {
		return buttonIR;
	}

	public void setButtonIR(JButton buttonIR) {
		this.buttonIR = buttonIR;
	}

	public JButton getButtonPC() {
		return buttonPC;
	}

	public void setButtonPC(JButton buttonPC) {
		this.buttonPC = buttonPC;
	}

	public JButton getButtonIPL() {
		return buttonIPL;
	}

	public void setButtonIPL(JButton buttonIPL) {
		this.buttonIPL = buttonIPL;
	}

	public JButton getButtonRUN() {
		return buttonRUN;
	}

	public void setButtonRUN(JButton buttonRUN) {
		this.buttonRUN = buttonRUN;
	}

	public JButton getButtonSTEP() {
		return buttonSTEP;
	}

	public void setButtonSTEP(JButton buttonSTEP) {
		this.buttonSTEP = buttonSTEP;
	}

	public JButton getButtonHLT() {
		return buttonHLT;
	}

	public void setButtonHLT(JButton buttonHLT) {
		this.buttonHLT = buttonHLT;
	}

	public ControlButton getCtrlButton() {
		return ctrlButton;
	}

	public void setCtrlButton(ControlButton ctrlButton) {
		this.ctrlButton = ctrlButton;
	}

	public boolean isFlagIPL() {
		return flagIPL;
	}

	public void setFlagIPL(boolean flagIPL) {
		this.flagIPL = flagIPL;
	}
	

	public JTextField getTextFieldADD() {
		return textFieldADD;
	}

	public void setTextFieldADD(JTextField textFieldADD) {
		this.textFieldADD = textFieldADD;
	}

	public JTextField getTextFieldDATA() {
		return textFieldDATA;
	}

	public void setTextField_DATA(JTextField textFieldDATA) {
		this.textFieldDATA = textFieldDATA;
	}

	public JButton getButtonLOAD() {
		return buttonLOAD;
	}

	public void setButtonLOAD(JButton buttonLOAD) {
		this.buttonLOAD = buttonLOAD;
	}

	public JButton getButtonSTORE() {
		return buttonSTORE;
	}

	public void setButtonSTORE(JButton buttonSTORE) {
		this.buttonSTORE = buttonSTORE;
	}


	public JTextField getTextFieldINSTRUCTION() {
		return textFieldINSTRUCTION;
	}

	public void setTextFieldINSTRUCTION(JTextField textFieldINSTRUCTION) {
		this.textFieldINSTRUCTION = textFieldINSTRUCTION;
	}
}
