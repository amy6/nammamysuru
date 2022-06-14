package example.com.cityguide.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.cityguide.R;
import example.com.cityguide.adapter.PlaceAdapter;
import example.com.cityguide.data.PlaceData;
import example.com.cityguide.model.Place;
import example.com.cityguide.utils.Utils;

public class PlaceFragment extends Fragment {
    static String value;
    //no-arg constructor
    public PlaceFragment() {
    }

    public static Fragment newInstance(Bundle args){
// get your data and do whatever

        if (args != null) {
            value = args.getString("key");
        }
        return new PlaceFragment(); }
    /**
     * define inflation logic
     * @param inflater inflater object to inflate new layout
     * @param container viewgroup to which the new layout is to be attached
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     * @return newly inflated view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment, container, false);
    }

    /**
     * access views that have been initialized in the fragment UI
     * @param view reference to fragment view
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        String value = null;
        if (getArguments() != null) {
            value = getArguments().getString("key");
        }
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        Utils.setUpRecyclerView(recyclerView);
        if (getContext() != null ) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new PlaceAdapter(PlaceData.fetchPlaceDetails(value,getContext()), getContext()));
        }
    }

}
