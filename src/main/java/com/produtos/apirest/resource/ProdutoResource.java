package com.produtos.apirest.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController		//dizendo que aqui é o controll
@RequestMapping(value="/api")	//uri
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	public List<Produto> listaProdutos(){
		
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produto/{id}")
	public Optional<Produto> listaProdutoPorId(@PathVariable(value = "id") long id) {
		
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	public Produto incluirProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
}
