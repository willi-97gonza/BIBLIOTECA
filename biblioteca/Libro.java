import java.util.concurrent.atomic.AtomicInteger;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;
    private AtomicInteger vecesPrestado = new AtomicInteger(0);

    public Libro(String isbn, String titulo, String autor, int anio, int ejemplaresTotales) {
        if (isbn == null || !isbn.matches("\\d{13}")) throw new IllegalArgumentException("ISBN inválido");
        if (anio < 1500 || anio > 2025) throw new IllegalArgumentException("Año inválido");
        this.isbn=isbn; this.titulo=titulo; this.autor=autor; this.anio=anio;
        this.ejemplaresTotales=ejemplaresTotales; this.ejemplaresDisponibles=ejemplaresTotales;
    }
    public synchronized void prestar() throws LibroNoDisponibleException {
        if (ejemplaresDisponibles<=0) throw new LibroNoDisponibleException("No disponible");
        ejemplaresDisponibles--; vecesPrestado.incrementAndGet();
    }
    public synchronized void devolver(){ if(ejemplaresDisponibles<ejemplaresTotales) ejemplaresDisponibles++; }
    public boolean estaDisponible(){ return ejemplaresDisponibles>0; }
    public int getVecesPrestado(){ return vecesPrestado.get(); }
    public String getIsbn(){ return isbn; }
    public String getTitulo(){ return titulo; }
}