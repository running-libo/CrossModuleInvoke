package com.example.base_module

interface ServiceCreator<T> {
    fun create(): T
}
