package com.caveofprogramming.db;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
	public DaoException(SQLException e) {
		super(e);
	}
	
	
}
