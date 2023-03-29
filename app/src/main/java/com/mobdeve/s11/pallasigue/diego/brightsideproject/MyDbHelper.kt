package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context?) : SQLiteOpenHelper(context, DbReference.DATABASE_NAME, null, DbReference.DATABASE_VERSION) {

    companion object {
        private var instance: MyDbHelper? = null

        @Synchronized
        fun getInstance(context: Context): MyDbHelper? {
            if (instance == null) {
                instance = MyDbHelper(context.applicationContext)
            }
            return instance
        }
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(DbReference.CREATE_TABLE_STATEMENT)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL(DbReference.DROP_TABLE_STATEMENT)
        onCreate(sqLiteDatabase)
    }

    fun getAllEntriesDefault(): ArrayList<EntryModel> {
        val database: SQLiteDatabase = this.readableDatabase

        val c: Cursor = database.query(
            DbReference.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            DbReference.COLUMN_NAME_DATE + "ASC",
            null
        )

        val entry: ArrayList<EntryModel> = ArrayList()
        val mood: MoodModel

        while(c.moveToNext()){
        entry.add(EntryModel(
            c.get
            c.getString(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_NOTES)),
        ))
        }
    }

    private object DbReference{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "my_database.db"

        const val TABLE_NAME = "entry"
        const val _ID = "id"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_NOTES = "notes"
        const val COLUMN_NAME_MODEL = "model"

        const val CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_DATE + " TEXT, " +
                    COLUMN_NAME_NOTES + " TEXT, " +
                    COLUMN_NAME_MODEL + " TEXT)"

        const val DROP_TABLE_STATEMENT = "DROP TABLE IF EXISTS " + TABLE_NAME
    }
}