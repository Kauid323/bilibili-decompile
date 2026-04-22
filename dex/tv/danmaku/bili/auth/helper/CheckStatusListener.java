package tv.danmaku.bili.auth.helper;

import java.util.ArrayList;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ModifyHelperApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/helper/CheckStatusListener;", "", "onPassed", "", "onReject", "reason", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onApplying", "onError", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface CheckStatusListener {
    void onApplying();

    void onError();

    void onPassed();

    void onReject(ArrayList<String> arrayList);
}