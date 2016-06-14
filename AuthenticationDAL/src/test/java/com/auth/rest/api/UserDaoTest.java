package com.auth.rest.api;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * Description courte de la classe
 *
 * @author mmerabti
 * @since 10 mai 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/appConfig-persistence-test.xml" })
public class UserDaoTest {

    @Test
    public void test() {
        assert true;
    }
}
