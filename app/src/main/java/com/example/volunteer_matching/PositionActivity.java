package com.example.volunteer_matching;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PositionActivity extends FragmentActivity implements
        GoogleMap.OnMapClickListener, OnMapReadyCallback {

    private GoogleMap mGoogleMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "k",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_position);

        Toast.makeText(getApplicationContext(), "a",Toast.LENGTH_SHORT).show();
        // BitmapDescriptorFactory 생성하기 위한 소스
        MapsInitializer.initialize(getApplicationContext());

        Toast.makeText(getApplicationContext(), "b",Toast.LENGTH_SHORT).show();

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        Toast.makeText(getApplicationContext(), "c",Toast.LENGTH_SHORT).show();
        mapFragment.getMapAsync(this);
        Toast.makeText(getApplicationContext(), "d",Toast.LENGTH_SHORT).show();

        init();
        Toast.makeText(getApplicationContext(), "e",Toast.LENGTH_SHORT).show();
    }

    /** Map 클릭시 터치 이벤트 */
    public void onMapClick(LatLng point) {

        // 현재 위도와 경도에서 화면 포인트를 알려준다
        Point screenPt = mGoogleMap.getProjection().toScreenLocation(point);

        // 현재 화면에 찍힌 포인트로 부터 위도와 경도를 알려준다.
        LatLng latLng = mGoogleMap.getProjection().fromScreenLocation(screenPt);

        Log.d("맵좌표", "좌표: 위도(" + String.valueOf(point.latitude) + "), 경도("
                + String.valueOf(point.longitude) + ")");
        Log.d("화면좌표", "화면좌표: X(" + String.valueOf(screenPt.x) + "), Y("
                + String.valueOf(screenPt.y) + ")");
    }

    /**
     * 초기화
     * @author
     */
    private void init() {

        GooglePlayServicesUtil.isGooglePlayServicesAvailable(PositionActivity.this);


        // 맵의 이동
        //mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));

        GpsInfo gps = new GpsInfo(PositionActivity.this);
        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude, longitude);

            // Showing the current location in Google Map
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // Map 을 zoom 합니다.
            mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(13));

            // 마커 설정.
            MarkerOptions optFirst = new MarkerOptions();
            optFirst.position(latLng);// 위도 • 경도
            optFirst.title("Current Position");// 제목 미리보기
            optFirst.snippet("Snippet");
            optFirst.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
            mGoogleMap.addMarker(optFirst).showInfoWindow();
        }
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setMyLocationEnabled(true);
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
