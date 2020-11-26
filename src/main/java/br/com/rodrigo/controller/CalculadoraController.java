package br.com.rodrigo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.service.OperacoesMatematicas;

@RestController
public class CalculadoraController {
	
	OperacoesMatematicas om;
	
	@RequestMapping(value="/soma/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) {
		om = new OperacoesMatematicas(numero1, numero2);
		Double resultado = om.soma();
		return resultado;
	}
	
	@RequestMapping(value="/subtracao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) {
		om = new OperacoesMatematicas(numero1, numero2);
		Double resultado = om.subtracao();
		return resultado;
	}
	
	@RequestMapping(value="/multiplicacao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) {
		om = new OperacoesMatematicas(numero1, numero2);
		Double resultado = om.multiplicacao();
		return resultado;
	}
	
	@RequestMapping(value="/divisao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) {
		om = new OperacoesMatematicas(numero1, numero2);
		Double resultado = om.divisao();
		return resultado;
	}
	
	@RequestMapping(value="/media/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double media(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) {
		om = new OperacoesMatematicas(numero1, numero2);
		Double resultado = om.media();
		return resultado;
	}
	
	@RequestMapping(value="/raiz/{numero1}", method = RequestMethod.GET)
	public Double media(@PathVariable("numero1") String numero1) {
		om = new OperacoesMatematicas(numero1);
		Double resultado = om.raiz();
		return resultado;
	}
}
