package br.com.vitorzary.adopet.cadastro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CadastroTests {
    private CadastroPage paginaCadastro;

    @BeforeEach
    public void beforeEach() {
        this.paginaCadastro = new CadastroPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaCadastro.fecharNavegador();
    }

    @Test
    public void testCadastroCorreto() throws InterruptedException {
        this.paginaCadastro.acessaPaginaDeCadastro();
        this.paginaCadastro.preencheFormularioDeCadastro("Darlene", "darlene026@email.com", "Senha123");
        this.paginaCadastro.submeteFormularioDeCadastro();

        Thread.sleep(10000);
        Assertions.assertTrue(this.paginaCadastro.verificaSeRedirecionouParaUrlLogin());
    }

    @Test
    public void testCadastroIncorreto() {
        this.paginaCadastro.acessaPaginaDeCadastro();
        this.paginaCadastro.submeteFormularioDeCadastro();

        Assertions.assertTrue(this.paginaCadastro.verificaSeMensagensDeValidacaoApareceram());
    }


}
