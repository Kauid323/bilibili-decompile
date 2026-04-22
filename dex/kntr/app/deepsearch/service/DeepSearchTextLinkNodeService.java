package kntr.app.deepsearch.service;

import com.bapis.bilibili.app.dynamic.v2.KLinkNode;
import javax.inject.Inject;
import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.deepsearch.di.DeepSearchCoroutineScope;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: DeepSearchTextLinkNodeService.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", RoomRecommendViewModel.EMPTY_CURSOR, "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "tapTextFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "getTapTextFlow$biz_debug", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "tapBubbleFlow", "getTapBubbleFlow$biz_debug", "showedBubble", RoomRecommendViewModel.EMPTY_CURSOR, "emit", RoomRecommendViewModel.EMPTY_CURSOR, "data", "emit$biz_debug", "configureShowedBubble", "isShow", "configureShowedBubble$biz_debug", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextLinkNodeService {
    public static final int $stable = 8;
    private final CoroutineScope scope;
    private boolean showedBubble;
    private final MutableSharedFlow<LinkNodeData> tapBubbleFlow;
    private final MutableSharedFlow<LinkNodeData> tapTextFlow;

    @Inject
    public DeepSearchTextLinkNodeService(@DeepSearchCoroutineScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.tapTextFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.tapBubbleFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final MutableSharedFlow<LinkNodeData> getTapTextFlow$biz_debug() {
        return this.tapTextFlow;
    }

    public final MutableSharedFlow<LinkNodeData> getTapBubbleFlow$biz_debug() {
        return this.tapBubbleFlow;
    }

    public final void emit$biz_debug(LinkNodeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        KLinkNode linkNode = data.getLinkNode();
        if ((linkNode != null ? linkNode.getLinkClickBubble() : null) != null) {
            if (this.showedBubble) {
                return;
            }
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DeepSearchTextLinkNodeService$emit$1(this, data, null), 3, (Object) null);
            return;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DeepSearchTextLinkNodeService$emit$2(this, data, null), 3, (Object) null);
    }

    public final void configureShowedBubble$biz_debug(boolean isShow) {
        this.showedBubble = isShow;
    }
}