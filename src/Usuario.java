import javax.swing.*;

public class Usuario {
    private String nombre;
    private CuentaCorriente cuentaCorriente;
    private CuentaAhorros cuentaAhorros;
    private CDT cdt;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.cuentaCorriente = new CuentaCorriente(0);
        this.cuentaAhorros = new CuentaAhorros(0, 0.006);  // 0.6% interés mensual
        this.cdt = null;
    }

    private double negociarInteresCDT(double cantidad){
        if (cantidad >= 10000){
            //Interes del 5%
            return 0.05;
        } else if (cantidad >= 5000) {
            //Interes del 3%
            return 0.03;
        } else {
            //Interes del 1%
            return 0.01;
        }
    }

    public void invertirEnCDT(double cantidad, double interesMensual) {
        if (cdt != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un CDT activo");
        }
        double interesNegocio = negociarInteresCDT(cantidad);
        cdt = new CDT(cantidad, interesMensual);
    }

    public void cerrarCDT() {
        if (cdt == null) {
            JOptionPane.showMessageDialog(null,"No hay CDT activo");
        }
        double montoTransferido = cdt.cerrarCDT();
        cuentaCorriente.depositar(montoTransferido);
        cdt = null;
    }

    public double saldoTotal() {
        double total = cuentaCorriente.getSaldo() + cuentaAhorros.getSaldo();
        if (cdt != null) {
            total += cdt.getSaldo();
        }
        return total;
    }

    public void avanzarMes() {
        cuentaAhorros.aplicarInteres();
        // El CDT acumula interés pero no se suma hasta cerrarlo
    }

    // Método para depositar en la cuenta corriente
    public void depositarEnCuentaCorriente(double monto) {
        cuentaCorriente.depositar(monto);
    }
    //Metodo para retirar
    public void retirarDeCuentaCorriente(double monto) {
        if (monto <= cuentaCorriente.getSaldo()) {
            cuentaCorriente.retirar(monto);
            JOptionPane.showMessageDialog(null, "Monto retirado de cuenta corriente. Saldo: " + saldoCuentaCorriente());
        } else {
            JOptionPane.showMessageDialog(null, "No tiene suficiente saldo en la cuenta corriente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para depositor con la cuenta de ahorros
    public void depositarEnCuentaAhorros(double monto) {
        cuentaAhorros.depositar(monto);
    }

    //Metodo para retirar de la cuenta de eahorros

    public void retirarDeCuentaAhorros(double monto) {
        if (monto <= cuentaAhorros.getSaldo()) {
            cuentaAhorros.retirar(monto);
            JOptionPane.showMessageDialog(null, "Monto retirado de cuenta de ahorros. Saldo: " + saldoCuentaAhorros());
        } else {
            JOptionPane.showMessageDialog(null, "No tiene suficiente saldo en la cuenta de ahorros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método saldo de las cuenta
    public double saldoCuentaCorriente() {
        return cuentaCorriente.getSaldo();
    }

    //Metodo saldo cuenta de ahorros
    public double saldoCuentaAhorros() {
        return cuentaAhorros.getSaldo();
    }

    //Metodo saldo cdt
    public double obtenerSaldoCDT() {
        if (cdt == null) {
            return 0;
        } else {
            return cdt.getSaldo();
        }
    }

}
