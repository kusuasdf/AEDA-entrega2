import java.util.Scanner;
public class test {
    static java.util.Random generator = new java.util.Random();
    static char[][]t;
    static int cant_A=5;
    static int cant_B=4;
    static int cant_C=3;
    static int cant_S=3;
    static int cant_D=2;
    static int [][] color_map;
    static Tablero game;

    static void destroy(int auxx, int auxy){
        //System.out.println("disparanding");
        char aux= game.disparo(auxx,auxy);
       // System.out.println("disparanding "+ aux);
        if(aux=='A'){
            destroyA(auxx,auxy);
        }
        if(aux=='B'){
            destroyB(auxx,auxy);
        }
        if(aux=='C'){
            destroyC(auxx,auxy);
        }
        if(aux=='S'){
            destroyS(auxx,auxy);
        }
        if(aux=='D'){
            destroyD(auxx,auxy);
        }
        if(aux=='0'){
            t[auxx][auxy]='f';
          //  System.out.println("f");
        }
        if(aux=='X'){
            System.out.println("la cagamos tamo en X");
        }
    }

    private static void destroyS(int auxx, int auxy) {
        System.out.println("destroyS");
        int move=1;
        char aux;
        cant_S--;
        t[auxx][auxy]='X';
        //Try up
        while (cant_S!=0 && auxy-move>=1){
            if (color_map[auxx][auxy-move]!=0) {
                aux=game.disparo(auxx,auxy-move);
                switch (aux){
                    case 'A':   destroyA(auxx,auxy-move);
                        move++;
                        break;
                    case 'D':   destroyD(auxx,auxy-move);
                        move++;
                        break;
                    case 'C':   destroyC(auxx,auxy-move);
                        move++;
                        break;
                    case 'B':   destroyB(auxx,auxy-move);
                        move++;
                        break;
                    case 'S':   move++;
                        cant_S--;
                        t[auxx][auxy-move]='X';
                        break;
                }
                if (aux=='0'){
                    move++;
                    t[auxx][auxy-move]='f';
                    break;
                }
            }
            break;
        }
        move=1;
        //Try down
        while (cant_S!=0 && auxy+cant_S<=11){
            if (color_map[auxx][auxy+move]!=0) {
                aux=game.disparo(auxx,auxy+move);
                switch (aux){
                    case 'A':   destroyA(auxx,auxy+move);
                        move++;
                        break;
                    case 'D':   destroyD(auxx,auxy+move);
                        move++;
                        break;
                    case 'C':   destroyC(auxx,auxy+move);
                        move++;
                        break;
                    case 'B':   destroyB(auxx,auxy+move);
                        move++;
                        break;
                    case 'S':   move++;
                        cant_S--;
                        t[auxx][auxy+move]='X';
                        break;
                }
                if (aux=='0'){
                    move++;
                    t[auxx][auxy+move]='f';
                    break;
                }
            }
            break;
        }
        move=1;
        //Try left
        while (cant_S!=0 && auxx-cant_S>=1){
            if (color_map[auxx-move][auxy]!=0) {
                aux=game.disparo(auxx-move,auxy);
                switch (aux){
                    case 'A':   destroyA(auxx-move,auxy);
                        move++;
                        break;
                    case 'D':   destroyD(auxx-move,auxy);
                        move++;
                        break;
                    case 'C':   destroyC(auxx-move,auxy);
                        move++;
                        break;
                    case 'B':   destroyB(auxx-move,auxy);
                        move++;
                        break;
                    case 'S':   move++;
                        cant_S--;
                        t[auxx-move][auxy]='X';
                        break;
                }
                if (aux=='0'){
                    move++;
                    t[auxx-move][auxy]='f';
                    break;
                }
            }
            break;
        }
        move=1;
        //Try Right
        while (cant_S!=0 && auxx+cant_S<=11){
            if (color_map[auxx+move][auxy]!=0) {
                aux=game.disparo(auxx+move,auxy);
                switch (aux){
                    case 'A':   destroyA(auxx+move,auxy);
                        move++;
                        break;
                    case 'D':   destroyD(auxx+move,auxy);
                        move++;
                        break;
                    case 'C':   destroyC(auxx+move,auxy);
                        move++;
                        break;
                    case 'B':   destroyB(auxx+move,auxy);
                        move++;
                        break;
                    case 'S':   move++;
                        cant_S--;
                        t[auxx+move][auxy]='X';
                        break;
                }
                if (aux=='0'){
                    move++;
                    t[auxx+move][auxy]='f';
                    break;
                }
            }
        }
    }

