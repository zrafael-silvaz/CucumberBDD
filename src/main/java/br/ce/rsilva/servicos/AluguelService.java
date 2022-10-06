package br.ce.rsilva.servicos;

import br.ce.rsilva.entidades.EnumTipoAluguel;
import br.ce.rsilva.entidades.Filme;
import br.ce.rsilva.entidades.NotaAluguel;
import br.ce.rsilva.utils.DateUtils;


public class AluguelService {
	public NotaAluguel alugar(Filme filme, EnumTipoAluguel tipoaluguel) {
		
		if (filme.getEstoque()<1) {
			throw new RuntimeException("Filme sem estoque");
		}
		
		NotaAluguel notaAluguel = new NotaAluguel(); 
		
		switch (tipoaluguel) {
		case COMUM:
			notaAluguel.setPreco(filme.getAluguel());
			notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			notaAluguel.setPontuacao(1);
			break;
		case EXTENDIDO:
			notaAluguel.setPreco(filme.getAluguel() * 2);
			notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			notaAluguel.setPontuacao(2);
			break;
		case SEMANAL:
			notaAluguel.setPreco(filme.getAluguel() * 3);
			notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			notaAluguel.setPontuacao(3);
			break;
		}			
		
		filme.setEstoque(filme.getEstoque() - 1);
		return notaAluguel;		
	}
}
