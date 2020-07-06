package pruebas_nacho;

public class Barco {
    private int fila, columna, size, hitSize;
    private boolean vertical, hundido;
    Barco(){
        vertical = false;
        hundido = false;
        size = 0;
        hitSize = size;
    }
    Barco(boolean es_vertical, int tamano){
        hundido = false;
        vertical = es_vertical;
        size = tamano;
        hitSize = size;
    }
    void hit(){
        hitSize--;
        hundido = (hitSize == 0);
    }

    void setUbicacion(int new_fila, int new_columna){
        fila = new_fila;
        columna = new_columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    public int getSize() {
        return size;
    }

    public boolean esta_hundido() {
        return hundido;
    }

    public boolean es_vertical() {
        return vertical;
    }
}
