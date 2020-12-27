package com.example.myapplication_final.ui.card

import android.content.res.Configuration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication_final.R
import kotlinx.android.synthetic.main.card_fragment.*

class CardFragment : Fragment() {

    companion object {
        fun newInstance() = CardFragment()
    }

    lateinit var adapter: CardAdapter
    private lateinit var viewModel: CardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)

        viewModel.game.observe(viewLifecycleOwner, Observer {
            val game = it
            adapter = CardAdapter(it)
            recycleView.adapter = adapter

            val configure = resources.configuration
            if (configure.orientation == Configuration.ORIENTATION_PORTRAIT) {
                recycleView.layoutManager = GridLayoutManager(requireActivity(), 4)
            } else {
                recycleView.layoutManager = GridLayoutManager(requireActivity(), 6)
            }

            adapter.setOnClickListener {
                game.chooseCardAtIndex(it)
                adapter.notifyDataSetChanged()
                score.text = String.format("%s%d", getString(R.string.score), game.score)
                score.text = "Score:" + game.score
            }

            adapter.notifyDataSetChanged()
            score.text = String.format("%s%d", getString(R.string.score), it.score)
            score.text = "Score:" + it.score

            reset.setOnClickListener {
                game.reset()
                adapter.notifyDataSetChanged()
                score.text = String.format("%s%d", getString(R.string.score), game.score)
                score.text = "Score:" + game.score
            }
        })
    }

}