package com.infozup.cadastrocliente;

import com.infozup.cadastrocliente.domain.entity.Address;
import com.infozup.cadastrocliente.domain.entity.Contact;
import com.infozup.cadastrocliente.domain.entity.Person;
import com.infozup.cadastrocliente.domain.repository.AddressRepository;
import com.infozup.cadastrocliente.domain.repository.ContactRepository;
import com.infozup.cadastrocliente.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class PocCadastroClienteApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {

		SpringApplication.run(PocCadastroClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Address a = new Address(null,"Rua Otacilio Pedro Vasco","110","próximo posto de saúde","Rio de Janeiro","RJ","21635440");
		Address a1 = new Address(null,"Rua Otacilio Pedro Vasco","111","próximo posto de saúde","Nova iguaçu","RJ","21635441");
		Address a2 = new Address(null,"Rua Otacilio Pedro Vasco","112","próximo posto de saúde","Niterói","RJ","21635442");

		addressRepository.saveAll(Arrays.asList(a,a1,a2));

		Contact c1 = new Contact(null,"982380946",null,"caka19@hotmail.com");
		Contact c2 = new Contact(null,"982380947",null,"caka19@hotmail.com");
		Contact c3 = new Contact(null,"982380948",null,"caka19@hotmail.com");

		contactRepository.saveAll(Arrays.asList(c1,c2,c3));

		Person p = new Person(null,"Carlos","11792993706","Carlos", LocalDate.of(1985,12,11), LocalDate.now());
		Person p1 = new Person(null,"Roberto Carlos","11792993707","Betinho", LocalDate.of(1985,12,11), LocalDate.now());
		Person p2 = new Person(null,"Renato","11792993708","Renatinho", LocalDate.of(1985,12,11), LocalDate.now());
		Person p3 = new Person(null,"Igor","11792993709","Coelho", LocalDate.of(1985,12,11), LocalDate.now());

		p.setAddress(a);
		p1.setAddress(a1);
		p2.setAddress(a2);
		p3.setAddress(a);

		p.setContact(c1);
		p1.setContact(c2);
		p2.setContact(c3);
		p3.setContact(c1);

		personRepository.saveAll(Arrays.asList(p,p1,p2,p3));

	}
}
