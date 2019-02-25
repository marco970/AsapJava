package pl.test;

import pl.asap.DB.DBConnect;
import pl.asap.entity.Lista;
import pl.asap.transactions.FromTrans;
import pl.asap.transactions.SaveTrans;

public class AsapStart {

	public static void main(String[] args) {
		DBConnect a = new DBConnect();
		//new TestStarter();
		Lista lista = new Lista();
		new FromTrans("hibernate.cfg.xml", lista);
		
		//new SaveTrans("hibernate.cfg.xml", lista, "ZZ", "ZZ/PLI0006568");
		//a.zabij();
		

	}

}
