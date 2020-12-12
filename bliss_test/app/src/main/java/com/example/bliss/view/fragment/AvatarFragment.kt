package com.example.bliss.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bliss.R
import com.example.bliss.model.Repo
import com.example.bliss.view.adapter.AvatarAdapter
import com.example.bliss.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_repos.view.*

class AvatarFragment : Fragment() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)
        userViewModel.context.value = requireActivity()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_avatar, container, false)

        userViewModel.userReposLiveData.value?.let {
            setAdapter(it, view)
        }
        return view
    }

    private fun setAdapter(list: MutableList<Repo>, view: View) {
        view.recycler_repos.layoutManager = GridLayoutManager(requireActivity(), 4)
        view.recycler_repos.adapter = AvatarAdapter(list)
    }
}