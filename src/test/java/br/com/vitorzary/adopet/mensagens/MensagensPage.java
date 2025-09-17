package br.com.vitorzary.adopet.mensagens;

import br.com.vitorzary.adopet.PageObject;
import br.com.vitorzary.adopet.home.HomePage;
import org.junit.jupiter.api.Assertions;
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

    public boolean validarMensagensDeErro() {
        String pageSource = navegador.getPageSource();

        return pageSource.contains("É necessário informar seu nome") &&
                pageSource.contains("Informe um número de telefone") &&
                pageSource.contains("É necessário informar o nome do animal") &&
                pageSource.contains("É necessário escrever uma mensagem");
    }

    public boolean validarMensagemEnviada(String mensagem) {
        return navegador.findElement(By.cssSelector("ul.enviadas > li:last-child")).getText().contains(mensagem);
    }
}
