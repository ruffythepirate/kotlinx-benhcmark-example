package me.johan

import java.util.concurrent.Semaphore

class SemaphoreList<T> {
    val s = Semaphore(1)
    val list = ArrayList<T>()

    fun add(item: T) {
        try {
            s.acquireUninterruptibly()
            list.add(item)
        } finally {
            s.release()
        }
    }

    fun remove(item: T) {
        try {
            s.acquireUninterruptibly()
            list.remove(item)
        } finally {
            s.release()
        }
    }

    fun iterate(lambda: (T) -> Unit) {
        try {
            s.acquireUninterruptibly()
            list.forEach(lambda)
        } finally {
            s.release()
        }
    }
}