package com.example.bliss.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.bliss.R
import com.example.bliss.core.openFragment
import com.example.bliss.viewmodel.EmojiViewModel
import com.example.bliss.viewmodel.UserViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.*

class MainFragment : Fragment(), View.OnClickListener {
    lateinit var userViewModel: UserViewModel
    lateinit var emojiViewModel: EmojiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)
        userViewModel.context.value = requireActivity()
        emojiViewModel = ViewModelProviders.of(requireActivity()).get(EmojiViewModel::class.java)
        emojiViewModel.context.value = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        userViewModel.userLivaData.observe(viewLifecycleOwner, {
            if (it.repos_url.isNotEmpty()) {
                enableButtons()
            } else {
                disableButtons()
                Toast.makeText(requireContext(), "Nothing found", Toast.LENGTH_LONG).show()
            }
        })

        emojiViewModel.emojisLiveData.observe((viewLifecycleOwner), {
            if (it.isNotEmpty()) {
                val random = Random()
                Picasso.get().load(it.entries.elementAt(random.nextInt(it.size)).toString())
                    .into(view.img_emoji)
            }
        })

        view.btn_random_emoji.setOnClickListener(this)
        view.btn_emoji_list.setOnClickListener(this)
        view.btn_search.setOnClickListener(this)
        view.btn_avatar_list.setOnClickListener(this)
        view.btn_google_repos.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_random_emoji -> {
                emojiViewModel.retrieveEmojis()
            }
            btn_emoji_list -> {
                openFragment(requireActivity(), EmojiFragment())
            }
            btn_search -> {
                if (edt_username.text.toString().isNotEmpty()) {
                    userViewModel.retrieveUser(edt_username.text.toString())
                } else {
                    Toast.makeText(requireContext(), "Inform username", Toast.LENGTH_LONG).show()
                }
            }
            btn_avatar_list -> {
                openFragment(requireActivity(), AvatarFragment())
            }
            btn_google_repos -> {
                openFragment(requireActivity(), ReposFragment())
            }
        }
    }

    private fun enableButtons() {
        userViewModel.userReposLiveData.value?.let {
            btn_avatar_list.isEnabled = true
        }
        btn_google_repos.isEnabled = true
    }

    private fun disableButtons() {
        btn_avatar_list.isEnabled = false
        btn_google_repos.isEnabled = false
    }
}