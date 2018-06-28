package daraunited.com.fisherinnovapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import daraunited.com.fisherinnovapps.R;


public class OneFragment extends Fragment{

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*CardView Oneacard = (CardView) getView().findViewById(R.id.card_view_one_a);
        Oneacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Calkpage.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        ImageView Oneacard = (ImageView) v.findViewById(R.id.thumbnailConea);
        Oneacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Calkpage.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });
        CardView eOneacard = (CardView) v.findViewById(R.id.card_view_one_a);
        eOneacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Calkpage.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });

        ImageView Oneacardg = (ImageView) v.findViewById(R.id.thumbnailConeag);
        Oneacardg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Evaluateff.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });
        CardView eOneacardg = (CardView) v.findViewById(R.id.card_view_one_agl);
        eOneacardg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Evaluateff.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });

        ImageView Oneacardgd = (ImageView) v.findViewById(R.id.thumbnailConeagd);
        Oneacardgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Costeval.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });
        CardView eOneacardgd = (CardView) v.findViewById(R.id.card_view_one_ag);
        eOneacardgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Costeval.class);
                startActivity(myIntent);
                //StartActivityForResult(myIntent, 0);
            }
        });
        return v;
    }

}
