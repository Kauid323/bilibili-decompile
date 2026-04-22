package tv.danmaku.biliplayer.preload.repository;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$release$1", f = "PreloadPoolImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PreloadPoolImpl$release$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sceneIdentity;
    int label;
    final /* synthetic */ PreloadPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPoolImpl$release$1(PreloadPoolImpl preloadPoolImpl, String str, Continuation<? super PreloadPoolImpl$release$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadPoolImpl;
        this.$sceneIdentity = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadPoolImpl$release$1(this.this$0, this.$sceneIdentity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkedList linkedList;
        PreloadPoolImpl.LimitFiFoList limitFiFoList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                linkedList = this.this$0.preloadList;
                Iterator iterator = linkedList.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    CacheElement element = (CacheElement) next;
                    if (Intrinsics.areEqual(element.getIdentity(), this.$sceneIdentity)) {
                        element.release();
                        iterator.remove();
                    }
                }
                limitFiFoList = this.this$0.sceneInfo;
                limitFiFoList.remove(this.$sceneIdentity);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}