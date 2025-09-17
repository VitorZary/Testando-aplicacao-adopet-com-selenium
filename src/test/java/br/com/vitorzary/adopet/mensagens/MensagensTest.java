package br.com.vitorzary.adopet.mensagens;

import br.com.vitorzary.adopet.home.HomePage;
import br.com.vitorzary.adopet.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MensagensTest {
    private LoginPage paginaLogin;
    private HomePage paginaHome;
    private MensagensPage paginaMensagens;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        this.paginaLogin = new LoginPage();
        this.paginaLogin.acessarPaginaDeLogin();
        this.paginaLogin.preencherFormularioDeLogin("darlene001@email.com", "Senha123");
        this.paginaHome = this.paginaLogin.submeteFormularioDeLogin();
        Thread.sleep(10000);
        this.paginaMensagens = this.paginaHome.navegarParaPaginaDeMensagens();
        Thread.sleep(3000);
    }

    @AfterEach
    public void afterEach() {
        this.paginaLogin.fecharNavegador();
    }

    @Test
    public void testComUsuarioLogadoValidarSeAsMensagensSaoEnviadasCorretamente() throws InterruptedException {
        paginaMensagens.preencherFormularioDeMensagens("Darlene", "83988412999", "Dunga", "Gostaria do cachorro chamado Dunga porque eu achei ele muito bonito.");
        paginaHome = paginaMensagens.submeterFormularioDeMensagens();
        Thread.sleep(3000);
        paginaMensagens = paginaHome.navegarParaPaginaDeMensagens();
        Thread.sleep(3000);
        Assertions.assertTrue(paginaMensagens.validarMensagemEnviada("Gostaria do cachorro chamado Dunga porque eu achei ele muito bonito."));
    }

    @Test
    public void testComUsuarioLogadoVerificarSeSaoMostradasMensagensDeErroAoSubmeterFormularioDeMensagensVazio() throws InterruptedException {
        paginaMensagens.submeterFormularioDeMensagens();
        Thread.sleep(3000);

        Assertions.assertTrue(paginaMensagens.validarMensagensDeErro());
    }
}
