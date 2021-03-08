package me.johan

import java.util.concurrent.Semaphore

class SyncList<T> {
    val list = ArrayList<T>()

    @Synchronized
    fun add(item: T) {
            list.add(item)
    }

    @Synchronized
    fun remove(item: T) {
            list.remove(item)
    }

    @Synchronized
    fun iterate(lambda: (T) -> Unit) {
            list.forEach(lambda)
    }
}