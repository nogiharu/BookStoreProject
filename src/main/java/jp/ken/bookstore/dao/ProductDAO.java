package jp.ken.bookstore.dao;

import java.util.List;

public interface ProductDAO <T> {
	
	List<T> allListOrderBy();
	List<T> likeList(String name);
}
