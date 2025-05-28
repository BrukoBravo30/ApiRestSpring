package mx.unam.aragon.ico.ings.videojuegos.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.ings.videojuegos.entities.Videojuego;
import mx.unam.aragon.ico.ings.videojuegos.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public ResponseEntity<Iterable<Videojuego>> getVideojuegos() {
        return ResponseEntity.ok().body(videojuegoService.listarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Videojuego> getVideojuego(@PathVariable Integer id) {
        return ResponseEntity.ok(videojuegoService.buscarPorID(id).orElse(null));
    }

    @PostMapping
    public Videojuego createVideojuego(@Valid @RequestBody Videojuego videojuego) {
        return videojuegoService.crear(videojuego);
    }

    @PutMapping("{id}")
    public ResponseEntity<Videojuego> updateVideojuego(@PathVariable Integer id, @RequestBody Videojuego videojuego) {
        return ResponseEntity.ok(videojuegoService.actualizar(id, videojuego));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Videojuego> patchVideojuego(@PathVariable Integer id, @RequestBody Videojuego videojuego) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorID(id);

        if (tmp.isPresent()) {
            Videojuego actual = tmp.get();

            if (videojuego.getTitulo() != null) actual.setTitulo(videojuego.getTitulo());
            if (videojuego.getGenero() != null) actual.setGenero(videojuego.getGenero());
            if (videojuego.getPrecio() != null) actual.setPrecio(videojuego.getPrecio());
            if (videojuego.getPlataforma() != null) actual.setPlataforma(videojuego.getPlataforma());
            if (videojuego.getImagen() != null) actual.setImagen(videojuego.getImagen());

            return ResponseEntity.ok(videojuegoService.actualizar(id, actual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public void deleteVideojuego(@PathVariable Integer id) {
        videojuegoService.eliminar(id);
    }
}
