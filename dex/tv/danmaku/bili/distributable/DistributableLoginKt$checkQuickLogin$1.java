package tv.danmaku.bili.distributable;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DistributableLogin.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.distributable.DistributableLoginKt", f = "DistributableLogin.kt", i = {0}, l = {BR.count}, m = "checkQuickLogin", n = {FavoritesConstsKt.SPMID}, s = {"L$0"}, v = 1)
public final class DistributableLoginKt$checkQuickLogin$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistributableLoginKt$checkQuickLogin$1(Continuation<? super DistributableLoginKt$checkQuickLogin$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object checkQuickLogin;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkQuickLogin = DistributableLoginKt.checkQuickLogin(null, null, null, (Continuation) this);
        return checkQuickLogin;
    }
}