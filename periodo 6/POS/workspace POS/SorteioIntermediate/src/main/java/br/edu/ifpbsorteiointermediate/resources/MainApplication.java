/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpbsorteiointermediate.resources;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Luciano
 */
public class MainApplication extends Application {
    
    @Override
    public Restlet createInboundRoot(){
        Router router = new Router();
        
        //recuperar maior frequencia em todos os sorteios
        router.attach("/all/maior", EstatisticaResourceMaiorFrequenciaAllSorteios.class);
        //recuperar menor frequencia em todos os sorteios
        router.attach("/all/menor", EstatisticaResourceMenorFrequenciaAllSorteio.class);
        //recuperar maior frequencia por periodo
        router.attach("/maior/{dtInicial}/{dtFinal}", EstatisticaResourceMaiorFrequenciaPeriodo.class);
        //recuperar menor frequencia por periodo
        router.attach("/menor/{dtInicial}/{dtFinal}", EstatisticaResourceMenorFrequenciaPeriodo.class);
        //recuperar maior frequencia por faixa de codigo do sorteio
        router.attach("/maior/codigo/{codInicial}/{codFinal}", EstatiscaResourceMaiorFrequenciaPorFaixaDeCodigo.class);
        //recuperar menor frequencia por faixa de codigo do sorteio
        router.attach("/menorFrequencia/{inicial}/{final}", EstatiscaResourceMenorFrequenciaPorFaixaDeCodigo.class);
       
        return router;
    }
    
}
