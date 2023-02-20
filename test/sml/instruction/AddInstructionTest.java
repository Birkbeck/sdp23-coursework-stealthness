package sml.instruction;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

  @DisplayName("Should evaluate the correct AddInstruction")
  @ParameterizedTest(name = "{index} => a={0} + b={1} the expected output is {2}")
  @CsvSource({
          "1, 1, 2",
          "2, 2, 4",
          "4, 2, 6",
          "2, -4, -2",
          "-2, 4, 2",
          "-2, -4, -6"
  })
  void executeParameterizedTest(int value1, int value2, int expectedValue){
    registers.set(EAX, value1);
    registers.set(EBX, value2);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(expectedValue, machine.getRegisters().get(EAX));
  }
}