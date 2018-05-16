package com.jmeter.javasamplers.example;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContextService;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class js1 extends AbstractJavaSamplerClient {

    @Override
    public void setupTest(JavaSamplerContext context) {
        super.setupTest(context);
       
//        
//        try {
//        	File f = new File("C:\\fixfiles\\f2.fix.txt");
//    		BufferedReader	inputStream = new BufferedReader(new FileReader(f));
//    		// Put in the context of thread group
//    	    JMeterContextService.getContext().getVariables().putObject("inputStream", inputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

	// public Arguments getDefaultParameters() {
	//
	// Arguments arguments = new Arguments();
	// // arguments.addArgument("fixmsg","${__StringFromFile("+fixFilePath+",,,)}"
	// );
	// arguments.addArgument("fixmessage","${message}" );
	// return arguments;
	// }

	
	public void testStarted() throws FileNotFoundException {
//		File f = new File("C:\\fixfiles\\f2.fix.txt");
//		BufferedReader	inputStream = new BufferedReader(new FileReader(f));
//		// Put in the context of thread group
//	    JMeterContextService.getContext().getVariables().putObject("inputStream", inputStream);

	}

	@Override
	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
		
		final SampleResult sampleResult = new SampleResult();

		sampleResult.sampleStart();
		BufferedReader inputStream = (BufferedReader) JMeterContextService.getContext().getVariables().getObject("inputStream");
		// String fixmsg = javaSamplerContext.getParameter("fixmessage");
		// File f = new File("C:\\fixfiles\\f2.fix.txt");
		// if(f.isFile()) {

		try {
			// inputStream = new BufferedReader(new FileReader(f));
			String line = inputStream.readLine();
			sampleResult.setResponseMessage(line);
			sampleResult.setSuccessful(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return sampleResult;
	}

}
