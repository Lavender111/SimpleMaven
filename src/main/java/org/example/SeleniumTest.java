package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static WebDriver driver = null;
    public static String url = "https://www.baidu.com/";

    @Before
    public void setUp() throws Exception{
        //加载相应的驱动
        System.setProperty("webdriver.chrome.driver","F:/软件测试/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void testId(){
        Assert.assertEquals("百度一下，你就知道",driver.getTitle());
        //获取输入框
        WebElement element = driver.findElement(By.id("kw"));
        //在搜索框输入selenium
        element.sendKeys("selenium");
        element.submit();
    }

    @Test
    public void testXpath(){
        Assert.assertEquals("百度一下，你就知道",driver.getTitle());
        //获取输入框
        WebElement element = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        //在搜索框输入selenium
        element.sendKeys("selenium");
        element.submit();
    }
}
