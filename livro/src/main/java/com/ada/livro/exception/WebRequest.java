package com.ada.livro.exception;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Component
public class WebRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1186467498211971036L;

    protected String email;
    protected String fullName;
    protected String path;
}
