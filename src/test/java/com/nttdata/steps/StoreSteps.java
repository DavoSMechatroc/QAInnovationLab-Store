
package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;


public class StoreSteps {

    private WebDriver driver;
    private AccionesWeb acciones;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
        this.acciones = new AccionesWeb(driver);
    }


    public void navegarCategoriaMen() {
        Actions mouse = new Actions(driver);
        mouse.moveToElement(driver.findElement(StorePage.categoriaClothes)).perform();
        acciones.hacerClick(StorePage.subcategoriaMen);
    }

    public void seleccionarPrimerProducto() {

        acciones.hacerClick(StorePage.primerProducto);
    }

    public void agregarProductoAlCarrito(int cantidad) {

        WebElement campoCantidad = driver.findElement(StorePage.cantidadProducto);

        campoCantidad.click();
        campoCantidad.sendKeys(Keys.CONTROL, "a");
        campoCantidad.sendKeys(String.valueOf(cantidad));

        acciones.hacerClick(StorePage.botonAgregarCarrito);
    }

    public String obtenerConfirmacionCarrito() {

        return acciones.obtenerTexto(StorePage.mensajeConfirmacion);
    }

    public boolean validarTotalPopup() {

        String textoPrecio = acciones.obtenerTexto(StorePage.precioUnitarioPopup);
        String textoCantidad = acciones.obtenerTexto(StorePage.cantidadPopup);
        String textoSubtotal = acciones.obtenerTexto(StorePage.subtotalPopup);

        double precio = Double.parseDouble(
                textoPrecio.replace("PEN", "").trim().replace(",", "."));

        int cantidad = Integer.parseInt(textoCantidad.trim());

        double subtotal = Double.parseDouble(
                textoSubtotal.replace("PEN", "").trim().replace(",", "."));

        return Math.abs((precio * cantidad) - subtotal) < 0.01;
    }

    public void finalizarCompra() {

        acciones.hacerClick(StorePage.botonFinalizarCompra);
    }

    public String obtenerTituloCarrito() {

        return acciones.obtenerTexto(StorePage.tituloCarrito);
    }

    public boolean validarTotalCarrito() {

        String textoPrecio = acciones.obtenerTexto(StorePage.precioUnitarioCarrito);
        String textoCantidad = driver.findElement(StorePage.cantidadCarrito)
                .getAttribute("value");
        String textoTotal = acciones.obtenerTexto(StorePage.totalCarrito);

        double precio = Double.parseDouble(
                textoPrecio.replace("PEN", "").trim().replace(",", "."));

        int cantidad = Integer.parseInt(textoCantidad.trim());

        double total = Double.parseDouble(
                textoTotal.replace("PEN", "").trim().replace(",", "."));

        return Math.abs((precio * cantidad) - total) < 0.01;
    }

    public boolean existeCategoria(String categoria) {

        By categoriaBuscada = By.cssSelector(
                "#top-menu > li > a"
        );

        return driver.findElements(categoriaBuscada)
                .stream()
                .anyMatch(elemento ->
                        elemento.getText().trim().equalsIgnoreCase(categoria));
    }

}
