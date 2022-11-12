package com.example.tp2_android

import android.util.Log
import android.util.LogPrinter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gl4.myapplication.Etudiant
import com.gl4.myapplication.R
import com.gl4.myapplication.R.mipmap
import java.util.*
import kotlin.collections.ArrayList

class WordListAdapter(private val dataSet: ArrayList<Etudiant>) :
    RecyclerView.Adapter<WordListAdapter.ViewHolder>(), Filterable {

    var dataFilterList = ArrayList<Etudiant>()
    var initDataSet = ArrayList<Etudiant>()
    init {
        dataFilterList = dataSet
        initDataSet = dataSet
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    dataFilterList = dataSet
                } else {
                    val resultList = ArrayList<Etudiant>()
                    for (student in dataSet) {
                        if (student.getNom().lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(student)
                        }
                    }
                    dataFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                dataFilterList = results?.values as ArrayList<Etudiant>
                notifyDataSetChanged()
            }

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val image: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            image = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.student_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.image.setImageResource(mipmap.img);
        viewHolder.textView.text = dataFilterList[position].getPrenom() + " " + dataFilterList[position].getNom();
    }

    override fun getItemCount() = dataFilterList.size

}