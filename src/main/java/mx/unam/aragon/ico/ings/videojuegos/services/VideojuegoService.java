package mx.unam.aragon.ico.ings.videojuegos.services;

import mx.unam.aragon.ico.ings.videojuegos.entities.Videojuego;

import java.util.Optional;

public interface VideojuegoService {

    public abstract Videojuego crear(Videojuego videojuego);

    public abstract Iterable<Videojuego> listarTodos();

    public abstract Optional<Videojuego> buscarPorID(Integer id);

    public abstract Videojuego actualizar(Integer id, Videojuego videojuego);

    public abstract void eliminar(Integer id);
}
