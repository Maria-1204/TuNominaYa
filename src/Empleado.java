/**
 * Abstract base class for employees.
 * Defines common attributes and the abstract method calcularSalario().
 */
public abstract class Empleado {
    private String nombre;
    private String cedula;

    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    // Abstract method - must be implemented by subclasses
    public abstract double calcularSalario();

    @Override
    public String toString() {
        return String.format("Empleado: %s - Cédula: %s - Salario: %.2f", 
                             nombre, cedula, calcularSalario());
    }
}
