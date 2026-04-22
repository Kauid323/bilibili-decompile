package kntr.base.dd.preview;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.KDeviceDecision;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$9$1", f = "DDDebuggerPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$9$1  reason: invalid class name */
public final class ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<IDeviceDecision.Version> $currentVersion$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$9$1(CoroutineScope coroutineScope, MutableState<IDeviceDecision.Version> mutableState, Continuation<? super ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$9$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$currentVersion$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$9$1(this.$coroutineScope, this.$currentVersion$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DDDebuggerPreview.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$9$1$1", f = "DDDebuggerPreview.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$9$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<IDeviceDecision.Version> $currentVersion$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<IDeviceDecision.Version> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentVersion$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$currentVersion$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KLog_androidKt.getKLog().d("DDLib", "start collect.");
                    Flow<IDeviceDecision.Version> versions = KDeviceDecision.INSTANCE.getDd().versions();
                    final MutableState<IDeviceDecision.Version> mutableState = this.$currentVersion$delegate;
                    this.label = 1;
                    if (versions.collect(new FlowCollector() { // from class: kntr.base.dd.preview.ComposableSingletons.DDDebuggerPreviewKt.lambda.-18439082.1.9.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((IDeviceDecision.Version) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(IDeviceDecision.Version it, Continuation<? super Unit> continuation) {
                            mutableState.setValue(it);
                            ILogger kLog = KLog_androidKt.getKLog();
                            IDeviceDecision.Version.Env env = it.getEnv();
                            kLog.d("DDLib", "version updated " + env + " - " + it.getVersion() + ".");
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KLog_androidKt.getKLog().d("DDLib", "end collect.");
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BuildersKt.launch$default(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$currentVersion$delegate, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}