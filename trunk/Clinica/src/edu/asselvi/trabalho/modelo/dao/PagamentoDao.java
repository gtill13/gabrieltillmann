package edu.asselvi.trabalho.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.trabalho.modelo.entidade.Pagamento;

public class PagamentoDao extends DaoBase {

	public long inserirComRetorno(Pagamento pagamento) {

		if (pagamento == null)
			return 0;

		conectaPeloContext();
		executeUpdate("insert into pagamento (data_pagamento, data_vencimento, valor, juros, valor_total) values ( '"
				+ pagamento.getDataPagamento()
				+ "', '"
				+ pagamento.getDataVencimento()
				+ "', '"
				+ pagamento.getValor()
				+ "', '"
				+ pagamento.getJuros()
				+ "', '"
				+ pagamento.getValorTotal() + "' ) ");

		return getGenerationKeys();

	}

	public void atualizar(Pagamento pagamento) throws DaoException {

		if (pagamento == null)
			return;

		conecta();

		executeUpdate("update pagamento set data_pagamento = '" + pagamento.getDataPagamento()
				+ "', data_vencimento = '" + pagamento.getDataVencimento() + "', valor = '"
				+ pagamento.getValor() + "', juros = '" + pagamento.getJuros() +
				"', valor_total = '" + pagamento.getValorTotal() + 
				"' where id = '" + pagamento.getId() + "' ");
	}

	public void deletar(Pagamento pagamento) throws DaoException {

		conecta();

		executeUpdate("delete from pagamento where id = '" + pagamento.getId()
				+ "' ");
	}

	public List<Pagamento> buscaTodos() {

		final List<Pagamento> listPagamentos = new ArrayList<Pagamento>();

		executeQuery("select * from pagamento", new Mapeador<Pagamento>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Pagamento pagamento = new Pagamento();

						pagamento.setId(rset.getLong("id"));
						pagamento.setDataPagamento(rset.getDate("data_pagamento"));
						pagamento.setDataVencimento(rset.getDate("data_vencimento"));
						pagamento.setValor(rset.getDouble("valor"));
						pagamento.setJuros(rset.getDouble("juros"));
						pagamento.setValorTotal(rset.getDouble("valor_total"));

						listPagamentos.add(pagamento);
					}
				} catch (SQLException e) {
					throw new DaoException(
							"Banco de dados - Erro ao criar lista em "
									+ this.getClass().toString(), e);
				}
			}
		});

		return listPagamentos;
	}

	public Pagamento buscaContatoPeloId(long id) {

		final Pagamento pagamento = new Pagamento();

		executeQuery("select * from pagamento where id = '" + id + "' ",
				new Mapeador<Pagamento>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								pagamento.setId(rset.getLong("id"));
								pagamento.setDataPagamento(rset.getDate("data_pagamento"));
								pagamento.setDataVencimento(rset.getDate("data_vencimento"));
								pagamento.setValor(rset.getDouble("valor"));
								pagamento.setJuros(rset.getDouble("juros"));
								pagamento.setValorTotal(rset.getDouble("valor_total"));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return pagamento;
	}
	
}
