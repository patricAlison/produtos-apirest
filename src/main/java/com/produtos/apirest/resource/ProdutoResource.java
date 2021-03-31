package com.produtos.apirest.resource;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController		//dizendo que aqui é o controll
@RequestMapping(value="/api")	//uri
@Api(value="API REST Produtos")		//é o nome que vai aprecer assim que executar
@CrossOrigin(origins = "*")	//para dar  aturização a api na produção, (origins = "*") um coriga pra todos
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	@ApiOperation(value="Retorna uma lista de produtos")	//serve pra explicar oq essa API faz
	public List<Produto> listaProdutos(){
		
		return produtoRepository.findAll();
		
	}
	
	/*@GetMapping("/produto/{id}")
	public Optional<Produto> listaProdutoPorId(@PathVariable(value = "id") long id) {
		
		return produtoRepository.findById(id);
		
	}*/
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna uma lista de produtos pela Id")	//serve pra explicar oq essa API faz
	public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
		
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Inseri um novo produto")	//serve pra explicar oq essa API faz
	public Produto incluirProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto do banco")	//serve pra explicar oq essa API faz
	public void deleteProduto(@RequestBody Produto produto) {
		
		produtoRepository.delete(produto);
		
	}
	
	/*@DeleteMapping("/produto")
	public Produto deleteProduto(@RequestBody Produto produto) {
		
		return produtoRepository.deletarProduto(produto);
		
	}*/
	
	//serve para atualizar os dados
	/*@PutMapping("/produto")
	public void putProduto(@RequestBody Produto produto) {
		
		produtoRepository.save(produto);
		
	}*/
	@PutMapping("/produto")
	@ApiOperation(value="Faz uma atualizacao no produto")	//serve pra explicar oq essa API faz
	public Produto putProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
}
