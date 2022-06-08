package br.com.treinamento.gft.treinamentogft.entity

import br.com.treinamento.gft.treinamentogft.enums.BookStatus
import javax.persistence.*

@Entity
@Table(name="TB_LIVRO")
data class Livro(

    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column(name = "ds_nome")
    var name : String,

    @Column(name = "ds_autor")
    var author : String,

    @Column(name = "ano_publicacao")
    var publicationYear : Int,

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status : BookStatus? = null

)