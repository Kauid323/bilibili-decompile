package tv.danmaku.bili.distributable;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DistributableLogin.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.distributable.DistributableLoginKt", f = "DistributableLogin.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3}, l = {BR.badgeBgColor, BR.btnTryAgainText, BR.buttonWidths, BR.canFavor}, m = "tryDistributableStartupLogin", n = {AudioIntentHelper.FROM_ACTIVITY, "loginBlock", FavoritesConstsKt.SPMID, AudioIntentHelper.FROM_ACTIVITY, "loginBlock", FavoritesConstsKt.SPMID, "loginType", "loginPageType", AudioIntentHelper.FROM_ACTIVITY, FavoritesConstsKt.SPMID, "loginType", "loginPageType", "phoneInfo", AudioIntentHelper.FROM_ACTIVITY}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"}, v = 1)
public final class DistributableLoginKt$tryDistributableStartupLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistributableLoginKt$tryDistributableStartupLogin$1(Continuation<? super DistributableLoginKt$tryDistributableStartupLogin$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DistributableLoginKt.tryDistributableStartupLogin(null, null, (Continuation) this);
    }
}