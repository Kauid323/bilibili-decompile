package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.Bson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: DLCCardRewardModel.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/ReportVo;", "", ReportEvent.EVENT_TYPE_SHOW, "Ltv/danmaku/bili/ui/garb/nft/model/ReportVo$Content;", "click", "<init>", "(Ltv/danmaku/bili/ui/garb/nft/model/ReportVo$Content;Ltv/danmaku/bili/ui/garb/nft/model/ReportVo$Content;)V", "getShow", "()Ltv/danmaku/bili/ui/garb/nft/model/ReportVo$Content;", "getClick", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Content", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReportVo {
    public static final int $stable = 8;
    private final Content click;
    private final Content show;

    public static /* synthetic */ ReportVo copy$default(ReportVo reportVo, Content content, Content content2, int i, Object obj) {
        if ((i & 1) != 0) {
            content = reportVo.show;
        }
        if ((i & 2) != 0) {
            content2 = reportVo.click;
        }
        return reportVo.copy(content, content2);
    }

    public final Content component1() {
        return this.show;
    }

    public final Content component2() {
        return this.click;
    }

    public final ReportVo copy(Content content, Content content2) {
        Intrinsics.checkNotNullParameter(content, ReportEvent.EVENT_TYPE_SHOW);
        Intrinsics.checkNotNullParameter(content2, "click");
        return new ReportVo(content, content2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReportVo) {
            ReportVo reportVo = (ReportVo) obj;
            return Intrinsics.areEqual(this.show, reportVo.show) && Intrinsics.areEqual(this.click, reportVo.click);
        }
        return false;
    }

    public int hashCode() {
        return (this.show.hashCode() * 31) + this.click.hashCode();
    }

    public String toString() {
        Content content = this.show;
        return "ReportVo(show=" + content + ", click=" + this.click + ")";
    }

    public ReportVo(Content show, Content click) {
        Intrinsics.checkNotNullParameter(show, ReportEvent.EVENT_TYPE_SHOW);
        Intrinsics.checkNotNullParameter(click, "click");
        this.show = show;
        this.click = click;
    }

    public final Content getShow() {
        return this.show;
    }

    public final Content getClick() {
        return this.click;
    }

    /* compiled from: DLCCardRewardModel.kt */
    @Bson
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/ReportVo$Content;", "", "eventId", "", "params", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventId", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Content {
        public static final int $stable = 8;
        private final String eventId;
        private final Map<String, String> params;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Content copy$default(Content content, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = content.eventId;
            }
            if ((i & 2) != 0) {
                map = content.params;
            }
            return content.copy(str, map);
        }

        public final String component1() {
            return this.eventId;
        }

        public final Map<String, String> component2() {
            return this.params;
        }

        public final Content copy(String str, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Intrinsics.checkNotNullParameter(map, "params");
            return new Content(str, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.eventId, content.eventId) && Intrinsics.areEqual(this.params, content.params);
            }
            return false;
        }

        public int hashCode() {
            return (this.eventId.hashCode() * 31) + this.params.hashCode();
        }

        public String toString() {
            String str = this.eventId;
            return "Content(eventId=" + str + ", params=" + this.params + ")";
        }

        public Content(String eventId, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(map, "params");
            this.eventId = eventId;
            this.params = map;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final Map<String, String> getParams() {
            return this.params;
        }
    }
}