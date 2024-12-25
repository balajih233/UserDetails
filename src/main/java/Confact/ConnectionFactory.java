package Confact;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource ds=null;
	public static Connection getConnection() throws Exception {
		if(ds==null) {
			File f=new File("C:\\Users\\HP\\eclipse-workspace\\Form\\DB.properties");
			FileInputStream fis=new FileInputStream(f);
			Properties p=new Properties();
			p.load(fis);
			String url=p.getProperty("DB.url");
			String uname=p.getProperty("DB.uname");
			String pwd=p.getProperty("DB.pwd");
			HikariConfig conf=new HikariConfig();
			conf.setJdbcUrl(url);
			conf.setUsername(uname);
			conf.setPassword(pwd);
			Class.forName("com.mysql.jdbc.Driver");
			ds=new HikariDataSource(conf);
		}
		return ds.getConnection();
	}
}
