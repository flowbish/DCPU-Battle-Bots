package com.flowbish.dcpu16;

public class Memory {
	private int[] memory;
	
	public final int MAX_MEMORY = 0x10000;
	
	public Memory() {
		memory = new int[MAX_MEMORY];
	}
	
	/**
	 * Set memory address 'addr' to the value
	 * @param addr - Memory address to write to
	 * @param value - 16 bit integer to write
	 */
	public void setAddress(int addr, int value) {
		if (addr < MAX_MEMORY)
			memory[addr] = value;
		else throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Returns the value at memory address 'addr'
	 * @param addr - Memory address to return
	 * @return 16 bit integer
	 */
	public int getAddress(int addr) {
		if (addr < MAX_MEMORY)
			return memory[addr];
		else throw new IndexOutOfBoundsException();
	}
}
