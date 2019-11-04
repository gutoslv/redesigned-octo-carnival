package DesafioZup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pageObject.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {
  @AfterClass
  public static void teardown(){
    DriverFactory.closeDriver();
  }
}