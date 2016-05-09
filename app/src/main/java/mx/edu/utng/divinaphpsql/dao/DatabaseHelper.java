package mx.edu.utng.divinaphpsql.dao;


import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.edu.utng.divinaphpsql.Contact;


/**
 * Created by MD on 29/02/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String TABLE_NAME_USUARIOS = "Usuario";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    private static final String TABLE_NAME_LOCK = "Bloqueo";
    private static final String COLUMN_LOCK_ID = "id";
    private static final String COLUMN_LOCK = "lock";

    private static final String TABLE_NAME_POINTS = "Puntaje";
    private static final String COLUMN_POINTS_ID = "id";
    private static final String COLUMN_POINTS = "points";

    private static final String TABLE_NAME_CAPITULO = "Capitulo";
    private static final String COLUMN_CAPITULO_ID = "id";
    private static final String COLUMN_CAPITULO = "cap";

    private static final String TABLE_NAME_TEME = "Temas";
    private static final String COLUMN_TEME_ID = "id";
    private static final String COLUMN_TEME = "teme";



    private SQLiteDatabase dbSql;


    private static final String TABLE_CREATE_TEME = "CREATE TABLE "+ TABLE_NAME_TEME +"(" +
            COLUMN_TEME_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_TEME +" INTEGER NOT NULL"+");";

    private static final String TABLE_CREATE_PUNTAJE = "CREATE TABLE "+ TABLE_NAME_POINTS +"(" +
            COLUMN_POINTS_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_POINTS +" INTEGER NOT NULL"+");";

    ///Sintaxis para crear la tabla de usuario
    private static final String TABLE_CREATE_USUARIOS = "create table "+TABLE_NAME_USUARIOS+" (id integer primary key not null , " +
            "name text not null , email text not null , uname text not null , pass text not null);";

    private static final String TABLE_CREATE_BLOQUEO = "CREATE TABLE "+ TABLE_NAME_LOCK +"(" +
            COLUMN_LOCK_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_LOCK +" INTEGER NOT NULL"+");";


    private static final String TABLE_CREATE_CAPITULOS = "CREATE TABLE "+ TABLE_NAME_CAPITULO +"(" +
            COLUMN_CAPITULO_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_CAPITULO +" INTEGER NOT NULL"+");";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        this.dbSql = db;
        db.execSQL(TABLE_CREATE_USUARIOS);
        db.execSQL(TABLE_CREATE_BLOQUEO);
        db.execSQL(TABLE_CREATE_CAPITULOS);
        db.execSQL(TABLE_CREATE_TEME);
        db.execSQL(TABLE_CREATE_PUNTAJE);


        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (1,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (2,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (3,0)");

        db.execSQL("INSERT INTO " + TABLE_NAME_LOCK + " VALUES (1,1)");
        db.execSQL("INSERT INTO " + TABLE_NAME_TEME + " VALUES (1,1)");

    }
   public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
       super(context, name, factory, version);
   }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_CAPITULO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_LOCK);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_POINTS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_TEME);

        this.onCreate(db);

    }


 /*Quizz
    private void addQuestions()
    {

        Question q1;
        //if(a==1) {
            //================Basico de c++============================================
            //Se crean las preguntas con sus posibles resultado y su resultado correcto
            //5
            q1 = new Question("¿Que es PHP? \"int ____ ()\"", "std", "main", "count", "main");
            this.addQuestion(q1);
            q1 = new Question("¿Cuantos bytes ocupa el tipo de dato \"int\"", "2bytes", "8bytes", "4bytes", "4bytes");
            this.addQuestion(q1);

            q1 = new Question("Cual es la principal caracteristica de una constante", "Tiene un valor fijo", "expresa valores diferentes dentro del codigo", "Ninguna", "Tiene un valor fijo");
            this.addQuestion(q1);
            q1 = new Question("para que sirven los operadores en C++", "es mas corto", "es mas internacional", "ambos", "ambos");
            this.addQuestion(q1);

            q1 = new Question("Para que nos sirven la entrada y salida de datos", "para realizar operaciones", "extraer caracteres", "Ninguna", "para realizar operaciones");
            this.addQuestion(q1);


            //================Controles de estructura============================================
            //10
            q1 = new Question("Hay algunos pasos que deben completarse antes de que podamos conseguir a la materia esencial cuantos pasos son. ", "5", "10", "6", "6");
            this.addQuestion(q1);
            q1 = new Question("Este es un paso opcional que le ayudará con las pruebas de su juegos en muchas versiones de la API y tamaños de pantalla.", "Descargar sdk", "openGL", "Crear un emulador.", "Crear un emulador.");
            this.addQuestion(q1);
            q1 = new Question("Este es un paso opcional que le ayudará con las pruebas de su juegos en muchas versiones de la API y tamaños de pantalla.", "Descargar sdk", "openGL", "Crear un emulador.", "Crear un emulador.");
            this.addQuestion(q1);
            q1 = new Question("Este es un paso opcional que le ayudará con las pruebas de su juegos en muchas versiones de la API y tamaños de pantalla.", "Descargar sdk", "openGL", "Crear un emulador.", "Crear un emulador.");
            this.addQuestion(q1);
            q1 = new Question("Este es un paso opcional que le ayudará con las pruebas de su juegos en muchas versiones de la API y tamaños de pantalla.", "Descargar sdk", "openGL", "Crear un emulador.", "Crear un emulador.");
            this.addQuestion(q1);

            //================Componentes de tipos de datos============================================
            //15
            q1 = new Question("Antes de empezar que se tiene que hacer primero de acuerdo a lo leído.", "Abrir el proyecto para empezar a trabajar.", "Descargar aplicaciones.", "Instalar el SDK", "Instalar el SDK");
            this.addQuestion(q1);
            q1 = new Question("¿Que es sdk?", "Herramienta de cómputo", "Programa informático.", "Herramienta que sirve para la creación de nuestro proyecto.", "Herramienta que sirve para la creación de nuestro proyecto.");
            this.addQuestion(q1);
            q1 = new Question("¿Que es sdk?", "Herramienta de cómputo", "Programa informático.", "Herramienta que sirve para la creación de nuestro proyecto.", "Herramienta que sirve para la creación de nuestro proyecto.");
            this.addQuestion(q1);
            q1 = new Question("¿Que es sdk?", "Herramienta de cómputo", "Programa informático.", "Herramienta que sirve para la creación de nuestro proyecto.", "Herramienta que sirve para la creación de nuestro proyecto.");
            this.addQuestion(q1);
            q1 = new Question("¿Que es sdk?", "Herramienta de cómputo", "Programa informático.", "Herramienta que sirve para la creación de nuestro proyecto.", "Herramienta que sirve para la creación de nuestro proyecto.");
            this.addQuestion(q1);


            //================Programacion orientada a objetos============================================
            //20
            q1 = new Question("Por qué es importante configurar tu eclipse ", "Es esencial para la creación del juego.", "Para trabajar más rápido.", "Para así poder usarlo para la creación de juegos.", "Para así poder usarlo para la creación de juegos.");
            this.addQuestion(q1);
            q1 = new Question("En cualquier ide se puede crear un juego.", "Si solo basta con tener un SDK", "Si en cualquiera que se desee.", "Se tiene que tener un configurado el IDE para poder crear un juego.", "Se tiene que tener un configurado el IDE para poder crear un juego.");
            this.addQuestion(q1);
            q1 = new Question("En cualquier ide se puede crear un juego.", "Si solo basta con tener un SDK", "Si en cualquiera que se desee.", "Se tiene que tener un configurado el IDE para poder crear un juego.", "Se tiene que tener un configurado el IDE para poder crear un juego.");
            this.addQuestion(q1);
            q1 = new Question("En cualquier ide se puede crear un juego.", "Si solo basta con tener un SDK", "Si en cualquiera que se desee.", "Se tiene que tener un configurado el IDE para poder crear un juego.", "Se tiene que tener un configurado el IDE para poder crear un juego.");
            this.addQuestion(q1);
            q1 = new Question("En cualquier ide se puede crear un juego.", "Si solo basta con tener un SDK", "Si en cualquiera que se desee.", "Se tiene que tener un configurado el IDE para poder crear un juego.", "Se tiene que tener un configurado el IDE para poder crear un juego.");
            this.addQuestion(q1);
        //}

        //================Conceptos avanzados============================================
        //25
        q1=new Question("Para qué sirve el emulador de Android en el desarrollo de un juego.","Hace más rápido el proceso de la creación del juego.","Es una librería importante en la aplicación.","Para correr nuestra aplicación.","Para correr nuestra aplicación.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);
        q1=new Question("Que parte es importante saber acerca del emulador Android.","Nada todo queda entendido.","Que se debe de instalar siempre después de configurar eclipse.","Que se puede correr la aplicación en un dispositivo real o en emulador.","Que se puede correr la aplicación en un dispositivo real o en emulador.");
        this.addQuestion(q1);

        //30
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //35
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //40
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //45
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //50
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        // 55
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //60
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        //68
        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);





        //================Estandar de librerias============================================

        q1=new Question("¿Que es avd?","Un componente de eclipse.","Una librería.","Conjunto de atributos de configuración aplicado a una imagen emulador.","Conjunto de atributos de configuración aplicado a una imagen emulador.");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
        q1=new Question("Que es lo que ofrece un AVD","Un entorno más cómodo para trabajar.","Se encarga de correr el programa.","Crea dispositivos virtuales","Crea dispositivos virtuales");
        this.addQuestion(q1);
    }
*/

    public void insertContact(Contact c){
        dbSql = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from "+TABLE_NAME_USUARIOS;
        Cursor cursor = dbSql.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        dbSql.insert(TABLE_NAME_USUARIOS, null, values);
        dbSql.close();
    }

    public String searchPass(String uname){
        dbSql = this.getReadableDatabase();

        String query= "select uname, pass from "+ TABLE_NAME_USUARIOS;
        Cursor cursor = dbSql.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;

    }

    public  int  tema (){
        dbSql = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_TEME +" FROM "+ TABLE_NAME_TEME ;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }
    public void actualizarTema(int date){

        dbSql = this.getWritableDatabase();
        //Actualizamos el registro en la base de datos
        dbSql.execSQL("UPDATE "+ TABLE_NAME_TEME +" SET "+ COLUMN_TEME +
                " = "+date+" WHERE id = 1");
        dbSql.close();
    }


    public  int  bloqueo (){
        //Consulta que perite verificar cuales temas estan bloqueados

        dbSql = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_LOCK +" FROM "+ TABLE_NAME_LOCK ;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }

    public void actualizarBloqueo(int date) {
//Consulta que permite actualizar los temas bloqueados
        dbSql = this.getWritableDatabase();

        //Actualizamos el registro en la base de datos
        dbSql.execSQL("UPDATE " + TABLE_NAME_LOCK + " SET " + COLUMN_LOCK +
                " = " + date + " WHERE id = 1");
        dbSql.close();

    }
    //METODO PARA VALIDAR QUE EL USUARIO ESTE REGISTRADO
    public  String  traerNombre(){
        dbSql = this.getReadableDatabase();
        String name="";
        String selectQuery = "SELECT "+COLUMN_NAME+" FROM " + TABLE_NAME_USUARIOS;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                name = cursor.getString(0);
                return name;
            } while (cursor.moveToNext());
        }
        return name;
    }

    //BLOQUEO DE CAPITULOS
    public  int  bloqueoCapitulos (){
        //Consulta que perite verificar cuales temas estan bloqueados

        dbSql = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_LOCK +" FROM "+ TABLE_NAME_LOCK ;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }

    public void actualizarCapitulo(int date) {
//Consulta que permite actualizar los temas bloqueados
        dbSql = this.getWritableDatabase();
        String selectQuery = "SELECT " + COLUMN_LOCK + " FROM " + TABLE_NAME_LOCK;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                    if (score < date) {
                        //Actualizamos el registro en la base de datos
                        dbSql.execSQL("UPDATE " + TABLE_NAME_LOCK + " SET " + COLUMN_LOCK +
                                " = " + date + " WHERE id = 1");
                        dbSql.close();
                    }
                } while (cursor.moveToNext());
            }
        }
    }

    public void actualizarQuiz(double re, int numQuiz){
        dbSql = this.getWritableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_POINTS +" FROM "+ TABLE_NAME_POINTS +" where id="+numQuiz;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                    if(score<re){
                        //Actualizamos el registro en la base de datos
                        dbSql.execSQL("UPDATE "+ TABLE_NAME_POINTS +" SET "+ COLUMN_POINTS +
                                " = "+re+" WHERE id = "+numQuiz);
                        dbSql.close();
                    }
                } while (cursor.moveToNext());
            }
        }
    }

    public  int  traerResult(int id){
        dbSql = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_POINTS +" FROM "+ TABLE_NAME_POINTS +" where id="+id;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }
    public  String  traerEmail(){
        dbSql = this.getReadableDatabase();
        String email="";
        String selectQuery = "SELECT  email FROM " + TABLE_NAME_USUARIOS;
        Cursor cursor = dbSql.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                email = cursor.getString(0);
                return email;
            } while (cursor.moveToNext());
        }
        return email;
    }
    public int porsentajeCurso(){
        int q1 =traerResult(1);
        int q2 =traerResult(2);
        int q3 =traerResult(3);
        int suma;
        int porsentaje;
        suma= q1+q2+q3;
        porsentaje= suma/3;
        return porsentaje;
    }
}
