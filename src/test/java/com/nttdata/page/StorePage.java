
package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    // LOCALIZADORES DE TIENDA

    public static By categoriaClothes = By.cssSelector("a[href$='/3-clothes']");
    public static By subcategoriaMen = By.cssSelector("a[href$='/4-men']");
    public static By primerProducto = By.cssSelector("a[href*='/men/1-1-hummingbird-printed-t-shirt.html']");
    public static By cantidadProducto = By.id("quantity_wanted");
    public static By botonAgregarCarrito = By.cssSelector("[data-button-action='add-to-cart']");


    //LOCALIZADORES DE CONFIRMACION
    public static By mensajeConfirmacion = By.id("myModalLabel");
    public static By precioUnitarioPopup = By.cssSelector("#blockcart-modal .product-price");
    public static By cantidadPopup = By.cssSelector(".product-quantity strong");
    public static By subtotalPopup = By.cssSelector(".subtotal.value");

    //VENTANA DEL CARRITO
    public static By botonFinalizarCompra = By.cssSelector("#blockcart-modal a[href*='carrito?action=show']");
    public static By tituloCarrito = By.cssSelector(".card-block h1");
    public static By cantidadCarrito = By.cssSelector(".js-cart-line-product-quantity");
    public static By precioUnitarioCarrito = By.cssSelector(".cart-item .current-price .price");
    public static By totalCarrito = By.cssSelector(".cart-total .value");


}
