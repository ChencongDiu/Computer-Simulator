package memory;

import java.util.HashMap;
import java.util.Map;

import constant.Constant;

/**
 * Memory
 * @author Chen
 *
 */
public class Memory {
	private Map<Integer, String> memoryMap;
	
	public Memory() {
		memoryMap = new HashMap<Integer, String>();
		initMemoryMap();
	}

	/**
	 * initiate memory
	 */
	private void initMemoryMap() {
		System.out.println("memory initiated!");
		for (int i = 0; i < 4096; i++) {
			memoryMap.put(i, Constant.CONST_ALL_ZERO);
		}
	}

	/**
	 * fetch data from strAddress
	 * @param strAddress decimal
	 * @return
	 */
	public String load(String strAddress) {
		int intAddress = Integer.parseInt(strAddress);
		String strData = memoryMap.get(intAddress);
		System.out.println("Load " + strData + " from memory location: " + intAddress);
		return strData;
	}

	public void store(String strAddress, String strData) {
		strData = switchStringToBinary(strData);
		int intAddress = Integer.parseInt(strAddress);
		memoryMap.replace(intAddress, strData);
		System.out.println("Store " + strData + " into memory location: " + intAddress);
	}
	
	public String switchStringToBinary(String instruction) {
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
