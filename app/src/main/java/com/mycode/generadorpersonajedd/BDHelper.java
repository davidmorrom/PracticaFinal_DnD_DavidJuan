package com.mycode.generadorpersonajedd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
    public BDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PERSONAJES = "CREATE TABLE Personajes (" +
                "NombreJugador TEXT," +
                "NombrePersonaje TEXT," +
                "Clase TEXT," +
                "Fuerza INTEGER," +
                "Destreza INTEGER," +
                "Constitucion INTEGER," +
                "Inteligencia INTEGER," +
                "Sabiduria INTEGER," +
                "Carisma INTEGER," +
                "Habilidades TEXT," +
                "PRIMARY KEY (NombreJugador, NombrePersonaje))";
        db.execSQL(CREATE_TABLE_PERSONAJES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Personajes");
        onCreate(db);
    }

    public SQLiteDatabase getBDWriteable() {
        return getWritableDatabase();
    }

    public SQLiteDatabase getBDReadable() {
        return getReadableDatabase();
    }

}
