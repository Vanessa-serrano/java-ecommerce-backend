package service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service 
public class UploadFileService {
    private final Path folder = Paths.get("images").toAbsolutePath().normalize();

    public String saveImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "default.jpg";
        }

        Files.createDirectories(folder);
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isBlank()) {
            throw new IOException("El archivo seleccionado no tiene un nombre válido.");
        }

        String filename = originalFilename.replace('\\', '/');
        filename = filename.substring(filename.lastIndexOf('/') + 1);
        if (filename.isBlank() || filename.equals(".") || filename.equals("..")) {
            throw new IOException("El archivo seleccionado no tiene un nombre válido.");
        }

        int extensionIndex = filename.lastIndexOf('.');
        String name = extensionIndex > 0 ? filename.substring(0, extensionIndex) : filename;
        String extension = extensionIndex > 0 ? filename.substring(extensionIndex) : "";

        Files.createDirectories(folder);
        for (int suffix = 1; ; suffix++) {
            String savedFilename = suffix == 1 ? filename : name + "-" + suffix + extension;
            Path destination = folder.resolve(savedFilename);
            try (InputStream input = file.getInputStream()) {
                Files.copy(input, destination);
                return savedFilename;
            } catch (FileAlreadyExistsException exception) {
                // Keep existing uploads intact when two files have the same name.
            }
        }
    }

    public void deleteImage(String filename) throws IOException {
        Path image = folder.resolve(filename).normalize();
        if (!image.getParent().equals(folder)) {
            throw new IllegalArgumentException("Ruta de imagen no válida: " + filename);
        }
        Files.deleteIfExists(image);
    }
}
