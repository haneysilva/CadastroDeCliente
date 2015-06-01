package com.ifg.haney.cadastrodecliente.Persist;

import com.ifg.haney.cadastrodecliente.Model.Cliente;

import java.util.List;

/**
 * Created by Haney on 21/05/2015.
 */
public interface ClienteDAO {

    public Cliente salvar(Cliente c) throws Exception;

    public void exluir(Cliente c) throws Exception;
    public void exluir(int id) throws Exception;

    public List<Cliente> listarTodos() throws Exception;

    public Cliente buscar(int id) throws Exception;

    public void alterar(Cliente c) throws Exception;

}
