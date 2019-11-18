package com.example.ui.injection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import androidx.lifecycle.ViewModelProviders
import com.example.presentation.viewmodel.SkillViewModel


@Singleton
open class ViewModelFactory : ViewModelProvider.Factory {
    private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>

    @Inject
    constructor(creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) {
        this.creators = creators
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalStateException("Unknown model class: " + modelClass)
        }

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    /**
     * Returns an instance of the specified view model, which is scoped to the activity if annotated
     * with [SharedViewModel], or scoped to the Fragment if not.
     */
//    operator fun <T : ViewModel> get(fragment: Fragment, modelClass: Class<T>): T {
//        return if (modelClass.getAnnotation(SkillViewModel::class.java!!) == null) {
//            ViewModelProviders.of(fragment, this).get(modelClass)
//        } else {
//            get(fragment.getActivity(), modelClass)
//        }
//    }
//
    operator fun <T : ViewModel> get(activity: FragmentActivity, modelClass: Class<T>): T {
        return ViewModelProviders.of(activity, this).get(modelClass)
    }
}