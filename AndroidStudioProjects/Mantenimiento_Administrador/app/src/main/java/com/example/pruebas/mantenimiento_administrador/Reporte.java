package com.example.pruebas.mantenimiento_administrador;

/**
 * Created by Pruebas on 21/05/2017.
 */
public class Reporte {
    private int id;
    private String estadoReporte;
    private String prioridadReporte;
    private String fechaReporte;
    private String fechaFinalizacion;
    private String descripcion;
    private String establecimiento;
    private String nombreUsuario;
    private String nombre;

    public Reporte(int id, String estadoReporte, String prioridadReporte, String fechaReporte
            , String fechaFinalizacion, String descripcion, String establecimiento, String nombreUsuario
            , String nombre) {
        this.id = id;
        this.estadoReporte = estadoReporte;
        this.prioridadReporte = prioridadReporte;
        this.fechaReporte = fechaReporte;
        this.fechaFinalizacion = fechaFinalizacion;
        this.descripcion = descripcion;
        this.establecimiento = establecimiento;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getPrioridadReporte() {
        return prioridadReporte;
    }

    public void setPrioridadReporte(String prioridadReporte) {
        this.prioridadReporte = prioridadReporte;
    }

    public String getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
