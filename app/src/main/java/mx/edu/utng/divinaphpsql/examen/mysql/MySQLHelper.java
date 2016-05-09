package mx.edu.utng.divinaphpsql.examen.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.divinaphpsql.examen.Question;

public class MySQLHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "jpa";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // respuesta correcta
	private static final String KEY_OPTA = "opta"; // opcion a
	private static final String KEY_OPTB = "optb"; // opcion b
	private static final String KEY_OPTC = "optc"; // opcion c

	private SQLiteDatabase dbase;

	public MySQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
		db.execSQL(sql);
		addQuestion();
		// db.close();
	}

	private void addQuestion() {
		Question q1 = new Question("¿Que es MySQL?", "Lenguaje de programación",
				"Es un sistema de administarción de Bases de Datos", "Un servidor web",
				"Es un sistema de administarción de Bases de Datos ");
		this.addQuestion(q1);

		Question q2 = new Question("¿En que conciste el software de Base de Datos MySQL?", "Es una asistencia cliente sevidor ya que contiene varias herramientas administrativas",
				"En desarrollar paginas web", "Ninguna de las anteriores",
				"Es una asistencia cliente sevidor ya que contiene varias herramientas administrativas");
		this.addQuestion(q2);

		Question q3 = new Question("CREATE ________ IF NOT EXIST.\nComplete la parte de la sentencia que falta para crear una tabla",
				"DATABASE",
				"TABLA",
				"TABLE",
				"TABLE");
		this.addQuestion(q3);

		Question q4 = new Question("¿Para que sirve la sentencia UPDATE?", "Eliminar duplicados",
				"Para borrar datos", "Actualizar o modificar datos",
				"Actualizar o modificar datos");
		this.addQuestion(q4);

		Question q5 = new Question("INSERT ________ escuela.\nComplete la parte de la sentencia que falta para ingresar valorea a una tabla",
				"INTRO",
				"INTO",
				"DENTRO",
				"INTO");
		this.addQuestion(q5);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());

		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));

				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}


}
