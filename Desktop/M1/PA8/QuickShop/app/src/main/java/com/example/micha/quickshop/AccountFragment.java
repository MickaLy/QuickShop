package com.example.micha.quickshop;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.micha.entity.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /***** *****/

    private TextView firstName_textView, lastName_textView, creditCardId_textView, cvv_textView, expirationDate_textView;
    private EditText firstName_editText, lastName_editText, creditCardId_editText, cvv_editText, expirationDate_editText;
    private Button validateButton, changeButton;
    private ListView listView_userRegistered;

    private List<User> listUser;

    /***** *****/

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        firstName_textView = (TextView) view.findViewById(R.id.firstnameTextView);
        firstName_editText = (EditText) view.findViewById(R.id.firstnameEditText);
        lastName_textView = (TextView) view.findViewById(R.id.lastnameTextView);
        lastName_editText = (EditText) view.findViewById(R.id.lastnameEditText);
        creditCardId_textView = (TextView) view.findViewById(R.id.creditcardTextView);
        creditCardId_editText = (EditText) view.findViewById(R.id.creditcardEditText);
        cvv_textView = (TextView) view.findViewById(R.id.cvvTextView);
        cvv_editText = (EditText) view.findViewById(R.id.cvvEditText);
        expirationDate_textView = (TextView) view.findViewById(R.id.expirationDateTextView);
        expirationDate_editText = (EditText) view.findViewById(R.id.expirationdateEditText);

        validateButton = (Button) view.findViewById(R.id.validateBtn);
        changeButton = (Button) view.findViewById(R.id.changeBtn);

        listUser  = new ArrayList<User>();


        //initComponent();


        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName, lastName, creditCardId, cvv, expirationDate;
                firstName = firstName_editText.getText().toString();
                lastName = lastName_editText.getText().toString();
                creditCardId = creditCardId_editText.getText().toString();
                cvv = cvv_editText.getText().toString();
                expirationDate = expirationDate_editText.getText().toString();
                User user = new User(firstName, lastName, creditCardId, cvv, expirationDate);
                listUser.add(user);
                validateButton.setVisibility(View.INVISIBLE);
                System.out.println(user);
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Going to change... \n"+listUser.get(0));
                listUser.clear();
                validateButton.setVisibility(View.VISIBLE);
            }
        });

        return view;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

    public void initComponent(){
        firstName_textView = (TextView) getView().findViewById(R.id.firstnameTextView);
        firstName_editText = (EditText) getView().findViewById(R.id.firstnameEditText);
        lastName_textView = (TextView) getView().findViewById(R.id.lastnameTextView);
        lastName_editText = (EditText) getView().findViewById(R.id.lastnameEditText);
        creditCardId_textView = (TextView) getView().findViewById(R.id.creditcardTextView);
        creditCardId_editText = (EditText) getView().findViewById(R.id.creditcardEditText);
        cvv_textView = (TextView) getView().findViewById(R.id.cvvTextView);
        cvv_editText = (EditText) getView().findViewById(R.id.cvvEditText);
        expirationDate_textView = (TextView) getView().findViewById(R.id.expirationDateTextView);
        expirationDate_editText = (EditText) getView().findViewById(R.id.expirationdateEditText);

        validateButton = (Button) getView().findViewById(R.id.validateBtn);
        changeButton = (Button) getView().findViewById(R.id.changeBtn);

        listUser  = new ArrayList<User>();
    }
}
