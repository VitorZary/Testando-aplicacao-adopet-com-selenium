package br.com.vitorzary.adopet.inicial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InicialTests {
    private InicialPage paginaInicial;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        this.paginaInicial = new InicialPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaInicial.fecharNavegador();
    }

    @Test
    public void testVerificarSeOTituloDaPaginaEAdopet() {
        this.paginaInicial.acessarPaginaInicial();
        Assertions.assertTrue(paginaInicial.verificarSeOTituloDaPaginaE("AdoPet"));
    }

    @Test
    public void testVerificarSeTextoAdotarPodeMudarUmaVidaEstaPresente() {
        this.paginaInicial.acessarPaginaInicial();
        Assertions.assertTrue(this.paginaInicial.verificarseTextoAdotarPodeMudarUmaVidaEstaPresenteNoHTML());
    }

    @Test
    public void testVerificarSeTextoQuemAmaAdotaEstaPresente() {
        this.paginaInicial.acessarPaginaInicial();
        Assertions.assertTrue(this.paginaInicial.verificarseTextoQuemAmaAdotaEstaPresenteNoHTML());
    }

}
