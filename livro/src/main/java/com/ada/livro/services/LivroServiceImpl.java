package com.ada.livro.services;

import com.ada.livro.dto.response.EstoqueResponse;
import com.ada.livro.exception.NotFoundException;
import com.ada.livro.model.Livro;
import com.ada.livro.repositories.LivroRepository;
import com.ada.livro.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ada.livro.util.Status.DEVOLVIDO;
import static com.ada.livro.util.Status.EMPRESTADO;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> getById(int id) {
        verifyLivroExist(id);
        return livroRepository.findById(id);
    }

    @Override
    public Livro update(int id, Livro livro) {
        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            Livro livroBD = optional.get();
            return livroRepository.save(livroBD);
        }
        return new Livro();
    }

    @Override
    public EstoqueResponse updateEstoque(int id, Status tipoTransacao, Livro livro) {

        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            Livro livroBD = optional.get();
            if (tipoTransacao == DEVOLVIDO) {
                livroBD.setQuantidade(livroBD.getQuantidade() + livro.getQuantidade());
            } else if (tipoTransacao == EMPRESTADO) {
                livroBD.setQuantidade(livroBD.getQuantidade() - livro.getQuantidade());
            }
            return livroRepository.save(livroBD).toDTOEstoque();
        }
        return new Livro().toDTOEstoque();
    }

    @Override
    public void delete(int id) {
        verifyLivroExist(id);
        livroRepository.deleteById(id);
    }

    private void verifyLivroExist(Integer id) {
        if (livroRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Livro não encontrado ID: " + id);
        }
    }
}
