let empleados;
function getAllEmpleado() {
    //alert("Si");

    //A donde va a ir
    fetch("http://localhost:8080/sicefaSucursal/api/empleado/getAll")
            .then(response => response.json())
            .then(response => {
                empleados = response;
                let datos = "";
                let i = 0;
                empleados.forEach((empleado) => {
                    let dato1 = empleado.idEmpleado + "<br>"
                            + empleado.codigo + "<br>"
                            + empleado.fechaIngreso + "<br>"
                            + empleado.puesto + "<br>"
                            + empleado.salarioBruto;

                    let dato2 = empleado.persona.nombre + "<br>"
                            + empleado.persona.apellidoPaterno + "<br>"
                            + empleado.persona.apellidoMaterno;

                    let dato3 = empleado.persona.genero + "<br>"
                            + empleado.persona.fechaNacimiento + "<br>"
                            + empleado.persona.rfc + "<br>"
                            + empleado.persona.curp;

                    let dato4 = empleado.persona.domicilio + "<br>"
                            + empleado.persona.codigoPostal + "<br>"
                            + empleado.persona.cuidad + "<br>"
                            + empleado.persona.estado + "<br>"
                            + empleado.persona.telefono;

                    let dato5 = empleado.usuario.nombreUsuario + "<br>"
                            + empleado.usuario.contrasenia + "<br>"
                            + empleado.usuario.rol;

                    let dato6 = empleado.sucursal.nombre + "<br>"
                            + empleado.sucursal.domicilio + "<br>"
                            + empleado.sucursal.colonia + "<br>"
                            + empleado.sucursal.codigoPostal + "<br>"
                            + empleado.sucursal.ciudad + "<br>"
                            + empleado.sucursal.estado + "<br>"
                            + empleado.sucursal.telefono;

                    datos += "<tr>";
                    datos += "<td>" + dato1 + "</td>";
                    datos += "<td>" + dato2 + "</td>";
                    datos += "<td>" + dato3 + "</td>";
                    datos += "<td>" + dato4 + "</td>";
                    datos += "<td>" + dato5 + "</td>";
                    datos += "<td>" + dato6 + "</td>";
                    datos += "<td> <button type='button' onclick='modificarEmpleado(" + i + ")'>Modificar</button> </td>";
                    datos += "<td> <button type='button' onclick='eliminarEmpleado(" + empleado.idEmpleado + ")'>Eliminar</button> </td>";
                    datos += "<td> <button type='button' onclick='reactivarEmpleado(" + empleado.idEmpleado + ")'>Reactivar</button> </td>";


                    datos += "</tr>";
                    i++;
                });
                document.getElementById("tbEmpleados").innerHTML = datos;
            });
}

function filterTable(searchTerm) {
    const tableRows = document.querySelectorAll('#tbEmpleados tr');

    tableRows.forEach(row => {
        const cells = row.getElementsByTagName('td');
        let found = false;

        for (let i = 0; i < cells.length; i++) {
            const cellContent = cells[i].textContent.toLowerCase();

            if (cellContent.includes(searchTerm)) {
                found = true;
                break;
            }
        }

        if (found) {
            row.style.display = ''; // Mostrar la fila
        } else {
            row.style.display = 'none'; // Ocultar la fila
        }
    });
}
const searchInput = document.getElementById('searchInput');
searchInput.addEventListener('input', function () {
    const searchTerm = searchInput.value.toLowerCase();
    filterTable(searchTerm);
});


//http://localhost:8080/sicefaSucursal/api/empleado/getAll
function reactivarEmpleado(empleado) {
    let idEmpleado = empleado;
    fetch("http://localhost:8080/sicefaSucursal/api/empleado/reactivar?idE=" + idEmpleado)
            .then(response => response.json())
            .then(response => {
                if (response.result == "success") {
                    Swal.fire(response.result, "Empleado reactivado");
                    //alert("Empleado eliminado");
                } else {
                    Swal.fire(response.error, "error Empleado activado");
                    //alert("Error al eliminar");
                }
                getAllEmpleado();
            });
}

function eliminarEmpleado(empleado) {
    let idEmpleado = empleado;
    fetch("http://localhost:8080/sicefaSucursal/api/empleado/delete?idE=" + idEmpleado)
            .then(response => response.json())
            .then(response => {
                if (response.result == "success") {
                    Swal.fire(response.result, "Empleado eliminado");
                    //alert("Empleado eliminado");
                } else {
                    Swal.fire(response.error, "Empleado eliminado");
                    //alert("Error al eliminar");
                }
                getAllEmpleado();
            });
}
function modificarEmpleado(i) {
    //Datos persona
    document.getElementById("txtaCodigoImagen").value = empleados[i].persona.foto;
    document.getElementById("txtIdPersona").value = empleados[i].persona.idPersona;
    document.getElementById("txtNombre").value = empleados[i].persona.nombre;
    document.getElementById("txtApellidoPaterno").value = empleados[i].persona.apellidoaterno;
    document.getElementById("txtApellidoMaterno").value = empleados[i].persona.apellidoMaterno;
    document.getElementById("cmbGenero").value = empleados[i].persona.genero;
    document.getElementById("txtFechaNacimiento").value = empleados[i].persona.fechaNacimiento;
    document.getElementById("txtRfc").value = empleados[i].persona.rfc;
    document.getElementById("txtCurp").value = empleados[i].persona.curp;
    document.getElementById("txtDomicilio").value = empleados[i].persona.domicilio;
    document.getElementById("txtCp").value = empleados[i].persona.codigoPostal;
    document.getElementById("txtCiudad").value = empleados[i].persona.ciudad;
    document.getElementById("txtEstado").value = empleados[i].persona.estado;
    document.getElementById("txtTelefono").value = empleados[i].persona.telefono;
    //Datos empleado
    document.getElementById("txtIdEmpleado").value = empleados[i].IdEmpleado;
    document.getElementById("txtCodigoEmpleado").value = empleados[i].codigo;
    document.getElementById("txtFechaIngreso").value = empleados[i].fechaIngreso;
    document.getElementById("cmbPuesto").value = empleados[i].puesto;
    document.getElementById("txtSalarioBruto").value = empleados[i].salarioBruto;
    document.getElementById("cmbEstatus").value = empleados[i].estatus;
    //Datos Usuario
    document.getElementById("txtIdUsuario").value = empleados[i].usuario.idUsuario;
    document.getElementById("txtNombreUsuario").value = empleados[i].usuario.nombreUsuario;
    document.getElementById("txtContrasenia").value = empleados[i].usuario.contrasenia;
    document.getElementById("cmbRol").value = empleados[i].usuario.rol;
}

