/**
 * @author João Paulo
 */

package br.com.paulo;

import br.com.paulo.DAO.*;
import br.com.paulo.domain.Acessorio;
import br.com.paulo.domain.Carro;
import br.com.paulo.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Teste {

    private IMarcaDAO marcaDAO;

    private IAcessorioDAO acessorioDAO;

    private ICarroDAO carroDAO;

    public Teste() {
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
        carroDAO = new CarroDAO();
    }

    @Test
    public void teste() {
        Marca marca = criarMarca("1");
        Acessorio acessorio = criarAcessorio("1");

        Carro carro = new Carro();
        carro.setCodigo("1");
        carro.setModelo("Punto");
        carro.setMarca(marca);
        carro.setAcessorio(acessorio);

        carroDAO.cadastrar(carro);

        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());
    }

    public Marca criarMarca(String codigo) {
       Marca marca = new Marca();
       marca.setNome("FIAT");
       marca.setCodigo(codigo);

       return marcaDAO.cadastrar(marca);
    }

    public Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Escapamento");
        acessorio.setCodigo(codigo);

        return acessorioDAO.cadastrar(acessorio);
    }
}
