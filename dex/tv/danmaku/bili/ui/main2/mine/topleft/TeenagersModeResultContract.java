package tv.danmaku.bili.ui.main2.mine.topleft;

import android.content.Intent;
import com.bilibili.app.comm.list.common.contract.RouterResultContract;
import com.bilibili.lib.blrouter.MutableBundleLike;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TeensAge.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/topleft/TeenagersModeResultContract;", "Lcom/bilibili/app/comm/list/common/contract/RouterResultContract;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "buildBundle", "", "bundleLike", "Lcom/bilibili/lib/blrouter/MutableBundleLike;", "input", "(Lcom/bilibili/lib/blrouter/MutableBundleLike;Ljava/lang/Integer;)V", "parseResult", "resultCode", "intent", "Landroid/content/Intent;", "(ILandroid/content/Intent;)Ljava/lang/Integer;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TeenagersModeResultContract extends RouterResultContract<Integer, Integer> {
    public static final int $stable = RouterResultContract.$stable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeenagersModeResultContract(String url) {
        super(url);
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void buildBundle(MutableBundleLike bundleLike, Integer input) {
        Intrinsics.checkNotNullParameter(bundleLike, "bundleLike");
        bundleLike.put("page_type", "5");
        if (input != null) {
            bundleLike.put("age_set", String.valueOf(input.intValue()));
        }
    }

    /* renamed from: parseResult */
    public Integer m2116parseResult(int resultCode, Intent intent) {
        if (resultCode != -1 || intent == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(intent.getIntExtra("age_set", -1));
        int it = valueOf.intValue();
        if (it >= 0) {
            return valueOf;
        }
        return null;
    }
}