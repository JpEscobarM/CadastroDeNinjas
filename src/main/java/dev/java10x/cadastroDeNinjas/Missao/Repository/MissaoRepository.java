package dev.java10x.cadastroDeNinjas.Missao.Repository;

import dev.java10x.cadastroDeNinjas.Missao.Model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao,Long> {
}
