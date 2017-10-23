package cpu;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;
import frame.ControlButton;
import frame.ControlPanel;
import memory.Memory;

public class CPU {
	//program counter, increment = 1
	private int PC;
	
	public String getGPR_0() {
		return GPR_0;
	}

	public void setGPR_0(String gPR_0) {
		GPR_0 = gPR_0;
	}

	public String getGPR_1() {
		return GPR_1;
	}

	public void setGPR_1(String gPR_1) {
		GPR_1 = gPR_1;
	}

	public String getGPR_2() {
		return GPR_2;
	}

	public void setGPR_2(String gPR_2) {
		GPR_2 = gPR_2;
	}

	public String getGPR_3() {
		return GPR_3;
	}

	public void setGPR_3(String gPR_3) {
		GPR_3 = gPR_3;
	}
	
	public String getCC() {
		return CC;
	}

	public void setCC(String cC) {
		CC = cC;
	}

	//condition code
	private String CC;
	
	//4 GPRs, general purpose registers
	private String GPR_0;
	private String GPR_1;
	private String GPR_2;
	private String GPR_3;
	
	//3 IXs
	private String IX_1;
	private String IX_2;
	private String IX_3;
	
	private ControlPanel panel;
	
	private ControlButton ctrlButton;
	
	private Memory memory;
	
	private String instr;
	
	public CPU(ControlPanel panel, Memory memory, ControlButton ctrlButton) {
		this.ctrlButton = ctrlButton;
		this.panel = panel;
		this.memory = memory;
		System.out.println("CPU initiated!");
		initCPU();
	}

	private void initCPU() {
		PC = 1;
		GPR_0 = Constant.CONST_ALL_ZERO;
		GPR_1 = Constant.CONST_ALL_ZERO;
		GPR_2 = Constant.CONST_ALL_ZERO;
		GPR_3 = Constant.CONST_ALL_ZERO;
		IX_1 = Constant.CONST_ALL_ZERO;
		IX_2 = Constant.CONST_ALL_ZERO;
		IX_3 = Constant.CONST_ALL_ZERO;
	}
	
