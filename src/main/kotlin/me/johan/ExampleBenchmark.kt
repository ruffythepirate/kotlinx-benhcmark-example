package me.johan

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
open class ExampleBenchmark {

    var num: Int = 0

    @Setup
    fun setUp() {
        num = 3
    }

    @Benchmark
    fun exampleBenchmark(blackhole: Blackhole) {
        val sum = 5 + 2 * num
        blackhole.consume(sum)
    }

}