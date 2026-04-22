package tv.danmaku.bili.report.sample;

import com.bilibili.lib.moss.utils.SampleKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.random.Random;
import tv.danmaku.bili.BR;

/* compiled from: Sample.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/report/sample/Sample;", "", "<init>", "()V", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Sample {
    public static final Companion Companion = new Companion(null);
    public static final int MAX = 10000;
    public static final int MIN = 0;

    /* compiled from: Sample.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\u0005H\u0002J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/report/sample/Sample$Companion;", "", "<init>", "()V", "MIN", "", "MAX", "sample", "Lkotlin/Pair;", "", "", "threshold", "randomInt", "rate", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<Boolean, Float> sample(int threshold) {
            float rate = threshold > 0 ? (threshold * 1.0f) / 10000 : 0.0f;
            return new Pair<>(Boolean.valueOf(randomInt() < threshold), Float.valueOf(rate));
        }

        private final int randomInt() {
            return SampleKt.randInt(0, 9999);
        }

        public final Pair<Boolean, Float> sample(float rate) {
            boolean b = Random.Default.nextFloat() < rate;
            return new Pair<>(Boolean.valueOf(b), Float.valueOf(rate));
        }
    }
}