package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class ChatDao {

	private final JdbcTemplate db;

	public ChatDao(JdbcTemplate db) {
		this.db = db;

	}

	public void insertDb(EntForm entform) {
		db.update("INSERT INTO sample (name,comment)VALUES(?,?)", entform.getName(), entform.getComment());

	}
}
