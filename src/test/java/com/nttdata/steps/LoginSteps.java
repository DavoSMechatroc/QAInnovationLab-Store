package com.nttdata.steps;

import com.nttdata.core.DriverManager;
import com.nttdata.page.InventoryPage;
import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.*;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }
    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user) {
        AccionesWeb acciones = new AccionesWeb(driver);
        acciones.escribirTexto(LoginPage.userInput, user);
    }
    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password) {
        AccionesWeb acciones = new AccionesWeb(driver);
        acciones.escribirTexto(LoginPage.passInput, password);
    }
    /**
     * Hacer click en el botón login
     */
    public void login() {
        AccionesWeb acciones = new AccionesWeb(driver);
        acciones.hacerClick(LoginPage.loginButton);
    }
    public void ingresoUsuarioYClave(String user, String password) {
        typeUser(user);
        typePassword(password);
        esperaImplicita();
        login();
    }

    //INICIO DE SESION
    public void iniciarSesionTienda(String correo, String clave) {
        AccionesWeb acciones = new AccionesWeb(driver);
        acciones.hacerClick(LoginPage.enlaceIniciarSesion);
        acciones.escribirTexto(LoginPage.emailTienda, correo);
        acciones.escribirTexto(LoginPage.passwordTienda, clave);
        acciones.hacerClick(LoginPage.botonIngresarTienda);
    }

    //MENSAJE DE ERROR LOGIN
    public String obtenerMensajeErrorLogin() {
        AccionesWeb acciones = new AccionesWeb(driver);

        return acciones.obtenerTexto(LoginPage.mensajeErrorLogin);
    }

}
