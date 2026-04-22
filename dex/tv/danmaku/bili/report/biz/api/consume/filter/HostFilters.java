package tv.danmaku.bili.report.biz.api.consume.filter;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;

/* compiled from: HostFilters.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/filter/HostFilters;", "", "<init>", "()V", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HostFilters {
    public static final Companion Companion = new Companion(null);

    /* compiled from: HostFilters.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/filter/HostFilters$Companion;", "", "<init>", "()V", "isReportSelf", "", "event", "Ltv/danmaku/bili/report/biz/api/produce/model/RequestEvent;", "reportRequest", ReportEvent.Tag.HOST, "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isReportSelf(RequestEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            String str = event.host;
            return (str == null || StringsKt.isBlank(str)) || Intrinsics.areEqual("data.bilibili.com", event.host);
        }

        public final boolean reportRequest(String host) {
            Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
            return Intrinsics.areEqual("dataflow.biliapi.com", host) || Intrinsics.areEqual("data.bilibili.com", host) || Intrinsics.areEqual("apm-misaka.biliapi.net", host);
        }
    }

    @JvmStatic
    public static final boolean isReportSelf(RequestEvent event) {
        return Companion.isReportSelf(event);
    }
}