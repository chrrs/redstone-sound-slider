import me.modmuss50.mpp.ReleaseType

plugins {
    id("fabric-loom")
    id("me.modmuss50.mod-publish-plugin")
}

fun Project.hasProp(namespace: String, key: String) = hasProperty("$namespace.$key")
fun Project.prop(namespace: String, key: String) = property("$namespace.$key") as String

val minecraft = stonecutter.current.version

group = prop("mod", "group")
version = "${prop("mod", "version")}+mc$minecraft-fabric"
base.archivesName.set(prop("mod", "name"))

repositories {
    maven("https://maven.shedaniel.me/")
    maven("https://maven.terraformersmc.com/releases/")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraft")
    mappings("net.fabricmc:yarn:${prop("fabric", "yarnVersion")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${prop("fabric", "loaderVersion")}")

    fun fabricApiModule(name: String) =
        modImplementation(fabricApi.module(name, prop("fabric", "apiVersion")))
    fabricApiModule("fabric-resource-loader-v0")

    modCompileOnly("com.terraformersmc:modmenu:${prop("modmenu", "version")}")
    modCompileOnly("me.shedaniel.cloth:cloth-config-fabric:${prop("clothconfig", "version")}")
}

loom {
    runConfigs.all {
        isIdeConfigGenerated = false
        runDir = "../../run"
        vmArgs("-Dmixin.debug.export=true")
    }
}

java {
    val java = if (stonecutter.eval(minecraft, ">=1.20.5"))
        JavaVersion.VERSION_21 else JavaVersion.VERSION_17
    targetCompatibility = java
    sourceCompatibility = java
}

tasks {
    jar {
        from("LICENSE")
    }

    processResources {
        // We construct our minecraft dependency string based on the versions provided in gradle.properties
        val platformVersions = prop("platform", "versions").split(",")
        val minecraftDependency = if (platformVersions.size == 1)
            platformVersions.first() else ">=${platformVersions.first()} <=${platformVersions.last()}"

        filesMatching("fabric.mod.json") {
            expand(
                "version" to prop("mod", "version"),
                "minecraft" to minecraftDependency,
            )
        }
    }

    build {
        group = "versioned"
        description = "Must run through `chiseledBuild`"
    }
}

publishMods {
    val versions = prop("platform", "versions").split(",")
    val modVersion = prop("mod", "version")
    changelog.set(providers.environmentVariable("CHANGELOG"))

    type = when {
        modVersion.contains("alpha") -> ReleaseType.ALPHA
        modVersion.contains("beta") -> ReleaseType.BETA
        else -> ReleaseType.STABLE
    }

    displayName.set("$modVersion - Fabric $minecraft")
    version.set(project.version.toString())
    modLoaders.addAll(prop("platform", "loaders").split(","))
    file.set(tasks.remapJar.get().archiveFile)

    modrinth {
        projectId.set(prop("modrinth", "id"))
        accessToken.set(providers.environmentVariable("MODRINTH_TOKEN"))
        minecraftVersions.addAll(versions)
        optional("cloth-config")
    }

    curseforge {
        projectId.set(prop("curseforge", "id"))
        accessToken.set(providers.environmentVariable("CURSEFORGE_TOKEN"))
        minecraftVersions.addAll(versions)
        optional("cloth-config")
    }
}