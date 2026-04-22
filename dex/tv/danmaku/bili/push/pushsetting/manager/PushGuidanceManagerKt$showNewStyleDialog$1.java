package tv.danmaku.bili.push.pushsetting.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushGuidanceManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt", f = "PushGuidanceManager.kt", i = {0, 0}, l = {BR.handler}, m = "showNewStyleDialog", n = {"showFrom", FavoritesConstsKt.SPMID}, s = {"L$0", "L$1"}, v = 1)
public final class PushGuidanceManagerKt$showNewStyleDialog$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushGuidanceManagerKt$showNewStyleDialog$1(Continuation<? super PushGuidanceManagerKt$showNewStyleDialog$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object showNewStyleDialog;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showNewStyleDialog = PushGuidanceManagerKt.showNewStyleDialog(null, null, null, null, (Continuation) this);
        return showNewStyleDialog;
    }
}