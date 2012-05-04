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
		 * Should run "SET A, 0x13"
		 * Result:
		 * 		A =13
		 * 		PC = 1
		 * 		cycles = 1
		 */
		cpu.step();
		assertEquals(0x1, mem.getPC());
		assertEquals(0x13, mem.getA());	
	}
	
	@Test
	public void testMemoryRanges() {
		mem.setAddress(0x3000, 0x30);
		assertEquals(0x30, mem.getAddress(0x3000));
		
		exception.expect(IndexOutOfBoundsException.class);
		mem.setAddress(0x123456, 0x0);
	}
}
