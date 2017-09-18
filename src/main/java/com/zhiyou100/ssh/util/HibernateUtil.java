package com.zhiyou100.ssh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory FAVTORy;
	static {
		Configuration conf = new Configuration().configure();
		FAVTORy = conf.buildSessionFactory();
	}

	public static Session opensession() {
		/*
		 * Configuration conf = new Configuration().configure(); SessionFactory
		 * factory = conf.buildSessionFactory(); Session session =
		 * factory.openSession();
		 */
		return FAVTORy.openSession();
	}

}
