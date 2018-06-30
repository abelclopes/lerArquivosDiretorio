package br.eti.abellopes.teste1.models;

public class DadoVenda {

	private String Code;
	private String VendaId;
	private Venda[] Venda;
	private String SalesMenName;
	
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getVendaId() {
		return VendaId;
	}
	public void setVendaId(String vendaId) {
		VendaId = vendaId;
	}
	public Venda[] getVenda() {
		return Venda;
	}
	public void setVenda(Venda[] venda) {
		Venda = venda;
	}
	public String getSalesMenName() {
		return SalesMenName;
	}
	public void setSalesMenName(String salesMenName) {
		SalesMenName = salesMenName;
	}
	

}
