package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

  static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

  /**
   * Define o texto em um campo inpuy
   * @param by o caminho do elemento
   * @param text o texto a ser inserid
   */
  public static void setText(By by, String text) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    DriverFactory.getDriver().findElement(by).sendKeys(text);
  }

  /**
   * Retorna o texto de um elemento na página
   * @param by o caminho do elemento
   * @return o texto do elemento
   */
  public static String getText(By by){
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    return DriverFactory.getDriver().findElement(by).getText();
  }

  /**
   * Obtem a URL atual da página
   * @return URL atual da página
   */
  public static String getCurrentUrl(){
    return DriverFactory.getDriver().getCurrentUrl();
  }

  /**
   * Navega até uma URL
   * @param Url URL a ser acessada
   */
  public static void navigateToUrl(String Url){
    DriverFactory.getDriver().navigate().to(Url);
    DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  /**
   * Clica em um elemento na página
   * @param by caminho do elemento a ser clicado
   */
  public static void clickElement(By by){
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    DriverFactory.getDriver().findElement(by).click();
  }

  /**
   * Verifica a presença de um elemento na página
   * @param by caminho do elemento a ser verificado
   * @return true se o elemento existe na página, false se não existir
   */
  public static boolean isElementOnPage(By by){
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    try {
      DriverFactory.getDriver().findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
