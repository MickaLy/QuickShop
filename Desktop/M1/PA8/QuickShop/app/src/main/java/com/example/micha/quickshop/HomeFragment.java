package com.example.micha.quickshop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.micha.entity.OnMyFragmentEvent;
import com.example.micha.entity.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private OnMyFragmentEvent eventListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        System.out.println("test");

        /***** *****/
        Product prod1, prod2, prod3, prod4, prod5, prod6;
        prod1 = new Product(R.drawable.bomber, "bomber", "49e99", "Bomber Kaki");
        prod2 = new Product(R.drawable.casque_beats, "casque beats", "89e99", "Casque Beats Studio Blanc");
        prod3 = new Product(R.drawable.chaussure_nike, "huarache", "119e89", "Nike Huarache Noir");
        prod4 = new Product(R.drawable.chaussure_nike1, "air max", "129e19", "Nike Air Max Blanche");
        prod5 = new Product(R.drawable.clavier, "clavier", "19e99", "Clavier noir QWERTY usb");
        prod6 = new Product(R.drawable.gilet_levis, "gilet levis", "149e99", "Veste Levi's Noir");
        /***** *****/


        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        final List<Product> listRowItem = new ArrayList<Product>();
        listRowItem.add(prod1);
        listRowItem.add(prod2);
        listRowItem.add(prod3);
        listRowItem.add(prod4);
        listRowItem.add(prod5);
        listRowItem.add(prod6);



        listView.setAdapter(new ArrayAdapter<Product>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,
                listRowItem));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) listView.getItemAtPosition(position);
                eventListener.onMyEvent(product);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            eventListener = (OnMyFragmentEvent) context;
        }catch (Exception e){System.out.println(e.toString());}

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
