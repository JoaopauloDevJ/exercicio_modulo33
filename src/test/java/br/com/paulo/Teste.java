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
        Carro carro = criarCarro("1");

        Marca marca = new Marca();
        marca.setNome("FIAT");
        marca.setCodigo("1");
        carro.setMarca(marca);

        marcaDAO.cadastrar(marca);

        Assert.assertNotNull(marca);
        Assert.assertNotNull(marca.getId());
    }

    public Carro criarCarro(String codigo) {
        Acessorio acessorio = criarAcessorio("1");

        Carro carro = new Carro();
        carro.setModelo("Punto");
        carro.setCodigo(codigo);
        carro.add(acessorio);

        return carroDAO.cadastrar(carro);
    }

    public Acessorio criarAcessorio(String codigo) {
       Acessorio acessorio = new Acessorio();
       acessorio.setCodigo(codigo);
       acessorio.setNome("Escapamento duplo");

       return acessorio;
    }
}
