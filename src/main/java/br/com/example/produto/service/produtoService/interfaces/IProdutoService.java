package br.com.example.produto.service.produtoService.interfaces;

import br.com.example.produto.model.Produto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProdutoService {

    // save operation
    Produto salvarProduto(Produto produto);

    // read operation
    List<Produto> listarProduto();

    // update operation
    Produto updateProduto(Produto produto, Long produtoId);

    // Delete
    void deletaProdutoPorId(Long produtoId);

    //Salvar imagem
    String salvarImagemProduto(Long id, MultipartFile file);
}
