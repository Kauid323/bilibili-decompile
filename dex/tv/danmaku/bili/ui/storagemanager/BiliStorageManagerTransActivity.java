package tv.danmaku.bili.ui.storagemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.app.preferences.storage.BiliStorageManagerActivity;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import tv.danmaku.bili.ui.GarbUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliStorageManagerTransActivity.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/storagemanager/BiliStorageManagerTransActivity;", "Landroid/app/Activity;", "Lcom/bilibili/base/util/DelayTaskController$IInterceptDialogHost;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliStorageManagerTransActivity extends android_app_Activity implements DelayTaskController.IInterceptDialogHost {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GarbUtils.resetThemeWithFirstBoot((Context) this);
        HandlerThreads.getHandler(0).postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.storagemanager.BiliStorageManagerTransActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliStorageManagerTransActivity.onCreate$lambda$0(BiliStorageManagerTransActivity.this);
            }
        }, 200L);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(BiliStorageManagerTransActivity this$0) {
        this$0.startActivity(new Intent((Context) this$0, BiliStorageManagerActivity.class));
    }
}