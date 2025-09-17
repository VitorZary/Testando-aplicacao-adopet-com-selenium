package br.com.vitorzary.adopet.home;

import br.com.vitorzary.adopet.inicial.InicialPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeSemLogarTests {

    private InicialPage inicialPage;
    private HomePage homePage;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        this.inicialPage = new InicialPage();
        this.inicialPage.acessarPaginaInicial();
        this.homePage = this.inicialPage.clicarNoBotaoVerPetsDisponiveisParaAdocao();
        Thread.sleep(3000);
    }

    @AfterEach
    public void afterEach() {
        this.inicialPage.fecharNavegador();
    }

    @Test
    public void testAcessarAPaginaHomeSemLogarEVerificarSeOsPetsSaoMostrados() {
        Assertions.assertTrue(homePage.verificarSeOsPetsEstaoAparecendoNaPagina());
    }

}
