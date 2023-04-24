package com.ada.emprestimo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private long timestamp;

}
