package training.employee;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateEmployeeSeleniumIT {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\training\\chromedriver.exe");
    driver = new ChromeDriver();
//    driver = new FirefoxDriver();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  public void typeName(String name) {
    driver.findElement(By.id("createForm:nameInput")).click();
    driver.findElement(By.id("createForm:nameInput")).sendKeys(name);
  }

  @Test
  public void createEmployee() {
    driver.get("http://localhost:8080/employees.xhtml");
    driver.manage().window().setSize(new Dimension(1300, 827));

    for (int i = 0 ; i < 10; i++) {
      driver.findElement(By.linkText("Create employee")).click();
      typeName("John Doe" + i);
      driver.findElement(By.id("createForm:createButton")).click();
    }

    assertEquals("Employee has created", driver.findElement(By.cssSelector("li")).getText());
  }
}
