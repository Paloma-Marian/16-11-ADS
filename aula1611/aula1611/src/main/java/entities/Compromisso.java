package entities;

import jakarta.persistence.Column;

//import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_compromisso")
public class Compromisso {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String local;
	@Column(length = 50, nullable = false)
	private String contato;
	@Column(length = 50, nullable = false)
	private String data;
	@Column(length = 50, nullable = false)
	private Double hora;
	@Column(length = 1, nullable = false)
	private byte status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getHora() {
		return hora;
	}
	public void setHora(Double hora) {
		this.hora = hora;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}

	public Compromisso(Long id, String local, String contato, String data, Double hora, byte status) {
		super();
		this.id = id;
		this.local = local;
		this.contato = contato;
		this.data = data;
		this.hora = hora;
		this.status = status;
	}

}
