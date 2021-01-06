package com.kondeyanapps.shimmersample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kondeyanapps.shimmersample.model.Accounts

class ShimmerViewModel : ViewModel() {

    val listOfData = ArrayList<Accounts>()

    val accountsLiveData: MutableLiveData<List<Accounts>> by lazy {
        MutableLiveData<List<Accounts>>()
    }

    fun getData(): List<Accounts>{
        return ArrayList<Accounts>().apply {
            add(Accounts("Orange everyday","112233","1000","999"))
            add(Accounts("Orange everyday2","112234","1000","999"))
            add(Accounts("Orange everyday3","112235","1000","999"))
            add(Accounts("Orange everyday5","112236","1000","999"))
            add(Accounts("Orange everyday","112233","1000","999"))
            add(Accounts("Orange everyday2","112234","1000","999"))
            add(Accounts("Orange everyday3","112235","1000","999"))
            add(Accounts("Orange everyday5","112236","1000","999"))

        }
    }

    fun updateData(){
        listOfData.addAll(getData())
        Thread().apply {

        }
        accountsLiveData.postValue(listOfData)
    }

}
