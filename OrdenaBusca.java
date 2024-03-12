import java.util.Scanner;

public class OrdenaBusca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MeuVetor v1;
        System.out.println("Digite n, 0 encerra: ");
        int n = sc.nextInt();
        while(n>0){
            v1 = new MeuVetor(n);
            v1.preencheVetor();
            // System.out.println("Vetor Gerado: " + v1);
            System.out.println("Digite valor para a busca: ");
            double x = sc.nextDouble();
            Retorno r = v1.buscaSimples(x);
            if(r.getAchou()){
                System.out.println(x + " encontrado pela busca simples");
            }
            else{
                System.out.println(x + " nao encontrado pela busca simples");
            }
            System.out.println("Busca simples realizou " + r.getCont() + " comparacoes");
            System.out.println("\nordenando...");
            v1.bubbleSort();
            r = v1.buscaBinaria(x);
            if(r.getAchou()){
                System.out.println(x + " encontrado pela busca binaria");
            }
            else{
                System.out.println(x + " nao encontrado pela busca binaria");
            }
            System.out.println("Busca binaria realizou " + r.getCont() + " comparacoes");
            System.out.println("\nDigite n, 0 encerra: ");
            n = sc.nextInt();
        }
        sc.close();
    }
}
