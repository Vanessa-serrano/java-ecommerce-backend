package service;
import java.util.List;
import java.util.Optional;
import model.Producto;

public interface ProductoService {
    Producto save(Producto producto);
    Optional<Producto> get(Integer id);
    void update(Producto producto);
    void delete(Integer id);
    List<Producto> findAll();
}

