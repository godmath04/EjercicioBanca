import javax.swing.*;

public class Cuenta {
    protected double saldo;

    public Cuenta(double saldoInicio) {
        this.saldo = saldoInicio;
    }

    //Metodo para depositar
    public void depositar(double cantidad) {
        saldo = saldo + cantidad;
    }
    //Metodo apra retirar

    public void retirar(double cantidad){
        if (cantidad > saldo){
            JOptionPane.showMessageDialog(null, "FOndos insuficientes");
        }
        saldo -= cantidad;
    }

    //Consultar saldo
    public double getSaldo() {
        return saldo;
    }
}
