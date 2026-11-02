
#language: es
@teststore
Característica: Product - Store

  @loginValido
  Escenario: Inicio de sesión con credenciales válidas
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "sandav1302@gmail.com" y clave "Davos20267#$"
    Entonces valido que el usuario inició sesión correctamente
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y selecciono el primer producto
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito



  @loginInvalido
  Escenario: Inicio de sesión con credenciales inválidas
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "correo_invalido@example.com" y clave "ClaveIncorrecta123"
    Entonces valido que aparezca el error de autenticación



  @categoriaInvalida
  Escenario: Validar una categoria inexistente
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "sandav1302@gmail.com" y clave "Davos20267#$"
    Entonces valido que el usuario inició sesión correctamente
    Y valido que la categoria "AUTOS" no exista

