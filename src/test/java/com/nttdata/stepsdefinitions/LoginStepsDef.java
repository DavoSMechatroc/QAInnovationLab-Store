package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import com.nttdata.page.LoginPage;
import com.nttdata.steps.AccionesWeb;

import java.time.Duration;

import static com.nttdata.core.DriverManager.*;

public class LoginStepsDef {

    private WebDriver driver;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }


    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String correo, String clave) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.iniciarSesionTienda(correo, clave);
        screenShot();
    }

    @Entonces("valido que el usuario inició sesión correctamente")
    public void validoQueElUsuarioInicioSesionCorrectamente() {
        AccionesWeb acciones = new AccionesWeb(driver);

        String nombreUsuario = acciones.obtenerTexto(LoginPage.usuarioAutenticado);

        Assertions.assertFalse(nombreUsuario.trim().isEmpty(),
                "No se encontró el nombre del usuario autenticado");

        screenShot();
    }

    @Entonces("valido que aparezca el error de autenticación")
    public void validoQueAparezcaElErrorDeAutenticacion() {
        LoginSteps loginSteps = new LoginSteps(driver);

        String mensajeError = loginSteps.obtenerMensajeErrorLogin();

        Assertions.assertEquals("Error de autenticación.", mensajeError.trim());

        screenShot();
    }


}
