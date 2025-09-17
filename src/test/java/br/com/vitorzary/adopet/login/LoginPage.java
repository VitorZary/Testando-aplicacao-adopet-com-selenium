package br.com.vitorzary.adopet.login;

import br.com.vitorzary.adopet.PageObject;
import br.com.vitorzary.adopet.home.HomePage;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private static final String URL_INICIAL = "https://adopet-frontend-cypress.vercel.app";
    private static final String URL_HOME = "https://adopet-frontend-cypress.vercel.app/home";

    public LoginPage() {
        super(null);
    }

    public void acessarPaginaDeLogin() {
        navegador.get(URL_INICIAL);
        navegador.findElement(By.cssSelector("[data-test='login-button']")).click();
    }

    public void preencherFormularioDeLogin(String email, String senha) {
        navegador.findElement(By.id("email")).sendKeys(email);
        navegador.findElement(By.id("pass")).sendKeys(senha);
    }

    public HomePage submeteFormularioDeLogin() {
        navegador.findElement(By.cssSelector("[data-test='submit-button']")).click();
        return new HomePage(navegador);
    }

    public boolean verificarSeFezOLogin() {
        return navegador.getCurrentUrl().equals(URL_HOME);
    }

    public boolean verificarSeMensagensDeValidacaoAparecem() {
        String pageSource = navegador.getPageSource();
        return pageSource.contains("É necessário informar um endereço de email") &&
                pageSource.contains("Insira sua senha");
    }

    public void acessarPaginaDeLoginViaBotaoDeMensagens() {
        navegador.get(URL_INICIAL);
        navegador.findElement(By.cssSelector(".header__message")).click();
    }
}
