package tv.danmaku.bili.ui.garb.nft.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.DigitalJsCallHandler;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.digital.base.view.OnCancelClickListener;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;

/* compiled from: DLCCardHalfScreenDetailView.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014JI\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u00102JI\u00103\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u00102J:\u00104\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0014J\b\u00105\u001a\u000200H\u0016J\u001c\u00106\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00107\u001a\u00020!H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCCardHalfScreenDetailView;", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "context", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "handler", "Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "onCancelClickListener", "Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;Lcom/bili/digital/common/player/DigitalCardPlayerManager;)V", "getContext", "()Landroid/app/Activity;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getHandler", "()Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "setHandler", "(Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "mFloatBottomContainer", "Landroid/view/View;", "shareType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "shareModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "getShareModel", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "setShareModel", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;)V", "initTopContainer", "", "container", "Landroid/view/ViewGroup;", "initBottomContainer", "initBottomFloatContainer", "renderTopContainerUI", "fromType", "data", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "isFullScreen", "", "isMultiView", "materialType", "", "fromItemChanged", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;ZZILjava/lang/Boolean;)V", "renderBottomContainerUI", "renderBottomFloatContainerUI", "resId", "setShareData", "closeContainer", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardHalfScreenDetailView extends DigitalCardDetailBaseView {
    public static final int $stable = 8;
    private final Activity context;
    private final Fragment fragment;
    private DigitalJsCallHandler handler;
    private View mFloatBottomContainer;
    private final OnCancelClickListener onCancelClickListener;
    private final DigitalCardPlayerManager playerManager;
    private DLCCardShareModel shareModel;
    private DigitalFromType shareType;

    /* compiled from: DLCCardHalfScreenDetailView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DigitalFromType.values().length];
            try {
                iArr[DigitalFromType.SEE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DigitalFromType.TASK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DigitalFromType.SCAN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DigitalFromType.RESULT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DigitalFromType.DRAW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCCardHalfScreenDetailView(Activity context, Fragment fragment, DigitalJsCallHandler handler, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager playerManager) {
        super(context, fragment, onCancelClickListener, playerManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onCancelClickListener, "onCancelClickListener");
        Intrinsics.checkNotNullParameter(playerManager, "playerManager");
        this.context = context;
        this.fragment = fragment;
        this.handler = handler;
        this.onCancelClickListener = onCancelClickListener;
        this.playerManager = playerManager;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DLCCardHalfScreenDetailView(Activity activity, Fragment fragment, DigitalJsCallHandler digitalJsCallHandler, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager digitalCardPlayerManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, r2, digitalJsCallHandler, onCancelClickListener, digitalCardPlayerManager);
        Fragment fragment2;
        if ((i & 2) == 0) {
            fragment2 = fragment;
        } else {
            fragment2 = null;
        }
    }

    public final Activity getContext() {
        return this.context;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final DigitalJsCallHandler getHandler() {
        return this.handler;
    }

    public final void setHandler(DigitalJsCallHandler digitalJsCallHandler) {
        this.handler = digitalJsCallHandler;
    }

    public final DLCCardShareModel getShareModel() {
        return this.shareModel;
    }

    public final void setShareModel(DLCCardShareModel dLCCardShareModel) {
        this.shareModel = dLCCardShareModel;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initTopContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initBottomContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    protected void initBottomFloatContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mFloatBottomContainer = container;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void renderTopContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType, Boolean fromItemChanged) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void renderBottomContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType, Boolean fromItemChanged) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    protected void renderBottomFloatContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
        switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                View view = this.mFloatBottomContainer;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            case 4:
                View view2 = this.mFloatBottomContainer;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            case 5:
                View view3 = this.mFloatBottomContainer;
                if (view3 != null) {
                    view3.setVisibility(8);
                    return;
                }
                return;
            default:
                View view4 = this.mFloatBottomContainer;
                if (view4 != null) {
                    view4.setVisibility(8);
                    return;
                }
                return;
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public int resId() {
        return R.layout.bili_app_dialog_digital_half_screen_detail_view;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void setShareData(DigitalFromType shareType, DLCCardShareModel shareModel) {
        this.shareType = shareType;
        this.shareModel = shareModel;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    protected void closeContainer() {
        DigitalJsCallHandler digitalJsCallHandler = this.handler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.toDismiss();
        }
    }
}