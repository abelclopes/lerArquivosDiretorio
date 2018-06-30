package br.eti.abellopes.teste1.models;

import java.math.BigDecimal;

public class Venda {
	private Integer ItemId;
	private Integer ItemQtd;
	private BigDecimal ItemPreco;
	
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public Integer getItemQtd() {
		return ItemQtd;
	}
	public void setItemQtd(Integer itemQtd) {
		ItemQtd = itemQtd;
	}
	public BigDecimal getItemPreco() {
		return ItemPreco;
	}
	public void setItemPreco(BigDecimal itemPreco) {
		ItemPreco = itemPreco;
	}
	
	
}
