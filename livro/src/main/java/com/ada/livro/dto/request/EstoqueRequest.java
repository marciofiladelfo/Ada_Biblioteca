package com.ada.livro.dto.request;

import com.ada.livro.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueRequest {

    private Integer quantidade;

    public Livro toModelEstoque() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, Livro.class);
    }
}
