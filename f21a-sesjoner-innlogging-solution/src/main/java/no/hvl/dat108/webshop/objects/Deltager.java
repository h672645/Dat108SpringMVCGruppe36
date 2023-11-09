package no.hvl.dat108.webshop.objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Pattern;
import no.hvl.dat108.webshop.services.PassordService;

@Entity
@Table(schema="oblig4")
public class Deltager {

	@Id
	@Pattern(regexp = "^[0-9]{8}$", message = "Mobil must contain exactly 8 numbers")
	private String mobil;
	
	@Pattern(regexp = "^[A-Za-z\\s-]{2,20}$", message = "Fornavn must be 2-20 characters long and only contain letters, spaces, or dashes")
	private String fornavn;

	@Pattern(regexp = "^[A-Za-z\\s-]{2,20}$", message = "Etternavn must be 2-20 characters long and only contain letters, spaces, or dashes")
	private String etternavn;

	private String passord;
	
	private String salt;

	@Pattern(regexp = "^(mann|kvinne)$", message = "Kjonn must be either 'mann' or 'kvinne'")
	private String kjonn;

	public Deltager() {

	}

	public Deltager(String fornavn) {
		this.fornavn = fornavn;
	}

	public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Deltager [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil + ", passord=" + passord
				+ ", kjonn=" + kjonn + "]";
	}

}
