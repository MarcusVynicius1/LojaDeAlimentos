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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente cli = clienteService.findById(id);

        if (cli == null) {
            return null;
        }

        cli.setNome(cliente.getNome());
        cli.setEmail(cliente.getEmail());
        cli.setPassword(cliente.getPassword());
        cli.setCpf(cliente.getCpf());

        clienteService.addCliente(cli);

        return cli;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deletarClientePor(@PathVariable Long id) {
        Cliente cBusca = clienteService.findById(id);
        if (cBusca == null) {
            return "Cliente não encontrado";
        } else {
            clienteService.deleteCliente(cBusca);
            return "cliente excluído";
        }
    }

    @GetMapping("")
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> buscarClienteId(@PathVariable("id") Long id) {
        try {
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
