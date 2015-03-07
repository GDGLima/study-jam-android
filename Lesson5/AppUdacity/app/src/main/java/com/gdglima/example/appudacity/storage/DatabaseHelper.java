package com.gdglima.example.appudacity.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gdglima.example.appudacity.model.entity.CursoEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by alienware18 on 9-8-13.
 */
public class DatabaseHelper  extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "studyjam.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
   /* private Dao<OrderTaxiEntity, Integer> commentsDao = null;
    private RuntimeExceptionDao<OrderTaxiEntity, Integer> commentsRuntimeDao = null;

    private Dao<OrderTaxiEntity, Integer> ordertaxiDao = null;
    private RuntimeExceptionDao<OrderTaxiEntity, Integer> ordertaxiRuntimeDao = null;*/

    private Dao<CursoEntity, Integer> cursoDao = null;
    private RuntimeExceptionDao<CursoEntity, Integer> cursoDaoRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            //TableUtils.createTable(connectionSource, OrderTaxiEntity.class);
            TableUtils.createTable(connectionSource, CursoEntity.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        // here we try inserting data in the on-create as a test
        //RuntimeExceptionDao<OrderTaxiEntity, Integer> dao = getCommentsDataDao();
        // create some entries in the onCreate
        /*OrderTaxiEntity order = new OrderTaxiEntity();
        order.setCreationDate(new Date());
        order.setAddress("My Address");
        // OrderTaxiEntity comment = new OrderTaxiEntity("First Test Comment");
        dao.create(order);
        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate");*/
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            //TableUtils.dropTable(connectionSource, OrderTaxiEntity.class, true);
            TableUtils.dropTable(connectionSource, CursoEntity.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */


    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */

    //-------------------------------------------------------------------------------
    public Dao<CursoEntity, Integer> getCursoDao() throws SQLException
    {
        if (cursoDao == null) {
            cursoDao = getDao(CursoEntity.class);
        }
        return cursoDao;
    }

    public RuntimeExceptionDao<CursoEntity, Integer> getCursoDataDao() {
        if (cursoDaoRuntimeDao == null) {
            cursoDaoRuntimeDao = getRuntimeExceptionDao(CursoEntity.class);
        }
        return cursoDaoRuntimeDao;
    }

    //--------------------------------------------------------------------------------

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        cursoDao = null;
        //ordertaxiDao = null;
        //bookingDao = null;
    }

}
