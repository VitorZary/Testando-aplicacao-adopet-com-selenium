package br.com.vitorzary.adopet.inicial;

import br.com.vitorzary.adopet.PageObject;

public class InicialPage extends PageObject {

    private static final String URL_INICIAL = "https://adopet-frontend-cypress.vercel.app";

    public InicialPage() {
        super(null);
    }

    public void acessarPaginaInicial() {
        navegador.get(URL_INICIAL);
    }

    public boolean verificarSeOTituloDaPaginaE(String titulo) {
        return navegador.getTitle().equals(titulo);
    }

    public boolean verificarseTextoAdotarPodeMudarUmaVidaEstaPresenteNoHTML() {
        String pageSource = navegador.getPageSource();
        return pageSource.contains("Adotar pode mudar uma vida. Que tal buscar seu novo melhor amigo hoje? Vem com a gente!");
    }

    public boolean verificarseTextoQuemAmaAdotaEstaPresenteNoHTML() {
        String pageSource = navegador.getPageSource();
        return pageSource.contains("Quem ama adota!");
    }
}
