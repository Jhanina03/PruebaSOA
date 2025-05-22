/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Usuario
 */
public class Estudiante {

    public String cedula;
    public String nombre;
    public String apellido;
    public String direccion;
    public String telefono;

    @Override
    public String toString() {
        return this.cedula + " " + this.nombre + " " + this.apellido;
    }
}
