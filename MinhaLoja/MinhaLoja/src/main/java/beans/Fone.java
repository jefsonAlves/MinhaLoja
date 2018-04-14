package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "fone")
public class Fone implements Serializable{
	
	private static final long serialVersionUID = -8023482526632579452L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fon_id")
	private int id;
	
	@Column(name = "fon_numero")
	private String numero;
	
	@Column(name = "fon_descricao")
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
