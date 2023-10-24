import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.4.0"
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp") version "1.8.20-1.0.11"
}

group = "com.loloof64"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    val voyagerVersion = "1.0.0-rc08"
    val lyricistVersion = "1.6.0"
    implementation(compose.desktop.currentOs)
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.lyricist:lyricist:$lyricistVersion")
    ksp("cafe.adriel.lyricist:lyricist-processor:$lyricistVersion")
    implementation("io.github.wolfraam:chessgame:1.5")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ChessKingWinningZone"
            packageVersion = "1.0.0"
        }
    }
}
