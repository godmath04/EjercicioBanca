public class CDT extends Cuenta {
    private double interesMensual;

    public CDT(double saldoInicial, double interesMensual) {
        super(saldoInicial);
        this.interesMensual = interesMensual;
    }

    public double calcularInteres() {
        return saldo * interesMensual;
    }

    public double cerrarCDT() {
        double montoConIntereses = saldo + calcularInteres();
        saldo = 0;
        return montoConIntereses;
    }
}
