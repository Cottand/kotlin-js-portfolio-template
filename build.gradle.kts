plugins {
    kotlin("js") version "1.4.21"
}

group = "org"
version = "0.1"

repositories {
    jcenter()
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

val kotlinJsVersion = "pre.134-kotlin-1.4.10"

dependencies {
    val reactVersion = "17.0.0"
    val kotlinStyledVersion = "5.2.0"
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains:kotlin-react:$reactVersion-$kotlinJsVersion")
    implementation("org.jetbrains:kotlin-react-dom:$reactVersion-$kotlinJsVersion")
    implementation("org.jetbrains:kotlin-styled:$kotlinStyledVersion-$kotlinJsVersion")
    implementation(npm("react-hot-loader", "^4.12.20"))
    implementation("com.ccfraser.muirwik:muirwik-components:0.6.2")
}

kotlin {
    js(LEGACY) {
        compilations.all {
            kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.js.ExperimentalJsExport"
        }
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    if (isChromiumInstalled()) useChromiumHeadless() else useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
            binaries.executable()
        }
    }
}


fun isChromiumInstalled() = ProcessBuilder("sh", "-c", "chromium --help")
    .directory(file("."))
    .start()
    .waitFor() == 0