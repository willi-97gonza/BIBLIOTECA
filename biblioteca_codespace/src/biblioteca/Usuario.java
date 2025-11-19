package biblioteca;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    private static AtomicInteger gen=new AtomicInteger(1);
    private int id;
    private String nombre,email;
    private BigDecimal multas=BigDecimal.ZERO;
    private List<Prestamo> prestamosActivos=new ArrayList<>();

    public Usuario(String nombre,String email){
        if(email==null||!email.contains("@")) throw new IllegalArgumentException("Email inválido");
        this.id=gen.getAndIncrement(); this.nombre=nombre; this.email=email;
    }
    public boolean puedePedirPrestado(){ return prestamosActivos.size()<3 && multas.compareTo(new BigDecimal("5000"))<=0; }
    public void agregarPrestamo(Prestamo p){ prestamosActivos.add(p); }
    public void cerrarPrestamo(Prestamo p){ prestamosActivos.remove(p); }
    public void agregarMulta(BigDecimal v){ multas=multas.add(v); }
    public int getId(){ return id; }
    public String getNombre(){ return nombre; }
    public BigDecimal getMultas(){ return multas; }
    public List<Prestamo> getPrestamosActivos(){ return prestamosActivos; }
}