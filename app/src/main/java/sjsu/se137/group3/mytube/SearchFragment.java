package sjsu.se137.group3.mytube;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Sheethal Mathew
 * 5/15/16
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 * adapted from poojaTakawale gihub myyoutube repository
 */
/*
public class SearchFragment extends Fragment {
    private EditText searchInput;
    private List<VideoInformationMode> searchResults;
    private Handler handler;
    private RecyclerView recyclerView;

    public static SearchFragment getInstance(int position) {
        SearchFragment searchFragment = new SearchFragment();
        Bundle args = new bundle();
        args.putInt("position", position);
        return searchFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_search, container, false);
        searchInput = (EditText) layout.findViewById(R.id.search_input);
        recyclerView = (RecyclerView) layout.findViewById(R.id.search_list);
        recyclerView.addItemDecoration(LinearLayoutCompat.DividerMode(getActivity(), LinearLayoutCompat.DividerMode(Canvas.VertexMode));
        recyclerView.setHasFixedSize(true);
        handler = new Handler();

        searchInput.setOnEditorActionListener((v,actionId,event) -> {
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                searchOnYoutube(v,getText().toString());
                return false;
            }
            return true;
        });
        informationAdapter = new InformationAdapter(getActivity(),searchResults);
        recyclerView.setAdapter(informationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void searchOnYoutube(final String keywords) {
        (Thread) run()-> {
            YoutubeConnect yc = new YoutubeConnect();
            searchResults = yc.search(keywords);
            handler.post(()-> {
                updateSearchResults();
            });
        }
        onStart();//I AMMM NOTSURE
    }

    private void updateSearchResults() {
        informationAdapter = new InformationAdapter(getActivity(),searchResults);
        recyclerView.setAdapter(informationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }*/





















































// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public SearchFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @return A new instance of fragment SearchFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static SearchFragment newInstance(){//String param1, String param2) {
//        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }


//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }}
//}
