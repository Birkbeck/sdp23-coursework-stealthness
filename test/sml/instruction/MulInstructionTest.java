package sml.instruction;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

class MulInstructionTest {
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

  @DisplayName("Should evaluate the correct MulInstruction")
  @ParameterizedTest(name = "{index} => a={0} * b={1} the expected output is {2}")
  @CsvSource({
         "1, 1, 1",
         "2, 2, 4",
         "4, 2, 8",
         "2, -4, -8",

  })
  void executeParameterizedTest(int value1, int value2, int expectedValue){
    registers.set(EAX, value1);
    registers.set(EBX, value2);
    Instruction instruction = new MulInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(expectedValue, machine.getRegisters().get(EAX));
  }
}