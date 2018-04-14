package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = -8023482526632579452L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pes_id")
	private int pes_id;
	
	@Column(name = "pes_nome")
	private String pes_nome;
	
	@Column(name = "pes_cpf")
	private String cpf;
	
	@Column(name = "pes_data_nasc")
	@Temporal(value = TemporalType.DATE)
	private Date data;
	
	@Column(name = "pes_rua")
	private String rua;
	
	@Column(name = "pes_bairro")
	private String bairro;
	
	@Column(name = "pes_cidade")
	private String cidade;
	
	@Column(name = "pes_uf")
	private String uf;
	
	@Column(name = "pes_cep")
	private int cep;
	
	@Column(name = "pes_email")
	private String email;
	
	@Column(name = "pes_senha")
	private String senha;
	
	@Column(name = "pes_tipo")
	private String tipo;

	public int getPes_id() {
		return pes_id;
	}

	public void setPes_id(int pes_id) {
		this.pes_id = pes_id;
	}

	public String getPes_nome() {
		return pes_nome;
	}

	public void setPes_nome(String pes_nome) {
		this.pes_nome = pes_nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Fone> fones = new ArrayList<Fone>();
	
	public List<Fone> getFones(){
		return fones;
	}
	
	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pes_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (pes_id != other.pes_id)
			return false;
		return true;
	}
	
}
