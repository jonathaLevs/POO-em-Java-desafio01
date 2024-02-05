import java.util.Scanner;

public class Menu
{
    private Scanner scan = new Scanner(System.in);
    private Gerenciamento frota = new Gerenciamento();

    public void executar()
    {
        int opcao;
        do
        {
            exibirMenu();
            System.out.print("Digite uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();            
            executarOpcao(opcao);
            System.out.println("");
        }while(opcao!=5);
    }

    private void exibirMenu()
    {
        System.out.println("=========== MENU ===========");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Buscar");
        System.out.println("3 - Remover");
        System.out.println("4 - Listar todos");
        System.out.println("5 - Sair");
    }

    private void executarOpcao(int opcao)
    {
        switch (opcao) {
            case 1: {
                adicionar();
                System.out.println();
                break;
            }
            case 2: {
                buscar();
                System.out.println();
                break;
            }
            case 3: {
                remover();
                System.out.println();
                break;
            }
            case 4: {
                listar();
                System.out.println();
                         
        } break;
            }  

    }

    private void adicionar()
    {
        System.out.println("\n### INSERSAO DE VEICULO ###");
        int tipoVeiculo = selecionarTipoVeiculo();
        scan.nextLine();

        String marca = lerMarca();
        String modelo = lerModelo();
        int anoFabricacao = lerAnoFabricacao();        
        double precoInicial = lerPrecoInicial();
        
        switch (tipoVeiculo) 
        {
            case 1:
                frota.adicionarVeiculo(adicionarBicicleta(marca, modelo, anoFabricacao, precoInicial));
                System.out.println("Adicionado com sucesso!");
                break;
            case 2:
                frota.adicionarVeiculo(adicionCarro(marca, modelo, anoFabricacao, precoInicial));
                System.out.println("Adicionado com sucesso!");
                break;
            case 3:
                frota.adicionarVeiculo(adicionarCaminhao(marca, modelo, anoFabricacao, precoInicial));
                System.out.println("Adicionado com sucesso!");
                break;
            default:
                System.out.println("Tipo de veiculo invalido.");
                break;
        }
    }
    private int selecionarTipoVeiculo()
    {
        System.out.println("Selecione o veiculo: ");
        System.out.println("1 - Bicicleta\n2 - Carro\n3 - Caminhao");
        return scan.nextInt();
    }

    private Bicicleta adicionarBicicleta(String marca, String modelo, int anoFabricacao, double precoInicial)
    {
        int qtdMarchas;
        System.out.print("Digite a quantidade de marchas: ");
        qtdMarchas = scan.nextInt();
        return new Bicicleta(marca, modelo, anoFabricacao, precoInicial, qtdMarchas);
    }

    private Carro adicionCarro(String marca, String modelo, int anoFabricacao, double precoInicial)
    {
        String categoria;
        System.out.print("Digite a categoria do carro (Utilitario ou Esportivo): ");
        categoria = scan.next();
        return new Carro(marca, modelo, anoFabricacao, precoInicial, categoria);
    }

    private Caminhao adicionarCaminhao(String marca, String modelo, int anoFabricacao, double precoInicial)
    {
        int numEixos;
        System.out.print("Digite a quantidade de eixos do caminhao: ");
        numEixos = scan.nextInt();
        return new Caminhao(marca, modelo, anoFabricacao, precoInicial, numEixos);
    }

    private void buscar()
    {
        System.out.println("\n### BUSCA DE VEICULO ###");

        String marca = lerMarca();
        String modelo = lerModelo();
        int anoFabricacao = lerAnoFabricacao();        
        double precoInicial = lerPrecoInicial();
        
        Veiculo v = frota.buscarVeiculo(marca, modelo, anoFabricacao, precoInicial);
        
        if (v != null)
        {
            System.out.println("\n###############");
            System.out.println(v);
            System.out.println("### VEICULO ENCONTRADO ###");
        }
        else
            System.out.println("Veiculo nao encontrado!");
    }

    private void remover()
    {
        System.out.println("\n### REMOCAO DE VEICULO ###");
        int tipo = selecionarTipoVeiculo();

        String marca = lerMarca();
        String modelo = lerModelo();
        int anoFabricacao = lerAnoFabricacao();        
        double precoInicial = lerPrecoInicial();
        
        switch (tipo) 
        {
            case 1:
                boolean bic = frota.removerVeiculo(adicionarBicicleta(marca, modelo, anoFabricacao, precoInicial));
                if(bic == true)
                    System.out.println("Removido!");
                else
                    System.out.println("Veiculo nao removido!");
                break;
            case 2:
                boolean car = frota.removerVeiculo(adicionCarro(marca, modelo, anoFabricacao, precoInicial));
                if(car == true)
                    System.out.println("Removido!");
                else
                    System.out.println("Veiculo nao removido!");
                break;
            case 3:
                boolean cam = frota.removerVeiculo(adicionarCaminhao(marca, modelo, anoFabricacao, precoInicial));
                if(cam == true)
                    System.out.println("Removido!");
                else
                    System.out.println("Veiculo nao removido!");
                break;
            default:
                System.out.println("Tipo de veiculo invalido.");
                break;
        }
    }

    private void listar()
    {
        System.out.println("\n### LISTA DE VEICULO ###");
        frota.listarVeiculos();
    }

    private String lerMarca()
    {
        System.out.print("Digite a marca: ");
        return scan.next();
    }
        
    private String lerModelo()
    {
        System.out.print("Digite o modelo: ");
        return scan.next();
    }

    private int lerAnoFabricacao()
    {
        System.out.print("Digite o ano de fabricacao: ");
        return scan.nextInt();
    }

    private double lerPrecoInicial()
    {
        System.out.print("Digite o preco inicial: ");
        return scan.nextDouble();
    }
}
