package com.khushanshu.counterapp

//Our Model
data class CounterModel(var count:Int);


//Repository as class;
class CounterRepository{
    private var _counter= CounterModel(0); //object of Counter Model i.e of type "Model"

    fun getCounter()=_counter;

    fun incrementCounter(){
        _counter.count++;
    }

    fun decrementCounter(){
        _counter.count--;
    }
}