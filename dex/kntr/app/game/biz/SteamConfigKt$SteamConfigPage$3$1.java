package kntr.app.game.biz;

import androidx.compose.runtime.MutableIntState;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.SteamConfigKt$SteamConfigPage$3$1", f = "SteamConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SteamConfigKt$SteamConfigPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableIntState $refreshTrigger$delegate;
    final /* synthetic */ SteamConfigViewModel $steamViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamConfigKt$SteamConfigPage$3$1(CoroutineScope coroutineScope, MutableIntState mutableIntState, SteamConfigViewModel steamConfigViewModel, Continuation<? super SteamConfigKt$SteamConfigPage$3$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$refreshTrigger$delegate = mutableIntState;
        this.$steamViewModel = steamConfigViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamConfigKt$SteamConfigPage$3$1(this.$coroutineScope, this.$refreshTrigger$delegate, this.$steamViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int SteamConfigPage$lambda$3;
        int SteamConfigPage$lambda$32;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SteamConfigPage$lambda$3 = SteamConfigKt.SteamConfigPage$lambda$3(this.$refreshTrigger$delegate);
                if (SteamConfigPage$lambda$3 > 0) {
                    SteamConfigPage$lambda$32 = SteamConfigKt.SteamConfigPage$lambda$3(this.$refreshTrigger$delegate);
                    System.out.println((Object) ("SteamConfig: 执行页面恢复刷新，trigger=" + SteamConfigPage$lambda$32));
                    try {
                        BuildersKt.launch$default(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$steamViewModel, null), 3, (Object) null);
                    } catch (Exception e) {
                        System.out.println((Object) ("SteamConfig: 刷新数据异常: " + e.getMessage()));
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SteamConfig.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.biz.SteamConfigKt$SteamConfigPage$3$1$1", f = "SteamConfig.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.biz.SteamConfigKt$SteamConfigPage$3$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SteamConfigViewModel $steamViewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SteamConfigViewModel steamConfigViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$steamViewModel = steamConfigViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$steamViewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$steamViewModel.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation) this) == coroutine_suspended) {
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
}