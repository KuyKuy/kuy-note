package org.kuykuy.kuynote

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.kuykuy.kuynote.domain.Note

class NoteAdapter: BaseAdapter {

    var listNoteArray = ArrayList<Note>()
    var context:Context?=null
    var layoutInflater:LayoutInflater?=null

    constructor(context: Context, listNotes: ArrayList<Note>):super(){
        this.context = context
        this.listNoteArray = listNotes
        layoutInflater = LayoutInflater.from(this.context)
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val noteItem =  layoutInflater?.inflate(R.layout.item_note, null)
        val note = listNoteArray[position]
        val title = note.title
        val description = note.description
        val noteText = "$title \n$description"
        val titleTv:TextView = noteItem?.findViewById(R.id.titleTv)!!
        val descTv:TextView = noteItem.findViewById(R.id.descTv)!!
        val editBtn:ImageButton = noteItem.findViewById(R.id.editBtn)!!
        val deleteBtn:ImageButton = noteItem.findViewById(R.id.deleteBtn)!!
        val copyBtn:ImageButton = noteItem.findViewById(R.id.copyBtn)!!
        val shareBtn:ImageButton = noteItem.findViewById(R.id.shareBtn)!!

        titleTv.text = title
        descTv.text = description

        editBtn.setOnClickListener {
            val intent = Intent(context, AddNoteActivity::class.java)
            intent.putExtra("note_index", position)
            context?.startActivity(intent)
        }

        deleteBtn.setOnClickListener {
            listNoteArray.remove(note)
            notifyDataSetChanged()
        }

        copyBtn.setOnClickListener {
            val clipboard =  context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cd = ClipData.newPlainText(MIMETYPE_TEXT_PLAIN, noteText)
            clipboard.primaryClip = cd
            Toast.makeText(context,"Copied... $noteText",Toast.LENGTH_LONG).show()
        }

        shareBtn.setOnClickListener {
           val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = MIMETYPE_TEXT_PLAIN
            shareIntent.putExtra(Intent.EXTRA_TEXT, noteText)
            context?.startActivity(shareIntent)
        }

        return noteItem
    }

    override fun getItem(position: Int): Any {
        return listNoteArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listNoteArray.size
    }

}
