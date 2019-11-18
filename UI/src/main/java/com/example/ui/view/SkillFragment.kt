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
import com.example.presentation.model.SkillView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import com.example.presentation.viewmodel.ProfileViewModel
import com.example.presentation.viewmodel.SkillViewModel
import com.example.ui.CVApplication
import com.example.ui.R
import com.example.ui.injection.ViewModelFactory
import com.example.ui.mapper.UISkillMapper
import com.example.ui.model.UISkill
import com.example.ui.view.adapter.SkillAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.fragment_skill.*
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SkillFragment : Fragment() {

    @Inject lateinit var skillAdapter: SkillAdapter
    @Inject lateinit var mapper: UISkillMapper
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var skillViewModel: SkillViewModel

    companion object {
        fun newInstance() = SkillFragment()
    }

    override fun onAttach(context: Context) {
        (activity?.application as CVApplication).androidInjector().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_skill, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

         skillViewModel = ViewModelProviders.of(activity!!, viewModelFactory)
            .get(SkillViewModel::class.java)
         setupSkillsRecycler()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity?.application as CVApplication).androidInjector()
    }

    private fun setupSkillsRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = skillAdapter
    }
    override fun onStart() {
        super.onStart()
        skillViewModel.getSkills().observe(this,
            Observer<Resource<List<SkillView>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        skillViewModel.fetchSkill()
    }
    private fun handleDataState(resource: Resource<List<SkillView>>) {
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

    private fun setupScreenForSuccess(skill: List<UISkill>?) {
        skill?.let {
            skillAdapter.skillList = it
            skillAdapter.notifyDataSetChanged()
        } ?: run {
        }
    }
}

