package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.model.Library;
import com.model.LibraryId;
import com.model.Song;
import com.model.SongId;

public class UserTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;;
	
	
	@Before
	public void init(){
		//创建配置对象  读取hibernate.cfg.xml文件，完成初始化。
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//会话对象
		session=sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
	}
	
	@After
	public void destroy(){
		
		transaction.commit();//提交事务
		session.close();//关闭会话
		sessionFactory.close();//关闭会话工厂
		
	}
	
	@Test
	public void testSaveUser(){
		LibraryId library=new LibraryId("lxy","0416","Forever");
		Library l=new Library(library);
		SongId s=new SongId("齐天大圣",99);
		Song song=new Song(s);
		session.save(song);//保存对象进入数据库
		session.save(l);
		
	}

}