	/**
	 * execute input instruction
	 * @param strInstruction
	 */
	public void execute(String strInstruction) {
		this.instr = strInstruction;
		if (strInstruction.length() == 16) {
			//instructionList holds opcode, GPR, IX, I, address
			List<String> instructionList = null;
			List<String> shiftinstructionList = null;
			
			strInstruction = switchStringToBinary(strInstruction);
			instructionList = decodeInstruction(strInstruction);
			shiftinstructionList = decodeShiftInstruction(strInstruction);
			
			switch (instructionList.get(0)) {
			case Constant.CONST_HLT:
				executeHLT(instructionList);
				break;
			case Constant.CONST_TRAP:
				executeTRAP(instructionList);
				break;
			case Constant.CONST_LDR:
				executeLDR(instructionList);
				break;
			case Constant.CONST_STR:
				executeSTR(instructionList);
				break;
			case Constant.CONST_LDA:
				executeLDA(instructionList);
				break;
			case Constant.CONST_LDX:
				executeLDX(instructionList);
				break;
			case Constant.CONST_STX:
				executeSTX(instructionList);
				break;
			case Constant.CONST_JZ:
				executeJZ(instructionList);
				break;
			case Constant.CONST_JNE:
				executeJNE(instructionList);
				break;
			case Constant.CONST_JCC:
				executeJCC(instructionList);
				break;
			case Constant.CONST_JMA:
				executeJMA(instructionList);
				break;
			case Constant.CONST_JSR:
				executeJSR(instructionList);
				break;
			case Constant.CONST_RFS:
				executeRFS(instructionList);
				break;
			case Constant.CONST_SOB:
				executeSOB(instructionList);
				break;
			case Constant.CONST_JGE:
				executeJGE(instructionList);
				break;
			case Constant.CONST_AMR:
				executeAMR(instructionList);
				break;
			case Constant.CONST_SMR:
				executeSMR(instructionList);
				break;
			case Constant.CONST_AIR:
				executeAIR(instructionList);
				break;
			case Constant.CONST_SIR:
				executeSIR(instructionList);
				break;
			case Constant.CONST_MLT:
				executeMLT(instructionList);
				break;
			case Constant.CONST_AND:
				executeAND(instructionList);
				break;
			case Constant.CONST_ORR:
				executeORR(instructionList);
				break;
			case Constant.CONST_NOT:
				executeNOT(instructionList);
				break;
			case Constant.CONST_SRC:
				executeSRC(shiftinstructionList);
				break;
			case Constant.CONST_RRC:
				executeRRC(shiftinstructionList);
				break;
			default:
				break;
			}
			
		} else {
			System.out.println("ERROR: Instruction format invalid!");
		}
	}
	/**
	 * MLT rx,ry
	 * Multiply Register by Register
	 * rx, rx+1 <- c(rx) * c(ry)
	 * rx must be 0 or 2
	 * ry must be 0 or 2
	 * rx contains the high order bits, rx+1 contains the 
	 * low order bits of the result
	 * Set OVERFLOW flag, if overflow
	 * 
	 * @param instructionList
	 */
	private void executeMLT(List<String> instructionList) {
		//divide instruction
		String Rx = instructionList.get(1);
		String Ry = instructionList.get(2);
		//String I = instructionList.get(3);
		//String address = instructionList.get(4);
		
		//get EA
		//int intEA = EA(I, IX, address);
		//System.out.println("EA: " + intEA);
		
		List<String> ccList = new ArrayList<String>();
		ccList = tranCC(CC);
		
		switch (Rx) {
		case Constant.CONST_00:
			int intGPR_0 = Integer.parseInt(GPR_0, 2);
			switch (Ry) {
			case Constant.CONST_10:
				int intGPR_2 = Integer.parseInt(GPR_2, 2);
				int intResult = intGPR_0 * intGPR_2;
				String strResult = Integer.toBinaryString(intResult);
				strResult = (Constant.CONST_32_ZERO + strResult).substring(strResult.length());
				GPR_0 = strResult.substring(0, 16);
				GPR_1 = strResult.substring(16);
				System.out.println("Result: " + intResult);
				System.out.println("GPR_0: " + GPR_0);
				System.out.println("GPR_1: " + GPR_1);
				if (intResult > 4095) {
					ccList.set(0, "1");
					ccList.set(1, "0");
					ccList.set(2, "0");
					ccList.set(3, "0");
					CC = tranCC(ccList);
					System.out.println("Overflow! CC: " + CC);
				}
				break;
			default:
				break;
			}
		case Constant.CONST_10:
			int intGPR_2 = Integer.parseInt(GPR_2, 2);
			switch (Ry) {
			case Constant.CONST_00:
				int intGPR_0_1 = Integer.parseInt(GPR_0, 2);
				int intResult = intGPR_0_1 * intGPR_2;
				String strResult = Integer.toBinaryString(intResult);
				strResult = (Constant.CONST_32_ZERO + strResult).substring(strResult.length());
				GPR_2 = strResult.substring(0, 16);
				GPR_3 = strResult.substring(16);
				System.out.println("Result: " + intResult);
				System.out.println("GPR_2: " + GPR_2);
				System.out.println("GPR_3: " + GPR_3);
				if (intResult > 4095) {
					ccList.set(0, "1");
					ccList.set(1, "0");
					ccList.set(2, "0");
					ccList.set(3, "0");
					CC = tranCC(ccList);
					System.out.println("Overflow! CC: " + CC);
				}
				break;
			default:
				break;
			}
		default:
			break;
		}
		PC++;
		showCPU(0, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * transfer ccList to CC 
	 * 
	 * @param ccList
	 * @return
	 */
	private String tranCC(List<String> ccList) {
		String returnCC = "";
		for (String c: ccList)
			returnCC += c;
		return returnCC;
	}

	/**
	 * JGE r,x, address[,I]
	 * Jump Greater Than or Equal To:
	 * If c(r) >= 0, then PC <- EA or c(EA) , if I bit set;
	 * Else PC <- PC + 1
	 * 
	 * @param instructionList
	 */
	private void executeJGE(List<String> instructionList) {
		//divide instruction
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		
		switch (R) {
		case Constant.CONST_00:
			if (Integer.parseInt(GPR_0, 2) > 0)
				PC = intEA;
			else
				PC++;
			break;
		case Constant.CONST_01:
			if (Integer.parseInt(GPR_1, 2) > 0)
				PC = intEA;
			else
				PC++;
			break;
		case Constant.CONST_10:
			if (Integer.parseInt(GPR_2, 2) > 0)
				PC = intEA;
			else
				PC++;
			break;
		case Constant.CONST_11:
			if (Integer.parseInt(GPR_3, 2) > 0)
				PC = intEA;
			else
				PC++;
			break;
		default:
			break;
		}
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * SOB r, x, address[,I]
	 * Subtract One and Branch. R = 0..3
	 * r<-c(r) �C 1
	 * If c(r) > 0,  PC <- EA; but PC<-c(EA), if I bit set;
	 * Else PC <- PC + 1
	 * 
	 * @param instructionList
	 */
	private void executeSOB(List<String> instructionList) {
		//divide instruction
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		
		//execute
		int intGPR = 0;
		switch (R) {
		case Constant.CONST_00:
			intGPR = Integer.parseInt(GPR_0, 2) - 1;
			GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR));
			System.out.println("GPR_0: " + GPR_0);
			if (intGPR > 0)
				PC = intEA;
			else 
				PC++;
			break;
		case Constant.CONST_01:
			intGPR = Integer.parseInt(GPR_1, 2) - 1;
			GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR));
			System.out.println("GPR_1: " + GPR_1);
			if (intGPR > 0)
				PC = intEA;
			else 
				PC++;
			break;
		case Constant.CONST_10:
			intGPR = Integer.parseInt(GPR_2, 2) - 1;
			GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR));
			System.out.println("GPR_2: " + GPR_2);
			if (intGPR > 0)
				PC = intEA;
			else 
				PC++;
			break;
		case Constant.CONST_11:
			intGPR = Integer.parseInt(GPR_3, 2) - 1;
			GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR));
			System.out.println("GPR_3: " + GPR_3);
			if (intGPR > 0)
				PC = intEA;
			else 
				PC++;
			break;
		default:
			break;
		}
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * RFS Immed
	 * R0<-Immed; PC<-c(R3)
	 * IX, I fields are ignored.
	 * 
	 * @param instructionList
	 */
	private void executeRFS(List<String> instructionList) {
		//divide instruction
		//String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		
		String immed = address;
		GPR_0 = (Constant.CONST_ALL_ZERO + address).substring(immed.length());
		System.out.println("GPR_0: " + GPR_0);
		PC = Integer.parseInt(GPR_3, 2);
		
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * JSR x, address[,I]
	 * Jump and Save Return Address:
	 * R3<-PC+1;
	 * PC<-EA or PC<-c(EA), if I bit set
	 * R0 should contain pointer to arguments
	 * Argument list should end with �C17777 value
	 * 
	 * @param instructionList
	 */
	private void executeJSR(List<String> instructionList) {
		//divide instruction
		//String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		
		//execute
		int intGPR_3 = PC + 1;
		GPR_3 = Integer.toBinaryString(intGPR_3);
		PC = intEA;
		
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * JMA x, address[,I]
	 * Unconditional Jump To Address
	 * PC <- EA, if I bit not set; PC<-c(EA), if I bit set
	 * Note: r is ignored in this instruction
	 * 
	 * @param instructionList
	 */
	private void executeJMA(List<String> instructionList) {
		//divide instruction
		//String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		
		//execute
		PC = intEA;
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	/*
	 * JNE
	 * JNE r, x, address[,I]
	 * Jump If NOT EQUAL
	 * If c(r) != 0, then PC <--EA 
	 * Else PC <- PC+1
	 */
	private void executeJNE(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			if (!GPR_0.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			System.out.println("PC: " + PC);
			break;
		case Constant.CONST_01:
			if (!GPR_1.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_0);
			System.out.println("PC: " + PC);
			break;
		case Constant.CONST_10:
			if (!GPR_2.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			System.out.println("PC:" + PC);
			break;
		case Constant.CONST_11:
			if (!GPR_3.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			System.out.println("PC: " + PC);
			break;
		default:
			break;
		}
		//PC++ and display
		//PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	/*
	 * JZ
	 * JZ r, x, address[,I]
	 * Jump If Zero:
	 * If c(r) = 0, then PC <--EA 
	 * Else PC <- PC+1
	*/
	private void executeJZ(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			if (GPR_0.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			System.out.println("PC: " + PC);
			break;
		case Constant.CONST_01:
			if (GPR_1.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_0);
			System.out.println("PC: " + PC);
			break;
		case Constant.CONST_10:
			if (GPR_2.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			System.out.println("PC:" + PC);
			break;
		case Constant.CONST_11:
			if (GPR_3.equals(Constant.CONST_ALL_ZERO)) {
				PC = intEA;
			}else {
				PC++;
			}
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			System.out.println("PC: " + PC);
			break;
		default:
			break;
		}
		//PC++ and display
		//PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
		
	}
	/**
	 * JCC cc, x, address[,I]
	 * Jump If Condition Code
	 * cc replaces r for this instruction
	 * cc takes values 0, 1, 2, 3 as above and specifies 
	 * the bit in the Condition Code Register to check;
	 * If cc bit  = 1, PC<-EA or c(EA), if I bit set;
	 * Else PC <- PC + 1
	 * 
	 * @param instructionList
	 */
	private void executeJCC(List<String> instructionList) {
		//divide instruction
		//String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		
		List<String> ccList = new ArrayList<String>();
		ccList = tranCC(CC);
		int ccCounter = 0;
		for (String c: ccList)
			if (c.equals("1"))
				ccCounter++;
		
		//execute
		if (ccCounter != 0) {
			PC = intEA;
		} else {
			PC++;
		}
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * tansfer 4-bits cc to list
	 * 
	 * @param cc
	 * @return
	 */
	private List<String> tranCC(String cc) {
		List<String> ccList = new ArrayList<String>();
		String cc1 = cc.substring(0, 1);
		String cc2 = cc.substring(1, 2);
		String cc3 = cc.substring(2, 3);
		String cc4 = cc.substring(3, 4);
		
		ccList.add(cc1);
		ccList.add(cc2);
		ccList.add(cc3);
		ccList.add(cc4);
		
		return ccList;
	}
	/*
	 * RRC
	Rotate Register by Count
	c(r) is rotated left (L/R = 1) or right (L/R =0)
	either logically (A/L =1)
	Count = 0…15
	If Count = 0, no rotate occurs
	 */
	private void executeRRC(List<String> shiftinstructionList) {
		String R = shiftinstructionList.get(1);
		String AL = shiftinstructionList.get(2);
		String LR = shiftinstructionList.get(3);
		String count = shiftinstructionList.get(4);
		int intEA = 0;
		//System.out.println("EA: " + intEA);
		int r0 = Integer.parseInt(GPR_0,2);
		int r1 = Integer.parseInt(GPR_1,2);
		int r2 = Integer.parseInt(GPR_2,2);
		int r3 = Integer.parseInt(GPR_3,2);
		int tempCount = Integer.parseInt(count,2);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			if (AL.equals(Constant.CONST_1)||AL.equals(Constant.CONST_0)){ 	//Shift Logically
				if(LR.equals(Constant.CONST_0)){							//Shift Right
					int intGPR0 = r0 << tempCount | r0 >> (16-tempCount);
					GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
					showCPU(intEA, GPR_0, instr);
					System.out.println("GPR_0: " + GPR_0);
				}else if (LR.equals(Constant.CONST_1)) {					//Shift Left
					int intGPR0 = r0 >> tempCount | r0 << (16-tempCount);
					GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
					showCPU(intEA, GPR_0, instr);
					System.out.println("GPR_0: " + GPR_0);
				}else {
					System.out.println("Error");
				}
			}
			break;
		case Constant.CONST_01:
			if (AL.equals(Constant.CONST_1)||AL.equals(Constant.CONST_0)){ 	//Shift Logically
				if(LR.equals(Constant.CONST_0)){							//Shift Right
					int intGPR1 = r1 << tempCount | r1 >> (16-tempCount);
					GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
					showCPU(intEA, GPR_1, instr);
					System.out.println("GPR_0: " + GPR_0);
				}else if (LR.equals(Constant.CONST_1)) {					//Shift Left
					int intGPR1 = r1 >> tempCount | r1 << (16-tempCount);
					GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
					showCPU(intEA, GPR_1, instr);
					System.out.println("GPR_1: " + GPR_1);
				}else {
					System.out.println("Error");
				}
			}
			break;
		case Constant.CONST_10:
			if (AL.equals(Constant.CONST_1)||AL.equals(Constant.CONST_0)){ 	//Shift Logically
				if(LR.equals(Constant.CONST_0)){			//Shift Right
					int intGPR2 = r2 << tempCount | r2 >> (16-tempCount);
					GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
					showCPU(intEA, GPR_2, instr);
					System.out.println("GPR_2: " + GPR_2);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR2 = r2 >> tempCount | r2 << (16-tempCount);
					GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
					showCPU(intEA, GPR_2, instr);
					System.out.println("GPR_2: " + GPR_2);
				}else {
					System.out.println("Error");
				}
			}
			break;
		case Constant.CONST_11:
			if (AL.equals(Constant.CONST_1)||AL.equals(Constant.CONST_0)){ 	//Shift Logically
				if(LR.equals(Constant.CONST_0)){							//Shift Right
					int intGPR3 = r3 << tempCount | r3 >> (16-tempCount);
					GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
					showCPU(intEA, GPR_3, instr);
					System.out.println("GPR_3: " + GPR_3);
				}else if (LR.equals(Constant.CONST_1)) {					//Shift Left
					int intGPR3 = r3 >> tempCount | r3 << (16-tempCount);
					GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
					showCPU(intEA, GPR_3, instr);
					System.out.println("GPR_3: " + GPR_3);
				}else {
					System.out.println("Error");
				}
			}
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	/*
	 * SRC
	Shift Register by Count
	c(r) is shifted left (L/R =1) or right (L/R = 0) 
	either logically (A/L = 1) or arithmetically (A/L = 0)
	Count = 0…15
	If Count = 0, no shift occurs
	*/
	private void executeSRC(List<String> shiftinstructionList) {
		String R = shiftinstructionList.get(1);
		String AL = shiftinstructionList.get(2);
		String LR = shiftinstructionList.get(3);
		String count = shiftinstructionList.get(4);
		int intEA = 0;
		//System.out.println("EA: " + intEA);
		int r0 = Integer.parseInt(GPR_0,2);
		int r1 = Integer.parseInt(GPR_1,2);
		int r2 = Integer.parseInt(GPR_2,2);
		int r3 = Integer.parseInt(GPR_3,2);
		int tempCount = Integer.parseInt(count,2);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			if (AL.equals(Constant.CONST_1)){ 	//Shift Logically
					if(LR.equals(Constant.CONST_0)){	//Shift Right
						int intGPR0 = r0 >> tempCount;
						GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
						showCPU(intEA, GPR_0, instr);
						System.out.println("GPR_0: " + GPR_0);
					}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
						int intGPR0 = r0 << tempCount;
						GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
						showCPU(intEA, GPR_0, instr);
						System.out.println("GPR_0: " + GPR_0);
					}else {
						System.out.println("Error");
					}
			}else if (AL.equals(Constant.CONST_0)){		//Shift arithmetically 
					if(LR.equals(Constant.CONST_0)){	//Shift Right
						int intGPR0 = r0 >>> tempCount;
						GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
						showCPU(intEA, GPR_0, instr);
						System.out.println("GPR_0: " + GPR_0);
					}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
						int intGPR0 = r0 << tempCount;
						GPR_0 = switchStringToBinary(Integer.toBinaryString(intGPR0));
						showCPU(intEA, GPR_0, instr);
						System.out.println("GPR_0: " + GPR_0);
					}else {
						System.out.println("Error");
					}
			}
			break;
		case Constant.CONST_01:
			if (AL.equals(Constant.CONST_1)){ 	//Shift Logically
				if(LR.equals(Constant.CONST_0)){	//Shift Right
					int intGPR1 = r1 >> tempCount;
						GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
						showCPU(intEA, GPR_1, instr);
						System.out.println("GPR_1: " + GPR_1);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR1 = r1 << tempCount;
					GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
					showCPU(intEA, GPR_1, instr);
					System.out.println("GPR_1: " + GPR_1);
				}else {
					System.out.println("Error");
				}
			}else if (AL.equals(Constant.CONST_0)){		//Shift arithmetically 
				if(LR.equals(Constant.CONST_0)){	//Shift Right
					int intGPR1 = r1 >>> tempCount;
					GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
					showCPU(intEA, GPR_1, instr);
					System.out.println("GPR_1: " + GPR_1);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR1 = r1 << tempCount;
					GPR_1 = switchStringToBinary(Integer.toBinaryString(intGPR1));
					showCPU(intEA, GPR_1, instr);
					System.out.println("GPR_1: " + GPR_1);
				}else {
					System.out.println("Error");
				}
			}
			break;
		case Constant.CONST_10:
			if (AL.equals(Constant.CONST_1)){ 				//Shift Logically
				if(LR.equals(Constant.CONST_0)){			//Shift Right
					int intGPR2 = r2 >> tempCount;
						GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
						showCPU(intEA, GPR_2, instr);
						System.out.println("GPR_2: " + GPR_2);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR2 = r2 << tempCount;
					GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
					showCPU(intEA, GPR_2, instr);
					System.out.println("GPR_2: " + GPR_2);
				}else {
					System.out.println("Error");
				}
			}else if (AL.equals(Constant.CONST_0)){			//Shift arithmetically 
				if(LR.equals(Constant.CONST_0)){			//Shift Right
					int intGPR2 = r2 >>> tempCount;
					GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
					showCPU(intEA, GPR_2, instr);
					System.out.println("GPR_2: " + GPR_2);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR2 = r2 << tempCount;
					GPR_2 = switchStringToBinary(Integer.toBinaryString(intGPR2));
					showCPU(intEA, GPR_2, instr);
					System.out.println("GPR_2: " + GPR_2);
				}else {
					System.out.println("Error");
				}
			}
			break;
		case Constant.CONST_11:
			if (AL.equals(Constant.CONST_1)){ 				//Shift Logically
				if(LR.equals(Constant.CONST_0)){			//Shift Right
					int intGPR3 = r3 >> tempCount;
						GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
						showCPU(intEA, GPR_3, instr);
						System.out.println("GPR_3: " + GPR_3);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR3 = r3 << tempCount;
					GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
					showCPU(intEA, GPR_3, instr);
					System.out.println("GPR_3: " + GPR_3);
				}else {
					System.out.println("Error");
				}
			}else if (AL.equals(Constant.CONST_0)){			//Shift arithmetically 
				if(LR.equals(Constant.CONST_0)){			//Shift Right
					int intGPR3 = r3 >>> tempCount;	
					GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
					showCPU(intEA, GPR_3, instr);
					System.out.println("GPR_3: " + GPR_3);
				}else if (LR.equals(Constant.CONST_1)) {	//Shift Left
					int intGPR3 = r3 << tempCount;
					GPR_3 = switchStringToBinary(Integer.toBinaryString(intGPR3));
					showCPU(intEA, GPR_3, instr);
					System.out.println("GPR_3: " + GPR_3);
				}else {
					System.out.println("Error");
				}
			}
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	/*
	AND
	Logical And of Register and Register
	c(rx) <- c(rx) AND c(ry)
	 */
	private void executeAND(List<String> instructionList) {
		String Rx = instructionList.get(1);
		String Ry = instructionList.get(2);
//		String I = instructionList.get(3);
//		String address = instructionList.get(4);
		//get EA
		int intEA = 0;
		//System.out.println("EA: " + intEA);
		int r0 = Integer.parseInt(GPR_0,2);
		int r1 = Integer.parseInt(GPR_1,2);
		int r2 = Integer.parseInt(GPR_2,2);
		int r3 = Integer.parseInt(GPR_3,2);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (Rx) {
		case Constant.CONST_00:
			switch (Ry) {
			case Constant.CONST_01:
				int temp1 = r0 & r1;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_10:
				int temp2 = r0 & r2;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r0 & r3;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r1 & r0;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_10:
				int temp2 = r1 & r2;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r1 & r3;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r2 & r0;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_01:
				int temp2 = r2 & r1;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r2 & r3;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r3 & r0;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_01:
				int temp2 = r3 & r1;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_10:
				int temp3 = r3 & r2;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
	}
	/*
	ORR
	Logical Or of Register and Register
	c(rx) <- c(rx) OR c(ry)
	 */
	private void executeORR(List<String> instructionList) {
		String Rx = instructionList.get(1);
		String Ry = instructionList.get(2);
//		String I = instructionList.get(3);
//		String address = instructionList.get(4);
		//get EA
		int intEA = 0;
		//System.out.println("EA: " + intEA);
		int r0 = Integer.parseInt(GPR_0,2);
		int r1 = Integer.parseInt(GPR_1,2);
		int r2 = Integer.parseInt(GPR_2,2);
		int r3 = Integer.parseInt(GPR_3,2);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (Rx) {
		case Constant.CONST_00:
			switch (Ry) {
			case Constant.CONST_01:
				int temp1 = r0 | r1;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_10:
				int temp2 = r0 | r2;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r0 | r3;
				GPR_0 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r1 | r0;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_10:
				int temp2 = r1 | r2;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r1 | r3;
				GPR_1 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r2 | r0;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_01:
				int temp2 = r2 | r1;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_11:
				int temp3 = r2 | r3;
				GPR_2 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			switch (Ry) {
			case Constant.CONST_00:
				int temp1 = r3 | r0;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp1));
				break;
			case Constant.CONST_01:
				int temp2 = r3 | r1;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp2));
				break;
			case Constant.CONST_10:
				int temp3 = r3 | r2;
				GPR_3 = switchStringToBinary(Integer.toBinaryString(temp3));
				break;
			default:
				break;
			}
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
	}
	/*
	NOT
	Logical Not of Register and Register
	c(rx) <- NOT c(rx)
	 */
	private void executeNOT(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			int r0 = Integer.parseInt(GPR_0,2);
			int intGPR0 = 0 - (r0+1);
			String stringGPR_0 = Integer.toBinaryString(intGPR0);
			GPR_0 = switchStringToBinary(stringGPR_0);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			int r1 = Integer.parseInt(GPR_1,2);
			int intGPR1 = 0 - (r1+1);
			String stringGPR_1 = Integer.toBinaryString(intGPR1);
			GPR_1 = switchStringToBinary(stringGPR_1);
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			int r2 = Integer.parseInt(GPR_2,2);
			int intGPR2 = 0 - (r2+1);
			String stringGPR_2 = Integer.toBinaryString(intGPR2);
			GPR_2 = switchStringToBinary(stringGPR_2);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_0);
			break;
		case Constant.CONST_11:
			int r3 = Integer.parseInt(GPR_3,2);
			int intGPR3 = 0 - (r3+1);
			String stringGPR_3 = Integer.toBinaryString(intGPR3);
			GPR_3 = switchStringToBinary(stringGPR_3);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	/*SIR
	Subtract  Immediate  from Register, r = 0..3
			r <- c(r) - Immed
			Note:
			1. if Immed = 0, does nothing
			2. if c(r) = 0, loads r with –(Immed)
			IX and I are ignored in this instruction
	 */
	private void executeSIR(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			int r0 = Integer.parseInt(GPR_0,2);
			int Imm0 = Integer.parseInt(address,2);
			int intGPR0 = r0 - Imm0;
			System.out.println(intGPR0);
			String stringGPR_0 = Integer.toBinaryString(intGPR0);
			GPR_0 = switchStringToBinary(stringGPR_0);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			int r1 = Integer.parseInt(GPR_1,2);
			int Imm1 = Integer.parseInt(address,2);
			int intGPR1 = r1 - Imm1;
			String stringGPR_1 = Integer.toBinaryString(intGPR1);
			GPR_1 = switchStringToBinary(stringGPR_1);
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			int r2 = Integer.parseInt(GPR_2,2);
			int Imm2 = Integer.parseInt(address,2);
			int intGPR2 = r2 - Imm2;
			String stringGPR_2 = Integer.toBinaryString(intGPR2);
			GPR_2 = switchStringToBinary(stringGPR_2);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			int r3 = Integer.parseInt(GPR_3,2);
			int Imm3 = Integer.parseInt(address,2);
			int intGPR3 = r3 - Imm3;
			String stringGPR_3 = Integer.toBinaryString(intGPR3);
			GPR_3 = switchStringToBinary(stringGPR_3);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	/*AIR
	Add  Immediate  from Register, r = 0..3
			r <- c(r) + Immed
			Note:
			1. if Immed = 0, does nothing
			2. if c(r) = 0, loads r with +(Immed)
			IX and I are ignored in this instruction
	 */
	private void executeAIR(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		//String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			int r0 = Integer.parseInt(GPR_0,2);
			int Imm0 = Integer.parseInt(address,2);
			int intGPR0 = r0 + Imm0;
			String stringGPR_0 = Integer.toBinaryString(intGPR0);
			GPR_0 = switchStringToBinary(stringGPR_0);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			int r1 = Integer.parseInt(GPR_1,2);
			int Imm1 = Integer.parseInt(address,2);
			int intGPR1 = r1 + Imm1;
			String stringGPR_1 = Integer.toBinaryString(intGPR1);
			GPR_1 = switchStringToBinary(stringGPR_1);
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			int r2 = Integer.parseInt(GPR_2,2);
			int Imm2 = Integer.parseInt(address,2);
			int intGPR2 = r2 + Imm2;
			String stringGPR_2 = Integer.toBinaryString(intGPR2);
			GPR_2 = switchStringToBinary(stringGPR_2);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			int r3 = Integer.parseInt(GPR_3,2);
			int Imm3 = Integer.parseInt(address,2);
			int intGPR3 = r3 + Imm3;
			String stringGPR_3 = Integer.toBinaryString(intGPR3);
			GPR_3 = switchStringToBinary(stringGPR_3);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	/*SMR
	Subtract Memory From Register, r = 0..3
	r <- c(r) – c(EA)
	 */
	private void executeSMR(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			int i0 = Integer.parseInt(GPR_0,2);
			int j0 = Integer.parseInt(memory.load(strEA),2);
			int intGPR0 = i0 - j0;
			GPR_0 = Integer.toBinaryString(intGPR0);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			int i1 = Integer.parseInt(GPR_1,2);
			int j1 = Integer.parseInt(memory.load(strEA),2);
			int intGPR1 = i1 - j1;
			GPR_1 = Integer.toBinaryString(intGPR1);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			int i2 = Integer.parseInt(GPR_2,2);
			int j2 = Integer.parseInt(memory.load(strEA),2);
			int intGPR2 = i2 - j2;
			GPR_2 = Integer.toBinaryString(intGPR2);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			int i3 = Integer.parseInt(GPR_3,2);
			int j3 = Integer.parseInt(memory.load(strEA),2);
			int intGPR3 = i3 - j3;
			GPR_3 = Integer.toBinaryString(intGPR3);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_0);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	/*SMR
	Add Memory From Register, r = 0..3
	r <- c(r) + c(EA)
	 */
	private void executeAMR(List<String> instructionList) {
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			int i0 = Integer.parseInt(GPR_0,2);
			int j0 = Integer.parseInt(memory.load(strEA),2);
			int intGPR0 = i0 + j0;
			GPR_0 = Integer.toBinaryString(intGPR0);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			int i1 = Integer.parseInt(GPR_1,2);
			int j1 = Integer.parseInt(memory.load(strEA),2);
			int intGPR1 = i1 + j1;
			GPR_1 = Integer.toBinaryString(intGPR1);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			int i2 = Integer.parseInt(GPR_2,2);
			int j2 = Integer.parseInt(memory.load(strEA),2);
			int intGPR2 = i2 + j2;
			GPR_2 = Integer.toBinaryString(intGPR2);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			int i3 = Integer.parseInt(GPR_3,2);
			int j3 = Integer.parseInt(memory.load(strEA),2);
			int intGPR3 = i3 + j3;
			GPR_3 = Integer.toBinaryString(intGPR3);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_0);
			break;
		default:
			break;
		}
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	
	
	/**
	 * Traps to memory address 0, which contains the address of a table in memory. 
	 * Stores the PC+1 in memory location 2. 
	 * The table can have a maximum of 16 entries representing 16 routines for 
	 * user-specified instructions stored elsewhere in memory. 
	 * Trap code contains an index into the table, e.g. it takes values 0 ¨C 15. 
	 * When a TRAP instruction is executed, it goes to the routine whose address 
	 * is in memory location 0, executes those instructions, and returns to the 
	 * instruction stored in memory location 2. 
	 * The PC+1 of the TRAP instruction is stored in memory location 2.
	 * 
	 * @param instructionList
	 */
	private void executeTRAP(List<String> instructionList) {
		System.out.println("Traps to memory's instruction address 0: code 036 occurs!");
	}

	/**
	 * 000	HLT	Stops the machine.
	 * @param instructionList
	 */
	private void executeHLT(List<String> instructionList) {
		ctrlButton.HLT();
		System.out.println("Machine stopped: code 000 occurs!");
		//System.exit(0);
	}

	/**
	 * STX
	 * STX x, address[,I]
	 * Store Index Register to Memory. X = 1..3
	 * EA <- c(X0)
	 * C(EA) <- c(Xx), if I-bit set
	 * 
	 * @param instructionList
	 */
	private void executeSTX(List<String> instructionList) {
		instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		//execute
		switch (IX) {
		case Constant.CONST_01:
			memory.store(strEA, IX_1);
			showCPU(intEA, IX_1, instr);
			break;
		case Constant.CONST_10:
			memory.store(strEA, IX_2);
			showCPU(intEA, IX_2, instr);
			break;
		case Constant.CONST_11:
			memory.store(strEA, IX_3);
			showCPU(intEA, IX_3, instr);
			break;
		default:
			break;
		}
		
		PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * LDX
	 * LDX x, address[,I]
	 * Load Index Register from Memory, x = 1..3
	 * Xx<-c(EA)
	 * 
	 * @param instructionList
	 */
	private void executeLDX(List<String> instructionList) {
		instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		//execute
		switch (IX) {
		case Constant.CONST_01:
			IX_1 = memory.load(strEA);
			showCPU(intEA, IX_1, instr);
			System.out.println("IX_1: " + IX_1);
			break;
		case Constant.CONST_10:
			IX_2 = memory.load(strEA);
			showCPU(intEA, IX_2, instr);
			System.out.println("IX_2: " + IX_2);
			break;
		case Constant.CONST_11:
			IX_3 = memory.load(strEA);
			showCPU(intEA, IX_3, instr);
			System.out.println("IX_3: " + IX_3);
			break;
		default:
			break;
		}
		
		PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * LDA
	 * LDA r, x, address[,I]
	 * Load Register with Address, r = 0..3
	 * r<-EA
	 * r<-c(EA), if I bit set
	 * 
	 * @param instructionList
	 */
	private void executeLDA(List<String> instructionList) {
		//divide instruction
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		Integer.toString(intEA);
		//get a 16-bits binary string EA
		String strBinaryEA = Integer.toBinaryString(intEA);
		strBinaryEA = memory.switchStringToBinary(strBinaryEA);
		
		//execute
		switch (R) {
		case Constant.CONST_00:
			GPR_0 = strBinaryEA;
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			GPR_1 = strBinaryEA;
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			GPR_2 = strBinaryEA;
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			GPR_3 = strBinaryEA;
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		
		showCPU(intEA, Constant.CONST_ALL_ZERO, instr);
		PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * STR
	 * 	STR r, x, address[,I]
	 * Store Register To Memory, r = 0..3
	 * EA<-c(r)
 	 * c(c(EA)) <- c(r), if I-bit set

	 * @param instructionList
	 */
	private void executeSTR(List<String> instructionList) {
		//divide instruction
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		
		//execute
		switch (R) {
		case Constant.CONST_00:
			memory.store(strEA, GPR_0);
			showCPU(intEA, GPR_0, instr);
			break;
		case Constant.CONST_01:
			memory.store(strEA, GPR_1);
			showCPU(intEA, GPR_1, instr);
			break;
		case Constant.CONST_10:
			memory.store(strEA, GPR_2);
			showCPU(intEA, GPR_2, instr);
			break;
		case Constant.CONST_11:
			memory.store(strEA, GPR_3);
			showCPU(intEA, GPR_3, instr);
			break;
		default:
			break;
		}
		
		PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}

	/**
	 * LDR
	 * LDR r, x, address[,I]
	 * Load Register From Memory, r = 0..3
	 * r<-c(EA)
	 * r <- c(c(EA)), if I bit set
	 * 
	 * @param instructionList
	 */
	private void executeLDR(List<String> instructionList) {
		//divide instruction
		String R = instructionList.get(1);
		String IX = instructionList.get(2);
		String I = instructionList.get(3);
		String address = instructionList.get(4);
		//get EA
		int intEA = EA(I, IX, address);
		System.out.println("EA: " + intEA);
		String strEA = Integer.toString(intEA);
		//execute
		switch (R) {
		case Constant.CONST_00:
			GPR_0 = memory.load(strEA);
			showCPU(intEA, GPR_0, instr);
			System.out.println("GPR_0: " + GPR_0);
			break;
		case Constant.CONST_01:
			GPR_1 = memory.load(strEA);
			showCPU(intEA, GPR_1, instr);
			System.out.println("GPR_1: " + GPR_1);
			break;
		case Constant.CONST_10:
			GPR_2 = memory.load(strEA);
			showCPU(intEA, GPR_2, instr);
			System.out.println("GPR_2: " + GPR_2);
			break;
		case Constant.CONST_11:
			GPR_3 = memory.load(strEA);
			showCPU(intEA, GPR_3, instr);
			System.out.println("GPR_3: " + GPR_3);
			break;
		default:
			break;
		}
		//PC++ and display
		PC++;
		showPC(PC);
		showGPR(GPR_0, GPR_1, GPR_2, GPR_3);
		showIX(IX_1, IX_2, IX_3);
	}
	
	/**
	 * show IX rbts
	 * @param IX_1
	 * @param IX_2
	 * @param IX_3
	 */
	private void showIX(String IX_1, String IX_2, String IX_3) {
		ctrlButton.rbtSwitch("IX_1", IX_1);
		ctrlButton.rbtSwitch("IX_2", IX_2);
		ctrlButton.rbtSwitch("IX_3", IX_3);
	}

	/*
	 * show GPR rbts
	 */
	private void showGPR(String GPR_0, String GPR_1, String GPR_2, String GPR_3) {
		ctrlButton.rbtSwitch("GPR_0", GPR_0);
		ctrlButton.rbtSwitch("GPR_1", GPR_1);
		ctrlButton.rbtSwitch("GPR_2", GPR_2);
		ctrlButton.rbtSwitch("GPR_3", GPR_3);
	}

	//show MAR, MBR, IR, PC on panel
	private void showCPU(int intEA, String data, String IR) {
		Integer.toString(intEA);
		String biMAR = Integer.toBinaryString(intEA);
		
		//MAR
		String strMAR = (Constant.CONST_ALL_ZERO + biMAR).substring(biMAR.length());
		
		//MBR
		String strMBR = data;
		
		//IR
		
		//PC
		//String biPC = Integer.toBinaryString(PC);
		//String strPC = (Constant.CONST_ALL_ZERO + biPC).substring(biPC.length());
		
		//show on panel
		panel.getTextFieldMAR().setText(strMAR);
		panel.getTextFieldMBR().setText(strMBR);
		panel.getTextFieldIR().setText(IR);
		//panel.getTextFieldPC().setText(strPC);
	}
	
	/**
	 * 
	 * @param PC
	 */
	private void showPC(int PC) {
		String biPC = Integer.toBinaryString(PC);
		String strPC = (Constant.CONST_ALL_ZERO + biPC).substring(biPC.length());
		panel.getTextFieldPC().setText(strPC);
	}

	/**
	 * get effective address
	 * @param address
	 * @param address2 
	 * @param I 
	 * @return
	 */
	private int EA(String I, String IX, String address) {
		String strBinaryEA = address;
		int intDecimalEA = Integer.parseInt(strBinaryEA, 2);
		String strDecimalEA = Integer.toString(intDecimalEA);
		
		String returnStrEA = null;
		int returnIntEA = 0;
		if (I.equals(Constant.CONST_0)) {
			if (IX.equals(Constant.CONST_00)) {
				//returnStrEA is a binary string
				//returnStrEA = memory.load(strDecimalEA);
				//returnIntEA is a decimal integer
				//returnIntEA = Integer.parseInt(returnStrEA, 2);
				returnIntEA = intDecimalEA;
				return returnIntEA;
			} else if (IX.equals(Constant.CONST_01)) {
				//intIX is a decimal integer
				int intIX_1 = Integer.parseInt(IX_1, 2);
				//returnStrEA = memory.load(strDecimalEA);
				//returnIntEA = Integer.parseInt(returnStrEA, 2);
				returnIntEA = intDecimalEA;
				returnIntEA += intIX_1;
				return returnIntEA;
			} else if (IX.equals(Constant.CONST_10)) {
				int intIX_2 = Integer.parseInt(IX_2, 2);
				//returnStrEA = memory.load(strDecimalEA);
				//returnIntEA = Integer.parseInt(returnStrEA, 2);
				returnIntEA += intIX_2;
				return returnIntEA;
			} else {
				int intIX_3 = Integer.parseInt(IX_3, 2);
				//returnStrEA = memory.load(strDecimalEA);
				//returnIntEA = Integer.parseInt(returnStrEA, 2);
				returnIntEA = intDecimalEA;
				returnIntEA += intIX_3;
				return returnIntEA;
			}
		} else {
			if (IX.equals(Constant.CONST_00)) {
				//returnStrEA is a binary string
				returnStrEA = memory.load(strDecimalEA);
				//returnIntEA is a decimal integer
				returnIntEA = Integer.parseInt(returnStrEA, 2);
				return returnIntEA;
			} else if (IX.equals(Constant.CONST_01)) {
				/*//intIX_1 is a decimal integer
				int intIX_1 = Integer.parseInt(IX_1, 2);
				//tempStrEA is a binary string
				String tempStrEA = memory.load(strDecimalEA);
				int tempIntEA = Integer.parseInt(tempStrEA);
				tempIntEA += intIX_1;
				returnStrEA = memory.load(Integer.toString(tempIntEA));
				returnIntEA = Integer.parseInt(returnStrEA);
				return returnIntEA;*/
				int intIX_1 = Integer.parseInt(IX_1, 2);
				int tempIntEA = intDecimalEA;
				tempIntEA += intIX_1;
				String tempStrEA = Integer.toString(tempIntEA);
				returnStrEA = memory.load(tempStrEA);
				returnIntEA = Integer.parseInt(returnStrEA);
				return returnIntEA;
			} else if (IX.equals(Constant.CONST_10)) {
				int intIX_2 = Integer.parseInt(IX_2, 2);
				int tempIntEA = intDecimalEA;
				tempIntEA += intIX_2;
				String tempStrEA = Integer.toString(tempIntEA);
				returnStrEA = memory.load(tempStrEA);
				returnIntEA = Integer.parseInt(returnStrEA);
				return returnIntEA;
			} else {
				int intIX_3 = Integer.parseInt(IX_3, 2);
				int tempIntEA = intDecimalEA;
				tempIntEA += intIX_3;
				String tempStrEA = Integer.toString(tempIntEA);
				returnStrEA = memory.load(tempStrEA);
				returnIntEA = Integer.parseInt(returnStrEA);
				return returnIntEA;
			}
		}
	}

	/**
	 * decode instruction
	 * @param strInstruction
	 * @return
	 */
	private List<String> decodeInstruction(String strInstruction) {
		String tempOpcode = strInstruction.substring(0, 6);
		String tempR = strInstruction.substring(6, 8);
		String tempIX = strInstruction.substring(8, 10);
		String tempI = strInstruction.substring(10, 11);
		String tempAddress = strInstruction.substring(11);
		
		List<String> instructionList = new ArrayList<String>();
		
		instructionList.add(tempOpcode);
		instructionList.add(tempR);
		instructionList.add(tempIX);
		instructionList.add(tempI);
		instructionList.add(tempAddress);
		
		return instructionList;
	}
	/**
	 * decode Shiftinstruction
	 * @param strShiftInstruction
	 * @return
	 */
	private List<String> decodeShiftInstruction(String strInstruction) {
		String tempOpcode = strInstruction.substring(0, 6);
		String tempR = strInstruction.substring(6, 8);
		String tempAL = strInstruction.substring(8, 9);
		String tempLR = strInstruction.substring(9, 10);
		String tempCount = strInstruction.substring(12);
		
		List<String> shiftinstructionList = new ArrayList<String>();
		
		shiftinstructionList.add(tempOpcode);
		shiftinstructionList.add(tempR);
		shiftinstructionList.add(tempAL);
		shiftinstructionList.add(tempLR);
		shiftinstructionList.add(tempCount);
		
		return shiftinstructionList;
	}

	/**
	 * for test
	 */
	public void show() {
		/*System.out.println("GPR_0: " + GPR_0);
		System.out.println("GPR_1: " + GPR_1);
		System.out.println("GPR_2: " + GPR_2);
		System.out.println("GPR_3: " + GPR_3);*/
		/*PC++;
		String biPC = Integer.toBinaryString(PC);
		String strPC = (Constant.CONST_ALL_ZERO + biPC).substring(biPC.length());
		panel.getTextFieldPC().setText(strPC);*/
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
}
