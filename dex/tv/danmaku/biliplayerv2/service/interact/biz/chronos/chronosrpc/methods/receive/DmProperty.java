package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdateDanmakuInputPanel.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/DmProperty;", "", "<init>", "()V", "color", "", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fontsize", "getFontsize", "setFontsize", "pool", "getPool", "setPool", "mode", "getMode", "setMode", "checkboxType", "getCheckboxType", "setCheckboxType", "avatarId", "", "getAvatarId", "()Ljava/lang/String;", "setAvatarId", "(Ljava/lang/String;)V", "avatarType", "getAvatarType", "setAvatarType", "parentId", "getParentId", "setParentId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DmProperty {
    @JSONField(name = "avatar_id")
    private String avatarId;
    @JSONField(name = "avatar_type")
    private Integer avatarType;
    @JSONField(name = "checkbox_type")
    private Integer checkboxType;
    @JSONField(name = "parent_id")
    private String parentId;
    @JSONField(name = "color")
    private Integer color = -1;
    @JSONField(name = "fontsize")
    private Integer fontsize = -1;
    @JSONField(name = "pool")
    private Integer pool = 0;
    @JSONField(name = "mode")
    private Integer mode = 0;

    public final Integer getColor() {
        return this.color;
    }

    public final void setColor(Integer num) {
        this.color = num;
    }

    public final Integer getFontsize() {
        return this.fontsize;
    }

    public final void setFontsize(Integer num) {
        this.fontsize = num;
    }

    public final Integer getPool() {
        return this.pool;
    }

    public final void setPool(Integer num) {
        this.pool = num;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final void setMode(Integer num) {
        this.mode = num;
    }

    public final Integer getCheckboxType() {
        return this.checkboxType;
    }

    public final void setCheckboxType(Integer num) {
        this.checkboxType = num;
    }

    public final String getAvatarId() {
        return this.avatarId;
    }

    public final void setAvatarId(String str) {
        this.avatarId = str;
    }

    public final Integer getAvatarType() {
        return this.avatarType;
    }

    public final void setAvatarType(Integer num) {
        this.avatarType = num;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }
}