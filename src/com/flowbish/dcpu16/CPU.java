package com.flowbish.dcpu16;

public class CPU {
	private Memory memory;
	private char[] registers;
	private char PC;
	private char SP;
	private char EX;
	private long cycles;
	
	public CPU() {
		memory = new Memory();
		registers = new char[8];
		reset();
	}
	
	public void loadProgram(byte[] program) {
		for (int i = 0; i < program.length; i += 2) {
			char value = (char) ((program[i]) << 8);
			if (i + 1 < program.length)
				value += program[i+1];
			memory.setAddress(i/2, value);
		}
	}
	
	public void reset() {
		for (int i = 0; i < registers.length; i++) {
			registers[i] = 0;
		}
		PC = 0;
		SP = 0xffff;
		EX = 0;
		cycles = 0;
	}
	
	public void step() {
		//TODO: A lot of stuff!
		char instruction = memory.getAddress(PC);
		PC++;
		char opcode = (char) (instruction & 0x1f);
		if (opcode != 0x0) { // Basic Opcode
			char b = (char)((instruction >> 5) & 0x1f);
			char a = (char)((instruction >> 10) & 0x1f);
			if (opcode == 0x1){ // SET b, a
				
			}
		}
		else { // Non-basic Opcode
			
		}
	}
	
	private void baiscOp(char opcode, char b, char a) {
		//TODO
	}
	
	private void nonBasicOp(char opcode, char b) {
		//TODO
	}
	
	public Memory getMemory() {
		return memory;
	}
	
	public char[] getRegisters() {
		return registers;
	}
	
	public char getPC() {
		return PC;
	}
}
