package kntr.app.digital.preview.share;

import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.card.video.DigitalVideoPlayService;
import kntr.app.digital.preview.share.ShareDialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ShareActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.share.ShareActionModule$provide$1$1", f = "ShareActionModule.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ShareActionModule$provide$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareDialogService $shareDialogService;
    final /* synthetic */ Action<ShareAction> $this_ActionModule;
    final /* synthetic */ DigitalVideoPlayService $videoPlayService;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareActionModule$provide$1$1(DigitalVideoPlayService digitalVideoPlayService, ShareDialogService shareDialogService, Action<ShareAction> action, Continuation<? super ShareActionModule$provide$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayService = digitalVideoPlayService;
        this.$shareDialogService = shareDialogService;
        this.$this_ActionModule = action;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareActionModule$provide$1$1(this.$videoPlayService, this.$shareDialogService, this.$this_ActionModule, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareActionModule.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.share.ShareActionModule$provide$1$1$1", f = "ShareActionModule.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.share.ShareActionModule$provide$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ShareDialogService $shareDialogService;
        final /* synthetic */ Action<ShareAction> $this_ActionModule;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShareDialogService shareDialogService, Action<ShareAction> action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$shareDialogService = shareDialogService;
            this.$this_ActionModule = action;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$shareDialogService, this.$this_ActionModule, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ShareDialogService shareDialogService = this.$shareDialogService;
                    String uniqueId = this.$this_ActionModule.getData().getUniqueId();
                    if (this.$this_ActionModule.getData().getCardScarcity() == 30 || this.$this_ActionModule.getData().getCardScarcity() == 40) {
                        str = "https://i1.hdslb.com/bfs/static/jinkela/mall-digital-card/assets/card-frame.05fad8e6.png";
                    } else {
                        str = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    this.label = 1;
                    if (shareDialogService.keepShowing(new ShareDialogService.ShareInfo(uniqueId, str, this.$this_ActionModule.getData().getBadgeUrl(), this.$this_ActionModule.getData().getCardImage(), this.$this_ActionModule.getData().getCardName(), this.$this_ActionModule.getData().getShareDesc(), this.$this_ActionModule.getData().getUface(), this.$this_ActionModule.getData().getShareUrl()), (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$videoPlayService.pauseAndResumeState(new AnonymousClass1(this.$shareDialogService, this.$this_ActionModule, null), (Continuation) this) == coroutine_suspended) {
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