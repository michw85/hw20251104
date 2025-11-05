package app;

import app.Exception.NotCorrectEmailFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Main2Test {

    @Test
    void checkEmailPositiveTest() {
        assertDoesNotThrow(() -> Main2.checkEmail("qwerty@mail.com"));
    }

    @Test
    void checkEmailNegativeTest() {
        NotCorrectEmailFormatException exception = assertThrows(NotCorrectEmailFormatException.class, () -> Main2.checkEmail("@ty@"));
        List<String> actualList = exception.getList();
        List<String> expectedList = List.of("строка короче 5 символов",
                "отсутствует символ '@'",
                "не может начинаться с '@'",
                "не может заканчиваться на '@'",
                "должен быть один символ '@'");
        assertIterableEquals(new HashSet<>(expectedList), new HashSet<>(actualList));
    }

    static Stream<Arguments> emailNegativeArguments() {
        return Stream.of(
                Arguments.of("@ty@",
                        List.of("строка короче 5 символов",
                                "отсутствует символ '@'",
                                "не может начинаться с '@'",
                                "не может заканчиваться на '@'",
                                "должен быть один символ '@'")),
//                Arguments.of("@mail.com",
//                        List.of("не может начинаться с '@'")),
//                Arguments.of("@ty.com@",
//                        List.of("не может начинаться с '@'",
//                                "не может заканчиваться на '@'",
//                                "должен быть один символ '@'")),
                Arguments.of("qwerty@@mail.com",
                        List.of("должен быть один символ '@'"))
        );
    }

    @ParameterizedTest
    @MethodSource ("emailNegativeArguments")
    void checkEmailNegativeTestParameterized(String email, List<String> expectedList) {
        NotCorrectEmailFormatException exception = assertThrows(NotCorrectEmailFormatException.class, () -> Main2.checkEmail(email));
        List<String> actualList = exception.getList();
        assertIterableEquals(new HashSet<>(expectedList), new HashSet<>(actualList));
    }
}