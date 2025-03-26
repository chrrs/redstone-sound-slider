# Redstone Sound Slider

> Adjust your redstone/piston/dispenser volume. That's it.

![Version](https://img.shields.io/github/v/release/chrrs/redstone-sound-slider?include_prereleases&style=flat-square)
![Build status](https://img.shields.io/github/actions/workflow/status/chrrs/redstone-sound-slider/build.yml?style=flat-square)
[![Modrinth](https://img.shields.io/modrinth/dt/yXAvIk0x?style=flat-square&logo=modrinth)](https://modrinth.com/mod/redstone-sound-slider)
[![CurseForge](https://img.shields.io/curseforge/dt/1051344?style=flat-square&logo=curseforge)](https://curseforge.com/minecraft/mc-mods/redstone-sound-slider)

Read more about it on [Modrinth](https://modrinth.com/mod/redstone-sound-slider)
or [CurseForge](https://curseforge.com/minecraft/mc-mods/redstone-sound-slider).

## Project Structure

Redstone Sound Slider supports multiple Minecraft versions using [Stonecutter](https://stonecutter.kikugie.dev/).
The easiest way to interact with this is by using an IDE such as IntelliJ. To switch between versions,
use the Gradle tasks under the `stonecutter` category. To run the game, use the `runActiveClient` task.

Make sure to switch back to the latest version to commit changes.

### Release checklist

- Update the version number.
    - Change in `gradle.properties`.
    - Add an entry in `CHANGELOG.md`.
- Commit and push a new tag. (example: `v1.2.3`)
    - Tag name is the version number prefixed by `v`.
- Manually trigger the Publish workflow on GitHub.
