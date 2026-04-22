package tv.danmaku.bili.push.pushsetting.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushGuidanceManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt", f = "PushGuidanceManager.kt", i = {0, 0, 1, 1, 1, 1}, l = {BR.downBadgeVisible, BR.dynamicPlayedNumIcon, BR.endIconVisible, BR.episodeDurationText, BR.errorText, BR.eventHandle}, m = "showSettingDialog", n = {"showFrom", FavoritesConstsKt.SPMID, AudioIntentHelper.FROM_ACTIVITY, "showFrom", FavoritesConstsKt.SPMID, "pushData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class PushGuidanceManagerKt$showSettingDialog$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushGuidanceManagerKt$showSettingDialog$1(Continuation<? super PushGuidanceManagerKt$showSettingDialog$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object showSettingDialog;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showSettingDialog = PushGuidanceManagerKt.showSettingDialog(null, null, null, null, (Continuation) this);
        return showSettingDialog;
    }
}