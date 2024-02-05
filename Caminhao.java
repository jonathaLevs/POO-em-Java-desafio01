public class Caminhao extends Veiculo implements Contribuinte
{
    private int numEixos;

    public Caminhao(String marca, String modelo, int anoFabricacao, double precoInicial, int numEixos) 
    {
        super(marca, modelo, anoFabricacao, precoInicial);
        this.numEixos = numEixos;
    }

    private int getNumEixos() {
        return numEixos;
    }

    public double calcularIPVA()
    {
        return (0.03*getNumEixos()*getPrecoInicial() - (2024 - getAnoFabricacao()));
    }
    
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nNumero de eixos: %d\nIPVA: R$ %.2f \n",getNumEixos(), calcularIPVA());
    }
}
