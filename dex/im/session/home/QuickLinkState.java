package im.session.home;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.matrix.report.Issue;
import com.yalantis.ucrop.view.CropImageView;
import im.session.IMActionDismissQuickLinkBubble;
import im.session.common.IMSessionEventHandler;
import im.session.common.IMSessionRouteHandler;
import im.session.log.LogTagKt;
import im.session.model.IMQuickLink;
import im.session.model.IMQuickLinkItem;
import java.util.Iterator;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a*\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019J\u000e\u0010!\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lim/session/home/QuickLinkState;", "", "quickLink", "Lim/session/model/IMQuickLink;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "<init>", "(Lim/session/model/IMQuickLink;Lim/session/common/IMSessionEventHandler;)V", "getQuickLink", "()Lim/session/model/IMQuickLink;", "getEventHandler", "()Lim/session/common/IMSessionEventHandler;", Issue.ISSUE_REPORT_TAG, "", "bubble", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "getBubble", "()Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "horizonPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizonPadding-D9Ej5fM", "()F", "F", "itemsMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;", "Landroidx/compose/ui/geometry/Rect;", "put", "", "itemType", "rect", "centerOfWithPadding", "Landroidx/compose/ui/unit/Density;", "onBubbleClick", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBubbleDismiss", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QuickLinkState {
    public static final int $stable = 0;
    private final IMSessionEventHandler eventHandler;
    private final float horizonPadding;
    private final SnapshotStateMap<KQuickLinkItemType, Rect> itemsMap;
    private final IMQuickLink quickLink;
    private final String tag;

    public QuickLinkState(IMQuickLink quickLink, IMSessionEventHandler eventHandler) {
        float f2;
        Intrinsics.checkNotNullParameter(quickLink, "quickLink");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.quickLink = quickLink;
        this.eventHandler = eventHandler;
        this.tag = LogTagKt.SessionLogTag("QuickLink-Bubble");
        if (this.quickLink.isLegacyStyle()) {
            int $this$dp$iv = this.quickLink.getItems().size() <= 4 ? 16 : 8;
            f2 = Dp.constructor-impl($this$dp$iv);
        } else {
            f2 = this.quickLink.getItems().size() <= 3 ? Dp.constructor-impl(32) : Dp.constructor-impl(16);
        }
        this.horizonPadding = f2;
        this.itemsMap = SnapshotStateKt.mutableStateMapOf();
    }

    public final IMQuickLink getQuickLink() {
        return this.quickLink;
    }

    public final IMSessionEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public final KQuickLinkBubble getBubble() {
        return this.quickLink.getBubble();
    }

    /* renamed from: getHorizonPadding-D9Ej5fM  reason: not valid java name */
    public final float m3320getHorizonPaddingD9Ej5fM() {
        return this.horizonPadding;
    }

    public final void put(KQuickLinkItemType itemType, Rect rect) {
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.itemsMap.put(itemType, rect);
    }

    public final Rect centerOfWithPadding(Density $this$centerOfWithPadding, KQuickLinkItemType itemType) {
        Intrinsics.checkNotNullParameter($this$centerOfWithPadding, "<this>");
        Rect rect = (Rect) this.itemsMap.get(itemType);
        if (rect != null) {
            return rect.translate($this$centerOfWithPadding.toPx-0680j_4(this.horizonPadding), (float) CropImageView.DEFAULT_ASPECT_RATIO);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onBubbleClick(Continuation<? super Unit> continuation) {
        QuickLinkState$onBubbleClick$1 quickLinkState$onBubbleClick$1;
        KQuickLinkBubble bubble;
        IMQuickLinkItem iMQuickLinkItem;
        IMQuickLinkItem item;
        if (continuation instanceof QuickLinkState$onBubbleClick$1) {
            quickLinkState$onBubbleClick$1 = (QuickLinkState$onBubbleClick$1) continuation;
            if ((quickLinkState$onBubbleClick$1.label & Integer.MIN_VALUE) != 0) {
                quickLinkState$onBubbleClick$1.label -= Integer.MIN_VALUE;
                Object $result = quickLinkState$onBubbleClick$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (quickLinkState$onBubbleClick$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i(this.tag, "onBubbleClick on bubble item " + (getBubble() != null ? bubble.getQuickLinkItem() : null));
                        Iterator<T> it = this.quickLink.getItems().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                IMQuickLinkItem it2 = (IMQuickLinkItem) next;
                                KQuickLinkItemType type = it2.getType();
                                KQuickLinkBubble bubble2 = getBubble();
                                iMQuickLinkItem = Intrinsics.areEqual(type, bubble2 != null ? bubble2.getQuickLinkItem() : null) ? next : null;
                            }
                        }
                        IMQuickLinkItem item2 = iMQuickLinkItem;
                        KLog_androidKt.getKLog().i(this.tag, "Related quick link item exists " + (item2 != null));
                        if (item2 != null) {
                            KLog_androidKt.getKLog().i(this.tag, "Routing to " + item2.getUrl());
                            IMSessionRouteHandler routeHandler = this.eventHandler.getRouteHandler();
                            Uri parse = Uri.Companion.parse(item2.getUrl());
                            quickLinkState$onBubbleClick$1.L$0 = SpillingKt.nullOutSpilledVariable(item2);
                            quickLinkState$onBubbleClick$1.label = 1;
                            if (routeHandler.invoke(parse, quickLinkState$onBubbleClick$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            item = item2;
                            break;
                        }
                        break;
                    case 1:
                        item = (IMQuickLinkItem) quickLinkState$onBubbleClick$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.eventHandler.getActionHandler().invoke(IMActionDismissQuickLinkBubble.INSTANCE);
                return Unit.INSTANCE;
            }
        }
        quickLinkState$onBubbleClick$1 = new QuickLinkState$onBubbleClick$1(this, continuation);
        Object $result2 = quickLinkState$onBubbleClick$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (quickLinkState$onBubbleClick$1.label) {
        }
        this.eventHandler.getActionHandler().invoke(IMActionDismissQuickLinkBubble.INSTANCE);
        return Unit.INSTANCE;
    }

    public final void onBubbleDismiss() {
        this.eventHandler.getActionHandler().invoke(IMActionDismissQuickLinkBubble.INSTANCE);
    }
}