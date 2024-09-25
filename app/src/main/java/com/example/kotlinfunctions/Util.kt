package com.example.kotlinfunctions

import android.content.Context
import android.util.Log
import android.widget.Toast


object Util {

    val TAG = Util.javaClass.canonicalName

    // Lambda Function
    // Lambda Expressions

    // A function without a name is called an anonymous function.
    // Lambda expressions provide a shorthand syntax to write functions
    val myLambdaWithoutReturnType = {
        println("Lambda is called")
    }

    // My Lambda With Out Signature
    val myLambdaWithOutSignature = { a: Int, b: Int -> a + b }

    // My Lambda With Signature
    val myLambdaWithSignature: (a: Int, b: Int) -> Int = { a: Int, b: Int -> a + b }

    // My Lambda With ArrayList Filter
    val myLambdaWithFilterArraylist =
        { argumentArrayList: List<String> -> argumentArrayList.sorted() }

    fun callLambda() {

        // we can also call the lambda using the invoke() method
        myLambdaWithoutReturnType.invoke()

        Log.d(TAG, "callLambda: myLambdaWithoutReturnType: " + myLambdaWithoutReturnType())
        Log.d(TAG, "callLambda: myLambdaWithOutSignature: " + myLambdaWithOutSignature(100, 100))
        Log.d(TAG, "callLambda: myLambdaWithSignature: " + myLambdaWithSignature(200, 200))

        val arrayList = ArrayList<String>()//Creating an empty arraylist
        arrayList.add("Vipul")//Adding object in arraylist
        arrayList.add("Milan")
        arrayList.add("Nirmal")
        arrayList.add("Prerak")
        arrayList.add("Bhakti")
        arrayList.add("Ashok")
        Log.d(TAG, "callLambda: myLambdaWithSignature: " + myLambdaWithFilterArraylist(arrayList))
    }


    /* In Kotlin, a higher-order function is a function which can accept one or more
    functions as parameters or returns a function. Means, instead of passing Int, String,
    or other types as a parameter in a function we will pass anonymous function or lambdas.

    By passing functions as arguments, you can customize the behavior of a higher order
    function without modifying its implementation.
     */
    fun callHigherOrderFunction() {
        Log.d(TAG, "callHigherOrderFunction: " + lambdaExpressionWithUnit(myLambdaWithoutReturnType))
        Log.d(TAG, "callHigherOrderFunction: " + lambdaExpressionWithIntReturn(5, 5, myLambdaWithOutSignature))
    }

    // Lambda expression which returns Unit
    private fun lambdaExpressionWithUnit(lambda: () -> Unit) {
        lambda()
    }

    // A higher-order function that takes a function as a parameter
    private fun lambdaExpressionWithIntReturn(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }


    fun callInLineFunction() {
        inlinedFunction(myLambdaWithoutReturnType, myLambdaWithoutReturnType)
    }

    /* Inlined function copy the code to the calling place, similarly inline
    keyword copy the inline properties accessor methods to calling place.
     */
    private inline fun inlinedFunction(lambda1: () -> Unit, lambda2: () -> Unit  ) {
        lambda1()
        lambda2()
    }

    fun callFilter() {
        val products = listOf(
            Product("Laptop", 999.99),
            Product("Smartphone", 499.99),
            Product("Tablet", 299.99),
            Product("Smartwatch", 199.99),
            Product("Headphones", 79.99)
        )
        val expensiveProducts = products.filter { it.price > 200.0 }.sortedBy { it.price }
        Log.d(TAG, "Products: " + expensiveProducts.joinToString("\n") { "${it.name}: $${it.price}" })
    }
}