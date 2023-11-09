package no.hvl.dat108.webshop.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no.hvl.dat108.webshop.interfaces.DeltagerRepo;
import no.hvl.dat108.webshop.objects.Deltager;

@Service
public class DeltagerService {
    
	@Autowired private DeltagerRepo deltagerrepo;

	public List<Deltager> finnAlleDeltagere() {
        return deltagerrepo.findAll();
    }

    public Deltager finnDeltagerMedMobil(String mobil) {
        return deltagerrepo.findByMobil(mobil); // Use the method from the interface
    }
    
    public boolean eksistererDeltager(String mobil) {
    	
    	Deltager deltager = deltagerrepo.findByMobil(mobil);
    	
    	if(deltager == null) {
    		return false;
    	}
    	
    	return true;
    	
    }
    
    public void lagreDeltager(Deltager deltager) {
    	deltagerrepo.save(deltager);
    }
}
