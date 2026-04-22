package tv.danmaku.bili.ui.garb.api.collection;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BiliCollectionUserData.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionUserData;", "", "avatar", "", "mid", "", ChannelRoutes.CHANNEL_NAME, "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getMid", "()J", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionUserData {
    public static final int $stable = 0;
    @SerializedName("avatar")
    private final String avatar;
    @SerializedName("mid")
    private final long mid;
    @SerializedName(ChannelRoutes.CHANNEL_NAME)
    private final String name;

    public static /* synthetic */ BiliCollectionUserData copy$default(BiliCollectionUserData biliCollectionUserData, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = biliCollectionUserData.avatar;
        }
        if ((i & 2) != 0) {
            j = biliCollectionUserData.mid;
        }
        if ((i & 4) != 0) {
            str2 = biliCollectionUserData.name;
        }
        return biliCollectionUserData.copy(str, j, str2);
    }

    public final String component1() {
        return this.avatar;
    }

    public final long component2() {
        return this.mid;
    }

    public final String component3() {
        return this.name;
    }

    public final BiliCollectionUserData copy(String str, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, ChannelRoutes.CHANNEL_NAME);
        return new BiliCollectionUserData(str, j, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionUserData) {
            BiliCollectionUserData biliCollectionUserData = (BiliCollectionUserData) obj;
            return Intrinsics.areEqual(this.avatar, biliCollectionUserData.avatar) && this.mid == biliCollectionUserData.mid && Intrinsics.areEqual(this.name, biliCollectionUserData.name);
        }
        return false;
    }

    public int hashCode() {
        return (((this.avatar.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.name.hashCode();
    }

    public String toString() {
        String str = this.avatar;
        long j = this.mid;
        return "BiliCollectionUserData(avatar=" + str + ", mid=" + j + ", name=" + this.name + ")";
    }

    public BiliCollectionUserData(String avatar, long mid, String name) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        this.avatar = avatar;
        this.mid = mid;
        this.name = name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getMid() {
        return this.mid;
    }

    public final String getName() {
        return this.name;
    }
}