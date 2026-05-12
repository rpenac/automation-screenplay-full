package co.reto.automatizacion.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import co.reto.automatizacion.tasks.Login;
import co.reto.automatizacion.questions.HomePageVisible;

import static org.junit.Assert.assertTrue;

public class LoginSauceDemoStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    private Actor usuario = Actor.named("Usuario");

    @Before
    public void setUp() {
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario abre la pagina de SauceDemo")
    public void abrirPagina() {
        usuario.attemptsTo(
                Open.url("https://www.saucedemo.com")
        );
    }

    @When("inicia sesion con credenciales validas")
    public void iniciarSesion() {
        usuario.attemptsTo(
                Login.conCredencialesValidas()
        );
    }

    @Then("visualiza la pagina de productos")
    public void validarProductos() {
        assertTrue(
                HomePageVisible.esVisible().answeredBy(usuario)
        );
    }
}

