package br.com.ada.progwebsb.repository;

import br.com.ada.progwebsb.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query(value = "SELECT * FROM tb_pessoa WHERE idade>=18",nativeQuery = true)
    List<Pessoa> findPessoasAdultas();

    @Query(value = "SELECT * FROM tb_pessoa WHERE idade<18",nativeQuery = true)
    List<Pessoa> findPessoasMenores();
}