package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import de.oliver.fancysitula.api.packets.FS_ClientboundCreateOrUpdateTeamPacket;
import de.oliver.fancysitula.api.teams.FS_Team;

import java.util.List;

public class TeamFactory {

    public void createTeamFor(FS_RealPlayer player, FS_Team team) {
        FS_ClientboundCreateOrUpdateTeamPacket packet = FancySitula.PACKET_FACTORY.createCreateOrUpdateTeamPacket(
                team.getTeamName(),
                new FS_ClientboundCreateOrUpdateTeamPacket.CreateTeam(
                        team.getDisplayName(),
                        team.isAllowFriendlyFire(),
                        team.isCanSeeFriendlyInvisibles(),
                        team.getNameTagVisibility(),
                        team.getCollisionRule(),
                        team.getColor(),
                        team.getPrefix(),
                        team.getSuffix(),
                        team.getEntities()
                )
        );

        player.sendPacket(packet);
    }

    public void removeTeamFor(FS_RealPlayer player, FS_Team team) {
        FS_ClientboundCreateOrUpdateTeamPacket packet = FancySitula.PACKET_FACTORY.createCreateOrUpdateTeamPacket(
                team.getTeamName(),
                new FS_ClientboundCreateOrUpdateTeamPacket.RemoveTeam()
        );

        player.sendPacket(packet);
    }

    /**
     * Updates the team for the player. But does not add or remove entities.
     */
    public void updateTeamFor(FS_RealPlayer player, FS_Team team) {
        FS_ClientboundCreateOrUpdateTeamPacket packet = FancySitula.PACKET_FACTORY.createCreateOrUpdateTeamPacket(
                team.getTeamName(),
                new FS_ClientboundCreateOrUpdateTeamPacket.UpdateTeam(
                        team.getDisplayName(),
                        team.isAllowFriendlyFire(),
                        team.isCanSeeFriendlyInvisibles(),
                        team.getNameTagVisibility(),
                        team.getCollisionRule(),
                        team.getColor(),
                        team.getPrefix(),
                        team.getSuffix()
                )
        );

        player.sendPacket(packet);
    }

    public void addEntitiesToTeamFor(FS_RealPlayer player, FS_Team team, List<String> entities) {
        FS_ClientboundCreateOrUpdateTeamPacket packet = FancySitula.PACKET_FACTORY.createCreateOrUpdateTeamPacket(
                team.getTeamName(),
                new FS_ClientboundCreateOrUpdateTeamPacket.AddEntity(entities)
        );

        player.sendPacket(packet);
    }

    public void removeEntitiesFromTeamFor(FS_RealPlayer player, FS_Team team, List<String> entities) {
        FS_ClientboundCreateOrUpdateTeamPacket packet = FancySitula.PACKET_FACTORY.createCreateOrUpdateTeamPacket(
                team.getTeamName(),
                new FS_ClientboundCreateOrUpdateTeamPacket.RemoveEntity(entities)
        );

        player.sendPacket(packet);
    }
}
