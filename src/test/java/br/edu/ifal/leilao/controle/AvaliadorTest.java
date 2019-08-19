package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Usuario usuario5;
	private Usuario usuario6;
	private Leilao leilao;
	private Avaliador avaliador;
	
	@Before
	public void inicializacao(){
		usuario1 = new Usuario("Italo");
		usuario2 = new Usuario("Andréia");
		usuario3 = new Usuario("Emilly");
		usuario4 = new Usuario("Maria");
		usuario5 = new Usuario("José");
		usuario6 = new Usuario("Daniel");
		
		leilao = new Leilao();
		
		avaliador = new Avaliador();
	}
	//300, 400 e 250
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {
		
		
		
		
		leilao.propoe(new Lance(usuario1, 300));
		leilao.propoe(new Lance(usuario2, 400));
		leilao.propoe(new Lance(usuario3, 250));
		
		
		
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
		
		leilao.propoe(new Lance(usuario1, 250));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 400));
		
		
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
		
		
		leilao.propoe(new Lance(usuario1, 400));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 250));
		
		
		
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
		
		leilao.propoe(new Lance(usuario1, 400));	
		leilao.propoe(new Lance(usuario2, 300));
		leilao.propoe(new Lance(usuario3, 250));
		
		
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
		
		leilao.propoe(new Lance(usuario1, 300));	
		leilao.propoe(new Lance(usuario2, 400));
		leilao.propoe(new Lance(usuario3, 250));
		leilao.propoe(new Lance(usuario4, 100));	
		leilao.propoe(new Lance(usuario5, 500));
		leilao.propoe(new Lance(usuario6, 750));
		
		
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
		
		leilao.propoe(new Lance(usuario1, 250));	
				
		
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 250;
		int tamanhoTop3Esperado = 1;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3NãoDeveFuncionarComApenas2Lances() {
		
		leilao.propoe(new Lance(usuario1, 250));
		leilao.propoe(new Lance(usuario2, 300));
				
		
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 300;
		double segundoLanceEsperado = 250;
		int tamanhoTop3Esperado = 2;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.001);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3NãoDeveFuncionarSemLances() {
		
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		
		int tamanhoTop3Obtido = top3.size();
		
		
		int tamanhoTop3Esperado = 0;
		
		
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesIguais() {
		
		leilao.propoe(new Lance(usuario1, 250));	
		leilao.propoe(new Lance(usuario2, 250));
		leilao.propoe(new Lance(usuario3, 250));
		
		
		
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
