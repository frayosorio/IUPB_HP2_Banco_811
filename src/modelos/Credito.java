package modelos;

public class Credito extends Cuenta {

    private double valorPrestado;
    private double tasa;
    private int plazo;
    private double valorRetirado;

    public Credito(String titular, String numero) {
        super(titular, numero, 0);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (valorPrestado - valorRetirado >= cantidad) {
            valorRetirado += cantidad;
            System.out.println("Retiro existoso. Nuevo saldo:" + (valorPrestado - valorRetirado));
            return true;
        } else {
            System.out.println("Ya fue retirado todo el capital del préstamo o la cantidad supera lo disponible");
            return false;
        }
    }

    public double getCuota() {
        return valorPrestado * Math.pow(1 + tasa, plazo) * tasa / (Math.pow(1 + tasa, plazo) - 1);
    }

    public void pagar(double cantidad) {
        if (getSaldo() < valorPrestado) {
            double intereses = (valorPrestado - getSaldo()) * tasa;
            double abonoCapital = cantidad - intereses;
            consignar(abonoCapital);
        } else {
            System.out.println("Ya la deuda está pagada");
        }

    }

}
