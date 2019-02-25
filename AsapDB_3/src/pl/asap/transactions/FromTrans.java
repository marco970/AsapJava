package pl.asap.transactions;

import java.util.List;

import org.hibernate.query.Query;

import pl.asap.entity.Lista;

public class FromTrans extends TransBlank {
	
	
	public FromTrans(String hibernateConf, Object bean)	{
		super(hibernateConf, bean);
		
		session.beginTransaction();
		
		String from = "from Lista";
		Query query = session.createQuery(from);
		
		List<Lista> list = query.getResultList();

		session.getTransaction().commit();
		
		for(Lista lista : list) {
			System.out.println(lista);
		}

		// zamkniêcie obiektu SessionFactory
		factory.close();
	}
	

}
