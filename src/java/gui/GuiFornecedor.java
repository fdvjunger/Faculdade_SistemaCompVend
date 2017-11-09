/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FornecedorDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Fornecedor;

/**
 *
 * @author acg
 */
@Named(value = "guiFornecedor")
@SessionScoped
public class GuiFornecedor implements Serializable {
    
    @EJB
    FornecedorDao daoFornecedor;
    private Fornecedor fornecedor;
    private List<Fornecedor> lisFornecedor;
    private Boolean alterando;
    
    /**
     * Creates a new instance of GuiCliente
     */
    public GuiFornecedor() {
    }
    
    
    public String iniciarLista() {
        lisFornecedor = daoFornecedor.getList();
        return "ListaFornecedor";
    }
    
    public String iniciarNovo() {
        fornecedor = new Fornecedor();
        alterando = false;
        return "CadFornecedor";
    }

    public String iniciarAlterar(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        alterando = true;
        return "CadFornecedor";
    }
    
    
    public String excluir(Fornecedor fornecedor) {
        daoFornecedor.excluir(fornecedor);
        lisFornecedor = daoFornecedor.getList();
        return null;
    }

    public String gravar() {
        daoFornecedor.gravar(fornecedor, alterando);
        lisFornecedor = daoFornecedor.getList();
        return "ListFornecedor";
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getLisFornecedor() {
        return lisFornecedor;
    }

    public void setLisFornecedor(List<Fornecedor> lisFornecedor) {
        this.lisFornecedor = lisFornecedor;
    }


    
}

