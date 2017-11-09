/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProdutoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Produto;

/**
 *
 * @author acg
 */
@Named(value = "guiProduto")
@SessionScoped
public class GuiProduto implements Serializable {
    
    @EJB
    ProdutoDao daoProduto;
    private Produto produto;
    private List<Produto> lisProduto;
    private Boolean alterando;
    
    /**
     * Creates a new instance of GuiCliente
     */
    public GuiProduto() {
    }
    
    
    public String iniciarLista() {
        lisProduto = daoProduto.getList();
        return "ListaProduto";
    }
    
    public String iniciarNovo() {
        produto = new Produto();
        alterando = false;
        return "CadProduto";
    }

    public String iniciarAlterar(Produto produto) {
        this.produto = produto;
        alterando = true;
        return "CadProduto";
    }
    
    
    public String excluir(Produto produto) {
        daoProduto.excluir(produto);
        lisProduto = daoProduto.getList();
        return null;
    }

    public String gravar() {
        daoProduto.gravar(produto, alterando);
        lisProduto = daoProduto.getList();
        return "ListaProduto";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getLisProduto() {
        return lisProduto;
    }

    public void setLisProduto(List<Produto> lisProduto) {
        this.lisProduto = lisProduto;
    }


    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }


    
}

