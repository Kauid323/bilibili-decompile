package kntr.base.dd.preview;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$1", f = "DDDebuggerPreview.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$1  reason: invalid class name */
public final class ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$1(Toaster toaster, String str, Continuation<? super ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$1> continuation) {
        super(2, continuation);
        this.$toaster = toaster;
        this.$key = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$1(this.$toaster, this.$key, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DDDebuggerPreview.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$1$1", f = "DDDebuggerPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Toaster $toaster;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Toaster toaster, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$toaster = toaster;
            this.$key = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$toaster, this.$key, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Toaster.CC.showToast$default(this.$toaster, "已移除对 " + this.$key + " 值的监听.", null, 2, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$toaster, this.$key, null), (Continuation) this) == coroutine_suspended) {
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