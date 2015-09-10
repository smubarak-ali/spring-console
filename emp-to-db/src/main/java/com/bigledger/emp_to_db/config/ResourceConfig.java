package com.bigledger.emp_to_db.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

@Configuration
public class ResourceConfig {

	private static final String APPLICATION_PROPERTIES = "application.properties";

	private static final String DB_EMP_DRIVER = "db.emp.driver";
	private static final String DB_EMP_URL = "db.emp.url";
	private static final String DB_EMP_USERNAME = "db.emp.username";
	private static final String DB_EMP_PASSWORD = "db.emp.password";

	private static final String DB_STAGING_DRIVER = "db.staging.driver";
	private static final String DB_STAGING_URL = "db.staging.url";
	private static final String DB_STAGING_USERNAME = "db.staging.username";
	private static final String DB_STAGING_PASSWORD = "db.staging.password";

	private static final String EMP_DATABASE = "emp.database";
	private static final String STAGING_DATABASE = "staging.database";

	private static String dbEmpDriver;
	private static String dbEmpUrl;
	private static String dbEmpUsername;
	private static String dbEmpPassword;

	private static String dbStagingDriver;
	private static String dbStagingUrl;
	private static String dbStagingUsername;
	private static String dbStagingPassword;

	private static String empDatabase;
	private static String stagingDatabase;

	static{
		initData();
	}

	public ResourceConfig() {
		super();
	}

	private static void initData() {

		try {

			Properties  properties = PropertiesLoaderUtils.loadAllProperties(APPLICATION_PROPERTIES);

			setDbEmpDriver( properties.getProperty(DB_EMP_DRIVER).trim() );
			setDbEmpUrl( properties.getProperty(DB_EMP_URL).trim() );
			setDbEmpUsername( properties.getProperty(DB_EMP_USERNAME).trim() );
			setDbEmpPassword( properties.getProperty(DB_EMP_PASSWORD).trim() );

			setDbStagingDriver( properties.getProperty(DB_STAGING_DRIVER).trim() );
			setDbStagingUrl( properties.getProperty(DB_STAGING_URL).trim() );
			setDbStagingUsername( properties.getProperty(DB_STAGING_USERNAME).trim() );
			setDbStagingPassword( properties.getProperty(DB_STAGING_PASSWORD).trim() );

			setEmpDatabase( properties.getProperty( EMP_DATABASE ).trim() );
			setStagingDatabase( properties.getProperty( STAGING_DATABASE ).trim() );
		} 
		catch (IOException e) {

			e.printStackTrace();
			throw new RuntimeException("load file application.properties error : ", e);
		}
	}

	public static String getDbEmpDriver() {
		return dbEmpDriver;
	}

	public static String getDbEmpUrl() {
		return dbEmpUrl;
	}

	public static String getDbEmpUsername() {
		return dbEmpUsername;
	}

	public static String getDbEmpPassword() {
		return dbEmpPassword;
	}

	public static String getDbStagingDriver() {
		return dbStagingDriver;
	}

	public static String getDbStagingUrl() {
		return dbStagingUrl;
	}

	public static String getDbStagingUsername() {
		return dbStagingUsername;
	}

	public static String getDbStagingPassword() {
		return dbStagingPassword;
	}

	public static String getEmpDatabase() {
		return empDatabase;
	}

	public static String getStagingDatabase() {
		return stagingDatabase;
	}

	public static void setDbEmpDriver(String dbEmpDriver) {
		ResourceConfig.dbEmpDriver = dbEmpDriver;
	}

	public static void setDbEmpUrl(String dbEmpUrl) {
		ResourceConfig.dbEmpUrl = dbEmpUrl;
	}

	public static void setDbEmpUsername(String dbEmpUsername) {
		ResourceConfig.dbEmpUsername = dbEmpUsername;
	}

	public static void setDbEmpPassword(String dbEmpPassword) {
		ResourceConfig.dbEmpPassword = dbEmpPassword;
	}

	public static void setDbStagingDriver(String dbStagingDriver) {
		ResourceConfig.dbStagingDriver = dbStagingDriver;
	}

	public static void setDbStagingUrl(String dbStagingUrl) {
		ResourceConfig.dbStagingUrl = dbStagingUrl;
	}

	public static void setDbStagingUsername(String dbStagingUsername) {
		ResourceConfig.dbStagingUsername = dbStagingUsername;
	}

	public static void setDbStagingPassword(String dbStagingPassword) {
		ResourceConfig.dbStagingPassword = dbStagingPassword;
	}

	public static void setEmpDatabase(String empDatabase) {
		ResourceConfig.empDatabase = empDatabase;
	}

	public static void setStagingDatabase(String stagingDatabase) {
		ResourceConfig.stagingDatabase = stagingDatabase;
	}

	
}
