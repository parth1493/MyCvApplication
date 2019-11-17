package com.example.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R

/**
 * A simple [Fragment] subclass.
 */
class SkillFragment : Fragment() {

   // private lateinit var skillViewModel : SkillViewModel

    companion object {
        fun newInstance() = SkillFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        skillViewModel = ViewModelProviders.of(this).get(SkillViewModel::class.java)
//        getSkillData(skillViewModel)
//        observeMySkills(skillViewModel)
    }
//    private fun getSkillData(viewModel: SkillViewModel) {
//        viewModel.getSkillData()
//    }
//
//    fun observeMySkills(viewModel: SkillViewModel){
//        viewModel.getLiveData().observe(this, Observer {
//                skill ->
//            recyclerView.apply {
//                layoutManager = LinearLayoutManager(activity)
//                adapter = SkillAdapter(skill)
//            }
//        })
//    }
}
