package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;
import de.oliver.fancysitula.api.utils.entityData.TextDisplayData;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.EntityType;

import java.util.List;

public class FS_TextDisplay extends FS_Entity {

    protected FS_ClientboundSetEntityDataPacket.EntityData textData = new FS_ClientboundSetEntityDataPacket.EntityData(TextDisplayData.TEXT, null);
    protected FS_ClientboundSetEntityDataPacket.EntityData lineWidthData = new FS_ClientboundSetEntityDataPacket.EntityData(TextDisplayData.LINE_WIDTH, null);
    protected FS_ClientboundSetEntityDataPacket.EntityData backgroundData = new FS_ClientboundSetEntityDataPacket.EntityData(TextDisplayData.BACKGROUND, null);
    protected FS_ClientboundSetEntityDataPacket.EntityData textOpacityData = new FS_ClientboundSetEntityDataPacket.EntityData(TextDisplayData.TEXT_OPACITY, null);
    protected FS_ClientboundSetEntityDataPacket.EntityData styleFlagsData = new FS_ClientboundSetEntityDataPacket.EntityData(TextDisplayData.STYLE_FLAGS, null);

    public FS_TextDisplay() {
        super(EntityType.TEXT_DISPLAY);
    }

    public Component getText() {
        return (Component) this.textData.getValue();
    }

    public void setText(Component text) {
        this.textData.setValue(text);
    }

    public int getLineWidth() {
        return (int) this.lineWidthData.getValue();
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidthData.setValue(lineWidth);
    }

    public int getBackground() {
        return (int) this.backgroundData.getValue();
    }

    public void setBackground(int background) {
        this.backgroundData.setValue(background);
    }

    public byte getTextOpacity() {
        return (byte) this.textOpacityData.getValue();
    }

    public void setTextOpacity(byte textOpacity) {
        this.textOpacityData.setValue(textOpacity);
    }

    public byte getStyleFlags() {
        return (byte) this.styleFlagsData.getValue();
    }

    public void setStyleFlags(byte styleFlags) {
        this.styleFlagsData.setValue(styleFlags);
    }

    @Override
    public List<FS_ClientboundSetEntityDataPacket.EntityData> getEntityData() {
        List<FS_ClientboundSetEntityDataPacket.EntityData> entityData = super.getEntityData();

        entityData.add(this.textData);
        entityData.add(this.lineWidthData);
        entityData.add(this.backgroundData);
        entityData.add(this.textOpacityData);
        entityData.add(this.styleFlagsData);
        return entityData;
    }
}

