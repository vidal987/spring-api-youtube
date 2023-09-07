package br.com.example.produto.service.produtoService.impl;

import br.com.example.produto.model.Produto;
import br.com.example.produto.repository.IProdutoRepository;
import br.com.example.produto.service.produtoService.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    IProdutoRepository produtoRepository;

    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listaProduto() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @Override
    public Produto updateProduto(Produto produto, Long produtoId) {
        Produto prodDb = produtoRepository.findById(produtoId).get();

        if (Objects.nonNull(produto.getNome()) && !"".equalsIgnoreCase(produto.getNome())) {
            prodDb.setNome(produto.getNome());
        }

        if (Objects.nonNull(produto.getDescricao()) && !"".equalsIgnoreCase(produto.getDescricao())) {
            prodDb.setDescricao(produto.getDescricao());
        }

        if (Objects.nonNull(produto.getPreco())) {
            prodDb.setPreco(produto.getPreco());
        }

        return produtoRepository.save(prodDb);
    }

    @Override
    public void deletaProdutoPorId(Long departmentId) {
        produtoRepository.deleteById(departmentId);
    }
}
