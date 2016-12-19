package id.fikri.navigationdrawerapp.Fragmrnt;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.fikri.navigationdrawerapp.R;

/**
 * Created by lowercase on 16/12/16.
 */

public class Profile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_profile, container, false);
        return viewRoot;
    }
}
