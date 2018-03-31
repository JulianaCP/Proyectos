package com.example.pruebas.proyectolenguajes;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Administrador extends Usuario {
    String departamento;
    String salario;
    String cedula;

    public Administrador(String nombre,String login,String password,String telefono,
                         String permiso,String departamento,String salario,String cedula){
        super(nombre,login,password,telefono,permiso);
        this.departamento=departamento;
        this.salario=salario;
        this.cedula=cedula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
