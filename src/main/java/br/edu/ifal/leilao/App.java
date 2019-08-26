package br.edu.ifal.leilao;

import br.edu.ifal.leilao.controle.Avaliador;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Leilao leilao = new Leilao();
    	leilao.propoe(new Lance(new Usuario("ze"), 250.0));
    	leilao.propoe(new Lance(new Usuario("ze"), 300.0));
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        avaliador.setTop3Lances(leilao);
        
        for (Lance lance : avaliador.getTop3Lances()) {
			System.out.println(lance.getValor());
		}
    }
}
