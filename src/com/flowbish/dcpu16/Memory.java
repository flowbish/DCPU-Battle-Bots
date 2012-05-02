package com.flowbish.dcpu16;

public class Memory {
	private char[] memory;
	
	public final int MAX_MEMORY = 0x10000;
	
	public Memory() {
		memory = new char[MAX_MEMORY];
	}
	
	/**
	 * Set memory address 'addr' to the value
	 * @param addr - Memory address to write to
	 * @param value - 16 bit integer to write
	 */
	public void setAddress(char addr, char value) {
		memory[addr] = value;
	}
	
	public void setAddress(int addr, int value) {
		if (addr < MAX_MEMORY)
			setAddress((char) addr, (char) value);
		else throw new IndexOutOfBoundsException();
		
	}
	
	/**
	 * Returns the value at memory address 'addr'
	 * @param addr - Memory address to return
	 * @return 16 bit integer
	 */
	public char getAddress(char addr) {
		return memory[addr];
	}
	
	public char getAddress(int addr) {
		if (addr < MAX_MEMORY)
			return getAddress((char) addr);
		else throw new IndexOutOfBoundsException();
	}
}
