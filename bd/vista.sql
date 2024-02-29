## vistas sicefa gil
-- Vista para mostrar información del empleado
-- Vista para mostrar información del empleado con IDs de persona, usuario y sucursal
use sicefa;
CREATE VIEW v_empleado AS
SELECT
    e.idEmpleado,
    e.codigo,
    e.fechaIngreso,
    e.puesto,
    e.salarioBruto,
    e.activo AS empleadoActivo,
    e.email,
    p.idPersona,
    p.foto AS fotoPersona,
    p.fechaNacimiento AS fechaNacimientoPersona,
    p.telefono AS telefonoPersona,
    p.domicilio AS domicilioPersona,
    p.codigoPostal AS codigoPostalPersona,
    p.ciudad AS ciudadPersona,
    p.estado AS estadoPersona,
    p.nombre AS nombrePersona,
    p.apellidoPaterno AS apellidoPaternoPersona,
    p.apellidoMaterno AS apellidoMaternoPersona,
    p.genero AS generoPersona,
    p.curp AS curpPersona,
    p.rfc AS rfcPersona,
    u.idUsuario,
    u.nombreUsuario,
    u.rol,
    s.idSucursal,
    s.nombre AS nombreSucursal,
    s.titular AS titularSucursal,
    s.rfc AS rfcSucursal,
    s.domicilio AS domicilioSucursal,
    s.colonia AS coloniaSucursal,
    s.codigoPostal AS codigoPostalSucursal,
    s.ciudad AS ciudadSucursal,
    s.estado AS estadoSucursal,
    s.telefono AS telefonoSucursal,
    s.latitud AS latitudSucursal,
    s.longitud AS longitudSucursal,
    s.estatus AS estatusSucursal
FROM
    empleado e
    JOIN persona p ON e.idPersona = p.idPersona
    JOIN usuario u ON e.idUsuario = u.idUsuario
    JOIN sucursal s ON e.idSucursal = s.idSucursal;
    
    SELECT * FROM v_empleado;

