package br.com.example.produto.service.produtoService.interfaces;

import br.com.example.produto.model.Produto;

import java.util.List;

public interface IProdutoService {
    // save operation
    Produto salvarProduto(Produto produto);

    // read operation
    List<Produto> listaProduto();

    // update operation
    Produto updateProduto(Produto produto, Long produtoId);

    // Delete
    void deletaProdutoPorId(Long departmentId);
}
