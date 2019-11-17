package com.example.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.model.UISkill

import kotlinx.android.synthetic.main.skill_layout.view.*


import java.util.ArrayList
import javax.inject.Inject


class SkillAdapter @Inject constructor() : RecyclerView.Adapter<SkillAdapter.SkillRecycleView>() {

    var skillList: List<UISkill> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillRecycleView {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.skill_layout, parent, false)
        return SkillRecycleView(v)
    }

    override fun getItemCount(): Int {
        return skillList.size
    }

    override fun onBindViewHolder(holder: SkillRecycleView, position: Int) {
        holder.txtSkillName.text = skillList[position].skillname
        holder.ratingBar.rating = skillList[position].skillValue
    }



     class SkillRecycleView(view: View) : RecyclerView.ViewHolder(view) {
            val txtSkillName = view.txtSkillName
            val ratingBar = view.myRating
    }
}
