package com.example.gestioneDispositivi.controllers;

import com.example.gestioneDispositivi.entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.gestioneDispositivi.services.DipendenteService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    private DipendenteService dipendenteService;

    private static final String UPLOAD_DIR = "pictures";

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.save(dipendente);
    }

    @GetMapping
    public List<Dipendente> getAllDipendenti(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        return dipendenteService.getDipendenti(page, size, sort).getContent();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable Long id) {
        return dipendenteService.findById(id);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        return dipendenteService.findByIdAndUpdate(id, dipendente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.findByIdAndDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/uploadProfileImage")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File non caricato");
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            String directory = System.getProperty("user.dir");
            Path uploadPath = Paths.get(directory, UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, file.getBytes());

            Dipendente dipendente = dipendenteService.findById(id);
            String imagePath = UPLOAD_DIR + "/" + fileName;
            dipendente.setPathImmagine(imagePath);
            dipendenteService.save(dipendente);

            return ResponseEntity.ok("File caricato");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File non caricato");
        }
    }
}
