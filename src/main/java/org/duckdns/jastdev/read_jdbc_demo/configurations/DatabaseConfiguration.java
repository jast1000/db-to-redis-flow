package org.duckdns.jastdev.read_jdbc_demo.configurations;

import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.io.jdbc.JdbcIO.DataSourceConfiguration;
import org.duckdns.jastdev.read_jdbc_demo.options.PipelineOptionParams;

public class DatabaseConfiguration {
	
	private static DataSourceConfiguration datasource;
	
	public static void initialize(PipelineOptionParams options) {
		datasource = JdbcIO.DataSourceConfiguration
				.create(options.getDbDriver(), options.getDbUrl())
				.withUsername(options.getDbUsername())
				.withPassword(options.getDbPassword());
	}
	
	public static DataSourceConfiguration getDatasource() {
		return datasource;
	}

}
