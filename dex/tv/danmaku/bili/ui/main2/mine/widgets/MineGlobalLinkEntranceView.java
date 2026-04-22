package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bilibili.lib.projection.ProjectionClient;
import com.bilibili.lib.projection.internal.projectionitem.base.IProjectionItem;
import com.bilibili.lib.projection.internal.projectionitem.base.IProjectionPlayableItem;
import com.bilibili.lib.projection.selector.ProjectionSelectorContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: MineGlobalLinkEntranceView.kt */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003*\u0001\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0015\u001a\u00020\u0012R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/MineGlobalLinkEntranceView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mProjectionClient", "Lcom/bilibili/lib/projection/ProjectionClient;", "mMineLink", "Landroid/view/View;", "mMineLinkSelected", "init", "", "setProjectionClient", "client", "clearProjectionCallback", "mProjectionCallback", "tv/danmaku/bili/ui/main2/mine/widgets/MineGlobalLinkEntranceView$mProjectionCallback$1", "Ltv/danmaku/bili/ui/main2/mine/widgets/MineGlobalLinkEntranceView$mProjectionCallback$1;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGlobalLinkEntranceView extends FrameLayout {
    public static final int $stable = 8;
    private View mMineLink;
    private View mMineLinkSelected;
    private final MineGlobalLinkEntranceView$mProjectionCallback$1 mProjectionCallback;
    private ProjectionClient mProjectionClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1] */
    public MineGlobalLinkEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mProjectionCallback = new ProjectionClient.ClientCallback() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1
            public /* synthetic */ void onDanmakuVisibleChanged(boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onDanmakuVisibleChanged(this, z);
            }

            public /* synthetic */ void onItemChange(IProjectionItem iProjectionItem, int i, boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onItemChange(this, iProjectionItem, i, z);
            }

            public /* synthetic */ void onPanelShow(boolean z, boolean z2, ProjectionClient.ClientPanel clientPanel) {
                ProjectionClient.ClientCallback.-CC.$default$onPanelShow(this, z, z2, clientPanel);
            }

            public /* synthetic */ void onProjectionBackPressed() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionBackPressed(this);
            }

            public /* synthetic */ void onProjectionCompleted(IProjectionPlayableItem iProjectionPlayableItem, int i) {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionCompleted(this, iProjectionPlayableItem, i);
            }

            public /* synthetic */ void onProjectionEnd() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionEnd(this);
            }

            public /* synthetic */ void onProjectionStart() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionStart(this);
            }

            public /* synthetic */ void onResolveFailed(Throwable th) {
                ProjectionClient.ClientCallback.-CC.$default$onResolveFailed(this, th);
            }

            public /* synthetic */ void onShowSearchFragment(boolean z, boolean z2) {
                ProjectionClient.ClientCallback.-CC.$default$onShowSearchFragment(this, z, z2);
            }

            public /* synthetic */ ProjectionSelectorContainer onShowSelector() {
                return ProjectionClient.ClientCallback.-CC.$default$onShowSelector(this);
            }

            public /* synthetic */ void updateTopBarState(ProjectionClient.ClientCallback.TopBarState topBarState) {
                ProjectionClient.ClientCallback.-CC.$default$updateTopBarState(this, topBarState);
            }

            public void onEnableGlobalMode(boolean enable) {
                View view;
                View view2;
                View view3;
                View view4;
                if (enable) {
                    view3 = MineGlobalLinkEntranceView.this.mMineLink;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    view4 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                    if (view4 != null) {
                        view4.setVisibility(0);
                        return;
                    }
                    return;
                }
                view = MineGlobalLinkEntranceView.this.mMineLink;
                if (view != null) {
                    view.setVisibility(0);
                }
                view2 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1] */
    public MineGlobalLinkEntranceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mProjectionCallback = new ProjectionClient.ClientCallback() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1
            public /* synthetic */ void onDanmakuVisibleChanged(boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onDanmakuVisibleChanged(this, z);
            }

            public /* synthetic */ void onItemChange(IProjectionItem iProjectionItem, int i, boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onItemChange(this, iProjectionItem, i, z);
            }

            public /* synthetic */ void onPanelShow(boolean z, boolean z2, ProjectionClient.ClientPanel clientPanel) {
                ProjectionClient.ClientCallback.-CC.$default$onPanelShow(this, z, z2, clientPanel);
            }

            public /* synthetic */ void onProjectionBackPressed() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionBackPressed(this);
            }

            public /* synthetic */ void onProjectionCompleted(IProjectionPlayableItem iProjectionPlayableItem, int i) {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionCompleted(this, iProjectionPlayableItem, i);
            }

            public /* synthetic */ void onProjectionEnd() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionEnd(this);
            }

            public /* synthetic */ void onProjectionStart() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionStart(this);
            }

            public /* synthetic */ void onResolveFailed(Throwable th) {
                ProjectionClient.ClientCallback.-CC.$default$onResolveFailed(this, th);
            }

            public /* synthetic */ void onShowSearchFragment(boolean z, boolean z2) {
                ProjectionClient.ClientCallback.-CC.$default$onShowSearchFragment(this, z, z2);
            }

            public /* synthetic */ ProjectionSelectorContainer onShowSelector() {
                return ProjectionClient.ClientCallback.-CC.$default$onShowSelector(this);
            }

            public /* synthetic */ void updateTopBarState(ProjectionClient.ClientCallback.TopBarState topBarState) {
                ProjectionClient.ClientCallback.-CC.$default$updateTopBarState(this, topBarState);
            }

            public void onEnableGlobalMode(boolean enable) {
                View view;
                View view2;
                View view3;
                View view4;
                if (enable) {
                    view3 = MineGlobalLinkEntranceView.this.mMineLink;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    view4 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                    if (view4 != null) {
                        view4.setVisibility(0);
                        return;
                    }
                    return;
                }
                view = MineGlobalLinkEntranceView.this.mMineLink;
                if (view != null) {
                    view.setVisibility(0);
                }
                view2 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1] */
    public MineGlobalLinkEntranceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mProjectionCallback = new ProjectionClient.ClientCallback() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView$mProjectionCallback$1
            public /* synthetic */ void onDanmakuVisibleChanged(boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onDanmakuVisibleChanged(this, z);
            }

            public /* synthetic */ void onItemChange(IProjectionItem iProjectionItem, int i, boolean z) {
                ProjectionClient.ClientCallback.-CC.$default$onItemChange(this, iProjectionItem, i, z);
            }

            public /* synthetic */ void onPanelShow(boolean z, boolean z2, ProjectionClient.ClientPanel clientPanel) {
                ProjectionClient.ClientCallback.-CC.$default$onPanelShow(this, z, z2, clientPanel);
            }

            public /* synthetic */ void onProjectionBackPressed() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionBackPressed(this);
            }

            public /* synthetic */ void onProjectionCompleted(IProjectionPlayableItem iProjectionPlayableItem, int i) {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionCompleted(this, iProjectionPlayableItem, i);
            }

            public /* synthetic */ void onProjectionEnd() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionEnd(this);
            }

            public /* synthetic */ void onProjectionStart() {
                ProjectionClient.ClientCallback.-CC.$default$onProjectionStart(this);
            }

            public /* synthetic */ void onResolveFailed(Throwable th) {
                ProjectionClient.ClientCallback.-CC.$default$onResolveFailed(this, th);
            }

            public /* synthetic */ void onShowSearchFragment(boolean z, boolean z2) {
                ProjectionClient.ClientCallback.-CC.$default$onShowSearchFragment(this, z, z2);
            }

            public /* synthetic */ ProjectionSelectorContainer onShowSelector() {
                return ProjectionClient.ClientCallback.-CC.$default$onShowSelector(this);
            }

            public /* synthetic */ void updateTopBarState(ProjectionClient.ClientCallback.TopBarState topBarState) {
                ProjectionClient.ClientCallback.-CC.$default$updateTopBarState(this, topBarState);
            }

            public void onEnableGlobalMode(boolean enable) {
                View view;
                View view2;
                View view3;
                View view4;
                if (enable) {
                    view3 = MineGlobalLinkEntranceView.this.mMineLink;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    view4 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                    if (view4 != null) {
                        view4.setVisibility(0);
                        return;
                    }
                    return;
                }
                view = MineGlobalLinkEntranceView.this.mMineLink;
                if (view != null) {
                    view.setVisibility(0);
                }
                view2 = MineGlobalLinkEntranceView.this.mMineLinkSelected;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        };
        init();
    }

    private final void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bili_layout_globallink_entrance, (ViewGroup) this, false);
        addView(view);
        this.mMineLink = view.findViewById(R.id.mine_link_normal);
        this.mMineLinkSelected = view.findViewById(R.id.mine_link_selected);
    }

    public final void setProjectionClient(ProjectionClient client) {
        this.mProjectionClient = client;
        ProjectionClient projectionClient = this.mProjectionClient;
        if (projectionClient != null) {
            projectionClient.setCallback(this.mProjectionCallback);
        }
    }

    public final void clearProjectionCallback() {
        ProjectionClient projectionClient = this.mProjectionClient;
        if (projectionClient != null) {
            projectionClient.setCallback(ProjectionClient.ClientCallback.DEFAULT);
        }
    }
}