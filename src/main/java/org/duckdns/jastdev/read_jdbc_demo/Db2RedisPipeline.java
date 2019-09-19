package org.duckdns.jastdev.read_jdbc_demo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.duckdns.jastdev.read_jdbc_demo.configurations.DatabaseConfiguration;
import org.duckdns.jastdev.read_jdbc_demo.configurations.RedisConfiguration;
import org.duckdns.jastdev.read_jdbc_demo.options.PipelineOptionParams;
import org.duckdns.jastdev.read_jdbc_demo.transforms.StudentReader;
import org.duckdns.jastdev.read_jdbc_demo.transforms.StudentSaver;

/**
 * Read jdbc pipeline
 *
 */
public class Db2RedisPipeline {

	public static void main(String[] args) {
		PipelineOptionParams pipelineOptionParams = PipelineOptionsFactory
				.fromArgs(args)
				.withValidation()
				.as(PipelineOptionParams.class);
		
		DatabaseConfiguration.initialize(pipelineOptionParams);
		RedisConfiguration.initialize(pipelineOptionParams);
		
		PipelineOptions options = PipelineOptionsFactory.create();
		
		Pipeline pipeline = Pipeline.create(options);

		pipeline
			.apply(StudentReader.read())
			.apply(ParDo.of(new StudentSaver()));
		
		pipeline.run().waitUntilFinish();
	}

}
