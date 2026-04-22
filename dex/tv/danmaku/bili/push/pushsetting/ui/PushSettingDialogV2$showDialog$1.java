package tv.danmaku.bili.push.pushsetting.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushSettingDialogV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogV2", f = "PushSettingDialogV2.kt", i = {}, l = {BR.danmukuTvVisible, BR.directionType}, m = "showDialog", n = {}, s = {}, v = 1)
public final class PushSettingDialogV2$showDialog$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushSettingDialogV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingDialogV2$showDialog$1(PushSettingDialogV2 pushSettingDialogV2, Continuation<? super PushSettingDialogV2$showDialog$1> continuation) {
        super(continuation);
        this.this$0 = pushSettingDialogV2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showDialog((Continuation) this);
    }
}