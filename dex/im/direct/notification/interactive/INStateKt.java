package im.direct.notification.interactive;

import bili.resource.common.CommonRes;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bapis.bilibili.im.gateway.interfaces.v1.KAtBiz;
import com.bapis.bilibili.im.gateway.interfaces.v1.KAtCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KCoinCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KFavoriteCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KLikeCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedFilterType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListRsp;
import com.bapis.bilibili.im.gateway.interfaces.v1.KNotice;
import com.bapis.bilibili.im.gateway.interfaces.v1.KReplyBiz;
import com.bapis.bilibili.im.gateway.interfaces.v1.KReplyCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KRichTextContent;
import com.bapis.bilibili.im.gateway.interfaces.v1.KThankButton;
import com.bapis.bilibili.im.gateway.interfaces.v1.KUser;
import faceverify.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.base.config.SharedPreferences;
import kntr.base.localization.DateTimeFormatKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KBusinessException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0080@¢\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010\u0011\u001a\u00020\u000fH\u0000\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\b\u0012\u0004\u0012\u00020\u000f0\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002\u001a \u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0007H\u0002\u001a\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\r¨\u0006&"}, d2 = {"cards", "", "Lim/direct/notification/interactive/INMessageCard;", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListRsp;", "currentFilterType", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilterType;", "isFirstPage", "", "ToastMessage", "Lim/direct/notification/interactive/ToastMessage;", "t", "", "default", "", "(Ljava/lang/Throwable;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lim/direct/notification/interactive/INFilter;", "shouldChangeToFilter", "filter", "select", "createCommentCtrl", "Lim/direct/notification/interactive/CommentCtrl;", "replyCard", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KReplyCard;", "atCard", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KAtCard;", "createLikeCtrl", "Lim/direct/notification/interactive/LikeCtrl;", "replyBiz", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KReplyBiz;", "common", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;", "messageCard", "message", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;", "isPinned", "isThisFirstTime", q.KEY_RES_9_KEY, "prefsName", "interactive_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class INStateKt {
    public static final List<INMessageCard> cards(KMsgListRsp $this$cards, KMsgFeedFilterType currentFilterType, boolean isFirstPage) {
        List cards = new ArrayList();
        if (isFirstPage) {
            Iterable $this$map$iv = $this$cards.getTopCards();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KMsgFeedMsgCard it = (KMsgFeedMsgCard) item$iv$iv;
                destination$iv$iv.add(messageCard(it, currentFilterType, true));
            }
            cards.addAll((List) destination$iv$iv);
        }
        Iterable $this$mapIndexed$iv = $this$cards.getMsgCards();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv2 : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KMsgFeedMsgCard it2 = (KMsgFeedMsgCard) item$iv$iv2;
            destination$iv$iv2.add(messageCard(it2, currentFilterType, false));
            index$iv$iv = index$iv$iv2;
        }
        List normalCards = (List) destination$iv$iv2;
        cards.addAll(normalCards);
        return cards;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0062  */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object ToastMessage(Throwable t, String str, Continuation<? super ToastMessage> continuation) {
        INStateKt$ToastMessage$1 iNStateKt$ToastMessage$1;
        Object suspendGetString;
        String msg;
        if (continuation instanceof INStateKt$ToastMessage$1) {
            iNStateKt$ToastMessage$1 = (INStateKt$ToastMessage$1) continuation;
            if ((iNStateKt$ToastMessage$1.label & Integer.MIN_VALUE) != 0) {
                iNStateKt$ToastMessage$1.label -= Integer.MIN_VALUE;
                Object $result = iNStateKt$ToastMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iNStateKt$ToastMessage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CommonRes commonRes = CommonRes.INSTANCE;
                        StringResource common_global_string_378 = String0_commonMainKt.getCommon_global_string_378(Res.string.INSTANCE);
                        iNStateKt$ToastMessage$1.L$0 = t;
                        iNStateKt$ToastMessage$1.L$1 = str;
                        iNStateKt$ToastMessage$1.label = 1;
                        suspendGetString = commonRes.suspendGetString(common_global_string_378, iNStateKt$ToastMessage$1);
                        if (suspendGetString == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        str = (String) iNStateKt$ToastMessage$1.L$1;
                        t = (Throwable) iNStateKt$ToastMessage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetString = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String defaultString = suspendGetString;
                if (!(t instanceof KBusinessException)) {
                    msg = t.getMessage();
                } else if (t instanceof INHttpBusinessException) {
                    msg = ((INHttpBusinessException) t).getErrorMsg();
                } else {
                    msg = str == null ? defaultString : str;
                }
                return new ToastMessage(msg, 0L, 2, null);
            }
        }
        iNStateKt$ToastMessage$1 = new INStateKt$ToastMessage$1(continuation);
        Object $result2 = iNStateKt$ToastMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iNStateKt$ToastMessage$1.label) {
        }
        String defaultString2 = suspendGetString;
        if (!(t instanceof KBusinessException)) {
        }
        return new ToastMessage(msg, 0L, 2, null);
    }

    public static /* synthetic */ Object ToastMessage$default(Throwable th, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return ToastMessage(th, str, continuation);
    }

    public static final KMsgFeedFilterType currentFilterType(List<INFilter> list) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<INFilter> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                INFilter it2 = (INFilter) element$iv;
                if (it2.isSelected()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        INFilter selected = (INFilter) element$iv;
        if (selected == null) {
            KLog_androidKt.getKLog().e(INStateHolderKt.TAG, "List<INFilter>.currentFilterType error. NO SELECTED FILTER in list.");
            return KMsgFeedFilterType.MSG_FEED_ALL.INSTANCE;
        }
        return selected.getType$interactive_debug();
    }

    public static final boolean shouldChangeToFilter(List<INFilter> list, INFilter filter) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        boolean isContains = list.contains(filter);
        List<INFilter> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                INFilter it2 = (INFilter) element$iv;
                if (it2.isSelected()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        boolean isDifferent = !Intrinsics.areEqual(element$iv, filter);
        return isContains && isDifferent;
    }

    public static final List<INFilter> select(List<INFilter> list, INFilter filter) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (filter != null && list.contains(filter)) {
            List<INFilter> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                INFilter it = (INFilter) item$iv$iv;
                destination$iv$iv.add(INFilter.copy$default(it, null, Intrinsics.areEqual(filter, it), null, 5, null));
            }
            return (List) destination$iv$iv;
        }
        return list;
    }

    private static final CommentCtrl createCommentCtrl(KReplyCard replyCard) {
        KReplyBiz replyBiz = replyCard.getReplyBiz();
        KCommonMsgCard commonCard = replyCard.getReplyMsg();
        boolean hideReplyButton = replyBiz != null ? replyBiz.getHideReplyButton() : true;
        if (hideReplyButton || replyBiz == null || commonCard == null) {
            return null;
        }
        long subjectId = replyBiz.getSubjectId();
        long rootId = replyBiz.getRootId();
        long sourceId = replyBiz.getSourceId();
        long targetId = replyBiz.getTargetId();
        long businessId = commonCard.getBusinessId();
        KUser kUser = (KUser) CollectionsKt.singleOrNull(commonCard.getUsers());
        String nickname = kUser != null ? kUser.getNickname() : null;
        KUser kUser2 = (KUser) CollectionsKt.singleOrNull(commonCard.getUsers());
        return new CommentCtrl(subjectId, rootId, sourceId, targetId, businessId, nickname, kUser2 != null ? Long.valueOf(kUser2.getMid()) : null);
    }

    private static final CommentCtrl createCommentCtrl(KAtCard atCard) {
        KAtBiz atBiz = atCard.getAtBiz();
        KCommonMsgCard commonCard = atCard.getAtMsg();
        boolean hideReplyButton = atBiz != null ? atBiz.getHideReplyButton() : true;
        if (hideReplyButton || atBiz == null || commonCard == null) {
            return null;
        }
        long subjectId = atBiz.getSubjectId();
        long rootId = atBiz.getRootId();
        long sourceId = atBiz.getSourceId();
        long targetId = atBiz.getTargetId();
        long businessId = commonCard.getBusinessId();
        KUser kUser = (KUser) CollectionsKt.singleOrNull(commonCard.getUsers());
        String nickname = kUser != null ? kUser.getNickname() : null;
        KUser kUser2 = (KUser) CollectionsKt.singleOrNull(commonCard.getUsers());
        return new CommentCtrl(subjectId, rootId, sourceId, targetId, businessId, nickname, kUser2 != null ? Long.valueOf(kUser2.getMid()) : null);
    }

    private static final LikeCtrl createLikeCtrl(KReplyBiz replyBiz, KCommonMsgCard common2) {
        if (replyBiz == null || common2 == null || replyBiz.getHideLikeButton()) {
            return null;
        }
        return new LikeCtrl(replyBiz.getSubjectId(), common2.getBusinessId(), replyBiz.getSourceId(), replyBiz.getLikeState() != 0);
    }

    private static final INMessageCard messageCard(KMsgFeedMsgCard message, KMsgFeedFilterType currentFilterType, boolean isPinned) {
        String messageTips;
        CommentCtrl commentCtrl;
        LikeCtrl likeCtrl;
        ThankCtrl thankCtrl;
        boolean isMuted;
        List minorOperations;
        long sourceID;
        KCommonMsgCard common2;
        CommentCtrl commentCtrl2;
        LikeCtrl likeCtrl2;
        ThankCtrl thankCtrl2;
        long j;
        CommentCtrl commentCtrl3;
        LikeCtrl likeCtrl3;
        ThankCtrl thankCtrl3;
        long j2;
        byte[] richTextContentByteArray;
        String formatRelativeDateTime;
        KRichTextContent it;
        byte[] bArr;
        KMsgItem msgItem = message.getMsgItem();
        KMsgItem.IMsgCard cardType = msgItem != null ? msgItem.getMsgCard() : null;
        KMsgItem msgItem2 = message.getMsgItem();
        KMsgItem.IMsgCard msgCard = msgItem2 != null ? msgItem2.getMsgCard() : null;
        boolean z = true;
        if (msgCard instanceof KMsgItem.KReplyCard) {
            KMsgItem msgItem3 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard2 = msgItem3 != null ? msgItem3.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard2, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KReplyCard");
            KReplyCard replyCard = ((KMsgItem.KReplyCard) msgCard2).getValue();
            KCommonMsgCard common3 = replyCard.getReplyMsg();
            CommentCtrl commentCtrl4 = createCommentCtrl(replyCard);
            LikeCtrl likeCtrl4 = createLikeCtrl(replyCard.getReplyBiz(), common3);
            List minorOperations2 = CollectionsKt.listOf(new INMinorOperation[]{INMuteMsgOperation.INSTANCE, INDeleteOperation.INSTANCE});
            KNotice notice = replyCard.getReplyNotice();
            if (notice == null || notice.getNoticeState() != 1) {
                z = false;
            }
            boolean isMuted2 = z;
            long sourceID2 = notice != null ? notice.getSourceId() : 0L;
            String noticeText = notice != null ? notice.getNoticeText() : null;
            if (noticeText == null) {
                noticeText = "";
            }
            minorOperations = minorOperations2;
            commentCtrl = commentCtrl4;
            likeCtrl = likeCtrl4;
            thankCtrl = null;
            isMuted = isMuted2;
            messageTips = noticeText;
            sourceID = sourceID2;
            common2 = common3;
        } else if (msgCard instanceof KMsgItem.KAtCard) {
            KMsgItem msgItem4 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard3 = msgItem4 != null ? msgItem4.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard3, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KAtCard");
            KAtCard atCard = ((KMsgItem.KAtCard) msgCard3).getValue();
            KCommonMsgCard common4 = atCard.getAtMsg();
            CommentCtrl commentCtrl5 = createCommentCtrl(atCard);
            minorOperations = CollectionsKt.listOf(INDeleteOperation.INSTANCE);
            commentCtrl = commentCtrl5;
            likeCtrl = null;
            thankCtrl = null;
            isMuted = false;
            sourceID = 0;
            messageTips = "";
            common2 = common4;
        } else if (msgCard instanceof KMsgItem.KDanmuCard) {
            KMsgItem msgItem5 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard4 = msgItem5 != null ? msgItem5.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard4, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KDanmuCard");
            KCommonMsgCard common5 = ((KMsgItem.KDanmuCard) msgCard4).getValue().getDanmuMsg();
            List minorOperations3 = CollectionsKt.listOf(INDeleteOperation.INSTANCE);
            messageTips = "";
            commentCtrl = null;
            likeCtrl = null;
            thankCtrl = null;
            isMuted = false;
            minorOperations = minorOperations3;
            sourceID = 0;
            common2 = common5;
        } else if (msgCard instanceof KMsgItem.KLikeCard) {
            KMsgItem msgItem6 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard5 = msgItem6 != null ? msgItem6.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard5, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KLikeCard");
            KLikeCard likeCard = ((KMsgItem.KLikeCard) msgCard5).getValue();
            KCommonMsgCard common6 = likeCard.getLikeMsg();
            KThankButton it2 = likeCard.getThankButton();
            if (it2 == null) {
                commentCtrl3 = null;
                likeCtrl3 = null;
                thankCtrl3 = null;
            } else {
                if (common6 != null) {
                    commentCtrl3 = null;
                    likeCtrl3 = null;
                    j2 = common6.getId();
                } else {
                    commentCtrl3 = null;
                    likeCtrl3 = null;
                    j2 = 0;
                }
                thankCtrl3 = new ThankCtrl(it2, j2);
            }
            ThankCtrl thankCtrl4 = thankCtrl3;
            boolean isMuted3 = likeCard.getNoticeState() == 1;
            List minorOperations4 = Intrinsics.areEqual(currentFilterType, KMsgFeedFilterType.MSG_FEED_ALL.INSTANCE) ? CollectionsKt.listOf(new INMinorOperation[]{INMuteMsgOperation.INSTANCE, INDeleteOperation.INSTANCE}) : CollectionsKt.listOf(INDeleteOperation.INSTANCE);
            thankCtrl = thankCtrl4;
            isMuted = isMuted3;
            messageTips = "";
            sourceID = 0;
            likeCtrl = likeCtrl3;
            commentCtrl = commentCtrl3;
            minorOperations = minorOperations4;
            common2 = common6;
        } else if (msgCard instanceof KMsgItem.KCoinCard) {
            KMsgItem msgItem7 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard6 = msgItem7 != null ? msgItem7.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard6, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KCoinCard");
            KCoinCard coinCard = ((KMsgItem.KCoinCard) msgCard6).getValue();
            KCommonMsgCard common7 = coinCard.getCoinMsg();
            KThankButton it3 = coinCard.getThankButton();
            if (it3 == null) {
                commentCtrl2 = null;
                likeCtrl2 = null;
                thankCtrl2 = null;
            } else {
                if (common7 != null) {
                    commentCtrl2 = null;
                    likeCtrl2 = null;
                    j = common7.getId();
                } else {
                    commentCtrl2 = null;
                    likeCtrl2 = null;
                    j = 0;
                }
                thankCtrl2 = new ThankCtrl(it3, j);
            }
            ThankCtrl thankCtrl5 = thankCtrl2;
            boolean isMuted4 = coinCard.getNoticeState() == 1;
            List minorOperations5 = Intrinsics.areEqual(currentFilterType, KMsgFeedFilterType.MSG_FEED_ALL.INSTANCE) ? CollectionsKt.listOf(new INMinorOperation[]{INMuteMsgOperation.INSTANCE, INDeleteOperation.INSTANCE}) : CollectionsKt.listOf(INDeleteOperation.INSTANCE);
            common2 = common7;
            thankCtrl = thankCtrl5;
            isMuted = isMuted4;
            messageTips = "";
            sourceID = 0;
            likeCtrl = likeCtrl2;
            commentCtrl = commentCtrl2;
            minorOperations = minorOperations5;
        } else if (msgCard instanceof KMsgItem.KFavoriteCard) {
            KMsgItem msgItem8 = message.getMsgItem();
            KMsgItem.IMsgCard msgCard7 = msgItem8 != null ? msgItem8.getMsgCard() : null;
            Intrinsics.checkNotNull(msgCard7, "null cannot be cast to non-null type com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem.KFavoriteCard");
            KFavoriteCard favoriteCard = ((KMsgItem.KFavoriteCard) msgCard7).getValue();
            KCommonMsgCard common8 = favoriteCard.getFavMsg();
            boolean isMuted5 = favoriteCard.getNoticeState() == 1;
            List minorOperations6 = Intrinsics.areEqual(currentFilterType, KMsgFeedFilterType.MSG_FEED_ALL.INSTANCE) ? CollectionsKt.listOf(new INMinorOperation[]{INMuteMsgOperation.INSTANCE, INDeleteOperation.INSTANCE}) : CollectionsKt.listOf(INDeleteOperation.INSTANCE);
            messageTips = "";
            commentCtrl = null;
            likeCtrl = null;
            thankCtrl = null;
            isMuted = isMuted5;
            minorOperations = minorOperations6;
            sourceID = 0;
            common2 = common8;
        } else {
            List minorOperations7 = CollectionsKt.emptyList();
            messageTips = "";
            commentCtrl = null;
            likeCtrl = null;
            thankCtrl = null;
            isMuted = false;
            minorOperations = minorOperations7;
            sourceID = 0;
            common2 = null;
        }
        if (common2 == null || (it = common2.getRichTextContent()) == null) {
            richTextContentByteArray = null;
        } else {
            try {
                BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
                $this$encodeToByteArray$iv.getSerializersModule();
                bArr = $this$encodeToByteArray$iv.encodeToByteArray(KRichTextContent.Companion.serializer(), it);
            } catch (Exception e2) {
                bArr = null;
            }
            richTextContentByteArray = bArr;
        }
        String timeDescription = (common2 == null || (formatRelativeDateTime = DateTimeFormatKt.formatRelativeDateTime(((long) 1000) * common2.getMsgTime())) == null) ? "" : formatRelativeDateTime;
        return new INMessageCard(message, cardType, common2, richTextContentByteArray, timeDescription, commentCtrl, likeCtrl, thankCtrl, minorOperations, isMuted, isPinned, common2 != null ? common2.isUnread() : false, true, false, sourceID, messageTips, false);
    }

    public static /* synthetic */ boolean isThisFirstTime$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "kntr-base-preferences";
        }
        return isThisFirstTime(str, str2);
    }

    public static final boolean isThisFirstTime(String key, String prefsName) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(prefsName, "prefsName");
        SharedPreferences sp = new SharedPreferences(prefsName, false, 2, (DefaultConstructorMarker) null);
        String value = SharedPreferences.getString$default(sp, key, (String) null, 2, (Object) null);
        if (value == null) {
            sp.setString(key, "true");
            return true;
        }
        return false;
    }
}