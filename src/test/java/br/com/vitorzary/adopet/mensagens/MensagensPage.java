package br.com.vitorzary.adopet.mensagens;

import br.com.vitorzary.adopet.PageObject;
import br.com.vitorzary.adopet.home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MensagensPage extends PageObject {

    public MensagensPage(WebDriver navegador) {
        super(navegador);
    }

    public void preencherFormularioDeMensagens(String nome, String telefone, String petName, String mensagem) {
        navegador.findElement(By.id("name")).sendKeys(nome);
        navegador.findElement(By.id("phone")).sendKeys(telefone);
        navegador.findElement(By.id("petName")).sendKeys(petName);
        navegador.findElement(By.id("msg")).sendKeys(mensagem);

    }

    public HomePage submeterFormularioDeMensagens() {
        navegador.findElement(By.cssSelector("[data-test='submit-button']")).click();
        return new HomePage(navegador);
    }

    public boolean contemTexto(String texto) {
        String pageSource = navegador.getPageSource();
        return pageSource.contains(texto);
    }

}
