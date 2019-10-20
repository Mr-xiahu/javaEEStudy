package com.xiahu.service;

import java.sql.SQLException;
import java.util.List;

import com.xiahu.dao.SearchWordDao;
import com.xiahu.domain.Product;

public class SearchWordService {

	public List<Object> findProductListByWord(String word) throws SQLException {
		//直接传递到Dao层
		SearchWordDao dao = new SearchWordDao();
		return dao.findProductListByWord(word);
	}

}
