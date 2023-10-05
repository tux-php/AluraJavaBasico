public class ContaCorrente implements Conta{
        protected double saldo;
    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void fazerTransferencia(double valor) {
        if(getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
        }
    }

    @Override
    public void recebeTransferencia(double valor) throws Exception {
            if(valor > 0){
                setSaldo(getSaldo() + valor);
            }
    }
    @Override
    public String toString() {
        return "Corrente";
    }
}
