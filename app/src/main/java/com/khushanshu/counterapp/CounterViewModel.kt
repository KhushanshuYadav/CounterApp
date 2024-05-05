package com.khushanshu.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


//"ViewModel" PART OF ARCHITECTURE
class CounterViewModel: ViewModel(){
    private val _count=mutableStateOf(0);

    //Exposing the _count as immutable state i.e preserving _count state i.e no change in rotation
    //since val so no  change

    val count:MutableState<Int> = _count;

    //count is referencing to same value as _count so when _count changes so does the count

    fun increment(){
        _count.value++;
    }
    fun decrement(){
        _count.value--;
    }
}