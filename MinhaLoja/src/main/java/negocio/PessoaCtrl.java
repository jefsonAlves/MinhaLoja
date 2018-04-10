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
	private Fone fone;
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

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem("");
	}

	public List<Fone> getListagemF() {
		return FoneDAO.listagemF("");
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

	public void actionAlterar(Fone f) {
		this.fone = f;
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

	public void adicionartelefone() {
		if (!pessoa.getFones().contains(fone)) {
			fone.setPessoa(pessoa);
			pessoa.getFones().add(fone);
		}
		fone = new Fone();
	}

	public void actionExcluirFone(Fone f) {
		FoneDAO.excluirFone(f);
		getPessoa().getFones().remove(f);

	}

	public Fone getFone() {
		if (fone == null) {
			fone = new Fone();
		}
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}

}
