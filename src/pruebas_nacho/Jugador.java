package pruebas_nacho;




public class Jugador {
    static final int SIZE_TABLERO       = 10;
    static final int CANT_BARCOS        = 5;
    static final char POSICION_VACIA    = '_';
    static final char HIT               = 'X';
    static final char MISS              = 'O';

    static final int PORTAAVIONES_LEN   = 5;
    static final int BUQUE_LEN          = 4;
    static final int SUBMARINO_LEN      = 3;
    static final int CRUCERO_LEN        = 3;
    static final int DESTRUCTOR_LEN     = 2;

    enum barcos {
        PORTAAVIONES,
        BUQUE,
        SUBMARINO,
        CRUCERO,
        DESTRUCTOR
    };


    Jugador(){

    }

}
