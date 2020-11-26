package br.com.rodrigo.service;

public class OperacoesMatematicas {
	
	private Double operador1;
	private Double operador2;
	
	ConversorStringParaDouble conversor = new ConversorStringParaDouble();
	
	public OperacoesMatematicas(String strNumero1, String strNumero2 ) {
		this.operador1 = conversor.conversor(strNumero1);
		this.operador2 = conversor.conversor(strNumero2);
		
	}
	
	public OperacoesMatematicas(String strNumero) {
		this.operador1 = conversor.conversor(strNumero);
				
	}


	public Double soma () {
		return operador1+operador2;
	}
	
	public Double subtracao () {
		return operador1-operador2;
	}
	
	public Double divisao () {
		return operador1/operador2;
	}
	
	public Double multiplicacao () {
		return operador1*operador2;
	}
	
	public Double media () {
		return (operador1+operador2)/2;
	}
	
	public Double raiz () {
		return Math.sqrt(operador1);
	}

}
