/**
 * @author João Paulo
 */

package br.com.paulo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    private String modelo;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "tb_carro_acessorio",
            joinColumns = { @JoinColumn(name = "id_carro_fk") },
            inverseJoinColumns =  { @JoinColumn(name = "id_acessorio_fk") })
    private List<Acessorio> acessorios;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Carro() {
        this.acessorios = new ArrayList<>();
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}
