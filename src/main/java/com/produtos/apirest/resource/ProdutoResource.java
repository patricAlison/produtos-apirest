package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
