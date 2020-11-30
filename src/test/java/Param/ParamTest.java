package Param;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

/**
 * @Author wangqian
 * @Date 2020-11-25 22:12
 * @Version 1.0
 */
public class ParamTest {
 /*   @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExpectedLocalMethodSource(String argument){

    }
    static Stream<String> stringProvider(){
        return Stream.of("hello,hi");
    }*/

    @ParameterizedTest
    @MethodSource
    void search(TestCase testCase){
        testCase.run();
    }
    static List<TestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase =
                 mapper.readValue(ParamTest.class.getResourceAsStream("/search.yml"),
                TestCase.class);

        return testCase.testCaseGenerate();
    }
}
