package tv.danmaku.biliplayerv2.service.interact.biz.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: DanmakuFeedbackInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006."}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFeedbackInfo;", "", "dmId", "", "content", "nickname", RankRouter.BundleKey.AUTHOR_SPACE_MID, "", "type", "", "duration", "appearanceTime", "userHash", "oid", "aid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJJLjava/lang/String;Ljava/lang/String;J)V", "getDmId", "()Ljava/lang/String;", "getContent", "getNickname", "getMid", "()J", "getType", "()I", "getDuration", "getAppearanceTime", "getUserHash", "getOid", "getAid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuFeedbackInfo {
    private final long aid;
    private final long appearanceTime;
    private final String content;
    private final String dmId;
    private final long duration;
    private final long mid;
    private final String nickname;
    private final String oid;
    private final int type;
    private final String userHash;

    public final String component1() {
        return this.dmId;
    }

    public final long component10() {
        return this.aid;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.nickname;
    }

    public final long component4() {
        return this.mid;
    }

    public final int component5() {
        return this.type;
    }

    public final long component6() {
        return this.duration;
    }

    public final long component7() {
        return this.appearanceTime;
    }

    public final String component8() {
        return this.userHash;
    }

    public final String component9() {
        return this.oid;
    }

    public final DanmakuFeedbackInfo copy(String str, String str2, String str3, long j, int i, long j2, long j3, String str4, String str5, long j4) {
        Intrinsics.checkNotNullParameter(str, "dmId");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "nickname");
        Intrinsics.checkNotNullParameter(str4, "userHash");
        Intrinsics.checkNotNullParameter(str5, "oid");
        return new DanmakuFeedbackInfo(str, str2, str3, j, i, j2, j3, str4, str5, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DanmakuFeedbackInfo) {
            DanmakuFeedbackInfo danmakuFeedbackInfo = (DanmakuFeedbackInfo) obj;
            return Intrinsics.areEqual(this.dmId, danmakuFeedbackInfo.dmId) && Intrinsics.areEqual(this.content, danmakuFeedbackInfo.content) && Intrinsics.areEqual(this.nickname, danmakuFeedbackInfo.nickname) && this.mid == danmakuFeedbackInfo.mid && this.type == danmakuFeedbackInfo.type && this.duration == danmakuFeedbackInfo.duration && this.appearanceTime == danmakuFeedbackInfo.appearanceTime && Intrinsics.areEqual(this.userHash, danmakuFeedbackInfo.userHash) && Intrinsics.areEqual(this.oid, danmakuFeedbackInfo.oid) && this.aid == danmakuFeedbackInfo.aid;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.dmId.hashCode() * 31) + this.content.hashCode()) * 31) + this.nickname.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.type) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.appearanceTime)) * 31) + this.userHash.hashCode()) * 31) + this.oid.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid);
    }

    public String toString() {
        String str = this.dmId;
        String str2 = this.content;
        String str3 = this.nickname;
        long j = this.mid;
        int i = this.type;
        long j2 = this.duration;
        long j3 = this.appearanceTime;
        String str4 = this.userHash;
        String str5 = this.oid;
        return "DanmakuFeedbackInfo(dmId=" + str + ", content=" + str2 + ", nickname=" + str3 + ", mid=" + j + ", type=" + i + ", duration=" + j2 + ", appearanceTime=" + j3 + ", userHash=" + str4 + ", oid=" + str5 + ", aid=" + this.aid + ")";
    }

    public DanmakuFeedbackInfo(String dmId, String content, String nickname, long mid, int type, long duration, long appearanceTime, String userHash, String oid, long aid) {
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(userHash, "userHash");
        Intrinsics.checkNotNullParameter(oid, "oid");
        this.dmId = dmId;
        this.content = content;
        this.nickname = nickname;
        this.mid = mid;
        this.type = type;
        this.duration = duration;
        this.appearanceTime = appearanceTime;
        this.userHash = userHash;
        this.oid = oid;
        this.aid = aid;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DanmakuFeedbackInfo(String str, String str2, String str3, long j, int i, long j2, long j3, String str4, String str5, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, i, j2, j3, r14, r15, j4);
        String str6;
        String str7;
        if ((i2 & 128) == 0) {
            str6 = str4;
        } else {
            str6 = "";
        }
        if ((i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            str7 = str5;
        } else {
            str7 = "";
        }
    }

    public final String getDmId() {
        return this.dmId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getMid() {
        return this.mid;
    }

    public final int getType() {
        return this.type;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getAppearanceTime() {
        return this.appearanceTime;
    }

    public final String getUserHash() {
        return this.userHash;
    }

    public final String getOid() {
        return this.oid;
    }

    public final long getAid() {
        return this.aid;
    }
}