    private static void destroyC(int auxx, int auxy) {
        System.out.println("destroyC");
        int move=1;
        char aux;
        cant_C--;
        t[auxx][auxy]='X';
        //Try up
        while (cant_C!=0 && auxy-move>=1){
            aux=game.disparo(auxx,auxy-move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy-move);
                    move++;
                    break;
                case 'D':   destroyD(auxx,auxy-move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy-move);
                    move++;
                    break;
                case 'B':   destroyB(auxx,auxy-move);
                    move++;
                    break;
                case 'C':   move++;
                    cant_C--;
                    t[auxx][auxy-move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy-move]='f';
                break;
            }

        }
        move=1;
        //Try down
        while (cant_C!=0 && auxy+cant_C<=11){
            aux=game.disparo(auxx,auxy+move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy+move);
                    move++;
                    break;
                case 'D':   destroyD(auxx,auxy+move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy+move);
                    move++;
                    break;
                case 'B':   destroyB(auxx,auxy+move);
                    move++;
                    break;
                case 'C':   move++;
                    cant_C--;
                    t[auxx][auxy+move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy+move]='f';
                break;
            }
        }
        move=1;
        //Try left
        while (cant_C!=0 && auxx-cant_C>=1){
            aux=game.disparo(auxx-move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx-move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx-move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx-move,auxy);
                    move++;
                    break;
                case 'B':   destroyB(auxx-move,auxy);
                    move++;
                    break;
                case 'C':   move++;
                    cant_C--;
                    t[auxx-move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx-move][auxy]='f';
                break;
            }
        }
        move=1;
        //Try Right
        while (cant_C!=0 && auxx+cant_C<=11){
            aux=game.disparo(auxx+move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx+move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx+move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx+move,auxy);
                    move++;
                    break;
                case 'B':   destroyB(auxx+move,auxy);
                    move++;
                    break;
                case 'C':   move++;
                    cant_C--;
                    t[auxx+move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx+move][auxy]='f';
                break;
            }
        }
    }

    private static void destroyD(int auxx, int auxy) {
        System.out.println("destroyD");
        int move=1;
        char aux;
        cant_D--;
        t[auxx][auxy]='X';
        //Try up
        while (cant_D!=0 && auxy-move>=1){
            aux=game.disparo(auxx,auxy-move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy-move);
                    move++;
                    break;
                case 'C':   destroyC(auxx,auxy-move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy-move);
                    move++;
                    break;
                case 'B':   destroyB(auxx,auxy-move);
                    move++;
                    break;
                case 'D':   move++;
                    cant_D--;
                    t[auxx][auxy-move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy-move]='f';
                break;
            }

        }
        move=1;
        //Try down
        while (cant_D!=0 && auxy+cant_D<=11){
            aux=game.disparo(auxx,auxy+move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy+move);
                    move++;
                    break;
                case 'C':   destroyC(auxx,auxy+move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy+move);
                    move++;
                    break;
                case 'B':   destroyB(auxx,auxy+move);
                    move++;
                    break;
                case 'D':   move++;
                    cant_D--;
                    t[auxx][auxy+move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy+move]='f';
                break;
            }
        }
        move=1;
        //Try left
        while (cant_D!=0 && auxx-cant_D>=1){
            aux=game.disparo(auxx-move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx-move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx-move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx-move,auxy);
                    move++;
                    break;
                case 'B':   destroyB(auxx-move,auxy);
                    move++;
                    break;
                case 'D':   move++;
                    cant_D--;
                    t[auxx-move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx-move][auxy]='f';
                break;
            }
        }
        move=1;
        //Try Right
        while (cant_D!=0 && auxx+cant_D<=11){
            aux=game.disparo(auxx+move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx+move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx+move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx+move,auxy);
                    move++;
                    break;
                case 'B':   destroyB(auxx+move,auxy);
                    move++;
                    break;
                case 'D':   move++;
                    cant_D--;
                    t[auxx+move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx+move][auxy]='f';
                break;
            }
        }
    }

    private static void destroyB(int auxx, int auxy) {
        System.out.println("destroyB");
        int move=1;
        char aux;
        cant_B--;
        t[auxx][auxy]='X';
        //Try up
        while (cant_B!=0 && auxy-move>=1){
            aux=game.disparo(auxx,auxy-move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy-move);
                    move++;
                    break;
                case 'C':   destroyC(auxx,auxy-move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy-move);
                    move++;
                    break;
                case 'D':   destroyD(auxx,auxy-move);
                    move++;
                    break;
                case 'B':   move++;
                    cant_B--;
                    t[auxx][auxy-move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy-move]='f';
                break;
            }

        }
        move=1;
        //Try down
        while (cant_B!=0 && auxy+cant_B<=11){
            aux=game.disparo(auxx,auxy+move);
            switch (aux){
                case 'A':   destroyA(auxx,auxy+move);
                    move++;
                    break;
                case 'C':   destroyC(auxx,auxy+move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy+move);
                    move++;
                    break;
                case 'D':   destroyD(auxx,auxy+move);
                    move++;
                    break;
                case 'B':   move++;
                    cant_B--;
                    t[auxx][auxy+move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy+move]='f';
                break;
            }
        }
        move=1;
        //Try left
        while (cant_B!=0 && auxx-cant_B>=1){
            aux=game.disparo(auxx-move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx-move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx-move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx-move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx-move,auxy);
                    move++;
                    break;
                case 'B':   move++;
                    cant_B--;
                    t[auxx-move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx-move][auxy]='f';
                break;
            }
        }
        move=1;
        //Try Right
        while (cant_B!=0 && auxx+cant_B<=11){
            aux=game.disparo(auxx+move,auxy);
            switch (aux){
                case 'A':   destroyA(auxx+move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx+move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx+move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx+move,auxy);
                    move++;
                    break;
                case 'B':   move++;
                    cant_B--;
                    t[auxx+move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx+move][auxy]='f';
                break;
            }
        }
    }

    private static void destroyA(int auxx, int auxy) {
        System.out.println("destroyA");
        int move=1;
        char aux;
        cant_A--;
        t[auxx][auxy]='X';
        //Try up
        while (cant_A!=0 && auxy-move>=1){
            aux=game.disparo(auxx,auxy-move);
            switch (aux){
                case 'B':   destroyB(auxx,auxy-move);
                            move++;
                            break;
                case 'C':   destroyC(auxx,auxy-move);
                            move++;
                            break;
                case 'S':   destroyS(auxx,auxy-move);
                            move++;
                            break;
                case 'D':   destroyD(auxx,auxy-move);
                            move++;
                            break;
                case 'A':   move++;
                            cant_A--;
                            t[auxx][auxy-move]='X';
                            break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy-move]='f';
                break;
            }

        }
        move=1;
        //Try down
        while (cant_A!=0 && auxy+cant_A<=11){
            aux=game.disparo(auxx,auxy+move);
            switch (aux){
                case 'B':   destroyB(auxx,auxy+move);
                    move++;
                    break;
                case 'C':   destroyC(auxx,auxy+move);
                    move++;
                    break;
                case 'S':   destroyS(auxx,auxy+move);
                    move++;
                    break;
                case 'D':   destroyD(auxx,auxy+move);
                    move++;
                    break;
                case 'A':   move++;
                    cant_A--;
                    t[auxx][auxy+move]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx][auxy+move]='f';
                break;
            }
        }
        move=1;
        //Try left
        while (cant_A!=0 && auxx-cant_A>=1){
            aux=game.disparo(auxx-move,auxy);
            switch (aux){
                case 'B':   destroyB(auxx-move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx-move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx-move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx-move,auxy);
                    move++;
                    break;
                case 'A':   move++;
                    cant_A--;
                    t[auxx-move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx-move][auxy]='f';
                break;
            }
        }
        move=1;
        //Try Right
        while (cant_A!=0 && auxx+cant_A<=11){
            aux=game.disparo(auxx+move,auxy);
            switch (aux){
                case 'B':   destroyB(auxx+move,auxy);
                    move++;
                    break;
                case 'C':   destroyC(auxx+move,auxy);
                    move++;
                    break;
                case 'S':   destroyS(auxx+move,auxy);
                    move++;
                    break;
                case 'D':   destroyD(auxx+move,auxy);
                    move++;
                    break;
                case 'A':   move++;
                    cant_A--;
                    t[auxx+move][auxy]='X';
                    break;
            }
            if (aux=='0'){
                move++;
                t[auxx+move][auxy]='f';
                break;
            }
        }
    }

    static int[][] goWhite(int[][] color_map){
         for(int i=1;i<12;i++)
             for(int j=1;j<12;j++)
                color_map[i][j]=0;
        return color_map;
    }

    static int[][] mapper(int[][] color_map) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (t[i][j] == 'X') {
                    if (i != 10) color_map[i + 1][j] += 1;
                    if (j !=10) color_map[i][j + 1] += 1;
                    if (i != 1) color_map[i - 1][j] += 1;
                    if (j != 1) color_map[i][j - 1] += 1;
                } else if (t[i][j] != '0') {
                    color_map[i][j] += 1;
                }

            }
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if(t[i][j]=='f' ||t[i][j]=='X')
                    color_map[i][j]=0;
            }
        }
        return color_map;
    }

     static boolean FakeubicarNave(int l, char tipo){
        try{
            int x = 1+generator.nextInt(t.length-2);
         int y = 1+generator.nextInt(t.length-2);
        //System.out.println(x + "=x ;  y=" + y+ " ; l= "+l);
         int dir = generator.nextInt(2);
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
         //if(x+l>=t.length||y+l>=t.length) return false;
         if(dir==0 && t[x-(l)][y]!='0') return false;
         if(dir==1 && t[x+(l)][y]!='0') return false;
         if(dir==2 && t[x][y-(l)]!='0') return false;
         if(dir==3 && t[x][y+(l)]!='0') return false;
         for(int i=0;i<l;i++){
             if(dir==0) t[x+i][y]=tipo;
             if(dir==1) t[x][y+i]=tipo;
         }
         return true;
        }
        catch (Exception e){
           // System.out.println("error al crear tablero fantasma");
            return true;
        }
     }

    static void resetTable() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j <11; j++) {
                if(t[i][j]!='X' || t[i][j]!='f' ){
                   t[i][j]='0';
                }
            }
        }
    }

