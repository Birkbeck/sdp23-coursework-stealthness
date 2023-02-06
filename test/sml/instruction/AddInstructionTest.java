package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

class AddInstructionTest {
  private Machine machine;
  private Registers registers;

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    //...
  }

  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
  }

  @Test
  void executeValidAddInstructionUsingTwoPositiveInts() {
    final int VALUE_1 = 5;
    final int VALUE_2 = 6;

    registers.set(EAX, VALUE_1 );
    registers.set(EBX, VALUE_2 );
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(VALUE_1 + VALUE_2, machine.getRegisters().get(EAX));
  }

  @Test
  void executeValidAddInstructionUsingOnePositiveOneNegativeInts() {

    final int VALUE_1 = 5;
    final int VALUE_2 = 6;

    registers.set(EAX, -VALUE_1);
    registers.set(EBX, VALUE_2);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(VALUE_2 - VALUE_1, machine.getRegisters().get(EAX));
  }
}