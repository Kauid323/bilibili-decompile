package tv.danmaku.bili.report.sample.rule.backoff;

import com.alibaba.fastjson.JSON;
import com.bilibili.lib.moss.utils.backoff.BackoffConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.rule.path.PathRule;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: PathBackoff.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/backoff/PathBackoff;", "", FileChooserActivity.PATH, "Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "backoff", "Lcom/bilibili/lib/moss/utils/backoff/BackoffConfig;", "<init>", "(Ltv/danmaku/bili/report/sample/rule/path/PathRule;Lcom/bilibili/lib/moss/utils/backoff/BackoffConfig;)V", "getPath", "()Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "setPath", "(Ltv/danmaku/bili/report/sample/rule/path/PathRule;)V", "getBackoff", "()Lcom/bilibili/lib/moss/utils/backoff/BackoffConfig;", "setBackoff", "(Lcom/bilibili/lib/moss/utils/backoff/BackoffConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PathBackoff {
    public static final Companion Companion = new Companion(null);
    private BackoffConfig backoff;
    private PathRule path;

    public PathBackoff() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ PathBackoff copy$default(PathBackoff pathBackoff, PathRule pathRule, BackoffConfig backoffConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            pathRule = pathBackoff.path;
        }
        if ((i & 2) != 0) {
            backoffConfig = pathBackoff.backoff;
        }
        return pathBackoff.copy(pathRule, backoffConfig);
    }

    public final PathRule component1() {
        return this.path;
    }

    public final BackoffConfig component2() {
        return this.backoff;
    }

    public final PathBackoff copy(PathRule pathRule, BackoffConfig backoffConfig) {
        Intrinsics.checkNotNullParameter(pathRule, FileChooserActivity.PATH);
        Intrinsics.checkNotNullParameter(backoffConfig, "backoff");
        return new PathBackoff(pathRule, backoffConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathBackoff) {
            PathBackoff pathBackoff = (PathBackoff) obj;
            return Intrinsics.areEqual(this.path, pathBackoff.path) && Intrinsics.areEqual(this.backoff, pathBackoff.backoff);
        }
        return false;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.backoff.hashCode();
    }

    public String toString() {
        PathRule pathRule = this.path;
        return "PathBackoff(path=" + pathRule + ", backoff=" + this.backoff + ")";
    }

    public PathBackoff(PathRule path, BackoffConfig backoff) {
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        Intrinsics.checkNotNullParameter(backoff, "backoff");
        this.path = path;
        this.backoff = backoff;
    }

    public /* synthetic */ PathBackoff(PathRule pathRule, BackoffConfig backoffConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PathRule(null, null, 3, null) : pathRule, (i & 2) != 0 ? new BackoffConfig(0, 0, 0, 0.0f, 0.0f, 31, (DefaultConstructorMarker) null) : backoffConfig);
    }

    public final BackoffConfig getBackoff() {
        return this.backoff;
    }

    public final PathRule getPath() {
        return this.path;
    }

    public final void setBackoff(BackoffConfig backoffConfig) {
        Intrinsics.checkNotNullParameter(backoffConfig, "<set-?>");
        this.backoff = backoffConfig;
    }

    public final void setPath(PathRule pathRule) {
        Intrinsics.checkNotNullParameter(pathRule, "<set-?>");
        this.path = pathRule;
    }

    /* compiled from: PathBackoff.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/backoff/PathBackoff$Companion;", "", "<init>", "()V", "parse", "", "Ltv/danmaku/bili/report/sample/rule/backoff/PathBackoff;", "config", "", "matches", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "rules", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<PathBackoff> parse(String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            try {
                Iterable list = JSON.parseArray(config, PathBackoff.class);
                if (list == null) {
                    return null;
                }
                Iterable $this$filterNot$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    PathBackoff it = (PathBackoff) element$iv$iv;
                    if (!it.getPath().invalid()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                return null;
            }
        }

        public final PathBackoff matches(String host, String path, List<PathBackoff> list) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
            Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
            Intrinsics.checkNotNullParameter(list, "rules");
            List<PathBackoff> $this$firstOrNull$iv = list;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    PathBackoff it2 = (PathBackoff) element$iv;
                    if (it2.getPath().matches(host, path)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (PathBackoff) element$iv;
        }
    }
}