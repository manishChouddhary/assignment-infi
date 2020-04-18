package com.manish.assignmentlib.ui.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.manish.assignmentlib.R
import com.manish.assignmentlib.extentions.gone
import com.manish.assignmentlib.extentions.visible
import com.manish.assignmentlib.model.Fact
import kotlinx.android.synthetic.main.fact_item.view.*

class FactsListAdaptor : RecyclerView.Adapter<FactsListAdaptor.FactsViewHolder>() {

    lateinit var factsList: List<Fact>

    inner class FactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.tvTitle
        var tvDescription: TextView = view.tvDescription
        var ivFactImage: ImageView = view.ivFactImage
        init {
            this.setIsRecyclable(false)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        return FactsViewHolder(createItemView(parent))
    }

    private fun createItemView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
    }

    override fun getItemCount(): Int = factsList.size

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        with(factsList[position]) {
            holder.apply {
                tvTitle.text = title
                tvDescription.text = description
                if (imageHref.isNullOrEmpty()) {
                    ivFactImage.gone()
                } else{
                    ivFactImage.visible()
                    Glide.with(holder.itemView.context)
                        .load(imageHref)
                        .error(R.drawable.error_place_holder)
                        .placeholder(R.drawable.ic_placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .into(ivFactImage)
                }
            }
        }
    }
}