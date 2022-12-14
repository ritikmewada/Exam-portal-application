package com.example.exam_portal_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_portal_app.R
import com.example.exam_portal_app.databinding.OptionItemBinding
import com.example.exam_portal_app.models.Question


class OptionAdapter(val context: Context, val question: Question) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    private var options: List<String> = listOf(question.option1, question.option2, question.option3, question.option4)

    inner class OptionViewHolder(itemView: OptionItemBinding) : RecyclerView.ViewHolder(itemView.root){
        var optionView = itemView.quizOption
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {

//        return QuizViewHolder(QuizItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
//        val view = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false)
//        return  OptionViewHolder(view)

        return OptionViewHolder(OptionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener {
            question.userAnswer = options[position]
            notifyDataSetChanged()
        }
        if(question.userAnswer == options[position]){
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }
        else{
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }

    }

    override fun getItemCount(): Int {
        return options.size
    }
}