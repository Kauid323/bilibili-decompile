package kntr.base.apm.network.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: NetworkMetricsReportModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002 !B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsReportModel;", "", "startTime", "", "requestCount", "", "requestSize", "receiveSize", "isFirstLaunch", "", "<init>", "(IJJJZ)V", "getStartTime", "()I", "setStartTime", "(I)V", "getRequestCount", "()J", "setRequestCount", "(J)V", "getRequestSize", "setRequestSize", "getReceiveSize", "setReceiveSize", "()Z", "setFirstLaunch", "(Z)V", "asMap", "", "", "group", "Lkntr/base/apm/network/internal/NetworkMetricsReportModel$Group;", "Group", "ResourceItem", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetworkMetricsReportModel {
    private boolean isFirstLaunch;
    private long receiveSize;
    private long requestCount;
    private long requestSize;
    private int startTime;

    public NetworkMetricsReportModel() {
        this(0, 0L, 0L, 0L, false, 31, null);
    }

    public NetworkMetricsReportModel(int startTime, long requestCount, long requestSize, long receiveSize, boolean isFirstLaunch) {
        this.startTime = startTime;
        this.requestCount = requestCount;
        this.requestSize = requestSize;
        this.receiveSize = receiveSize;
        this.isFirstLaunch = isFirstLaunch;
    }

    public /* synthetic */ NetworkMetricsReportModel(int i, long j, long j2, long j3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) == 0 ? j3 : 0L, (i2 & 16) == 0 ? z : false);
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(int i) {
        this.startTime = i;
    }

    public final long getRequestCount() {
        return this.requestCount;
    }

    public final void setRequestCount(long j) {
        this.requestCount = j;
    }

    public final long getRequestSize() {
        return this.requestSize;
    }

    public final void setRequestSize(long j) {
        this.requestSize = j;
    }

    public final long getReceiveSize() {
        return this.receiveSize;
    }

    public final void setReceiveSize(long j) {
        this.receiveSize = j;
    }

    public final boolean isFirstLaunch() {
        return this.isFirstLaunch;
    }

    public final void setFirstLaunch(boolean z) {
        this.isFirstLaunch = z;
    }

    /* compiled from: NetworkMetricsReportModel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsReportModel$Group;", "", "<init>", "()V", "resource", "", "", "Lkntr/base/apm/network/internal/NetworkMetricsReportModel$ResourceItem;", "updateResource", "", "item", "dumpAsJson", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Group {
        private final Map<String, ResourceItem> resource = new LinkedHashMap();

        public final void updateResource(ResourceItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            String name = item.getName();
            Map<String, ResourceItem> map = this.resource;
            ResourceItem resourceItem = this.resource.get(name);
            ResourceItem it = resourceItem == null ? new ResourceItem(name, 0L, 0L, 6, null) : resourceItem;
            map.put(name, ResourceItem.copy$default(it, null, it.getCount() + item.getCount(), it.getTotalSize() + item.getTotalSize(), 1, null));
        }

        public final String dumpAsJson() {
            try {
                StringFormat $this$encodeToString$iv = Json.Default;
                Iterable $this$associate$iv = this.resource.values();
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $this$associate$iv) {
                    ResourceItem it = (ResourceItem) element$iv$iv;
                    Pair pair = TuplesKt.to(it.getName(), it.asMap());
                    destination$iv$iv.put(pair.getFirst(), pair.getSecond());
                }
                Object value$iv = MapsKt.mapOf(TuplesKt.to("resource", destination$iv$iv));
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, new LinkedHashMapSerializer(StringSerializer.INSTANCE, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE))), value$iv);
            } catch (Exception e) {
                UtilsKt.logE("Group", "dumpAsJson", e);
                return "";
            }
        }
    }

    /* compiled from: NetworkMetricsReportModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsReportModel$ResourceItem;", "", "name", "", "count", "", "totalSize", "<init>", "(Ljava/lang/String;JJ)V", "getName", "()Ljava/lang/String;", "getCount", "()J", "getTotalSize", "asMap", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ResourceItem {
        private final long count;
        private final String name;
        private final long totalSize;

        public static /* synthetic */ ResourceItem copy$default(ResourceItem resourceItem, String str, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resourceItem.name;
            }
            if ((i & 2) != 0) {
                j = resourceItem.count;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                j2 = resourceItem.totalSize;
            }
            return resourceItem.copy(str, j3, j2);
        }

        public final String component1() {
            return this.name;
        }

        public final long component2() {
            return this.count;
        }

        public final long component3() {
            return this.totalSize;
        }

        public final ResourceItem copy(String str, long j, long j2) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new ResourceItem(str, j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResourceItem) {
                ResourceItem resourceItem = (ResourceItem) obj;
                return Intrinsics.areEqual(this.name, resourceItem.name) && this.count == resourceItem.count && this.totalSize == resourceItem.totalSize;
            }
            return false;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalSize);
        }

        public String toString() {
            String str = this.name;
            long j = this.count;
            return "ResourceItem(name=" + str + ", count=" + j + ", totalSize=" + this.totalSize + ")";
        }

        public ResourceItem(String name, long count, long totalSize) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.count = count;
            this.totalSize = totalSize;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ ResourceItem(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, r4, r6);
            long j3;
            long j4;
            if ((i & 2) == 0) {
                j3 = j;
            } else {
                j3 = 0;
            }
            if ((i & 4) == 0) {
                j4 = j2;
            } else {
                j4 = 0;
            }
        }

        public final String getName() {
            return this.name;
        }

        public final long getCount() {
            return this.count;
        }

        public final long getTotalSize() {
            return this.totalSize;
        }

        public final Map<String, String> asMap() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("cnt", String.valueOf(this.count)), TuplesKt.to("size", String.valueOf(this.totalSize))});
        }
    }

    public final Map<String, String> asMap(Group group) {
        Intrinsics.checkNotNullParameter(group, "group");
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("start_time", String.valueOf(this.startTime));
        pairArr[1] = TuplesKt.to("process", Utils_androidKt.getCurrentProcessName());
        pairArr[2] = TuplesKt.to("req_size", String.valueOf(this.requestSize));
        pairArr[3] = TuplesKt.to("req_cnt", String.valueOf(this.requestCount));
        pairArr[4] = TuplesKt.to("recv_size", String.valueOf(this.receiveSize));
        pairArr[5] = TuplesKt.to("group", group.dumpAsJson());
        pairArr[6] = TuplesKt.to("is_first_launch", this.isFirstLaunch ? "1" : "0");
        return MapsKt.mapOf(pairArr);
    }
}