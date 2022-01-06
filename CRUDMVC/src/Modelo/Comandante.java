package Modelo;

import java.util.Date;

public class Comandante {

    /**
     *
     */
    private int cod_comandante;
    private String nombre;
    private String apellidos;
    private int anio_servicio;
    private String escuela;
    private Date fecha_ingreso;

    /**
     *
     * @return Cod_comandante
     */
    public int getCod_comandante() {
        return cod_comandante;
    }

    /**
     *
     * @param cod_comandante
     */
    public void setCod_comandante(int cod_comandante) {
        this.cod_comandante = cod_comandante;
    }

    /**
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return Apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public int getAnio_servicio() {
        return anio_servicio;
    }

    /**
     *
     * @param anio_servicio
     */
    public void setAnio_servicio(int anio_servicio) {
        this.anio_servicio = anio_servicio;
    }

    /**
     *
     * @return Escuela
     */
    public String getEscuela() {
        return escuela;
    }

    /**
     *
     * @param escuela
     */
    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    /**
     *
     * @return Fecha_Ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     *
     * @param fecha_ingreso
     */

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

}
