package cp4_parte2_mvc.repository;

import cp4_parte2_mvc.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {

    List<Mercado> findByNomeContainingIgnoreCase(String nome);
}