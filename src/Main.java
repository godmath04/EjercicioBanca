import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Usuario promedio");
        int opcion = 0;

        do {
            String mensaje = "Seleccione lo que desea hacer:\n"
                    + "1. Consultar saldo cuenta corriente\n"
                    + "2. Consultar saldo cuenta de ahorros\n"
                    + "3. Consultar saldo CDT\n"
                    + "4. Consultar saldo total\n"
                    + "5. Invertir en CDT\n"
                    + "6. Cerrar CDT\n"
                    + "7. Consignar en cuenta corriente\n"
                    + "8. Retirar de cuenta corriente\n"
                    + "9. Consignar en cuenta de ahorros\n"
                    + "10. Retirar de cuenta de ahorros\n"
                    + "11. Avanzar un mes\n"
                    + "12. Salir";

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Saldo cuenta corriente: " + usuario.saldoCuentaCorriente());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                "Saldo cuenta de ahorros: " + usuario.saldoCuentaAhorros());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                "Saldo CDT: " + usuario.obtenerSaldoCDT());
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                "Saldo total: " + usuario.saldoTotal());
                        break;
                    case 5:
                        double montoInvertir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a invertir en el CDT:"));
                        double interesNegociado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el interés mensual para el CDT (en enteros):")) / 100;
                        usuario.invertirEnCDT(montoInvertir, interesNegociado);
                        JOptionPane.showMessageDialog(null,
                                "Inversión en CDT realizada. Saldo CDT: " + usuario.obtenerSaldoCDT());
                        break;
                    case 6:
                        usuario.cerrarCDT();
                        JOptionPane.showMessageDialog(null,
                                "CDT cerrado. Saldo acreditado cuenta corriente: " + usuario.saldoCuentaCorriente());
                        break;
                    case 7:
                        double montoDepositarCC = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a consignar en la cuenta corriente:"));
                        usuario.depositarEnCuentaCorriente(montoDepositarCC);
                        JOptionPane.showMessageDialog(null,
                                "Monto consignado en cuenta corriente. Saldo: " + usuario.saldoCuentaCorriente());
                        break;
                    case 8:
                        double montoRetirarCC = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar de la cuenta corriente:"));
                        usuario.retirarDeCuentaCorriente(montoRetirarCC);
                        //JOptionPane.showMessageDialog(null,
                        //        "Monto retirado de cuenta corriente. Saldo: " + usuario.saldoCuentaCorriente());
                        break;
                    case 9:
                        double montoDepositarCA = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a consignar en la cuenta de ahorros:"));
                        usuario.depositarEnCuentaAhorros(montoDepositarCA);
                        JOptionPane.showMessageDialog(null,
                                "Monto consignado en cuenta de ahorros. Saldo: " + usuario.saldoCuentaAhorros());
                        break;
                    case 10:
                        double montoRetirarCA = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar de la cuenta de ahorros:"));
                        usuario.retirarDeCuentaAhorros(montoRetirarCA);
                        //JOptionPane.showMessageDialog(null,
                        //        "Monto retirado de cuenta de ahorros. Saldo: " + usuario.saldoCuentaAhorros());
                        break;
                    case 11:
                        usuario.avanzarMes();
                        JOptionPane.showMessageDialog(null,
                                "Se avanzó un mes y se aplicó el interés.");
                        break;
                    case 12:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema bancario.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Seleccione una opción entre 1 y 12.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 12);
    }
}
