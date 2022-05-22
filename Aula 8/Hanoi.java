package ediquatroum;
public class Hanoi {
    public long movimentarDiscos(int discos,char original,char aux,char destino){
        
        if(discos>0){
            
            long movimentos = (long) Math.pow(2,discos) - 1;
            movimentarDiscos((discos-1), original, destino, aux);
            movimentarDiscos((discos-1), aux, destino, original);
        
            return movimentos;
        }
        
        return 0;
    }
}