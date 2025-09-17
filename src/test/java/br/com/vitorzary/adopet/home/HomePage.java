package br.com.vitorzary.adopet.home;

import br.com.vitorzary.adopet.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public boolean verificarSeOsPetsEstaoAparecendoNaPagina() {
        try {
            return navegador.findElement(By.cssSelector(".cards > :nth-child(1) > img")).isDisplayed() &&
                    navegador.findElement(By.cssSelector(".cards > :nth-child(3) > img")).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
