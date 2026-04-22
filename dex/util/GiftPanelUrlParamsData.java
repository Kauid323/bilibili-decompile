package util;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveGiftUrlSplicing.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ`\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lutil/GiftPanelUrlParamsData;", "", "url", "", "giftId", "", "isMultiVoice", "", "selectedUsers", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "extraParams", "", "originGiftId", "<init>", "(Ljava/lang/String;JZLjava/util/List;Ljava/util/Map;Ljava/lang/Long;)V", "getUrl", "()Ljava/lang/String;", "getGiftId", "()J", "()Z", "getSelectedUsers", "()Ljava/util/List;", "getExtraParams", "()Ljava/util/Map;", "getOriginGiftId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JZLjava/util/List;Ljava/util/Map;Ljava/lang/Long;)Lutil/GiftPanelUrlParamsData;", "equals", "other", "hashCode", "", "toString", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GiftPanelUrlParamsData {
    private final Map<String, String> extraParams;
    private final long giftId;
    private final boolean isMultiVoice;
    private final Long originGiftId;
    private final List<LiveGiftPanelMicUserInfo> selectedUsers;
    private final String url;

    public static /* synthetic */ GiftPanelUrlParamsData copy$default(GiftPanelUrlParamsData giftPanelUrlParamsData, String str, long j, boolean z, List list, Map map, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giftPanelUrlParamsData.url;
        }
        if ((i & 2) != 0) {
            j = giftPanelUrlParamsData.giftId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z = giftPanelUrlParamsData.isMultiVoice;
        }
        boolean z2 = z;
        List<LiveGiftPanelMicUserInfo> list2 = list;
        if ((i & 8) != 0) {
            list2 = giftPanelUrlParamsData.selectedUsers;
        }
        List list3 = list2;
        Map<String, String> map2 = map;
        if ((i & 16) != 0) {
            map2 = giftPanelUrlParamsData.extraParams;
        }
        Map map3 = map2;
        if ((i & 32) != 0) {
            l = giftPanelUrlParamsData.originGiftId;
        }
        return giftPanelUrlParamsData.copy(str, j2, z2, list3, map3, l);
    }

    public final String component1() {
        return this.url;
    }

    public final long component2() {
        return this.giftId;
    }

    public final boolean component3() {
        return this.isMultiVoice;
    }

    public final List<LiveGiftPanelMicUserInfo> component4() {
        return this.selectedUsers;
    }

    public final Map<String, String> component5() {
        return this.extraParams;
    }

    public final Long component6() {
        return this.originGiftId;
    }

    public final GiftPanelUrlParamsData copy(String str, long j, boolean z, List<LiveGiftPanelMicUserInfo> list, Map<String, String> map, Long l) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(list, "selectedUsers");
        return new GiftPanelUrlParamsData(str, j, z, list, map, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GiftPanelUrlParamsData) {
            GiftPanelUrlParamsData giftPanelUrlParamsData = (GiftPanelUrlParamsData) obj;
            return Intrinsics.areEqual(this.url, giftPanelUrlParamsData.url) && this.giftId == giftPanelUrlParamsData.giftId && this.isMultiVoice == giftPanelUrlParamsData.isMultiVoice && Intrinsics.areEqual(this.selectedUsers, giftPanelUrlParamsData.selectedUsers) && Intrinsics.areEqual(this.extraParams, giftPanelUrlParamsData.extraParams) && Intrinsics.areEqual(this.originGiftId, giftPanelUrlParamsData.originGiftId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.url.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.giftId)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMultiVoice)) * 31) + this.selectedUsers.hashCode()) * 31) + (this.extraParams == null ? 0 : this.extraParams.hashCode())) * 31) + (this.originGiftId != null ? this.originGiftId.hashCode() : 0);
    }

    public String toString() {
        String str = this.url;
        long j = this.giftId;
        boolean z = this.isMultiVoice;
        List<LiveGiftPanelMicUserInfo> list = this.selectedUsers;
        Map<String, String> map = this.extraParams;
        return "GiftPanelUrlParamsData(url=" + str + ", giftId=" + j + ", isMultiVoice=" + z + ", selectedUsers=" + list + ", extraParams=" + map + ", originGiftId=" + this.originGiftId + ")";
    }

    public GiftPanelUrlParamsData(String url, long giftId, boolean isMultiVoice, List<LiveGiftPanelMicUserInfo> list, Map<String, String> map, Long originGiftId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(list, "selectedUsers");
        this.url = url;
        this.giftId = giftId;
        this.isMultiVoice = isMultiVoice;
        this.selectedUsers = list;
        this.extraParams = map;
        this.originGiftId = originGiftId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GiftPanelUrlParamsData(String str, long j, boolean z, List list, Map map, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, z, list, r7, r8);
        Map map2;
        Long l2;
        if ((i & 16) == 0) {
            map2 = map;
        } else {
            map2 = null;
        }
        if ((i & 32) == 0) {
            l2 = l;
        } else {
            l2 = 0L;
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getGiftId() {
        return this.giftId;
    }

    public final boolean isMultiVoice() {
        return this.isMultiVoice;
    }

    public final List<LiveGiftPanelMicUserInfo> getSelectedUsers() {
        return this.selectedUsers;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final Long getOriginGiftId() {
        return this.originGiftId;
    }
}