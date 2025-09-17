package br.com.vitorzary.adopet.perfil;

import br.com.vitorzary.adopet.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerfilPage extends PageObject {

    public PerfilPage(WebDriver navegador) {
        super(navegador);
    }

    public boolean verificarSeApareceONomeDoUsuario() {
        return navegador.findElement(By.id("nome")).getAttribute("value").equals("Darlene");
    }
}
