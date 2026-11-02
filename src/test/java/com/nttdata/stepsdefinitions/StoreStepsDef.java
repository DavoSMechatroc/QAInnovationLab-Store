
package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class StoreStepsDef {

    private WebDriver driver;

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.navegarCategoriaMen();

        screenShot();
    }

    @Y("selecciono el primer producto")
    public void seleccionoElPrimerProducto() {
        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.seleccionarPrimerProducto();

        screenShot();
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProducto(int cantidad) {
        driver = getDriver();
        StoreSteps storeSteps = new StoreSteps(driver);

        storeSteps.seleccionarPrimerProducto();
        storeSteps.agregarProductoAlCarrito(cantidad);

        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoConfirmacionProductoAgregado() {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);
        String mensaje = storeSteps.obtenerConfirmacionCarrito();

        Assertions.assertTrue(
                mensaje.contains("Producto añadido correctamente"),
                "No apareció la confirmación del carrito"
        );

        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoMontoTotalPopup() {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);

        Assertions.assertTrue(
                storeSteps.validarTotalPopup(),
                "El subtotal del popup no coincide con el precio por la cantidad"
        );

        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.finalizarCompra();

        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoTituloPaginaCarrito() {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);

        Assertions.assertEquals("CARRITO",
                storeSteps.obtenerTituloCarrito().trim(),
                "El titulo del carrito no es correcto");

        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void validoCalculoPreciosCarrito() {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);

        Assertions.assertTrue(
                storeSteps.validarTotalCarrito(),
                "El total del carrito no coincide con el precio por la cantidad"
        );

        screenShot();
    }


    //VALIDACION DE TERCER ESENARIO
    @Entonces("valido que la categoria {string} no exista")
    public void validoCategoriaInexistente(String categoria) {

        driver = getDriver();

        StoreSteps storeSteps = new StoreSteps(driver);

        boolean existe = storeSteps.existeCategoria(categoria);

        Assertions.assertFalse(existe,
                "La categoria " + categoria + " existe en la tienda");

        System.out.println("VALIDACION: La categoria '" + categoria
                + "' no existe en la tienda. No se continua con la navegacion.");

        screenShot();
    }



}
