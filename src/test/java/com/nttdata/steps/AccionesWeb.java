
package com.nttdata.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class AccionesWeb {

    WebDriver driver;
    WebDriverWait wait;

    public AccionesWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void hacerClick(By elemento) {

        wait.until(ExpectedConditions.elementToBeClickable(elemento)).click();
    }

    public void escribirTexto(By elemento, String texto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento))
                .sendKeys(texto);
    }

    public void hacerScroll(int pixeles) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixeles);
    }

    public String obtenerTexto(By elemento) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(elemento)
        ).getText();
    }

}
