package com.example.ui.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.example.presentation.model.ProfileView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import com.example.presentation.viewmodel.ProfileViewModel
import com.example.ui.R
import com.example.ui.injection.ViewModelFactory
import com.example.ui.mapper.UIProfileMapper
import com.example.ui.model.UIProfile
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mapper:UIProfileMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        init()

        getInTouchOnClick.setOnClickListener {
            var number = "tel:4389888823"
            val dial = Intent(Intent.ACTION_DIAL, Uri.parse(number))
            startActivity(dial)
        }
        profileViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ProfileViewModel::class.java)
    }

    private fun init() {
        viewpager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when(position) {
                    0 -> {
                        AboutFragment.newInstance()
                    }
                    1 -> {
                        WorkFragment.newInstance()
                    }
                    2 -> {
                        SkillFragment.newInstance()
                    }
                    else -> {
                        ContactFragment.newInstance()
                    }

                }
            }

            override fun getItemCount(): Int {
                return 4
            }
        }

        TabLayoutMediator(tabs, viewpager) { tabs, position ->
            tabs.text = when(position) {
                0 -> "About"
                1 -> "Work"
                2 -> "Skill"
                else -> "Contact"
            }
        }.attach()
        tabs.setTabTextColors(this.getColor(R.color.backgroundColor),this.getColor(R.color.colorSecondary))
    }
    override fun onStart() {
        super.onStart()
        profileViewModel.getProfile().observe(this,
            Observer<Resource<List<ProfileView>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        profileViewModel.fetchProfile()
    }
    private fun handleDataState(resource: Resource<List<ProfileView>>) {
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
    private fun setupScreenForSuccess(profile: List<UIProfile>?) {
        profile?.let {
            if(profile.size >= 0) {
                Glide.with(this)
                    .load(Uri.parse(profile.get(0).profilepic))
                    .into(profile_image)
                devName.text = profile.get(0).name
                devProfession.text = profile.get(0).role
            }
        } ?: run {
        }
    }
}
