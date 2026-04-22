package tv.danmaku.bili.push.pushsetting.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasePushSettingDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog", f = "BasePushSettingDialog.kt", i = {0, 0, 0}, l = {BR.currentBannerItemPos, 155}, m = "suspendShow", n = {AudioIntentHelper.FROM_ACTIVITY, "manager", AppConfig.HOST_TAG}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class BasePushSettingDialog$suspendShow$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasePushSettingDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePushSettingDialog$suspendShow$1(BasePushSettingDialog basePushSettingDialog, Continuation<? super BasePushSettingDialog$suspendShow$1> continuation) {
        super(continuation);
        this.this$0 = basePushSettingDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.suspendShow(null, null, null, (Continuation) this);
    }
}