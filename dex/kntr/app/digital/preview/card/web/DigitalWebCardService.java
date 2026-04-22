package kntr.app.digital.preview.card.web;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService;
import kntr.app.digital.preview.card.web.DigitalWebCardService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DigitalWebCardService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkntr/app/digital/preview/card/web/DigitalWebCardService;", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeService", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;)V", "smeltState", "Lkntr/app/digital/preview/card/web/SmeltState;", "getSmeltState", "()Lkntr/app/digital/preview/card/web/SmeltState;", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "webViewVisible", "getWebViewVisible", "()Z", "setWebViewVisible", "(Z)V", "webViewVisible$delegate", "Landroidx/compose/runtime/MutableState;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalWebCardService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final CoroutineScope coroutineScope;
    private final SmeltState smeltState;
    private final DigitalVideoCardVolumeService volumeService;
    private final MutableState webViewVisible$delegate;

    @Inject
    public DigitalWebCardService(@BusinessCoroutineScope CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(volumeService, "volumeService");
        this.coroutineScope = coroutineScope;
        this.cardStateService = cardStateService;
        this.volumeService = volumeService;
        this.smeltState = new SmeltState() { // from class: kntr.app.digital.preview.card.web.DigitalWebCardService$smeltState$1
            @Override // kntr.app.digital.preview.card.web.SmeltState
            public String getUrl() {
                CardItem cardData = DigitalWebCardService.this.cardStateService.getCurrentCardItem();
                if (cardData.getData() instanceof WebCard) {
                    return ((WebCard) cardData.getData()).getRenderUrl();
                }
                return null;
            }

            @Override // kntr.app.digital.preview.card.web.SmeltState
            public Long getCardId() {
                CardItem cardData = DigitalWebCardService.this.cardStateService.getCurrentCardItem();
                if (cardData.getData() instanceof WebCard) {
                    return Long.valueOf(cardData.getBasic().getCardIdInfo().getCardId());
                }
                return null;
            }

            @Override // kntr.app.digital.preview.card.web.SmeltState
            public boolean getEnableAudio() {
                DigitalVideoCardVolumeService digitalVideoCardVolumeService;
                digitalVideoCardVolumeService = DigitalWebCardService.this.volumeService;
                return digitalVideoCardVolumeService.getVolumeOn();
            }
        };
        this.webViewVisible$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (!IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "smelting_usage_restriction", false, 2, (Object) null)) {
            return;
        }
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
    }

    public final SmeltState getSmeltState() {
        return this.smeltState;
    }

    public final boolean getWebViewVisible() {
        State $this$getValue$iv = this.webViewVisible$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setWebViewVisible(boolean z) {
        MutableState $this$setValue$iv = this.webViewVisible$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    /* compiled from: DigitalWebCardService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.web.DigitalWebCardService$1", f = "DigitalWebCardService.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.web.DigitalWebCardService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DigitalWebCardService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "cardData", "Lkntr/app/digital/preview/cardlistmapper/CardItem;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.digital.preview.card.web.DigitalWebCardService$1$2", f = "DigitalWebCardService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.digital.preview.card.web.DigitalWebCardService$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CardItem<?>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DigitalWebCardService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DigitalWebCardService digitalWebCardService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = digitalWebCardService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            public final Object invoke(CardItem<?> cardItem, Continuation<? super Unit> continuation) {
                return create(cardItem, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.this$0.setWebViewVisible(false);
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
                    final DigitalWebCardService digitalWebCardService = DigitalWebCardService.this;
                    this.label = 1;
                    if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.web.DigitalWebCardService$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            CardItem invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = DigitalWebCardService.AnonymousClass1.invokeSuspend$lambda$0(DigitalWebCardService.this);
                            return invokeSuspend$lambda$0;
                        }
                    }), new AnonymousClass2(DigitalWebCardService.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final CardItem invokeSuspend$lambda$0(DigitalWebCardService this$0) {
            return this$0.cardStateService.getCurrentCardItem();
        }
    }

    /* compiled from: DigitalWebCardService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.web.DigitalWebCardService$2", f = "DigitalWebCardService.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.web.DigitalWebCardService$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final DigitalWebCardService digitalWebCardService = DigitalWebCardService.this;
                    Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.web.DigitalWebCardService$2$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            SmeltStatus invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = DigitalWebCardService.AnonymousClass2.invokeSuspend$lambda$0(DigitalWebCardService.this);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    final DigitalWebCardService digitalWebCardService2 = DigitalWebCardService.this;
                    this.label = 1;
                    if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.digital.preview.card.web.DigitalWebCardService.2.2
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((SmeltStatus) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(SmeltStatus status, Continuation<? super Unit> continuation) {
                            if (status != null) {
                                DigitalWebCardService.this.setWebViewVisible(status.getCardId() == DigitalWebCardService.this.cardStateService.getCurrentCardItem().getBasic().getCardIdInfo().getCardId() && status.getLoadState());
                            }
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
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SmeltStatus invokeSuspend$lambda$0(DigitalWebCardService this$0) {
            return this$0.getSmeltState().getSmeltStatus();
        }
    }
}