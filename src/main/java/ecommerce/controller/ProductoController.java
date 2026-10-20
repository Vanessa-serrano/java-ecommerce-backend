package ecommerce.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import ecommerce.model.Producto;
import ecommerce.model.Usuario;
import ecommerce.service.ProductoService;
@Controller 
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired 
    private ProductoService productoService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }
    
    @GetMapping ("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping ("/save")
    public String save(Producto producto) {
        LOGGER.info("Este es el objeto producto{}",producto);
        Usuario u= new Usuario(1, null, null, null, null, null, null, null);
        producto.setUsuario(u);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping ("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Producto producto = productoService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        model.addAttribute("producto", producto);
        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto",producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto) {
        Producto productoExistente = productoService.get(producto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + producto.getId()));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setPrecio(producto.getPrecio());
        productoService.update(productoExistente);
        return "redirect:/productos";
    }


}
