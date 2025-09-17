package br.com.vitorzary.adopet.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTests {
    private LoginPage paginaLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaLogin.fecharNavegador();
    }

    @Test
    public void testLoginCorreto() throws InterruptedException {
        paginaLogin.acessarPaginaDeLogin();
        paginaLogin.preencherFormularioDeLogin("darlene001@email.com", "Senha123");
        paginaLogin.submeteFormularioDeLogin();

        Thread.sleep(10000);
        Assertions.assertTrue(paginaLogin.verificarSeFezOLogin());
    }

    @Test
    public void testLoginIncorreto() {
        paginaLogin.acessarPaginaDeLogin();
        paginaLogin.submeteFormularioDeLogin();

        Assertions.assertTrue(paginaLogin.verificarSeMensagensDeValidacaoAparecem());
    }

    @Test
    public void testLoginFluxoAlternativo() throws InterruptedException {
        paginaLogin.acessarPaginaDeLoginViaBotaoDeMensagens();
        paginaLogin.preencherFormularioDeLogin("darlene001@email.com", "Senha123");
        paginaLogin.submeteFormularioDeLogin();

        Thread.sleep(10000);
        Assertions.assertTrue(paginaLogin.verificarSeFezOLogin());
    }

}
