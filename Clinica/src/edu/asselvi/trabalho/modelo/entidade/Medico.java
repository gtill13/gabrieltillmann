/**
 * 
 */
package edu.asselvi.trabalho.modelo.entidade;

/**
 * @author Gabriel Tillmann
 *
 */
public class Medico {

	/**
	 * 
	 */
	public Medico() {
		super();
	}
	public Medico(String crm, String nome, String rg, String cpf, ESexo sexo) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
	}
	public Medico(long id, String crm, String nome, String rg, String cpf,
			ESexo sexo) {
		this(crm, nome, rg, cpf, sexo);
		this.id = id;
	}
	public Medico(long id, String crm, String nome, String rg, String cpf,
			ESexo sexo, Endereco endereco, Contato contato) {
		this(id, crm, nome, rg, cpf, sexo);
		this.endereco = endereco;
		this.contato = contato;
	}
	
	private long id;
	private String crm;
	private String nome;
	private String rg;
	private String cpf;
	
	private ESexo sexo;
	
	private Endereco endereco;
	private Contato contato;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ESexo getSexo() {
		return sexo;
	}
	public void setSexo(ESexo sexo) {
		this.sexo = sexo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Medico other = (Medico) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [id=").append(id).append(", crm=").append(crm)
				.append(", nome=").append(nome).append(", rg=").append(rg)
				.append(", cpf=").append(cpf).append(", sexo=").append(sexo)
				.append(", endereco=").append(endereco).append(", contato=")
				.append(contato).append("]");
		return builder.toString();
	}
		
}
