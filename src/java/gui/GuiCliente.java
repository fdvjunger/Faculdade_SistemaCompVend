/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ClienteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Cliente;

/**
 *
 * @author acg
 */
@Named(value = "guiCliente")
@SessionScoped
public class GuiCliente implements Serializable {
    
    @EJB
    ClienteDao daoCliente;
    private Cliente cliente;
    private List<Cliente> lisClientes;
    private Boolean alterando;
    
    /**
     * Creates a new instance of GuiCliente
     */
    public GuiCliente() {
    }
    
    
    public String iniciarLista() {
        lisClientes = daoCliente.getList();
        return "ListaCliente";
    }
    
    public String iniciarNovo() {
        cliente = new Cliente();
        alterando = false;
        return "CadCliente";
    }

    public String iniciarAlterar(Cliente cliente) {
        this.cliente = cliente;
        alterando = true;
        return "CadCliente";
    }
    
    
    public String excluir(Cliente cliente) {
        daoCliente.excluir(cliente);
        lisClientes = daoCliente.getList();
        return null;
    }

    public String gravar() {
        daoCliente.gravar(cliente, alterando);
        lisClientes = daoCliente.getList();
        return "ListaCliente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLisClientes() {
        return lisClientes;
    }

    public void setLisClientes(List<Cliente> lisClientes) {
        this.lisClientes = lisClientes;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }


    
}

