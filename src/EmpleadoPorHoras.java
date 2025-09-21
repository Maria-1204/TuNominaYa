/**
 * Empleado pagado por horas.
 */
public class EmpleadoPorHoras extends Empleado {
    private double valorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, String cedula, double valorHora, int horasTrabajadas) {
        super(nombre, cedula);
        if (valorHora < 0) throw new IllegalArgumentException("valorHora must be >= 0");
        if (horasTrabajadas < 0) throw new IllegalArgumentException("horasTrabajadas must be >= 0");
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return valorHora * horasTrabajadas;
    }

    public double getValorHora() { return valorHora; }
    public int getHorasTrabajadas() { return horasTrabajadas; }
}
