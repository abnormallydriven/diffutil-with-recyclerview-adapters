package com.abnormallydriven.personlist

import android.support.v7.util.DiffUtil

class PersonDiffUtilCallback constructor(private val oldList : List<Person>,
                                         private val updatedList : List<Person>) : DiffUtil.Callback() {

    companion object {
        const val NAME_KEY = "name"
        const val ONLINE_STATUS_KEY = "online"
        const val STATUS_KEY = "status"
    }


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return updatedList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPerson = oldList[oldItemPosition]
        val updatedPerson = updatedList[newItemPosition]

        return oldPerson.id == updatedPerson.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPerson = oldList[oldItemPosition]
        val updatedPerson = updatedList[newItemPosition]


        val isNameTheSame = oldPerson.name == updatedPerson.name
        val isOnlineStatusTheSame = oldPerson.isOnline == updatedPerson.isOnline
        val isStatusTheSame = oldPerson.status == updatedPerson.status

        return isNameTheSame && isOnlineStatusTheSame && isStatusTheSame
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldPerson = oldList[oldItemPosition]
        val updatedPerson = updatedList[newItemPosition]

        val changeMap = mutableMapOf<String, Any>()

        val isNameTheSame = oldPerson.name == updatedPerson.name
        val isOnlineStatusTheSame = oldPerson.isOnline == updatedPerson.isOnline
        val isStatusTheSame = oldPerson.status == updatedPerson.status


        if(!isNameTheSame){
            changeMap[NAME_KEY] = updatedPerson.name
        }

        if(!isOnlineStatusTheSame){
            changeMap[ONLINE_STATUS_KEY] = updatedPerson.isOnline
        }

        if(!isStatusTheSame){
            changeMap[STATUS_KEY] = updatedPerson.status
        }

        return changeMap
    }
}