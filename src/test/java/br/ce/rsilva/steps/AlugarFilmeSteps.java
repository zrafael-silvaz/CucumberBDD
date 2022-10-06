package br.ce.rsilva.steps;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.google.common.collect.Table;

import br.ce.rsilva.entidades.EnumTipoAluguel;
import br.ce.rsilva.entidades.Filme;
import br.ce.rsilva.entidades.NotaAluguel;
import br.ce.rsilva.servicos.AluguelService;
import br.ce.rsilva.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private EnumTipoAluguel tipoaluguel;
	
	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer int1) {
	    filme = new Filme();
	    filme.setEstoque(int1);
	}
	
	@Dado("um filme")
	public void umFilme(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		//Map<String, Integer> map1 = dataTable.asMap(String.class, Integer.class);
	    
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    
	    String tipo = map.get("tipo");
	    tipoaluguel = (tipo.equals("semanal"))? EnumTipoAluguel.SEMANAL: (tipo.equals("extendido"))? EnumTipoAluguel.EXTENDIDO: EnumTipoAluguel.COMUM;
	    
	    System.out.println(map.get("2"+"impressao preco-------------------------------------------"));
	    }

	@Dado("que o preço do aluguel seja R$ {int}")
	public void queOPreçoDoAluguelSejaR$(Integer int1) {
	    filme.setAluguel(int1);
	}

	@Quando("alugar")
	public void alugar() {
		try {
			notaAluguel = aluguel.alugar(filme, tipoaluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}	    
	}

	@Então("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPreco(), 0);
	}

	@Então("o estoque do filme será {int} unidade")
	public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
	    Assert.assertEquals(int1, filme.getEstoque(), 0);
	}

	@Então("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
	    Assert.assertEquals("Filme sem estoque", erro);
	}

	@Dado("o tipo do aluguel seja {}")
	public void oTipoDoAluguelSejaExtendito(String tipo) {
	    tipoaluguel = (tipo.equals("semanal"))? EnumTipoAluguel.SEMANAL: (tipo.equals("extendido"))? EnumTipoAluguel.EXTENDIDO: EnumTipoAluguel.COMUM;
	}

	@Então("a data de entrega será de {int} dia(s)")
	public void aDataDeEntregaSeráDeDias(Integer int1) {
	    Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);	    
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");	    
	    //Assert.assertEquals(DateUtils.formatarData(dataEsperada), DateUtils.formatarData(notaAluguel.getDataEntrega()));
	    Assert.assertEquals(format.format(dataEsperada), format.format(notaAluguel.getDataEntrega()));
	}
	
	@Então("a pontuação será de {int} pontos")
	public void aPontuaçãoSeráDePontos(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPontuacao(),0);
	}
}
