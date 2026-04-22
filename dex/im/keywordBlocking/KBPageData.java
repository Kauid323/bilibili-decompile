package im.keywordBlocking;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingItem;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingListReply;
import com.bilibili.blens.Lens;
import com.tencent.smtt.utils.TbsLog;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IMToast;
import im.base.IMToastKt;
import im.base.IdleContent;
import im.base.LoadingContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Lens
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0001OBy\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u00107\u001a\u00020\u00002\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0080@¢\u0006\u0004\b;\u0010<J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\u000e\u0010A\u001a\u00020\bHÀ\u0003¢\u0006\u0002\bBJ\u0010\u0010C\u001a\u0004\u0018\u00010\rHÀ\u0003¢\u0006\u0002\bDJ\u000b\u0010E\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000e\u0010H\u001a\u00020\u0015HÀ\u0003¢\u0006\u0002\bIJ{\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010K\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\bHÖ\u0001J\t\u0010N\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000b\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b2\u0010*R\u0011\u00103\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b4\u0010*R\u0014\u00105\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010*¨\u0006P"}, d2 = {"Lim/keywordBlocking/KBPageData;", "", "status", "Lim/keywordBlocking/KBPageStatus;", "items", "", "Lim/keywordBlocking/KBListItem;", "limit", "", "limitsHint", "", "charLimit", "toast", "Lim/base/IMToast;", "inputBox", "Lim/keywordBlocking/KBInputBox;", "dropList", "Lim/keywordBlocking/KBDropList;", "alert", "Lim/keywordBlocking/KBAlert;", "firstLoad", "", "<init>", "(Lim/keywordBlocking/KBPageStatus;Ljava/util/List;ILjava/lang/String;ILim/base/IMToast;Lim/keywordBlocking/KBInputBox;Lim/keywordBlocking/KBDropList;Lim/keywordBlocking/KBAlert;Z)V", "getStatus", "()Lim/keywordBlocking/KBPageStatus;", "getItems", "()Ljava/util/List;", "getLimit", "()I", "getLimitsHint", "()Ljava/lang/String;", "getCharLimit$keyword_blocking_debug", "getToast$keyword_blocking_debug", "()Lim/base/IMToast;", "getInputBox", "()Lim/keywordBlocking/KBInputBox;", "getDropList", "()Lim/keywordBlocking/KBDropList;", "getAlert", "()Lim/keywordBlocking/KBAlert;", "getFirstLoad$keyword_blocking_debug", "()Z", "hasReachLimits", "getHasReachLimits", "contentStatus", "Lim/base/ContentStatus;", "getContentStatus", "()Lim/base/ContentStatus;", "displayAddButton", "getDisplayAddButton", "displayLimitsHint", "getDisplayLimitsHint", "isInputting", "isInputting$keyword_blocking_debug", "receive", "result", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingListReply;", "receive$keyword_blocking_debug", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component5$keyword_blocking_debug", "component6", "component6$keyword_blocking_debug", "component7", "component8", "component9", "component10", "component10$keyword_blocking_debug", "copy", "equals", "other", "hashCode", "toString", "Companion", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBPageData {
    public static final Companion Companion = new Companion(null);
    private final KBAlert alert;
    private final int charLimit;
    private final KBDropList dropList;
    private final boolean firstLoad;
    private final KBInputBox inputBox;
    private final List<KBListItem> items;
    private final int limit;
    private final String limitsHint;
    private final KBPageStatus status;
    private final IMToast toast;

    public KBPageData() {
        this(null, null, 0, null, 0, null, null, null, null, false, 1023, null);
    }

    public final KBPageStatus component1() {
        return this.status;
    }

    public final boolean component10$keyword_blocking_debug() {
        return this.firstLoad;
    }

    public final List<KBListItem> component2() {
        return this.items;
    }

    public final int component3() {
        return this.limit;
    }

    public final String component4() {
        return this.limitsHint;
    }

    public final int component5$keyword_blocking_debug() {
        return this.charLimit;
    }

    public final IMToast component6$keyword_blocking_debug() {
        return this.toast;
    }

    public final KBInputBox component7() {
        return this.inputBox;
    }

    public final KBDropList component8() {
        return this.dropList;
    }

    public final KBAlert component9() {
        return this.alert;
    }

    public final KBPageData copy(KBPageStatus kBPageStatus, List<KBListItem> list, int i2, String str, int i3, IMToast iMToast, KBInputBox kBInputBox, KBDropList kBDropList, KBAlert kBAlert, boolean z) {
        Intrinsics.checkNotNullParameter(kBPageStatus, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str, "limitsHint");
        return new KBPageData(kBPageStatus, list, i2, str, i3, iMToast, kBInputBox, kBDropList, kBAlert, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBPageData) {
            KBPageData kBPageData = (KBPageData) obj;
            return Intrinsics.areEqual(this.status, kBPageData.status) && Intrinsics.areEqual(this.items, kBPageData.items) && this.limit == kBPageData.limit && Intrinsics.areEqual(this.limitsHint, kBPageData.limitsHint) && this.charLimit == kBPageData.charLimit && Intrinsics.areEqual(this.toast, kBPageData.toast) && Intrinsics.areEqual(this.inputBox, kBPageData.inputBox) && Intrinsics.areEqual(this.dropList, kBPageData.dropList) && Intrinsics.areEqual(this.alert, kBPageData.alert) && this.firstLoad == kBPageData.firstLoad;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.status.hashCode() * 31) + this.items.hashCode()) * 31) + this.limit) * 31) + this.limitsHint.hashCode()) * 31) + this.charLimit) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.inputBox == null ? 0 : this.inputBox.hashCode())) * 31) + (this.dropList == null ? 0 : this.dropList.hashCode())) * 31) + (this.alert != null ? this.alert.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.firstLoad);
    }

    public String toString() {
        KBPageStatus kBPageStatus = this.status;
        List<KBListItem> list = this.items;
        int i2 = this.limit;
        String str = this.limitsHint;
        int i3 = this.charLimit;
        IMToast iMToast = this.toast;
        KBInputBox kBInputBox = this.inputBox;
        KBDropList kBDropList = this.dropList;
        KBAlert kBAlert = this.alert;
        return "KBPageData(status=" + kBPageStatus + ", items=" + list + ", limit=" + i2 + ", limitsHint=" + str + ", charLimit=" + i3 + ", toast=" + iMToast + ", inputBox=" + kBInputBox + ", dropList=" + kBDropList + ", alert=" + kBAlert + ", firstLoad=" + this.firstLoad + ")";
    }

    public KBPageData(KBPageStatus status, List<KBListItem> list, int limit, String limitsHint, int charLimit, IMToast toast, KBInputBox inputBox, KBDropList dropList, KBAlert alert, boolean firstLoad) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(limitsHint, "limitsHint");
        this.status = status;
        this.items = list;
        this.limit = limit;
        this.limitsHint = limitsHint;
        this.charLimit = charLimit;
        this.toast = toast;
        this.inputBox = inputBox;
        this.dropList = dropList;
        this.alert = alert;
        this.firstLoad = firstLoad;
    }

    public /* synthetic */ KBPageData(KBPageStatus kBPageStatus, List list, int i2, String str, int i3, IMToast iMToast, KBInputBox kBInputBox, KBDropList kBDropList, KBAlert kBAlert, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KBPageStatusInitial.INSTANCE : kBPageStatus, (i4 & 2) != 0 ? CollectionsKt.emptyList() : list, (i4 & 4) != 0 ? Integer.MAX_VALUE : i2, (i4 & 8) != 0 ? "" : str, (i4 & 16) == 0 ? i3 : Integer.MAX_VALUE, (i4 & 32) != 0 ? null : iMToast, (i4 & 64) != 0 ? null : kBInputBox, (i4 & 128) != 0 ? null : kBDropList, (i4 & 256) == 0 ? kBAlert : null, (i4 & 512) != 0 ? true : z);
    }

    public final KBPageStatus getStatus() {
        return this.status;
    }

    public final List<KBListItem> getItems() {
        return this.items;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getLimitsHint() {
        return this.limitsHint;
    }

    public final int getCharLimit$keyword_blocking_debug() {
        return this.charLimit;
    }

    public final IMToast getToast$keyword_blocking_debug() {
        return this.toast;
    }

    public final KBInputBox getInputBox() {
        return this.inputBox;
    }

    public final KBDropList getDropList() {
        return this.dropList;
    }

    public final KBAlert getAlert() {
        return this.alert;
    }

    public final boolean getFirstLoad$keyword_blocking_debug() {
        return this.firstLoad;
    }

    /* compiled from: KBPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/keywordBlocking/KBPageData$Companion;", "", "<init>", "()V", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getHasReachLimits() {
        return this.items.size() >= this.limit;
    }

    public final ContentStatus getContentStatus() {
        KBPageStatus kBPageStatus = this.status;
        if (Intrinsics.areEqual(kBPageStatus, KBPageStatusInitial.INSTANCE)) {
            return IdleContent.INSTANCE;
        }
        if (Intrinsics.areEqual(kBPageStatus, KBPageStatusLoading.INSTANCE)) {
            return LoadingContent.INSTANCE;
        }
        if (kBPageStatus instanceof KBPageStatusError) {
            return new ErrorContent(((KBPageStatusError) this.status).getMessage());
        }
        if (Intrinsics.areEqual(kBPageStatus, KBPageStatusIdle.INSTANCE)) {
            return this.items.isEmpty() ? EmptyContent.INSTANCE : IdleContent.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getDisplayAddButton() {
        return Intrinsics.areEqual(this.status, KBPageStatusIdle.INSTANCE) && !getHasReachLimits();
    }

    public final boolean getDisplayLimitsHint() {
        return Intrinsics.areEqual(this.status, KBPageStatusIdle.INSTANCE) && getHasReachLimits();
    }

    public final boolean isInputting$keyword_blocking_debug() {
        return (this.status instanceof KBPageStatusIdle) && this.inputBox != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object receive$keyword_blocking_debug(Object result, Continuation<? super KBPageData> continuation) {
        KBPageData$receive$1 kBPageData$receive$1;
        Object displayString$default;
        if (continuation instanceof KBPageData$receive$1) {
            kBPageData$receive$1 = (KBPageData$receive$1) continuation;
            if ((kBPageData$receive$1.label & Integer.MIN_VALUE) != 0) {
                kBPageData$receive$1.label -= Integer.MIN_VALUE;
                Object $result = kBPageData$receive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBPageData$receive$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Throwable it = Result.exceptionOrNull-impl(result);
                        if (it == null) {
                            KKeywordBlockingListReply it2 = (KKeywordBlockingListReply) result;
                            boolean z = false;
                            KBPageStatusIdle kBPageStatusIdle = KBPageStatusIdle.INSTANCE;
                            Iterable $this$map$iv = it2.getItems();
                            boolean z2 = false;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                destination$iv$iv.add(new KBListItem(((KKeywordBlockingItem) item$iv$iv).getKeyword(), false, 2, null));
                                $this$map$iv = $this$map$iv;
                                z2 = z2;
                                z = z;
                            }
                            return new KBPageData(kBPageStatusIdle, (List) destination$iv$iv, it2.getListLimit(), it2.getListLimitText(), it2.getCharLimit(), null, null, null, null, false, TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null);
                        }
                        kBPageData$receive$1.L$0 = SpillingKt.nullOutSpilledVariable(result);
                        kBPageData$receive$1.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        kBPageData$receive$1.I$0 = 0;
                        kBPageData$receive$1.label = 1;
                        displayString$default = IMToastKt.toDisplayString$default(it, null, null, kBPageData$receive$1, 3, null);
                        if (displayString$default != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = kBPageData$receive$1.I$0;
                        Throwable th = (Throwable) kBPageData$receive$1.L$1;
                        Object obj = kBPageData$receive$1.L$0;
                        ResultKt.throwOnFailure($result);
                        displayString$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return new KBPageData(new KBPageStatusError((String) displayString$default), null, 0, null, 0, null, null, null, null, false, 1022, null);
            }
        }
        kBPageData$receive$1 = new KBPageData$receive$1(this, continuation);
        Object $result2 = kBPageData$receive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBPageData$receive$1.label) {
        }
        return new KBPageData(new KBPageStatusError((String) displayString$default), null, 0, null, 0, null, null, null, null, false, 1022, null);
    }
}