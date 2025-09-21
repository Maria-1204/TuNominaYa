/**
 * Employee paid by commission: base salary + commission percentage on sales.
 */
public class EmpleadoPorComision extends Empleado {
    private double salarioBase;
    private double ventas;
    private double porcentajeComision; // e.g., 0.10 for 10%

    public EmpleadoPorComision(String nombre, String cedula, double salarioBase, double ventas, double porcentajeComision) {
        super(nombre, cedula);
        if (salarioBase < 0 || ventas < 0 || porcentajeComision < 0) 
            throw new IllegalArgumentException("Values must be >= 0");
        this.salarioBase = salarioBase;
        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + ventas * porcentajeComision;
    }

    public double getSalarioBase() { return salarioBase; }
    public double getVentas() { return ventas; }
    public double getPorcentajeComision() { return porcentajeComision; }
}
