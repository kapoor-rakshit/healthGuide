package rkapoors.healthguide;

/**
 * Created by KAPOOR's on 09-09-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MySampleFragment2 extends Fragment {

    private static View mView;

    /*CONSTRUCTOR

    public static final MySampleFragment newInstance(String sampleText) {
        MySampleFragment f = new MySampleFragment();

        Bundle b = new Bundle();
        b.putString("bString", sampleText);
        f.setArguments(b);

        return f;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.sample_fragment2, container, false);

        //String sampleText = getArguments().getString("bString");      GET from args

        Button nr=(Button)mView.findViewById(R.id.nr);
        nr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nra=new Intent(getActivity(),newrecord.class);
                startActivity(nra);
            }
        });

        Button chk=(Button)mView.findViewById(R.id.chk);
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chka=new Intent(getActivity(),checkrecord.class);
                startActivity(chka);
            }
        });

        return mView;
    }
}
