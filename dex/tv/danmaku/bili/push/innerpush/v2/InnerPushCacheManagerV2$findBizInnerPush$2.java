package tv.danmaku.bili.push.innerpush.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushCacheManagerV2.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.InnerPushCacheManagerV2$findBizInnerPush$2", f = "InnerPushCacheManagerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerPushCacheManagerV2$findBizInnerPush$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>>, Object> {
    final /* synthetic */ int $bid;
    final /* synthetic */ String $pvId;
    final /* synthetic */ int $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerPushCacheManagerV2$findBizInnerPush$2(int i, String str, int i2, Continuation<? super InnerPushCacheManagerV2$findBizInnerPush$2> continuation) {
        super(2, continuation);
        this.$bid = i;
        this.$pvId = str;
        this.$type = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerPushCacheManagerV2$findBizInnerPush$2(this.$bid, this.$pvId, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                InnerPushConfig config = InnerPushLocalStorage.INSTANCE.loadInnerPushConfig();
                InnerPushLocalStorage.INSTANCE.getInnerPushCommonExposeCount();
                Map businessExposeCountMap = InnerPushLocalStorage.INSTANCE.getInnerPushBusinessExposeMap();
                Integer num = businessExposeCountMap.get(String.valueOf(this.$bid));
                int todayBusinessExposeCount = num != null ? num.intValue() : 0;
                Integer num2 = config.getMaxBusinessExposure().get(String.valueOf(this.$bid));
                int serverLimitBusinessExposeCount = num2 != null ? num2.intValue() : -1;
                if (!config.getMaxBusinessExposure().containsKey(String.valueOf(this.$bid)) || serverLimitBusinessExposeCount == -1 || todayBusinessExposeCount < serverLimitBusinessExposeCount) {
                    Pair matchResult = AppInnerPushManagerV2.Companion.getInstance().matchBizPush$core_apinkDebug(this.$pvId, String.valueOf(this.$type));
                    if (((Boolean) matchResult.getFirst()).booleanValue()) {
                        return new Pair(Boxing.boxBoolean(true), String.valueOf(((Number) matchResult.getSecond()).intValue()));
                    }
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "type = " + this.$type + ", hit block, save to cache");
                } else {
                    BLog.i("[InnerPush]InnerPushCacheManagerV2", "type = " + this.$type + ", todayBusinessExposeCount = " + todayBusinessExposeCount);
                }
                return new Pair(Boxing.boxBoolean(false), "");
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}