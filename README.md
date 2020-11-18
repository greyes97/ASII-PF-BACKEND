# Clinic API

Clinic disponibiliza una API REST que permite la getsion de la informacion para clinicas medicas.
Permite la creaion de citas medicas, gestion de pacientes, hitorial mdedico de los pacientes, y asignacion 
de habitaciones a los pacientes.

Las preguntas y solicitudes relacionadas con el acceso a la API deben enviarse al correo electrónico 
proyectosoftwareumg@gmail.com.

Recursos disponibles que proporciona la API:

* Gestion de la infromacion de los pacientes.
* Gestion de citas medicas.
* Control de habitaciones para los pacientes internados en la clinica.
* Historial medico por paciente.
* Recetar medicamentos.


## Metodos

Las solicitudes de la API deben seguir los estándares siguientes:

| Metodo | Descripcion |
| ------------- | ------------- |
| GET | Devuelve información de uno o más registros. |
| POST  | Se utiliza para crear un nuevo registro. |
| PUT  | Actualiza los datos de un registro o cambia su estado. |
| DELETE  |Elimina un registro del sistema. |


## Manejo de Respuestas

| codigo| Descripcion |
| ------------- | ------------- |
| 200 | Solicitud ejecutada con éxito. |
| 400  | Los errores de validación o los campos informados no existen en el sistema. |
| 401  | Datos de acceso no válidos. |
| 404 |Registro no encontrado. |
| 405 |Método no implementado. |
| 410 | El registro buscado se ha eliminado del sistema y ya no está disponible. |
| 420 |Los datos reportados están fuera del alcance definido para el campo. |
| 422 |Se alcanzó el número máximo de solicitudes. (espera unos segundos y vuelve a intentarlo) |

## Listar Datos

Las acciones de la lista permiten el envío de los siguientes parámetros:

| Parametro| Descripcion |
| ------------- | ------------- |
| Filtro | Filtra los datos por el valor ingresado. |


## Autenticacion

Para utilizar el Sistema necesita un usuario generardo por el adminitrador del mismo.

Si el usuario autoriza el acceso, nuestro sistema utilizará redirect_uri para redirigir al 
usuario a su aplicación, informando el parámetro de código.

## Ejemplo metodo Get.
### Listar {GET}

* Request (application/json)

localhost:8485/patient

* Response 200 (application/json)

 -{
  -  "message": "success",
   - "responsePatient": [
    -    {
     -       "idPatient": 74,
      -      "dpi": "7878880005888",
       -     "nit": "878978978",
        -    "birthday": "2020-11-17",
         -   "gender": "m",
          -  "fullName": "Angel",
           - "surName": "Garcia Reyes",
           - "address": "Guatemala",
            -"phone": 98956526,
            -"emergencyContact": 78545785,
            -"statePatient": false,
            -"statusWait": false
        -},
        -{
            -"idPatient": 75,
            -"dpi": "7878878458888",
            -"nit": "986556877",
            -"birthday": "2020-11-18",
            -"gender": "m",
            -"fullName": "Gustavo Fernando",
            -"surName": "Reyes Sicay",
            -"address": "Guatemala, Ciudad Vieja",
            "phone": 95652354,
            "emergencyContact": 78784512,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 76,
            "dpi": "1245784548",
            "nit": "989895623",
            "birthday": "2020-11-19",
            "gender": "f",
            "fullName": "Developer Jr",
            "surName": "Full Stack",
            "address": "Guatemala",
            "phone": 78758454,
            "emergencyContact": 98978787,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 77,
            "dpi": "2386749450313",
            "nit": "787525487",
            "birthday": "2020-11-25",
            "gender": "m",
            "fullName": "Fernando Alexander",
            "surName": "Reyes Garcia",
            "address": "Ciudad Vieja, La antigua Guatemala.",
            "phone": 95623231,
            "emergencyContact": 78451212,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 78,
            "dpi": "2386749325413",
            "nit": "785421454",
            "birthday": "2020-11-11",
            "gender": "f",
            "fullName": "Angel Arturo",
            "surName": "Sicay Reyes",
            "address": "Ciudad Guatemala, Guatemala.",
            "phone": 96523215,
            "emergencyContact": 78323454,
            "statePatient": true,
            "statusWait": false
        },
        {
            "idPatient": 79,
            "dpi": "2386749970313",
            "nit": "787454547",
            "birthday": "2020-12-04",
            "gender": "m",
            "fullName": "Gustavo Angel Arturo",
            "surName": "Garcia Reyes",
            "address": "Guatemala, Guatemala.",
            "phone": 95623554,
            "emergencyContact": 78454578,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 80,
            "dpi": "7855245221887",
            "nit": "112002154",
            "birthday": "2020-11-25",
            "gender": "m",
            "fullName": "Fernanda",
            "surName": "Sicay Garcia",
            "address": "Ciudad Guatemala, Guatemala",
            "phone": 78322040,
            "emergencyContact": 78888878,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 81,
            "dpi": "8785544784512",
            "nit": "784545124",
            "birthday": "2020-11-19",
            "gender": "m",
            "fullName": "Developer Jr",
            "surName": "lopez lopez",
            "address": "Ciudad Guatemala",
            "phone": 87978545,
            "emergencyContact": 98784545,
            "statePatient": true,
            "statusWait": false
        },
        {
            "idPatient": 82,
            "dpi": "7841122000000",
            "nit": "787878455",
            "birthday": "2020-11-16",
            "gender": "m",
            "fullName": "Angel Garcia",
            "surName": "Sicay Reyes",
            "address": "Ciudad Guatemala.",
            "phone": 12200555,
            "emergencyContact": 77445551,
            "statePatient": false,
            "statusWait": false
        },
        {
            "idPatient": 83,
            "dpi": "5457845555555",
            "nit": "457878878",
            "birthday": "2020-11-26",
            "gender": "f",
            "fullName": "Angel Gustavo",
            "surName": "Sicay Reyes",
            "address": "Guatemala",
            "phone": 87452124,
            "emergencyContact": 78751451,
            "statePatient": true,
            "statusWait": false
        }
    ],
    "status": true,
    "typeMessage": 1
}



