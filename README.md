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
	
		localhost:8485/patient=74
	
* Response 200 (application/json)

	+
		"message": "success",
		"responsePatient": 
				{
					"idPatient": 74,
					
					"dpi": "7878880005888",
					
					"nit": "878978978",
					"birthday": "2020-11-17",
					"gender": "m",
					"fullName": "Angel",
					"surName": "Garcia Reyes",
					"address": "Guatemala",
					"phone": 98956526,
					"emergencyContact": 78545785,
					"statePatient": false,
					"statusWait": false
				},
        