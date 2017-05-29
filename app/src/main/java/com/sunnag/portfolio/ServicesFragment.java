package com.sunnag.portfolio;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ServicesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ServicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServicesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    NonScrollExpandableListView expList;

    public ServicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicesFragment newInstance(String param1, String param2) {
        ServicesFragment fragment = new ServicesFragment();
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

        View view = inflater.inflate(R.layout.fragment_services, container, false);
        expList = (NonScrollExpandableListView) view.findViewById(R.id.exp_list);
        ExampleAdapter adapter = new ExampleAdapter(getActivity(), getActivity().getLayoutInflater());
        expList.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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

    /***
     * Adapter For Expandable Listview
     *
     * */
    class ExampleAdapter implements ExpandableListAdapter {
        Context context;
        LayoutInflater layoutInflater;
        public ExampleAdapter(Context context, LayoutInflater layoutInflater) {
            this.context = context;
            this.layoutInflater = layoutInflater;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            View v = null;
            if(groupPosition == 0) {
                v = View.inflate(context, R.layout.child_text, null);
            }
            if(groupPosition == 1) {
                v = View.inflate(context, R.layout.business_ana, null);
            }
            if(groupPosition == 2) {
                v = View.inflate(context, R.layout.business_process_out, null);
            }
            if(groupPosition == 3) {
                v = View.inflate(context, R.layout.web_des, null);
            }
            if(groupPosition == 4) {
                v = View.inflate(context, R.layout.emp_text, null);
            }
            v.invalidate();
            return v;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getGroupCount() {
            return 8;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            View v = convertView.inflate(context, R.layout.expandable_group_layout, null);
            TextView txtView = (TextView) v.findViewById(R.id.txt1);

            ImageView ivGroupIndicator = (ImageView) v.findViewById(R.id.ivGroupIndicator);

            ivGroupIndicator.setSelected(isExpanded);

            if(groupPosition == 0) {
                txtView.setText("Outsourcing");
                //txtView.setTextSize(15f);
            }
            if(groupPosition == 1) {
                txtView.setText("Business Analysis");
                //txtView.setTextSize(15f);
            }
            if(groupPosition == 2) {
                txtView.setText("BUSINESS PROCESS OUTSOURCING");
                // txtView.setTextSize(15f);
            }
            if(groupPosition == 3) {
                txtView.setText("WEB DESIGN & DEVELOPMENT");
                //txtView.setTextSize(15f);
            }

            if(groupPosition == 4) {
                txtView.setText("EMPLOYEE RECRUITMENT");
                //txtView.setTextSize(15f);
            }

            if(groupPosition == 5) {
                txtView.setText("OUTSOURCING OF ACCOUNTS & PAYROLL");
                //txtView.setTextSize(15f);
            }
            if(groupPosition == 6) {
                txtView.setText("OFFSHORE CALL CENTERS");
                //txtView.setTextSize(15f);
            }

            if(groupPosition == 7) {
                txtView.setText("EMPLOYEE RECRUITMENT");
                //txtView.setTextSize(15f);
            }

            v.invalidate();
            return v;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }
    }
}
