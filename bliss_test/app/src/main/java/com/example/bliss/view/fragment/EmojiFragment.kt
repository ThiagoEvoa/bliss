package com.example.bliss.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bliss.R
import com.example.bliss.view.adapter.EmojiAdapter
import com.example.bliss.viewmodel.EmojiViewModel
import kotlinx.android.synthetic.main.fragment_emoji.view.*

class EmojiFragment : Fragment() {
    lateinit var emojiViewModel: EmojiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emojiViewModel = ViewModelProviders.of(requireActivity()).get(EmojiViewModel::class.java)
        emojiViewModel.context.value = requireActivity()
        emojiViewModel.retrieveEmojis()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_emoji, container, false)

        emojiViewModel.emojisLiveData.observe(viewLifecycleOwner, {
            setAdapter(it, view)
        })

        return view
    }

    private fun setAdapter(list: Map<String, String>, view: View) {
        view.recycler_emoji.layoutManager = GridLayoutManager(requireActivity(), 4)
        view.recycler_emoji.adapter = EmojiAdapter(this, list)
    }
}