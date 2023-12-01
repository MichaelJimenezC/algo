/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import espol.utilidades.ArrayList;
import espol.utilidades.DoubleLinkedList;
import espol.utilidades.LinkedList;
import java.util.Date;
import espol.utilidades.List;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Lenovo
 */
public class Contacto implements Serializable {

    private String nombre;
    private DoubleLinkedList<String> foto;
    private LinkedList<String> direccion;
    private LinkedList<String> emailPersonal;
    private LinkedList<String> numerosTelefonicos;
    private LinkedList<String> redesSociales;
    private LinkedList<Contacto> contactosRelacionados;
    private static final long serialVersionUID = 6122862457247319501L;

    public Contacto(String nombre, DoubleLinkedList<String> foto, LinkedList<String> direccion, LinkedList<String> emailPersonal, LinkedList<String> numerosTelefonicos, LinkedList<String> redesSociales) {
        this.nombre = nombre;
        this.foto = foto;
        this.direccion = direccion;
        this.emailPersonal = emailPersonal;
        this.numerosTelefonicos = numerosTelefonicos;
        this.redesSociales = redesSociales;
        this.contactosRelacionados = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DoubleLinkedList<String> getFoto() {
        return foto;
    }

    public void setFoto(DoubleLinkedList<String> foto) {
        this.foto = foto;
    }

    public LinkedList<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(LinkedList<String> direccion) {
        this.direccion = direccion;
    }

    public LinkedList<String> getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(LinkedList<String> emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public LinkedList<String> getNumerosTelefonicos() {
        return numerosTelefonicos;
    }

    public void setNumerosTelefonicos(LinkedList<String> numerosTelefonicos) {
        this.numerosTelefonicos = numerosTelefonicos;
    }

    public LinkedList<String> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(LinkedList<String> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public LinkedList<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public void setContactosRelacionados(LinkedList<Contacto> contactosRelacionados) {
        this.contactosRelacionados = contactosRelacionados;
    }

    private static class ComparatorPaisResidencia implements Comparator<Contacto> {

        @Override
        public int compare(Contacto c1, Contacto c2) {
            // Asumiendo que paisResidencia es de tipo String
            if (!c1.getDireccion().isEmpty() && !c2.getDireccion().isEmpty()) {
                return c1.getDireccion().getFirst().compareTo(c2.getDireccion().getFirst());

            }
            return 0;
        }
    }

    public static void ordenarPorPaisResidencia(DoubleLinkedList<Contacto> listaContactos) {
        Collections.sort(listaContactos, new ComparatorPaisResidencia());
    }
    // Método para ordenar la lista de contactos por tipo de contacto

    public static void ordenarPorTipoContacto(DoubleLinkedList<Contacto> listaContactos) {
        Collections.sort(listaContactos, new ComparatorTipoContacto());
    }

    // Comparator para comparar por tipo de contacto
    private static class ComparatorTipoContacto implements Comparator<Contacto> {

        @Override
        public int compare(Contacto c1, Contacto c2) {
            // Comparar por tipo de contacto (persona natural o empresa)
            boolean esPersonaC1 = c1 instanceof ContactoPersona;
            boolean esPersonaC2 = c2 instanceof ContactoPersona;

            if (esPersonaC1 && esPersonaC2) {
                return 0; // Ambos son personas naturales
            } else if (esPersonaC1) {
                return -1; // c1 es persona natural, c2 es empresa
            } else if (esPersonaC2) {
                return 1; // c1 es empresa, c2 es persona natural
            } else {
                return 0; // Ambos son empresas
            }
        }
    }

    // Método para ordenar la lista de contactos por cantidad de atributos contenidos
    public static void ordenarPorCantidadAtributos(DoubleLinkedList<Contacto> listaContactos) {
        Collections.sort(listaContactos, new ComparatorCantidadAtributos());
    }

    // Comparator para comparar por cantidad de atributos contenidos
    private static class ComparatorCantidadAtributos implements Comparator<Contacto> {

        @Override
        public int compare(Contacto c1, Contacto c2) {
            int atributosC1 = contarAtributosNoNulos(c1);
            int atributosC2 = contarAtributosNoNulos(c2);

            return Integer.compare(atributosC1, atributosC2);
        }

        // Método para contar atributos no nulos y con elementos en listas
        private int contarAtributosNoNulos(Contacto contacto) {
            int contador = 0;

            if (contacto.getNombre() != null) {
                contador++;
            }

            if (contacto.getFoto() != null && !contacto.getFoto().isEmpty()) {
                contador += contacto.getFoto().size();
            }

            if (contacto.getDireccion() != null && !contacto.getDireccion().isEmpty()) {
                contador += contacto.getDireccion().size();
            }

            if (contacto.getEmailPersonal() != null && !contacto.getEmailPersonal().isEmpty()) {
                contador += contacto.getEmailPersonal().size();
            }

            if (contacto.getNumerosTelefonicos() != null && !contacto.getNumerosTelefonicos().isEmpty()) {
                contador += contacto.getNumerosTelefonicos().size();
            }

            if (contacto.getRedesSociales() != null && !contacto.getRedesSociales().isEmpty()) {
                contador += contacto.getRedesSociales().size();
            }

            if (contacto.getContactosRelacionados() != null && !contacto.getContactosRelacionados().isEmpty()) {
                contador += contacto.getContactosRelacionados().size();
            }

            return contador;
        }
    }

}
