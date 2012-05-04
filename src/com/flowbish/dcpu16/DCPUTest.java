package com.flowbish.dcpu16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class DCPUTest extends TestCase {
	private CPU cpu;
	private Memory mem;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		cpu = new CPU();
		mem= cpu.getMemory();
		byte[] program = null;
		try {
			RandomAccessFile file = new RandomAccessFile("dcpu_test.bin", "r");
			program = new byte[(int) file.length()];
			file.read(program);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpu.loadProgram(program);
	}
	
	@Test
	public void testCPUStep() {
		/*
		 * Pre-test sanitation checks
		 */
		assertEquals(0xd001, mem.getAddress(0x0000));
		assertEquals(0x0 , mem.getA());
		assertEquals(0x0, mem.getPC());
		assertEquals(0xffff, mem.getAddress(mem.SP));
		
		
		/*
		 * Runs "SET A, 0x13"
		 * Result:
		 * 		A = 0x13
		 * 		PC = 0x01
		 * 		cycles = 1
		 */
		cpu.step();
		assertEquals(0x13, mem.getA());	
		assertEquals(0x1, mem.getPC());
		assertEquals(1, cpu.getCycles());
		
		
		/*
		 * Runs "SET B, 0x04"
		 * Result:
		 * 		A = 0x13
		 * 		B = 0x04
		 * 		PC = 0x02
		 * 		cycles = 2
		 */
		cpu.step();
		assertEquals(0x13, mem.getA());	
		assertEquals(0x04, mem.getB());	
		assertEquals(0x2, mem.getPC());
		assertEquals(2, cpu.getCycles());
		
		
		/*
		 * Runs "ADD B, A"
		 * Result:
		 * 		A = 0x13
		 * 		B = 0x17
		 * 		PC = 0x03
		 * 		cycles = 4
		 */
		cpu.step();
		assertEquals(0x13, mem.getA());	
		assertEquals(0x17, mem.getB());	
		assertEquals(0x3, mem.getPC());
		assertEquals(4, cpu.getCycles());
		
		
		/*
		 * Runs "SUB B, 6"
		 * Result:
		 * 		A = 0x13
		 * 		B = 0x11
		 * 		PC = 0x04
		 * 		cycles = 6
		 */
		cpu.step();
		assertEquals(0x13, mem.getA());	
		assertEquals(0x11, mem.getB());	
		assertEquals(0x4, mem.getPC());
		assertEquals(6, cpu.getCycles());
		
		/*
		 * Runs "MUL A, B"
		 * Result:
		 * 		A = 0x143
		 * 		B = 0x11
		 * 		PC = 0x05
		 * 		cycles = 8
		 */
		cpu.step();
		assertEquals(0x143, mem.getA());	
		assertEquals(0x11, mem.getB());	
		assertEquals(0x5, mem.getPC());
		assertEquals(8, cpu.getCycles());
		
		/*
		 * Runs "DIV A, 0x20"
		 * Result:
		 * 		A = 0x0a
		 * 		B = 0x11
		 * 		EX = 0x1800
		 * 		PC = 0x07
		 * 		cycles = 12
		 */
		cpu.step();
		assertEquals(0x0a, mem.getA());	
		assertEquals(0x11, mem.getB());	
		assertEquals(0x1800, mem.getEX());
		assertEquals(0x7, mem.getPC());
		assertEquals(12, cpu.getCycles());
		
		/*
		 * Runs "DIV A, 0x20"
		 * Result:
		 * 		A = 0x0a
		 * 		B = 0x07
		 * 		EX = 0x1800
		 * 		PC = 0x08
		 * 		cycles = 15
		 */
		cpu.step();
		assertEquals(0x0a, mem.getA());	
		assertEquals(0x07, mem.getB());	
		assertEquals(0x1800, mem.getEX());
		assertEquals(0x8, mem.getPC());
		assertEquals(15, cpu.getCycles());
		
		/*
		 * Runs "AND B, 0x5"
		 * Result:
		 * 		A = 0x0a
		 * 		B = 0x05
		 * 		EX = 0x1800
		 * 		PC = 0x09
		 * 		cycles = 16
		 */
		cpu.step();
		assertEquals(0x0a, mem.getA());	
		assertEquals(0x05, mem.getB());	
		assertEquals(0x1800, mem.getEX());
		assertEquals(0x9, mem.getPC());
		assertEquals(16, cpu.getCycles());
		
		/*
		 * Runs "BOR B, 0x10"
		 * Result:
		 * 		A = 0x0a
		 * 		B = 0x15
		 * 		EX = 0x1800
		 * 		PC = 0x0a
		 * 		cycles = 17
		 */
		cpu.step();
		assertEquals(0x0a, mem.getA());	
		assertEquals(0x15, mem.getB());	
		assertEquals(0x1800, mem.getEX());
		assertEquals(0xa, mem.getPC());
		assertEquals(17, cpu.getCycles());
		
		//TODO: Test for JSR and SET PC, a
	}
	
	@Test
	public void testMemoryRanges() {
		mem.setAddress(0x3000, 0x30);
		assertEquals(0x30, mem.getAddress(0x3000));
		
		exception.expect(IndexOutOfBoundsException.class);
		mem.setAddress(0x123456, 0x0);
	}
}
