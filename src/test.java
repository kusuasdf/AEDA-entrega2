import java.io.Console;
import java.util.Scanner;
public class test {
    static java.util.Random generator = new java.util.Random();
    public char[][]t;
    static int cant_A=5;
    static int cant_B=4;
    static int cant_C=3;
    static int cant_S=3;
    static int cant_D=2;
    static int cant;
    static int [][] color_map;
    static Tablero game;
    static test fantasma;

    public void destroy(int auxx, int auxy){
        if(game.t[auxx][auxy] != 'X' && t[auxx][auxy] != 'X' && t[auxx][auxy] != 'f'  ){
            char aux= game.disparo(auxx,auxy);
            // System.out.println("Dispara en ["+auxx+"]["+auxy+"]="+aux);

            if(aux=='A'){
                destroyByChar(auxx,auxy, 'A');
            }else if(aux=='B'){
                destroyByChar(auxx,auxy, 'B');
            }else if(aux=='C'){
                destroyByChar(auxx,auxy, 'C');
            }else if(aux=='S'){
                destroyByChar(auxx,auxy, 'S');
            }else if(aux=='D'){
                destroyByChar(auxx,auxy, 'D');
            }else if(aux=='0'){
                t[auxx][auxy]='f';
                // System.out.println("f");
            }
        }
        /*if(aux=='X'){
            //System.out.println("la cagamos tamo en X");

        }*/
    }

