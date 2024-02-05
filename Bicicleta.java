public class Bicicleta extends Veiculo
{
    private int qtdMarchas;
    
    public int getQtdMarchas() {
        return qtdMarchas;
    }

    public Bicicleta(String marca, String modelo, int anoFabricacao, double precoInicial, int qtdMarchas) 
    {
        super(marca, modelo, anoFabricacao, precoInicial);
        this.qtdMarchas = qtdMarchas;
    }

    @Override
    public String toString()
    {
        return super.toString() + String.format("\nNumero de marchas: %d\n", getQtdMarchas());
    }
}
