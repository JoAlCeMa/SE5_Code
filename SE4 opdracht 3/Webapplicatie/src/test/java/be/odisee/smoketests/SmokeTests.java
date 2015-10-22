package be.odisee.smoketests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SmokeTests {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(LoginAdminCreateUsers.class);
		suite.addTestSuite(RouteMaken.class);
		suite.addTestSuite(RouteComm.class);
		suite.addTestSuite(RouteField.class);
		suite.addTestSuite(RouteGebrControle.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}