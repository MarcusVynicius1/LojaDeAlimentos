package br.edu.iff.LojaDeAlimentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.repository.AlimentoRepository;
import br.edu.iff.LojaDeAlimentos.repository.ClienteRepository;
import br.edu.iff.LojaDeAlimentos.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private ClienteRepository clienteRep;

	@Autowired
	private CompraRepository compraRep;
	@Autowired
	private AlimentoRepository alimentoRep;

	public String addCompra(String cpf) {
		Cliente cl = clienteRep.buscarPeloCPF(cpf);
		if (cl == null) {
			return "Cliente não achado";
		} else {
			Compra compra = new Compra(cpf);
			cl.adicionarCompra(compra);
			Compra c = compraRep.save(compra);
			clienteRep.flush();
			return "Registrado no id " + c.getId();
		}
	}

	public String addCompraAPI(Long id, String cpf) {
		Cliente cl = clienteRep.buscarPeloCPF(cpf);
		if (cl == null) {
			return "Cliente não achado";
		} else {
			Compra compra = new Compra(id, cpf);
			cl.adicionarCompra(compra);
			Compra c = compraRep.save(compra);
			clienteRep.flush();
			return "Registrado no id " + c.getId();
		}
	}

	public String atualizarCompra(String idCompra, String cpf) {
		Compra c = compraRep.BuscarPeloId(Long.parseLong(idCompra));
		if (c == null) {
			return "Compra não achada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				if (cpf != null) {
					Cliente cl = clienteRep.buscarPeloCPF(cpf);
					if (cl == null) {
						return "Cliente não achado";
					} else {
						c.setCpfCliente(cpf);
						cl.adicionarCompra(c);
						clienteRep.flush();
					}
				}
				compraRep.flush();
				return "Atualizado no id " + c.getId();
			}
		}
	}

	public String deletarCompra(Long idCompra) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não achada";
		} else {
			Long idCliente = compraRep.BuscarPeloIdCliente(idCompra);
			Cliente cl = clienteRep.BuscarPeloId(idCliente);
			if (cl == null) {
				return "Cliente não achado";
			} else {
				cl.removerCompra(c);
				clienteRep.flush();
			}

			compraRep.delete(c);
			return "Deletado no id " + c.getId();
		}
	}

	public List<Compra> listarCompras() {
		return compraRep.findAll();
	}

	public String addAlimento(String idCompra, String nome) {
		Compra c = compraRep.BuscarPeloId(Long.parseLong(idCompra));
		if (c == null) {
			return "Compra não encontrada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				Alimento a = alimentoRep.buscarPeloNome(nome);
				if (a == null) {
					return "Alimento não encontrado";
				} else {
					if (compraRep.verificarAlimentoCompra(a.getId(), c.getId()) != 0) {
						return "Alimento já cadastrado";
					} else {
						c.adicionarAlimento(a);
						compraRep.flush();
						return "E-Book adicionado";
					}
				}
			}
		}
	}

	public String removeAlimento(Long idCompra, String nome) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não encontrada";
		} else {
			Alimento a = alimentoRep.buscarPeloNome(nome);
			if (a == null) {
				return "Alimento não encontrado";
			} else {
				if (compraRep.verificarAlimentoCompra(a.getId(), c.getId()) == 0) {
					return "Alimento não consta na compra";
				} else {
					c.removerAlimento(a);
					compraRep.flush();
					return "Alimento removido";
				}
			}
		}
	}

	public String finalizarCompraPeloId(Long idCompra) {
		Compra c = compraRep.BuscarPeloId(idCompra);
		if (c == null) {
			return "Compra não encontrada";
		} else {
			if (c.isFinalizado()) {
				return "Compra já finalizada";
			} else {
				if (c.getQtdAlimentos() == 0) {
					return "A compra precisa ter no mínimo 1 produto.";
				} else {
					Cliente cl = clienteRep.BuscarPeloIdCompra(c.getId());
					if (cl.verSaldo() < c.getPrecoFinal()) {
						return "Saldo do cliente não é o suficiente";
					} else {
						cl.removerSaldo(c.getPrecoFinal());
						c.finalizar();
						compraRep.flush();
						clienteRep.flush();
						return "Compra finalizada com sucesso";
					}
				}
			}
		}
	}
	

	public Compra getCompraById(Long id) {
		return compraRep.BuscarPeloId(id);
	}
	
	public List<Alimento> ListarAlimentoPeloIdCompra(Long id){
		return alimentoRep.ListarAlimentoPeloIdCompra(id);
	}
	
	public Cliente getClienteDaCompra(Long idCompra) {
	    Compra compra = getCompraById(idCompra);
	    if (compra != null) {
	        return clienteRep.BuscarPeloIdCompra(compra.getId()); // Substitua pelo método correto que recupera o cliente a partir do ID da compra
	    }
	    return null;
	}

	
}
