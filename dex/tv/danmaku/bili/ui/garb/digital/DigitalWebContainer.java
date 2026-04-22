package tv.danmaku.bili.ui.garb.digital;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.DigitalJsCallHandler;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.digital.base.view.OnCancelClickListener;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCPurchaseModel;
import tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView;
import tv.danmaku.bili.ui.garb.nft.view.DLCCardHalfScreenDetailView;
import tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardViewManager;
import tv.danmaku.bili.ui.garb.nft.view.DrawCardActionWrapper;

/* compiled from: DigitalWebContainer.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0015\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eJb\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020,J8\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u00010\u001e2\b\u00102\u001a\u0004\u0018\u00010\u001e2\b\u00103\u001a\u0004\u0018\u00010\u001e2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u0003J\u0006\u00107\u001a\u00020 J\b\u00108\u001a\u0004\u0018\u00010\u001eJ\b\u00109\u001a\u0004\u0018\u00010\u001eJ\b\u0010:\u001a\u0004\u0018\u00010\u001eJ \u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020,2\b\u0010$\u001a\u0004\u0018\u00010>R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalWebContainer;", "", "mFragment", "Landroidx/fragment/app/Fragment;", "mDigitalJsHandler", "Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "<init>", "(Landroidx/fragment/app/Fragment;Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "getMDigitalJsHandler", "()Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "setMDigitalJsHandler", "(Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "mDetailView", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "mDrawCardViewManager", "Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardViewManager;", "onCancelClickListener", "tv/danmaku/bili/ui/garb/digital/DigitalWebContainer$onCancelClickListener$1", "Ltv/danmaku/bili/ui/garb/digital/DigitalWebContainer$onCancelClickListener$1;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "getView", "Landroid/view/View;", "isHalfScreen", "", "root", "Landroid/view/ViewGroup;", "initViews", "", "initData", "fromType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "data", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "cardTypeList", "", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "jumpToIndex", "", "isFullScreen", "isMultiView", "materialType", "initDrawCardData", "multiViewContainer", "floatBottomContainer", "drawCardContainer", "drawCardModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "fragment", "destroy", "getMultiViewContainer", "getBottomFloatContainer", "getDrawCardContainer", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalWebContainer {
    public static final int $stable = 8;
    private DigitalCardDetailBaseView mDetailView;
    private DigitalJsCallHandler mDigitalJsHandler;
    private DLCDrawCardViewManager mDrawCardViewManager;
    private Fragment mFragment;
    private final DigitalWebContainer$onCancelClickListener$1 onCancelClickListener;
    private final DigitalCardPlayerManager playerManager;

    public DigitalWebContainer() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$onCancelClickListener$1] */
    public DigitalWebContainer(Fragment mFragment, DigitalJsCallHandler mDigitalJsHandler) {
        Context activity;
        this.mFragment = mFragment;
        this.mDigitalJsHandler = mDigitalJsHandler;
        this.onCancelClickListener = new OnCancelClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$onCancelClickListener$1
            @Override // tv.danmaku.bili.ui.garb.digital.base.view.OnCancelClickListener
            public void onCancelClick() {
                DigitalJsCallHandler mDigitalJsHandler2 = DigitalWebContainer.this.getMDigitalJsHandler();
                if (mDigitalJsHandler2 != null) {
                    mDigitalJsHandler2.toDismiss();
                }
            }
        };
        this.playerManager = DigitalCardPlayerManager.Companion.buildManager$default(DigitalCardPlayerManager.Companion, this.mFragment, (FragmentActivity) null, true, 2, (Object) null);
        Fragment fragment = this.mFragment;
        if (fragment == null || (activity = fragment.getActivity()) == null) {
            return;
        }
        this.mDrawCardViewManager = new DLCDrawCardViewManager(activity);
    }

    public /* synthetic */ DigitalWebContainer(Fragment fragment, DigitalJsCallHandler digitalJsCallHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fragment, (i & 2) != 0 ? null : digitalJsCallHandler);
    }

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final void setMFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public final DigitalJsCallHandler getMDigitalJsHandler() {
        return this.mDigitalJsHandler;
    }

    public final void setMDigitalJsHandler(DigitalJsCallHandler digitalJsCallHandler) {
        this.mDigitalJsHandler = digitalJsCallHandler;
    }

    public final View getView(boolean isHalfScreen, ViewGroup root) {
        Activity activity;
        Intrinsics.checkNotNullParameter(root, "root");
        Fragment fragment = this.mFragment;
        if (fragment == null || (activity = fragment.getActivity()) == null) {
            return null;
        }
        this.mDetailView = isHalfScreen ? new DLCCardHalfScreenDetailView(activity, this.mFragment, this.mDigitalJsHandler, this.onCancelClickListener, this.playerManager) : new DLCCardDetailView(activity, this.mFragment, this.mDigitalJsHandler, this.onCancelClickListener, this.playerManager);
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            int resId = digitalCardDetailBaseView.resId();
            return LayoutInflater.from(activity).inflate(resId, root, true);
        }
        return null;
    }

    public final void initViews(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            digitalCardDetailBaseView.initViews(root);
        }
    }

    public final void initData(ViewGroup root, DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, List<? extends DigitalCardDetailRenderData> list, int jumpToIndex, boolean isFullScreen, boolean isMultiView, int materialType) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            digitalCardDetailBaseView.initData(root, fromType, data, routerInfo, list, jumpToIndex, isFullScreen, isMultiView, materialType);
        }
    }

    public final void initDrawCardData(ViewGroup multiViewContainer, ViewGroup floatBottomContainer, ViewGroup drawCardContainer, final DLCCardDrawModel drawCardModel, Fragment fragment) {
        DLCDrawCardViewManager dLCDrawCardViewManager = this.mDrawCardViewManager;
        if (dLCDrawCardViewManager != null) {
            DrawCardActionWrapper $this$initDrawCardData_u24lambda_u240 = new DrawCardActionWrapper(null, null, null, null, null, 31, null);
            $this$initDrawCardData_u24lambda_u240.setDrawAgain(new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit initDrawCardData$lambda$0$0;
                    initDrawCardData$lambda$0$0 = DigitalWebContainer.initDrawCardData$lambda$0$0(DigitalWebContainer.this);
                    return initDrawCardData$lambda$0$0;
                }
            });
            $this$initDrawCardData_u24lambda_u240.setSwitchToResult(new Function3() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit initDrawCardData$lambda$0$1;
                    initDrawCardData$lambda$0$1 = DigitalWebContainer.initDrawCardData$lambda$0$1(DigitalWebContainer.this, (DLCCardShareModel) obj, (DLCItem) obj2, ((Boolean) obj3).booleanValue());
                    return initDrawCardData$lambda$0$1;
                }
            });
            $this$initDrawCardData_u24lambda_u240.setGoGraphic(new Function1() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit initDrawCardData$lambda$0$2;
                    initDrawCardData$lambda$0$2 = DigitalWebContainer.initDrawCardData$lambda$0$2(DigitalWebContainer.this, (String) obj);
                    return initDrawCardData$lambda$0$2;
                }
            });
            $this$initDrawCardData_u24lambda_u240.setGoBack(new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit initDrawCardData$lambda$0$3;
                    initDrawCardData$lambda$0$3 = DigitalWebContainer.initDrawCardData$lambda$0$3(DigitalWebContainer.this);
                    return initDrawCardData$lambda$0$3;
                }
            });
            $this$initDrawCardData_u24lambda_u240.setPurchase(new Function1() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalWebContainer$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit initDrawCardData$lambda$0$4;
                    initDrawCardData$lambda$0$4 = DigitalWebContainer.initDrawCardData$lambda$0$4(DigitalWebContainer.this, drawCardModel, ((Integer) obj).intValue());
                    return initDrawCardData$lambda$0$4;
                }
            });
            Unit unit = Unit.INSTANCE;
            dLCDrawCardViewManager.initData(multiViewContainer, floatBottomContainer, drawCardContainer, drawCardModel, $this$initDrawCardData_u24lambda_u240, fragment != null ? fragment.getLifecycle() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDrawCardData$lambda$0$0(DigitalWebContainer this$0) {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this$0.mDetailView;
        if (digitalCardDetailBaseView != null) {
            digitalCardDetailBaseView.hideVideoView();
        }
        DigitalCardDetailBaseView digitalCardDetailBaseView2 = this$0.mDetailView;
        if (digitalCardDetailBaseView2 != null) {
            digitalCardDetailBaseView2.hideImage();
        }
        DigitalCardDetailBaseView digitalCardDetailBaseView3 = this$0.mDetailView;
        if (digitalCardDetailBaseView3 != null) {
            digitalCardDetailBaseView3.hideSingleView();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDrawCardData$lambda$0$1(DigitalWebContainer this$0, DLCCardShareModel shareModel, DLCItem dlcItem, boolean hasSmeltingTutorial) {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this$0.mDetailView;
        if (digitalCardDetailBaseView != null) {
            digitalCardDetailBaseView.setShareData(DigitalFromType.DRAW, shareModel);
        }
        DigitalCardDetailBaseView digitalCardDetailBaseView2 = this$0.mDetailView;
        if (digitalCardDetailBaseView2 != null) {
            digitalCardDetailBaseView2.renderUI(shareModel, dlcItem);
        }
        DigitalCardDetailBaseView digitalCardDetailBaseView3 = this$0.mDetailView;
        if (digitalCardDetailBaseView3 != null) {
            digitalCardDetailBaseView3.setSmeltingTutorialBtnVisible(hasSmeltingTutorial);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDrawCardData$lambda$0$2(DigitalWebContainer this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DigitalJsCallHandler digitalJsCallHandler = this$0.mDigitalJsHandler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.toDismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDrawCardData$lambda$0$3(DigitalWebContainer this$0) {
        DigitalJsCallHandler digitalJsCallHandler = this$0.mDigitalJsHandler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.toDismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDrawCardData$lambda$0$4(DigitalWebContainer this$0, DLCCardDrawModel $drawCardModel, int num) {
        DigitalJsCallHandler digitalJsCallHandler = this$0.mDigitalJsHandler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.purchaseCardPkg(new DLCPurchaseModel($drawCardModel != null ? $drawCardModel.getLotteryId() : 0L, num));
        }
        return Unit.INSTANCE;
    }

    public final void destroy() {
        DLCDrawCardViewManager dLCDrawCardViewManager = this.mDrawCardViewManager;
        if (dLCDrawCardViewManager != null) {
            dLCDrawCardViewManager.destroy();
        }
        this.mDrawCardViewManager = null;
    }

    public final ViewGroup getMultiViewContainer() {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            return digitalCardDetailBaseView.getMultiViewContainer();
        }
        return null;
    }

    public final ViewGroup getBottomFloatContainer() {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            return digitalCardDetailBaseView.getBottomFloatContainer();
        }
        return null;
    }

    public final ViewGroup getDrawCardContainer() {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            return digitalCardDetailBaseView.getDrawCardContainer();
        }
        return null;
    }

    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        DigitalCardDetailBaseView digitalCardDetailBaseView = this.mDetailView;
        if (digitalCardDetailBaseView != null) {
            digitalCardDetailBaseView.onActivityResult(requestCode, resultCode, data);
        }
    }
}