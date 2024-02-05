public class Carro extends Veiculo implements Contribuinte
{
    private String categoria;
    
    public Carro(String marca, String modelo, int anoFabricacao, double precoInicial, String categoria) 
    {
        super(marca, modelo, anoFabricacao, precoInicial);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    
    public double calcularIPVA()
    {
        if(getCategoria().equals("Utilitario"))
        {
            return (0.02*getPrecoInicial() - (2024 - getAnoFabricacao()));
        }
        else if (getCategoria().equals("Esportivo"))
        {
            return (0.04*getPrecoInicial() - (2024 - getAnoFabricacao()));
        }
        else
        {
            return 0;
        }
    }
    
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nCategoria: %s\nIPVA: R$ %.2f\n",getCategoria(), calcularIPVA());
    }
}