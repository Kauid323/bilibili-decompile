package tv.danmaku.bili.report.sample.rule.path;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: PathRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getPath", "setPath", "invalid", "", "matches", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PathRule {
    public static final Companion Companion = new Companion(null);
    private String host;
    private String path;

    public PathRule() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ PathRule copy$default(PathRule pathRule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pathRule.host;
        }
        if ((i & 2) != 0) {
            str2 = pathRule.path;
        }
        return pathRule.copy(str, str2);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.path;
    }

    public final PathRule copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(str2, FileChooserActivity.PATH);
        return new PathRule(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathRule) {
            PathRule pathRule = (PathRule) obj;
            return Intrinsics.areEqual(this.host, pathRule.host) && Intrinsics.areEqual(this.path, pathRule.path);
        }
        return false;
    }

    public int hashCode() {
        return (this.host.hashCode() * 31) + this.path.hashCode();
    }

    public String toString() {
        String str = this.host;
        return "PathRule(host=" + str + ", path=" + this.path + ")";
    }

    public PathRule(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        this.host = host;
        this.path = path;
    }

    public /* synthetic */ PathRule(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    /* compiled from: PathRule.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/path/PathRule$Companion;", "", "<init>", "()V", "parse", "", "Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "config", "", "matches", "", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "rules", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<PathRule> parse(String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            try {
                Iterable list = JSON.parseArray(config, PathRule.class);
                if (list == null) {
                    return null;
                }
                Iterable $this$filterNot$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    PathRule it = (PathRule) element$iv$iv;
                    if (!it.invalid()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                return null;
            }
        }

        public final boolean matches(String host, String path, List<PathRule> list) {
            Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
            Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
            Intrinsics.checkNotNullParameter(list, "rules");
            List<PathRule> $this$any$iv = list;
            if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                PathRule it = (PathRule) element$iv;
                if (it.matches(host, path)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean invalid() {
        String str = this.host;
        return str == null || StringsKt.isBlank(str);
    }

    public final boolean matches(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (Intrinsics.areEqual(this.host, host)) {
            String str = this.path;
            return str == null || str.length() == 0 ? true : Intrinsics.areEqual(this.path, path);
        }
        return false;
    }
}