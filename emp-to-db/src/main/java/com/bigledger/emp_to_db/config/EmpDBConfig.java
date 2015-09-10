package com.bigledger.emp_to_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({ "com.bigledger.emp_to_db.service" })
public class EmpDBConfig {

	@Bean(name = "emp_db")
	public DriverManagerDataSource getEmpDatasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName( ResourceConfig.getDbEmpDriver() );
		datasource.setUrl( ResourceConfig.getDbEmpUrl() );
		datasource.setUsername( ResourceConfig.getDbEmpUsername() );
		datasource.setPassword( ResourceConfig.getDbEmpPassword() );
		return datasource;
	}
	
	@Bean(name="staging_db")
	public DriverManagerDataSource getStagingDbDatasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName( ResourceConfig.getDbStagingDriver() );
		datasource.setUrl( ResourceConfig.getDbStagingUrl() );
		datasource.setUsername( ResourceConfig.getDbStagingUsername() );
		datasource.setPassword( ResourceConfig.getDbStagingPassword() );
		return datasource;
	}
}
