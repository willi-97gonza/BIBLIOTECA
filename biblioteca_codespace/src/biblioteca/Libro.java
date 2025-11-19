package biblioteca;
import java.util.concurrent.atomic.AtomicInteger;

public class Libro {
    private String isbn,titulo,autor;
    private int anio,ejemplaresTotales,ejemplaresDisponibles;
    private AtomicInteger vecesPrestado=new AtomicInteger(0);

    public Libro(String isbn,String titulo,String autor,int anio,int total){
        if(isbn==null||!isbn.matches("\\d{13}")) throw new IllegalArgumentException("ISBN inválido");
        if(anio<1500||anio>2025) throw new IllegalArgumentException("Año inválido");
        this.isbn=isbn;this.titulo=titulo;this.autor=autor;this.anio=anio;
        this.ejemplaresTotales=total;this.ejemplaresDisponibles=total;
    }
    public synchronized void prestar() throws LibroNoDisponibleException{
        if(ejemplaresDisponibles<=0) throw new LibroNoDisponibleException("No disponible");
        ejemplaresDisponibles--; vecesPrestado.incrementAndGet();
    }
    public synchronized void devolver(){ if(ejemplaresDisponibles<ejemplaresTotales) ejemplaresDisponibles++; }
    public boolean estaDisponible(){ return ejemplaresDisponibles>0; }
    public int getVecesPrestado(){ return vecesPrestado.get(); }
    public String getIsbn(){ return isbn; }
    public String getTitulo(){ return titulo; }
}