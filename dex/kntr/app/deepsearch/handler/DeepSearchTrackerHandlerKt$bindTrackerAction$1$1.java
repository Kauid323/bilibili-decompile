package kntr.app.deepsearch.handler;

import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchTrackerHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "state", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchTrackerHandlerKt$bindTrackerAction$1$1", f = "DeepSearchTrackerHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchTrackerHandlerKt$bindTrackerAction$1$1 extends SuspendLambda implements Function3<DeepSearchAction, DeepSearchPageData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchTrackerHandlerKt$bindTrackerAction$1$1(Continuation<? super DeepSearchTrackerHandlerKt$bindTrackerAction$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction deepSearchAction, DeepSearchPageData deepSearchPageData, Continuation<? super Unit> continuation) {
        DeepSearchTrackerHandlerKt$bindTrackerAction$1$1 deepSearchTrackerHandlerKt$bindTrackerAction$1$1 = new DeepSearchTrackerHandlerKt$bindTrackerAction$1$1(continuation);
        deepSearchTrackerHandlerKt$bindTrackerAction$1$1.L$0 = deepSearchAction;
        deepSearchTrackerHandlerKt$bindTrackerAction$1$1.L$1 = deepSearchPageData;
        return deepSearchTrackerHandlerKt$bindTrackerAction$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DeepSearchAction action = (DeepSearchAction) this.L$0;
        DeepSearchPageData state = (DeepSearchPageData) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof DeepSearchAction.TrackerAction.HeadIconClick) {
                    DeepSearchTrackerHandlerKt.handleHeadIcon(state, (DeepSearchAction.TrackerAction.HeadIconClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.LinkNodeClick) {
                    DeepSearchTrackerHandlerKt.handleLinkNode(state, (DeepSearchAction.TrackerAction.LinkNodeClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.PictureClick) {
                    DeepSearchTrackerHandlerKt.handlePicture(state, (DeepSearchAction.TrackerAction.PictureClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.BubbleClick) {
                    DeepSearchTrackerHandlerKt.handleBubble(state, (DeepSearchAction.TrackerAction.BubbleClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.ArchiveClick) {
                    DeepSearchTrackerHandlerKt.handleArchive(state, (DeepSearchAction.TrackerAction.ArchiveClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.TimestampArchiveClick) {
                    DeepSearchTrackerHandlerKt.handleTimestampArchiveClick(state, (DeepSearchAction.TrackerAction.TimestampArchiveClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.ArchiveTimestampClick) {
                    DeepSearchTrackerHandlerKt.handleArchiveTimestamp(state, (DeepSearchAction.TrackerAction.ArchiveTimestampClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.PicturePreviewClick) {
                    DeepSearchTrackerHandlerKt.handlePicturePreview(state, (DeepSearchAction.TrackerAction.PicturePreviewClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.CopyClick) {
                    DeepSearchTrackerHandlerKt.handleCopy(state, (DeepSearchAction.TrackerAction.CopyClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.LikeClick) {
                    DeepSearchTrackerHandlerKt.handleLike(state, (DeepSearchAction.TrackerAction.LikeClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.DisLikeClick) {
                    DeepSearchTrackerHandlerKt.handleDisLike(state, (DeepSearchAction.TrackerAction.DisLikeClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.SubmitDisLikeClick) {
                    DeepSearchTrackerHandlerKt.handleSubmitDisLike(state, (DeepSearchAction.TrackerAction.SubmitDisLikeClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.RetryClick) {
                    DeepSearchTrackerHandlerKt.handleRetry(state, (DeepSearchAction.TrackerAction.RetryClick) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.PreviewPictureCommentFold) {
                    DeepSearchTrackerHandlerKt.handlePreviewPictureCommentFold(state, (DeepSearchAction.TrackerAction.PreviewPictureCommentFold) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.PreviewPictureViewOriginPic) {
                    DeepSearchTrackerHandlerKt.handlePreviewPictureViewOriginPic(state, (DeepSearchAction.TrackerAction.PreviewPictureViewOriginPic) action);
                } else if (action instanceof DeepSearchAction.TrackerAction.HistoryEntryClick) {
                    DeepSearchTrackerHandlerKt.handleHistoryEntry(state);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}