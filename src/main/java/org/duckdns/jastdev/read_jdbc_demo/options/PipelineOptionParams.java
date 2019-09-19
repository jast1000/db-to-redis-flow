package org.duckdns.jastdev.read_jdbc_demo.options;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface PipelineOptionParams extends PipelineOptions {
	
	@Description("Driver class name")
    String getDbDriver();
    void setDbDriver(String driver);

    @Description("Database url")
    String getDbUrl();
    void setDbUrl(String url);
    
    @Description("Database username")
    String getDbUsername();
    void setDbUsername(String username);
    
    @Description("Database password")
    String getDbPassword();
    void setDbPassword(String password);
 
	@Description("Redis host")
	String getRedisHost();
	void setRedisHost(String host);
	
	@Description("Redis port")
	Integer getRedisPort();
	void setRedisPort(Integer port);

}
