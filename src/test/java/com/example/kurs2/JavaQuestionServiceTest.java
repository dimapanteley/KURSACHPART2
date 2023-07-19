import com.example.kurs2.Qestion;
import com.example.kurs2.exceptions.ParameterIsNullException;
import com.example.kurs2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.kurs2.TestingDataStorage.*;
import static com.example.kurs2.TestingDataStorage.QUESTION5;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    private final JavaQuestionService jqs = new JavaQuestionService();

    @BeforeEach
    public void setUp() {
        jqs.getAll().clear(); //очищаю коллекцию
        assertTrue(jqs.getAll().isEmpty()); //проверка, что коллекция пуста
    }

    public static Stream<Arguments> provideParamsForTheTests() {
        return Stream.of(
                Arguments.of(QUESTION1),
                Arguments.of(QUESTION2),
                Arguments.of(QUESTION3),
                Arguments.of(QUESTION4),
                Arguments.of(QUESTION5)
        );
    }

    private void fullCollectionWithTestQuestions() {
        jqs.getAll().add(QUESTION1);
        jqs.getAll().add(QUESTION2);
        jqs.getAll().add(QUESTION3);
        jqs.getAll().add(QUESTION4);
        jqs.getAll().add(QUESTION5);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void addParametrisedTest(Qestion question) {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы
        assertTrue(jqs.getAll().contains(question)); //проверяю что тестовые вопросы добавились в коллекцию
    }

    @Test
    public void addTest() {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы
        assertTrue(jqs.getAll().contains(QUESTION1)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(jqs.getAll().contains(QUESTION2)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(jqs.getAll().contains(QUESTION3)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(jqs.getAll().contains(QUESTION4)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(jqs.getAll().contains(QUESTION5)); //проверяю что тестовые вопросы добавились в коллекцию
    }

    @Test
    public void removeTest() {
        String question1 = QUESTION1.getQuestion();
        String answer1 = QUESTION1.getAnswer();
        jqs.add(question1, answer1);//добавляю тестовые вопросы и ответы
        assertTrue(jqs.getAll().contains(QUESTION1)); //проверяю что тестовый вопрос добавился в коллекцию
        jqs.remove(QUESTION1.getQuestion(), QUESTION1.getAnswer());//удаляю вопрос из коллекции
        assertFalse(jqs.getAll().contains(QUESTION1)); //проверяю что тестовый вопрос удалился из коллекции
    }

    @Test
    public void getAllTest() {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы
        Set<Qestion> expectedSet = new HashSet<>(); //заполняю "ожидаемую" коллекцию
        expectedSet.add(new Qestion(QUESTION1.getQuestion(), QUESTION1.getAnswer()));
        expectedSet.add(new Qestion(QUESTION2.getQuestion(), QUESTION2.getAnswer()));
        expectedSet.add(new Qestion(QUESTION3.getQuestion(), QUESTION3.getAnswer()));
        expectedSet.add(new Qestion(QUESTION4.getQuestion(), QUESTION4.getAnswer()));
        expectedSet.add(new Qestion(QUESTION5.getQuestion(), QUESTION5.getAnswer()));
        assertNotNull(jqs.getAll()); //проверка, что коллекция не пуста
        assertEquals(expectedSet, jqs.getAll()); //проверка, что ожидаемая и актуальные коллекции совпадают
    }

    @Test
    public void addValidateParameterTest() {
        assertThrows(ParameterIsNullException.class, () -> jqs.add("", ""));
    }

    @Test
    public void getRandomQuestionTest() {
        assertThrows(ParameterIsNullException.class, () -> jqs.add("", ""));
    }

}