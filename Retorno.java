public class Retorno {
    private int cont;
    private boolean achou;
    //Construtor padrão zera tudo
    public int getCont(){
        return cont;
    }
    public boolean getAchou(){
        return achou;
    }
    public void incrementaCont(){
        cont++;
    }
    public void incrementaCont(int k){
        cont+=k;
    }
    public void setAchou(boolean achou){
        this.achou = achou;
    }
}