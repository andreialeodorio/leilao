package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifal.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class TddTest {
	private CriadorDeLeilao criadorDeLeilao;
	private Leilao leilao;
	private Avaliador avaliador;
	private Usuario usuario;
	private Usuario usuario2;
	@Test
	public void leilaoDeveFuncionarComUsuariosELancesDiferentes() {
	criadorDeLeilao = new CriadorDeLeilao();
	leilao = criadorDeLeilao.para(new Produto("TV"))
			.lance(new Usuario("usuario1"), 300)
			.lance(new Usuario("usuario2"), 400)
			.lance(new Usuario("usuario3"), 250)
			.lance(new Usuario("usuario4"), 800)
			.lance(new Usuario("usuario5"), 150)
			.constroi();
	
		avaliador = new Avaliador();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void leilaoNaoDeveFuncionarComCincoLancesDoMesmoUsuario() {
		usuario = new Usuario("usuario1");
		criadorDeLeilao = new CriadorDeLeilao();
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario, 300)
				.lance(usuario, 400)
				.lance(usuario, 250)
				.lance(usuario, 800)
				.lance(usuario, 150)
				.lance(usuario, 550)
				.constroi();
		
			avaliador = new Avaliador();
			
			boolean validadeObtida = avaliador.validarLeilao(leilao);
			boolean validadeEsperada = false;
			
			assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void leilaoDeveFuncionarComTresLancesPorUsuario() {
		usuario = new Usuario("usuario1");
		usuario2 = new Usuario("José");
		
		criadorDeLeilao = new CriadorDeLeilao();
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario, 300)
				.lance(usuario, 400)
				.lance(usuario, 250)
				.lance(usuario2, 800)
				.lance(usuario2, 150)
				.lance(usuario2, 550)
				.constroi();
		
		avaliador = new Avaliador();		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void leilaoDeveFuncionarSemLances() {
		criadorDeLeilao = new CriadorDeLeilao();
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.constroi();
		
		avaliador = new Avaliador();		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
	
}