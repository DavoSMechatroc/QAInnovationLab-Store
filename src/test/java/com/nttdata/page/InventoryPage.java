package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");
    public static By botonAgregarMochila = By.id("add-to-cart-sauce-labs-backpack");
    public static By botonAgregarSueter = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    public static By contadorCarrito = By.cssSelector("[data-test='shopping-cart-badge']");


}
