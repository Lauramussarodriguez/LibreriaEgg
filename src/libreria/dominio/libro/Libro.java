
package libreria.dominio.libro;


import libreria.dominio.editorial.Editorial;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/*
isbn,tirulo,anio,ajemplares,ejP,ejR,autor,editorial
*/
@Entity
public class Libro {

    @Id
    @GeneratedValue
    private String id;
    
    @Column(unique = true)
    private long isbn;
    
    private String titulo;
    private Integer anio;
    private Integer Ejemplares;
    private Integer EjemplaresPrestados;
    private Integer EjemplaresRestantes;
    private String autor;
    private String editorial;

    public Libro() {
    }

    public Libro(String id, long isbn, String titulo, Integer anio, Integer Ejemplares, 
            Integer EjemplaresPrestados, Integer EjemplaresRestantes, String autor, String editorial) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.Ejemplares = Ejemplares;
        this.EjemplaresPrestados = EjemplaresPrestados;
        this.EjemplaresRestantes = EjemplaresRestantes;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return Ejemplares;
    }

    public void setEjemplares(Integer Ejemplares) {
        this.Ejemplares = Ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return EjemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer EjemplaresPrestados) {
        this.EjemplaresPrestados = EjemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return EjemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer EjemplaresRestantes) {
        this.EjemplaresRestantes = EjemplaresRestantes;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro {" + "id= " + id + ", isbn= " + isbn + ", titulo= " + titulo + ", anio= " + anio + ", Ejemplares =" + Ejemplares + ", EjemplaresPrestados =" + EjemplaresPrestados + ", EjemplaresRestantes= " + EjemplaresRestantes + ", autor= " + autor + ", editorial= " + editorial + '}';
    }
    
         
    
}
