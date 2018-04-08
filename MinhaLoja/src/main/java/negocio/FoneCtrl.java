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
public class FoneCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fone fone;
	private String pesquisa;

	private List<Fone> fones = new ArrayList<Fone>();
	private List<Fone> lista;

	public Fone getFone() {
		if (fone == null) {
			fone = new Fone();
		}
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}

	public List<Fone> listagemF() {
		return FoneDAO.listagemF("");
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public String actionGravar() {
		if (fone.getId() == 0) {
			FoneDAO.inserir(fone);
			return actionInserirFone();
		} else {
			FoneDAO.alterar(fone);
			return "lista_pessoa";
		}
	}

	public String actionInserirFone() {
		fone = new Fone();
		return "form_cadusuario";
	}

	public String actionExcluirfone(Fone f) {
		FoneDAO.excluirFone(f);
		return "lista_pessoa";
	}

	public String actionAlterarfone(Fone f) {
		this.fone = f;
		return "form_cadusuario";
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public void setFone(List<Fone> fones) {
		this.fones = fones;
	}

	public List<Fone> getLista() {
		return lista;
	}

	public void setLista(List<Fone> lista) {
		this.lista = lista;
	}


}
