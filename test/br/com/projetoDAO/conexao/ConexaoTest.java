
package br.com.projetoDAO.conexao;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConexaoTest {
    
    public ConexaoTest() {
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

    /**
     * Test of conectar method, of class Conexao.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        Connection expResult = null;
        Connection result = Conexao.conectar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectar method, of class Conexao.
     */
    @Test
    public void testDesconectar() {
        System.out.println("desconectar");
        Connection conexao = null;
        Conexao.desconectar(conexao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
