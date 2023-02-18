package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class MovInstruction extends Instruction {
	private final int value;
	private final RegisterName register;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, int value, RegisterName register) {
		super(label, OP_CODE);
		this.value = value;
		this.register = register;
	}

	@Override
	public int execute(Machine m) {
		m.getRegisters().set(register, value);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + value + " " + register;
	}
}
