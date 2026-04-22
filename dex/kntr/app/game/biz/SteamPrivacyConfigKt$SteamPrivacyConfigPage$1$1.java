package kntr.app.game.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: SteamPrivacyConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1", f = "SteamPrivacyConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SteamPrivacyConfigViewModel $steamViewModel;
    final /* synthetic */ Toaster $toaster;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1(SteamPrivacyConfigViewModel steamPrivacyConfigViewModel, Toaster toaster, Continuation<? super SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1> continuation) {
        super(2, continuation);
        this.$steamViewModel = steamPrivacyConfigViewModel;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> steamPrivacyConfigKt$SteamPrivacyConfigPage$1$1 = new SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1(this.$steamViewModel, this.$toaster, continuation);
        steamPrivacyConfigKt$SteamPrivacyConfigPage$1$1.L$0 = obj;
        return steamPrivacyConfigKt$SteamPrivacyConfigPage$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SteamPrivacyConfig.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.biz.SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1$1", f = "SteamPrivacyConfig.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.biz.SteamPrivacyConfigKt$SteamPrivacyConfigPage$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SteamPrivacyConfigViewModel $steamViewModel;
        final /* synthetic */ Toaster $toaster;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SteamPrivacyConfigViewModel steamPrivacyConfigViewModel, Toaster toaster, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$steamViewModel = steamPrivacyConfigViewModel;
            this.$toaster = toaster;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$steamViewModel, this.$toaster, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharedFlow<String> toastEvent = this.$steamViewModel.getToastEvent();
                    final Toaster toaster = this.$toaster;
                    this.label = 1;
                    if (toastEvent.collect(new FlowCollector() { // from class: kntr.app.game.biz.SteamPrivacyConfigKt.SteamPrivacyConfigPage.1.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String toast, Continuation<? super Unit> continuation) {
                            if (toast.length() > 0) {
                                Toaster.-CC.showToast$default(toaster, toast, (ToastDuration) null, 2, (Object) null);
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
            throw new KotlinNothingValueException();
        }
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BuildersKt.launch$default($this$LaunchedEffect, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$steamViewModel, this.$toaster, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}