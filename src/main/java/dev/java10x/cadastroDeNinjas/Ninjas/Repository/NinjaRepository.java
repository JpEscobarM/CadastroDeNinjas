package dev.java10x.cadastroDeNinjas.Ninjas.Repository;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja,Long> {
}
