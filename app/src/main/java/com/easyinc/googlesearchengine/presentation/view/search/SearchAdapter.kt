package com.easyinc.googlesearchengine.presentation.view.search

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyinc.googlesearchengine.R
import com.easyinc.googlesearchengine.common.extention.inflate
import com.easyinc.googlesearchengine.presentation.model.ResultView
import kotlinx.android.synthetic.main.result_raw.view.*
import javax.inject.Inject

class SearchAdapter @Inject constructor(): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var resultsList = listOf<ResultView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        parent.inflate(R.layout.result_raw)
    )

    override fun getItemCount() = resultsList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) = holder.bind(resultsList[position])

    fun submitList(newList: List<ResultView>){
        resultsList = newList
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(result: ResultView){
            itemView.title.text = result.title
            itemView.link.text = result.link
            itemView.descreption.text = result.snippet

            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result.link))
                itemView.context.startActivity(intent)
            }
        }
    }
}