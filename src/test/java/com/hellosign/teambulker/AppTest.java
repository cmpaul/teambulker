package com.hellosign.teambulker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private App app;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // App can be instantiated
        MockClient client = new MockClient("API_KEY");
        app = new App(client);
        assertNotNull(app);
    }

    /**
     * Rigourous Test :-)
     */
    public void testAppInvite() {
        // App can invite user with email
        assertTrue(app.addTeamMember("test+1@hellosign.com"));
    }
    
    public void testAppValidation() {
        assertTrue(!app.addTeamMember("invalidemail"));
    }
}
