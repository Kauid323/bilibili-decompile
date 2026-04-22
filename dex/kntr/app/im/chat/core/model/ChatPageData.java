package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bilibili.blens.Lens;
import im.base.IMRouteHolder;
import im.base.IMToast;
import im.base.model.SessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.core.model.track.ChatPageTechTrack;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: ChatPageData.kt */
@Lens
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0001jBÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$¢\u0006\u0004\b%\u0010&J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010Z\u001a\u00020\u0012HÆ\u0003J\t\u0010[\u001a\u00020\u0014HÆ\u0003J\t\u0010\\\u001a\u00020\u0016HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bHÆ\u0003J\t\u0010^\u001a\u00020\u001aHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010b\u001a\u00020\"HÆ\u0003J\t\u0010c\u001a\u00020$HÆ\u0003JË\u0001\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$HÆ\u0001J\u0013\u0010e\u001a\u00020\u00122\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010g\u001a\u00020HHÖ\u0001J\t\u0010h\u001a\u00020iHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u00105R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bK\u00105R\u0011\u0010L\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bL\u00105R\u0013\u0010M\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\bN\u0010>R\u0013\u0010O\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bP\u0010>R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u00100¨\u0006k"}, d2 = {"Lkntr/app/im/chat/core/model/ChatPageData;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "hostMid", RoomRecommendViewModel.EMPTY_CURSOR, "pageStatus", "Lkntr/app/im/chat/core/model/PageStatus;", "chatInfo", "Lkntr/app/im/chat/core/model/ChatInfo;", "messageGroups", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageGroup;", "toast", "Lim/base/IMToast;", "previewImageData", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewImageData;", "isShowStickerEditPage", RoomRecommendViewModel.EMPTY_CURSOR, "route", "Lim/base/IMRouteHolder;", "upgradeAnswerDialogStatus", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "pendingMsgForUpdate", "Lkntr/app/im/chat/core/model/MessageId;", "inputBoxSelectState", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "deletingMsg", "Lkntr/app/im/chat/core/model/EntityMessage;", "displayingBehaviorAlert", "Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "currentFetchResult", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "inputContent", "Lkntr/app/im/chat/core/model/InputContent;", "track", "Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;", "<init>", "(Lim/base/model/SessionId;JLkntr/app/im/chat/core/model/PageStatus;Lkntr/app/im/chat/core/model/ChatInfo;Ljava/util/List;Lim/base/IMToast;Lkntr/common/photonic/aphro/ui/preview/model/PreviewImageData;ZLim/base/IMRouteHolder;Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;Ljava/util/List;Lkntr/app/im/chat/core/model/InputBoxSelectState;Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;Lkntr/app/im/chat/core/model/FetchMessagesData;Lkntr/app/im/chat/core/model/InputContent;Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;)V", "getSessionId", "()Lim/base/model/SessionId;", "getHostMid", "()J", "getPageStatus", "()Lkntr/app/im/chat/core/model/PageStatus;", "getChatInfo", "()Lkntr/app/im/chat/core/model/ChatInfo;", "getMessageGroups", "()Ljava/util/List;", "getToast", "()Lim/base/IMToast;", "getPreviewImageData", "()Lkntr/common/photonic/aphro/ui/preview/model/PreviewImageData;", "()Z", "getRoute", "()Lim/base/IMRouteHolder;", "getUpgradeAnswerDialogStatus", "()Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "getPendingMsgForUpdate", "getInputBoxSelectState", "()Lkntr/app/im/chat/core/model/InputBoxSelectState;", "getDeletingMsg", "()Lkntr/app/im/chat/core/model/EntityMessage;", "getDisplayingBehaviorAlert", "()Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "getCurrentFetchResult", "()Lkntr/app/im/chat/core/model/FetchMessagesData;", "getInputContent", "()Lkntr/app/im/chat/core/model/InputContent;", "getTrack", "()Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;", "totalItemCountWithTime", RoomRecommendViewModel.EMPTY_CURSOR, "getTotalItemCountWithTime", "()I", "isBottomSheetVisible", "isEnableSendButton", "lastMessage", "getLastMessage", "lastMessageNotSending", "getLastMessageNotSending", "messageSending", "getMessageSending", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatPageData {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final ChatInfo chatInfo;
    private final FetchMessagesData currentFetchResult;
    private final EntityMessage deletingMsg;
    private final KBehaviorAlertToast displayingBehaviorAlert;
    private final long hostMid;
    private final InputBoxSelectState inputBoxSelectState;
    private final InputContent inputContent;
    private final boolean isShowStickerEditPage;
    private final EntityMessage lastMessageNotSending;
    private final List<MessageGroup> messageGroups;
    private final List<EntityMessage> messageSending;
    private final PageStatus pageStatus;
    private final List<MessageId> pendingMsgForUpdate;
    private final PreviewImageData previewImageData;
    private final IMRouteHolder route;
    private final SessionId sessionId;
    private final IMToast toast;
    private final ChatPageTechTrack track;
    private final ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus;

    public final SessionId component1() {
        return this.sessionId;
    }

    public final ChatUpgradeAnswerDialogStatus component10() {
        return this.upgradeAnswerDialogStatus;
    }

    public final List<MessageId> component11() {
        return this.pendingMsgForUpdate;
    }

    public final InputBoxSelectState component12() {
        return this.inputBoxSelectState;
    }

    public final EntityMessage component13() {
        return this.deletingMsg;
    }

    public final KBehaviorAlertToast component14() {
        return this.displayingBehaviorAlert;
    }

    public final FetchMessagesData component15() {
        return this.currentFetchResult;
    }

    public final InputContent component16() {
        return this.inputContent;
    }

    public final ChatPageTechTrack component17() {
        return this.track;
    }

    public final long component2() {
        return this.hostMid;
    }

    public final PageStatus component3() {
        return this.pageStatus;
    }

    public final ChatInfo component4() {
        return this.chatInfo;
    }

    public final List<MessageGroup> component5() {
        return this.messageGroups;
    }

    public final IMToast component6() {
        return this.toast;
    }

    public final PreviewImageData component7() {
        return this.previewImageData;
    }

    public final boolean component8() {
        return this.isShowStickerEditPage;
    }

    public final IMRouteHolder component9() {
        return this.route;
    }

    public final ChatPageData copy(SessionId sessionId, long j2, PageStatus pageStatus, ChatInfo chatInfo, List<MessageGroup> list, IMToast iMToast, PreviewImageData previewImageData, boolean z, IMRouteHolder iMRouteHolder, ChatUpgradeAnswerDialogStatus chatUpgradeAnswerDialogStatus, List<MessageId> list2, InputBoxSelectState inputBoxSelectState, EntityMessage entityMessage, KBehaviorAlertToast kBehaviorAlertToast, FetchMessagesData fetchMessagesData, InputContent inputContent, ChatPageTechTrack chatPageTechTrack) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "messageGroups");
        Intrinsics.checkNotNullParameter(iMRouteHolder, "route");
        Intrinsics.checkNotNullParameter(chatUpgradeAnswerDialogStatus, "upgradeAnswerDialogStatus");
        Intrinsics.checkNotNullParameter(list2, "pendingMsgForUpdate");
        Intrinsics.checkNotNullParameter(inputBoxSelectState, "inputBoxSelectState");
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        Intrinsics.checkNotNullParameter(chatPageTechTrack, "track");
        return new ChatPageData(sessionId, j2, pageStatus, chatInfo, list, iMToast, previewImageData, z, iMRouteHolder, chatUpgradeAnswerDialogStatus, list2, inputBoxSelectState, entityMessage, kBehaviorAlertToast, fetchMessagesData, inputContent, chatPageTechTrack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatPageData) {
            ChatPageData chatPageData = (ChatPageData) obj;
            return Intrinsics.areEqual(this.sessionId, chatPageData.sessionId) && this.hostMid == chatPageData.hostMid && Intrinsics.areEqual(this.pageStatus, chatPageData.pageStatus) && Intrinsics.areEqual(this.chatInfo, chatPageData.chatInfo) && Intrinsics.areEqual(this.messageGroups, chatPageData.messageGroups) && Intrinsics.areEqual(this.toast, chatPageData.toast) && Intrinsics.areEqual(this.previewImageData, chatPageData.previewImageData) && this.isShowStickerEditPage == chatPageData.isShowStickerEditPage && Intrinsics.areEqual(this.route, chatPageData.route) && Intrinsics.areEqual(this.upgradeAnswerDialogStatus, chatPageData.upgradeAnswerDialogStatus) && Intrinsics.areEqual(this.pendingMsgForUpdate, chatPageData.pendingMsgForUpdate) && Intrinsics.areEqual(this.inputBoxSelectState, chatPageData.inputBoxSelectState) && Intrinsics.areEqual(this.deletingMsg, chatPageData.deletingMsg) && Intrinsics.areEqual(this.displayingBehaviorAlert, chatPageData.displayingBehaviorAlert) && Intrinsics.areEqual(this.currentFetchResult, chatPageData.currentFetchResult) && Intrinsics.areEqual(this.inputContent, chatPageData.inputContent) && Intrinsics.areEqual(this.track, chatPageData.track);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.sessionId.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.hostMid)) * 31) + this.pageStatus.hashCode()) * 31) + (this.chatInfo == null ? 0 : this.chatInfo.hashCode())) * 31) + this.messageGroups.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.previewImageData == null ? 0 : this.previewImageData.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShowStickerEditPage)) * 31) + this.route.hashCode()) * 31) + this.upgradeAnswerDialogStatus.hashCode()) * 31) + this.pendingMsgForUpdate.hashCode()) * 31) + this.inputBoxSelectState.hashCode()) * 31) + (this.deletingMsg == null ? 0 : this.deletingMsg.hashCode())) * 31) + (this.displayingBehaviorAlert == null ? 0 : this.displayingBehaviorAlert.hashCode())) * 31) + (this.currentFetchResult != null ? this.currentFetchResult.hashCode() : 0)) * 31) + this.inputContent.hashCode()) * 31) + this.track.hashCode();
    }

    public String toString() {
        SessionId sessionId = this.sessionId;
        long j2 = this.hostMid;
        PageStatus pageStatus = this.pageStatus;
        ChatInfo chatInfo = this.chatInfo;
        List<MessageGroup> list = this.messageGroups;
        IMToast iMToast = this.toast;
        PreviewImageData previewImageData = this.previewImageData;
        boolean z = this.isShowStickerEditPage;
        IMRouteHolder iMRouteHolder = this.route;
        ChatUpgradeAnswerDialogStatus chatUpgradeAnswerDialogStatus = this.upgradeAnswerDialogStatus;
        List<MessageId> list2 = this.pendingMsgForUpdate;
        InputBoxSelectState inputBoxSelectState = this.inputBoxSelectState;
        EntityMessage entityMessage = this.deletingMsg;
        KBehaviorAlertToast kBehaviorAlertToast = this.displayingBehaviorAlert;
        FetchMessagesData fetchMessagesData = this.currentFetchResult;
        InputContent inputContent = this.inputContent;
        return "ChatPageData(sessionId=" + sessionId + ", hostMid=" + j2 + ", pageStatus=" + pageStatus + ", chatInfo=" + chatInfo + ", messageGroups=" + list + ", toast=" + iMToast + ", previewImageData=" + previewImageData + ", isShowStickerEditPage=" + z + ", route=" + iMRouteHolder + ", upgradeAnswerDialogStatus=" + chatUpgradeAnswerDialogStatus + ", pendingMsgForUpdate=" + list2 + ", inputBoxSelectState=" + inputBoxSelectState + ", deletingMsg=" + entityMessage + ", displayingBehaviorAlert=" + kBehaviorAlertToast + ", currentFetchResult=" + fetchMessagesData + ", inputContent=" + inputContent + ", track=" + this.track + ")";
    }

    public ChatPageData(SessionId sessionId, long hostMid, PageStatus pageStatus, ChatInfo chatInfo, List<MessageGroup> list, IMToast toast, PreviewImageData previewImageData, boolean isShowStickerEditPage, IMRouteHolder route, ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus, List<MessageId> list2, InputBoxSelectState inputBoxSelectState, EntityMessage deletingMsg, KBehaviorAlertToast displayingBehaviorAlert, FetchMessagesData currentFetchResult, InputContent inputContent, ChatPageTechTrack track) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "messageGroups");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(upgradeAnswerDialogStatus, "upgradeAnswerDialogStatus");
        Intrinsics.checkNotNullParameter(list2, "pendingMsgForUpdate");
        Intrinsics.checkNotNullParameter(inputBoxSelectState, "inputBoxSelectState");
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        Intrinsics.checkNotNullParameter(track, "track");
        this.sessionId = sessionId;
        this.hostMid = hostMid;
        this.pageStatus = pageStatus;
        this.chatInfo = chatInfo;
        this.messageGroups = list;
        this.toast = toast;
        this.previewImageData = previewImageData;
        this.isShowStickerEditPage = isShowStickerEditPage;
        this.route = route;
        this.upgradeAnswerDialogStatus = upgradeAnswerDialogStatus;
        this.pendingMsgForUpdate = list2;
        this.inputBoxSelectState = inputBoxSelectState;
        this.deletingMsg = deletingMsg;
        this.displayingBehaviorAlert = displayingBehaviorAlert;
        this.currentFetchResult = currentFetchResult;
        this.inputContent = inputContent;
        this.track = track;
        Sequence $this$firstOrNull$iv = SequencesKt.flatMapIterable(CollectionsKt.asSequence(CollectionsKt.asReversed(this.messageGroups)), new Function1() { // from class: kntr.app.im.chat.core.model.ChatPageData$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Iterable lastMessageNotSending$lambda$0;
                lastMessageNotSending$lambda$0 = ChatPageData.lastMessageNotSending$lambda$0((MessageGroup) obj);
                return lastMessageNotSending$lambda$0;
            }
        });
        boolean z = false;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            EntityMessage it2 = (EntityMessage) element$iv;
            Sequence $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            boolean z2 = z;
            if (it2.getSendStatus() != SendStatus.Sending) {
                break;
            }
            $this$firstOrNull$iv = $this$firstOrNull$iv2;
            z = z2;
        }
        this.lastMessageNotSending = (EntityMessage) element$iv;
        Iterable<MessageGroup> list$iv$iv = this.messageGroups;
        Collection destination$iv$iv = new ArrayList();
        for (MessageGroup it3 : list$iv$iv) {
            Iterable $this$flatMap$iv = list$iv$iv;
            CollectionsKt.addAll(destination$iv$iv, it3.getMessages());
            list$iv$iv = $this$flatMap$iv;
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Iterable $this$filter$iv2 = $this$filter$iv;
            EntityMessage it4 = (EntityMessage) element$iv$iv;
            if (it4.getSendStatus() == SendStatus.Sending) {
                destination$iv$iv2.add(element$iv$iv);
            }
            $this$filter$iv = $this$filter$iv2;
        }
        this.messageSending = (List) destination$iv$iv2;
    }

    public /* synthetic */ ChatPageData(SessionId sessionId, long j2, PageStatus pageStatus, ChatInfo chatInfo, List list, IMToast iMToast, PreviewImageData previewImageData, boolean z, IMRouteHolder iMRouteHolder, ChatUpgradeAnswerDialogStatus chatUpgradeAnswerDialogStatus, List list2, InputBoxSelectState inputBoxSelectState, EntityMessage entityMessage, KBehaviorAlertToast kBehaviorAlertToast, FetchMessagesData fetchMessagesData, InputContent inputContent, ChatPageTechTrack chatPageTechTrack, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionId, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? new PageStatus(false, null, null, null, 15, null) : pageStatus, (i & 8) != 0 ? null : chatInfo, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : iMToast, (i & 64) != 0 ? null : previewImageData, (i & 128) != 0 ? false : z, (i & 256) != 0 ? IMRouteHolder.Companion.getEmpty() : iMRouteHolder, (i & 512) != 0 ? ChatUpgradeAnswerDialogStatus.IDLE.INSTANCE : chatUpgradeAnswerDialogStatus, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2, (i & 2048) != 0 ? InputBoxSelectState.Idle.INSTANCE : inputBoxSelectState, (i & 4096) != 0 ? null : entityMessage, (i & 8192) != 0 ? null : kBehaviorAlertToast, (i & 16384) != 0 ? null : fetchMessagesData, (i & 32768) != 0 ? new InputContent(null, null, false, 0, 15, null) : inputContent, (i & 65536) != 0 ? new ChatPageTechTrack(RoomRecommendViewModel.EMPTY_CURSOR, null, null, null, 14, null) : chatPageTechTrack);
    }

    public final SessionId getSessionId() {
        return this.sessionId;
    }

    public final long getHostMid() {
        return this.hostMid;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public final List<MessageGroup> getMessageGroups() {
        return this.messageGroups;
    }

    public final IMToast getToast() {
        return this.toast;
    }

    public final PreviewImageData getPreviewImageData() {
        return this.previewImageData;
    }

    public final boolean isShowStickerEditPage() {
        return this.isShowStickerEditPage;
    }

    public final IMRouteHolder getRoute() {
        return this.route;
    }

    public final ChatUpgradeAnswerDialogStatus getUpgradeAnswerDialogStatus() {
        return this.upgradeAnswerDialogStatus;
    }

    public final List<MessageId> getPendingMsgForUpdate() {
        return this.pendingMsgForUpdate;
    }

    public final InputBoxSelectState getInputBoxSelectState() {
        return this.inputBoxSelectState;
    }

    public final EntityMessage getDeletingMsg() {
        return this.deletingMsg;
    }

    public final KBehaviorAlertToast getDisplayingBehaviorAlert() {
        return this.displayingBehaviorAlert;
    }

    public final FetchMessagesData getCurrentFetchResult() {
        return this.currentFetchResult;
    }

    public final InputContent getInputContent() {
        return this.inputContent;
    }

    public final ChatPageTechTrack getTrack() {
        return this.track;
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/ChatPageData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getTotalItemCountWithTime() {
        int i = 0;
        for (MessageGroup it : this.messageGroups) {
            i += it.getItemCountWithTime();
        }
        return i;
    }

    public final boolean isBottomSheetVisible() {
        return (this.inputBoxSelectState instanceof InputBoxSelectState.Gallery) || (this.inputBoxSelectState instanceof InputBoxSelectState.EMOJI);
    }

    public final boolean isEnableSendButton() {
        return this.inputContent.getHasContent();
    }

    public final EntityMessage getLastMessage() {
        List<EntityMessage> messages;
        MessageGroup messageGroup = (MessageGroup) CollectionsKt.lastOrNull(this.messageGroups);
        if (messageGroup == null || (messages = messageGroup.getMessages()) == null) {
            return null;
        }
        return (EntityMessage) CollectionsKt.lastOrNull(messages);
    }

    public final EntityMessage getLastMessageNotSending() {
        return this.lastMessageNotSending;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable lastMessageNotSending$lambda$0(MessageGroup it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.asReversed(it.getMessages());
    }

    public final List<EntityMessage> getMessageSending() {
        return this.messageSending;
    }
}