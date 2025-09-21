/**
 * Empleado con un salario mensual fijo
 */
public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String cedula, double salarioMensual) {
        super(nombre, cedula);
        if (salarioMensual < 0) throw new IllegalArgumentException("salarioMensual must be >= 0");
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }
}
