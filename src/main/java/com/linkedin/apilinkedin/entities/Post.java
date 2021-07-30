package com.linkedin.apilinkedin.entities;

import com.linkedin.apilinkedin.enums.Anexo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Anexo anexo;
    private String textoPost;

    public Post(Anexo anexo, String textoPost) {
        this.anexo = anexo;
        this.textoPost = textoPost;
    }
}
