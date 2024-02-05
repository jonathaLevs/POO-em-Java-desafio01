import java.util.ArrayList;

public class Gerenciamento 
{
    private ArrayList<Veiculo> listaVeiculos;

    public Gerenciamento()
    {
        listaVeiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo umVeiculo)
    {
        listaVeiculos.add(umVeiculo);
    }

    public Veiculo buscarVeiculo(String marca, String modelo, int anoFabricacao, double precoInicial)
    {
        for (Veiculo v : listaVeiculos) 
        {
            if(v.getMarca().equals(marca) & v.getModelo().equals(modelo))            
            {
                if(v.getAnoFabricacao() == anoFabricacao & v.getPrecoInicial() == precoInicial)
                {
                    return v;
                }
            }
        }
        return null;
    }

    public boolean removerVeiculo(Veiculo umVeiculo)
    {
        Veiculo veiculo = buscarVeiculo(umVeiculo.getMarca(), umVeiculo.getModelo(), umVeiculo.getAnoFabricacao(), umVeiculo.getPrecoInicial());
        if(veiculo!=null)
        {
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    public void listarVeiculos()
    {
        for (Veiculo veiculo : listaVeiculos) 
        {
            System.out.println("###############");
            System.out.println(veiculo);
        }
    }
}
