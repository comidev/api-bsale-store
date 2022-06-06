# API Bsale Store
Endpoint: https://api-rest-bsale-store.herokuapp.com
## Categoria
/categories
### GET - getCategories: Obtener categorías
Get
#### Respuesta
```json
[
  {
    "id": Identificador único de la categoría,
    "name": Nombre de la categoría
  },
  {
    "id": 2,
    "name": "pisco"
  },
  ...
]
```
## Productos
/products

Casi todos los endpoints son paginados, por esto llevan dos variables: numPage y limit.
- numPage: Número de página
- limit: Número de items que ocupada

Ejemplo: numPage = 0 y limit = 10, devolverá los primeros 10 items, si numPage = 1, devolverá el segundo grupo de 10 items.

Respuesta:
```json
{
  "items": Lista de productos,
  "totalPages": Cantidad de páginas totales,
  "pageNumber": Número de página de la petición,
  "totalItems": Cantidad de items totales,
  "empty": Estado de vacío, si es True es porque está vacío,
  "first": Estado de si es la primera página,
  "last": Estado de si es la última página
}
```
Cuando un endpoint no es paginado se mencionará.
### GET - getProducts: Obtener productos
Ejemplo: ?numPage=0&limit=10
#### Respuesta
```json
{
  "items": [
    {
      "id": 5,
      "name": "ENERGETICA MR BIG",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/misterbig3308256.jpg",
      "price": 1490,
      "discount": 20,
      "category": {
        "id": 1,
        "name": "bebida energetica"
      }
    },
    ...
  ],
  "totalPages": 6,
  "pageNumber": 0,
  "totalItems": 57,
  "empty": false,
  "first": true,
  "last": false
}
```

### GET - getProductsSort: Obtener productos ordenados
/sort

Variables:
- by: El atributo por el cual se odenará, solo puede ser "name", "price" o "discount".
- order: El sentido o la dirección del orden, solo puede ser "asc" o "desc".

Ejemplo: sort?by=price&order=desc&numPage=0&limit=2
#### Respuesta
```json
{
  "items": [
    {
      "id": 33,
      "name": "RON PAMPERO ANIVERSARIO",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/ron_pampero_aniversario0311.jpg",
      "price": 20000,
      "discount": 15,
      "category": {
        "id": 3,
        "name": "ron"
      }
    },
    {
      "id": 91,
      "name": "PISCO MISTRAL NOBEL 40°",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/nobel409551.jpg",
      "price": 19990,
      "discount": 0,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    }
  ],
  ... (atributos de la paginación)
}
```

### GET - getProductsByNameContaining: Obtener productos por nombre que contenga un dato.
/name

Variables:
- name: El dato o texto que busca o que debe contener el nombre.

Ejemplo: name?name=pis&numPage=0&limit=2 // Buscando la palabra que contenga "pis"
#### Respuesta
```json
{
  "items": [
    {
      "id": 8,
      "name": "PISCO ALTO DEL CARMEN 35º",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/alto8532.jpg",
      "price": 7990,
      "discount": 10,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    },
    {
      "id": 9,
      "name": "PISCO ALTO DEL CARMEN 40º ",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/alto408581.jpg",
      "price": 5990,
      "discount": 0,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    }
  ],
  ...
}
```

### GET - getProductByCategory: Obtener productos por id de categoría.
/categoria/{id}

Variables:
- id: El id de la categoría que desea traer sus productos

Ejemplo: categoria/2?numPage=0&limit=2
#### Respuesta
```json
{
  "items": [
    {
      "id": 8,
      "name": "PISCO ALTO DEL CARMEN 35º",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/alto8532.jpg",
      "price": 7990,
      "discount": 10,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    },
    {
      "id": 9,
      "name": "PISCO ALTO DEL CARMEN 40º ",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/alto408581.jpg",
      "price": 5990,
      "discount": 0,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    }
  ],
  ...
}
```

### GET - getProductsByDiscountBetween: Obtener productos por descuento que se encuentre entre dos valores.
/descuentos

Variables:
- min: el valor mínimo del intervalo del descuento
- max: el valor mínimo del intervalo del descuento

Ejemplo: descuentos?min=10&max=20&numPage=0&limit=2 // descuento mayor o igual a 10 pero menor o igual a 20
#### Respuesta
```json
{
  "items": [
    {
      "id": 8,
      "name": "PISCO ALTO DEL CARMEN 35º",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/alto8532.jpg",
      "price": 7990,
      "discount": 10,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    },
    {
      "id": 68,
      "name": "Bebida Sprite 1 Lt",
      "urlImage": null,
      "price": 1250,
      "discount": 10,
      "category": {
        "id": 4,
        "name": "bebida"
      }
    }
  ],
  ...
}
```

### GET - getProductsByPriceBetween: Obtener productos por precio que se encuentre entre dos valores.
/precios

Variables:
- min: el valor mínimo del intervalo del descuento
- max: el valor mínimo del intervalo del descuento

Ejemplo: precios?min=10000&max=20000&numPage=0&limit=2
#### Respuesta
```json
{
  "items": [
    {
      "id": 92,
      "name": "PISCO MISTRAL NOBEL 46",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/nobelanejado9639.jpg",
      "price": 15990,
      "discount": 15,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    },
    {
      "id": 88,
      "name": "PISCO MISTRAL GRAN NOBEL 40°",
      "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/grannobel9104.jpg",
      "price": 19900,
      "discount": 0,
      "category": {
        "id": 2,
        "name": "pisco"
      }
    }
  ],
  ...
}
```

### GET - getDescuentoMayor: Obtener el mayor descuento de todos los productos
/descuentos/mayor

* No es paginado.
* Única respuesta

Ejemplo: descuentos/mayor

#### Respuesta
```json
{
  "discount": 30
}
```

### GET - getPrecioMayor: Obtener el mayor precio de todos los productos
/precios/mayor

* No es paginado.
* Única respuesta

Ejemplo: precios/mayor

#### Respuesta
```json
{
  "price": 20000
}
```
