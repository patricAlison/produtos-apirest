package com.produtos.apirest.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/*@GetMapping("/produto/{id}")
	public Optional<Produto> listaProdutoPorId(@PathVariable(value = "id") long id) {
		
		return produtoRepository.findById(id);
		
	}*/
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
		
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	public Produto incluirProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping("/produto")
	public void deleteProduto(@RequestBody Produto produto) {
		
		produtoRepository.delete(produto);
		
	}
	
	/*@DeleteMapping("/produto")
	public Produto deleteProduto(@RequestBody Produto produto) {
		
		return produtoRepository.deletarProduto(produto);
		
	}*/
	
	//serve para atualizar os dados
	@PutMapping("/produto")
	public void putProduto(@RequestBody Produto produto) {
		
		produtoRepository.save(produto);
		
	}
	
}
