package br.com.vitorzary.adopet.home;

import br.com.vitorzary.adopet.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTests {
    private LoginPage paginaLogin;
    private HomePage paginaHome;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        this.paginaLogin = new LoginPage();
        this.paginaLogin.acessarPaginaDeLogin();
        this.paginaLogin.preencherFormularioDeLogin("darlene001@email.com", "Senha123");
        this.paginaHome = this.paginaLogin.submeteFormularioDeLogin();

        Thread.sleep(10000);
    }

    @AfterEach
    public void afterEach() {
        this.paginaLogin.fecharNavegador();
    }

    @Test
    public void testAoLogarComUmUsuarioVerificarSeNaHomeAparecemImagensDosPets() {
        Assertions.assertTrue(this.paginaHome.verificarSeOsPetsEstaoAparecendoNaPagina());
    }


}
