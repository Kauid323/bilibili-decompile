package tv.danmaku.bili.report.sample.rule.url;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: BizSample.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "sample", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getPath", "setPath", "getSample", "()I", "setSample", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BizSample {
    public static final Companion Companion = new Companion(null);
    private String host;
    private String path;
    private int sample;

    public BizSample() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ BizSample copy$default(BizSample bizSample, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bizSample.host;
        }
        if ((i2 & 2) != 0) {
            str2 = bizSample.path;
        }
        if ((i2 & 4) != 0) {
            i = bizSample.sample;
        }
        return bizSample.copy(str, str2, i);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.path;
    }

    public final int component3() {
        return this.sample;
    }

    public final BizSample copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(str2, FileChooserActivity.PATH);
        return new BizSample(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BizSample) {
            BizSample bizSample = (BizSample) obj;
            return Intrinsics.areEqual(this.host, bizSample.host) && Intrinsics.areEqual(this.path, bizSample.path) && this.sample == bizSample.sample;
        }
        return false;
    }

    public int hashCode() {
        return (((this.host.hashCode() * 31) + this.path.hashCode()) * 31) + this.sample;
    }

    public String toString() {
        String str = this.host;
        String str2 = this.path;
        return "BizSample(host=" + str + ", path=" + str2 + ", sample=" + this.sample + ")";
    }

    public BizSample(String host, String path, int sample) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        this.host = host;
        this.path = path;
        this.sample = sample;
    }

    public /* synthetic */ BizSample(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getSample() {
        return this.sample;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setSample(int i) {
        this.sample = i;
    }

    /* compiled from: BizSample.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/url/BizSample$Companion;", "", "<init>", "()V", "parse", "", "Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "config", "", "parseConfig", "find", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "rules", "matches", "", "rule", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<BizSample> parse(String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (StringsKt.isBlank(config)) {
                return null;
            }
            return parseConfig(config);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x001b A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<BizSample> parseConfig(String config) {
            boolean z;
            try {
                Iterable list = JSON.parseArray(config, BizSample.class);
                if (list == null) {
                    return null;
                }
                Iterable $this$filterNot$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    BizSample it = (BizSample) element$iv$iv;
                    String host = it.getHost();
                    if (host != null && !StringsKt.isBlank(host)) {
                        z = false;
                        if (z) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                return null;
            }
        }

        public final BizSample find(String host, String path, List<BizSample> list) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
            Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
            Intrinsics.checkNotNullParameter(list, "rules");
            List<BizSample> $this$firstOrNull$iv = list;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    BizSample it2 = (BizSample) element$iv;
                    if (BizSample.Companion.matches(host, path, it2)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (BizSample) element$iv;
        }

        private final boolean matches(String host, String path, BizSample rule) {
            if (Intrinsics.areEqual(rule.getHost(), host)) {
                String path2 = rule.getPath();
                return path2 == null || path2.length() == 0 ? true : Intrinsics.areEqual(rule.getPath(), path);
            }
            return false;
        }
    }
}