package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCSplashSettingService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCSplashSettingService", f = "DLCSplashSettingService.kt", i = {0}, l = {BR.background, BR.bgBarVisible}, m = "splashSetting", n = {"cardTypeId"}, s = {"J$0"}, v = 1)
public final class DLCSplashSettingService$splashSetting$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DLCSplashSettingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCSplashSettingService$splashSetting$1(DLCSplashSettingService dLCSplashSettingService, Continuation<? super DLCSplashSettingService$splashSetting$1> continuation) {
        super(continuation);
        this.this$0 = dLCSplashSettingService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.splashSetting(0, 0L, (Continuation) this);
    }
}