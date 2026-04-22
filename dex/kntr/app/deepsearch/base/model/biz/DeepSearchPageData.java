package kntr.app.deepsearch.base.model.biz;

import androidx.collection.DoubleList$;
import com.bilibili.blens.Lens;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.PageStatus;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPageData.kt */
@Lens
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\bHÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\t\u0010I\u001a\u00020\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010Q\u001a\u00020\u001eHÆ\u0003J\t\u0010R\u001a\u00020 HÆ\u0003J½\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 HÆ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020XHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006["}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQuery", "sessionTitle", "historyCursor", "pageStatus", "Lkntr/app/deepsearch/base/model/biz/PageStatus;", "pageStyle", "Lkntr/app/deepsearch/base/model/biz/PageStyle;", "requestModel", "Lkntr/app/deepsearch/base/model/biz/RequestModel;", "textConfigModel", "Lkntr/app/deepsearch/base/model/biz/TextConfigModel;", "containerWidth", RoomRecommendViewModel.EMPTY_CURSOR, "pageChatState", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "thinkPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "deepSearchToast", "Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", "copyModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel;", "treadPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;", "bubbleData", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "inputState", "Lkntr/app/deepsearch/base/model/input/InputState;", "list", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/PageStatus;Lkntr/app/deepsearch/base/model/biz/PageStyle;Lkntr/app/deepsearch/base/model/biz/RequestModel;Lkntr/app/deepsearch/base/model/biz/TextConfigModel;DLkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel;Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;Lkntr/app/deepsearch/base/model/biz/LinkNodeData;Lkntr/app/deepsearch/base/model/input/InputState;Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;)V", "getSessionId", "()Ljava/lang/String;", "getSessionQuery", "getSessionTitle", "getHistoryCursor", "getPageStatus", "()Lkntr/app/deepsearch/base/model/biz/PageStatus;", "getPageStyle", "()Lkntr/app/deepsearch/base/model/biz/PageStyle;", "getRequestModel", "()Lkntr/app/deepsearch/base/model/biz/RequestModel;", "getTextConfigModel", "()Lkntr/app/deepsearch/base/model/biz/TextConfigModel;", "getContainerWidth", "()D", "getPageChatState", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "getThinkPopContent", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "getDeepSearchToast", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", "getCopyModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel;", "getTreadPopContent", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;", "getBubbleData", "()Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "getInputState", "()Lkntr/app/deepsearch/base/model/input/InputState;", "getList", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchPageData {
    public static final Companion Companion = new Companion(null);
    private final LinkNodeData bubbleData;
    private final double containerWidth;
    private final DeepSearchCopyModel copyModel;
    private final DeepSearchToast deepSearchToast;
    private final String historyCursor;
    private final InputState inputState;
    private final DeepSearchContentList list;
    private final DeepSearchPageChatState pageChatState;
    private final PageStatus pageStatus;
    private final PageStyle pageStyle;
    private final RequestModel requestModel;
    private final String sessionId;
    private final String sessionQuery;
    private final String sessionTitle;
    private final TextConfigModel textConfigModel;
    private final DeepSearchThinkPopContent thinkPopContent;
    private final DeepSearchTreadPopContent treadPopContent;

    public DeepSearchPageData() {
        this(null, null, null, null, null, null, null, null, 0.0d, null, null, null, null, null, null, null, null, 131071, null);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final DeepSearchPageChatState component10() {
        return this.pageChatState;
    }

    public final DeepSearchThinkPopContent component11() {
        return this.thinkPopContent;
    }

    public final DeepSearchToast component12() {
        return this.deepSearchToast;
    }

    public final DeepSearchCopyModel component13() {
        return this.copyModel;
    }

    public final DeepSearchTreadPopContent component14() {
        return this.treadPopContent;
    }

    public final LinkNodeData component15() {
        return this.bubbleData;
    }

    public final InputState component16() {
        return this.inputState;
    }

    public final DeepSearchContentList component17() {
        return this.list;
    }

    public final String component2() {
        return this.sessionQuery;
    }

    public final String component3() {
        return this.sessionTitle;
    }

    public final String component4() {
        return this.historyCursor;
    }

    public final PageStatus component5() {
        return this.pageStatus;
    }

    public final PageStyle component6() {
        return this.pageStyle;
    }

    public final RequestModel component7() {
        return this.requestModel;
    }

    public final TextConfigModel component8() {
        return this.textConfigModel;
    }

    public final double component9() {
        return this.containerWidth;
    }

    public final DeepSearchPageData copy(String str, String str2, String str3, String str4, PageStatus pageStatus, PageStyle pageStyle, RequestModel requestModel, TextConfigModel textConfigModel, double d, DeepSearchPageChatState deepSearchPageChatState, DeepSearchThinkPopContent deepSearchThinkPopContent, DeepSearchToast deepSearchToast, DeepSearchCopyModel deepSearchCopyModel, DeepSearchTreadPopContent deepSearchTreadPopContent, LinkNodeData linkNodeData, InputState inputState, DeepSearchContentList deepSearchContentList) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "sessionQuery");
        Intrinsics.checkNotNullParameter(str3, "sessionTitle");
        Intrinsics.checkNotNullParameter(str4, "historyCursor");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(pageStyle, "pageStyle");
        Intrinsics.checkNotNullParameter(requestModel, "requestModel");
        Intrinsics.checkNotNullParameter(textConfigModel, "textConfigModel");
        Intrinsics.checkNotNullParameter(deepSearchPageChatState, "pageChatState");
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        Intrinsics.checkNotNullParameter(deepSearchContentList, "list");
        return new DeepSearchPageData(str, str2, str3, str4, pageStatus, pageStyle, requestModel, textConfigModel, d, deepSearchPageChatState, deepSearchThinkPopContent, deepSearchToast, deepSearchCopyModel, deepSearchTreadPopContent, linkNodeData, inputState, deepSearchContentList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchPageData) {
            DeepSearchPageData deepSearchPageData = (DeepSearchPageData) obj;
            return Intrinsics.areEqual(this.sessionId, deepSearchPageData.sessionId) && Intrinsics.areEqual(this.sessionQuery, deepSearchPageData.sessionQuery) && Intrinsics.areEqual(this.sessionTitle, deepSearchPageData.sessionTitle) && Intrinsics.areEqual(this.historyCursor, deepSearchPageData.historyCursor) && Intrinsics.areEqual(this.pageStatus, deepSearchPageData.pageStatus) && Intrinsics.areEqual(this.pageStyle, deepSearchPageData.pageStyle) && Intrinsics.areEqual(this.requestModel, deepSearchPageData.requestModel) && Intrinsics.areEqual(this.textConfigModel, deepSearchPageData.textConfigModel) && Double.compare(this.containerWidth, deepSearchPageData.containerWidth) == 0 && Intrinsics.areEqual(this.pageChatState, deepSearchPageData.pageChatState) && Intrinsics.areEqual(this.thinkPopContent, deepSearchPageData.thinkPopContent) && Intrinsics.areEqual(this.deepSearchToast, deepSearchPageData.deepSearchToast) && Intrinsics.areEqual(this.copyModel, deepSearchPageData.copyModel) && Intrinsics.areEqual(this.treadPopContent, deepSearchPageData.treadPopContent) && Intrinsics.areEqual(this.bubbleData, deepSearchPageData.bubbleData) && Intrinsics.areEqual(this.inputState, deepSearchPageData.inputState) && Intrinsics.areEqual(this.list, deepSearchPageData.list);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.sessionId.hashCode() * 31) + this.sessionQuery.hashCode()) * 31) + this.sessionTitle.hashCode()) * 31) + this.historyCursor.hashCode()) * 31) + this.pageStatus.hashCode()) * 31) + this.pageStyle.hashCode()) * 31) + this.requestModel.hashCode()) * 31) + this.textConfigModel.hashCode()) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.containerWidth)) * 31) + this.pageChatState.hashCode()) * 31) + (this.thinkPopContent == null ? 0 : this.thinkPopContent.hashCode())) * 31) + (this.deepSearchToast == null ? 0 : this.deepSearchToast.hashCode())) * 31) + (this.copyModel == null ? 0 : this.copyModel.hashCode())) * 31) + (this.treadPopContent == null ? 0 : this.treadPopContent.hashCode())) * 31) + (this.bubbleData != null ? this.bubbleData.hashCode() : 0)) * 31) + this.inputState.hashCode()) * 31) + this.list.hashCode();
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.sessionQuery;
        String str3 = this.sessionTitle;
        String str4 = this.historyCursor;
        PageStatus pageStatus = this.pageStatus;
        PageStyle pageStyle = this.pageStyle;
        RequestModel requestModel = this.requestModel;
        TextConfigModel textConfigModel = this.textConfigModel;
        double d = this.containerWidth;
        DeepSearchPageChatState deepSearchPageChatState = this.pageChatState;
        DeepSearchThinkPopContent deepSearchThinkPopContent = this.thinkPopContent;
        DeepSearchToast deepSearchToast = this.deepSearchToast;
        DeepSearchCopyModel deepSearchCopyModel = this.copyModel;
        DeepSearchTreadPopContent deepSearchTreadPopContent = this.treadPopContent;
        LinkNodeData linkNodeData = this.bubbleData;
        InputState inputState = this.inputState;
        return "DeepSearchPageData(sessionId=" + str + ", sessionQuery=" + str2 + ", sessionTitle=" + str3 + ", historyCursor=" + str4 + ", pageStatus=" + pageStatus + ", pageStyle=" + pageStyle + ", requestModel=" + requestModel + ", textConfigModel=" + textConfigModel + ", containerWidth=" + d + ", pageChatState=" + deepSearchPageChatState + ", thinkPopContent=" + deepSearchThinkPopContent + ", deepSearchToast=" + deepSearchToast + ", copyModel=" + deepSearchCopyModel + ", treadPopContent=" + deepSearchTreadPopContent + ", bubbleData=" + linkNodeData + ", inputState=" + inputState + ", list=" + this.list + ")";
    }

    public DeepSearchPageData(String sessionId, String sessionQuery, String sessionTitle, String historyCursor, PageStatus pageStatus, PageStyle pageStyle, RequestModel requestModel, TextConfigModel textConfigModel, double containerWidth, DeepSearchPageChatState pageChatState, DeepSearchThinkPopContent thinkPopContent, DeepSearchToast deepSearchToast, DeepSearchCopyModel copyModel, DeepSearchTreadPopContent treadPopContent, LinkNodeData bubbleData, InputState inputState, DeepSearchContentList list) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionQuery, "sessionQuery");
        Intrinsics.checkNotNullParameter(sessionTitle, "sessionTitle");
        Intrinsics.checkNotNullParameter(historyCursor, "historyCursor");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(pageStyle, "pageStyle");
        Intrinsics.checkNotNullParameter(requestModel, "requestModel");
        Intrinsics.checkNotNullParameter(textConfigModel, "textConfigModel");
        Intrinsics.checkNotNullParameter(pageChatState, "pageChatState");
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        Intrinsics.checkNotNullParameter(list, "list");
        this.sessionId = sessionId;
        this.sessionQuery = sessionQuery;
        this.sessionTitle = sessionTitle;
        this.historyCursor = historyCursor;
        this.pageStatus = pageStatus;
        this.pageStyle = pageStyle;
        this.requestModel = requestModel;
        this.textConfigModel = textConfigModel;
        this.containerWidth = containerWidth;
        this.pageChatState = pageChatState;
        this.thinkPopContent = thinkPopContent;
        this.deepSearchToast = deepSearchToast;
        this.copyModel = copyModel;
        this.treadPopContent = treadPopContent;
        this.bubbleData = bubbleData;
        this.inputState = inputState;
        this.list = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DeepSearchPageData(String str, String str2, String str3, String str4, PageStatus pageStatus, PageStyle pageStyle, RequestModel requestModel, TextConfigModel textConfigModel, double d, DeepSearchPageChatState deepSearchPageChatState, DeepSearchThinkPopContent deepSearchThinkPopContent, DeepSearchToast deepSearchToast, DeepSearchCopyModel deepSearchCopyModel, DeepSearchTreadPopContent deepSearchTreadPopContent, LinkNodeData linkNodeData, InputState inputState, DeepSearchContentList deepSearchContentList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r2, r5, r6, r7, r8, r9, r11, r14, r15, r18, r44, r17, r16, r0);
        DeepSearchCopyModel deepSearchCopyModel2;
        LinkNodeData linkNodeData2;
        DeepSearchContentList deepSearchContentList2;
        int i2 = i & 1;
        String str5 = RoomRecommendViewModel.EMPTY_CURSOR;
        String str6 = i2 != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str;
        String str7 = (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2;
        String str8 = (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3;
        str5 = (i & 8) == 0 ? str4 : str5;
        PageStatus.Idle idle = (i & 16) != 0 ? PageStatus.Idle.INSTANCE : pageStatus;
        PageStyle.Idle idle2 = (i & 32) != 0 ? PageStyle.Idle.INSTANCE : pageStyle;
        RequestModel requestModel2 = (i & 64) != 0 ? new RequestModel(null, null, null, null, null, null, null, 127, null) : requestModel;
        TextConfigModel textConfigModel2 = (i & 128) != 0 ? new TextConfigModel(null, null, null, null, null, null, 0L, null, 255, null) : textConfigModel;
        double d2 = (i & 256) != 0 ? 0.0d : d;
        DeepSearchPageChatState.None none = (i & 512) != 0 ? new DeepSearchPageChatState.None(null, null, 3, null) : deepSearchPageChatState;
        DeepSearchThinkPopContent deepSearchThinkPopContent2 = (i & 1024) != 0 ? null : deepSearchThinkPopContent;
        DeepSearchToast deepSearchToast2 = (i & 2048) != 0 ? null : deepSearchToast;
        DeepSearchCopyModel deepSearchCopyModel3 = (i & 4096) != 0 ? null : deepSearchCopyModel;
        DeepSearchTreadPopContent deepSearchTreadPopContent2 = (i & 8192) != 0 ? null : deepSearchTreadPopContent;
        LinkNodeData linkNodeData3 = (i & 16384) != 0 ? null : linkNodeData;
        InputState inputState2 = (i & 32768) != 0 ? new InputState(null, null, 0, false, false, 31, null) : inputState;
        if ((i & 65536) != 0) {
            deepSearchCopyModel2 = deepSearchCopyModel3;
            linkNodeData2 = linkNodeData3;
            deepSearchContentList2 = new DeepSearchContentList(null, null, 3, null);
        } else {
            deepSearchCopyModel2 = deepSearchCopyModel3;
            linkNodeData2 = linkNodeData3;
            deepSearchContentList2 = deepSearchContentList;
        }
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionQuery() {
        return this.sessionQuery;
    }

    public final String getSessionTitle() {
        return this.sessionTitle;
    }

    public final String getHistoryCursor() {
        return this.historyCursor;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final PageStyle getPageStyle() {
        return this.pageStyle;
    }

    public final RequestModel getRequestModel() {
        return this.requestModel;
    }

    public final TextConfigModel getTextConfigModel() {
        return this.textConfigModel;
    }

    public final double getContainerWidth() {
        return this.containerWidth;
    }

    public final DeepSearchPageChatState getPageChatState() {
        return this.pageChatState;
    }

    public final DeepSearchThinkPopContent getThinkPopContent() {
        return this.thinkPopContent;
    }

    public final DeepSearchToast getDeepSearchToast() {
        return this.deepSearchToast;
    }

    public final DeepSearchCopyModel getCopyModel() {
        return this.copyModel;
    }

    public final DeepSearchTreadPopContent getTreadPopContent() {
        return this.treadPopContent;
    }

    public final LinkNodeData getBubbleData() {
        return this.bubbleData;
    }

    public final InputState getInputState() {
        return this.inputState;
    }

    public final DeepSearchContentList getList() {
        return this.list;
    }

    /* compiled from: DeepSearchPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}