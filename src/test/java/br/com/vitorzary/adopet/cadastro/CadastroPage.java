package br.com.vitorzary.adopet.cadastro;

import br.com.vitorzary.adopet.PageObject;
import org.openqa.selenium.By;

public class CadastroPage extends PageObject {

    private static final String URL_INICIAL = "https://adopet-frontend-cypress.vercel.app";
    private static final String URL_LOGIN = "https://adopet-frontend-cypress.vercel.app/login";

    public CadastroPage() {
        super(null);
    }

    public void acessaPaginaDeCadastro() {
        navegador.get(URL_INICIAL);
        navegador.findElement(By.cssSelector("[data-test='register-button']")).click();
    }

    public void preencheFormularioDeCadastro(String nome, String email, String senha) {
        navegador.findElement(By.id("name")).sendKeys(nome);
        navegador.findElement(By.id("email")).sendKeys(email);
        navegador.findElement(By.id("pass-create")).sendKeys(senha);
        navegador.findElement(By.id("pass-confirm")).sendKeys(senha);
    }

    public void submeteFormularioDeCadastro() {
        navegador.findElement(By.cssSelector("[data-test='submit-button']")).click();
    }

    public boolean verificaSeRedirecionouParaUrlLogin() {
        return navegador.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean verificaSeMensagensDeValidacaoApareceram() {
        String pageSource = navegador.getPageSource();

        return pageSource.contains("É necessário informar um endereço de email") &&
                pageSource.contains("Crie uma senha") &&
                pageSource.contains("Repita a senha criada acima");
    }
}
