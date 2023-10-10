

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();
        ArrayList<PessoaJuridica> listaPJ = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de cadastro de pessoa fisica e pessoa juridica!!! ");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opcao: 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {

                case 1:
                    int opcaopf;
                    do {

                        System.out.println("Escolha uma opcao: 1 - Cadastrar pessoa Fisica / 2 - Listar pessoa Fisica / 0 Voltar ao menu anterior");
                        opcaopf = scanner.nextInt();
                        switch (opcaopf) {
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("digite o nome da pessoa fisica: ");
                                novapf.nome = scanner.next();

                                System.out.println("digite o cpf: ");
                                novapf.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal: ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de nascimento (dd/MM/aaaa): ");
                                novapf.dataDeNascimento = LocalDate.parse(scanner.next());
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                novapf.dataDeNascimento = date;

                                if (periodo.getYears() >= 18) {
                                    System.out.println("A Pessoa tem mais de 18 anos");
                                } else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando ao menu...");
                                    break;
                                }


                                System.out.println("Digite o logradouro: ");
                                novoEndPf.logradouro = scanner.next();

                                System.out.println("Digite o numero: ");
                                novoEndPf.numero = scanner.next();

                                System.out.println("Este endereco e comercial? S/N ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoEndPf.endComercial = true;
                                } else {
                                    novoEndPf.endComercial = false;
                                }

                                novapf.endereco = novoEndPf;

                                listaPf.add(novapf);

                                System.out.println("Cadastro realizado com sucesso!!");


                                break;
                            case 2:

                                if (listaPf.size() > 0) {
                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de nascimento: " + cadaPf.dataDeNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("");
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaopf = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;
                            default:
                                System.out.println("Opcao invalida, por favor digite uma opcao valida!");
                                break;
                        }
                    } while (opcaopf != 0);
                    break;
                case 2:
                    int opcaopj;


                    do {
                        System.out.println("Escolha uma opcao: 1 - Cadastrar pessoa juridica / 2 - Listar pessoa juridica / 0 Voltar ao menu anterior");
                        opcaopj = scanner.nextInt();

                        switch (opcaopj) {
                            case 1:
                                PessoaJuridica novapj = new PessoaJuridica();
                                Endereco novoendpj = new Endereco();

                                System.out.println("digite o nome da pessoa fisica: ");
                                novapj.nome = scanner.next();

                                System.out.println("digite o cpf: ");
                                novapj.cnpj = scanner.next();

                                System.out.println("digite a razao social: ");
                                novapj.razaoSocial = scanner.next();

                                System.out.println("Digite o rendimento mensal: ");
                                novapj.rendimento = scanner.nextInt();

                                System.out.println("Digite o logradouro: ");
                                novoendpj.logradouro = scanner.next();

                                System.out.println("Digite o numero: ");
                                novoendpj.numero = scanner.next();

                                System.out.println("Este endereco e comercial? S/N ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoendpj.endComercial = true;
                                } else {
                                    novoendpj.endComercial = false;
                                }

                                novapj.endereco = novoendpj;


                                listaPJ.add(novapj);

                                System.out.println("Cadastro realizado com sucesso!!");
                                break;

                            case 2:
                                if (listaPJ.size() > 0) {
                                    for (PessoaJuridica cadaPJ : listaPJ) {

                                        System.out.println();
                                        System.out.println("Nome: " + cadaPJ.nome);
                                        System.out.println("CPF: " + cadaPJ.cnpj);
                                        System.out.println("Endereco: " + cadaPJ.endereco.logradouro + ", " + cadaPJ.endereco.numero);
                                        System.out.println("Data de nascimento: " + cadaPJ.razaoSocial);
                                        System.out.println("imposto a ser pago: " + metodosPf.CalcularImposto(cadaPJ.rendimento));
                                        System.out.println("");
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();


                                    }

                                    opcaopj = scanner.nextInt();
                                }else {
                                    System.out.println("Lista Vazia!");
                                }

                        }


                    } while (opcaopj != 0);

                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema! Forte Abraco!");
                    break;
                default:
                    System.out.println("Opcao invalida, por favor digite uma opcao valida!");


            }


        } while (opcao != 0);

    }
}