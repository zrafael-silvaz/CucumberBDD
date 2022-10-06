package br.ce.rsilva.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {
	@Dado("que criei o arquivo corretamente")
	public void que_criei_o_arquivo_corretamente() {
	    System.out.println("teste");
	}

	@Quando("executá-lo")
	public void executá_lo() {
	    
	}

	@Então("a especificação deve finalizar com sucesso")
	public void a_especificação_deve_finalizar_com_sucesso() {
	    
	}
	
	private int contador = 0;	
	@Dado("que o valor do contador é {int}")
	public void que_o_valor_do_contador_é(Integer int1) {
	    contador = int1;
	}
	
	@Quando("eu incrementar em {int}")
	public void eu_incrementar_em(Integer int1) {
	   contador += int1;
	}
	
	@Então("o valor do contador será {int}")
	public void o_valor_do_contador_será(Integer int1) {
		System.out.println("teste"+int1);
	    Assert.assertEquals(int1, contador, 0);		
	}
	
	
	Date entrega = new Date();
	
//	@Dado("que a entrega é dia {}")
//	public void que_a_entrega_é_dia(Date data) {
//		entrega = data;				
//	}
	@Dado("que a entrega é dia {int}\\/{int}\\/{int}")
	public void que_a_entrega_é_dia(int dia, int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1); //no java a contagem de mes é menos 1 pois janeiro na verdade é 0
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();		
	}
	@Quando("a entrega atrasar em {int} {string}")
	public void a_entrega_atrasar_em_dias(Integer i, String tempo) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if (tempo.equals("dia") || tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, i);
		}
	    if (tempo.equals("mes") || tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, i);
		}			   
	    entrega = cal.getTime();	    
	}
	@Então("a entrega será efetuada em {string}")
	public void a_entrega_será_efetuada_em(String string) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFomatada = format.format(entrega);	    
	    Assert.assertEquals(string, dataFomatada);	    
	}
	
	
	@Dado("que o ticket( especial) é {string}")
	public void que_o_ticket_é(String string) {
	    
	}

	@Dado("que o valor da passagem é R$ {double}")
	public void que_o_valor_da_passagem_é_r$(Double double1) {
	    
	}

	@Dado("que o nome do passageiro é {string}")
	public void que_o_nome_do_passageiro_é(String string) {
	   
	}

	@Dado("que o telefone do passageiro é {string}")
	public void que_o_telefone_do_passageiro_é(String string) {
	    
	}

	@Quando("criar os steps")
	public void criar_os_steps() {
	    
	}

	@Então("o teste vai funcionar")
	public void o_teste_vai_funcionar() {
	   
	}
	
}
