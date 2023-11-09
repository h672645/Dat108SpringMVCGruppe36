package no.hvl.dat108.webshop.objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.hvl.dat108.webshop.interfaces.DeltagerRepo;
import no.hvl.dat108.webshop.services.DeltagerService;



@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class DeltagerTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Mock
    DeltagerRepo mockedDeltagerRepo;

    @InjectMocks
    DeltagerService deltagerService;

    
    private Deltager deltager1 = new Deltager("Marco","Guiterrez","75838933","test56","mann");
    private Deltager deltager2 = new Deltager("Johanna","Lindgren","65424254","vinkork2377","kvinne");
    private Deltager deltager3 = new Deltager("Maria","Sousa","75231254","h24ha","kvinne");
    private Deltager deltager4 = new Deltager("Fritz","Grossmann","22355311","schnitzel20","mann");
    private Deltager deltager5 = new Deltager("Maria","Maria","51236231","h24ha","kvinne");
    
    @BeforeEach
    void reset() {
    	mockedDeltagerRepo.save(deltager1);
    	mockedDeltagerRepo.save(deltager2);
    	mockedDeltagerRepo.save(deltager3);
    	mockedDeltagerRepo.save(deltager4);
    }
    
    @Test
void testOmPersonHarPassord(){

        Deltager deltager1 = this.deltager1;
        assertTrue(inneholder(deltager1,"passord"));
    }
    @Test
    void testOmPersonHarFornavn(){
        Deltager deltager2 = this.deltager2;
        assertTrue(inneholder(deltager2,"fornavn"));
    }
    @Test
    void testOmPersonErMannellerKvinne() {
        Deltager deltager3 = this.deltager3;
        assertTrue(deltager3.getKjonn()=="kvinne");
    }
    @Test
    void testOmPersonHarRiktigFornavn() {
        Deltager deltager4 = this.deltager4;
        assertTrue(deltager4.getFornavn()=="Fritz");
    }
    @Test
    void TestOmFinnerDeltagerMedMobil() {

        when(mockedDeltagerRepo.findByMobil("75838933")).thenReturn(
                new Deltager("Marco","Guiterrez","75838933","test56","mann"));

                Deltager resultat = deltagerService.finnDeltagerMedMobil("75838933");
                System.out.println(resultat.toString());

                assertTrue(resultat.getFornavn()=="Marco");
    }

    private boolean inneholder(Deltager deltager, String egenskap) {
        return !validator.validate(deltager).stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet()).contains(egenskap);
    }
    
    @Test
	void finnerDeSomHarNavnet() {
		
		when(mockedDeltagerRepo.findAllByFornavn("Maria")).thenReturn(List.of(
				new Deltager("Maria","Sousa","75231254","h24ha","kvinne"),
				new Deltager("Maria","Maria","51236231","h24ha","kvinne")
				));
		
		List<Deltager> liste = deltagerService.finnDeltagereMedFornavn("Maria");
		System.out.println(liste.toString());
		
		assertTrue(liste == mockedDeltagerRepo.findAllByFornavn("Maria"));
		assertFalse(liste == mockedDeltagerRepo.findAllByFornavn("maria"));
	}
}