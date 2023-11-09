package no.hvl.dat108.webshop.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import no.hvl.dat108.webshop.objects.Deltager;


public interface DeltagerRepo extends JpaRepository<Deltager, String> {
    Deltager findByMobil(String mobil);

    List<Deltager> findAll(); // This method retrieves all Deltager entities
}