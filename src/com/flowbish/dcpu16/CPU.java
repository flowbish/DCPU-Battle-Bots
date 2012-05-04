package com.flowbish.dcpu16;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * CPU of the DCPU-16
 * @author Flowbish
 * @version not finished yet
 *
 */
public class CPU {
	private Memory memory;
	private long cycles;
	
	public CPU() {
		memory = new Memory();
		reset();
	}
	
	/**
	 * Loads a program from a byte array and pushes it into
	 * memory starting at 0x0000
	 * @param program - byte array of instructions, two bytes
	 * 	                per instruction
	 */
	public void loadProgram(byte[] program) {
		for (int i = 0; i < program.length; i += 2) {
			char value = (char) ((program[i]) << 8);
			if (i + 1 < program.length)
				value += program[i+1];
			memory.setAddress(i/2, value);
		}
	}
	
	public void reset() {
		memory = new Memory();
		cycles = 0;
	}
	
	public void step() {
		char instruction = memory.nextWord();
		char opcode = (char) (instruction & 0x1f);
		if (opcode != 0x0) { // Basic Opcode
			char b = (char)((instruction >> 5) & 0x1f);
			char a = (char)((instruction >> 10) & 0x3f);
			basicOp(opcode, b, a);
		}
		else { // Non-basic Opcode
			opcode = (char)((instruction >> 5) & 0x1f);
			char a = (char)((instruction >> 10) & 0x1f); 
			nonBasicOp(opcode, a);
		}
	}
	
	/**
	 * Performs a basic instruction.
	 * @param opcode  the opcode of the instruction (lower 5 bits)
	 * @param b - the b value of the instruction (middle 5 bits)
	 * @param a - the a value of the instruction (upper 6 bits)
	 */
	private void basicOp(char opcode, char b, char a) {
		int b_addr = operand(b);
		int a_addr = operand(a);
		char b_value = memory.getAddress(b_addr);
		char a_value = memory.getAddress(a_addr);
		switch(opcode) {
		// SET b, a
		case 0x01:
			memory.setAddress(b_addr, a_value);
			cycles += 1;
			break;
		// ADD b, a
		case 0x02:
			int sum = b_value + a_value;
			if (sum > 0xffff) 
				memory.setAddress(memory.EX, 0x0001);
			else
				memory.setAddress(memory.EX, 0x0000);
			memory.setAddress(b_addr, sum);
			cycles += 2;
			break;
		// SUB b, a
		case 0x03:
			int dif = b_value - a_value;
			if (dif < 0x0) 
				memory.setAddress(memory.EX, 0xffff);
			else
				memory.setAddress(memory.EX, 0x0000);
			memory.setAddress(b_addr, dif);
			cycles += 2;
			break;
		// MUL b, a
		case 0x04:
			int prod = b_value * a_value;
			memory.setAddress(memory.EX, (prod >> 16) & 0xffff);
			memory.setAddress(b_addr, prod);
			cycles += 2;
			break;
		// DIV b, a
		case 0x06:
			int div = b_value / a_value;
			if (a != 0x0) {
				memory.setEX(((b_value << 16) / a_value) & 0xffff);
				memory.setAddress(b_addr, div);
			}
			else {
				memory.setAddress(memory.EX, 0x0000);
				memory.setAddress(b_addr, 0x0);
			}
			cycles += 3;
			break;
		// MOD b, a
		case 0x08:
			if (a_value == 0)
				memory.setAddress(b_addr, 0);
			else
				memory.setAddress(b_addr, b_value % a_value);
			cycles += 3;
			break;
		// AND b, a
		case 0x0a:
			memory.setAddress(b_addr, a_value & b_value);
			cycles += 1;
			break;
		// BOR b, a
		case 0x0b:
			memory.setAddress(b_addr, a_value | b_value);
			cycles += 1;
			break;
		}
	}
	
	/**
	 * Performs a non-basic instruction, that is, where the lowest 5 bits are unset.
	 * @param opcode - the opcode of the instruction (middle 5 bits)
	 * @param a - the a value of the instruction (upper 6 bits)
	 */
	private void nonBasicOp(char opcode, char a) {
		//TODO
	}
	
	/**
	 * Returns a memory address that contains the value of the specified operand.
	 * @param a  operand
	 * @return memory address to access <code>a<code>
	 */
	private int operand(char a) {
		if (a < 0x8) {
			return memory.MEMORY_SIZE + a;
		}
		else if (a < 0x10) {
			return memory.getAddress(memory.MEMORY_SIZE + a - 0x8);
		}
		else if (a < 0x18) {
			char word =memory.nextWord();
			return memory.getAddress(memory.MEMORY_SIZE + a - 0x10) + word;
		}
		else if (a  == 0x1f) {
			char pc = memory.getPC();
			memory.setPC(pc + 1);
			cycles += 1;
			return pc;
		}
		else {
			a -= 0x21;
			memory.setAddress(memory.A_TEMP, a);
			return memory.A_TEMP;
		}
	}
	/**
	 * Returns instance of Memory used by this CPU
	 */
	public Memory getMemory() {
		return memory;
	}
	
	public long getCycles() {
		return cycles;
	}
}
