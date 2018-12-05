package io.sherlock.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

/**
 * @author Pedro Ribeiro
 *
 */
@Component
public class Buscador {
   
   public static void main(String[] args) throws InterruptedException {
      
      System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
      System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
      System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
      
      String site = "https://www.casasbahia.com.br";
      
      WebDriver driver = new FirefoxDriver();
      driver.get(site);
      
      System.out.println("Estou pesquisando no " + driver.getTitle());

      WebElement web = driver.findElement(By.id("strBusca"));
      web.sendKeys("x box one");
      web.submit();

      Thread.sleep(5000);

      System.out.println("Resultado da pesquisa: " + driver.getTitle());

      List<WebElement> elementa = driver.findElements(By.className("nm-product-info"));

      if (elementa.equals(null)) {
         System.out.println("Nenhum elemento encontrado!");
      } else {
         for (WebElement webElement : elementa) {
            System.out.println("Titulo:" + webElement.findElement(By.tagName("a")).getAttribute("title"));
            // System.out.println("Preço Regular:" (webElement.findElement(By.className("nm-old-price-value")).getText()));
            System.out.println("Preço Desconto:" + webElement.findElement(By.className("nm-price-value")).getText());
            System.out.println("Parcelado:" + webElement.findElement(By.className("nm-installment-container")).getText());
            System.out.println();
         }
      }
      driver.quit();
   }
   
}