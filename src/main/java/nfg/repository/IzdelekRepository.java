package nfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nfg.model.Izdelek;

public interface IzdelekRepository extends JpaRepository<Izdelek, Long> {

}
