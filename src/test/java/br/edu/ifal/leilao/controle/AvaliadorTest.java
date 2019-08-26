package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
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
	private CriadorDeLeilao criadorDeLeilao;
	
	@Before
	public void inicializacao(){
		usuario1 = new Usuario("Italo");
		usuario2 = new Usuario("Andréia");
		usuario3 = new Usuario("Emilly");
		usuario4 = new Usuario("Maria");
		usuario5 = new Usuario("José");
		usuario6 = new Usuario("Daniel");
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		avaliador = new Avaliador();
	}
	//300, 400 e 250
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.constroi();
		
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
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 300)
				.lance(usuario3, 400)
				.constroi();
		
		
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
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 400)
				.lance(usuario2, 300)
				.lance(usuario3, 250)
				.constroi();
		
		
		
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		double menorLanceObtido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
		assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
	}	
	
	@Test
	public void top3DeveFuncionarComLancesEmOrdemCrescente() {
    	
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 300)
				.lance(usuario3, 400)
				.constroi();
		
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3Lances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 400.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
}
	
	@Test
	public void top3DeveFuncionarComLancesEmOrdemDecrescente() {
    	
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 400)
				.lance(usuario2, 300)
				.lance(usuario3, 250)
				.constroi();
		
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3Lances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 400.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
}
	
	@Test
	public void top3DeveFuncionarCom3LancesEmOrdemAleatoria() {
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 400)
				.lance(usuario2, 300)
				.lance(usuario3, 250)
				.constroi();
		
		
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
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.lance(usuario4, 100)
				.lance(usuario5, 500)
				.lance(usuario6, 750)
				.constroi();
		
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
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.constroi();
				
		
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
	public void top3DeveFuncionarComApenas2Lances() {
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250.0)
				.lance(usuario2, 300.0)
				.constroi();
				
		
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
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.constroi();
		
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3 = avaliador.getTop3Lances();
		
		int tamanhoTop3Obtido = top3.size();
		
		
		int tamanhoTop3Esperado = 0;
		
		
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesIguais() {
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 250)
				.lance(usuario3, 250)
				.constroi();
		
		
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
