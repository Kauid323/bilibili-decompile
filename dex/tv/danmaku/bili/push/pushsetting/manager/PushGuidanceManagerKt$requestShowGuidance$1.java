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
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt", f = "PushGuidanceManager.kt", i = {0, 0, 0}, l = {BR.cover, BR.danmakuNumIcon, BR.danmukuTvVisible}, m = "requestShowGuidance", n = {AudioIntentHelper.FROM_ACTIVITY, "showFrom", FavoritesConstsKt.SPMID}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class PushGuidanceManagerKt$requestShowGuidance$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushGuidanceManagerKt$requestShowGuidance$1(Continuation<? super PushGuidanceManagerKt$requestShowGuidance$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object requestShowGuidance;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestShowGuidance = PushGuidanceManagerKt.requestShowGuidance(null, null, null, (Continuation) this);
        return requestShowGuidance;
    }
}