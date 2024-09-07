package com.khushanshu.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


//"ViewModel" PART OF ARCHITECTURE
class CounterViewModel: ViewModel(){
    //Now we fetch count from data source via repository so we need to have object of it
    //IT CAN ALSO BE PASSED AS PARAMETER TO ViewModel
    private val repository: CounterRepository = CounterRepository();
    private val _count=mutableStateOf(repository.getCounter().count);

    //Exposing the _count as immutable state i.e preserving _count state i.e no change in rotation
    //since val so no  change
    //changes in private _count are reflected in app via count;

    val count:MutableState<Int> = _count;

    //count is referencing to same value as _count so when _count changes so does the count

    fun increment(){
        repository.incrementCounter()  //this modifies the count in data base or in Model class via repository
        _count.value=repository.getCounter().count; //fetching the incremented value
    }
    fun decrement(){
        repository.decrementCounter()  //this modifies the count in data base or in Model class via repository
        _count.value=repository.getCounter().count; //fetching the incremented value
    }
}