package biblioteca;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private Map<String,Libro> libros=new HashMap<>();
    private Map<Integer,Usuario> usuarios=new HashMap<>();
    private List<Prestamo> prestamos=new ArrayList<>();

    public void agregarLibro(Libro l){ libros.put(l.getIsbn(),l); }
    public void registrarUsuario(Usuario u){ usuarios.put(u.getId(),u); }

    public Prestamo realizarPrestamo(String isbn,int idU) throws Exception{
        Libro l=libros.get(isbn); Usuario u=usuarios.get(idU);
        if(l==null) throw new IllegalArgumentException("Libro no existe");
        if(u==null) throw new IllegalArgumentException("Usuario no existe");
        if(!u.puedePedirPrestado()) throw new UsuarioSinCupoException("Sin cupo");
        l.prestar();
        Prestamo p=new Prestamo(l,u);
        u.agregarPrestamo(p); prestamos.add(p);
        return p;
    }

    public void devolverLibro(Prestamo p){
        p.devolver(); p.getLibro().devolver();
        var multa=p.calcularMulta();
        if(multa.compareTo(BigDecimal.ZERO)>0) p.getUsuario().agregarMulta(multa);
        p.getUsuario().cerrarPrestamo(p);
    }

    public List<Libro> topLibros(){ return libros.values().stream()
            .sorted((a,b)->b.getVecesPrestado()-a.getVecesPrestado()).limit(5).toList(); }

    public List<Usuario> usuariosConMultas(){
        return usuarios.values().stream().filter(u->u.getMultas().compareTo(BigDecimal.ZERO)>0).toList();
    }

    public Collection<Libro> getLibros(){ return libros.values(); }
}