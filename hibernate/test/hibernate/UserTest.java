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
		//�������ö���  ��ȡhibernate.cfg.xml�ļ�����ɳ�ʼ����
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//�����Ự��������
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//�Ự����
		session=sessionFactory.openSession();
		//��������
		transaction=session.beginTransaction();
	}
	
	@After
	public void destroy(){
		
		transaction.commit();//�ύ����
		session.close();//�رջỰ
		sessionFactory.close();//�رջỰ����
		
	}
	
	@Test
	public void testSaveUser(){
		LibraryId library=new LibraryId("lxy","0416","Forever");
		Library l=new Library(library);
		SongId s=new SongId("�����ʥ",99);
		Song song=new Song(s);
		session.save(song);//�������������ݿ�
		session.save(l);
		
	}

}
