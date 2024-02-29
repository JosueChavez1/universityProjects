/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author josue
 */
public class Estudiante {
    private String _id;

    private String nombre;
    
    private int matricula;
    
    private String carrera;

    public Estudiante(String _id, String nombre, int matricula, String carrera) {
        this._id = _id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public Estudiante(String nombre, int matricula, String carrera) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
    }
    

    public Estudiante() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("_id=").append(_id);
        sb.append(", nombre=").append(nombre);
        sb.append(", matricula=").append(matricula);
        sb.append(", carrera=").append(carrera);
        sb.append('}');
        return sb.toString();
    }
    
    
}