public static void main(String[] args){
    game = new Tablero(10);

    char aux;
    int n=10;
    int suma=0;
    t = new char[n+2][n+2];
    for(int i=1;i<n+1;i++)
        for(int j=1;j<n+1;j++)
            t[i][j]= '0';
    color_map=new int[12][12];
    for(int juegos=1; juegos<=1;juegos++){


        while (game.ganar()==0) {
            color_map = goWhite(color_map);
            for (int i = 0; i < 100; i += 1) {
                resetTable();
                //System.out.println("mapa " +i);
                if(cant_A!=0)while (!FakeubicarNave(cant_A, 'A')) ;
                if(cant_B!=0)while (!FakeubicarNave(cant_B, 'B')) ;
                if(cant_C!=0)while (!FakeubicarNave(cant_C, 'C')) ;
                if(cant_S!=0)while (!FakeubicarNave(cant_S, 'S')) ;
                if(cant_D!=0)while (!FakeubicarNave(cant_D, 'D')) ;
                color_map = mapper(color_map);
                resetTable();
            }
            int max = color_map[1][1];
            int auxx = 0;
            int auxy = 0;
            for (int j = 1; j < 12; j++) {
                for (int k = 1; k < 12; k++) {
                    if (max < color_map[j][k] && t[j][k]!='X') {
                        max = color_map[j][k];
                        auxx = j;
                        auxy = k;
                        //System.out.println("max acutal: "+ max);
                    }
                }
            }
            color_map[auxx][auxy]=0;
            //System.out.println("t["+auxx+"]["+auxy+"] = "+game.t[auxx][auxy]);
            destroy(auxx,auxy);
            /*System.out.println("resultado tiro "+aux+  " A :"+ cant_A + " B: "+ cant_B+" C: " + cant_C +" s: "+ cant_S + " D: " + cant_D);
            System.out.println("estado actual del mapa");
            for(int i=1;i<t.length-1;i++){
                for(int j=1;j<t.length-1;j++)
                    System.out.print(t[i][j] + " ");
                System.out.println("");
            }*/

            //myObj.nextLine();
        }
        suma+=game.ganar();
    }
    System.out.println("promedio es: "+ suma);
}

}
