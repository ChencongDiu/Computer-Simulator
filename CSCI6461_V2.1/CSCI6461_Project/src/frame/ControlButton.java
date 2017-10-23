package frame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import constant.Constant;
import cpu.CPU;
import memory.Memory;

public class ControlButton {
	
	//
	private String strEmptyText = Constant.CONST_EMPTY_TEXT;
	private String strAllZero = Constant.CONST_ALL_ZERO;
	
	//GPR list
	private List<JRadioButton> list_GPR_0 = null;
	private List<JRadioButton> list_GPR_1 = null;
	private List<JRadioButton> list_GPR_2 = null;
	private List<JRadioButton> list_GPR_3 = null;
	
	//IX list
	private List<JRadioButton> list_IX_1 = null;
	private List<JRadioButton> list_IX_2 = null;
	private List<JRadioButton> list_IX_3 = null;
	
	private ControlPanel panel;
	
	private CPU cpu;
	
	private Memory memory;
	
	public ControlButton (ControlPanel panel, Memory memory) {
		this.panel = panel;
		this.memory = memory;
		buttonList();
		cpu = new CPU(this.panel, this.memory, this);
	}

	/**
	 * add buttons into lists
	 */
	private void buttonList() {
		
		list_GPR_0 = new ArrayList<JRadioButton>();
		list_GPR_1 = new ArrayList<JRadioButton>();
		list_GPR_2 = new ArrayList<JRadioButton>();
		list_GPR_3 = new ArrayList<JRadioButton>();
		
		list_IX_1 = new ArrayList<JRadioButton>();
		list_IX_2 = new ArrayList<JRadioButton>();
		list_IX_3 = new ArrayList<JRadioButton>();
		
		//add buttons into GPR_0
		list_GPR_0.add(panel.getRdbtnNewRadioButton());
		list_GPR_0.add(panel.getRadioButton());
		list_GPR_0.add(panel.getRadioButton_1());
		list_GPR_0.add(panel.getRadioButton_2());
		list_GPR_0.add(panel.getRadioButton_3());
		list_GPR_0.add(panel.getRadioButton_4());
		list_GPR_0.add(panel.getRadioButton_5());
		list_GPR_0.add(panel.getRadioButton_6());
		list_GPR_0.add(panel.getRadioButton_7());
		list_GPR_0.add(panel.getRadioButton_8());
		list_GPR_0.add(panel.getRadioButton_9());
		list_GPR_0.add(panel.getRadioButton_10());
		list_GPR_0.add(panel.getRadioButton_11());
		list_GPR_0.add(panel.getRadioButton_12());
		list_GPR_0.add(panel.getRadioButton_13());
		list_GPR_0.add(panel.getRadioButton_14());
		
		//add buttons into GPR_1
		list_GPR_1.add(panel.getRadioButton_15());
		list_GPR_1.add(panel.getRadioButton_16());
		list_GPR_1.add(panel.getRadioButton_17());
		list_GPR_1.add(panel.getRadioButton_18());
		list_GPR_1.add(panel.getRadioButton_19());
		list_GPR_1.add(panel.getRadioButton_20());
		list_GPR_1.add(panel.getRadioButton_21());
		list_GPR_1.add(panel.getRadioButton_22());
		list_GPR_1.add(panel.getRadioButton_23());
		list_GPR_1.add(panel.getRadioButton_24());
		list_GPR_1.add(panel.getRadioButton_25());
		list_GPR_1.add(panel.getRadioButton_26());
		list_GPR_1.add(panel.getRadioButton_27());
		list_GPR_1.add(panel.getRadioButton_28());
		list_GPR_1.add(panel.getRadioButton_29());
		list_GPR_1.add(panel.getRadioButton_30());
		
		//add buttons into GPR_2
		list_GPR_2.add(panel.getRadioButton_31());
		list_GPR_2.add(panel.getRadioButton_32());
		list_GPR_2.add(panel.getRadioButton_33());
		list_GPR_2.add(panel.getRadioButton_34());
		list_GPR_2.add(panel.getRadioButton_35());
		list_GPR_2.add(panel.getRadioButton_36());
		list_GPR_2.add(panel.getRadioButton_37());
		list_GPR_2.add(panel.getRadioButton_38());
		list_GPR_2.add(panel.getRadioButton_39());
		list_GPR_2.add(panel.getRadioButton_40());
		list_GPR_2.add(panel.getRadioButton_41());
		list_GPR_2.add(panel.getRadioButton_42());
		list_GPR_2.add(panel.getRadioButton_43());
		list_GPR_2.add(panel.getRadioButton_44());
		list_GPR_2.add(panel.getRadioButton_45());
		list_GPR_2.add(panel.getRadioButton_46());
		
		//add buttons into GPR_3
		list_GPR_3.add(panel.getRadioButton_47());
		list_GPR_3.add(panel.getRadioButton_48());
		list_GPR_3.add(panel.getRadioButton_49());
		list_GPR_3.add(panel.getRadioButton_50());
		list_GPR_3.add(panel.getRadioButton_51());
		list_GPR_3.add(panel.getRadioButton_52());
		list_GPR_3.add(panel.getRadioButton_53());
		list_GPR_3.add(panel.getRadioButton_54());
		list_GPR_3.add(panel.getRadioButton_55());
		list_GPR_3.add(panel.getRadioButton_56());
		list_GPR_3.add(panel.getRadioButton_57());
		list_GPR_3.add(panel.getRadioButton_58());
		list_GPR_3.add(panel.getRadioButton_59());
		list_GPR_3.add(panel.getRadioButton_60());
		list_GPR_3.add(panel.getRadioButton_61());
		list_GPR_3.add(panel.getRadioButton_62());
		
		//add buttons into IX_1
		list_IX_1.add(panel.getRadioButton_63());
		list_IX_1.add(panel.getRadioButton_64());
		list_IX_1.add(panel.getRadioButton_65());
		list_IX_1.add(panel.getRadioButton_66());
		list_IX_1.add(panel.getRadioButton_67());
		list_IX_1.add(panel.getRadioButton_68());
		list_IX_1.add(panel.getRadioButton_69());
		list_IX_1.add(panel.getRadioButton_70());
		list_IX_1.add(panel.getRadioButton_71());
		list_IX_1.add(panel.getRadioButton_72());
		list_IX_1.add(panel.getRadioButton_73());
		list_IX_1.add(panel.getRadioButton_74());
		list_IX_1.add(panel.getRadioButton_75());
		list_IX_1.add(panel.getRadioButton_76());
		list_IX_1.add(panel.getRadioButton_77());
		list_IX_1.add(panel.getRadioButton_78());
		
		//add buttons into IX_2
		list_IX_2.add(panel.getRadioButton_79());
		list_IX_2.add(panel.getRadioButton_80());
		list_IX_2.add(panel.getRadioButton_81());
		list_IX_2.add(panel.getRadioButton_82());
		list_IX_2.add(panel.getRadioButton_83());
		list_IX_2.add(panel.getRadioButton_84());
		list_IX_2.add(panel.getRadioButton_85());
		list_IX_2.add(panel.getRadioButton_86());
		list_IX_2.add(panel.getRadioButton_87());
		list_IX_2.add(panel.getRadioButton_88());
		list_IX_2.add(panel.getRadioButton_89());
		list_IX_2.add(panel.getRadioButton_90());
		list_IX_2.add(panel.getRadioButton_91());
		list_IX_2.add(panel.getRadioButton_92());
		list_IX_2.add(panel.getRadioButton_93());
		list_IX_2.add(panel.getRadioButton_94());
		
		//add buttons into IX_3
		list_IX_3.add(panel.getRadioButton_95());
		list_IX_3.add(panel.getRadioButton_96());
		list_IX_3.add(panel.getRadioButton_97());
		list_IX_3.add(panel.getRadioButton_98());
		list_IX_3.add(panel.getRadioButton_99());
		list_IX_3.add(panel.getRadioButton_100());
		list_IX_3.add(panel.getRadioButton_101());
		list_IX_3.add(panel.getRadioButton_102());
		list_IX_3.add(panel.getRadioButton_103());
		list_IX_3.add(panel.getRadioButton_104());
		list_IX_3.add(panel.getRadioButton_105());
		list_IX_3.add(panel.getRadioButton_106());
		list_IX_3.add(panel.getRadioButton_107());
		list_IX_3.add(panel.getRadioButton_108());
		list_IX_3.add(panel.getRadioButton_109());
		list_IX_3.add(panel.getRadioButton_110());
	}
	
