package tv.danmaku.bili.core.test;

import android.content.Context;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.list.test.BaseTestActivity;
import com.bilibili.list.test.TestItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.bili.BR;

/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/core/test/CommonTestPageActivity;", "Lcom/bilibili/list/test/BaseTestActivity;", "<init>", "()V", "getTestItems", "", "Lcom/bilibili/list/test/TestItem;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CommonTestPageActivity extends BaseTestActivity {
    public static final int $stable = BaseTestActivity.$stable;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public List<TestItem> getTestItems() {
        return CollectionsKt.listOf(new TestItem[]{new C0006(), new C0004(), new Format()});
    }
}