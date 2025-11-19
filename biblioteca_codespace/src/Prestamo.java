package biblioteca;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro; private Usuario usuario;
    private LocalDate fechaPrestamo=LocalDate.now();
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado=EstadoPrestamo.ACTIVO;

    public Prestamo(Libro l,Usuario u){ this.libro=l; this.usuario=u; }
    public BigDecimal calcularMulta(){
        if(fechaDevolucion==null) return BigDecimal.ZERO;
        long dias= ChronoUnit.DAYS.between(fechaPrestamo.plusDays(14),fechaDevolucion);
        if(dias<=0) return BigDecimal.ZERO;
        return new BigDecimal(dias).multiply(new BigDecimal("500"));
    }
    public void devolver(){ fechaDevolucion=LocalDate.now(); estado=EstadoPrestamo.DEVUELTO; }
    public Libro getLibro(){ return libro; }
    public Usuario getUsuario(){ return usuario; }
}