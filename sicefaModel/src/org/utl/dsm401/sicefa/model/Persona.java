
package org.utl.dsm401.sicefa.model;

/**
 *
 * @author josue
 */
public class Persona {
    private int idPersona;
    private String foto;
    private String fechaNacimiento;
    private String telefono;
    private String domicilio;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String curp;
    private String rfc;
    
    
    public Persona(){  
    }

    public Persona(String foto, String fechaNacimiento, String telefono, String domicilio, String codigoPostal, String ciudad, String estado, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String curp, String rfc) {
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.curp = curp;
        this.rfc = rfc;
    }

    public Persona(int idPersona, String foto, String fechaNacimiento, String telefono, String domicilio, String codigoPostal, String ciudad, String estado, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String curp, String rfc) {
        this.idPersona = idPersona;
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.curp = curp;
        this.rfc = rfc;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona:").append(idPersona);
        sb.append(", foto:").append(foto);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", telefono:").append(telefono);
        sb.append(", domicilio:").append(domicilio);
        sb.append(", codigoPostal:").append(codigoPostal);
        sb.append(", ciudad:").append(ciudad);
        sb.append(", estado:").append(estado);
        sb.append(", nombre:").append(nombre);
        sb.append(", apellidoPaterno:").append(apellidoPaterno);
        sb.append(", apellidoMaterno:").append(apellidoMaterno);
        sb.append(", genero:").append(genero);
        sb.append(", curp:").append(curp);
        sb.append(", rfc:").append(rfc);
        sb.append('}');
        return sb.toString();
    }
    
}
