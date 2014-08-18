/**
 * 
 */
package test.nl.pczeeuw.boeken.model.db;

import nl.pczeeuw.boeken.model.db.DB;

import org.junit.Before;
import org.junit.Test;

/**
 * Class description
 * 
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public class DBTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
	DB.getInstance().getBankConnection();
    }

}
