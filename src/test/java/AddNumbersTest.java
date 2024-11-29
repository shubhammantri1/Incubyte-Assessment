import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNumbersTest {

    @Test
    void validNumbersTest() throws Exception {
        Assertions.assertEquals(100, Main.add("5,95"));
        Assertions.assertEquals(-2, Main.add("5,-7"));
        Assertions.assertEquals(0, Main.add("5,-5"));
        Assertions.assertEquals(10, Main.add("1,2,3,4"));
        Assertions.assertEquals(0, Main.add(",,"));
        Assertions.assertEquals(2,Main.add(",0,2,,"));
    }

    @Test
    void edgeCasesNumbersTest() {
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add(" ,7"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add(" , "));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("asd,7"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("asd,zxc"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("123123123123123123123123123,1"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("-10000000000000, 03490349209"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("0.00,1.5"));
        Assertions.assertThrows(NumberFormatException.class, () -> Main.add("*&&^,!"));
    }

}
