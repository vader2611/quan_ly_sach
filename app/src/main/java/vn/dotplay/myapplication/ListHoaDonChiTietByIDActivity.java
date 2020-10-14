package vn.dotplay.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.List;

import vn.dotplay.myapplication.Adapter.CartAdapter;
import vn.dotplay.myapplication.DAO.HoaDonChiTietDAO;
import vn.dotplay.myapplication.MODER.HoaDonChiTiet;

public class ListHoaDonChiTietByIDActivity extends AppCompatActivity {
    public List<HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    CartAdapter adapter = null;
    HoaDonChiTietDAO hoaDonChiTietDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don_chi_tiet_by_id);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        lvCart = (ListView) findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(ListHoaDonChiTietByIDActivity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT = hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new CartAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);

}
}
