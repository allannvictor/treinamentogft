package br.com.treinamento.gft.treinamentogft.controller

import br.com.treinamento.gft.treinamentogft.entity.Livro
import br.com.treinamento.gft.treinamentogft.request.BookRequest
import br.com.treinamento.gft.treinamentogft.service.LivroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("api/v1/books")
class LivroController(
    private val livroService: LivroService
) {

    @GetMapping
    fun getAll() : ResponseEntity<List<Livro>>{
        return ResponseEntity.ok(livroService.findAll())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: BookRequest) {
        livroService.save(request.toBookEntity(null))
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id : Int, @RequestBody @Valid request: BookRequest) {
        val bookSaved = livroService.findById(id)
        livroService.update(request.toBookEntity(bookSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id : Int) {
        livroService.remove(id)
    }
}