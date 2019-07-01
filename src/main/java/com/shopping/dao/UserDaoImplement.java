package com.shopping.dao;

import com.shopping.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.lang.model.element.NestingKind;
import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
@Repository
public class UserDaoImplement implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        String hql = "from User where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);

        return (User)query.uniqueResult();
    }

    @Override
    public User getUser(String nameOrEmail) {
        String hql = "from User where email=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, nameOrEmail);
        if(query.uniqueResult() == null){
            hql = "from User where name=?";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter(0, nameOrEmail);
        }
        return (User)query.uniqueResult();
    }

    @Override
    public boolean addUser(User user) {
        String hql = "from User where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,user.getId());
        String hql1 = "from User where name=?";
        Query query1 = sessionFactory.getCurrentSession().createQuery(hql1);
        query1.setParameter(0,user.getName());
        String hql2 = "from User where email = ?";
        Query query2 = sessionFactory.getCurrentSession().createQuery(hql2);
        query2.setParameter(0,user.getEmail());
        if((query.uniqueResult()!=null)||(query1.uniqueResult()!=null)||(query2.uniqueResult()!=null)){
            return false;
        }else if((user.getName()==null)||user.getEmail()==null){
            return false;
        }else{
            sessionFactory.getCurrentSession().save(user);
            return true;
        }

    }

    @Override
    public boolean deleteUser(int id) {
        String hql1 = "from User where id=?";
        Query query1 = sessionFactory.getCurrentSession().createQuery(hql1);
        query1.setParameter(0,id);
        if(query1.uniqueResult()==null)
            return false;
        else{
            String hql = "delete User where id=?";
            Query  query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter(0,id);
            int isDelte = query.executeUpdate();
            return isDelte>0;
        }

    }

    @Override
    public boolean updateUser(User user) {
        String hql = "update User set name = ?,email=?,nickName=? ,role=? where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,user.getName());
        query.setParameter(1,user.getEmail());
        query.setParameter(2,user.getNickName());
        query.setParameter(3,user.getRole());
        query.setParameter(4,user.getId());
        int isUpdate = query.executeUpdate();
        return isUpdate>0;
    }

    @Override
    public List<User> getAllUser() {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
