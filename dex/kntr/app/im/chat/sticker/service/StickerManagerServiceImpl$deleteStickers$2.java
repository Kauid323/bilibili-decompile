package kntr.app.im.chat.sticker.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$deleteStickers$2", f = "StickerManagerService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {90}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$count$iv", "element$iv", "result", "$i$f$count", "count$iv", "$i$a$-count-StickerManagerServiceImpl$deleteStickers$2$2"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
final class StickerManagerServiceImpl$deleteStickers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ List<StickerAsset> $stickers;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$deleteStickers$2(List<StickerAsset> list, StickerManagerServiceImpl stickerManagerServiceImpl, Continuation<? super StickerManagerServiceImpl$deleteStickers$2> continuation) {
        super(2, continuation);
        this.$stickers = list;
        this.this$0 = stickerManagerServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stickerManagerServiceImpl$deleteStickers$2 = new StickerManagerServiceImpl$deleteStickers$2(this.$stickers, this.this$0, continuation);
        stickerManagerServiceImpl$deleteStickers$2.L$0 = obj;
        return stickerManagerServiceImpl$deleteStickers$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00eb -> B:23:0x00f7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterator it;
        int $i$f$count;
        Object await;
        CoroutineScope $this$coroutineScope;
        Iterable $this$count$iv;
        Object obj;
        Iterator it2;
        StickerManagerServiceImpl$deleteStickers$2 stickerManagerServiceImpl$deleteStickers$2;
        int $i$f$count2;
        int $i$f$count3;
        CoroutineScope $this$coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$stickers;
                StickerManagerServiceImpl stickerManagerServiceImpl = this.this$0;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    StickerAsset sticker = (StickerAsset) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerServiceImpl$deleteStickers$2$1$1(stickerManagerServiceImpl, sticker, null), 3, (Object) null));
                }
                Iterable $this$count$iv2 = (List) destination$iv$iv;
                if (($this$count$iv2 instanceof Collection) && ((Collection) $this$count$iv2).isEmpty()) {
                    $i$f$count = 0;
                    return Boxing.boxInt($i$f$count);
                }
                Iterable $this$count$iv3 = $this$count$iv2;
                it = $this$count$iv2.iterator();
                StickerManagerServiceImpl$deleteStickers$2 stickerManagerServiceImpl$deleteStickers$22 = this;
                CoroutineScope $this$coroutineScope3 = $this$coroutineScope2;
                int count$iv = 0;
                int $i$f$count4 = 0;
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    Deferred result = (Deferred) element$iv;
                    stickerManagerServiceImpl$deleteStickers$22.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope3);
                    stickerManagerServiceImpl$deleteStickers$22.L$1 = SpillingKt.nullOutSpilledVariable($this$count$iv3);
                    stickerManagerServiceImpl$deleteStickers$22.L$2 = it;
                    stickerManagerServiceImpl$deleteStickers$22.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
                    stickerManagerServiceImpl$deleteStickers$22.L$4 = SpillingKt.nullOutSpilledVariable(result);
                    stickerManagerServiceImpl$deleteStickers$22.I$0 = count$iv;
                    stickerManagerServiceImpl$deleteStickers$22.I$1 = $i$f$count4;
                    stickerManagerServiceImpl$deleteStickers$22.I$2 = 0;
                    stickerManagerServiceImpl$deleteStickers$22.label = 1;
                    await = result.await(stickerManagerServiceImpl$deleteStickers$22);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i = $i$f$count4;
                    $this$coroutineScope = $this$coroutineScope3;
                    $this$count$iv = $this$count$iv3;
                    obj = coroutine_suspended;
                    it2 = it;
                    stickerManagerServiceImpl$deleteStickers$2 = stickerManagerServiceImpl$deleteStickers$22;
                    $i$f$count2 = count$iv;
                    $i$f$count3 = i;
                    if (Result.isFailure-impl(((Result) await).unbox-impl())) {
                        int count$iv2 = $i$f$count3 + 1;
                        if (count$iv2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        count$iv = $i$f$count2;
                        stickerManagerServiceImpl$deleteStickers$22 = stickerManagerServiceImpl$deleteStickers$2;
                        it = it2;
                        coroutine_suspended = obj;
                        $this$count$iv3 = $this$count$iv;
                        CoroutineScope coroutineScope = $this$coroutineScope;
                        $i$f$count4 = count$iv2;
                        $this$coroutineScope3 = coroutineScope;
                    } else {
                        $this$coroutineScope3 = $this$coroutineScope;
                        $i$f$count4 = $i$f$count3;
                        count$iv = $i$f$count2;
                        stickerManagerServiceImpl$deleteStickers$22 = stickerManagerServiceImpl$deleteStickers$2;
                        it = it2;
                        coroutine_suspended = obj;
                        $this$count$iv3 = $this$count$iv;
                    }
                    if (it.hasNext()) {
                        $i$f$count = $i$f$count4;
                        return Boxing.boxInt($i$f$count);
                    }
                }
                break;
            case 1:
                int i2 = this.I$2;
                int count$iv3 = this.I$1;
                int $i$f$count5 = this.I$0;
                Deferred deferred = (Deferred) this.L$4;
                Object obj2 = this.L$3;
                ResultKt.throwOnFailure($result);
                await = $result;
                $this$count$iv = (Iterable) this.L$1;
                $i$f$count2 = $i$f$count5;
                obj = coroutine_suspended;
                $i$f$count3 = count$iv3;
                it2 = (Iterator) this.L$2;
                $this$coroutineScope = $this$coroutineScope2;
                stickerManagerServiceImpl$deleteStickers$2 = this;
                if (Result.isFailure-impl(((Result) await).unbox-impl())) {
                }
                if (it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}