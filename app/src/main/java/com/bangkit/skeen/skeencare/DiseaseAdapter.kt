package com.bangkit.skeen.skeencare

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skeen.R

class DiseaseAdapter(private val context: Context, private var diseaseList: List<Disease>) :
    RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder>() {

    private var filteredDiseaseList: List<Disease> = diseaseList.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_disease, parent, false)
        return DiseaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        val disease = filteredDiseaseList[position]
        holder.nameTextView.text = disease.name
        holder.descriptionTextView.text = disease.description
        holder.photoImageView.setImageResource(disease.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("DISEASE_NAME", disease.name)
                putExtra("DISEASE_DESCRIPTION", disease.description)
                putExtra("DISEASE_PHOTO", disease.photo)
                putExtra("DISEASE_CAUSES", disease.causes)
                putExtra("DISEASE_PREVENTION", disease.prevention)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = filteredDiseaseList.size

    fun filter(query: String) {
        filteredDiseaseList = if (query.isEmpty()) {
            diseaseList
        } else {
            diseaseList.filter { it.name.contains(query, true) }
        }
        notifyDataSetChanged()
    }

    class DiseaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_item_description)
        val photoImageView: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
