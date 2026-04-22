package tv.danmaku.biliplayerv2.service.interact.core.sender;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: DanmakuSendParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010I\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00100J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\t\u0010N\u001a\u00020\u0010HÆ\u0003J\t\u0010O\u001a\u00020\u0010HÆ\u0003J\t\u0010P\u001a\u00020\u0010HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÜ\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u000b2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0005HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010*R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b7\u00105\"\u0004\b8\u00109R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001c¨\u0006X"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "", "danmaku", "", "danmakuType", "", "danmakuSize", "danmakuColor", "newType", "parentDanmakuId", "hasExpression", "", "checkboxType", "isCheerTime", "cheerCheckbox", "postType", "", "handleError", "avatarId", "avatarType", "colorful", "avid", "cid", "position", "extra", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZIZLjava/lang/Boolean;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;JJJLjava/lang/String;)V", "getDanmaku", "()Ljava/lang/String;", "setDanmaku", "(Ljava/lang/String;)V", "getDanmakuType", "()I", "setDanmakuType", "(I)V", "getDanmakuSize", "setDanmakuSize", "getDanmakuColor", "setDanmakuColor", "getNewType", "getParentDanmakuId", "getHasExpression", "()Z", "getCheckboxType", "getCheerCheckbox", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPostType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHandleError", "getAvatarId", "getAvatarType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColorful", "setColorful", "(Ljava/lang/Integer;)V", "getAvid", "()J", "getCid", "getPosition", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZIZLjava/lang/Boolean;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;JJJLjava/lang/String;)Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "equals", "other", "hashCode", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuSendParams {
    private final String avatarId;
    private final Integer avatarType;
    private final long avid;
    private final int checkboxType;
    private final Boolean cheerCheckbox;
    private final long cid;
    private Integer colorful;
    private String danmaku;
    private int danmakuColor;
    private int danmakuSize;
    private int danmakuType;
    private final String extra;
    private final boolean handleError;
    private final boolean hasExpression;
    private final boolean isCheerTime;
    private final String newType;
    private final String parentDanmakuId;
    private final long position;
    private final Long postType;

    public final String component1() {
        return this.danmaku;
    }

    public final Boolean component10() {
        return this.cheerCheckbox;
    }

    public final Long component11() {
        return this.postType;
    }

    public final boolean component12() {
        return this.handleError;
    }

    public final String component13() {
        return this.avatarId;
    }

    public final Integer component14() {
        return this.avatarType;
    }

    public final Integer component15() {
        return this.colorful;
    }

    public final long component16() {
        return this.avid;
    }

    public final long component17() {
        return this.cid;
    }

    public final long component18() {
        return this.position;
    }

    public final String component19() {
        return this.extra;
    }

    public final int component2() {
        return this.danmakuType;
    }

    public final int component3() {
        return this.danmakuSize;
    }

    public final int component4() {
        return this.danmakuColor;
    }

    public final String component5() {
        return this.newType;
    }

    public final String component6() {
        return this.parentDanmakuId;
    }

    public final boolean component7() {
        return this.hasExpression;
    }

    public final int component8() {
        return this.checkboxType;
    }

    public final boolean component9() {
        return this.isCheerTime;
    }

    public final DanmakuSendParams copy(String str, int i, int i2, int i3, String str2, String str3, boolean z, int i4, boolean z2, Boolean bool, Long l, boolean z3, String str4, Integer num, Integer num2, long j, long j2, long j3, String str5) {
        Intrinsics.checkNotNullParameter(str2, "newType");
        return new DanmakuSendParams(str, i, i2, i3, str2, str3, z, i4, z2, bool, l, z3, str4, num, num2, j, j2, j3, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DanmakuSendParams) {
            DanmakuSendParams danmakuSendParams = (DanmakuSendParams) obj;
            return Intrinsics.areEqual(this.danmaku, danmakuSendParams.danmaku) && this.danmakuType == danmakuSendParams.danmakuType && this.danmakuSize == danmakuSendParams.danmakuSize && this.danmakuColor == danmakuSendParams.danmakuColor && Intrinsics.areEqual(this.newType, danmakuSendParams.newType) && Intrinsics.areEqual(this.parentDanmakuId, danmakuSendParams.parentDanmakuId) && this.hasExpression == danmakuSendParams.hasExpression && this.checkboxType == danmakuSendParams.checkboxType && this.isCheerTime == danmakuSendParams.isCheerTime && Intrinsics.areEqual(this.cheerCheckbox, danmakuSendParams.cheerCheckbox) && Intrinsics.areEqual(this.postType, danmakuSendParams.postType) && this.handleError == danmakuSendParams.handleError && Intrinsics.areEqual(this.avatarId, danmakuSendParams.avatarId) && Intrinsics.areEqual(this.avatarType, danmakuSendParams.avatarType) && Intrinsics.areEqual(this.colorful, danmakuSendParams.colorful) && this.avid == danmakuSendParams.avid && this.cid == danmakuSendParams.cid && this.position == danmakuSendParams.position && Intrinsics.areEqual(this.extra, danmakuSendParams.extra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((this.danmaku == null ? 0 : this.danmaku.hashCode()) * 31) + this.danmakuType) * 31) + this.danmakuSize) * 31) + this.danmakuColor) * 31) + this.newType.hashCode()) * 31) + (this.parentDanmakuId == null ? 0 : this.parentDanmakuId.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasExpression)) * 31) + this.checkboxType) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCheerTime)) * 31) + (this.cheerCheckbox == null ? 0 : this.cheerCheckbox.hashCode())) * 31) + (this.postType == null ? 0 : this.postType.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.handleError)) * 31) + (this.avatarId == null ? 0 : this.avatarId.hashCode())) * 31) + (this.avatarType == null ? 0 : this.avatarType.hashCode())) * 31) + (this.colorful == null ? 0 : this.colorful.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.position)) * 31) + (this.extra != null ? this.extra.hashCode() : 0);
    }

    public String toString() {
        String str = this.danmaku;
        int i = this.danmakuType;
        int i2 = this.danmakuSize;
        int i3 = this.danmakuColor;
        String str2 = this.newType;
        String str3 = this.parentDanmakuId;
        boolean z = this.hasExpression;
        int i4 = this.checkboxType;
        boolean z2 = this.isCheerTime;
        Boolean bool = this.cheerCheckbox;
        Long l = this.postType;
        boolean z3 = this.handleError;
        String str4 = this.avatarId;
        Integer num = this.avatarType;
        Integer num2 = this.colorful;
        long j = this.avid;
        long j2 = this.cid;
        long j3 = this.position;
        return "DanmakuSendParams(danmaku=" + str + ", danmakuType=" + i + ", danmakuSize=" + i2 + ", danmakuColor=" + i3 + ", newType=" + str2 + ", parentDanmakuId=" + str3 + ", hasExpression=" + z + ", checkboxType=" + i4 + ", isCheerTime=" + z2 + ", cheerCheckbox=" + bool + ", postType=" + l + ", handleError=" + z3 + ", avatarId=" + str4 + ", avatarType=" + num + ", colorful=" + num2 + ", avid=" + j + ", cid=" + j2 + ", position=" + j3 + ", extra=" + this.extra + ")";
    }

    public DanmakuSendParams(String danmaku, int danmakuType, int danmakuSize, int danmakuColor, String newType, String parentDanmakuId, boolean hasExpression, int checkboxType, boolean isCheerTime, Boolean cheerCheckbox, Long postType, boolean handleError, String avatarId, Integer avatarType, Integer colorful, long avid, long cid, long position, String extra) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        this.danmaku = danmaku;
        this.danmakuType = danmakuType;
        this.danmakuSize = danmakuSize;
        this.danmakuColor = danmakuColor;
        this.newType = newType;
        this.parentDanmakuId = parentDanmakuId;
        this.hasExpression = hasExpression;
        this.checkboxType = checkboxType;
        this.isCheerTime = isCheerTime;
        this.cheerCheckbox = cheerCheckbox;
        this.postType = postType;
        this.handleError = handleError;
        this.avatarId = avatarId;
        this.avatarType = avatarType;
        this.colorful = colorful;
        this.avid = avid;
        this.cid = cid;
        this.position = position;
        this.extra = extra;
    }

    public /* synthetic */ DanmakuSendParams(String str, int i, int i2, int i3, String str2, String str3, boolean z, int i4, boolean z2, Boolean bool, Long l, boolean z3, String str4, Integer num, Integer num2, long j, long j2, long j3, String str5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 1 : i, (i5 & 4) != 0 ? 25 : i2, (i5 & 8) != 0 ? 16777215 : i3, (i5 & 16) != 0 ? "1" : str2, (i5 & 32) != 0 ? null : str3, (i5 & 64) != 0 ? false : z, (i5 & 128) != 0 ? 0 : i4, (i5 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? false : z2, (i5 & 512) != 0 ? null : bool, (i5 & 1024) != 0 ? null : l, (i5 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? true : z3, (i5 & 4096) != 0 ? null : str4, (i5 & 8192) != 0 ? null : num, (i5 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? null : num2, j, j2, j3, (i5 & 262144) != 0 ? null : str5);
    }

    public final String getDanmaku() {
        return this.danmaku;
    }

    public final void setDanmaku(String str) {
        this.danmaku = str;
    }

    public final int getDanmakuType() {
        return this.danmakuType;
    }

    public final void setDanmakuType(int i) {
        this.danmakuType = i;
    }

    public final int getDanmakuSize() {
        return this.danmakuSize;
    }

    public final void setDanmakuSize(int i) {
        this.danmakuSize = i;
    }

    public final int getDanmakuColor() {
        return this.danmakuColor;
    }

    public final void setDanmakuColor(int i) {
        this.danmakuColor = i;
    }

    public final String getNewType() {
        return this.newType;
    }

    public final String getParentDanmakuId() {
        return this.parentDanmakuId;
    }

    public final boolean getHasExpression() {
        return this.hasExpression;
    }

    public final int getCheckboxType() {
        return this.checkboxType;
    }

    public final boolean isCheerTime() {
        return this.isCheerTime;
    }

    public final Boolean getCheerCheckbox() {
        return this.cheerCheckbox;
    }

    public final Long getPostType() {
        return this.postType;
    }

    public final boolean getHandleError() {
        return this.handleError;
    }

    public final String getAvatarId() {
        return this.avatarId;
    }

    public final Integer getAvatarType() {
        return this.avatarType;
    }

    public final Integer getColorful() {
        return this.colorful;
    }

    public final void setColorful(Integer num) {
        this.colorful = num;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getPosition() {
        return this.position;
    }

    public final String getExtra() {
        return this.extra;
    }
}