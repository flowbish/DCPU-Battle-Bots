package com.flowbish.dcpu16;

/**
 * Memory storage thingy for DCPU-16
 * @author Flowbish
 *
 */
public class Memory {
	private char[] memory;
	
	public final int MAX_MEMORY = 0x1000f;
	public final int MEMORY_SIZE = 0x10000;
	
	public final int A = 0x10000;
	public final int B = 0x10001;
	public final int C = 0x10002;
	public final int X = 0x10003;
	public final int Y = 0x10004;
	public final int Z = 0x10005;
	public final int I = 0x10006;
	public final int J = 0x10007;
	
	public final int SP = 0x10008;
	public final int PC = 0x10009;
	public final int EX = 0x1000a;
	public final int A_TEMP = 0x1000e;
	
	public Memory() {
		memory = new char[MAX_MEMORY];
		memory[SP] = 0xffff;
	}
	
	/**
	 * Sets memory address <code>addr</code> to <code>value</code>
	 * @param addr - Memory address to write to
	 * @param value - 16 bit integer to write
	 */
	public void setAddress(char addr, char value) {
		memory[addr] = value;
	}
	
	/**
	 * Sets memory address <code>addr</code> to <code>value</code>
	 * @param addr - memory address to write to
	 * @param value - 16 bit integer to write
	 */
	public void setAddress(int addr, int value) {
		if (addr < MAX_MEMORY)
			memory[addr] = (char)value;
		else throw new IndexOutOfBoundsException();
		
	}
	
	/**
	 * Returns the value at memory address <code>addr</code>
	 * @param addr - memory address to return
	 * @return 16 bit integer
	 */
	public char getAddress(char addr) {
		return memory[addr];
	}
	
	/**
	 * Returns the value at memory address <code>addr</code>
	 * @param addr - memory address to return
	 * @return 16 bit integer
	 */
	public char getAddress(int addr) {
		if (addr < MAX_MEMORY)
			return memory[addr];
		else throw new IndexOutOfBoundsException();
	}	
	
	/**
	 * Returns the value at the location of the current value of <code>PC</code>
	 * then increments <code>PC</code>.
	 * Analougous to <code>[PC++]</code>
	 * @return 16 bit integer
	 */
	public char nextWord() {
		char addr = getPC();
		setPC((char)(addr + 1));
		return getAddress(addr);
	}

	public char getPC() {
		return getAddress(PC);
	}
	
	public void setPC(int addr) {
		setAddress(PC, addr);
	}
	
	public char getEX() {
		return getAddress(EX);
	}
	
	public void setEX(int value) {
		setAddress(EX, value);
	}
	
	public char getSP() {
		return getAddress(SP);
	}
	
	public void setSP(int value) {
		setAddress(SP, value);
	}
	
	public void stackPush(int value) {
		int sp = getSP() - 1;
		setAddress(getAddress(sp), value);
		setSP(sp);
	}
	
	public char stackPop() {
		char sp = getSP();
		setSP(sp + 1);
		return getAddress(sp);
		
	}
	
	public char getA() {
		return getAddress(A);
	}	
	public char getB() {
		return getAddress(B);
	}	
	public char getC() {
		return getAddress(C);
	}	
	public char getX() {
		return getAddress(X);
	}	
	public char getY() {
		return getAddress(Y);
	}	
	public char getZ() {
		return getAddress(Z);
	}	
	public char getI() {
		return getAddress(I);
	}	
	public char getJ() {
		return getAddress(J);
	}

}
