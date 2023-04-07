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
    fun getAllEntriesDefault(): ArrayList<EntryModel>{
        val database: SQLiteDatabase = this.readableDatabase

        val c: Cursor = database.query(
            DbReference.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        val entry: ArrayList<EntryModel> = ArrayList()


        while(c.moveToNext()){
//            var blob = c.getBlob(c.getColumnIndexOrThrow((DbReference.COLUMN_NAME_MODEL)))

            val current = c.getString(c.getColumnIndexOrThrow((DbReference.COLUMN_NAME_DATE)))
            val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
            val formatted = LocalDate.parse(current, formatter)

            val name = c.getString(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_MODEL_NAME))
            val adj = c.getString(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_MODEL_ADJECTIVES))
            val imageID = c.getInt(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_MODEL_IMAGEID))
            val color = c.getInt(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_MODEL_COLOR))

            val adjectiveArray: Array<String>
            adjectiveArray = adj.split("[ ,]").toTypedArray()

            val moodObject: MoodModel
            moodObject = MoodModel(name,imageID, adjectiveArray,color)


        entry.add(EntryModel(
            formatted,
            moodObject,
            c.getString(c.getColumnIndexOrThrow(DbReference.COLUMN_NAME_NOTES)),
            c.getLong(c.getColumnIndexOrThrow(DbReference._ID))
        ))
        }

        c.close()
        database.close()

        return entry
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertEntry(entry: EntryModel){

        val database = this.writableDatabase

        val values = ContentValues()
        values.put(DbReference.COLUMN_NAME_NOTES, entry.notes.toString())

//        Formatting date before inserting in database
        val current = entry.date
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        val formatted = current.format(formatter)
        values.put(DbReference.COLUMN_NAME_DATE, formatted)

        val adjstring = entry.model.adjectives.joinToString()
        values.put(DbReference.COLUMN_NAME_MODEL_NAME, entry.model.name)
        values.put(DbReference.COLUMN_NAME_MODEL_IMAGEID, entry.model.imageId)
        values.put(DbReference.COLUMN_NAME_MODEL_ADJECTIVES, adjstring)
        values.put(DbReference.COLUMN_NAME_MODEL_COLOR, entry.model.color)

//        val model = makebyte(entry.model)
//        values.put(DbReference.COLUMN_NAME_MODEL, model)

        database.insert(DbReference.TABLE_NAME, null, values)
        database.close()
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
        const val DATABASE_VERSION = 3
        const val DATABASE_NAME = "my_database.db"

        const val TABLE_NAME = "entry"
        const val _ID = "id"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_NOTES = "notes"

//        const val COLUMN_NAME_MODEL = "model"

        const val COLUMN_NAME_MODEL_NAME = "name"
        const val COLUMN_NAME_MODEL_IMAGEID = "imageId"
        const val COLUMN_NAME_MODEL_ADJECTIVES = "adjectives"
        const val COLUMN_NAME_MODEL_COLOR = "color"

        const val CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_DATE + " TEXT, " +
                    COLUMN_NAME_NOTES + " TEXT, " +
                    COLUMN_NAME_MODEL_NAME + " TEXT, " +
                    COLUMN_NAME_MODEL_IMAGEID + " TEXT, " +
                    COLUMN_NAME_MODEL_ADJECTIVES + " TEXT, " +
                    COLUMN_NAME_MODEL_COLOR + " TEXT )"

        const val DROP_TABLE_STATEMENT = "DROP TABLE IF EXISTS " + TABLE_NAME
    }
}
