package me.johan

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Threads(20)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
open class SynchronizationTest {
    var semList = SemaphoreList<String>()
    var syncList = SyncList<String>()

    val text1 = "hello world 1"
    val text2 = "hello world 2"

    @Setup
    fun setUp() {
        semList = SemaphoreList<String>()
        syncList = SyncList<String>()
    }

    @Benchmark
    fun semaphoreBenchmark(blackhole: Blackhole) {
        semList.add(text1)
        semList.add(text2)

        semList.iterate { blackhole.consume(it) }

        semList.remove(text1)
        semList.remove(text2)
    }

    @Benchmark
    fun syncBenchmark(blackhole: Blackhole) {
        syncList.add(text1)
        syncList.add(text2)

        syncList.iterate { blackhole.consume(it) }

        syncList.remove(text1)
        syncList.remove(text2)
    }

}