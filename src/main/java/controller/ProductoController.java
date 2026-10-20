package controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.Producto;
import model.Usuario;
import service.ProductoService;
import service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private static final String DEFAULT_IMAGE = "default.jpg";

    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    private final ProductoService productoService;
    private final UploadFileService uploadFileService;

    public ProductoController(ProductoService productoService, UploadFileService uploadFileService) {
        this.productoService = productoService;
        this.uploadFileService = uploadFileService;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute Producto producto,
            @RequestParam(value = "img", required = false) MultipartFile image) throws IOException {
        producto.setUsuario(new Usuario(1, null, null, null, null, null, null, null));
        producto.setImagen(uploadFileService.saveImage(image));
        logger.info("Creando producto: {}", producto);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = productoService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute Producto submittedProduct,
            @RequestParam(value = "img", required = false) MultipartFile image) throws IOException {
        Producto existingProduct = productoService.get(submittedProduct.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Producto no encontrado: " + submittedProduct.getId()));

        existingProduct.setNombre(submittedProduct.getNombre());
        existingProduct.setDescripcion(submittedProduct.getDescripcion());
        existingProduct.setCantidad(submittedProduct.getCantidad());
        existingProduct.setPrecio(submittedProduct.getPrecio());

        String previousImage = existingProduct.getImagen();
        if (image != null && !image.isEmpty()) {
            existingProduct.setImagen(uploadFileService.saveImage(image));
        }

        productoService.update(existingProduct);

        if (image != null && !image.isEmpty()
                && previousImage != null
                && !DEFAULT_IMAGE.equals(previousImage)
                && !previousImage.equals(existingProduct.getImagen())) {
            uploadFileService.deleteImage(previousImage);
        }
        return "redirect:/productos";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) throws IOException {
        Producto product = productoService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));

        productoService.delete(id);
        if (product.getImagen() != null && !DEFAULT_IMAGE.equals(product.getImagen())) {
            uploadFileService.deleteImage(product.getImagen());
        }

        return "redirect:/productos";
    }
}
