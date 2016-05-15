package sjsu.se137.group3.mytube;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by SHEETHAL on 4/28/2016.
 */
public class Database extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "mytube.db";
        public static final String TABLE1_NAME = "user";
        public static final String USER_COL_1 = "islogin";
        public static final String TABLE2_NAME = "favoritevideos";
        public static final String FAVORITEVIDEOS_COL_1 = "id";
        public static final String FAVORITEVIDEOS_COL_2 = "link";

        public Database(Context context) {
            super(context, DATABASE_NAME, null, 1);
            SQLiteDatabase db = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE1 " + TABLE1_NAME +
                    " ( " + USER_COL_1 + "IS LOG IN) ");
            db.execSQL("CREATE TABLE2 " + TABLE2_NAME + " ( " + "FAVORITED VIDEOS COL1: "
                    + FAVORITEVIDEOS_COL_1 + " ID.  FAVORITEVIDEOS COL 2: " + FAVORITEVIDEOS_COL_2 + " LINK.  )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

}
