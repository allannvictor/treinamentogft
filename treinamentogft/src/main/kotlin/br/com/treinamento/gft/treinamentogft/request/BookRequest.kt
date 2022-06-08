package br.com.treinamento.gft.treinamentogft.request

import br.com.treinamento.gft.treinamentogft.entity.Livro
import br.com.treinamento.gft.treinamentogft.enums.BookStatus
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class BookRequest(

    @field:NotEmpty(message = "O nome é obrigatório.")
    val name : String,
    @field:NotEmpty(message = "O autor é obrigatório.")
    val author : String,

    @field:NotNull(message = "O ano é obrigatório.")
    @field:Min(message = "O ano não pode ser zero.", value = 1899)
    val publicationYear : Int
){
    fun toBookEntity(book: Livro?): Livro {
        return if (book == null)
            Livro(
                name = this.name,
                author = this.author,
                publicationYear = this.publicationYear,
                status = BookStatus.ATIVO
            )
        else
            Livro(
                id = book.id,
                name = this.name,
                author = this.author,
                publicationYear = this.publicationYear,
                status = BookStatus.ATIVO
            )
    }
}
