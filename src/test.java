import java.io.Console;
import java.util.Scanner;
public class test {
    static java.util.Random generator = new java.util.Random();
    public char[][] t;
    static boolean A = true;
    static boolean B = true;
    static boolean C = true;
    static boolean S = true;
    static boolean D = true;
    static int[][] color_map;
    static Tablero[] game;
    static test[] fantasma;

    public void destroy(int auxx, int auxy, int games) {
        if (game[games-1].t[auxx][auxy] != 'X' && t[auxx][auxy] != 'X' && t[auxx][auxy] != 'f') {
            char aux = game[games-1].disparo(auxx, auxy);

            if (aux == 'A') {
                destroyByChar(auxx, auxy, 'A', games);
            } else if (aux == 'B') {
                destroyByChar(auxx, auxy, 'B', games);
            } else if (aux == 'C') {
                destroyByChar(auxx, auxy, 'C', games);
            } else if (aux == 'S') {
                destroyByChar(auxx, auxy, 'S',games);
            } else if (aux == 'D') {
                destroyByChar(auxx, auxy, 'D',games);
            } else if (aux == '0') {
                t[auxx][auxy] = 'f';
            }
        }
    }

    private void destroyByChar(int auxx, int auxy, char tipo, int games) {
        int cant;
        if (tipo == 'A') {
            cant = 5;
            A=false;
        } else if (tipo == 'B') {
            cant = 4;
            B=false;
        } else if (tipo == 'C') {
            cant = 3;
            C=false;
        } else if (tipo == 'S') {
            cant = 3;
            S=false;
        } else if (tipo == 'D') {
            cant = 2;
            D=false;
        } else {
            System.out.println("hermano por que entraste aca?");
            cant = 1;
        }
        int cantHelper = cant;
        int move = 1;
        char aux;
        cant--;
        t[auxx][auxy] = 'X';
        while (cant != 0 && auxy - move >= 1 && move <= cantHelper && t[auxx][auxy - move] != 'X' && t[auxx][auxy - move] != 'f') {
            if (color_map[auxx][auxy - move] != 0) {
                aux = game[games-1].disparo(auxx, auxy - move);
                if (aux != tipo) {
                    switch (aux) {
                        case 'A':
                            try {
                                destroyByChar(auxx, auxy - move, 'A',games);
                                move++;
                                break;
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        case 'D':
                            destroyByChar(auxx, auxy - move, 'D',games);
                            move++;
                            break;
                        case 'C':
                            destroyByChar(auxx, auxy - move, 'C',games);
                            move++;
                            break;
                        case 'B':
                            destroyByChar(auxx, auxy - move, 'B',games);
                            move++;
                            break;
                        case 'S':
                            destroyByChar(auxx, auxy - move, 'S',games);
                            move++;
                            break;
                        case '0':
                            t[auxx][auxy - move] = 'f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                } else {
                    t[auxx][auxy - move] = 'X';
                    move++;
                    cant--;
                }
            } else {
                break;
            }

        }
        move = 1;
        while (cant != 0 && auxy + move <= 11 && move <= cantHelper && t[auxx][auxy + move] != 'X' && t[auxx][auxy + move] != 'f') {
            if (color_map[auxx][auxy + move] != 0) {
                aux = game[games-1].disparo(auxx, auxy + move);
                if (aux != tipo) {
                    switch (aux) {
                        case 'A':
                            destroyByChar(auxx, auxy + move, 'A',games);
                            move++;
                            break;
                        case 'D':
                            destroyByChar(auxx, auxy + move, 'D',games);
                            move++;
                            break;
                        case 'C':
                            destroyByChar(auxx, auxy + move, 'C',games);
                            move++;
                            break;
                        case 'B':
                            destroyByChar(auxx, auxy + move, 'B',games);
                            move++;
                            break;
                        case 'S':
                            destroyByChar(auxx, auxy + move, 'S',games);
                            move++;
                            break;
                        case '0':
                            t[auxx][auxy + move] = 'f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                } else {
                    t[auxx][auxy + move] = 'X';
                    move++;
                    cant--;
                }
            } else {
                break;
            }
        }
        move = 1;
        while (cant != 0 && auxx - move >= 1 && move <= cantHelper && t[auxx - move][auxy] != 'X' && t[auxx - move][auxy] != 'f') {
            if (color_map[auxx - move][auxy] != 0) {
                aux = game[games-1].disparo(auxx - move, auxy);
                if (aux != tipo) {
                    switch (aux) {
                        case 'A':
                            destroyByChar(auxx - move, auxy, 'A',games);
                            move++;
                            break;
                        case 'D':
                            destroyByChar(auxx - move, auxy, 'D',games);
                            move++;
                            break;
                        case 'C':
                            destroyByChar(auxx - move, auxy, 'C',games);
                            move++;
                            break;
                        case 'B':
                            destroyByChar(auxx - move, auxy, 'B',games);
                            move++;
                            break;
                        case 'S':
                            destroyByChar(auxx - move, auxy, 'S',games);
                            move++;
                            break;
                        case '0':
                            t[auxx - move][auxy] = 'f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                } else {
                    t[auxx - move][auxy] = 'X';
                    move++;
                    cant--;
                }

            } else {
                break;
            }
        }
        move = 1;
        while (cant != 0 && auxx + move <= 11 && move <= cantHelper && t[auxx + move][auxy] != 'X' && t[auxx + move][auxy] != 'f') {
            if (color_map[auxx + move][auxy] != 0) {
                aux = game[games-1].disparo(auxx + move, auxy);
                if (aux != tipo) {
                    switch (aux) {
                        case 'A':
                            destroyByChar(auxx + move, auxy, 'A',games);
                            move++;
                            break;
                        case 'D':
                            destroyByChar(auxx + move, auxy, 'D',games);
                            move++;
                            break;
                        case 'C':
                            destroyByChar(auxx + move, auxy, 'C',games);
                            move++;
                            break;
                        case 'B':
                            destroyByChar(auxx + move, auxy, 'B',games);
                            move++;
                            break;
                        case 'S':
                            destroyByChar(auxx + move, auxy, 'S',games);
                            move++;
                            break;
                        case '0':
                            t[auxx + move][auxy] = 'f';
                            move++;
                            break;
                        case 'X':
                            move++;
                            break;
                    }
                } else {
                    t[auxx + move][auxy] = 'X';
                    move++;
                    cant--;
                }
                /*if (aux=='0'){
                    t[auxx+move][auxy]='f';
                    move++;
                    break;
                }*/
            } else {
                break;
            }
        }
    }

    public static int[][] goWhite(int[][] color_map) {
        for (int i = 1; i < 12; i++)
            for (int j = 1; j < 12; j++)
                color_map[i][j] = 0;
        return color_map;
    }


    public static void todas_posibilidades(int l, char tipo, int games){
        for (int i = 1; i< fantasma[games-1].t.length-1;i++){
            for (int j =1; j< fantasma[games-1].t.length-1;j++){
                boolean flagi=true,flagj=true;
                for (int k=0;k<l;k++){
                    if(j+l-1<fantasma[games-1].t.length-2){
                        if (fantasma[games-1].t[i][j+k]=='X'||fantasma[games-1].t[i][j+k]=='f'){
                            flagj=false;
                        }
                    }
                    else {
                        flagj=false;
                    }
                    if(i+l-1<fantasma[games-1].t.length-2){
                        if (fantasma[games-1].t[i+k][j]=='X'||fantasma[games-1].t[i+k][j]=='f'){
                            flagi=false;
                        }
                    }
                    else {
                        flagi=false;
                    }

                }
                for (int k=0;k<l;k++){
                    if(flagi){
                        color_map[i+k][j]++;
                    }
                    if (flagj){
                        color_map[i][j+k]++;
                    }
                }
            }
        }
    }

    public test(int n) {
        if (n < 10) n = 10;
        t = new char[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                t[i][j] = '0';
            }
        }
    }

    public static void main(String[] args) {
        int n=10;
        int tiros_totales=0;
        game=new Tablero[100000];
        fantasma=new test[100000];
        for(int games=1;games<=100000;games++){
            game[games-1] = new Tablero(10);
            fantasma[games-1]=new test(10);
            color_map=new int[n+2][n+2];
            int auxx= 0;
            int auxy= 0;
            A = true;
            B = true;
            C = true;
            S = true;
            D = true;
            while (game[games-1].ganar()==0) {
                color_map= fantasma[games-1].goWhite(color_map);

                if(fantasma[games-1].A) todas_posibilidades(5,'A',games);
                if(fantasma[games-1].B) todas_posibilidades(4,'B',games);
                if(fantasma[games-1].C) todas_posibilidades(3,'C',games);
                if(fantasma[games-1].S) todas_posibilidades(3,'S',games);
                if(fantasma[games-1].D) todas_posibilidades(2,'D',games);

                int max=-999;
                auxx = 0;
                auxy = 0;
                for (int i=0; i<n+2;i++){
                    for (int j=0; j<n+2;j++){
                        if (color_map[i][j]>max){
                            max=color_map[i][j];
                            auxx=i;
                            auxy=j;
                        }
                    }
                }//
                System.out.println("juego " + games + " disparando a "+ auxx+ " "+ auxy);
                fantasma[games-1].destroy(auxx,auxy,games);
            }
            tiros_totales+=game[games-1].ganar();
        }
        System.out.println("promedio tiros= " + tiros_totales/100000);
    }

}