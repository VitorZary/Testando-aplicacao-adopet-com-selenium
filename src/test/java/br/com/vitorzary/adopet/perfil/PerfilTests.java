package br.com.vitorzary.adopet.perfil;

import br.com.vitorzary.adopet.home.HomePage;
import br.com.vitorzary.adopet.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerfilTests {
    private LoginPage paginaLogin;
    private HomePage paginaHome;
    private PerfilPage paginaPerfil;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        this.paginaLogin = new LoginPage();
        this.paginaLogin.acessarPaginaDeLogin();
        this.paginaLogin.preencherFormularioDeLogin("darlene001@email.com", "Senha123");
        this.paginaHome = this.paginaLogin.submeteFormularioDeLogin();

        Thread.sleep(10000);
        this.paginaPerfil = this.paginaHome.navegarParaPaginaDePerfil();
        Thread.sleep(2000);
    }

    @AfterEach
    public void afterEach() {
        this.paginaLogin.fecharNavegador();
    }

    @Test
    public void testVerificarSeNaPaginaDePerfilApareceNomeDoUsuario() {
        Assertions.assertTrue(paginaPerfil.verificarSeApareceONomeDoUsuario());
    }

}
