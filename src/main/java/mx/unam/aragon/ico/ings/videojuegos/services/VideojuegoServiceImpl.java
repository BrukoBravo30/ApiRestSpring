package mx.unam.aragon.ico.ings.videojuegos.services;

import mx.unam.aragon.ico.ings.videojuegos.entities.Videojuego;
import mx.unam.aragon.ico.ings.videojuegos.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Override
    public Videojuego crear(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public Iterable<Videojuego> listarTodos() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Optional<Videojuego> buscarPorID(Integer id) {
        return videojuegoRepository.findById(id);
    }

    @Override
    public Videojuego actualizar(Integer id, Videojuego videojuego) {
        Optional<Videojuego> videojuegoActual = videojuegoRepository.findById(id);
        if (videojuegoActual.isPresent()) {
            Videojuego tmp = videojuegoActual.get();
            tmp.setTitulo(videojuego.getTitulo());
            tmp.setGenero(videojuego.getGenero());
            tmp.setPlataforma(videojuego.getPlataforma());
            tmp.setImagen(videojuego.getImagen());
            tmp.setPrecio(videojuego.getPrecio());
            return videojuegoRepository.save(tmp);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        videojuegoRepository.deleteById(id);
    }
}
