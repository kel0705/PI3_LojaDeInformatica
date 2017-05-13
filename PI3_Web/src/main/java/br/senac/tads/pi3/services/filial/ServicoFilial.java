/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.services.filial;

import br.senac.tads.pi3.db.dao.DaoFilial;
import br.senac.tads.pi3.exceptions.DataSourceException;
import br.senac.tads.pi3.exceptions.FilialException;
import br.senac.tads.pi3.model.filial.Filial;
import java.util.List;

/**
 *
 * @author Nataly
 */
public class ServicoFilial {
    public static void inserirFilial(Filial filial)
            throws FilialException, DataSourceException {
        if (filial == null) {
            throw new FilialException("Filial nao informada");
        }else if (filial.getNomeFilial()== null || "".equals(filial.getNomeFilial())) {
            throw new FilialException("É necessário informar o nome da filial");
        }else if ( filial.getCnpj() ==  0) {
            throw new FilialException("Cnpj invalido");
        }else  if  (filial.getNomeFantasia()== null || "".equalsIgnoreCase(filial.getNomeFantasia())) {
            throw new FilialException("É necessário informar o nome fantasia da filial");
        }else{
            try {
                DaoFilial.inserirFilial(filial);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }

    public static void atualizarFilial(Filial filial) throws FilialException, DataSourceException {
        
        if (filial == null) {
            throw new FilialException("Não foi informado a filial");
        }else if (filial.getNomeFilial()== null || "".equalsIgnoreCase(filial.getNomeFilial())) {
            throw new FilialException("É necessário informar um nome da filial");
        }else if (filial.getNomeFantasia()== null || "".equalsIgnoreCase(filial.getNomeFantasia())) {
            throw new FilialException("É necessário informar nome fantasia da filial");
        }else if (filial.getCnpj() == 0) {
            throw new FilialException("É necessário informar o cnpj");
        }else {
            try {
                DaoFilial.atualizarFilial(filial);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
        
    }

    public static List<Filial> procurarFilial(int cnpj) throws FilialException, DataSourceException {
        try {
            if (cnpj == 0) {
                return DaoFilial.listarFiliais();
            } else {
                return DaoFilial.procurarFilialPorCNPJ(cnpj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o produto com ID informado do banco de dados
    public static void excluirFilial(Integer cnpj)
            throws FilialException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do produto informado
            DaoFilial.excluirFilial(cnpj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
}