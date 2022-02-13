package jp.ken.bookstore.model;

import org.hibernate.validator.constraints.NotEmpty;

public class BookStoreModel {

	private String selectRadio;
	
	@NotEmpty(message = "省略することはできません")
	private String vagueFiled;

	public String getSelectRadio() {
		return selectRadio;
	}

	public void setSelectRadio(String selectRadio) {
		this.selectRadio = selectRadio;
	}

	public String getVagueFiled() {
		return vagueFiled;
	}

	public void setVagueFiled(String vagueFiled) {
		this.vagueFiled = vagueFiled;
	}
	
}
