package Param;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangqian
 * @Date 2020-11-25 23:19
 * @Version 1.0
 */
public class TestCase {

    public List<String> data;
    public List<HashMap<String,Object>> steps;
    private ChromeDriver driver;
    private WebElement currentElement;
    public int index=0;

    //取出data中的值
    public List<TestCase> testCaseGenerate(){
        List<TestCase> testCaseList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            TestCase testCase = new TestCase();
            testCase.index=i;
            testCase.steps=steps;
            testCase.data=data;
            testCaseList.add(testCase);
        }
        return testCaseList;
    }

    public Object getValue(HashMap<String,Object> step,String key){
        Object value = step.get(key);
        if(value instanceof String){
            //如果值是string类型进行替换
          return ((String)value).replace("${data}",data.get(index));
        }else {
            return value;
        }
    }
    public Object getValue(HashMap<String,Object> step,String key,Object defalutValur){
       return step.getOrDefault(key,defalutValur);
    }

    public void run(){
        steps.forEach(step->{
            if(step.keySet().contains("chrome")){
                driver = new ChromeDriver();
            }
            if(step.keySet().contains("implicitly_wait")){
                driver.manage().timeouts().implicitlyWait((int)getValue(step,"implicitly_wait",5),TimeUnit.SECONDS);
            }

            if(step.keySet().contains("get")){
                driver.get(getValue(step,"get").toString());
            }
            if(step.keySet().contains("sleep")){

                try {
                    Thread.sleep(Long.valueOf(getValue(step,"sleep").toString()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(step.keySet().contains("quit")){
                //driver.quit();
            }
            if(step.keySet().contains("find")){
                ArrayList<By> bys = new ArrayList<>();
                ((HashMap<String,String>)getValue(step,"find")).entrySet().forEach(stringStringEntry -> {
                    if(stringStringEntry.getKey().contains("id")){
                        bys.add(By.id(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("xpath")){
                        bys.add(By.xpath(stringStringEntry.getValue()));
                    }
                    if (stringStringEntry.getKey().contains("className")){
                        bys.add(By.className(stringStringEntry.getValue()));
                    }
                });
                currentElement = driver.findElement(bys.get(0));
            }
            if(step.keySet().contains("click")){
                currentElement.click();
            }
            if(step.keySet().contains("send_keys")){
                currentElement.sendKeys(getValue(step,"send_keys").toString());
            }
        });
    }
}
