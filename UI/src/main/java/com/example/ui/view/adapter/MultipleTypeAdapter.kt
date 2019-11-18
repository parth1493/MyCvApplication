package com.example.ui.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ui.R
import com.example.ui.model.UITimeline
import kotlinx.android.synthetic.main.time_line_start.view.*
import javax.inject.Inject


class MultipleTypeAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var timelineList : List<UITimeline> = arrayListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (viewType) {
            time_line_start -> { // for call layout
                view = LayoutInflater.from(viewGroup?.context).inflate(R.layout.time_line_start, viewGroup, false)
                TimeLineStart(view)
            }
            time_line_add -> { // for call layout
                view = LayoutInflater.from(viewGroup?.context).inflate(R.layout.time_line_add, viewGroup, false)
                TimeLineAdd(view)
            }
            else -> { // for email layout
                view = LayoutInflater.from(viewGroup?.context).inflate(R.layout.time_line_end, viewGroup, false)
                TimeLineEnd(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            timelineList[position].timeLineState == 0 -> time_line_start
            timelineList[position].timeLineState == 1 -> time_line_add
            else -> time_line_end
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when {
            getItemViewType(position) == time_line_start -> (viewHolder as TimeLineStart).setTimeLineStart(timelineList[position])
            getItemViewType(position) == time_line_add -> (viewHolder as TimeLineAdd).setTimeLineAdd(timelineList[position])
            else -> (viewHolder as TimeLineEnd).setTimeLineEnd(timelineList[position])
        }
    }

    override fun getItemCount(): Int {
        return timelineList.size
    }

    class TimeLineStart(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName = view.txtName
        private val txtRole = view.txtRole
        private val txtDate = view.txtDate
        private val txtResponsibilities = view.txtResponsibilities
        private val imageView: ImageView = view.imgLogo

        fun setTimeLineStart(timeline: UITimeline) {
            txtName.text = timeline.name
            txtRole.text = timeline.roleName
            txtDate.text = timeline.dateToFrom
            txtResponsibilities.text = timeline.responsibilities
            Glide.with(itemView.context)
                .load(Uri.parse(timeline.image))
                .into(imageView)
        }
    }

    class TimeLineAdd(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName = view.txtName
        private val txtRole = view.txtRole
        private val txtDate = view.txtDate
        private val txtResponsibilities = view.txtResponsibilities
        private val imageView: ImageView = view.imgLogo

        fun setTimeLineAdd(timeline: UITimeline) {
            txtName.text = timeline.name
            txtRole.text = timeline.roleName
            txtDate.text = timeline.dateToFrom
            txtResponsibilities.text = timeline.responsibilities
            Glide.with(itemView.context)
                .load(Uri.parse(timeline.image))
                .into(imageView)
        }
    }

    class TimeLineEnd(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName = view.txtName
        private val txtRole = view.txtRole
        private val txtDate = view.txtDate
        private val txtResponsibilities = view.txtResponsibilities
        private val imageView: ImageView = view.imgLogo

        fun setTimeLineEnd(timeline: UITimeline) {
            txtName.text = timeline.name
            txtRole.text = timeline.roleName
            txtDate.text = timeline.dateToFrom
            txtResponsibilities.text = timeline.responsibilities
            Glide.with(itemView.context)
                .load(Uri.parse(timeline.image))
                .into(imageView)
        }
    }

    companion object {

        private val time_line_start = 0
        private val time_line_add = 1
        private val time_line_end = 2
    }

}
