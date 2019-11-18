package com.example.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.mapper.TimeLineMapper
import com.example.presentation.model.SkillView
import com.example.presentation.model.TimelineView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import com.example.presentation.viewmodel.SkillViewModel
import com.example.presentation.viewmodel.TimelineViewModel
import com.example.ui.CVApplication
import com.example.ui.R
import com.example.ui.mapper.UITimelineMapper
import com.example.ui.model.UISkill
import com.example.ui.model.UITimeline
import com.example.ui.view.adapter.MultipleTypeAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.fragment_skill.*
import timber.log.Timber
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WorkFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment() {

    @Inject lateinit var timelineAdapter: MultipleTypeAdapter
    @Inject lateinit var mapper: UITimelineMapper
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var timelineViewModel: TimelineViewModel
    companion object {
        fun newInstance() = WorkFragment()
    }

    override fun onAttach(context: Context) {
        (activity?.application as CVApplication).androidInjector().inject(this)
        super.onAttach(context)
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
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        timelineViewModel = ViewModelProviders.of(activity!!, viewModelFactory)
            .get(TimelineViewModel::class.java)
        setupSkillsRecycler()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity?.application as CVApplication).androidInjector()
    }

    private fun setupSkillsRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = timelineAdapter
    }
    override fun onStart() {
        super.onStart()
        timelineViewModel.getTimeline().observe(this,
            Observer<Resource<List<TimelineView>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        timelineViewModel.fetchTimeline()
    }
    private fun handleDataState(resource: Resource<List<TimelineView>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data?.map {
                    Timber.e(resource.message)
                    mapper.mapToView(it)
                })
            } ResourceState.LOADING -> {
            Timber.e(resource.message)
        }
            ResourceState.ERROR -> {
                Timber.e(resource.message)
            }
        }
    }

    private fun setupScreenForSuccess(skill: List<UITimeline>?) {
        skill?.let {
            timelineAdapter.timelineList = it
            timelineAdapter.notifyDataSetChanged()
        } ?: run {
        }
    }

}
