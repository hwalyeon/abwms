package kr.co.seculink.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MultipleDataSourceConfiguration {

//	@Bean(name = "writerHikariConfigDif")
//	@ConfigurationProperties(prefix = "spring.datasource.hikari.writer-dif")
//	public HikariConfig writerHikariConfigDif() {
//		return new HikariConfig();
//	}
//
//	@Bean(name = "writerDataSourceDif")
//	public DataSource writerDataSourceDif() throws Exception {
//		return new HikariDataSource(writerHikariConfigDif());
//	}

	@Bean(name = "readerHikariConfigDif")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.reader-dif")
	public HikariConfig readerHikariConfigDif() {
		return new HikariConfig();
	}

	@Bean(name = "readerDataSourceDif")
	public DataSource readerDataSourceDif() throws Exception {
		return new HikariDataSource(readerHikariConfigDif());
	}

	
	
	@Bean(name = "writerHikariConfig")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.hikari.writer-dsv")
	public HikariConfig writerHikariConfig() {
		return new HikariConfig();
	}

	@Bean(name = "writerDataSource")
	@Primary
	public DataSource writerDataSource() throws Exception {
		return new HikariDataSource(writerHikariConfig());
	}

//	@Bean(name = "readerHikariConfig")
//	@ConfigurationProperties(prefix = "spring.datasource.hikari.reader-dsv")
//	public HikariConfig readerHikariConfig() {
//		return new HikariConfig();
//	}
//
//	@Bean(name = "readerDataSource")
//	public DataSource readerDataSource() throws Exception {
//		return new HikariDataSource(readerHikariConfig());
//	}
}
