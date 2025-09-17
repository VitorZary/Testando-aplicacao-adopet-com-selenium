package br.com.vitorzary.adopet.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageObject {
    protected WebDriver navegador;

    public PageObject(WebDriver navegador) {
        WebDriverManager.chromedriver().setup();

        if(navegador == null){
            this.navegador = new ChromeDriver();
            this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }else {
            this.navegador = navegador;
        }

    }

    public void fecharNavegador() {
        this.navegador.quit();
    }
}
