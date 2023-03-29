package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

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

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllEntriesDefault() {
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


        while(c.moveToNext()){
            var blob = c.getBlob(c.getColumnIndexOrThrow((DbReference.COLUMN_NAME_MODEL)))

            val current = c.getString(c.getColumnIndexOrThrow((DbReference.COLUMN_NAME_DATE)))
            val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
            val formatted = LocalDate.parse(current, formatter)

        entry.add(EntryModel(
            formatted,
            read(blob),
            c.getString(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_NOTES)),
        ))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertEntry(entry: EntryModel){

        val database = this.writableDatabase

        val values = ContentValues()
        values.put(DbReference.COLUMN_NAME_NOTES, entry.notes)

//        Formatting date before inserting in database
        val current = entry.date
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        val formatted = current.format(formatter)
        values.put(DbReference.COLUMN_NAME_DATE, formatted)

        val model = makebyte(entry.model)
        values.put(DbReference.COLUMN_NAME_MODEL, model)

    }

    fun makebyte(modeldata: MoodModel): ByteArray? {
        try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(modeldata)
            val employeeAsBytes: ByteArray = baos.toByteArray()
            val bais = ByteArrayInputStream(employeeAsBytes)
            return employeeAsBytes
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    fun read(data: ByteArray?): MoodModel {
            val baip = ByteArrayInputStream(data)
            val ois = ObjectInputStream(baip)
            return ois.readObject() as MoodModel
    }

    private object DbReference{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "my_database.db"

        const val TABLE_NAME = "entry"
        const val _ID = "id"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_NOTES = "notes"

        const val COLUMN_NAME_MODEL = "model"

//        const val COLUMN_NAME_MODEL_NAME = "name"
//        const val COLUMN_NAME_MODEL_IMAGE = "image"
//        const val COLUMN_NAME_MODEL_ADJECTIVES = "adjectives"
//        const val COLUMN_NAME_MODEL_COLOR = "color"

        const val CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_DATE + " TEXT, " +
                    COLUMN_NAME_NOTES + " TEXT, " +
                    COLUMN_NAME_MODEL + " TEXT)"

        const val DROP_TABLE_STATEMENT = "DROP TABLE IF EXISTS " + TABLE_NAME
    }
}
