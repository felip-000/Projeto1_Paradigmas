import java.util.Random;
import java.util.Arrays;

public class MeuVetor {
    private double[] v;
    private int ultimaPos; //garante que a regra de negócios estabelecida vai ser seguida
    //Instancias: ocorrencias concretas de serviço
    //Método != construtor
    //construtor é sempre public e é classe
    /*4 níveis de acesso: private (Só classe encherga), default (classe e pacote enchergam), 
    protected (todos enchergam menos o mundo) e public (todos enchergam)*/
    //4 niveis de visibilidade: classe, pacote, herdeiros, mundo
    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso
    public int getUltimaPos (){
        return ultimaPos;
    }
    public double[] getV (){
        return v;
    }
    //modificador
    public void setUltimaPos(int pos){
        if (pos >= 0 && pos < v.length){
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }
    public boolean estaCheio () {
        return ultimaPos == v.length - 1;
    }

    public boolean estaVazio() {
        // if (ultimaPos == -1){
        //     return true;
        // }
        // return false;
        return ultimaPos == -1;
    }
    private void redimensiona(int novaCapacidade){
        double[] temp = new double[novaCapacidade];
            for(int i=0; i<=ultimaPos; i++){
                temp[i] = v[i];
            }
            v=temp;
    }

    public void adiciona (double e){
        if (estaCheio()){
            redimensiona(v.length*2);
        }
        ultimaPos++;
        v[ultimaPos] = e; //Ou tira o ultimaPos++ da linha anterior e coloca ++ultimaPos dentro dos colchetes dessa linha
    }

    public double remove(){
        if(estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length >= 10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        }
        return aux;
    }
    
    @Override
    public String toString () {
        String s = "";
        if(estaVazio()){
            s = s + "esta vazio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++){
                s = s + String.format("%.0f ", v[i]);
            }
        }
        return s + "\n";
    }

    public void bubbleSort(){
        for(int i = 1; i < v.length; i++){
            for(int j = 0; j < v.length-i; j++){
                if(v[j] > v[j+1]){ //< menor pro maior, > maior pro menor
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
    public void selectionSort(){
        for (int i = 0; i < v.length-1; i++){
            int menor = i;
            for (int j = i+1; j < v.length; j++){
                if (v[j] > v[menor]){
                    // troquei o sinal de < para > para desordenar, colocar em decrescente e depois reordenar
                    menor = j;
                }
            }
            double aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
            System.out.println("Passo select: " + (i + 1) + ": " + Arrays.toString(v));
        }
    }
    public void insertionSort(){
        for (int i = 1; i < v.length; i++){
            double aux = v[i];
            int j = i-1;
            while (j>=0 && v[j] > aux){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
            System.out.println("Passo insert:"  + i + ": " + Arrays.toString(v));
        }
    }
    public void preencheVetor(){
        Random r = new Random();
        for(int i = 0; i < v.length; i++){
            // adiciona(Math.random());
            // adiciona(r.nextDouble());
            adiciona(r.nextInt(v.length*10) + 1);
        }
    }
    public Retorno buscaSimples(double e){
        Retorno r = new Retorno();
        if(estaVazio()){ 
            return r;
        }
        for(int i=0; i<=ultimaPos; i++){
            r.incrementaCont();
            if(v[i] == e){
                r.setAchou(true);
                return r;
            }
        }
        return r;
    }
    public Retorno buscaBinaria (double e){
        Retorno r = new Retorno();
        if(estaVazio()){
            return r;
        }
        int inicio = 0;
        int fim = ultimaPos;
        while(inicio<=fim){
            r.incrementaCont(2);
            int meio = (inicio+fim)/2;
            if(e == v[meio]){
                r.setAchou(true);
                return r;
            }
            if(e > v[meio]){
                inicio = meio + 1;
            }
            else{
                fim = meio - 1;
            }
        }
        return r;
    }
}
/*Seja esperto que nem o jvm, quando usar && coloque a proposição com mais chances de ser falsa na frente,
 e quando for || coloque a com mais chances de ser verdadeira na frente*/
/*Se usar só um & ou | ele vai fazer os dois testes independente do resultado do primeiro teste, basicamente só é útil na 
inicialização do arquivo*/