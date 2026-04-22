package tv.danmaku.bili.core.test;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.list.test.BaseTestActivity;
import com.bilibili.list.test.TestItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/core/test/MainTestPageActivity;", "Lcom/bilibili/list/test/BaseTestActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTestItems", "", "Lcom/bilibili/list/test/TestItem;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainTestPageActivity extends BaseTestActivity {
    public static final int $stable = BaseTestActivity.$stable;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.main_test_page_title);
    }

    public List<TestItem> getTestItems() {
        return CollectionsKt.listOf(new TestItem[]{new C0005(), new CNY(), new OldPegasusTest(), new DebugForceShowNewPegasus(), new ResetTeenagersModeDaily(), new ResetHomeAvatarRectShown(), new ForceUpdateHomeTab(), new ClearPublishBubbleCount(), new C0009(), new CleanUserUseMiniGameFlag(), new CleanTopLeftGuidanceRecord(), new C0008(), new InnerPushEntrance(), new ClearFirstRequestTime(), new PushDuplicateButton(), new CleanTopGameTabLottieDisplayHistory(), new PegasusComponentLog(), new PegasusConfigLog(), new PegasusConfigDialog(), new C0007(), new CleanFavFolderBubbleSp()});
    }
}