    private void destroyByChar(int auxx, int auxy, char tipo) {

        if(tipo == 'A'){
            cant = 5;
        }else if(tipo == 'B'){
            cant = 4;
        }else if(tipo == 'C'){
            cant = 3;
        }else if(tipo == 'S'){
            cant = 3;
        }else if(tipo == 'D'){
            cant = 2;
        }else{
            System.out.println("hermano por que entraste aca?");
            cant = 1;
        }
        int cantHelper = cant;
        // System.out.println("destroy"+tipo+"("+auxx+","+auxy+")");
        int move=1;
        char aux;
        cant--;
        t[auxx][auxy]='X';
        //Try up
        while (cant!=0 && auxy-move>=1 && move <= cantHelper && t[auxx][auxy-move] != 'X' && t[auxx][auxy-move] != 'f'){
            if (color_map[auxx][auxy-move]!=0) {
                aux=game.disparo(auxx,auxy-move);
                if(aux != tipo){
                    switch (aux){
                        case 'A':
                            try{
                                destroyByChar(auxx,auxy-move, 'A');
                                move++;
                                break;
                            }catch (Throwable t){
                                System.out.println(t);
                            }
                        case 'D':   destroyByChar(auxx,auxy-move, 'D');
                            move++;
                            break;
                        case 'C':   destroyByChar(auxx,auxy-move, 'C');
                            move++;
                            break;
                        case 'B':   destroyByChar(auxx,auxy-move, 'B');
                            move++;
                            break;
                        case 'S': destroyByChar(auxx,auxy-move, 'S');
                            move++;
                            break;
                        case '0':
                            t[auxx][auxy-move]='f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                }else{
                    // System.out.println("\t tipo: "+tipo+", destroy en ["+auxx+"]["+(auxy-move)+"]");
                    t[auxx][auxy-move]='X';
                    move++;
                    cant--;
                }
                /*if (aux=='0'){
                    t[auxx][auxy-move]='f';
                    move++;
                    break;
                }*/
            }else{
                break;
            }

        }
        move=1;
        //Try down
        while (cant!=0 && auxy+move<=11 && move <= cantHelper && t[auxx][auxy+move] != 'X' && t[auxx][auxy+move] != 'f'){
            if (color_map[auxx][auxy+move]!=0) {
                aux=game.disparo(auxx,auxy+move);
                if(aux != tipo){
                    switch (aux){
                        case 'A':   destroyByChar(auxx,auxy+move, 'A');
                            move++;
                            break;
                        case 'D':   destroyByChar(auxx,auxy+move, 'D');
                            move++;
                            break;
                        case 'C':   destroyByChar(auxx,auxy+move, 'C');
                            move++;
                            break;
                        case 'B':   destroyByChar(auxx,auxy+move, 'B');
                            move++;
                            break;
                        case 'S':   destroyByChar(auxx,auxy+move, 'S');
                            move++;
                            break;
                        case '0':
                            t[auxx][auxy+move]='f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                }else{
                    // System.out.println("\t tipo: "+tipo+", destroy en ["+auxx+"]["+(auxy+move)+"]");
                    t[auxx][auxy+move]='X';
                    move++;
                    cant--;
                }
                /*if (aux=='0'){
                    t[auxx][auxy+move]='f';
                    move++;
                    break;
                }*/
            }else{
                break;
            }
        }
        move=1;
        //Try left
        while (cant!=0 && auxx-move>=1 && move <= cantHelper && t[auxx-move][auxy] != 'X' && t[auxx-move][auxy] != 'f'){
            if (color_map[auxx-move][auxy]!=0) {
                aux=game.disparo(auxx-move,auxy);
                if(aux != tipo){
                    switch (aux){
                        case 'A':   destroyByChar(auxx-move,auxy, 'A');
                            move++;
                            break;
                        case 'D':   destroyByChar(auxx-move,auxy, 'D');
                            move++;
                            break;
                        case 'C':   destroyByChar(auxx-move,auxy, 'C');
                            move++;
                            break;
                        case 'B':   destroyByChar(auxx-move,auxy, 'B');
                            move++;
                            break;
                        case 'S':   destroyByChar(auxx-move,auxy, 'S');
                            move++;
                            break;
                        case '0':
                            t[auxx-move][auxy]='f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                }else{
                    // System.out.println("\t tipo: "+tipo+", destroy en ["+(auxx - move)+"]["+auxy+"]");
                    t[auxx-move][auxy] = 'X';
                    move++;
                    cant--;
                }

                /*if (aux=='0'){
                    t[auxx-move][auxy]='f';
                    move++;
                    break;
                }*/
            }else{
                break;
            }
        }
        move=1;
        //Try Right
        while (cant!=0 && auxx+move<=11 && move <= cantHelper && t[auxx + move][auxy] != 'X' && t[auxx+move][auxy] != 'f'){
            if (color_map[auxx+move][auxy]!=0) {
                aux=game.disparo(auxx+move,auxy);
                if(aux != tipo){
                    switch (aux){
                        case 'A':   destroyByChar(auxx+move,auxy, 'A');
                            move++;
                            break;
                        case 'D':   destroyByChar(auxx+move,auxy, 'D');
                            move++;
                            break;
                        case 'C':   destroyByChar(auxx+move,auxy, 'C');
                            move++;
                            break;
                        case 'B':   destroyByChar(auxx+move,auxy, 'B');
                            move++;
                            break;
                        case 'S':   destroyByChar(auxx+move,auxy, 'S');
                            move++;
                            break;
                        case '0':
                            t[auxx+move][auxy]='f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                }else{
                    // System.out.println("\t tipo: "+tipo+", destroy en ["+(auxx + move)+"]["+auxy+"]");
                    t[auxx+move][auxy]='X';
                    move++;
                    cant--;
                }
                /*if (aux=='0'){
                    t[auxx+move][auxy]='f';
                    move++;
                    break;
                }*/
            }else{
                break;
            }
        }
    }

    public static int[][] goWhite(int[][] color_map){
         for(int i=1;i<12;i++)
             for(int j=1;j<12;j++)
                color_map[i][j]=0;
        return color_map;
    }

    public int[][] mapper(int[][] color_map) {
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

     public boolean FakeubicarNave(int l, char tipo){
        try{
            int x = 1+generator.nextInt(t.length-2);
            int y = 1+generator.nextInt(t.length-2);
        //System.out.println(x + "=x ;  y=" + y+ " ; l= "+l);
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
         //if(x+l>=t.length||y+l>=t.length) return false;
         /*
         if(dir==0 && t[x-(l)][y]!='0') return false;
         if(dir==1 && t[x+(l)][y]!='0') return false;
         if(dir==2 && t[x][y-(l)]!='0') return false;
         if(dir==3 && t[x][y+(l)]!='0') return false;
         */
         if(dir==0 && t[x-(l)][y]!='0') return false;
         if(dir==1 && t[x+(l)][y]!='0') return false;
         if(dir==2 && t[x][y-(l)]!='0') return false;
         if(dir==3 && t[x][y+(l)]!='0') return false;
         for(int i=0;i<l;i++){
//             if(dir==0) t[x+i][y]=tipo;
//             if(dir==1) t[x][y+i]=tipo;
             if(dir==0) t[x-i][y]=tipo;
             if(dir==1) t[x+i][y]=tipo;
             if(dir==2) t[x][y-i]=tipo;
             if(dir==3) t[x][y+i]=tipo;

         }
         return true;
        }
        catch (Exception e){
            System.out.println("Se cayó en ubicar naves: "+e);
           // System.out.println("error al crear tablero fantasma");
            return true;
        }
     }

    public void resetTable() {
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 11; j++) {
                if(t[i][j]!='X' && t[i][j]!='f' ){
                   t[i][j] = '0';
                }
            }
        }
    }
    public test(int n){
        if(n<10) n = 10;
        t = new char[n+2][n+2];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(t[i][j] != 'X' && t[i][j] != 'f'){
                    t[i][j]= '0';
                }
            }
        }

        while (!FakeubicarNave(5, 'A')) ;
        while (!FakeubicarNave(4, 'B')) ;
        while (!FakeubicarNave(3, 'C')) ;
        while (!FakeubicarNave(3, 'S')) ;
        while (!FakeubicarNave(2, 'D')) ;
    }

public static void main(String[] args) {
    char aux;
    int n=10;
    int suma=0;
    // Creacion de tablero fantasma
    //t = new char[n+2][n+2];
    // Creacion de mapa de calor
    color_map=new int[12][12];
    for(int juegos=1; juegos<=100;juegos++){
        System.out.println("juego n° "+juegos);
        // Tablero del juego
        game = new Tablero(10);

        // Inicializa tablero fantasma
        /*for(int i=1;i<=n+1;i++)
            for(int j=1;j<=n+1;j++)
                t[i][j]= '0';*/
        while (game.ganar()==0) {
            color_map = goWhite(color_map);
            for (int i = 0; i < 100; i += 1) {
                fantasma = new test(10);
                /*
                while (!fantasma.FakeubicarNave(5, 'A')) ;
                while (!fantasma.FakeubicarNave(4, 'B')) ;
                while (!fantasma.FakeubicarNave(3, 'C')) ;
                while (!fantasma.FakeubicarNave(3, 'S')) ;
                while (!fantasma.FakeubicarNave(2, 'D')) ;
                */
                color_map = fantasma.mapper(color_map);
                // fantasma.resetTable();
            }
            int max = color_map[1][1];
            int auxx = 0;
            int auxy = 0;
            for (int j = 1; j < 12; j++) {
                for (int k = 1; k < 12; k++) {
                    if (max < color_map[j][k]) {
                        max = color_map[j][k];
                        auxx = j;
                        auxy = k;
                    }
                }
            }


            if(fantasma.t[auxx][auxy] != 'X' && fantasma.t[auxx][auxy] != 'f' && game.t[auxx][auxy] != 'X'){
                fantasma.destroy(auxx,auxy);
            }



            // color_map[auxx][auxy]=0;
            // System.out.println("t["+auxx+"]["+auxy+"] = "+game.t[auxx][auxy]);

            //System.out.println("resultado tiro "+aux+  " A :"+ cant_A + " B: "+ cant_B+" C: " + cant_C +" s: "+ cant_S + " D: " + cant_D);
            //System.out.println("estado actual del mapa");
            /*for(int i=1;i<t.length-1;i++){
                for(int j=1;j<t.length-1;j++)
                    System.out.print(game.t[i][j] + "("+color_map[i][j]+") ");
                System.out.println("");
            }*/
        }
        suma+=game.ganar();
        System.out.println("\ttotal: "+game.ganar()+"\tpromedio momentaneo: "+(suma/juegos));
    }
    System.out.println("promedio es: "+ suma/100);
}

}
