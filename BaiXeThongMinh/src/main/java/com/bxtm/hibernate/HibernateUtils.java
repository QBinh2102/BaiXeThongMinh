/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.hibernate;

import com.bxtm.pojo.Baidoxe;
import com.bxtm.pojo.Booking;
import com.bxtm.pojo.Chodoxe;
import com.bxtm.pojo.Danhgia;
import com.bxtm.pojo.Giaca;
import com.bxtm.pojo.Loaixe;
import com.bxtm.pojo.Nguoidung;
import com.bxtm.pojo.Soden;
import com.bxtm.pojo.Thanhtoan;
import com.bxtm.pojo.Thongbao;
import com.bxtm.pojo.Xe;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author GIGA
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.JAKARTA_JDBC_DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_URL,"jdbc:mysql://localhost/baixedb");
        props.put(Environment.JAKARTA_JDBC_USER,"root");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "admin@123");
        props.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Baidoxe.class);
        conf.addAnnotatedClass(Chodoxe.class);
        conf.addAnnotatedClass(Booking.class);
        conf.addAnnotatedClass(Danhgia.class);
        conf.addAnnotatedClass(Giaca.class);
        conf.addAnnotatedClass(Loaixe.class);
        conf.addAnnotatedClass(Nguoidung.class);
        conf.addAnnotatedClass(Soden.class);
        conf.addAnnotatedClass(Thanhtoan.class);
        conf.addAnnotatedClass(Thongbao.class);
        conf.addAnnotatedClass(Xe.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
