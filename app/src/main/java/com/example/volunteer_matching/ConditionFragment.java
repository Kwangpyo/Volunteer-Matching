package com.example.volunteer_matching;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConditionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConditionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConditionFragment extends Fragment {

    View view;

    private OnFragmentInteractionListener mListener;

    public ConditionFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ConditionFragment newInstance() {
        ConditionFragment fragment = new ConditionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);

        Spinner positionSpinner = (Spinner)view.findViewById(R.id.spinner_position);
        ArrayAdapter positionAdapter = ArrayAdapter.createFromResource(getContext(), R.array.item_position, android.R.layout.simple_spinner_item);
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionSpinner.setAdapter(positionAdapter);

        Spinner typeSpinner = (Spinner)view.findViewById(R.id.spinner_type);
        ArrayAdapter typeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.item_type, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        Spinner objectSpinner = (Spinner)view.findViewById(R.id.spinner_object);
        ArrayAdapter objectAdapter = ArrayAdapter.createFromResource(getContext(), R.array.item_object, android.R.layout.simple_spinner_item);
        objectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        objectSpinner.setAdapter(objectAdapter);

        Spinner timeSpinner = (Spinner)view.findViewById(R.id.spinner_time);
        ArrayAdapter timeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.item_time, android.R.layout.simple_spinner_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
}
