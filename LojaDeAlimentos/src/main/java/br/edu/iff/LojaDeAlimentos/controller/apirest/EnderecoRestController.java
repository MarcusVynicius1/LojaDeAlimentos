package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Endereco;
import br.edu.iff.LojaDeAlimentos.service.EnderecoService;

@RestController
@RequestMapping(path = "/api/v1/endereco")
public class EnderecoRestController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoService.getEndereco();
    }

    @GetMapping("/{id}")
    public Endereco getEnderecoById(@PathVariable Long id) {
        return enderecoService.getEnderecoPorId(id);
    }

    @PostMapping
    public Endereco addEndereco(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.addEndereco(endereco);
        return novoEndereco;
    }

    @PutMapping("/{id}")
    public Endereco updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Endereco enderecoExistente = enderecoService.getEnderecoPorId(id);
        if (enderecoExistente == null) {
            return null;
        }
        enderecoExistente.setRua(endereco.getRua());
        enderecoExistente.setNumero(endereco.getNumero());
        enderecoExistente.setBairro(endereco.getBairro());
        enderecoExistente.setCidade(endereco.getCidade());
        enderecoExistente.setEstado(endereco.getEstado());
        enderecoExistente.setCep(endereco.getCep());
        enderecoService.addEndereco(enderecoExistente);
        return enderecoExistente;
    }

    @DeleteMapping("/{id}")
    public String deleteEndereco(@PathVariable Long id) {
        enderecoService.removerEndereco(id);
        return "Endereco excluído com sucesso.";
    }
}
