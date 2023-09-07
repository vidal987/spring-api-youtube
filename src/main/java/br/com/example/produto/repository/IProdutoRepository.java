package br.com.example.produto.repository;

import br.com.example.produto.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Long> {

}
