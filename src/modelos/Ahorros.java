package modelos;

public class Ahorros extends Cuenta {

    public Ahorros(String titular, String numero, double saldo) {
        super(titular, numero, saldo);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (getSaldo() >= cantidad) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro existoso. Nuevo saldo:" + getSaldo());
            return true;
        } else {
            System.out.println("Fondos insuficientes para este retiro");
            return false;
        }
    }

}
