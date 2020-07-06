public class test {
    static java.util.Random generator = new java.util.Random();
    static char[][]t;

     static int[][] goWhite(int[][] color_map){
        for(int i=0; i<10; i++){
            for (int j=0; j<10;j++){
                color_map[i][j]=0;
            }
        }
        return color_map;
    }
    static int[][] mapper(int[][] color_map){
        for(int i=0; i<10; i++){
            for (int j=0; j<10;j++){
                if(t[i][j]=='x'){
                    if(i!=9) color_map[i+1][j]+=1;
                    if(j!=9) color_map[i][j+1]+=1;
                    if(i!=0) color_map[i-1][j]+=1;
                    if(j!=0) color_map[i][j-1]+=1;
                }
                else if(t[i][j]!='0'){
                    color_map[i][j]+=1;
                }

            }
        }
        return color_map;
    }
     static boolean FakeubicarNave(int l, char tipo){
         int x = 1+generator.nextInt(10);
         int y = 1+generator.nextInt(10);
         System.out.println(x + "=x ;  y=" + y+ " ; l= "+l);
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

    static void resetmap() {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j <t.length; j++) {
                if(t[i][j]!='x'){
                   t[i][j]='0';
                }
            }
        }
    }

public static void main(String[] args){
    Tablero game = new Tablero(10);
    int cant_A=5;
    int cant_B=4;
    int cant_C=3;
    int cant_S=3;
    int cant_D=2;
    char aux;
    t=new char[12][12];
    for(int i=1;i<10;i++)
        for(int j=1;j<10;j++)
            t[i][j]= '0';
    int [][] color_map=new int[10][10];
    while (game.ganar()==0) {
        for (int i = 0; i < 7; i += 1) {
            color_map = goWhite(color_map);
            resetmap();
            System.out.println("mapa " +i);
            while (!FakeubicarNave(cant_A, 'A')) ;
            while (!FakeubicarNave(cant_B, 'B')) ;
            while (!FakeubicarNave(cant_C, 'C')) ;
            while (!FakeubicarNave(cant_S, 'S')) ;
            while (!FakeubicarNave(cant_D, 'D')) ;
            color_map = mapper(color_map);
            resetmap();
        }
        int max = 0;
        int auxx = 0;
        int auxy = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; j < 10; j++) {
                if (max < color_map[j][k]) {
                    max = color_map[j][k];
                    auxx = j;
                    auxy = k;
                }
            }
        }
        System.out.println("disparanding");
        aux= game.disparo(auxx, auxy);
        if(aux=='A'){
            cant_A--;
        }
        if (aux=='B'){
            cant_B--;
        }
        if (aux=='C'){
            cant_C--;
        }
        if (aux=='D'){
            cant_D--;
        }
        if (aux=='S'){
            cant_S--;
        }
    }
    System.out.println("ganado con " + game.ganar() +" tiros");

}

}
