package tests;

import org.junit.jupiter.api.*;


public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("### beforeall\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("### beforeEach\n");
        result = getResult();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterall\n");
    }


    @Test
     void FirstTest() {
        int result = getResult();
        System.out.println("### firstTest");
        Assertions.assertTrue(result>2);
    }

    @Test
    void secondTest() {
        System.out.println("### secondTest");

        Assertions.assertTrue(result>2);
    }

    @Test
    void thirdTest() {
        System.out.println("### thirdTest");

        Assertions.assertTrue(result>2);
    }

    private int getResult() {
        return 3;
    }
}
