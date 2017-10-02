package nfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nfg.model.Izdelek;

public interface IzdelekRepository extends JpaRepository<Izdelek, Long> {
	List<Izdelek> findByImeLike(String ime);
	List<Izdelek> findByCenaGreaterThanEqual(double low);
	List<Izdelek> findByCenaLessThanEqual(double high);
	List<Izdelek> findByCenaGreaterThanEqualAndCenaLessThanEqual(double low, double high);
	List<Izdelek> findBySifraStartingWith(String sif);
	
	@Query("select i from Izdelek i where i.ime like %?1")
	List<Izdelek> queryByName(String ime);
}