package com.example.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WorkFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment() {

   // private lateinit var timeLineViewModel : TimelineViewModel

    companion object {
        fun newInstance() = WorkFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_work, container, false)
        return view
    }


    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
     //   timeLineViewModel = ViewModelProviders.of(this).get(TimelineViewModel::class.java)
       // getTimeLineData(timeLineViewModel)
        //observeMyTimeLine(timeLineViewModel)
    }

//    private fun getTimeLineData(viewModel: TimelineViewModel) {
//        viewModel.getTimeLineData()
//    }

//    fun observeMyTimeLine(viewModel: TimelineViewModel){
//        viewModel.getLiveData().observe(this, Observer {
//                timeLine ->
//            recyclerView.apply {
//                layoutManager = LinearLayoutManager(activity)
//                adapter = MultipleTypeAdapter(timeLine)
//            }
//        })
//    }
}
