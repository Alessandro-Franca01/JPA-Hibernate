package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.dialect.lock.PessimisticForceIncrementLockingStrategy;

import dominio.Pessoa;

public class Programa {

	// Sistema com acesso ao banco de dados usando o JPA/Hibernate: FUNCIONANDO!!!
	public static void main(String[] args) {
		
		// Nao esta aceitando o parametro null 
		Pessoa pessoa1 = new Pessoa("Alessandro", "Ale@gmail.com");
		Pessoa pessoa2 = new Pessoa("Darcilene", "darci@gmail.com");
		Pessoa pessoa3= new Pessoa("Marcio", "mar@gmail.com");
		
		// Criando os objetos para ter acesso ao banco
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		// Metodo para iniciar essa operação ao banco	
		em.getTransaction().begin();
		
		// Salvando a pessoa no banco de dados
		em.persist(pessoa1);
		em.persist(pessoa2);
		em.persist(pessoa3);
		
		// Metodo para finalizar a operação
		em.getTransaction().commit();
		
		// Fechando conexão
		em.close();
		emf.close();
		
		System.out.println("Dados registrados!!");
	}

}
