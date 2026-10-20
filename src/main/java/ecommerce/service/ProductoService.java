package ecommerce.service;

import java.util.Optional;
import ecommerce.model.Producto;
public interface ProductoService {
    public Producto save(Producto producto);
    public Optional<Producto> get(Integer integer);
    public void update(Producto producto);
    public void delete(Integer id);
}


