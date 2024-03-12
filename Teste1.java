public class Teste1 {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(4);
        System.out.println("Ultima posicao depois da construcao: " + v1.getUltimaPos());
        System.out.println("vetor recem construido: " + v1);

        // v1.setUltimaPos(35); //Aqui foi o motivo de estar cheio, ele entendeu o vetor como cheio, mesmo não tendo nada, por causa que ele foi pra última posição
        // System.out.println("Ultima posicao depois da construcao: " + v1.getUltimaPos());
        // System.out.println("vetor recem construido: " + v1);
        
        // if (v1.adiciona(100)){
        //     System.out.println("Elemento inserido com sucesso");
        // }
        // else{
        //     System.out.println("Vetor esta cheio");
        // }
        // System.out.println("Ultima posicao depois da insercao: " + v1.getUltimaPos());
        // System.out.println("vetor depois da insercao: " + v1);

        // for(int n=0; n<=v1.getV().length; n++){
        //     v1.adiciona((n+1)*10);
        //     System.out.println(v1);
        // }

        for(int i=0; i<=100; i++){
            v1.adiciona(i);
            System.out.println("Adicionou " + i + " capacidade: " + v1.getV().length);
        }
        while(!v1.estaVazio()){
            System.out.println(v1.remove() + " foi atendido, capacidade: " + v1.getV().length);
        }
        for(int i=0; i<=100; i++){
            v1.adiciona(i);
            System.out.println("Adicionou " + i + " capacidade: " + v1.getV().length);
        }

        System.out.println("Ultima posicao depois da insercao: " + v1.getUltimaPos());
        System.out.println("vetor depois da insercao: " + v1);
    }
    
}