package com.ada.livro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.livro.dtos.EstoqueDto;
import com.ada.livro.model.Livro;
import com.ada.livro.repositories.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
	@Autowired
	LivroRepository livroRepository;

	@Override
	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}

	@Override
	public List<Livro> getAll(){
		return livroRepository.findAll();
	}

	@Override
	public Livro getOne(int id) {
		return livroRepository.findById(id).orElse(new Livro());
	}

	@Override
	public Livro update(int id, Livro livro) {
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent()){
			Livro livroBD = optional.get();

			return livroRepository.save(livroBD);
		}
		return new Livro();
	}

	@Override
	public EstoqueDto updateEstoque(int id, int tipoTransacao, Livro livro) {

		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent()){
			Livro livroBD = optional.get();
			if(tipoTransacao == 1) {
				livroBD.setQuantidade(livroBD.getQuantidade() + livro.getQuantidade());
			}
			else if(tipoTransacao == 2){
				livroBD.setQuantidade(livroBD.getQuantidade() - livro.getQuantidade());
			}
			return livroRepository.save(livroBD).toDTOEstoque();
		}
		return new Livro().toDTOEstoque();
	}

	@Override
	public void delete(int id) {
		livroRepository.deleteById(id);
	}
}
