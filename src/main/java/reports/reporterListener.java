package reports;

import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

public class reporterListener {

	
	
public void generateReport(List xmlSuites, List suites, String outputDirectory) {
		/*
		for(ISuite isuite : suites)
		{
			String  isuiteresult=" " ; 
			Map<String, ISuiteResult> suiteResults = isuite.getResults();
			String sn = isuite.getName();
			
			for(ISuiteResult obj : suiteResults.values())
			{
				ITestContext tc = obj.getTestContext();
				
				System.out.println("Passed Tests of"  + sn + "=" +  tc.getPassedTests().getAllResults().size());
				
				System.out.println("Failed Tests of"  + sn + "=" +  tc.getFailedTests().getAllResults().size());
				
				System.out.println("Skipped Tests of"  + sn + "=" +  tc.getSkippedTests().getAllResults().size());
			}
			
		}
	*/	
		
	}

	
}
