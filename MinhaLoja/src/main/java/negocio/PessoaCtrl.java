package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Fone;
import beans.Pessoa;
import persistencia.FoneDAO;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private String pesquisa;

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Pessoa> lista;

	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> listagem() {
		return PessoaDAO.listagem("");
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public String actionGravar() {
		if (pessoa.getPes_id() == 0) {
			PessoaDAO.inserir(pessoa);
			return actionInserirPessoa();
		} else {
			PessoaDAO.alterar(pessoa);
			return "lista_pessoa";
		}
	}

	public String actionInserirPessoa() {
		pessoa = new Pessoa();
		return "form_cadusuario";
	}

	public String actionExcluir(Pessoa p) {
		PessoaDAO.excluir(p);
		return "lista_pessoa";
	}

	public String actionAlterar(Pessoa p) {
		this.pessoa = p;
		return "form_cadusuario";
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

}
