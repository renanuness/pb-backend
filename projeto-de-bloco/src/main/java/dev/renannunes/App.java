package dev.renannunes;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import dev.renannunes.model.Cliente;
import dev.renannunes.model.ItemPedido;
import dev.renannunes.model.Pedido;
import dev.renannunes.model.Produto;
import dev.renannunes.utils.Ids;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
    public static Ids Ids;
    public static List<Produto> Produtos;
    public static List<Cliente> Clientes;
    public static List<Pedido> Pedidos;
    public static List<ItemPedido> ItensPedidos;

    public static final String produtosFilename = "produtos.csv";
    public static final String clientesFilename = "clientes.csv";
    public static final String pedidosFilename = "pedidos.csv";
    public static final String itensPedidosFilename = "itensPedidos.csv";

    public static void main(String[] args) {
        LerIds();
        Produtos = LerCsv(produtosFilename, Produto.class);
        Clientes = LerCsv(clientesFilename, Cliente.class);
        Pedidos = LerCsv(pedidosFilename, Pedido.class);
        ItensPedidos = LerCsv(itensPedidosFilename, ItemPedido.class);

        var sair = false;
        // MENU
        while(!sair){

            System.out.println("1 - Listar Clientes");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Listar Produto");
            System.out.println("4 - Cadastrar Produto");
            System.out.println("0 - SAIR");


            Scanner sc = new Scanner(System.in);
            var op = sc.nextInt();

            switch (op){
                case 0:
                    sair = true;
                    break;
                case 1:
                    ListarClientes();
                    break;
                case 2:
                    LerCliente();
                    break;
                case 3:
                    ListarProdutos();
                    break;
                case 4:
                    CadastrarProduto();
                default:
                    System.out.printf("Valor inválido");
            }
        }
        //Listar produtos
        //Selecionar produtos

        // Criar pedido
        // Listar pedidos
        // Detalhar pedido
        SalvarCsv(Produtos, produtosFilename);
        SalvarCsv(Pedidos, pedidosFilename);
        SalvarCsv(Clientes, clientesFilename);
        SalvarCsv(ItensPedidos, itensPedidosFilename);
        var idsList = new ArrayList<>();
        idsList.add(Ids);
        SalvarCsv(idsList, "ids.csv");
    }

    public static void LerIds(){
        var fileName = "ids.csv";

        File file = new File(fileName);

        if (file.exists()) {
            Ids =  LerCsv("ids.csv", Ids.class).get(0);
        } else {
            var newids = new Ids(1,1,1,1);
            var list = new ArrayList<>();
            list.add(newids);
            SalvarCsv(list, fileName);
            Ids = newids;
        }
    }

    public static void LerCliente(){
        var cpfRegex = Pattern.compile("^[0-9]{11}$");
        var nomeRegex = Pattern.compile("^(?!.*\\s{2})[A-Za-zÀ-ÖØ-öø-ÿçÇ]+(?:\\s+[A-Za-zÀ-ÖØ-öø-ÿçÇ]+)+$");
        var emailRegex = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})?$");
        var telefoneRegex = Pattern.compile("^[1-9]{2}9?\\d{8}$");
        var senhaRegex = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$");

        var nome = ObterEValidarCampo("Digite o nome do cliente: ", nomeRegex,"Nome inválido, digite apenas letras.");

        var cpf = ObterEValidarCampo("Digite o cpf do cliente: ", cpfRegex, "CPF inválido. Siga o formato 12345678900");

        var email = ObterEValidarCampo("Digite o email do cliente: ", emailRegex, "Digite um email válido.");

        var telefone = ObterEValidarCampo("Digite o telefone do cliente: ", telefoneRegex, "Digite um telefone no formato 53999999999");

        var endereco = ObterCampo("Digite o endereço de entrega do cliente: ");

        var senha = ObterEValidarCampo("Digite a senha do cliente: ", senhaRegex, "Senha inválida, digite uma senha que tenha entre 8-16 carecteres, letras maiusculas e minusculas, número e caracter especial.");

        var dataCadstro = LocalDateTime.now();
        var ativo = true;

        var cliente = new Cliente(Ids.getIdCliente(), nome, cpf, email, telefone, senha, endereco, dataCadstro, ativo);
        Ids.incrementIdCliente();
        Clientes.add(cliente);
    }

    public static void ListarClientes(){
        for(var cliente: Clientes){
            System.out.printf(cliente.toString());
        }
    }
    public static void CadastrarProduto(){
        System.out.println("==========CADASTRO DE PRODUTO==========");
        var nome = ObterCampo("Digite o nome do produto: ");
        var descricao = ObterCampo("Digite a descrição do produto: ");
        var categoria = ObterCampo("Digite o categoria: ");
        var preco = ObterValor("Digite o preço do produto: ");
        var tempoPreparo = ObterValorInteiro("Tempo de preparo estimado: ");
        var disponivel = true;
        var imagem = "https://img.freepik.com/psd-gratuitas/um-prato-de-frango-assado-e-um-banquete-delicioso_632498-25445.jpg?semt=ais_hybrid&w=740";

        var produto = new Produto(Ids.getIdProduto(), nome, descricao, categoria, preco, tempoPreparo, disponivel, imagem);
        Ids.incrementIdProduto();
        Produtos.add(produto);
    }

    public static void ListarProdutos(){
        for(var produto: Produtos){
            System.out.println(produto.toString());
        }
    }
    public static Pedido CadastrarPedido(Cliente cliente){
        Scanner sc = new Scanner(System.in);

        var endereco = cliente.getEndereco();
        System.out.println("Deseja utilizar o endereço previamente cadastrado? S/N");
        System.out.printf("Endereço:  %s\n", endereco);
        var usarClienteEndereco = sc.nextLine();

        if(usarClienteEndereco.equalsIgnoreCase("n")){
            endereco = ObterCampo("Digite o endereço de entrega: ");
        }

        var observacoes = ObterCampo("Observações do pedido: ");

        var itens = new ArrayList<Produto>();
        var pedido = new Pedido(cliente, LocalDateTime.now(), "CONFIRMADO", "CRÉDITO", endereco, observacoes);
        while(true){
            // Listar todos os produtos;
            // Selecionar um produto
            // Se existe, aumentar quantidade
//            var produto = SelecionarProduto();

            var observacoesProduto = ObterCampo("Observações do produto: ");
//            pedido.adicionarItem(produto, observacoesProduto);
        }

    }

