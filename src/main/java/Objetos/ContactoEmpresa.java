/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Lenovo
 */
public class ContactoEmpresa extends Contacto{
    private String paginaweb;

    // Constructor
    public ContactoEmpresa(String nombre, String numeroTelefono, String foto, String direccion, String emailPersonal, String paginaweb) {
        super(nombre, numeroTelefono, foto, direccion, emailPersonal);
        this.paginaweb = paginaweb;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }
    
}
