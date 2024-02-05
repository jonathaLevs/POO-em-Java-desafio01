public class Veiculo 
{
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double precoInicial;

    public Veiculo(String marca, String modelo, int anoFabricacao, double precoInicial) 
    {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.precoInicial = precoInicial;
    }

    protected String getMarca() {
        return marca;
    }
    protected String getModelo() {
        return modelo;
    }
    protected int getAnoFabricacao() {
        return anoFabricacao;
    }

    protected double getPrecoInicial()
    {
        return precoInicial;
    }

    @Override
    public String toString()
    {
        return String.format("Marca: %s\nModelo: %s\nAno de Fabricacao: %d\nPreco Inicial: R$ %.2f", getMarca(), getModelo(), getAnoFabricacao(), getPrecoInicial());
    }   
}