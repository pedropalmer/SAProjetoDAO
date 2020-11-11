/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.dao;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.internal.runners.statements.ExpectException;

/**
 *
 * @author Pedro
 */
public class PessoaDAOTest {
    
    Pessoa pessoa;
    Pessoa pessoa2;
    
    
    public PessoaDAOTest() {
        pessoa = new Pessoa("Sandra", "Fêssora");
        pessoa2 = new Pessoa("Lzd", "Templar");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConsulta() {
        System.out.println("consulta");
        PessoaDAO instance = new PessoaDAO();
//        if(instance.consulta())
//            System.out.println("Teste ok");
//        else
//            fail("Erro no teste de consulta");
        assertTrue(instance.consulta());        
    }
    
    @Test
    public void testCadastra() {
        System.out.println("cadastra");
        PessoaDAO instance = new PessoaDAO();
        
        assertTrue(instance.cadastra(pessoa));       
    }
    
    @Test
    public void testAltera() {
        System.out.println("altera");
        PessoaDAO instance = new PessoaDAO();
        
        assertTrue(instance.altera(pessoa2));
    }
    
    @Test
    public void testDeleta() {
        System.out.println("deleta");
        PessoaDAO instance = new PessoaDAO();
        
        assertTrue(instance.deleta(pessoa2));
    }
}
