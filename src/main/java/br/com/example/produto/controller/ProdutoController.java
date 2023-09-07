package br.com.example.produto.controller;

import br.com.example.produto.model.Produto;
import br.com.example.produto.service.produtoService.impl.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Save operation
    @PostMapping()
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    // Read operation
    @GetMapping()
    public List<Produto> listarProduto() {
        return produtoService.listaProduto();
    }

    // Update operation
    @PutMapping("/{id}")
    public Produto
    updateProduto(@RequestBody Produto produto, @PathVariable("id") Long produtoId) {
        return produtoService.updateProduto(
                produto, produtoId);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteProdutoPorId(@PathVariable("id") Long produtoId){

        produtoService.deletaProdutoPorId(
                produtoId);
        return "Deletado com Sucesso";
    }
}
