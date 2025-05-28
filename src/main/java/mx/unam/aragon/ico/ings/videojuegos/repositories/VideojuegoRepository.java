package mx.unam.aragon.ico.ings.videojuegos.repositories;

import mx.unam.aragon.ico.ings.videojuegos.entities.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    //esta seccion es para los test, pero la fase de test termino
}
