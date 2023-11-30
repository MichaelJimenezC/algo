/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Lenovo
 */
public class ContactoPersona extends Contacto{
        private String apellido;
        private String fechaCumpleanos;
        
        public ContactoPersona(String nombre, String apellido, String numeroTelefono, String foto, String direccion, String emailPersonal, String fechaCumpleaños) {
            super(nombre, numeroTelefono, foto, direccion, emailPersonal);
            this.apellido = apellido;
            this.fechaCumpleanos = fechaCumpleanos;
        }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public void setFechaCumpleanos(String fechaCumpleanos) {
        this.fechaCumpleanos = fechaCumpleanos;
    }
        
        
}
