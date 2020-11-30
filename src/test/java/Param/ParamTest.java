package Param;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @Author wangqian
 * @Date 2020-11-25 22:12
 * @Version 1.0
 */
public class ParamTest {
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExpectedLocalMethodSource(String argument){

    }
    static Stream<String> stringProvider(){
        return Stream.of("hello,hi");
    }
    @ParameterizedTest
    //@ValueSource(strings ={"demo1","demo2"})
    @MethodSource
    void search(TestCase testCase){
        /*ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);*/
        //driver.quit();
       // System.out.println(testCase);
        testCase.run();
    }
    static  Stream<TestCase> search() throws IOException {
        //return Stream.of("demo1","demo2");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
       // TypeReference typeReference = new TypeReference<List<String>>() {};
        TestCase testCase =
                 mapper.readValue(ParamTest.class.getResourceAsStream("/search.yml"),
                TestCase.class);

        return Stream.of(testCase);
    }
}