	/**
	 * IPL
	 * enable/unenable all buttons
	 */
	public boolean IPL(boolean flagIPL) {
		
		//clear up all textfield
		panel.getTextFieldGPR_0().setText(strEmptyText);
		panel.getTextFieldGPR_1().setText(strEmptyText);
		panel.getTextFieldGPR_2().setText(strEmptyText);
		panel.getTextFieldGPR_3().setText(strEmptyText);
		panel.getTextFieldIX_1().setText(strEmptyText);
		panel.getTextFieldIX_2().setText(strEmptyText);
		panel.getTextFieldIX_3().setText(strEmptyText);
		panel.getTextFieldMAR().setText(strEmptyText);
		panel.getTextFieldMBR().setText(strEmptyText);
		panel.getTextFieldIR().setText(strEmptyText);
		panel.getTextFieldPC().setText(strEmptyText);
		panel.getTextFieldADD().setText(strEmptyText);
		panel.getTextFieldDATA().setText(strEmptyText);
		panel.getTextFieldINSTRUCTION().setText(strEmptyText);
		
		//enable all rbts
		for (JRadioButton jrb: list_GPR_0)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_GPR_1)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_GPR_2)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_GPR_3)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_IX_1)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_IX_2)
			jrb.setEnabled(!flagIPL);
		for (JRadioButton jrb: list_IX_3)
			jrb.setEnabled(!flagIPL);
		
		//enable all textfields
		panel.getTextFieldGPR_0().setEnabled(!flagIPL);
		panel.getTextFieldGPR_1().setEnabled(!flagIPL);
		panel.getTextFieldGPR_2().setEnabled(!flagIPL);
		panel.getTextFieldGPR_3().setEnabled(!flagIPL);
		panel.getTextFieldIX_1().setEnabled(!flagIPL);
		panel.getTextFieldIX_2().setEnabled(!flagIPL);
		panel.getTextFieldIX_3().setEnabled(!flagIPL);
		panel.getTextFieldMAR().setEnabled(!flagIPL);
		panel.getTextFieldMBR().setEnabled(!flagIPL);
		panel.getTextFieldIR().setEnabled(!flagIPL);
		panel.getTextFieldPC().setEnabled(!flagIPL);
		panel.getTextFieldADD().setEnabled(!flagIPL);
		panel.getTextFieldDATA().setEnabled(!flagIPL);
		panel.getTextFieldINSTRUCTION().setEnabled(!flagIPL);
		
		//enable all buttons
		panel.getButtonGPR_0().setEnabled(!flagIPL);
		panel.getButtonGPR_1().setEnabled(!flagIPL);
		panel.getButtonGPR_2().setEnabled(!flagIPL);
		panel.getButtonGPR_3().setEnabled(!flagIPL);
		panel.getButtonIX_1().setEnabled(!flagIPL);
		panel.getButtonIX_2().setEnabled(!flagIPL);
		panel.getButtonIX_3().setEnabled(!flagIPL);
		panel.getButtonMAR().setEnabled(!flagIPL);
		panel.getButtonMBR().setEnabled(!flagIPL);
		panel.getButtonIR().setEnabled(!flagIPL);
		panel.getButtonPC().setEnabled(!flagIPL);
		//panel.getButtonIPL().setEnabled(!flagIPL);
		//panel.getButtonRUN().setEnabled(!flagIPL);
		panel.getButtonSTEP().setEnabled(!flagIPL);
		panel.getButtonHLT().setEnabled(!flagIPL);
		panel.getButtonLOAD().setEnabled(!flagIPL);
		panel.getButtonSTORE().setEnabled(!flagIPL);
		
		return !flagIPL;
	}

	/**
	 * HLT
	 * clear up all text fields, unselected all rbts
	 */
	public void HLT() {
		panel.getTextFieldMAR().setText(strEmptyText);
		panel.getTextFieldMBR().setText(strEmptyText);
		panel.getTextFieldIR().setText(strEmptyText);
		panel.getTextFieldPC().setText(strEmptyText);
		rbtSwitch(list_GPR_0, strAllZero);
		rbtSwitch(list_GPR_1, strAllZero);
		rbtSwitch(list_GPR_2, strAllZero);
		rbtSwitch(list_GPR_3, strAllZero);
		rbtSwitch(list_IX_1, strAllZero);
		rbtSwitch(list_IX_2, strAllZero);
		rbtSwitch(list_IX_3, strAllZero);
	}

	/**
	 * switch rbts according to string:
	 *   0 -> unselected
	 * 1-9 -> selected
	 * only last 16-bits are valid, ignore the rest part
	 * if instruction is less than 16-bits, 0 will be added
	 * 0101001 = 0000000000101001
	 */
	private void rbtSwitch(List<JRadioButton> rbtList, String instruction) {
		String temp = instruction;
		instruction = strAllZero + instruction;
		instruction = instruction.substring(temp.length());
		
		char[] strArray = instruction.toCharArray();
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] == '0')
				rbtList.get(i).setSelected(false);
			else
				rbtList.get(i).setSelected(true);
		}
	}
	
	/**
	 * 
	 * @param rbtListName
	 * @param instruction
	 */
	public void rbtSwitch(String rbtListName, String instruction) {
		List<JRadioButton> rbtList = null;
		
		switch (rbtListName) {
		case Constant.CONST_GPR_0:
			rbtList = list_GPR_0;
			break;
		case Constant.CONST_GPR_1:
			rbtList = list_GPR_1;
			break;
		case Constant.CONST_GPR_2:
			rbtList = list_GPR_2;
			break;
		case Constant.CONST_GPR_3:
			rbtList = list_GPR_3;
			break;
		case Constant.CONST_IX_1:
			rbtList = list_IX_1;
			break;
		case Constant.CONST_IX_2:
			rbtList = list_IX_2;
			break;
		case Constant.CONST_IX_3:
			rbtList = list_IX_3;
			break;
		default:
			break;
		}
		rbtSwitch(rbtList, instruction);
	}

	/**
	 * store text instruction to memory and switch rbts
	 * @param text (instruction)
	 * @param rbsListName (chosen rbt list)
	 */
	public void Set(String instruction, String rbtsListName) {
		
		instruction = switchStringToBinary(instruction);
		
		switch (rbtsListName) {
		case Constant.CONST_GPR_0:
			cpu.setGPR_0(instruction);
			System.out.println("Set " + instruction + " to GPR_0");
			break;
		case Constant.CONST_GPR_1:
			cpu.setGPR_1(instruction);
			System.out.println("Set " + instruction + " to GPR_1");
			break;
		case Constant.CONST_GPR_2:
			cpu.setGPR_2(instruction);
			System.out.println("Set " + instruction + " to GPR_2");
			break;
		case Constant.CONST_GPR_3:
			cpu.setGPR_3(instruction);
			System.out.println("Set " + instruction + " to GPR_3");
			break;
		default:
			break;
		}
		
		//switch rbts
		rbtSwitch(rbtsListName, instruction);
	}

	private String switchStringToBinary(String instruction) {
		String temp = instruction;
		instruction = Constant.CONST_ALL_ZERO + instruction;
		instruction = instruction.substring(temp.length());
		
		char[] charData = instruction.toCharArray();
		for (int i = 0; i < charData.length; i++) {
			if (charData[i] != '0')
				charData[i] = '1';
		}
		instruction = String.valueOf(charData);
		return instruction;
	}

	public void STEP(String strInstruction) {
		cpu.execute(strInstruction);
	}
}
