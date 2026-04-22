package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailLoader2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$job$1", f = "ThumbnailLoader2.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ThumbnailLoader2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ThumbnailLoader2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailLoader2$job$1(ThumbnailLoader2 thumbnailLoader2, Continuation<? super ThumbnailLoader2$job$1> continuation) {
        super(2, continuation);
        this.this$0 = thumbnailLoader2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThumbnailLoader2$job$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$job$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ThumbnailLoader2 this$0;

        AnonymousClass1(ThumbnailLoader2 thumbnailLoader2) {
            this.this$0 = thumbnailLoader2;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((ThumbnailLoader2.ThumbnailFetchRequest) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|13|14|15))|23|6|7|8|13|14|15) */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
            tv.danmaku.android.log.BLog.e("ThumbnailLoader2", "error -> " + r7);
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: Exception -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:12:0x002c, B:17:0x0037), top: B:25:0x0021 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(ThumbnailLoader2.ThumbnailFetchRequest it, Continuation<? super Unit> continuation) {
            ThumbnailLoader2$job$1$1$emit$1 thumbnailLoader2$job$1$1$emit$1;
            Object work;
            if (continuation instanceof ThumbnailLoader2$job$1$1$emit$1) {
                thumbnailLoader2$job$1$1$emit$1 = (ThumbnailLoader2$job$1$1$emit$1) continuation;
                if ((thumbnailLoader2$job$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    thumbnailLoader2$job$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = thumbnailLoader2$job$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (thumbnailLoader2$job$1$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            ThumbnailLoader2 thumbnailLoader2 = this.this$0;
                            thumbnailLoader2$job$1$1$emit$1.label = 1;
                            work = thumbnailLoader2.work(it, thumbnailLoader2$job$1$1$emit$1);
                            if (work == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            thumbnailLoader2$job$1$1$emit$1 = new ThumbnailLoader2$job$1$1$emit$1(this, continuation);
            Object $result2 = thumbnailLoader2$job$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (thumbnailLoader2$job$1$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableSharedFlow = this.this$0.thumbnailRequestFlow;
                this.label = 1;
                if (mutableSharedFlow.collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}