package mx.unam.aragon.ico.ings.videojuegos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo_videojuego", nullable = false, length = 100)
    @NotBlank(message = "El título no puede estar en blanco")
    @NotNull(message = "El título no puede ser nulo")
    private String titulo;

    @Column(name = "genero_videojuego", nullable = false, length = 50)
    @NotBlank(message = "El género no puede estar en blanco")
    @NotNull(message = "El género no puede ser nulo")
    private String genero;

    @Column(name = "plataforma", nullable = false, length = 50)
    @NotBlank(message = "La plataforma no puede estar en blanco")
    @NotNull(message = "La plataforma no puede ser nula")
    private String plataforma;

    @Column(name = "url_imagen", nullable = true,
            insertable = false,
            columnDefinition = "VARCHAR(250) default 'https://cdn-icons-png.flaticon.com/512/3501/3501811.png'"
    )
    private String imagen;

    @Column(name = "precio_mxn", nullable = true)
    private Float precio;

    public Videojuego() {
    }

    public Videojuego(Integer id, String titulo, String genero, String plataforma, String imagen, Float precio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.imagen = imagen;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Videojuego)) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(genero, that.genero) &&
                Objects.equals(plataforma, that.plataforma) &&
                Objects.equals(imagen, that.imagen) &&
                Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, genero, plataforma, imagen, precio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
