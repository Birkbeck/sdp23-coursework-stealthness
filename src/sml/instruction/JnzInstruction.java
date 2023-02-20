package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

/**
 * If the contents of register s is not zero, then make the statement labeled L the next statement to execute
 */
public class JnzInstruction extends Instruction {

    private final RegisterName source;
    private final String nextInstruction;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName source, String nextInstruction) {
        super(label, OP_CODE);
        this.nextInstruction =  nextInstruction;
        this.source = source;

    }


    @Override
    public int execute(Machine m) {

        if (m.getRegisters().get(source) == 0){
            m.execute();
        } else{

        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source + " " + nextInstruction;
    }
}
