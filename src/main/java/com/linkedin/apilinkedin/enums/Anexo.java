package com.linkedin.apilinkedin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Anexo {
    IMAGEM("Imagem"),
    VIDEO("Video"),
    DOCUMENTO("Documento");

    private final String descricao;
}
