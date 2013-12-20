/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.intermediateservices;

import br.edu.ifpb.intermediateservices.sorteioresource.MaiorFrequencia;
import br.edu.ifpb.intermediateservices.sorteioresource.MenorFrequencia;
import br.edu.ifpb.intermediateservices.sorteioresource.SorteioPorCodigo;
import br.edu.ifpb.intermediateservices.sorteioresource.SorteioPorData;
import br.edu.ifpb.intermediateservices.sorteioresource.SorteioPorFaixaDeCodigo;
import br.edu.ifpb.intermediateservices.sorteioresource.SorteioPorPeriodo;
import br.edu.ifpb.intermediateservices.sorteioresource.SorteioResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Luciano
 */
public class MainApplication extends Application{
    
    @Override
    public Restlet createInboundRoot(){
        
        Router router = new Router();
        
        router.attach("/sorteio/", SorteioResource.class);
        //recuperar sorteio por codigo
        router.attach("/codigoId/{id}", SorteioPorCodigo.class);
        //recuperar sorteio por faixa de codigo
        router.attach("/codigoFaixa/{id_inicial}/{id_final}", SorteioPorFaixaDeCodigo.class);
        //recuperar sorteio por data
        router.attach("/data/{data}", SorteioPorData.class);
        //recuperar sorteio por periodo
        router.attach("/periodo/{dataInicial}/{dataFinal}", SorteioPorPeriodo.class);
        //recuperar o numero de maior frequencia
        router.attach("/maiorFrequencia", MaiorFrequencia.class);
        //recuperar numero de menor frequencia
        router.attach("/menorFrequencia", MenorFrequencia.class);
        
        return router;
        
    }
    
}
