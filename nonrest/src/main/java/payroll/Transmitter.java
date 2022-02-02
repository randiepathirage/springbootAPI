package payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Transmitter {

	private @Id @GeneratedValue Long id;
	private String issuer;
	private String jwks_uri;

	Transmitter() {}

	Transmitter(String issuer, String jwks_uri) {

		this.issuer = issuer;
		this.jwks_uri = jwks_uri;
	}

	public Long getId() {
		return this.id;
	}

	public String getIssuer() {
		return this.issuer;
	}

	public String getJwks_uri() {
		return jwks_uri;
	}

	public void setJwks_uri(String jwks_uri) {
		this.jwks_uri = jwks_uri;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}


	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Transmitter))
			return false;
		Transmitter transmitter = (Transmitter) o;
		return Objects.equals(this.id, transmitter.id) && Objects.equals(this.issuer, transmitter.issuer)
				&& Objects.equals(this.jwks_uri, transmitter.jwks_uri);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.issuer, this.jwks_uri);
	}

	@Override
	public String toString() {
		return "Transmitter{" + "id=" + this.id + ", issuer='" + this.issuer + '\'' + ", role='" + this.jwks_uri + '\'' + '}';
	}
}
