#  PROYECTO INTEGRADOR - TRANSACCIONES BANCARIAS

Este proyecto tiene como objetivo demostrar todos los conocimientos y el uso de las herramientas y tecnologías aprendidas en el bootcamp de backend de Makaia

Este servicio simula el proceso de depositos, consultas, creación y manejo en general de cuentas bancarias y bolsillos en dichas cuentas.


El proyecto esta hecho con las siguientes tecnologías:

<ol>
	<li>JAVA</li>
	<li>PostgreSql</li>
    <li>IntelliJ</li>
	<li>Git</li>
	<li>GitHub</li>
</ol>

Además en Java se hizo uso de Spring boot para utilizar las siguientes librerías:

<ol>
	<li>Rest-api</li>
	<li>Swagger</li>
	<li>Spring data</li>
	<li>Spring security</li>
	<li>lombok</li>
</ol>


La integración continua se implementó con Github Actions y el despliegue de la API se hizo en Railway.

## Enlace para consultar la documentación
### [https://bubbly-quietude-production.up.railway.app/swagger-ui/index.html#](https://bubbly-quietude-production.up.railway.app/swagger-ui/index.html#)
#### NOTA: usuario: user - password: password



# Endpoints:

## Tabla de urls:

| URL                                                                             | Funcion                      | Peticion |
|---------------------------------------------------------------------------------|------------------------------|----------|
| https://proyecto-384916.uc.r.appspot.com/api/accounts                           | Apertura de Cuentas          | POST     |
| https://proyecto-384916.uc.r.appspot.com/api/accounts/{account_number}/deposit  | Depósitos en cuentas         | POST     |
| https://proyecto-384916.uc.r.appspot.com/api/accounts/transfer                  | Transferencias entre cuentas | POST     |
| https://proyecto-384916.uc.r.appspot.com/api/accounts/{account_number}          | Consultar cuenta             | GET      |
| https://proyecto-384916.uc.r.appspot.com/api/pockets                            | Creación de bolsillos        | POST     |
| https://proyecto-384916.uc.r.appspot.com/api/pockets/transfer                   | Transferencias a bolsillos   | POST     |
| https://proyecto-384916.uc.r.appspot.com/api/accounts/{account_number}/pockets  | Consulta de bolsillos        | GET      |


## Ejemplos de uso

### /api/accounts  (POST. Apertura de Cuentas)
Parametros del body de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "owner_name": String,
        "initial_balance": Double
    }
```
Ejemplo de petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "owner_name": "John Doe",
        "initial_balance": 1000
    }
```

### /api/accounts/{account_number}/deposit (POST. Depósitos en cuentas)
Parametros del body de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "amount": Double
    }
```
Ejemplo de petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "amount": 5000
    }
```

### /api/accounts/transfer  (POST. Transferencias entre cuentas)
Parametros del body de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "source_account_number": String,
        "destination_account_number": String,
        "amount": Double
    }
```
Ejemplo de petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "source_account_number": "123456789",
        "destination_account_number": "987654321",
        "amount": 2000
    }
```

### /api/accounts/{account_number}  (GET. Consultar cuenta)
La petición recibe un numero de cuenta y retorna la información asociada a esta cuenta.

Ejemplo de la respuesta:
 ```java {.highlight .highlight-source-java .bg-black}
    {
        "account_number": "123456789",
        "owner_name": "John Doe",
        "balance": 15000
    }
```

### /api/pockets  (POST. Creación de bolsillos)
Parametros del body de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "account_number": String,
        "name": String,
        "initial_balance": Double
    }
```
Ejemplo de petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "account_number": "123456789",
        "name": "Vacations",
        "initial_balance": 2000
    }
```

### /api/pockets/transfer  (POST. Transferencia a bolsillos)
Parametros del body de la petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "account_number": String,
        "pocket_number": String,
        "amount": 1000
    }
```
Ejemplo de petición:
  ```java {.highlight .highlight-source-java .bg-black}
    {
        "account_number": "123456789",
        "pocket_number": "P001",
        "amount": 1000
    }
```

### /api/accounts/{account_number}/pockets  (GET. Consulta de bolsillos)
La petición recibe un numero de cuenta y retorna los bolsillos asociados a dicha cuenta.

Ejemplo de la respuesta:
 ```java {.highlight .highlight-source-java .bg-black}
    [
        {
        "name": "Vacations",
        "pocket_number": "P001",
        "amount": 50000
        },
        {
        "name": "taxes",
        "pocket_number": "P002",
        "amount": 25000
        }
    ]
```

# Diagrama UML

![image](uml.png)

# Diagrama Entidad-Relación

![image](entidad-relacion.png)


