package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	//300, 400 e 250
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {
		
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 300));
		leilao.propoe(new Lance(usuario2, 400));
		leilao.propoe(new Lance(usuario3, 250));
		
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		double menorLanceObtido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
		assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);

	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemCrescente() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 250));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 400));
		
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		double menorLanceObtido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
		assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemDecrescente() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 400));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 250));
		
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		double menorLanceObtido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
		assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
	}	
	
	@Test
	public void top3DeveFuncionarCom3LancesEmOrdemAleatoria() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 400));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 250));
		
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3DeveFuncionarComMaisDe3Lances() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		Usuario usuario4 = new Usuario("Maria");
		Usuario usuario5 = new Usuario("José");
		Usuario usuario6 = new Usuario("Daniel");
		
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 300));	
		leilao.propoe(new Lance(usuario2, 400));
		leilao.propoe(new Lance(usuario3, 250));
		leilao.propoe(new Lance(usuario4, 100));	
		leilao.propoe(new Lance(usuario5, 500));
		leilao.propoe(new Lance(usuario6, 750));
		
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 750;
		double segundoLanceEsperado = 500;
		double terceiroLanceEsperado = 400;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3NãoDeveFuncionarComApenas1Lance() {
		Usuario usuario1 = new Usuario("Italo");
				
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 250));	
				
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 250;
		double segundoLanceEsperado = 0;
		double terceiroLanceEsperado = 0;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3NãoDeveFuncionarComApenas2Lances() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Emilly");
				
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 250));
		leilao.propoe(new Lance(usuario2, 300));
				
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 300;
		double segundoLanceEsperado = 250;
		double terceiroLanceEsperado = 0;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3NãoDeveFuncionarSemLances() {
				
		Leilao leilao = new Leilao();	
				
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 0;
		double segundoLanceEsperado = 0;
		double terceiroLanceEsperado = 0;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesIguais() {
		Usuario usuario1 = new Usuario("Italo");
		Usuario usuario2 = new Usuario("Andréia");
		Usuario usuario3 = new Usuario("Emilly");
		
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 250));	
		leilao.propoe(new Lance(usuario2, 250));
		leilao.propoe(new Lance(usuario3, 250));
		
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 250;
		double segundoLanceEsperado = 250;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3Esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	
	
	
	
	
	
}
