package vn.dotplay.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.dotplay.myapplication.DAO.HoaDonChiTietDAO;
import vn.dotplay.myapplication.DAO.HoaDonDAO;
import vn.dotplay.myapplication.DAO.NguoiDungDAO;
import vn.dotplay.myapplication.DAO.SachDAO;
import vn.dotplay.myapplication.DAO.TheLoaiDAO;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
        db.execSQL(HoaDonDAO.SQL_HOA_DON);
        db.execSQL(HoaDonChiTietDAO.SQL_HOA_DON_CHI_TIET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists "+NguoiDungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheLoaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonChiTietDAO.TABLE_NAME);
        onCreate(db);
    }
}
