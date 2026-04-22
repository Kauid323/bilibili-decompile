package video.biz.offline.list.ui.page;

import androidx.compose.runtime.State;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineCompletedPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1", f = "OfflineCompletedPage.kt", i = {0}, l = {209, 213, 214}, m = "invokeSuspend", n = {"keys"}, s = {"L$0"}, v = 1)
public final class OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ OfflineCompletedPageStateMachine $machine;
    final /* synthetic */ OfflinePageOperation $operations;
    final /* synthetic */ State<OfflinePageState> $state$delegate;
    final /* synthetic */ Toaster $toaster;
    Object L$0;
    int label;

    /* compiled from: OfflineCompletedPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflinePageOperation.values().length];
            try {
                iArr[OfflinePageOperation.DELETE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflinePageOperation.DANMAKU_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1(OfflinePageOperation offlinePageOperation, String str, OfflineCompletedPageStateMachine offlineCompletedPageStateMachine, State<OfflinePageState> state, Toaster toaster, Continuation<? super OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1> continuation) {
        super(2, continuation);
        this.$operations = offlinePageOperation;
        this.$key = str;
        this.$machine = offlineCompletedPageStateMachine;
        this.$state$delegate = state;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1(this.$operations, this.$key, this.$machine, this.$state$delegate, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        OfflinePageState OfflineCompletedView$lambda$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                switch (WhenMappings.$EnumSwitchMapping$0[this.$operations.ordinal()]) {
                    case 1:
                        OfflineCompletedView$lambda$1 = OfflineCompletedPageKt.OfflineCompletedView$lambda$1(this.$state$delegate);
                        Iterable $this$map$iv = OfflineCompletedView$lambda$1.selectedCompletedTask(this.$key);
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            OfflineCachedCardModel it = (OfflineCachedCardModel) item$iv$iv;
                            destination$iv$iv.add(it.getKeys());
                        }
                        List keys = CollectionsKt.flatten((List) destination$iv$iv);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(keys);
                        this.label = 1;
                        if (this.$machine.dispatch(new OfflineListAction.DeleteConfirmed(keys), (Continuation) this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 2:
                        this.label = 2;
                        if (this.$machine.dispatch(new OfflineListAction.UpdateDanmaku(this.$key), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.label = 3;
                        if (TimeoutKt.withTimeout(1000L, new AnonymousClass1(this.$toaster, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                }
                return Unit.INSTANCE;
            case 1:
                List list = (List) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                this.label = 3;
                if (TimeoutKt.withTimeout(1000L, new AnonymousClass1(this.$toaster, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineCompletedPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1$1", f = "OfflineCompletedPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.ui.page.OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Toaster $toaster;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Toaster toaster, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$toaster = toaster;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$toaster, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Toaster.-CC.showToast$default(this.$toaster, PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2256(PlayerbaseresRes.INSTANCE.getString())), (ToastDuration) null, 2, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}