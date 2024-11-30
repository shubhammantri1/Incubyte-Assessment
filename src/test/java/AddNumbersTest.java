import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNumbersTest {
    
    @Test
    void validNumbersTest() throws Exception {

        Main addNumbers = new Main();
        
        Assertions.assertEquals(100, addNumbers.add("5,95"));
//        Assertions.assertEquals(-2, addNumbers.add("5,-7"));
//        Assertions.assertEquals(0, addNumbers.add("5,-5"));

        Assertions.assertEquals(10, addNumbers.add("1,2,3,4"));
        Assertions.assertEquals(0, addNumbers.add(",,"));
        Assertions.assertEquals(2,addNumbers.add(",0,2,,"));

        Assertions.assertEquals(3, addNumbers.add("1\n2,"));
//        Assertions.assertEquals(-1, addNumbers.add("1\n-2,"));
        Assertions.assertEquals(0, addNumbers.add("\n,"));

        Assertions.assertEquals(9, addNumbers.add(";,;\n;"));
        Assertions.assertEquals(8, addNumbers.add("0,;\n5"));

    }

    @Test
    void edgeCasesNumbersTest() {

        Main addNumbers = new Main();

        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add(" ,7"));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add(" , "));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("asd,7"));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("asd,zxc"));

        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("123123123123123123123123123,1"));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("-10000000000000, 03490349209"));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("0.00,1.5"));
        Assertions.assertThrows(NumberFormatException.class, () -> addNumbers.add("*&&^,!"));

        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> addNumbers.add("-1,-2"));
        Assertions.assertEquals("negative numbers not allowed[-1, -2]", exception1.getMessage());

        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> addNumbers.add("1\n-5,0"));
        Assertions.assertEquals("negative numbers not allowed[-5]", exception2.getMessage());

    }

}
