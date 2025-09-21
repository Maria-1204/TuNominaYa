import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Principal aplicación para TuNominaYa.
 * Proporciona un menú sencillo (JOptionPane) para crear empleados y calcular salarios
 * Demuestra herencia, clases abstractas y polimorfismo.
 */
public class NominaApp {
    private static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String menu = "TuNominaYa - Menu:\n" +
                          "1. Crear Empleado Asalariado\n" +
                          "2. Crear Empleado Por Horas\n" +
                          "3. Crear Empleado Por Comisión\n" +
                          "4. Mostrar Nómina (todos los empleados)\n" +
                          "5. Calcular Nómina Total\n" +
                          "6. Salir\n" +
                          "Ingrese la opción (1-6):";
            String opcion = JOptionPane.showInputDialog(menu);
            if (opcion == null) break; // user cancelled
            switch (opcion.trim()) {
                case "1": crearAsalariado(); break;
                case "2": crearPorHoras(); break;
                case "3": crearPorComision(); break;
                case "4": mostrarNomina(); break;
                case "5": calcularNominaTotal(); break;
                case "6": System.exit(0); break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo."); 
            }
        }
    }

    private static void crearAsalariado() {
        try {
            String nombre = pedirStr("Ingrese el nombre del empleado (asalariado):");
            String cedula = pedirStr("Ingrese la cédula:"); 
            double salario = pedirDouble("Ingrese salario mensual:"); 
            Empleado e = new EmpleadoAsalariado(nombre, cedula, salario);
            empleados.add(e);
            JOptionPane.showMessageDialog(null, "Empleado creado:\n" + e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private static void crearPorHoras() {
        try {
            String nombre = pedirStr("Ingrese el nombre del empleado (por horas):");
            String cedula = pedirStr("Ingrese la cédula:"); 
            double valorHora = pedirDouble("Ingrese valor por hora:"); 
            int horas = (int) pedirDouble("Ingrese horas trabajadas (entero):"); 
            Empleado e = new EmpleadoPorHoras(nombre, cedula, valorHora, horas);
            empleados.add(e);
            JOptionPane.showMessageDialog(null, "Empleado creado:\n" + e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private static void crearPorComision() {
        try {
            String nombre = pedirStr("Ingrese el nombre del empleado (por comisión):");
            String cedula = pedirStr("Ingrese la cédula:"); 
            double base = pedirDouble("Ingrese salario base:"); 
            double ventas = pedirDouble("Ingrese total ventas:"); 
            double porcentaje = pedirDouble("Ingrese porcentaje de comisión (ej. 0.10 para 10%):"); 
            Empleado e = new EmpleadoPorComision(nombre, cedula, base, ventas, porcentaje);
            empleados.add(e);
            JOptionPane.showMessageDialog(null, "Empleado creado:\n" + e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private static void mostrarNomina() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Empleado e : empleados) {
            sb.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void calcularNominaTotal() {
        double total = 0;
        for (Empleado e : empleados) total += e.calcularSalario();
        JOptionPane.showMessageDialog(null, String.format("Nómina total: %.2f", total));
    }

    // Utility input helpers with basic validation
    private static String pedirStr(String msg) {
        String s = JOptionPane.showInputDialog(msg);
        if (s == null) throw new RuntimeException("Operación cancelada por el usuario");
        s = s.trim();
        if (s.isEmpty()) throw new RuntimeException("El valor no puede estar vacío");
        return s;
    }

    private static double pedirDouble(String msg) {
        String s = JOptionPane.showInputDialog(msg);
        if (s == null) throw new RuntimeException("Operación cancelada por el usuario");
        s = s.trim();
        if (s.isEmpty()) throw new RuntimeException("El valor no puede estar vacío");
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Valor numérico inválido: " + s);
        }
    }
}
