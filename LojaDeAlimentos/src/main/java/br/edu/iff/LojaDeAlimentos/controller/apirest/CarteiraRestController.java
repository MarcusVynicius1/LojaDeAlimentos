package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.service.CarteiraService;

@RestController
@RequestMapping("/api/v1/carteira")
public class CarteiraRestController {

    @Autowired
    private CarteiraService carteiraService;

    @PostMapping
    public ResponseEntity<String> addCarteira(@RequestBody Carteira carteira) {
        Carteira novaCarteira = carteiraService.addCarteira(carteira);
        return ResponseEntity.status(HttpStatus.CREATED).body("Carteira adicionada -> ID: " + novaCarteira.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carteira> getCarteira(@PathVariable Long id) {
        Carteira carteira = carteiraService.getCarteiraPorId(id);
        if (carteira != null) {
            return ResponseEntity.ok(carteira);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarCarteira(@PathVariable Long id, @RequestBody Carteira carteira) {
        Carteira carteiraExistente = carteiraService.getCarteiraPorId(id);
        if (carteiraExistente != null) {
            carteiraExistente.setSaldoDisponivel(carteira.getSaldoDisponivel());
            carteiraService.addCarteira(carteiraExistente);
            return ResponseEntity.ok("Carteira editada.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarteira(@PathVariable Long id) {
        carteiraService.removerCarteira(id);
        return ResponseEntity.ok("Carteira excluída.");
    }
    
    @GetMapping
    public ResponseEntity<List<Carteira>> listarCarteiras() {
        List<Carteira> carteiras = carteiraService.getCarteiras();
        if (!carteiras.isEmpty()) {
            return ResponseEntity.ok(carteiras);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
