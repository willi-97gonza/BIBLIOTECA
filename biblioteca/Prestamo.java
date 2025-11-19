import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;

    public Prestamo(Libro libro, Usuario usuario){
        this.libro=libro; this.usuario=usuario;
        fechaPrestamo=LocalDate.now(); estado=EstadoPrestamo.ACTIVO;
    }
    public BigDecimal calcularMulta(){
        if(fechaDevolucion==null) return BigDecimal.ZERO;
        long dias = ChronoUnit.DAYS.between(fechaPrestamo.plusDays(14), fechaDevolucion);
        if(dias<=0) return BigDecimal.ZERO;
        return new BigDecimal(dias).multiply(new BigDecimal("500"));
    }
    public void devolver(){ fechaDevolucion=LocalDate.now(); estado=EstadoPrestamo.DEVUELTO; }
    public Libro getLibro(){ return libro;}
    public Usuario getUsuario(){ return usuario;}
}