//    private static Produto SelecionarProduto() {
//
//    }

    public static String ObterEValidarCampo(String campo, Pattern validacao, String mensagemErro){
        while (true) {
            var valor = ObterCampo(campo);

            if (validacao.matcher(valor).matches()) {
                return valor;
            }
            System.out.println("Valor inválido.");
            System.out.printf("%s\n", mensagemErro);
        }
    }

    public static String ObterCampo(String campo){
        System.out.printf("%s \n", campo);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static BigDecimal ObterValor(String campo){
        while(true) {
            try {
                var valor = new BigDecimal(ObterCampo(campo));
                if(BigDecimal.ZERO.equals(valor)){
                    System.out.println("O valor precisa ser positivo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException ex) {
                System.out.println("Valor decimal inválido");
            }
        }
    }

    public static Integer ObterValorInteiro(String campo){
        while(true) {
            try {
                var valor = Integer.parseInt(ObterCampo(campo));
                if(valor <= 0){
                    System.out.println("O valor precisa ser positivo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException ex) {
                System.out.println("Valor número inválido");
            }
        }
    }

    public static <T> List<T> LerCsv(String fileName, Class<T> type) {
        try{
            File file = new File(fileName);

            if (!file.exists()) {
                return new ArrayList<T>();
            }
            List<T> itens = new CsvToBeanBuilder<T>(new FileReader(fileName))
                    .withType(type).build().parse();

            return itens;
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SalvarCsv(List itens, String fileName) {
        try {
            Writer writer = new FileWriter(fileName);
            var beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(itens);
            writer.close();
        }catch (IOException exception){
            System.out.println("Não foi possível escrever no arquivo.");
        }catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException exception){
            System.out.println("CSV inválido.");
        }
    }
}