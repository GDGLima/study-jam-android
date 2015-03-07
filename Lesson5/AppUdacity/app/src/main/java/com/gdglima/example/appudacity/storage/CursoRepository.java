package com.gdglima.example.appudacity.storage;

import android.content.Context;

import com.gdglima.example.appudacity.model.entity.CursoEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by alienware18 on 9-8-13.
 */
public class CursoRepository {

    private DatabaseHelper db;
    Dao<CursoEntity, Integer> cursoDao;

    public Dao<CursoEntity, Integer> getBookingDao() {
        return cursoDao;
    }

    public CursoRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            cursoDao = db.getCursoDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int create(CursoEntity comment)
    {
        try {
            return cursoDao.create(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int update(CursoEntity comment)
    {
        try {
            return cursoDao.update(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(CursoEntity comment)
    {
        try {
            return cursoDao.delete(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<CursoEntity> getAll()
    {
        try {
            return cursoDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

   /* public int getCount()
    {
        int total = bookingDao.queryBuilder().("select count(*)");
        return total;
    }*/

    public CursoEntity getById(String idBooking)
    {
        try {
            QueryBuilder<CursoEntity, Integer> qb = cursoDao.queryBuilder();
            qb.where().eq("id", idBooking);

            PreparedQuery<CursoEntity> pq = qb.prepare();
            return cursoDao.queryForFirst(pq);

        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<CursoEntity> getQuery(QueryBuilder<CursoEntity, Integer> queryBuilder)
    {
        try {
            PreparedQuery<CursoEntity> preparedQuery = queryBuilder.prepare();
            return cursoDao.query(preparedQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
