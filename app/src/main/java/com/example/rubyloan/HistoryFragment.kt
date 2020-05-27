package com.example.rubyloan


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.qucoon.rubies.utils.updateRecycler
import kotlinx.android.synthetic.main.fragment_history.*

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    val listOfHistory = listOf<History>(History(R.drawable.cnn_image, "CNN", "N50,000", "14 Nov 2019", R.drawable.green_dot),
        History(R.drawable.mines_image, "MINES", "N50,000", "14 Nov 2019", R.drawable.red_dot),
        History(R.drawable.ils_image, "ILS", "N50,000", "14 Nov 2019", R.drawable.grey_dot),
        History(R.drawable.mines_image, "MINES", "N50,000", "14 Nov 2019", R.drawable.green_dot),
        History(R.drawable.cnn_image, "CNN", "N50,000", "14 Nov 2019", R.drawable.grey_dot),
        History(R.drawable.cnn_image, "CNN", "N50,000", "14 Nov 2019", R.drawable.red_dot),
        History(R.drawable.cnn_image, "CNN", "N50,000", "14 Nov 2019", R.drawable.green_dot),
        History(R.drawable.mines_image, "MINES", "N50,000", "14 Nov 2019", R.drawable.red_dot),
        History(R.drawable.ils_image, "ILS", "N50,000", "14 Nov 2019", R.drawable.grey_dot),
        History(R.drawable.mines_image, "MINES", "N50,000", "14 Nov 2019", R.drawable.green_dot)
    )
    private fun setUpRecyclerView() {
       historyRecyclerView.updateRecycler(context!!,listOfHistory,R.layout.history_view,
           listOf(R.id.ivHistory, R.id.tvHistory, R.id.tvDate, R.id.tvAmount, R.id.ivDot), { innerView, position ->
               val iv = innerView[R.id.ivHistory] as ImageView
               val tv = innerView[R.id.tvHistory] as TextView
               val date = innerView[R.id.tvDate] as TextView
               val amount = innerView[R.id.tvAmount] as TextView
               val dot = innerView[R.id.ivDot] as ImageView

               val currentItems = listOfHistory[position]
               iv.setImageResource(currentItems.image)
               tv.text = currentItems.name
               date.text = currentItems.date
               amount.text = currentItems.amount
               dot.setImageResource(currentItems.dot)
           }, {position ->

           }, listOf(ivNoImage2, tvNoImage2)
       )
    }

}
data class History(val image: Int, val name: String, val amount: String, val date: String, val dot: Int)
