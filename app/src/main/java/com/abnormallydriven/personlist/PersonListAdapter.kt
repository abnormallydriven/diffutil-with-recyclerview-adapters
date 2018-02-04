package com.abnormallydriven.personlist

import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import javax.inject.Inject

class PersonListAdapter @Inject constructor() : RecyclerView.Adapter<PersonViewHolder>() {

    private val personList : MutableList<Person> = mutableListOf()

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)

        val itemView = layoutInflater.inflate(R.layout.person_item_view, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {
        holder?.bind(personList[position])
    }

    fun updateAdapter(updatedList: List<Person>) {
        personList.clear()
        personList.addAll(updatedList)
        notifyDataSetChanged()
    }
}


class PersonViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)
    private val statusTextView = itemView.findViewById<TextView>(R.id.status_text_view)
    private val connectionStatusImageView = itemView.findViewById<ImageView>(R.id.status_image_view)


    fun bind(person: Person) {
        nameTextView.text = person.name
        statusTextView.text = person.status

        val drawable = VectorDrawableCompat.create(itemView.resources, R.drawable.ic_brightness_1_black_24dp, null)
        if (drawable != null) {
            val colorResource = if (person.isOnline) R.color.onlineGreen else R.color.offlineRed
            val tintedDrawable = drawable.mutate()
            tintedDrawable.setTint(ContextCompat.getColor(itemView.context, colorResource))
            connectionStatusImageView.setImageDrawable(tintedDrawable)
        }
    }
}
