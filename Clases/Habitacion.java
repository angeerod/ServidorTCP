package Clases;

class Habitacion {
    private String numeroHabitacion;
    private String huesped;
    private String tipoHabitacion;


    public Habitacion(String numeroHabitacion, String huesped, String tipoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.huesped = huesped;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getHuesped() {
        return huesped;
    }
    public String gettipoHabitacion() {
        return tipoHabitacion;
    }

}