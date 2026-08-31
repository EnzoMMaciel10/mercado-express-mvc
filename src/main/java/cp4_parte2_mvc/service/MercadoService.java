package cp4_parte2_mvc.service;

import cp4_parte2_mvc.model.Mercado;
import cp4_parte2_mvc.repository.MercadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {

    private final MercadoRepository mercadoRepository;

    public MercadoService(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    public List<Mercado> listarTodos() {
        return mercadoRepository.findAll();
    }

    public List<Mercado> buscarPorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            return listarTodos();
        }

        return mercadoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Mercado buscarPorId(Long id) {
        return mercadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    public Mercado salvar(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public void excluir(Long id) {
        mercadoRepository.deleteById(id);
    }
}