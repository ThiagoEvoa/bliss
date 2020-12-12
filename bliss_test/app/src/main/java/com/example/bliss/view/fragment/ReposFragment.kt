package com.example.bliss.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bliss.R
import com.example.bliss.model.Repo
import com.example.bliss.view.adapter.ReposAdapter
import com.example.bliss.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_repos.view.*

class ReposFragment : Fragment() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)
        userViewModel.context.value = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_repos, container, false)

        retrieveUserRepos()

        userViewModel.userReposLiveData.observe(viewLifecycleOwner, {
            if (it.size > 0) {
                setAdapter(it, view)
            } else {
                Toast.makeText(requireContext(), "Nothing found", Toast.LENGTH_LONG).show()
            }
        })

        return view
    }

    private fun retrieveUserRepos() {
        userViewModel.retrieveUserRepos()
    }

    private fun setAdapter(list: MutableList<Repo>, view: View) {
        view.recycler_repos.layoutManager = LinearLayoutManager(requireActivity())
        view.recycler_repos.adapter = ReposAdapter(list)
    }
}