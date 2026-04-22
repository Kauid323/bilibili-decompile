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
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt", f = "PushGuidanceManager.kt", i = {0, 0}, l = {BR.followNum}, m = "showV1StyleDialog", n = {"showFrom", FavoritesConstsKt.SPMID}, s = {"L$0", "L$1"}, v = 1)
public final class PushGuidanceManagerKt$showV1StyleDialog$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushGuidanceManagerKt$showV1StyleDialog$1(Continuation<? super PushGuidanceManagerKt$showV1StyleDialog$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object showV1StyleDialog;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showV1StyleDialog = PushGuidanceManagerKt.showV1StyleDialog(null, null, null, null, (Continuation) this);
        return showV1StyleDialog;
    }
}