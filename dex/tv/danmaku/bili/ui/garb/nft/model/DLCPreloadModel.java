package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: DLCPreloadModel.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCPreloadModel;", "", "callbackId", "", "resources", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCallbackId", "()Ljava/lang/String;", "getResources", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCPreloadModel {
    public static final int $stable = 8;
    @SerializedName(AuthResultCbHelper.ARGS_CALLBACK)
    private final String callbackId;
    @SerializedName("resources")
    private final List<String> resources;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DLCPreloadModel copy$default(DLCPreloadModel dLCPreloadModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dLCPreloadModel.callbackId;
        }
        if ((i & 2) != 0) {
            list = dLCPreloadModel.resources;
        }
        return dLCPreloadModel.copy(str, list);
    }

    public final String component1() {
        return this.callbackId;
    }

    public final List<String> component2() {
        return this.resources;
    }

    public final DLCPreloadModel copy(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "callbackId");
        Intrinsics.checkNotNullParameter(list, "resources");
        return new DLCPreloadModel(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCPreloadModel) {
            DLCPreloadModel dLCPreloadModel = (DLCPreloadModel) obj;
            return Intrinsics.areEqual(this.callbackId, dLCPreloadModel.callbackId) && Intrinsics.areEqual(this.resources, dLCPreloadModel.resources);
        }
        return false;
    }

    public int hashCode() {
        return (this.callbackId.hashCode() * 31) + this.resources.hashCode();
    }

    public String toString() {
        String str = this.callbackId;
        return "DLCPreloadModel(callbackId=" + str + ", resources=" + this.resources + ")";
    }

    public DLCPreloadModel(String callbackId, List<String> list) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(list, "resources");
        this.callbackId = callbackId;
        this.resources = list;
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final List<String> getResources() {
        return this.resources;
    }
}