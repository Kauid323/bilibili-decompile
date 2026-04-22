package kntr.common.share.common.ui;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareParams;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.internal.ShareMenuProcessorKt;
import kntr.common.share.domain.DomainKt;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.ShareReporter;
import kntr.common.share.domain.model.ShareSession;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ShareMenuVM.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\t\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\t\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GJ\u001c\u0010H\u001a\u00020E2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001a\"\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\"\u00109\u001a\b\u0012\u0004\u0012\u0002010:8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\"\u0010?\u001a\b\u0012\u0004\u0012\u0002060@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010<\u001a\u0004\bB\u0010C¨\u0006J"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuVM;", "", "session", "Lkntr/common/share/domain/model/ShareSession;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "domain", "Lkntr/common/share/domain/ShareDomainApi;", "customizeChannelList", "Lkotlin/Function1;", "Lkntr/common/share/common/ui/ShareChannelList;", "shareContentProvider", "Lkntr/common/share/common/ShareTarget;", "Lkntr/common/share/common/ShareContent;", "clickHandler", "", "disableFetchShareContent", "<init>", "(Lkntr/common/share/domain/model/ShareSession;Lkotlinx/coroutines/CoroutineScope;Lkntr/common/share/domain/ShareDomainApi;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getSession", "()Lkntr/common/share/domain/model/ShareSession;", "getCoroutineScope$common_ui_debug", "()Lkotlinx/coroutines/CoroutineScope;", "getDomain$common_ui_debug", "()Lkntr/common/share/domain/ShareDomainApi;", "getCustomizeChannelList$common_ui_debug", "()Lkotlin/jvm/functions/Function1;", "getShareContentProvider$common_ui_debug", "setShareContentProvider$common_ui_debug", "(Lkotlin/jvm/functions/Function1;)V", "getClickHandler$common_ui_debug", "getDisableFetchShareContent$common_ui_debug", "params", "Lkntr/common/share/common/ShareParams;", "getParams$common_ui_debug", "()Lkntr/common/share/common/ShareParams;", CommonProjectType.REPORTER, "Lkntr/common/share/domain/ShareReporter;", "getReporter$common_ui_debug", "()Lkntr/common/share/domain/ShareReporter;", "extraReportFields", "", "", "getExtraReportFields$common_ui_debug", "()Ljava/util/Map;", "setExtraReportFields$common_ui_debug", "(Ljava/util/Map;)V", "mState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/common/share/common/ui/ShareMenuViewState;", "getMState$common_ui_debug", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "mEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/common/share/common/ui/ShareMenuEffect;", "getMEffect$common_ui_debug", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect$annotations", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "dispatch", "", "action", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "updateContentProvider", "newProvider", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuVM {
    public static final int $stable = 8;
    private final Function1<ShareTarget, Boolean> clickHandler;
    private final CoroutineScope coroutineScope;
    private final Function1<ShareChannelList, ShareChannelList> customizeChannelList;
    private final Function1<ShareTarget, Boolean> disableFetchShareContent;
    private final ShareDomainApi domain;
    private final SharedFlow<ShareMenuEffect> effect;
    private Map<String, String> extraReportFields;
    private final MutableSharedFlow<ShareMenuEffect> mEffect;
    private final MutableStateFlow<ShareMenuViewState> mState;
    private final ShareReporter reporter;
    private final ShareSession session;
    private Function1<? super ShareTarget, ShareContent> shareContentProvider;
    private final StateFlow<ShareMenuViewState> state;

    public static /* synthetic */ void getEffect$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareMenuVM(ShareSession session, CoroutineScope coroutineScope, ShareDomainApi domain, Function1<? super ShareChannelList, ShareChannelList> function1, Function1<? super ShareTarget, ShareContent> function12, Function1<? super ShareTarget, Boolean> function13, Function1<? super ShareTarget, Boolean> function14) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(function1, "customizeChannelList");
        Intrinsics.checkNotNullParameter(function12, "shareContentProvider");
        Intrinsics.checkNotNullParameter(function13, "clickHandler");
        Intrinsics.checkNotNullParameter(function14, "disableFetchShareContent");
        this.session = session;
        this.coroutineScope = coroutineScope;
        this.domain = domain;
        this.customizeChannelList = function1;
        this.shareContentProvider = function12;
        this.clickHandler = function13;
        this.disableFetchShareContent = function14;
        this.reporter = new ShareReporter();
        this.extraReportFields = MapsKt.emptyMap();
        this.mState = StateFlowKt.MutableStateFlow(new ShareMenuViewState(false, false, false, null, null, null, null, 127, null));
        this.mEffect = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.state = FlowKt.asStateFlow(this.mState);
        this.effect = FlowKt.asSharedFlow(this.mEffect);
    }

    public /* synthetic */ ShareMenuVM(ShareSession shareSession, CoroutineScope coroutineScope, ShareDomainApi shareDomainApi, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareSession, coroutineScope, (i & 4) != 0 ? DomainKt.defaultDomain(ShareKt.gShare()) : shareDomainApi, (i & 8) != 0 ? new Function1() { // from class: kntr.common.share.common.ui.ShareMenuVM$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ShareMenuVM._init_$lambda$0((ShareChannelList) obj);
            }
        } : function1, function12, (i & 32) != 0 ? new Function1() { // from class: kntr.common.share.common.ui.ShareMenuVM$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean _init_$lambda$1;
                _init_$lambda$1 = ShareMenuVM._init_$lambda$1((ShareTarget) obj);
                return Boolean.valueOf(_init_$lambda$1);
            }
        } : function13, (i & 64) != 0 ? new Function1() { // from class: kntr.common.share.common.ui.ShareMenuVM$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean _init_$lambda$2;
                _init_$lambda$2 = ShareMenuVM._init_$lambda$2((ShareTarget) obj);
                return Boolean.valueOf(_init_$lambda$2);
            }
        } : function14);
    }

    public final ShareSession getSession() {
        return this.session;
    }

    public final CoroutineScope getCoroutineScope$common_ui_debug() {
        return this.coroutineScope;
    }

    public final ShareDomainApi getDomain$common_ui_debug() {
        return this.domain;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.common.share.common.ui.ShareChannelList _init_$lambda$0(kntr.common.share.common.ui.ShareChannelList r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.common.share.common.ui.ShareMenuVM._init_$lambda$0(kntr.common.share.common.ui.ShareChannelList):kntr.common.share.common.ui.ShareChannelList");
    }

    public final Function1<ShareChannelList, ShareChannelList> getCustomizeChannelList$common_ui_debug() {
        return this.customizeChannelList;
    }

    public final Function1<ShareTarget, ShareContent> getShareContentProvider$common_ui_debug() {
        return this.shareContentProvider;
    }

    public final void setShareContentProvider$common_ui_debug(Function1<? super ShareTarget, ShareContent> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.shareContentProvider = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public final Function1<ShareTarget, Boolean> getClickHandler$common_ui_debug() {
        return this.clickHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(ShareTarget it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    public final Function1<ShareTarget, Boolean> getDisableFetchShareContent$common_ui_debug() {
        return this.disableFetchShareContent;
    }

    public final ShareParams getParams$common_ui_debug() {
        return this.session.getParams();
    }

    public final ShareReporter getReporter$common_ui_debug() {
        return this.reporter;
    }

    public final Map<String, String> getExtraReportFields$common_ui_debug() {
        return this.extraReportFields;
    }

    public final void setExtraReportFields$common_ui_debug(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraReportFields = map;
    }

    public final MutableStateFlow<ShareMenuViewState> getMState$common_ui_debug() {
        return this.mState;
    }

    public final MutableSharedFlow<ShareMenuEffect> getMEffect$common_ui_debug() {
        return this.mEffect;
    }

    public final StateFlow<ShareMenuViewState> getState() {
        return this.state;
    }

    public final SharedFlow<ShareMenuEffect> getEffect() {
        return this.effect;
    }

    public final void dispatch(ShareMenuViewAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ShareMenuProcessorKt.processAction(this, action);
    }

    public final void updateContentProvider(Function1<? super ShareTarget, ShareContent> function1) {
        Intrinsics.checkNotNullParameter(function1, "newProvider");
        this.shareContentProvider = function1;
    }
}