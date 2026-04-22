package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.dynamic.v2.KLinkNodeBubbleType;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Map;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchTrackerHandler.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\fH\u0002\u001a\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0010H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0012H\u0002\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0016H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0018H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u001aH\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u001cH\u0002\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u001eH\u0002\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020 H\u0002\u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\"H\u0002\u001a\u0018\u0010#\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020$H\u0002\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a\u0018\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0'*\u00020\u0003H\u0002\u001a\u001e\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-\u001a\u000e\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200¨\u00061"}, d2 = {"bindTrackerAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "handleHeadIcon", "pageData", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$HeadIconClick;", "handleLinkNode", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LinkNodeClick;", "handlePicture", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PictureClick;", "handleBubble", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$BubbleClick;", "handleArchive", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveClick;", "handleTimestampArchiveClick", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$TimestampArchiveClick;", "handleArchiveTimestamp", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveTimestampClick;", "handlePicturePreview", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PicturePreviewClick;", "handleCopy", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$CopyClick;", "handleLike", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LikeClick;", "handleDisLike", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$DisLikeClick;", "handleSubmitDisLike", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$SubmitDisLikeClick;", "handleRetry", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$RetryClick;", "handlePreviewPictureCommentFold", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureCommentFold;", "handlePreviewPictureViewOriginPic", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureViewOriginPic;", "handleHistoryEntry", "commonParam", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "handleBroadcastErrorTrack", "sessionId", "queryId", "broadcastError", "Lkntr/app/deepsearch/handler/DeepSearchBroadcastError;", "handleBroadcastTechnicalTrack", "response", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTrackerHandlerKt {
    public static final void bindTrackerAction(FlowReduxStoreBuilder<DeepSearchPageData, DeepSearchAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTrackerHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindTrackerAction$lambda$0;
                bindTrackerAction$lambda$0 = DeepSearchTrackerHandlerKt.bindTrackerAction$lambda$0((InStateBuilderBlock) obj);
                return bindTrackerAction$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(DeepSearchPageData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTrackerAction$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new DeepSearchTrackerHandlerKt$bindTrackerAction$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(DeepSearchAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleHeadIcon(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.HeadIconClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "profile"), TuplesKt.to("param", action.getMid()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLinkNode(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.LinkNodeClick action) {
        String clickArea;
        if (Intrinsics.areEqual(action.getLinkNode().getLinkTypeEnum(), KLinkNodeType.NICK_NAME.INSTANCE)) {
            clickArea = "nickname";
        } else {
            clickArea = "none";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", clickArea), TuplesKt.to("param", action.getLinkNode().getBizId()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePicture(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.PictureClick action) {
        String clickArea;
        KPictureCard.KSource type = action.getType();
        if (Intrinsics.areEqual(type, KPictureCard.KSource.VIDEO.INSTANCE)) {
            clickArea = "video_picture";
        } else if (Intrinsics.areEqual(type, KPictureCard.KSource.REPLY.INSTANCE)) {
            clickArea = "comment_picture";
        } else {
            clickArea = "none";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", clickArea), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleBubble(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.BubbleClick action) {
        String clickArea;
        KLinkNodeBubbleType type = action.getType();
        if (Intrinsics.areEqual(type, KLinkNodeBubbleType.BUBBLE_VIDEO.INSTANCE)) {
            clickArea = "title";
        } else if (Intrinsics.areEqual(type, KLinkNodeBubbleType.BUBBLE_COMMENT.INSTANCE)) {
            clickArea = "comment";
        } else {
            clickArea = "none";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", clickArea), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleArchive(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.ArchiveClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "archive"), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleTimestampArchiveClick(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.TimestampArchiveClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "timestamp_archive"), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleArchiveTimestamp(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.ArchiveTimestampClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "archive_timestamp"), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePicturePreview(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.PicturePreviewClick action) {
        String clickArea;
        KPictureCard.KSource type = action.getType();
        if (Intrinsics.areEqual(type, KPictureCard.KSource.VIDEO.INSTANCE)) {
            clickArea = "timestamp";
        } else if (Intrinsics.areEqual(type, KPictureCard.KSource.REPLY.INSTANCE)) {
            clickArea = "comment";
        } else {
            clickArea = "none";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.picture.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", clickArea), TuplesKt.to("param", action.getParam()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCopy(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.CopyClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "copy"), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLike(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.LikeClick action) {
        String area;
        if (action.isCancel()) {
            area = "cancel_like";
        } else {
            area = "like";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", area), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDisLike(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.DisLikeClick action) {
        String area;
        if (action.isCancel()) {
            area = "cancel_dislike";
        } else {
            area = "dislike";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", area), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSubmitDisLike(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.SubmitDisLikeClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "commit_dislike_reason"), TuplesKt.to("dislike_reason", action.getDisLikeReason()), TuplesKt.to("reason_detail", action.getReasonDetail()), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRetry(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.RetryClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.0.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "retry"), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePreviewPictureCommentFold(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.PreviewPictureCommentFold action) {
        String area;
        if (action.isFold()) {
            area = "unfold_comment";
        } else {
            area = "fold_comment";
        }
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.picture.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", area), TuplesKt.to("ds_queryid", action.getQueryId()), TuplesKt.to("param", action.getCommentId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePreviewPictureViewOriginPic(DeepSearchPageData pageData, DeepSearchAction.TrackerAction.PreviewPictureViewOriginPic action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.gpt-card.picture.click", MapsKt.plus(commonParam(pageData), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "view_origin_pic"), TuplesKt.to("ds_queryid", action.getQueryId())})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleHistoryEntry(DeepSearchPageData pageData) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.history.entry.click", commonParam(pageData));
    }

    private static final Map<String, String> commonParam(DeepSearchPageData $this$commonParam) {
        return MapsKt.mapOf(TuplesKt.to("ds_sessionid", $this$commonParam.getSessionId()));
    }

    public static final void handleBroadcastErrorTrack(String sessionId, String queryId, DeepSearchBroadcastError broadcastError) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(broadcastError, "broadcastError");
        KNeuron.INSTANCE.reportExposure(false, "im.ds-chat.gpt-card.error.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("ds_sessionid", sessionId), TuplesKt.to("ds_queryid", queryId), TuplesKt.to("error_code", broadcastError.toString())}));
    }

    public static final void handleBroadcastTechnicalTrack(KDeepSearchResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Map param = MapsKt.mapOf(new Pair[]{TuplesKt.to("session_id", response.getSessionId()), TuplesKt.to("query_id", response.getQueryId()), TuplesKt.to("chat_status", String.valueOf(response.getStatus().getValue())), TuplesKt.to("timestamp", String.valueOf(response.getTimestamp()))});
        if (IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "ff_community_deepsearch_broadcast_track", false, 2, (Object) null)) {
            KNeuron.INSTANCE.simpleTrackT("community.deepsearch.broadcast", param);
        }
    }
}