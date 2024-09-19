package com.springmvc.demo;

import com.springmvc.demo.models.Demon;
import com.springmvc.demo.repositories.DemonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

@SpringBootApplication // => Component scan + enableAutoConfiguration + configuration
public class SpringAppMvcApplication implements CommandLineRunner {

	@Autowired
	private DemonRepository _demonRepository; // Object pen to talk to the repositories.

	Logger logger = LoggerFactory.getLogger(SpringAppMvcApplication.class);

	//
	public static void main(String[] args) {SpringApplication.run(SpringAppMvcApplication.class, args);}

	@Override
	public void run(String...args) throws Exception{
		Demon demon = new Demon("Valik", 7.56, 450.56, "Monster of the great plans of Jerginstan");

		//System.out.println(_demonRepository.save(demon)); // sout in Terminal
//		logger.info(_demonRepository.save(demon).toString()); //

	}
}
