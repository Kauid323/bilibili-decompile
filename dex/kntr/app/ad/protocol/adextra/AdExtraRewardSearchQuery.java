package kntr.app.ad.protocol.adextra;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraRewardSearchQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "pluginRequestId", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.PLUGIN, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPluginRequestId", "()Ljava/lang/String;", "getPlugin", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraRewardSearchQuery implements IAdExtraQuery {
    private final String plugin;
    private final String pluginRequestId;

    public AdExtraRewardSearchQuery() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ AdExtraRewardSearchQuery copy$default(AdExtraRewardSearchQuery adExtraRewardSearchQuery, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraRewardSearchQuery.pluginRequestId;
        }
        if ((i & 2) != 0) {
            str2 = adExtraRewardSearchQuery.plugin;
        }
        return adExtraRewardSearchQuery.copy(str, str2);
    }

    public final String component1() {
        return this.pluginRequestId;
    }

    public final String component2() {
        return this.plugin;
    }

    public final AdExtraRewardSearchQuery copy(String str, String str2) {
        return new AdExtraRewardSearchQuery(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraRewardSearchQuery) {
            AdExtraRewardSearchQuery adExtraRewardSearchQuery = (AdExtraRewardSearchQuery) obj;
            return Intrinsics.areEqual(this.pluginRequestId, adExtraRewardSearchQuery.pluginRequestId) && Intrinsics.areEqual(this.plugin, adExtraRewardSearchQuery.plugin);
        }
        return false;
    }

    public int hashCode() {
        return ((this.pluginRequestId == null ? 0 : this.pluginRequestId.hashCode()) * 31) + (this.plugin != null ? this.plugin.hashCode() : 0);
    }

    public String toString() {
        String str = this.pluginRequestId;
        return "AdExtraRewardSearchQuery(pluginRequestId=" + str + ", plugin=" + this.plugin + ")";
    }

    public AdExtraRewardSearchQuery(String pluginRequestId, String plugin) {
        this.pluginRequestId = pluginRequestId;
        this.plugin = plugin;
    }

    public /* synthetic */ AdExtraRewardSearchQuery(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getPluginRequestId() {
        return this.pluginRequestId;
    }

    public final String getPlugin() {
        return this.plugin;
    }
}