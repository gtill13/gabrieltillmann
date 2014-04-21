/**
 * 
 */
package edu.asselvi.trabalho.framework.dao;

import java.sql.ResultSet;

/**
 * @author TiLL
 *
 */
public interface Mapeador<T> {

	void mapear (ResultSet rset) throws DaoException;
	
}
