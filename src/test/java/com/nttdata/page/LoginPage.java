package com.nttdata.page;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("user-name");
    public static By passInput = By.id("password");
    public static By loginButton = By.id("login-button");

    //LOGIN EXAMEN AUTOMATIZACION WEB
    public static By emailTienda = By.id("field-email");
    public static By passwordTienda = By.id("field-password");
    public static By botonIngresarTienda = By.id("submit-login");
    public static By mensajeErrorLogin = By.cssSelector("li.alert-danger");
    public static By usuarioAutenticado = By.cssSelector("a.account span.hidden-sm-down");
    public static By enlaceIniciarSesion = By.xpath("//a[.//span[normalize-space()='Iniciar sesión']]");



}
