import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private Map<String,Libro> libros=new HashMap<>();
    private Map<Integer,Usuario> usuarios=new HashMap<>();
    private List<Prestamo> prestamos=new ArrayList<>();

    public void agregarLibro(Libro l){ libros.put(l.getIsbn(),l);}
    public void registrarUsuario(Usuario u){ usuarios.put(u.getId(),u);}

    public Prestamo realizarPrestamo(String isbn,int idU) throws Exception{
        Libro l=libros.get(isbn); Usuario u=usuarios.get(idU);
        if(l==null) throw new IllegalArgumentException("Libro no existe");
        if(u==null) throw new IllegalArgumentException("Usuario no existe");
        if(!u.puedePedirPrestado()) throw new UsuarioSinCupoException("Sin cupo");
        l.prestar();
        Prestamo p=new Prestamo(l,u);
        u.agregarPrestamo(p);
        prestamos.add(p);
        return p;
    }
}