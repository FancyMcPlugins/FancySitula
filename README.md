![](fancysitula_title.png)

> [!CAUTION]
> This repository is no longer maintained and has been merged into our new monorepo: [https://github.com/FancyMcPlugins/fancyplugins](https://github.com/FancyMcPlugins/fancyplugins).
>
> For the latest updates, issues, and contributions, please visit the monorepo. This repo remains available for historical reference but will no longer receive updates.
>
> Read [this blog article](https://docs.fancyplugins.de/blog/why-monorepo/) to learn more about the reasons, why we switched to a monorepo.

## Using Minecraft internals made easier.

Initially developed for FancyNpcs and FancyHolograms, FancySitula is a library that simplifies the process of
interacting with Minecraft internals. It provides a simple and easy to use API to interact with Minecraft packets and
entities.

## Features

- Easy to use API for creating and sending packets
- Powerful factory classes for creating packets
- Wrapper classes for Minecraft packets and entities
- Support for multiple Minecraft versions
- No third-party dependencies and works out of the box

## Supported packets

The following packets are currently supported:

- ClientboundAddEntityPacket
- ClientboundPlayerInfoRemovePacket
- ClientboundPlayerInfoUpdatePacket
- ClientboundRemoveEntitiesPacket
- ClientboundRotateHeadPacket
- ClientboundSetEntityDataPacket
- ClientboundSetEquipmentPacket
- ClientboundTeleportEntityPacket

More packets will be added when needed / requested (contributions are welcome).

## Supported Minecraft versions

FancySitula will support the latest Minecraft version and additional older versions. The following versions are
supported:

- [x] 1.21.1
- [x] 1.21
- [x] 1.20.6
- [x] 1.20.5
- [ ] 1.20.4
- [ ] 1.20.2
- [ ] 1.20.1

## Missing Packets for FancyNpcs

- [x] ClientboundPlayerInfoUpdatePacket
- [x] ClientboundAddEntityPacket
- [x] ClientboundPlayerInfoRemovePacket
- [x] ClientboundRemoveEntitiesPacket
- [x] ClientboundTeleportEntityPacket
- [x] ClientboundRotateHeadPacket
- [x] ClientboundSetEquipmentPacket
- [x] ClientboundSetEntityDataPacket
- [x] ClientboundSetPlayerTeamPacket
- [ ] ClientboundUpdateAttributesPacket
- [ ] ClientboundAnimatePacket
- [ ] ClientboundSetPassengersPacket
