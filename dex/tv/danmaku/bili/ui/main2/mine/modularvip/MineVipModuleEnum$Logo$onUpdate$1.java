package tv.danmaku.bili.ui.main2.mine.modularvip;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipModuleManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Logo", f = "MineVipModuleManager.kt", i = {}, l = {BR.microphoneVolume, BR.moreEpisodesContentDescription}, m = "onUpdate", n = {}, s = {}, v = 1)
public final class MineVipModuleEnum$Logo$onUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MineVipModuleEnum.Logo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipModuleEnum$Logo$onUpdate$1(MineVipModuleEnum.Logo logo, Continuation<? super MineVipModuleEnum$Logo$onUpdate$1> continuation) {
        super(continuation);
        this.this$0 = logo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onUpdate(null, (Continuation) this);
    }
}