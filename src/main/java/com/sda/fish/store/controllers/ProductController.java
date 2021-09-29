package com.sda.fish.store.controllers;


import com.sda.fish.store.entities.ProductEntity;
import com.sda.fish.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class ProductController {

    public ProductController() {
        System.out.println(getClass().getSimpleName() + " loaded");
    }

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/frontpage")
    public ModelAndView getFrontPage() {
        ModelAndView modelAndView = new ModelAndView("frontpage");
        modelAndView.addObject("productList", productRepository.findAll()); //adauga lista de produse pe Get
        return modelAndView;
    }

    @GetMapping("/product/{id}")
    public ModelAndView productView(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("productView"); //productView de aici face legatura cu HTML
        modelAndView.addObject("product", productRepository.getById(id));
        return modelAndView;
    }

    @PostMapping(value="/product/save", consumes = {"multipart/form-data"})
    public ModelAndView productSave(@ModelAttribute("product") ProductEntity productEntity, @RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
        String path1 = "target/classes/static/imagines";
        String path2 = "src/main/resources/static/imagines";
        String filename = file.getOriginalFilename();
        saveFile(path1, filename, file);
        saveFile(path2, filename, file);
        productEntity.setImageUrl("/imagines/" + filename);
        productRepository.save(productEntity);
        return modelAndView;
    }

    public void saveFile(String path, String fileName, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(path);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

}

