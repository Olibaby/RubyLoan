package com.example.rubyloan


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.fragment_providers.*
import com.qucoon.rubies.utils.updateRecycler

/**
 * A simple [Fragment] subclass.
 */
class ProvidersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_providers, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    val listOfProviders = listOf<Providers>(Providers(R.drawable.cnn_image, "CNN"),
        Providers(R.drawable.mines_image, "MINES"),
        Providers(R.drawable.ils_image, "ILS"),
        Providers(R.drawable.cnn_image, "CNN"),
        Providers(R.drawable.mines_image, "MINES"),
        Providers(R.drawable.ils_image, "ILS")
    )
    private fun setUpRecyclerView() {
//        providersRecyclerView.layoutManager = LinearLayoutManager(this.activity, RecyclerView.VERTICAL, false)
//        providersRecyclerView.adapter = ProvidersAdaptor(listOfProviders)
        providersRecyclerView.updateRecycler(context!!,listOfProviders,R.layout.providers_view,
            listOf(R.id.tvProviders,R.id.ivProviders,R.id.cardView),{ innerView, position ->
                val tv = innerView[R.id.tvProviders] as TextView
                val iv = innerView[R.id.ivProviders] as ImageView
                val cardView = innerView[R.id.cardView] as CardView
                cardView.setOnClickListener {
                    print("I was Clicked")
                }
                val currentItem = listOfProviders[position]
                tv.text = currentItem.name
                iv.setImageResource(currentItem.image)
        },{position ->
            print("I was Clicked")
        }, listOf(ivNoImage,tvNoImage))

    }




}
data class Providers(val image: Int, val name: String)

