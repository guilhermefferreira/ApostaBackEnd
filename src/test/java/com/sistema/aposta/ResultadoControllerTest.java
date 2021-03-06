package com.sistema.aposta;

import com.sistema.aposta.controller.ResultadoController;
import com.sistema.aposta.entities.Resultado;
import com.sistema.aposta.repositories.ResultadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ResultadoControllerTest {

    @Autowired
    private ResultadoController resultadoController;

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Test
    void listarTest() {
        Integer expected = (int) resultadoRepository.count();
        Integer result = resultadoController.listar().size();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void incluirTest() {
        Resultado resultado = new Resultado();
        Integer expected = (int) resultadoRepository.count()+1;
        resultado.setIdResultado(0);
        resultado.setIdJogo(1);
        resultado.setIdClube(1);
        resultado.setNome("Resultado");
        resultado.setVencedor(true);
        resultadoController.incluir(resultado);
        Integer result = (int) resultadoRepository.count();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void alterarTest() {

        Resultado resultado = resultadoController.Consultar(1);
        resultado.setIdJogo(1);
        resultado.setIdClube(1);
        resultado.setNome("Resultado");
        resultado.setVencedor(true);
        resultadoController.alterar(resultado);
        Resultado resultadoTeste = resultadoController.Consultar(1);

        assertThat(resultado.getIdJogo()).isEqualTo(resultadoTeste.getIdJogo());

    }

    @Test
    void consultarTest(){

        Resultado resultadoTest = resultadoController.Consultar(1);

        assertThat(resultadoTest.getIdJogo()).isEqualTo(1);
        

    }
}
