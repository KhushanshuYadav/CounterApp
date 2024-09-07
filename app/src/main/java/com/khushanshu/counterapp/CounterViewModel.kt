package com.khushanshu.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


//"ViewModel" PART OF ARCHITECTURE
class CounterViewModel: ViewModel(){
    //Now we fetch count from data source via repository so we need to have object of it
    //IT CAN ALSO BE PASSED AS PARAMETER TO ViewModel
    private val repository: CounterRepository = CounterRepository();
    private val _count=mutableStateOf(repository.getCounter().count);  //type MutableState<Int>

    //Exposing the _count as immutable state i.e preserving _count state i.e no change in rotation
    //since val so no  change
    //changes in private _count are reflected in app via count;


//    1. val count: MutableState<Int>
//    count is a read-only reference (declared using val) to a mutable state object. In this case, it’s of type MutableState<Int>, meaning it holds an Int value that can change over time.
//    MutableState
//    In Jetpack Compose, MutableState<T> is a special type of observable state. When the value inside the MutableState changes, any UI elements that are observing this state automatically recompose (i.e., re-render).
//    It's part of Compose’s state management mechanism, allowing the UI to react to changes in the underlying data model.
//    So, MutableState<Int> is a wrapper around an Int value that lets Compose track changes and update the UI accordingly.

//    MutableState<T> can be thought of as a container or wrapper around a value of type T (in your case, an Int).
//    It provides a way to store, access, and modify the value it holds.
//    The value inside the container can change over time, but the reference to the container remains fixed if it’s declared with val.
//    val count as a Reference:
//    When you declare val count: MutableState<Int>, count is a reference to the MutableState container.
//    Since count is declared with val, the reference to the MutableState container cannot be changed to point to a different container, but the content inside the MutableState can change.

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