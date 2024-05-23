package Clases;

class Habitacion {
    private String numeroHabitacion;
    private String huesped;

    public Habitacion(String numeroHabitacion, String huesped) {
        this.numeroHabitacion = numeroHabitacion;
        this.huesped = huesped;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getHuesped() {
        return huesped;
    }
}