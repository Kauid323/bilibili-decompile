package tv.danmaku.bili.moss;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.test.cases.unary.SearchTestKt;

/* compiled from: MossTest.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "test", "", "context", "Landroid/content/Context;", "hostByPolicy", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossTestKt {
    public static final String TAG = "moss.test";

    public static final void test(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SearchTestKt.testSuggestAsync(context, "test");
    }

    public static final String hostByPolicy() {
        return "IGNORED IN 5.46 AS PLACEHOLDER";
    }
}