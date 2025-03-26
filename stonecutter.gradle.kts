plugins {
    id("dev.kikugie.stonecutter")
    id("fabric-loom") version "1.10-SNAPSHOT" apply false
    id("me.modmuss50.mod-publish-plugin") version "0.5.1" apply false
}

stonecutter active "1.21.5" /* [SC] DO NOT EDIT */

// Read the versions from CHISELED_VERSIONS, and only build / publish those versions.
// If it's blank, we build / publish all available versions.
val chiseledVersions = providers.environmentVariable("CHISELED_VERSIONS")
    .orNull?.ifBlank { null }?.split(",")

// Build every version into `build/libs`.
stonecutter registerChiseled tasks.register("chiseledBuild", stonecutter.chiseled) {
    versions { _, it -> chiseledVersions?.contains(it.version) ?: true }
    group = "project"
    ofTask("buildAndCollect")
}

// Publish every version after building.
stonecutter registerChiseled tasks.register("chiseledPublish", stonecutter.chiseled) {
    versions { _, it -> chiseledVersions?.contains(it.version) ?: true }
    group = "project"
    ofTask("publishMods")
}

for (version in stonecutter.versions) {
    if (version != stonecutter.current) continue
    tasks.register("runActiveClient") {
        dependsOn(":${version.project}:runClient")
        group = "project"
    }
}
