public class test {
    static java.util.Random generator = new java.util.Random();
    char[][]t;
public static void main(String[] args){
    Tablero game = new Tablero(10);
    Tablero help;
    char [][] aux;
    int [][] color_map;
    game.Imprimir();
}
int[][] mapper(int[][] color_map){
    int[][] f =new int[10][10];
    for(int i=0; i<10; i++){
        for (int j=0; j<10;j++){
            if(t[i][j]=='0'|| t[i][j]=){

            }
            else if()
        }
    }
}
    boolean FakeubicarNave(int l, char tipo){
        int x = 1+generator.nextInt(t.length-2);
        int y = 1+generator.nextInt(t.length-2);
        //System.out.println(x + " " + y);
        int dir = generator.nextInt(4);
        //if(t[x-1][y]!='0' || t[x+1][y]!='0' || t[x][y-1]!='0' || t[x][y+1]!='0') return false;
        if(dir==0 && x-(l-1)<1) return false;
        if(dir==1 && x+(l-1)>t.length-1) return false;
        if(dir==2 && y-(l-1)<1) return false;
        if(dir==3 && y+(l-1)>t.length-1) return false;
        for(int i=0;i<l;i++){
            if(dir==0 && (t[x-i][y]!='0' || t[x-i][y+1]!='0' || t[x-i][y-1]!='0')) return false;
            if(dir==1 && (t[x+i][y]!='0' || t[x+i][y+1]!='0' || t[x+i][y-1]!='0')) return false;
            if(dir==2 && (t[x][y-i]!='0' || t[x-1][y-i]!='0' || t[x+1][y-i]!='0')) return false;
            if(dir==3 && (t[x][y+i]!='0' || t[x-1][y+i]!='0' || t[x+1][y+i]!='0')) return false;
        }
        if(dir==0 && t[x-(l)][y]!='0') return false;
        if(dir==1 && t[x+(l)][y]!='0') return false;
        if(dir==2 && t[x][y-(l)]!='0') return false;
        if(dir==3 && t[x][y+(l)]!='0') return false;
        for(int i=0;i<l;i++){
            if(dir==0) t[x-i][y]=tipo;
            if(dir==1) t[x+i][y]=tipo;
            if(dir==2) t[x][y-i]=tipo;
            if(dir==3) t[x][y+i]=tipo;
        }
        return true;
    }
}
