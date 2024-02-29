/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm401.sicefa.model;

/**
 *
 * @author josue
 */
public class Empleado{
    private int idEmpleado;
    private String codigo;
    private String fechaIngreso;
    private String puesto;
    private float salarioBruto;
    private int activo;
    private String email;
    private Sucursal sucursal;
    private Usuario usuario;
    private Persona persona; // objEmpleado.persona.getIdPersona();  Esto se le llama contencion

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado:").append(idEmpleado);
        sb.append(", codigo:").append(codigo);
        sb.append(", fechaIngreso:").append(fechaIngreso);
        sb.append(", puesto:").append(puesto);
        sb.append(", salarioBruto:").append(salarioBruto);
        sb.append(", activo:").append(activo);
        sb.append(", email:").append(email);
        sb.append(", sucursal:").append(sucursal);
        sb.append(", usuario:").append(usuario);
        sb.append(", persona:").append(persona);
        sb.append('}');
        return sb.toString();
    }

    public Empleado(int idEmpleado, String codigo, String fechaIngreso, String puesto, float salarioBruto, int activo, String email, Sucursal sucursal, Usuario usuario, Persona persona) {
        this.idEmpleado = idEmpleado;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salarioBruto = salarioBruto;
        this.activo = activo;
        this.email = email;
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.persona = persona;
    }

    public Empleado(String codigo, String fechaIngreso, String puesto, float salarioBruto, int activo, String email, Sucursal sucursal, Usuario usuario, Persona persona) {
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salarioBruto = salarioBruto;
        this.activo = activo;
        this.email = email;
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.persona = persona;
    }

    public Empleado() {
    }

   
}
