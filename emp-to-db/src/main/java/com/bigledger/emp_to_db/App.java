package com.bigledger.emp_to_db;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import com.bigledger.emp_to_db.config.EmpDBConfig;
import com.bigledger.emp_to_db.config.MainAppConfig;
import com.bigledger.emp_to_db.service.ProcessBll;

public class App 
{
    public static void main( String[] args )
    {
    	final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // setup configuration
        applicationContext.register( MainAppConfig.class );
        applicationContext.register( EmpDBConfig.class );
        applicationContext.register( ProcessBll.class );
        
        // add CLI property source
        applicationContext.getEnvironment().getPropertySources()
                .addLast(new SimpleCommandLinePropertySource(args));

        // setup all the dependencies (refresh) and make them run (start)
        applicationContext.refresh();
        applicationContext.start();

        try 
        {
        	System.out.println("=========== Welcome to spring application ===========");            
            ProcessBll bll = applicationContext.getBean( ProcessBll.class );
            bll.getEmpData();
        } 
        catch (Exception e) {
        	
        	System.out.println(e.getMessage());
        } 
        finally {
        	
            applicationContext.close();
        }
    }
}
