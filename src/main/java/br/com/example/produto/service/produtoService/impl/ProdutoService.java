package br.com.example.produto.service.produtoService.impl;

import br.com.example.produto.model.Produto;
import br.com.example.produto.repository.IProdutoRepository;
import br.com.example.produto.service.produtoService.interfaces.IProdutoService;
import br.com.example.produto.service.s3Service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private S3Service s3Service;

    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public String salvarImagemProduto(Long id, MultipartFile file) {
        Produto produto = produtoRepository.findById(id).get();

        String url = s3Service.uploadImage(file);

        produto.setUrlFoto(url);

        produtoRepository.save(produto);

        return url;
    }

    @Override
    public List<Produto> listarProduto() {
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
    public void deletaProdutoPorId(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }
}

