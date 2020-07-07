import java.util.Scanner;
public class test {
    static java.util.Random generator = new java.util.Random();
    static char[][]t;

     static int[][] goWhite(int[][] color_map){
         for(int i=1;i<11;i++)
             for(int j=1;j<11;j++)
                color_map[i][j]=0;


        return color_map;
    }
    static int[][] mapper(int[][] color_map) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (t[i][j] == 'x') {
                    if (i != 9) color_map[i + 1][j] += 1;
                    if (j != 9) color_map[i][j + 1] += 1;
                    if (i != 0) color_map[i - 1][j] += 1;
                    if (j != 0) color_map[i][j - 1] += 1;
                } else if (t[i][j] != '0') {
                    color_map[i][j] += 1;
                }

            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            if(t[i][j]=='f' ||t[i][j]=='x') color_map[i][j]=0;
            }}
        return color_map;
    }
     static boolean FakeubicarNave(int l, char tipo){
         int x = 1+generator.nextInt(t.length-2);
         int y = 1+generator.nextInt(t.length-2);
        // System.out.println(x + "=x ;  y=" + y+ " ; l= "+l);
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
         if(x+l>=t.length||y+l>=t.length) return false;
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
                if(t[i][j]!='x' && t[i][j]!='f' ){
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
    int n=10;
    Scanner myObj = new Scanner(System.in);
    t = new char[n+2][n+2];
    for(int i=1;i<n+1;i++)
        for(int j=1;j<n+1;j++)
            t[i][j]= '0';
    int [][] color_map=new int[12][12];
    int xd=1;
    while (game.ganar()==0) {

        color_map = goWhite(color_map);
        for (int i = 0; i < 100; i += 1) {
            resetmap();
            //System.out.println("mapa " +i);
            if(cant_A!=0)while (!FakeubicarNave(cant_A, 'A')) ;
            if(cant_B!=0)while (!FakeubicarNave(cant_B, 'B')) ;
            if(cant_C!=0)while (!FakeubicarNave(cant_C, 'C')) ;
            if(cant_S!=0)while (!FakeubicarNave(cant_S, 'S')) ;
            if(cant_D!=0)while (!FakeubicarNave(cant_D, 'D')) ;
            color_map = mapper(color_map);
            resetmap();
        }


        int max = -10;
        int auxx = 0;
        int auxy = 0;
        for (int j = 1; j < 10; j++) {
            for (int k = 1; k < 10; k++) {
                if (max < color_map[j][k]) {
                    max = color_map[j][k];
                    auxx = j;
                    auxy = k;
                    //System.out.println("max acutal: "+ max);
                }
            }
        }
      System.out.println("disparanding  a "+ auxx +","+ auxy+ " van "+xd+" tiros");
        xd++;
        aux= game.disparo(auxx, auxy);
        if(aux=='A'){
            cant_A--;
            t[auxx][auxy]='x';
        }
        if (aux=='B'){
            cant_B--;
            t[auxx][auxy]='x';
        }
        if (aux=='C'){
            cant_C--;
            t[auxx][auxy]='x';
        }
        if (aux=='D'){
            cant_D--;
            t[auxx][auxy]='x';
        }
        if (aux=='S'){
            cant_S--;
            t[auxx][auxy]='x';
        }
        if (aux=='0'){
            t[auxx][auxy]='f';
        }
        System.out.println("resultado tiro "+aux+  " A :"+ cant_A + " B: "+ cant_B+" C: " + cant_C +" s: "+ cant_S + " D: " + cant_D);
        System.out.println("estado actual del mapa");
        for(int i=1;i<t.length-1;i++){
            for(int j=1;j<t.length-1;j++)
                System.out.print(t[i][j] + " ");
            System.out.println("");
        }

        //myObj.nextLine();
    }
    System.out.println("ganado con " + game.ganar() +" tiros");

}

}
