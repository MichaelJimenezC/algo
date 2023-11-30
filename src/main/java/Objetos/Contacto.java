/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import espol.utilidades.ArrayList;
import java.util.Date;
import espol.utilidades.List;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class Contacto implements Serializable{
    private String nombre;
    private String numeroTelefono;
    private String foto;
    private String direccion;
    private String emailPersonal;
    private List<String> numerosTelefonicos;
    private List<String> redesSociales;
    private List<Contacto> contactosRelacionados;

    // Constructor
    public Contacto(String nombre, String numeroTelefono, String foto, String direccion, String emailPersonal ) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.foto = foto;
        this.direccion = direccion;
        this.emailPersonal = emailPersonal;
        this.numerosTelefonicos = new ArrayList<>();
        this.redesSociales = new ArrayList<>();
        this.contactosRelacionados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public List<String> getNumerosTelefonicos() {
        return numerosTelefonicos;
    }

    public void setNumerosTelefonicos(List<String> numerosTelefonicos) {
        this.numerosTelefonicos = numerosTelefonicos;
    }

    public List<String> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(List<String> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public List<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public void setContactosRelacionados(List<Contacto> contactosRelacionados) {
        this.contactosRelacionados = contactosRelacionados;
    }
}
