package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {
  private static WebDriver driver;

  /**
   * Construtor para que a classe não seja iniciada
   */
  private DriverFactory() {}

  /**
   * Instância um novo Webdriver caso não haja um
   * @return a instância do driver a ser utiliada
   */
  public static WebDriver getDriver() {
    if (driver == null){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  /**
   * Encerra a sessão de um WebDriver aberto
   */
  public static void closeDriver(){
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}