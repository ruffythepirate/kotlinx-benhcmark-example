repositories{
    jcenter()
}

plugins {
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.kotlinx.benchmark") version "0.3.0"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.3.0")
}

benchmark {
    configurations {
        named("main") {
            iterationTime = 5
            iterationTimeUnit = "sec"
        }
    }
    targets {
        register("main") {
            this as kotlinx.benchmark.gradle.JvmBenchmarkTarget
            jmhVersion = "1.21"
        }
    }
}
