package br.com.treinamento.gft.treinamentogft.repository

import br.com.treinamento.gft.treinamentogft.entity.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository : JpaRepository<Livro, Int>