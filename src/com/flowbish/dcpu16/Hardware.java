package com.flowbish.dcpu16;

public abstract class Hardware {
	public final int manufacturer;
	public final int hardwareID;
	public final int hardwareVersion;
	private DCPU cpu;
	
	public Hardware(DCPU cpu) {
		this.cpu = cpu;
		manufacturer = 0;
		hardwareID = 0;
		hardwareVersion = 0;
	}
	
	public DCPU getCPU() {
		return cpu;
	}
	
	public abstract void inturrupt();
	
	protected final void pushInturrupt(char message) {
		cpu.sendInterrupt(message);
	}
	
	/**
	 * Sends the query data to the DCPU  <br>
	 * <code>A+(B&lt;&lt;16)</code> is a 32 bit word identifying the hardware id  <br>
	 * <code>C</code> is the hardware version  <br>
	 * <code>X+(Y&lt;&lt;16)</code> is a 32 bit word identifying the manufacturer 
	 */
	public final void query() {
		getCPU().getMemory().setA(hardwareID & 0xffff);
		getCPU().getMemory().setB((hardwareID>>16) & 0xffff);
		
		getCPU().getMemory().setC(hardwareVersion);
		
		getCPU().getMemory().setX(manufacturer & 0xffff);
		getCPU().getMemory().setY((manufacturer>>16) & 0xffff);
	}
}
