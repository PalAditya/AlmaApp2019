package iitbbs.almafiesta;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.ContentValues.TAG;

public class mapFragment extends Fragment{

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.map, container, false);
        try {
            TouchImageView imageView = view.findViewById(R.id.map);
            //ImageView imageView = view.findViewById(R.id.map);
            String str = HelperClass.getSharedPreferencesString(getActivity(), "Map", "");
            int r = 0;
            if (str.length() != 0)
                r = Integer.parseInt(str);
            if (r == 2)
                imageView.setImageResource(R.drawable.map2);
            else if (r == 3)
                imageView.setImageResource(R.drawable.map3);
            else if (r == 4)
                imageView.setImageResource(R.drawable.map4);
            else if (r == 5)
                imageView.setImageResource(R.drawable.map5);
            else if (r == 6)
                imageView.setImageResource(R.drawable.map6);
        }catch (Exception e)
        {
            Log.e("Touch", e.getMessage());
        }
        return view;
    }
}

/*public class mapFragment extends Fragment implements OnMapReadyCallback {
    private View rootView;
    GoogleMap myMap;
    MapView mMapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            rootView = inflater.inflate(R.layout.map_trial, container, false);
            MapsInitializer.initialize(this.getActivity());
            mMapView =  rootView.findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);
        } catch (InflateException e) {
            Log.e(TAG, "Inflate exception");
        }
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        {
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(20.150193,85.671452)));
            googleMap.addMarker(new MarkerOptions().title("IIT Bhubanneswar").position(new LatLng(20.150193,85.671452)));
        }

    }
}*/