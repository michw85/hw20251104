package app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isEmailCorrectPositiveTest() {
        assertTrue(Main.isEmailCorrect("qwerty@asdas.sad"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@qwe.com", "qwe.com@", "qwer", "qw@q", "qwer@qwe@qwerty.com", ""})
    void isEmailCorrectNegativeTest(String email){
        assertFalse(Main.isEmailCorrect(email));
    }
}