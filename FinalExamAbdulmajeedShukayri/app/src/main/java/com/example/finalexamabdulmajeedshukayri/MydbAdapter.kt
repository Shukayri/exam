package com.example.finalexamabdulmajeedshukayri

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexamabdulmajeedshukayri.database.Uni_table
import kotlinx.android.synthetic.main.database_row.view.*


class MydbAdapter(private val Fragment: Database_Fragment): RecyclerView.Adapter<MydbAdapter.MessageViewHolder>() {
    private var univs: List<Uni_table> = listOf()
    lateinit var tvNote: TextView

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MydbAdapter.MessageViewHolder {
        return MydbAdapter.MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.database_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MydbAdapter.MessageViewHolder, position: Int) {
        val uni = univs[position]

        holder.itemView.apply {
            University_Title.text = uni.name
            University_Location.text=uni.country

            deleteBtn.setOnClickListener {
                Fragment.delete(uni)
            }

            tvNote = findViewById(R.id.noteTV)

            editBtn.setOnClickListener {

            }
        }
    }

    //private fun editDialog(note: Note) {
        //val alertDialog = AlertDialog.Builder(activity)
        //val editText = EditText(activity)
        //editText.setText(note.noteText)
        //alertDialog.setTitle("Edit Note")
        //alertDialog.setView(editText)
        //alertDialog.setPositiveButton("Save"){
          //      _,_-> activity.updateNote(Note(note.timestamp,editText.text.toString()))
        //}
       // alertDialog.setNegativeButton("Cancel"){
          //      dialog,_ -> dialog.dismiss()
        //}
      //  alertDialog.show()
    //}

    override fun getItemCount() = univs.size

    fun setUniversity(univs: List<Uni_table>){

        this.univs = univs
        notifyDataSetChanged()
    }
}
