public class CuentaAhorros extends Cuenta {
    private double interesMensual;

    public CuentaAhorros(double saldoInicio, double interesMensual) {
        super(saldoInicio);
        this.interesMensual = interesMensual;
    }

    public void aplicarInteres() {
        saldo += saldo * interesMensual;
    }
}