function guardarEmpleado() {
    //Datos persona
    let ci = document.getElementById("txtaCodigoImagen").value;
    let idP = document.getElementById("txtIdPersona").value;
    let nom = document.getElementById("txtNombre").value;
    let ap = document.getElementById("txtApellidoPaterno").value;
    let am = document.getElementById("txtApellidoMaterno").value;
    let gen = document.getElementById("cmbGenero").value;
    let fn = document.getElementById("txtFechaNacimiento").value;
    let rfc = document.getElementById("txtRfc").value;
    let curp = document.getElementById("txtCurp").value;
    let dom = document.getElementById("txtDomicilio").value;
    let cp = document.getElementById("txtCp").value;
    let ciu = document.getElementById("txtCiudad").value;
    let edo = document.getElementById("txtEstado").value;
    let tel = document.getElementById("txtTelefono").value;
    

    let persona = {
        "idPersona": idP,
        "nombre": nom,
        "apellidoPaterno": ap,
        "apellidoMaterno": am,
        "genero": gen,
        "fechaNacimiento": fn,
        "rfc": rfc,
        "curp": curp,
        "domicilio": dom,
        "codigoPostal": cp,
        "ciudad": ciu,
        "estado": edo,
        "telefono": tel
    };
    
    let sucursal = {
    "idSucursal": 1,
    "nombre": "",
    "titular": "",
    "rfc": "",
    "domicilio": "",
    "colonia": "",
    "codigoPostal": "",
    "ciudad": "",
    "estado": "",
    "telefono": "",
    "latitud": "",
    "longitud": "",
    "estatus": ""
};

    //Datos Usuario
    document.getElementById("txtIdUsuario").value;
    document.getElementById("txtNombreUsuario").value;
    document.getElementById("txtContrasenia").value;
    document.getElementById("cmbRol").value;

    let usuario = {
        "idUsuario": document.getElementById("txtIdUsuario").value,
        "nombreUsuario": document.getElementById("txtNombreUsuario").value,
        "contrasenia": document.getElementById("txtContrasenia").value,
        "rol": document.getElementById("cmbRol").value

    };
    
    

    //Datos empleado
    document.getElementById("txtIdEmpleado").value;
    document.getElementById("txtCodigoEmpleado").value;
    document.getElementById("txtFechaIngreso").value;
    document.getElementById("cmbPuesto").value;
    document.getElementById("txtSalarioBruto").value;
    document.getElementById("cmbEstatus").value;
    

    let empleado = {
        "idEmpleado": document.getElementById("txtIdEmpleado").value,
        "codigo": document.getElementById("txtCodigoEmpleado").value,
        "fechaIngreso": document.getElementById("txtFechaIngreso").value,
        "puesto": document.getElementById("cmbPuesto").value,
        "salarioBruto": document.getElementById("txtSalarioBruto").value,
        "activo": document.getElementById("cmbEstatus").value,
        "email": "",
//      email: document.getElementById("txtEmail").value,
        "persona": persona,
        "usuario": usuario,
//        sucursal: document.getElementById("cmbSucursales")
        "sucursal":sucursal
    };
    let params = {e: JSON.stringify(empleado)};

    let ruta = "http://localhost:8080/sicefaSucursal/api/empleado/insert";

     fetch(ruta,
            {method: "POST",
             headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
             body: new URLSearchParams(params)
            })
            .then(response => response.json())
            .then(response => {
                if (response.result)
                    Swal.fire("Insercion correcta", response.result, "success");
                if (response.error)
                    Swal.fire("Problemas al insertar", response.error, "error");
                getAllEmpleado();
            });

    console.log(JSON.stringify(empleado));
    alert(JSON.stringify(empleado));
}

//function leerFoto(){
//    let ruta= document.getElementById("inputFileImagen").value;
//    
//    let reader= new FileReader();
//    reader.onload=function(){
//        base64String=reader.result.replace('data:','').replace(/^.+,/,'');
//        imageBase64Stringsep=base64String;
//        document.getElementById("imgFoto").src=imageBase64Stringsep;
//        document.getElementById("txtCodigoImagen").value=base64String;
//    }
//    reader.readDataURL(ruta);
//}

function cargarSucursales() {
    fetch("http://localhost:8080/sicefaSucursal/api/empleado/getAllSuc")
            .then(response => response.json())
            .then(response => {
                let sucursales = response;
                let datosSuc = "";
                for (let i = 0; i < sucursales.length; i++) {
                    datosSuc += "<option value='" + sucursales[i].idSucursal + "'>";
                    datosSuc += sucursales[i].nombre;
                    datosSuc += "</option>";

                }
                document.getElementById("cmbSucursales").innerHTML = datosSuc;
            });
}