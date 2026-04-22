package tv.danmaku.bili.ui.garb.digital;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bilibili.app.authorspace.SpaceReportHelper;
import com.bilibili.app.authorspace.ui.nft.utils.ImageLoadCallback;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarChooser;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarUploader;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.api.NftReporterHelper;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.digital.module.CheckAvatarTextKt;

/* compiled from: DigitalCardDetailPreviewView.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u0000 92\u00020\u0001:\u00019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016JI\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010.JI\u0010/\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010.J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J1\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014¢\u0006\u0002\u00104J\u0014\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106H\u0002J\u0012\u00108\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000106H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailPreviewView;", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", AudioIntentHelper.FROM_ACTIVITY, "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "uploadCallback", "Lcom/bilibili/app/comm/list/avatarcommon/changeavatar/AvatarUploader$UploadCallback;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "<init>", "(Lcom/bilibili/lib/ui/BaseAppCompatActivity;Lcom/bilibili/app/comm/list/avatarcommon/changeavatar/AvatarUploader$UploadCallback;Lcom/bili/digital/common/player/DigitalCardPlayerManager;)V", "getActivity", "()Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "mCloseBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "mLinkTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "mLinkArrowView", "Landroid/view/View;", "mActivityIcon", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mActivityText", "mActivityArrow", "mChangeAvatarView", "mChangePendantView", "mTopContainer", "mBottomContainer", "isAvatar", "", "isMe", "initTopContainer", "", "container", "Landroid/view/ViewGroup;", "initBottomContainer", "renderTopContainerUI", "fromType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "data", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "isFullScreen", "isMultiView", "materialType", "", "fromItemChanged", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;ZZILjava/lang/Boolean;)V", "renderBottomContainerUI", "reportClickLink", "reportClickActivity", "registerButtonListener", "type", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;Ljava/lang/Integer;)V", "appendParam", "", "url", "goRouterPage", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class DigitalCardDetailPreviewView extends DigitalCardDetailBaseView {
    public static final int AVATAR = 1;
    public static final int HEADER = 2;
    private final BaseAppCompatActivity activity;
    private boolean isAvatar;
    private boolean isMe;
    private AppCompatImageView mActivityArrow;
    private BiliImageView mActivityIcon;
    private AppCompatTextView mActivityText;
    private View mBottomContainer;
    private AppCompatTextView mChangeAvatarView;
    private AppCompatTextView mChangePendantView;
    private AppCompatImageView mCloseBtn;
    private View mLinkArrowView;
    private AppCompatTextView mLinkTextView;
    private View mTopContainer;
    private final AvatarUploader.UploadCallback uploadCallback;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DigitalCardDetailPreviewView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AvatarChooser.PhotoSource.values().length];
            try {
                iArr[AvatarChooser.PhotoSource.NFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AvatarChooser.PhotoSource.CHOOSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AvatarChooser.PhotoSource.APHRO_CHOOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AvatarChooser.PhotoSource.TAKE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AvatarChooser.PhotoSource.TAKE_AND_CROP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AvatarChooser.PhotoSource.RANDOM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalCardDetailPreviewView(BaseAppCompatActivity activity, AvatarUploader.UploadCallback uploadCallback, DigitalCardPlayerManager playerManager) {
        super((Context) activity, null, null, playerManager, 6, null);
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(playerManager, "playerManager");
        this.activity = activity;
        this.uploadCallback = uploadCallback;
        this.isMe = true;
    }

    protected final BaseAppCompatActivity getActivity() {
        return this.activity;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initTopContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View view = null;
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.bili_app_dialog_digital_card_top, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mTopContainer = inflate;
        View view2 = this.mTopContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view2 = null;
        }
        AppCompatImageView findViewById = view2.findViewById(R.id.nft_card_bottom_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCloseBtn = findViewById;
        View view3 = this.mTopContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view3 = null;
        }
        AppCompatTextView findViewById2 = view3.findViewById(R.id.nft_card_top_link);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mLinkTextView = findViewById2;
        View view4 = this.mTopContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.nft_card_top_link_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mLinkArrowView = findViewById3;
        View view5 = this.mTopContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
        } else {
            view = view5;
        }
        container.addView(view);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initBottomContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.bili_app_dialog_digital_card_bottom, container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mBottomContainer = inflate;
        View view = this.mBottomContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view = null;
        }
        BiliImageView findViewById = view.findViewById(R.id.digital_activity_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mActivityIcon = findViewById;
        View view3 = this.mBottomContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view3 = null;
        }
        AppCompatTextView findViewById2 = view3.findViewById(R.id.digital_activity_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mActivityText = findViewById2;
        View view4 = this.mBottomContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view4 = null;
        }
        AppCompatImageView findViewById3 = view4.findViewById(R.id.digital_activity_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mActivityArrow = findViewById3;
        View view5 = this.mBottomContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view5 = null;
        }
        AppCompatTextView findViewById4 = view5.findViewById(R.id.digital_change_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mChangeAvatarView = findViewById4;
        View view6 = this.mBottomContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view6 = null;
        }
        AppCompatTextView findViewById5 = view6.findViewById(R.id.digital_change_pendant);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mChangePendantView = findViewById5;
        View view7 = this.mBottomContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
        } else {
            view2 = view7;
        }
        view2.setVisibility(8);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void renderTopContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType, Boolean fromItemChanged) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
        String it = data.getLinkText();
        if (it != null) {
            AppCompatTextView appCompatTextView = this.mLinkTextView;
            View view = null;
            if (appCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLinkTextView");
                appCompatTextView = null;
            }
            appCompatTextView.setText(it);
            AppCompatTextView appCompatTextView2 = this.mLinkTextView;
            if (appCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLinkTextView");
                appCompatTextView2 = null;
            }
            appCompatTextView2.setVisibility(0);
            View view2 = this.mLinkArrowView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLinkArrowView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void renderBottomContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, final DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType, Boolean fromItemChanged) {
        BiliImageView biliImageView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        BiliImageView biliImageView2;
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.mBottomContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            view = null;
        }
        view.findViewById(R.id.checkAvatar).setVisibility(8);
        this.isMe = routerInfo != null ? routerInfo.isMe() : true;
        if (routerInfo != null) {
            int useScene = routerInfo.getUseScene();
            switch (useScene) {
                case 1:
                    this.isAvatar = true;
                    View view2 = this.mBottomContainer;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
                        view2 = null;
                    }
                    view2.setVisibility(0);
                    if (routerInfo.isMe()) {
                        AppCompatTextView appCompatTextView3 = this.mActivityText;
                        if (appCompatTextView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
                            appCompatTextView3 = null;
                        }
                        appCompatTextView3.setVisibility(8);
                        BiliImageView biliImageView3 = this.mActivityIcon;
                        if (biliImageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityIcon");
                            biliImageView3 = null;
                        }
                        biliImageView3.setVisibility(8);
                        AppCompatImageView appCompatImageView = this.mActivityArrow;
                        if (appCompatImageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityArrow");
                            appCompatImageView = null;
                        }
                        appCompatImageView.setVisibility(8);
                        AppCompatTextView $this$renderBottomContainerUI_u24lambda_u240_u240 = this.mChangePendantView;
                        if ($this$renderBottomContainerUI_u24lambda_u240_u240 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mChangePendantView");
                            $this$renderBottomContainerUI_u24lambda_u240_u240 = null;
                        }
                        $this$renderBottomContainerUI_u24lambda_u240_u240.setVisibility(0);
                        HashMap generateParams = SpaceReportHelper.generateParams(routerInfo.getMid());
                        Intrinsics.checkNotNullExpressionValue(generateParams, "generateParams(...)");
                        Neurons.reportExposure$default(false, "main.space.floating-window-pendant.0.show", generateParams, (List) null, 8, (Object) null);
                        AppCompatTextView appCompatTextView4 = this.mChangeAvatarView;
                        if (appCompatTextView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mChangeAvatarView");
                            appCompatTextView = null;
                        } else {
                            appCompatTextView = appCompatTextView4;
                        }
                        appCompatTextView.setVisibility(0);
                        return;
                    }
                    AppCompatTextView appCompatTextView5 = this.mChangePendantView;
                    if (appCompatTextView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangePendantView");
                        appCompatTextView5 = null;
                    }
                    appCompatTextView5.setVisibility(8);
                    AppCompatTextView appCompatTextView6 = this.mChangeAvatarView;
                    if (appCompatTextView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangeAvatarView");
                        appCompatTextView6 = null;
                    }
                    appCompatTextView6.setVisibility(8);
                    String it = data.getActivityIcon();
                    if (it != null) {
                        SpaceNftUtils spaceNftUtils = SpaceNftUtils.INSTANCE;
                        BiliImageView biliImageView4 = this.mActivityIcon;
                        if (biliImageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityIcon");
                            biliImageView = null;
                        } else {
                            biliImageView = biliImageView4;
                        }
                        SpaceNftUtils.loadImage$default(spaceNftUtils, it, biliImageView, (ImageLoadCallback) null, false, 12, (Object) null);
                        BiliImageView biliImageView5 = this.mActivityIcon;
                        if (biliImageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityIcon");
                            biliImageView5 = null;
                        }
                        biliImageView5.setVisibility(0);
                        AppCompatImageView appCompatImageView2 = this.mActivityArrow;
                        if (appCompatImageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityArrow");
                            appCompatImageView2 = null;
                        }
                        appCompatImageView2.setVisibility(0);
                    }
                    String it2 = data.getActivityText();
                    if (it2 != null) {
                        AppCompatTextView appCompatTextView7 = this.mActivityText;
                        if (appCompatTextView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
                            appCompatTextView7 = null;
                        }
                        appCompatTextView7.setText(it2);
                        AppCompatTextView appCompatTextView8 = this.mActivityText;
                        if (appCompatTextView8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
                            appCompatTextView8 = null;
                        }
                        appCompatTextView8.setVisibility(0);
                    }
                    View view3 = this.mBottomContainer;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
                        view3 = null;
                    }
                    ComposeView $this$renderBottomContainerUI_u24lambda_u240_u243 = view3.findViewById(R.id.checkAvatar);
                    String pendantUrl = routerInfo.getPendantUrl();
                    if (!(pendantUrl == null || pendantUrl.length() == 0)) {
                        $this$renderBottomContainerUI_u24lambda_u240_u243.setVisibility(0);
                        $this$renderBottomContainerUI_u24lambda_u240_u243.setContent(ComposableLambdaKt.composableLambdaInstance(1084967607, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit renderBottomContainerUI$lambda$0$3$0;
                                renderBottomContainerUI$lambda$0$3$0 = DigitalCardDetailPreviewView.renderBottomContainerUI$lambda$0$3$0(DigitalCardDetailRouterInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                                return renderBottomContainerUI$lambda$0$3$0;
                            }
                        }));
                        return;
                    }
                    $this$renderBottomContainerUI_u24lambda_u240_u243.setVisibility(8);
                    return;
                case 2:
                    this.isAvatar = false;
                    View view4 = this.mBottomContainer;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
                        view4 = null;
                    }
                    view4.setVisibility(0);
                    AppCompatTextView appCompatTextView9 = this.mChangePendantView;
                    if (appCompatTextView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangePendantView");
                        appCompatTextView9 = null;
                    }
                    appCompatTextView9.setVisibility(8);
                    AppCompatTextView appCompatTextView10 = this.mChangeAvatarView;
                    if (appCompatTextView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangeAvatarView");
                        appCompatTextView10 = null;
                    }
                    appCompatTextView10.setVisibility(8);
                    String it3 = data.getActivityIcon();
                    if (it3 != null) {
                        SpaceNftUtils spaceNftUtils2 = SpaceNftUtils.INSTANCE;
                        BiliImageView biliImageView6 = this.mActivityIcon;
                        if (biliImageView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityIcon");
                            biliImageView2 = null;
                        } else {
                            biliImageView2 = biliImageView6;
                        }
                        SpaceNftUtils.loadImage$default(spaceNftUtils2, it3, biliImageView2, (ImageLoadCallback) null, false, 12, (Object) null);
                        BiliImageView biliImageView7 = this.mActivityIcon;
                        if (biliImageView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityIcon");
                            biliImageView7 = null;
                        }
                        biliImageView7.setVisibility(0);
                        AppCompatImageView appCompatImageView3 = this.mActivityArrow;
                        if (appCompatImageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityArrow");
                            appCompatImageView3 = null;
                        }
                        appCompatImageView3.setVisibility(0);
                    }
                    String it4 = data.getActivityText();
                    if (it4 != null) {
                        AppCompatTextView appCompatTextView11 = this.mActivityText;
                        if (appCompatTextView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
                            appCompatTextView11 = null;
                        }
                        appCompatTextView11.setText(it4);
                        AppCompatTextView appCompatTextView12 = this.mActivityText;
                        if (appCompatTextView12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
                            appCompatTextView2 = null;
                        } else {
                            appCompatTextView2 = appCompatTextView12;
                        }
                        appCompatTextView2.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderBottomContainerUI$lambda$0$3$0(final DigitalCardDetailRouterInfo $routerInfo, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C143@6644L233,143@6628L249:DigitalCardDetailPreviewView.kt#vavq9d");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1084967607, $changed, -1, "tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView.renderBottomContainerUI.<anonymous>.<anonymous>.<anonymous> (DigitalCardDetailPreviewView.kt:143)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1023180640, "CC(remember):DigitalCardDetailPreviewView.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($routerInfo);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit renderBottomContainerUI$lambda$0$3$0$0$0;
                        renderBottomContainerUI$lambda$0$3$0$0$0 = DigitalCardDetailPreviewView.renderBottomContainerUI$lambda$0$3$0$0$0(DigitalCardDetailRouterInfo.this);
                        return renderBottomContainerUI$lambda$0$3$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CheckAvatarTextKt.CheckAvatarText(null, (Function0) it$iv, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderBottomContainerUI$lambda$0$3$0$0$0(DigitalCardDetailRouterInfo $routerInfo) {
        RouteRequest it;
        String pendantUrl = $routerInfo.getPendantUrl();
        if (pendantUrl != null && (it = RouteRequestKt.toRouteRequest(pendantUrl)) != null) {
            BLRouter.routeTo$default(it, (Context) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private final void reportClickLink() {
        if (this.isMe) {
            if (this.isAvatar) {
                NftReporterHelper.INSTANCE.reportAvatarDetailClick(3);
            } else {
                NftReporterHelper.INSTANCE.reportHeaderDetailClick(2);
            }
        } else if (this.isAvatar) {
            NftReporterHelper.INSTANCE.reportGuestAvatarDetailClick(1);
        } else {
            NftReporterHelper.INSTANCE.reportHeaderDetailClick(2);
        }
    }

    private final void reportClickActivity() {
        if (this.isMe) {
            NftReporterHelper.INSTANCE.reportHeaderDetailClick(1);
        } else if (this.isAvatar) {
            NftReporterHelper.INSTANCE.reportGuestAvatarDetailClick(2);
        } else {
            NftReporterHelper.INSTANCE.reportHeaderDetailClick(1);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    protected void registerButtonListener(DigitalFromType type, final DigitalCardDetailContainerRenderData data, final DigitalCardDetailRouterInfo routerInfo, Integer materialType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView appCompatImageView = this.mCloseBtn;
        AppCompatTextView appCompatTextView = null;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$0(DigitalCardDetailPreviewView.this, view);
            }
        });
        AppCompatTextView appCompatTextView2 = this.mLinkTextView;
        if (appCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLinkTextView");
            appCompatTextView2 = null;
        }
        appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$1(DigitalCardDetailPreviewView.this, data, view);
            }
        });
        View view = this.mLinkArrowView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLinkArrowView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$2(DigitalCardDetailPreviewView.this, data, view2);
            }
        });
        AppCompatTextView appCompatTextView3 = this.mActivityText;
        if (appCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityText");
            appCompatTextView3 = null;
        }
        appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$3(DigitalCardDetailPreviewView.this, data, view2);
            }
        });
        AppCompatImageView appCompatImageView2 = this.mActivityArrow;
        if (appCompatImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityArrow");
            appCompatImageView2 = null;
        }
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$4(DigitalCardDetailPreviewView.this, data, view2);
            }
        });
        AppCompatTextView appCompatTextView4 = this.mChangeAvatarView;
        if (appCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeAvatarView");
            appCompatTextView4 = null;
        }
        appCompatTextView4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$5(DigitalCardDetailRouterInfo.this, this, view2);
            }
        });
        AppCompatTextView appCompatTextView5 = this.mChangePendantView;
        if (appCompatTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangePendantView");
        } else {
            appCompatTextView = appCompatTextView5;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$6(DigitalCardDetailRouterInfo.this, this, view2);
            }
        });
        super.registerButtonListener(type, data, routerInfo, materialType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$0(DigitalCardDetailPreviewView this$0, View it) {
        this$0.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$1(DigitalCardDetailPreviewView this$0, DigitalCardDetailContainerRenderData $data, View it) {
        this$0.goRouterPage($data.getLinkUrl());
        this$0.reportClickLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$2(DigitalCardDetailPreviewView this$0, DigitalCardDetailContainerRenderData $data, View it) {
        this$0.goRouterPage($data.getLinkUrl());
        this$0.reportClickLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$3(DigitalCardDetailPreviewView this$0, DigitalCardDetailContainerRenderData $data, View it) {
        this$0.goRouterPage(this$0.appendParam($data.getActivityUrl()));
        this$0.reportClickActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$4(DigitalCardDetailPreviewView this$0, DigitalCardDetailContainerRenderData $data, View it) {
        this$0.goRouterPage(this$0.appendParam($data.getActivityUrl()));
        this$0.reportClickActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$5(DigitalCardDetailRouterInfo $routerInfo, DigitalCardDetailPreviewView this$0, View it) {
        boolean z = false;
        boolean showDigital = $routerInfo != null ? $routerInfo.getShowDigital() : false;
        String digitalText = ($routerInfo == null || (r1 = $routerInfo.getDigitalText()) == null) ? "" : "";
        String digitalUrl = AvatarChooser.getKeyChangeNftAvatarUrl() + "/2";
        new AvatarChooser(this$0.activity, this$0.uploadCallback).showAll(showDigital, digitalText, digitalUrl, 1017, new AvatarChooser.OnItemClickListener() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailPreviewView$$ExternalSyntheticLambda9
            public final void onItemClick(AvatarChooser.PhotoSource photoSource) {
                DigitalCardDetailPreviewView.registerButtonListener$lambda$5$0(photoSource);
            }
        });
        if ($routerInfo != null && $routerInfo.isMe()) {
            z = true;
        }
        if (z && $routerInfo.getUseScene() == 1) {
            NftReporterHelper.INSTANCE.reportAvatarDetailClick(1);
            NftReporterHelper.INSTANCE.reportAvatarFloatPanelShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$5$0(AvatarChooser.PhotoSource it) {
        int buttonType;
        switch (it == null ? -1 : WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
            case 1:
                buttonType = 1;
                break;
            case 2:
            case 3:
                buttonType = 2;
                break;
            case 4:
            case 5:
                buttonType = 3;
                break;
            case 6:
                buttonType = 4;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        NftReporterHelper.INSTANCE.reportAvatarFloatPanelClick(buttonType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$6(DigitalCardDetailRouterInfo $routerInfo, DigitalCardDetailPreviewView this$0, View it) {
        String it2;
        if ($routerInfo != null && (it2 = $routerInfo.getPendantUrl()) != null) {
            this$0.goRouterPage(it2);
        }
        boolean z = false;
        if ($routerInfo != null && $routerInfo.isMe()) {
            z = true;
        }
        if (z && $routerInfo.getUseScene() == 1) {
            NftReporterHelper.INSTANCE.reportAvatarDetailClick(2);
        }
    }

    private final String appendParam(String url) {
        if (url != null) {
            Uri uri = Uri.parse(url).buildUpon().build();
            return uri.buildUpon().appendQueryParameter("f_source", "garb").appendQueryParameter("from", "activity.link").build().toString();
        }
        return null;
    }

    private final void goRouterPage(String url) {
        if (url != null) {
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(url), this.activity);
        }
    }

    /* compiled from: DigitalCardDetailPreviewView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailPreviewView$Companion;", "", "<init>", "()V", "AVATAR", "", "HEADER", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}