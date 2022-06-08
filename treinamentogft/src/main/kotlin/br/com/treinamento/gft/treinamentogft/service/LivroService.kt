package br.com.treinamento.gft.treinamentogft.service

import br.com.treinamento.gft.treinamentogft.entity.Livro
import br.com.treinamento.gft.treinamentogft.enums.BookStatus
import org.springframework.stereotype.Service
import br.com.treinamento.gft.treinamentogft.repository.LivroRepository
import java.util.*


@Service
class LivroService(
    private val livroRepository: LivroRepository
) {
    fun findAll() : List<Livro>{
        return livroRepository.findAll()
    }

    fun save(livro: Livro) : Livro {
        return livroRepository.save(livro)
    }

    fun findById(id: Int): Livro {
        return livroRepository.findById(id).orElseThrow()
    }

    fun update(book: Livro) {
        livroRepository.save(book)
    }

    fun remove(id: Int) {
        val book = findById(id)
        book.status = BookStatus.INATIVO
        update(book)
    }
}