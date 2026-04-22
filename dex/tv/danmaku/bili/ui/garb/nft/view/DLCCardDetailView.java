package tv.danmaku.bili.ui.garb.nft.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bili.resource.space.R;
import com.alibaba.fastjson.JSON;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bilibili.app.authorspace.ui.AuthorImageUploadHelper;
import com.bilibili.app.authorspace.ui.nft.utils.NftCardClipper;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.ogv.infra.router.RouterRequestKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.xpref.Xpref;
import com.google.gson.JsonObject;
import com.yalantis.ucrop.UCrop;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppDlcDialogBottomContainerBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.DigitalJsCallHandler;
import tv.danmaku.bili.ui.garb.NftCardDialog;
import tv.danmaku.bili.ui.garb.NftCardPresentErrorCardDialog;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader;
import tv.danmaku.bili.ui.garb.api.BiliNftTransfer;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.DLCReporterHelper;
import tv.danmaku.bili.ui.garb.api.UseMenu;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.digital.base.view.OnCancelClickListener;
import tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService;
import tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback;
import tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList;
import tv.danmaku.bili.ui.garb.nft.DLCCardMenuButtonList;
import tv.danmaku.bili.ui.garb.nft.DLCSplashSettingNoticeDialogService;
import tv.danmaku.bili.ui.garb.nft.DLCSplashSettingService;
import tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;
import tv.danmaku.bili.ui.garb.nft.model.ActionVo;
import tv.danmaku.bili.ui.garb.nft.model.CardShareInfo;
import tv.danmaku.bili.ui.garb.nft.model.CollectProgressButton;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;
import tv.danmaku.bili.ui.garb.nft.util.DLCConstUtilKt;

/* compiled from: DLCCardDetailView.kt */
@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001v\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020)H\u0002J\u0010\u0010D\u001a\u00020<2\u0006\u0010C\u001a\u00020)H\u0002J\u0010\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020<2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u00020<2\u0006\u0010F\u001a\u00020GH\u0014JI\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020>2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0002\u0010UJ\u0010\u0010V\u001a\u00020<2\u0006\u0010C\u001a\u00020)H\u0016JI\u0010W\u001a\u00020<2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020>2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0002\u0010UJ:\u0010X\u001a\u00020<2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020>2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020SH\u0014J1\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u00020L2\u0006\u0010M\u001a\u00020>2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014¢\u0006\u0002\u0010[J\u001c\u0010\\\u001a\u00020<2\b\u0010]\u001a\u0004\u0018\u00010L2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010`\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\b\u0010e\u001a\u00020<H\u0002J\b\u0010f\u001a\u00020<H\u0002J\b\u0010g\u001a\u00020<H\u0002J\b\u0010h\u001a\u00020<H\u0002J\b\u0010i\u001a\u00020<H\u0002J\b\u0010j\u001a\u00020<H\u0002J \u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020G2\u0006\u0010K\u001a\u00020L2\u0006\u0010m\u001a\u00020nH\u0002J \u0010o\u001a\u00020<2\u0006\u0010l\u001a\u00020G2\u0006\u0010K\u001a\u00020L2\u0006\u0010m\u001a\u00020nH\u0002J\b\u0010p\u001a\u00020<H\u0014J\"\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020S2\u0006\u0010s\u001a\u00020S2\b\u0010M\u001a\u0004\u0018\u00010tH\u0016J\f\u0010x\u001a\u00020)*\u00020yH\u0002J\b\u0010z\u001a\u00020)H\u0002J\b\u0010{\u001a\u00020)H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R \u00103\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0010\u0010u\u001a\u00020vX\u0082\u0004¢\u0006\u0004\n\u0002\u0010w¨\u0006|"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCCardDetailView;", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "context", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "handler", "Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "onCancelClickListener", "Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;Ltv/danmaku/bili/ui/garb/digital/base/view/OnCancelClickListener;Lcom/bili/digital/common/player/DigitalCardPlayerManager;)V", "getContext", "()Landroid/app/Activity;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getHandler", "()Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "setHandler", "(Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "mTopContainer", "Landroid/view/View;", "bottomContainerBinding", "Ltv/danmaku/bili/databinding/BiliAppDlcDialogBottomContainerBinding;", "mFloatBottomContainer", "mCloseBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "mShareBtn", "mSmeltingTutorialBtn", "mMoreBtn", "mImageUploadHelper", "Lcom/bilibili/app/authorspace/ui/AuthorImageUploadHelper;", "mTopMenu", "Ltv/danmaku/bili/ui/garb/nft/DLCCardMenuButtonList;", "mBottomMenu", "Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList;", "mNftInfoUrl", "", "mShowTopMenu", "", "mShowBottomMenu", "splashSettingNoticeDialogService", "Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;", "service", "Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "splashSettingService", "Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingService;", "dlcCardLockService", "Ltv/danmaku/bili/ui/garb/digital/lockcard/DLCCardLockService;", "commonReportParams", "", "getCommonReportParams", "()Ljava/util/Map;", "topMenuCallback", "Ltv/danmaku/bili/ui/garb/nft/TopMenuButtonCallback;", "bottomMenuCallback", "Ltv/danmaku/bili/ui/garb/nft/BottomMenuButtonCallback;", "onCardItemChanged", "", "containerRenderData", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "cardInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "renderCardLock", "showTopMenu", "visible", "showBottomMenu", "initTopContainer", "container", "Landroid/view/ViewGroup;", "initBottomContainer", "initBottomFloatContainer", "renderTopContainerUI", "fromType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "data", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "isFullScreen", "isMultiView", "materialType", "", "fromItemChanged", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;ZZILjava/lang/Boolean;)V", "setSmeltingTutorialBtnVisible", "renderBottomContainerUI", "renderBottomFloatContainerUI", "registerButtonListener", "type", "(Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;Ljava/lang/Integer;)V", "setShareData", "shareType", "shareModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "handleShareData", "getShareModel", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "setShareModel", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;)V", "refreshTopMenuUI", "refreshBottomMenuUI", "openTopMenu", "openBottomMenu", "closeTopMenu", "closeBottomMenu", "initTopMenu", "menu", "mid", "", "initBottomMenu", "closeContainer", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "mUploadStateInterface", "tv/danmaku/bili/ui/garb/nft/view/DLCCardDetailView$mUploadStateInterface$1", "Ltv/danmaku/bili/ui/garb/nft/view/DLCCardDetailView$mUploadStateInterface$1;", "showUseTag", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "showHeaderTag", "showAvatarTag", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardDetailView extends DigitalCardDetailBaseView {
    public static final int $stable = 8;
    private BiliAppDlcDialogBottomContainerBinding bottomContainerBinding;
    private BottomMenuButtonCallback bottomMenuCallback;
    private final Activity context;
    private final DLCCardLockService dlcCardLockService;
    private final Fragment fragment;
    private DigitalJsCallHandler handler;
    private DLCCardBotttomMenuList mBottomMenu;
    private AppCompatImageView mCloseBtn;
    private View mFloatBottomContainer;
    private AuthorImageUploadHelper mImageUploadHelper;
    private AppCompatImageView mMoreBtn;
    private String mNftInfoUrl;
    private AppCompatImageView mShareBtn;
    private boolean mShowBottomMenu;
    private boolean mShowTopMenu;
    private AppCompatImageView mSmeltingTutorialBtn;
    private View mTopContainer;
    private DLCCardMenuButtonList mTopMenu;
    private final DLCCardDetailView$mUploadStateInterface$1 mUploadStateInterface;
    private final OnCancelClickListener onCancelClickListener;
    private final DigitalCardPlayerManager playerManager;
    private final DLCApiService service;
    private DLCCardShareModel shareModel;
    private DigitalFromType shareType;
    private final DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService;
    private final DLCSplashSettingService splashSettingService;
    private TopMenuButtonCallback topMenuCallback;

    /* compiled from: DLCCardDetailView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            try {
                iArr[DigitalFromType.AWARD_POOL_CARD_PREVIEW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DigitalFromType.DETAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionVo.Type.values().length];
            try {
                iArr2[ActionVo.Type.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[ActionVo.Type.TOAST.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v16, types: [tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$mUploadStateInterface$1] */
    public DLCCardDetailView(Activity context, Fragment fragment, DigitalJsCallHandler handler, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager playerManager) {
        super(context, fragment, onCancelClickListener, playerManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onCancelClickListener, "onCancelClickListener");
        Intrinsics.checkNotNullParameter(playerManager, "playerManager");
        this.context = context;
        this.fragment = fragment;
        this.handler = handler;
        this.onCancelClickListener = onCancelClickListener;
        this.playerManager = playerManager;
        this.mNftInfoUrl = NftCardDialog.NFT_INFO_URL;
        this.splashSettingNoticeDialogService = new DLCSplashSettingNoticeDialogService();
        Object createService = ServiceGenerator.createService(DLCApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        this.service = (DLCApiService) createService;
        this.splashSettingService = new DLCSplashSettingService(this.context, this.service, this.splashSettingNoticeDialogService);
        Activity activity = this.context;
        LifecycleOwner lifecycleOwner = this.fragment;
        this.dlcCardLockService = new DLCCardLockService(activity, (CoroutineScope) (lifecycleOwner != null ? LifecycleOwnerKt.getLifecycleScope(lifecycleOwner) : null), this.service, this.handler);
        this.topMenuCallback = new TopMenuButtonCallback() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$topMenuCallback$1
            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public boolean hasNftInfo() {
                return !TextUtils.isEmpty(DLCCardDetailView.this.getCardHash());
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public boolean canDonate() {
                Integer cardCanDonate = DLCCardDetailView.this.getCardCanDonate();
                return cardCanDonate != null && cardCanDonate.intValue() == 1;
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public boolean canSaveImage() {
                return DLCCardDetailView.this.getCanSaveImage();
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public void seeNftInfo() {
                String str;
                str = DLCCardDetailView.this.mNftInfoUrl;
                String url = str + DLCCardDetailView.this.getCardHash();
                BLog.i("NftCardDialog", "see nft info " + url);
                SpaceNftUtils.INSTANCE.routeTo(url, DLCCardDetailView.this.getContext());
                DLCCardDetailView.this.closeContainer();
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public void savePic() {
                Map commonReportParams;
                DLCCardDetailView dLCCardDetailView = DLCCardDetailView.this;
                Map $this$savePic_u24lambda_u240 = MapsKt.createMapBuilder();
                commonReportParams = dLCCardDetailView.getCommonReportParams();
                $this$savePic_u24lambda_u240.putAll(commonReportParams);
                DigitalCardDetailRenderData renderData = dLCCardDetailView.getContainerRenderData().getRenderData();
                $this$savePic_u24lambda_u240.put("card_id", String.valueOf(renderData != null ? Long.valueOf(renderData.getCardId()) : null));
                $this$savePic_u24lambda_u240.put("bottom_id", "1");
                Unit unit = Unit.INSTANCE;
                Neurons.reportClick(false, "sqzz.activity.bag.card-more.click", MapsKt.build($this$savePic_u24lambda_u240));
                Activity context2 = DLCCardDetailView.this.getContext();
                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                if (fragmentActivity != null) {
                    DLCCardDetailView dLCCardDetailView2 = DLCCardDetailView.this;
                    FragmentActivity it = fragmentActivity;
                    if (dLCCardDetailView2.isCurrentCardVideoType()) {
                        BLog.i("NftCardDialog", "save video !");
                        SpaceNftUtils.INSTANCE.saveVideo(dLCCardDetailView2.getImgDownloadUrl(), dLCCardDetailView2.getVideoDownloadUrl(), it);
                        return;
                    }
                    BLog.i("NftCardDialog", "save pic !");
                    SpaceNftUtils.INSTANCE.savePic(dLCCardDetailView2.getImgDownloadUrl(), it);
                }
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public void giveOther() {
                Map commonReportParams;
                DLCCardDetailView dLCCardDetailView = DLCCardDetailView.this;
                Map $this$giveOther_u24lambda_u242 = MapsKt.createMapBuilder();
                commonReportParams = dLCCardDetailView.getCommonReportParams();
                $this$giveOther_u24lambda_u242.putAll(commonReportParams);
                DigitalCardDetailRenderData renderData = dLCCardDetailView.getContainerRenderData().getRenderData();
                $this$giveOther_u24lambda_u242.put("card_id", String.valueOf(renderData != null ? Long.valueOf(renderData.getCardId()) : null));
                $this$giveOther_u24lambda_u242.put("bottom_id", "2");
                Unit unit = Unit.INSTANCE;
                Neurons.reportClick(false, "sqzz.activity.bag.card-more.click", MapsKt.build($this$giveOther_u24lambda_u242));
                BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
                int activityId = DLCCardDetailView.this.getActivityId();
                long cardId = DLCCardDetailView.this.getCardId();
                final DLCCardDetailView dLCCardDetailView2 = DLCCardDetailView.this;
                biliNftApiManager.transfer(activityId, cardId, new BiliApiDataCallback<BiliNftTransfer>() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$topMenuCallback$1$giveOther$2
                    public void onError(Throwable t) {
                        BLog.e("NftCardDialog", "转赠失败 11 onError: " + t);
                        ToastHelper.showToast(DLCCardDetailView.this.getContext(), "系统异常，请稍后处理", 0);
                    }

                    public void onDataSuccess(BiliNftTransfer data) {
                        if (data != null) {
                            DLCCardDetailView dLCCardDetailView3 = DLCCardDetailView.this;
                            if (data.getStatus() == 0) {
                                BLog.i("NftCardDialog", "转赠成功 onDataSuccess: " + data);
                                Uri parse = Uri.parse(data.getJumpUrl());
                                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                                BLRouter.routeTo(RouteRequestKt.toRouteRequest(parse), dLCCardDetailView3.getContext());
                                dLCCardDetailView3.closeContainer();
                                return;
                            }
                            BLog.e("NftCardDialog", "转赠失败弹窗");
                            Activity it = dLCCardDetailView3.getContext();
                            NftCardPresentErrorCardDialog.Companion.show(it, data.getTitle(), data.getContentTemplate(), data.getHighlightParams());
                        }
                    }
                });
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public void dismissDialog() {
                DLCCardDetailView.this.showTopMenu(false);
            }

            @Override // tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback
            public long getCurrentCardId() {
                return DLCCardDetailView.this.getCardId();
            }
        };
        this.bottomMenuCallback = new BottomMenuButtonCallback() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$bottomMenuCallback$1

            /* compiled from: DLCCardDetailView.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[UseMenu.Type.values().length];
                    try {
                        iArr[UseMenu.Type.Comment.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[UseMenu.Type.Dynamic.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[UseMenu.Type.SplashSetting.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[UseMenu.Type.AppWidget.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public void setAvatar() {
                Fragment it = DLCCardDetailView.this.getFragment();
                if (it != null) {
                    DLCCardDetailView dLCCardDetailView = DLCCardDetailView.this;
                    DLCReporterHelper dLCReporterHelper = DLCReporterHelper.INSTANCE;
                    int activityId = dLCCardDetailView.getActivityId();
                    String from = dLCCardDetailView.getFrom();
                    if (from == null) {
                        from = "";
                    }
                    String fromId = dLCCardDetailView.getFromId();
                    if (fromId == null) {
                        fromId = "";
                    }
                    String source = dLCCardDetailView.getSource();
                    if (source == null) {
                        source = "";
                    }
                    dLCReporterHelper.reportDLCSetAvatarHeaderClick(activityId, from, fromId, source, 1);
                    NftCardClipper.INSTANCE.startCropActivityWithAvatar(dLCCardDetailView.getCardImgUrl(), it);
                }
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public void setHeader() {
                if (DLCCardDetailView.this.getFragment() != null) {
                    DLCCardDetailView dLCCardDetailView = DLCCardDetailView.this;
                    DLCReporterHelper dLCReporterHelper = DLCReporterHelper.INSTANCE;
                    int activityId = dLCCardDetailView.getActivityId();
                    String from = dLCCardDetailView.getFrom();
                    if (from == null) {
                        from = "";
                    }
                    String fromId = dLCCardDetailView.getFromId();
                    if (fromId == null) {
                        fromId = "";
                    }
                    String source = dLCCardDetailView.getSource();
                    if (source == null) {
                        source = "";
                    }
                    dLCReporterHelper.reportDLCSetAvatarHeaderClick(activityId, from, fromId, source, 2);
                    String url = dLCCardDetailView.getSetBgUrl();
                    if (url != null) {
                        dLCCardDetailView.showBottomMenu(false);
                        dLCCardDetailView.closeContainer();
                        Map map = new LinkedHashMap();
                        map.put("biz_id", String.valueOf(dLCCardDetailView.getActivityId()));
                        map.put("biz_type", "2");
                        map.put("biz_item_id", String.valueOf(dLCCardDetailView.getCardTypeId()));
                        SpaceNftUtils.INSTANCE.routeWithMap(url, map, dLCCardDetailView.getContext());
                    }
                }
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public long getCurrentCardId() {
                return DLCCardDetailView.this.getCardId();
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public void dismissMenu() {
                DLCCardDetailView.this.showBottomMenu(false);
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public Pair<CardRightShow, CardRight> getLimitInfo() {
                return DLCCardDetailView.this.getCardLimitInfo();
            }

            @Override // tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback
            public void onUsingMenuClick(DLCCardBotttomMenuList.UseMenuVM menuVm) {
                RouteRequest routeRequest;
                CoroutineScope lifecycleScope;
                RouteRequest routeRequest2;
                Intrinsics.checkNotNullParameter(menuVm, "menuVm");
                dismissMenu();
                UseMenu menu = menuVm.getData();
                switch (WhenMappings.$EnumSwitchMapping$0[menu.getJumpType().ordinal()]) {
                    case 1:
                    case 2:
                        String targetUrl = menu.getTargetUrl();
                        if (targetUrl != null && (routeRequest = RouteRequestKt.toRouteRequest(targetUrl)) != null) {
                            RouterRequestKt.openWith(routeRequest, DLCCardDetailView.this.getContext());
                            return;
                        }
                        return;
                    case 3:
                        LifecycleOwner fragment2 = DLCCardDetailView.this.getFragment();
                        if (fragment2 == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragment2)) == null) {
                            return;
                        }
                        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new DLCCardDetailView$bottomMenuCallback$1$onUsingMenuClick$1(DLCCardDetailView.this, null), 3, (Object) null);
                        return;
                    case 4:
                        menuVm.setBadgeShowing(false);
                        Xpref.getDefaultSharedPreferences(DLCCardDetailView.this.getContext()).edit().putBoolean("app_widget_enter_badge_showed", true).apply();
                        String targetUrl2 = menu.getTargetUrl();
                        if (targetUrl2 != null && (routeRequest2 = RouteRequestKt.toRouteRequest(targetUrl2)) != null) {
                            RouterRequestKt.openWith(routeRequest2, DLCCardDetailView.this.getContext());
                        }
                        Neurons.reportClick(false, "sqzz.dressing.single-card.all.click", MapsKt.mapOf(new Pair[]{TuplesKt.to(ChannelRoutes.CHANNEL_NAME, "widget"), TuplesKt.to("dlc_id", String.valueOf(DLCCardDetailView.this.getCardTypeId()))}));
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        };
        this.mUploadStateInterface = new AuthorImageUploadHelper.IUploadStateInterface() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$mUploadStateInterface$1
            public void onCachePathInavailable() {
                BLog.e("NftCardDialog", "外部存储不可用");
                ToastHelper.showToastShort(DLCCardDetailView.this.getContext(), DLCCardDetailView.this.getContext().getResources().getString(R.string.space_global_string_125));
            }

            public void onCompressFailed() {
                BLog.e("NftCardDialog", "图片压缩失败");
                ToastHelper.showToastShort(DLCCardDetailView.this.getContext(), DLCCardDetailView.this.getContext().getResources().getString(bili.resource.following.R.string.following_global_string_752));
            }

            public void onUploadStart() {
            }

            public void onUploadSuccess(String url) {
            }

            public void onUploadFailed() {
                BLog.e("NftCardDialog", "图片上传失败");
                ToastHelper.showToastShort(DLCCardDetailView.this.getContext(), DLCCardDetailView.this.getContext().getResources().getString(R.string.space_global_string_237));
            }

            public void onNotVerify(int responseCode, String message) {
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DLCCardDetailView(Activity activity, Fragment fragment, DigitalJsCallHandler digitalJsCallHandler, OnCancelClickListener onCancelClickListener, DigitalCardPlayerManager digitalCardPlayerManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getCommonReportParams() {
        Map $this$_get_commonReportParams__u24lambda_u240 = MapsKt.createMapBuilder();
        $this$_get_commonReportParams__u24lambda_u240.put("page_type", "");
        $this$_get_commonReportParams__u24lambda_u240.put("activity_id", String.valueOf(getContainerRenderData().getActivityId()));
        $this$_get_commonReportParams__u24lambda_u240.put("activity_status", String.valueOf(getContainerRenderData().getActivityStatus()));
        $this$_get_commonReportParams__u24lambda_u240.put("lottery_id", String.valueOf(getContainerRenderData().getActivityId()));
        $this$_get_commonReportParams__u24lambda_u240.put("f_source", String.valueOf(getContainerRenderData().getFSource()));
        String from = getContainerRenderData().getFrom();
        if (from == null) {
            from = "";
        }
        $this$_get_commonReportParams__u24lambda_u240.put("from", from);
        String fromId = getContainerRenderData().getFromId();
        $this$_get_commonReportParams__u24lambda_u240.put("from_id", fromId != null ? fromId : "");
        return MapsKt.build($this$_get_commonReportParams__u24lambda_u240);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void onCardItemChanged(DigitalCardDetailContainerRenderData containerRenderData, DigitalCardDetailRenderData cardInfo) {
        Intrinsics.checkNotNullParameter(containerRenderData, "containerRenderData");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        handleShareData(null);
        showTopMenu(false);
        showBottomMenu(false);
        DigitalFromType fromType = getFromType();
        Boolean isFullScreen = isFullScreen();
        boolean booleanValue = isFullScreen != null ? isFullScreen.booleanValue() : true;
        Integer cardMaterialType = getCardMaterialType();
        renderTopContainerUI(fromType, containerRenderData, null, booleanValue, false, cardMaterialType != null ? cardMaterialType.intValue() : 0, true);
        DigitalFromType fromType2 = getFromType();
        Boolean isFullScreen2 = isFullScreen();
        boolean booleanValue2 = isFullScreen2 != null ? isFullScreen2.booleanValue() : true;
        Integer cardMaterialType2 = getCardMaterialType();
        renderBottomContainerUI(fromType2, containerRenderData, null, booleanValue2, false, cardMaterialType2 != null ? cardMaterialType2.intValue() : 0, true);
        refreshTopMenuUI();
        refreshBottomMenuUI();
        renderCardLock(cardInfo);
    }

    private final void renderCardLock(final DigitalCardDetailRenderData cardInfo) {
        CardLockStatus it = cardInfo.getCardLockStatus();
        if (it != null) {
            this.dlcCardLockService.renderCardLock(getCardLockComposeView(), getActivityId(), it, cardInfo.getCardId(), cardInfo.getCardTypeId(), cardInfo.getIndex(), new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit renderCardLock$lambda$0$0;
                    renderCardLock$lambda$0$0 = DLCCardDetailView.renderCardLock$lambda$0$0(DigitalCardDetailRenderData.this, (CardLockStatus) obj);
                    return renderCardLock$lambda$0$0;
                }
            });
            return;
        }
        DLCCardDetailView $this$renderCardLock_u24lambda_u241 = this;
        View $this$isVisible$iv = $this$renderCardLock_u24lambda_u241.getCardLockComposeView();
        $this$isVisible$iv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderCardLock$lambda$0$0(DigitalCardDetailRenderData $cardInfo, CardLockStatus lockStatus) {
        Intrinsics.checkNotNullParameter(lockStatus, "lockStatus");
        $cardInfo.setCardLockStatus(lockStatus);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTopMenu(boolean visible) {
        this.mShowTopMenu = visible;
        if (visible) {
            openTopMenu();
        } else {
            closeTopMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomMenu(boolean visible) {
        this.mShowBottomMenu = visible;
        if (visible) {
            openBottomMenu();
        } else {
            closeBottomMenu();
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initTopContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View view = null;
        View inflate = LayoutInflater.from(this.context).inflate(tv.danmaku.bili.R.layout.bili_app_dlc_dialog_top_container, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mTopContainer = inflate;
        View view2 = this.mTopContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view2 = null;
        }
        AppCompatImageView findViewById = view2.findViewById(tv.danmaku.bili.R.id.iv_dlc_card_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCloseBtn = findViewById;
        View view3 = this.mTopContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view3 = null;
        }
        AppCompatImageView findViewById2 = view3.findViewById(tv.danmaku.bili.R.id.iv_dlc_card_share);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mShareBtn = findViewById2;
        View view4 = this.mTopContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view4 = null;
        }
        AppCompatImageView findViewById3 = view4.findViewById(tv.danmaku.bili.R.id.iv_dlc_card_smelt_tutorial);
        AppCompatImageView $this$initTopContainer_u24lambda_u240 = findViewById3;
        $this$initTopContainer_u24lambda_u240.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "apply(...)");
        this.mSmeltingTutorialBtn = findViewById3;
        View view5 = this.mTopContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            view5 = null;
        }
        AppCompatImageView findViewById4 = view5.findViewById(tv.danmaku.bili.R.id.iv_dlc_card_more);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mMoreBtn = findViewById4;
        container.removeAllViews();
        View view6 = this.mTopContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
        } else {
            view = view6;
        }
        container.addView(view);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void initBottomContainer(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.removeAllViews();
        BiliAppDlcDialogBottomContainerBinding inflate = BiliAppDlcDialogBottomContainerBinding.inflate(LayoutInflater.from(this.context), container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.bottomContainerBinding = inflate;
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding = this.bottomContainerBinding;
        if (biliAppDlcDialogBottomContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            biliAppDlcDialogBottomContainerBinding = null;
        }
        biliAppDlcDialogBottomContainerBinding.ivBottomClose.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.this.closeContainer();
            }
        });
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
        int i = 8;
        View view = null;
        if (!isFullScreen) {
            View view2 = this.mTopContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        int i2 = 0;
        if (Intrinsics.areEqual(fromItemChanged, false)) {
            initTopMenu(getMTopMenuContainer(), fromType, routerInfo != null ? routerInfo.getMid() : 0L);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                switch (materialType) {
                    case 1:
                        View view3 = this.mTopContainer;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view3 = null;
                        }
                        view3.setVisibility(0);
                        AppCompatImageView appCompatImageView = this.mShareBtn;
                        if (appCompatImageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView = null;
                        }
                        appCompatImageView.setVisibility((isMe() && Intrinsics.areEqual(getCardHasGained(), true)) ? 0 : 8);
                        View view4 = this.mMoreBtn;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view4;
                        }
                        if (isMe() && Intrinsics.areEqual(getCardHasGained(), true)) {
                            i = 0;
                        }
                        view.setVisibility(i);
                        return;
                    case 2:
                        View view5 = this.mTopContainer;
                        if (view5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view5 = null;
                        }
                        view5.setVisibility(0);
                        AppCompatImageView appCompatImageView2 = this.mShareBtn;
                        if (appCompatImageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView2 = null;
                        }
                        if (!isMe() || !Intrinsics.areEqual(getCardHasGained(), true)) {
                            i2 = 8;
                        }
                        appCompatImageView2.setVisibility(i2);
                        View view6 = this.mMoreBtn;
                        if (view6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view6;
                        }
                        view.setVisibility(8);
                        return;
                    case 3:
                        View view7 = this.mTopContainer;
                        if (view7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view7 = null;
                        }
                        view7.setVisibility(0);
                        AppCompatImageView appCompatImageView3 = this.mShareBtn;
                        if (appCompatImageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView3 = null;
                        }
                        if (!isMe() || !Intrinsics.areEqual(getCardHasGained(), true)) {
                            i2 = 8;
                        }
                        appCompatImageView3.setVisibility(i2);
                        View view8 = this.mMoreBtn;
                        if (view8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view8;
                        }
                        view.setVisibility(8);
                        return;
                    case 4:
                        View view9 = this.mTopContainer;
                        if (view9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view9 = null;
                        }
                        view9.setVisibility(0);
                        AppCompatImageView appCompatImageView4 = this.mShareBtn;
                        if (appCompatImageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView4 = null;
                        }
                        if (!isMe() || !Intrinsics.areEqual(getCardHasGained(), true)) {
                            i2 = 8;
                        }
                        appCompatImageView4.setVisibility(i2);
                        View view10 = this.mMoreBtn;
                        if (view10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view10;
                        }
                        view.setVisibility(8);
                        return;
                    default:
                        return;
                }
            case 4:
                switch (materialType) {
                    case -1:
                        View view11 = this.mTopContainer;
                        if (view11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view11 = null;
                        }
                        view11.setVisibility(0);
                        AppCompatImageView appCompatImageView5 = this.mShareBtn;
                        if (appCompatImageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView5 = null;
                        }
                        appCompatImageView5.setVisibility(0);
                        View view12 = this.mMoreBtn;
                        if (view12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view12;
                        }
                        view.setVisibility(8);
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        View view13 = this.mTopContainer;
                        if (view13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view13 = null;
                        }
                        view13.setVisibility(0);
                        AppCompatImageView appCompatImageView6 = this.mShareBtn;
                        if (appCompatImageView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView6 = null;
                        }
                        appCompatImageView6.setVisibility(0);
                        View view14 = this.mMoreBtn;
                        if (view14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view14;
                        }
                        view.setVisibility(8);
                        return;
                    case 2:
                        View view15 = this.mTopContainer;
                        if (view15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view15 = null;
                        }
                        view15.setVisibility(0);
                        AppCompatImageView appCompatImageView7 = this.mShareBtn;
                        if (appCompatImageView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView7 = null;
                        }
                        appCompatImageView7.setVisibility(0);
                        View view16 = this.mMoreBtn;
                        if (view16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view16;
                        }
                        view.setVisibility(8);
                        return;
                    case 3:
                        View view17 = this.mTopContainer;
                        if (view17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view17 = null;
                        }
                        view17.setVisibility(0);
                        AppCompatImageView appCompatImageView8 = this.mShareBtn;
                        if (appCompatImageView8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView8 = null;
                        }
                        appCompatImageView8.setVisibility(0);
                        View view18 = this.mMoreBtn;
                        if (view18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view18;
                        }
                        view.setVisibility(8);
                        return;
                    case 4:
                        View view19 = this.mTopContainer;
                        if (view19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                            view19 = null;
                        }
                        view19.setVisibility(0);
                        AppCompatImageView appCompatImageView9 = this.mShareBtn;
                        if (appCompatImageView9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                            appCompatImageView9 = null;
                        }
                        appCompatImageView9.setVisibility(0);
                        View view20 = this.mMoreBtn;
                        if (view20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
                        } else {
                            view = view20;
                        }
                        view.setVisibility(8);
                        return;
                }
            case 5:
                View view21 = this.mTopContainer;
                if (view21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                } else {
                    view = view21;
                }
                view.setVisibility(4);
                return;
            case 6:
                View view22 = this.mTopContainer;
                if (view22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                } else {
                    view = view22;
                }
                view.setVisibility(4);
                return;
            case 7:
                View view23 = this.mTopContainer;
                if (view23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                } else {
                    view = view23;
                }
                view.setVisibility(4);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void setSmeltingTutorialBtnVisible(boolean visible) {
        AppCompatImageView appCompatImageView = this.mSmeltingTutorialBtn;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmeltingTutorialBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setVisibility(visible ? 0 : 8);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void renderBottomContainerUI(DigitalFromType fromType, DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, boolean isFullScreen, boolean isMultiView, int materialType, Boolean fromItemChanged) {
        String str;
        CardRightShow cardRightShow;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        String str2;
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(fromItemChanged, false)) {
            initBottomMenu(getMBottomMenuContainer(), fromType, routerInfo != null ? routerInfo.getMid() : 0L);
        }
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding = this.bottomContainerBinding;
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding2 = null;
        if (biliAppDlcDialogBottomContainerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            biliAppDlcDialogBottomContainerBinding = null;
        }
        biliAppDlcDialogBottomContainerBinding.getRoot().setVisibility(0);
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding3 = this.bottomContainerBinding;
        if (biliAppDlcDialogBottomContainerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            biliAppDlcDialogBottomContainerBinding3 = null;
        }
        biliAppDlcDialogBottomContainerBinding3.containerBottomButton.setVisibility(8);
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding4 = this.bottomContainerBinding;
        if (biliAppDlcDialogBottomContainerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            biliAppDlcDialogBottomContainerBinding4 = null;
        }
        biliAppDlcDialogBottomContainerBinding4.containerBottomClose.setVisibility(8);
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding5 = this.bottomContainerBinding;
        if (biliAppDlcDialogBottomContainerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            biliAppDlcDialogBottomContainerBinding5 = null;
        }
        biliAppDlcDialogBottomContainerBinding5.ivDlcBottomButtonTag.setVisibility(8);
        boolean z = true;
        if (data.getRewardBottomButton() != null) {
            final CollectProgressButton button = data.getRewardBottomButton();
            BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding6 = this.bottomContainerBinding;
            if (biliAppDlcDialogBottomContainerBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                biliAppDlcDialogBottomContainerBinding6 = null;
            }
            biliAppDlcDialogBottomContainerBinding6.containerBottomButton.setVisibility(0);
            BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding7 = this.bottomContainerBinding;
            if (biliAppDlcDialogBottomContainerBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                biliAppDlcDialogBottomContainerBinding7 = null;
            }
            biliAppDlcDialogBottomContainerBinding7.ivDlcBottomView.setVisibility(0);
            BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding8 = this.bottomContainerBinding;
            if (biliAppDlcDialogBottomContainerBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
            } else {
                biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding8;
            }
            final AppCompatTextView $this$renderBottomContainerUI_u24lambda_u240 = biliAppDlcDialogBottomContainerBinding2.ivDlcBottomView;
            $this$renderBottomContainerUI_u24lambda_u240.setText(button.getText());
            $this$renderBottomContainerUI_u24lambda_u240.setTextColor(button.getTextColor());
            $this$renderBottomContainerUI_u24lambda_u240.setBackgroundDrawable(button.getBackgroundDrawable());
            $this$renderBottomContainerUI_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DLCCardDetailView.renderBottomContainerUI$lambda$0$0(CollectProgressButton.this, $this$renderBottomContainerUI_u24lambda_u240, view);
                }
            });
            if (button.getReport() != null) {
                if ((button.getReport().getShow().getEventId().length() > 0 ? 1 : 0) != 0) {
                    Neurons.reportExposure$default(false, button.getReport().getShow().getEventId(), button.getReport().getShow().getParams(), (List) null, 8, (Object) null);
                    return;
                }
                return;
            }
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                switch (materialType) {
                    case 1:
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding9 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding9 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding9.containerBottomButton.setVisibility(0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding10 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding10 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding10.ivDlcBottomView.setVisibility((isMe() && Intrinsics.areEqual(getCardHasGained(), false) && fromType == DigitalFromType.TASK) ? 8 : 0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding11 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding11 = null;
                        }
                        AppCompatTextView appCompatTextView = biliAppDlcDialogBottomContainerBinding11.ivDlcBottomView;
                        if (isMe() && fromType != DigitalFromType.SCAN) {
                            if (Intrinsics.areEqual(getCardHasGained(), true)) {
                                Pair<CardRightShow, CardRight> cardLimitInfo = getCardLimitInfo();
                                if ((cardLimitInfo == null || (cardRightShow3 = (CardRightShow) cardLimitInfo.getFirst()) == null || !DLCConstUtilKt.forbiddenUse(cardRightShow3)) ? false : true) {
                                    BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding12 = this.bottomContainerBinding;
                                    if (biliAppDlcDialogBottomContainerBinding12 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                        biliAppDlcDialogBottomContainerBinding12 = null;
                                    }
                                    biliAppDlcDialogBottomContainerBinding12.ivDlcBottomView.setTextColor(this.context.getResources().getColor(tv.danmaku.bili.R.color.bili_digital_detail_bottom_btn_unused_text_color));
                                    BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding13 = this.bottomContainerBinding;
                                    if (biliAppDlcDialogBottomContainerBinding13 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                        biliAppDlcDialogBottomContainerBinding13 = null;
                                    }
                                    biliAppDlcDialogBottomContainerBinding13.ivDlcBottomView.setBackgroundDrawable(this.context.getResources().getDrawable(tv.danmaku.bili.R.drawable.ic_nft_card_bottom_button_unused_bg));
                                } else {
                                    BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding14 = this.bottomContainerBinding;
                                    if (biliAppDlcDialogBottomContainerBinding14 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                        biliAppDlcDialogBottomContainerBinding14 = null;
                                    }
                                    biliAppDlcDialogBottomContainerBinding14.ivDlcBottomView.setTextColor(this.context.getResources().getColor(tv.danmaku.bili.R.color.bili_digital_detail_bottom_btn_used_text_color));
                                    BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding15 = this.bottomContainerBinding;
                                    if (biliAppDlcDialogBottomContainerBinding15 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                        biliAppDlcDialogBottomContainerBinding15 = null;
                                    }
                                    biliAppDlcDialogBottomContainerBinding15.ivDlcBottomView.setBackgroundDrawable(this.context.getResources().getDrawable(tv.danmaku.bili.R.drawable.ic_nft_card_bottom_button_bg));
                                }
                                BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding16 = this.bottomContainerBinding;
                                if (biliAppDlcDialogBottomContainerBinding16 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                    biliAppDlcDialogBottomContainerBinding16 = null;
                                }
                                BiliImageView biliImageView = biliAppDlcDialogBottomContainerBinding16.ivDlcBottomButtonTag;
                                Pair<CardRightShow, CardRight> cardLimitInfo2 = getCardLimitInfo();
                                if (cardLimitInfo2 == null || (cardRightShow2 = (CardRightShow) cardLimitInfo2.getFirst()) == null || !showUseTag(cardRightShow2)) {
                                    z = false;
                                }
                                if (!z) {
                                    r2 = 8;
                                }
                                biliImageView.setVisibility(r2);
                                BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding17 = this.bottomContainerBinding;
                                if (biliAppDlcDialogBottomContainerBinding17 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                    biliAppDlcDialogBottomContainerBinding17 = null;
                                }
                                if (biliAppDlcDialogBottomContainerBinding17.ivDlcBottomButtonTag.getVisibility() == 0) {
                                    ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.context);
                                    Pair<CardRightShow, CardRight> cardLimitInfo3 = getCardLimitInfo();
                                    ImageRequestBuilder url = with.url((cardLimitInfo3 == null || (cardRightShow = (CardRightShow) cardLimitInfo3.getFirst()) == null) ? null : cardRightShow.getUseTagUrl());
                                    BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding18 = this.bottomContainerBinding;
                                    if (biliAppDlcDialogBottomContainerBinding18 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                                    } else {
                                        biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding18;
                                    }
                                    BiliImageView biliImageView2 = biliAppDlcDialogBottomContainerBinding2.ivDlcBottomButtonTag;
                                    Intrinsics.checkNotNullExpressionValue(biliImageView2, "ivDlcBottomButtonTag");
                                    url.into(biliImageView2);
                                }
                            }
                        }
                        appCompatTextView.setText(str);
                        return;
                    case 2:
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding19 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding19 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding19.containerBottomButton.setVisibility(0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding20 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding20 = null;
                        }
                        AppCompatTextView appCompatTextView2 = biliAppDlcDialogBottomContainerBinding20.ivDlcBottomView;
                        if (isMe() && !Intrinsics.areEqual(getCardHasGained(), true)) {
                            r2 = 8;
                        }
                        appCompatTextView2.setVisibility(r2);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding21 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                        } else {
                            biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding21;
                        }
                        biliAppDlcDialogBottomContainerBinding2.ivDlcBottomView.setText(!isMe() ? "查看活动" : "去使用");
                        return;
                    case 3:
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding22 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding22 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding22.containerBottomButton.setVisibility(0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding23 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding23 = null;
                        }
                        AppCompatTextView appCompatTextView3 = biliAppDlcDialogBottomContainerBinding23.ivDlcBottomView;
                        if (isMe() && !Intrinsics.areEqual(getCardHasGained(), true)) {
                            r2 = 8;
                        }
                        appCompatTextView3.setVisibility(r2);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding24 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                        } else {
                            biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding24;
                        }
                        biliAppDlcDialogBottomContainerBinding2.ivDlcBottomView.setText(!isMe() ? "查看活动" : "去使用");
                        return;
                    case 4:
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding25 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding25 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding25.containerBottomButton.setVisibility(0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding26 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                            biliAppDlcDialogBottomContainerBinding26 = null;
                        }
                        biliAppDlcDialogBottomContainerBinding26.ivDlcBottomView.setVisibility(0);
                        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding27 = this.bottomContainerBinding;
                        if (biliAppDlcDialogBottomContainerBinding27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                        } else {
                            biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding27;
                        }
                        AppCompatTextView appCompatTextView4 = biliAppDlcDialogBottomContainerBinding2.ivDlcBottomView;
                        if (isMe()) {
                            str2 = Intrinsics.areEqual(getCardHasGained(), true) ? "去使用" : "查看套装详情";
                        }
                        appCompatTextView4.setText(str2);
                        return;
                    default:
                        return;
                }
            case 4:
            case 5:
                BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding28 = this.bottomContainerBinding;
                if (biliAppDlcDialogBottomContainerBinding28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                } else {
                    biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding28;
                }
                biliAppDlcDialogBottomContainerBinding2.getRoot().setVisibility(8);
                return;
            case 6:
                BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding29 = this.bottomContainerBinding;
                if (biliAppDlcDialogBottomContainerBinding29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                } else {
                    biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding29;
                }
                biliAppDlcDialogBottomContainerBinding2.containerBottomClose.setVisibility(0);
                return;
            case 7:
                BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding30 = this.bottomContainerBinding;
                if (biliAppDlcDialogBottomContainerBinding30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
                } else {
                    biliAppDlcDialogBottomContainerBinding2 = biliAppDlcDialogBottomContainerBinding30;
                }
                biliAppDlcDialogBottomContainerBinding2.getRoot().setVisibility(8);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderBottomContainerUI$lambda$0$0(CollectProgressButton $button, AppCompatTextView $this_apply, View it) {
        ActionVo action = $button.getAction();
        ActionVo.Type type = action != null ? action.getType() : null;
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1:
                SpaceNftUtils.INSTANCE.routeWithMap($button.getAction().getValue(), MapsKt.emptyMap(), $this_apply.getContext());
                break;
            case 2:
                ToastHelper.showToast($this_apply.getContext(), $button.getAction().getValue(), 0);
                break;
        }
        if ($button.getReport() != null) {
            if ($button.getReport().getClick().getEventId().length() > 0) {
                Neurons.reportClick(false, $button.getReport().getClick().getEventId(), $button.getReport().getClick().getParams());
            }
        }
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
            case 6:
                View view4 = this.mFloatBottomContainer;
                if (view4 != null) {
                    view4.setVisibility(8);
                    return;
                }
                return;
            case 7:
                View view5 = this.mFloatBottomContainer;
                if (view5 != null) {
                    view5.setVisibility(8);
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void registerButtonListener(final DigitalFromType type, final DigitalCardDetailContainerRenderData data, DigitalCardDetailRouterInfo routerInfo, Integer materialType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView appCompatImageView = this.mCloseBtn;
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding = null;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.registerButtonListener$lambda$0(DLCCardDetailView.this, view);
            }
        });
        AppCompatImageView appCompatImageView2 = this.mShareBtn;
        if (appCompatImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            appCompatImageView2 = null;
        }
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.registerButtonListener$lambda$1(DLCCardDetailView.this, view);
            }
        });
        AppCompatImageView appCompatImageView3 = this.mSmeltingTutorialBtn;
        if (appCompatImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmeltingTutorialBtn");
            appCompatImageView3 = null;
        }
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.registerButtonListener$lambda$2(DLCCardDetailView.this, view);
            }
        });
        AppCompatImageView appCompatImageView4 = this.mMoreBtn;
        if (appCompatImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
            appCompatImageView4 = null;
        }
        appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.registerButtonListener$lambda$3(DLCCardDetailView.this, view);
            }
        });
        BiliAppDlcDialogBottomContainerBinding biliAppDlcDialogBottomContainerBinding2 = this.bottomContainerBinding;
        if (biliAppDlcDialogBottomContainerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainerBinding");
        } else {
            biliAppDlcDialogBottomContainerBinding = biliAppDlcDialogBottomContainerBinding2;
        }
        biliAppDlcDialogBottomContainerBinding.ivDlcBottomView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DLCCardDetailView.registerButtonListener$lambda$4(DigitalFromType.this, this, data, view);
            }
        });
        super.registerButtonListener(type, data, routerInfo, materialType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$0(DLCCardDetailView this$0, View it) {
        DigitalJsCallHandler digitalJsCallHandler = this$0.handler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.toDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$1(DLCCardDetailView this$0, View it) {
        DigitalJsCallHandler digitalJsCallHandler;
        DLCCardShareModel it2 = this$0.shareModel;
        if (it2 != null && (digitalJsCallHandler = this$0.handler) != null) {
            digitalJsCallHandler.toShareDLC(it2);
        }
        DigitalJsCallHandler digitalJsCallHandler2 = this$0.handler;
        if (digitalJsCallHandler2 != null) {
            digitalJsCallHandler2.toDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$2(DLCCardDetailView this$0, View it) {
        Map $this$registerButtonListener_u24lambda_u242_u240 = MapsKt.createMapBuilder();
        $this$registerButtonListener_u24lambda_u242_u240.putAll(this$0.getCommonReportParams());
        $this$registerButtonListener_u24lambda_u242_u240.put("arrive", "3");
        $this$registerButtonListener_u24lambda_u242_u240.put("is_huixingka", "1");
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "sqzz.dressing.rebuild.guide.click", MapsKt.build($this$registerButtonListener_u24lambda_u242_u240));
        Uri.Builder buildUpon = Uri.parse("bilibili://digital/smelting_tutorial").buildUpon();
        JsonObject jsonObject$iv$iv = new JsonObject();
        JsonObject builder$iv$iv = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv);
        JsonObjectBuilder.kv-impl(builder$iv$iv, "f_source", String.valueOf(this$0.getContainerRenderData().getFSource()));
        JsonObjectBuilder.kv-impl(builder$iv$iv, "from", this$0.getContainerRenderData().getFrom());
        JsonObjectBuilder.kv-impl(builder$iv$iv, "from_id", this$0.getContainerRenderData().getFromId());
        JsonObjectBuilder.kv-impl(builder$iv$iv, "is_huixingka", "1");
        Unit unit2 = Unit.INSTANCE;
        String uri = buildUpon.appendQueryParameter("report_params", GsonKt.toJsonString(builder$iv$iv)).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        BLRouter.routeTo(new RouteRequest.Builder(uri).build(), this$0.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$3(DLCCardDetailView this$0, View it) {
        this$0.showTopMenu(!this$0.mShowTopMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$4(DigitalFromType $type, DLCCardDetailView this$0, DigitalCardDetailContainerRenderData $data, View it) {
        String it2;
        String it3;
        CardRightShow cardRightShow;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        switch (WhenMappings.$EnumSwitchMapping$0[$type.ordinal()]) {
            case 1:
            case 2:
            case 3:
                Integer cardMaterialType = this$0.getCardMaterialType();
                boolean z = false;
                if (cardMaterialType != null && cardMaterialType.intValue() == 1) {
                    if (this$0.isMe() && Intrinsics.areEqual(this$0.getCardHasGained(), true) && $type != DigitalFromType.SCAN) {
                        if (this$0.mShowBottomMenu) {
                            return;
                        }
                        Pair<CardRightShow, CardRight> cardLimitInfo = this$0.getCardLimitInfo();
                        if ((cardLimitInfo == null || (cardRightShow3 = (CardRightShow) cardLimitInfo.getFirst()) == null || !DLCConstUtilKt.forbiddenUse(cardRightShow3)) ? false : true) {
                            Pair<CardRightShow, CardRight> cardLimitInfo2 = this$0.getCardLimitInfo();
                            if ((cardLimitInfo2 == null || (cardRightShow2 = (CardRightShow) cardLimitInfo2.getFirst()) == null || !DLCConstUtilKt.hasUseToast(cardRightShow2)) ? false : true) {
                                Activity activity = this$0.context;
                                Pair<CardRightShow, CardRight> cardLimitInfo3 = this$0.getCardLimitInfo();
                                ToastHelper.showToast(activity, (cardLimitInfo3 == null || (cardRightShow = (CardRightShow) cardLimitInfo3.getFirst()) == null) ? null : cardRightShow.getUseToast(), 0);
                                return;
                            }
                        }
                        this$0.showBottomMenu(true);
                        return;
                    } else if (!this$0.isMe() || $type == DigitalFromType.SCAN) {
                        String it4 = $data.getActHomepageurl();
                        if (it4 != null) {
                            SpaceNftUtils.INSTANCE.routeTo(it4, this$0.context);
                            this$0.closeContainer();
                            return;
                        }
                        return;
                    } else {
                        String it5 = $data.getHolderListUrl();
                        if (it5 != null) {
                            SpaceNftUtils.INSTANCE.routeWithMap(it5, this$0.buildParam(), this$0.context);
                            this$0.closeContainer();
                            return;
                        }
                        return;
                    }
                }
                Integer cardMaterialType2 = this$0.getCardMaterialType();
                if (cardMaterialType2 != null && cardMaterialType2.intValue() == 2) {
                    if (this$0.isMe()) {
                        DigitalCardDetailRenderData renderData = $data.getRenderData();
                        if (renderData != null && renderData.getHasGained()) {
                            z = true;
                        }
                        if (z) {
                            String it6 = $data.getGarbApplyUrl();
                            if (it6 != null) {
                                SpaceNftUtils.INSTANCE.routeTo(it6, this$0.context);
                                this$0.closeContainer();
                                return;
                            }
                            return;
                        }
                    }
                    if (!this$0.isMe() && (it3 = $data.getActHomepageurl()) != null) {
                        SpaceNftUtils.INSTANCE.routeTo(it3, this$0.context);
                        this$0.closeContainer();
                        return;
                    }
                    return;
                }
                Integer cardMaterialType3 = this$0.getCardMaterialType();
                if (cardMaterialType3 != null && cardMaterialType3.intValue() == 3) {
                    if (this$0.isMe()) {
                        DigitalCardDetailRenderData renderData2 = $data.getRenderData();
                        if (renderData2 != null && renderData2.getHasGained()) {
                            z = true;
                        }
                        if (z) {
                            String it7 = $data.getGarbApplyUrl();
                            if (it7 != null) {
                                SpaceNftUtils.INSTANCE.routeTo(it7, this$0.context);
                                this$0.closeContainer();
                                return;
                            }
                            return;
                        }
                    }
                    if (!this$0.isMe() && (it2 = $data.getActHomepageurl()) != null) {
                        SpaceNftUtils.INSTANCE.routeTo(it2, this$0.context);
                        this$0.closeContainer();
                        return;
                    }
                    return;
                }
                Integer cardMaterialType4 = this$0.getCardMaterialType();
                if (cardMaterialType4 != null && cardMaterialType4.intValue() == 4) {
                    if (this$0.isMe()) {
                        DigitalCardDetailRenderData renderData3 = $data.getRenderData();
                        if (renderData3 != null && renderData3.getHasGained()) {
                            z = true;
                        }
                        if (z) {
                            String it8 = $data.getGarbApplyUrl();
                            if (it8 != null) {
                                SpaceNftUtils.INSTANCE.routeTo(it8, this$0.context);
                                this$0.closeContainer();
                                return;
                            }
                            return;
                        }
                    }
                    if (!this$0.isMe()) {
                        String it9 = $data.getActHomepageurl();
                        if (it9 != null) {
                            SpaceNftUtils.INSTANCE.routeTo(it9, this$0.context);
                            this$0.closeContainer();
                            return;
                        }
                        return;
                    }
                    String it10 = $data.getGarbSuitUrl();
                    if (it10 != null) {
                        Map map = new LinkedHashMap();
                        map.put("act_id", String.valueOf(this$0.getActivityId()));
                        String it11 = this$0.getRedeemItemId();
                        if (it11 != null) {
                            map.put("id", it11);
                        }
                        SpaceNftUtils.INSTANCE.routeWithMap(it10, map, this$0.context);
                        this$0.closeContainer();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void setShareData(DigitalFromType shareType, DLCCardShareModel shareModel) {
        this.shareType = shareType;
        this.shareModel = shareModel;
    }

    private final void handleShareData(DigitalFromType fromType) {
        byte[] bArr;
        this.shareType = fromType;
        List list = new ArrayList();
        String valueOf = String.valueOf(getCardId());
        Integer cardMaterialType = getCardMaterialType();
        String valueOf2 = String.valueOf(cardMaterialType != null ? cardMaterialType.intValue() : 1);
        String valueOf3 = String.valueOf(getCardTypeId());
        String cardImgUrl = getCardImgUrl();
        String cardName = getCardName();
        String str = cardName == null ? "" : cardName;
        String jSONString = JSON.toJSONString(getTagInfo());
        if (jSONString != null) {
            bArr = jSONString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "getBytes(...)");
        } else {
            bArr = null;
        }
        String encodeToString = Base64.encodeToString(bArr, 2);
        String str2 = encodeToString == null ? "" : encodeToString;
        String leftTopTagImg = getLeftTopTagImg();
        String str3 = leftTopTagImg == null ? "" : leftTopTagImg;
        String frameImg = getFrameImg();
        list.add(new CardShareInfo(cardImgUrl, str, str2, valueOf, valueOf3, valueOf2, str3, frameImg == null ? "" : frameImg, null, BR.hallEnterHotText, null));
        long activityId = getActivityId();
        Integer cardShareType = getCardShareType();
        this.shareModel = new DLCCardShareModel(activityId, cardShareType != null ? cardShareType.intValue() : 0, CollectionsKt.toList(list));
    }

    public final DLCCardShareModel getShareModel() {
        return this.shareModel;
    }

    public final void setShareModel(DLCCardShareModel dLCCardShareModel) {
        this.shareModel = dLCCardShareModel;
    }

    private final void refreshTopMenuUI() {
        DLCCardMenuButtonList dLCCardMenuButtonList = this.mTopMenu;
        if (dLCCardMenuButtonList != null) {
            View view = this.mTopContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopContainer");
                view = null;
            }
            dLCCardMenuButtonList.refreshMenu((ViewGroup) view.findViewById(tv.danmaku.bili.R.id.iv_dlc_card_menu_list));
        }
    }

    private final void refreshBottomMenuUI() {
        DLCCardBotttomMenuList dLCCardBotttomMenuList = this.mBottomMenu;
        if (dLCCardBotttomMenuList != null) {
            dLCCardBotttomMenuList.refreshButton();
        }
    }

    private final void openTopMenu() {
        DLCCardMenuButtonList dLCCardMenuButtonList = this.mTopMenu;
        if (dLCCardMenuButtonList != null) {
            dLCCardMenuButtonList.open();
        }
    }

    private final void openBottomMenu() {
        DLCCardBotttomMenuList dLCCardBotttomMenuList = this.mBottomMenu;
        if (dLCCardBotttomMenuList != null) {
            dLCCardBotttomMenuList.open();
        }
    }

    private final void closeTopMenu() {
        DLCCardMenuButtonList dLCCardMenuButtonList = this.mTopMenu;
        if (dLCCardMenuButtonList != null) {
            dLCCardMenuButtonList.close();
        }
    }

    private final void closeBottomMenu() {
        DLCCardBotttomMenuList dLCCardBotttomMenuList = this.mBottomMenu;
        if (dLCCardBotttomMenuList != null) {
            dLCCardBotttomMenuList.close();
        }
    }

    private final void initTopMenu(ViewGroup menu, DigitalFromType fromType, long mid) {
        this.mTopMenu = new DLCCardMenuButtonList(this.context, mid);
        DLCCardMenuButtonList dLCCardMenuButtonList = this.mTopMenu;
        Intrinsics.checkNotNull(dLCCardMenuButtonList);
        dLCCardMenuButtonList.init(menu, fromType, this.topMenuCallback);
    }

    private final void initBottomMenu(ViewGroup menu, DigitalFromType fromType, long mid) {
        this.mImageUploadHelper = new AuthorImageUploadHelper(this.context, this.mUploadStateInterface);
        this.mBottomMenu = new DLCCardBotttomMenuList(this.context, mid, this.splashSettingNoticeDialogService);
        DLCCardBotttomMenuList dLCCardBotttomMenuList = this.mBottomMenu;
        Intrinsics.checkNotNull(dLCCardBotttomMenuList);
        dLCCardBotttomMenuList.init(menu, fromType, this.bottomMenuCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void closeContainer() {
        DigitalJsCallHandler digitalJsCallHandler = this.handler;
        if (digitalJsCallHandler != null) {
            digitalJsCallHandler.toDismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri output;
        AuthorImageUploadHelper authorImageUploadHelper;
        if (resultCode == -1) {
            boolean z = true;
            switch (requestCode) {
                case 20:
                    if (data != null && (output = UCrop.getOutput(data)) != null && output.getPath() != null) {
                        int width = data.getIntExtra("com.yalantis.ucrop.ImageWidth", 0);
                        int height = data.getIntExtra("com.yalantis.ucrop.ImageHeight", 0);
                        int offsetX = data.getIntExtra("com.yalantis.ucrop.OffsetX", 0);
                        int offsetY = data.getIntExtra("com.yalantis.ucrop.OffsetY", 0);
                        int inSampleSize = data.getIntExtra("com.yalantis.ucrop.InSampleSize", 1);
                        final TintProgressDialog progressDialog = TintProgressDialog.show(this.context, (CharSequence) null, "正在提交...", true);
                        BiliNftAvatarUploader.Companion.uploadAvatar(this.context, width * inSampleSize, height * inSampleSize, offsetX * inSampleSize, offsetY * inSampleSize, getCardId(), new BiliNftAvatarUploader.UploadCallback() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCCardDetailView$onActivityResult$1$1$1
                            @Override // tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader.UploadCallback
                            public void onUploadSuccess() {
                                BLog.i("NftCardDialog", "更换头像成功 onUploadSuccess");
                                progressDialog.dismiss();
                                ToastHelper.showToastShort(this.getContext(), "更换头像成功");
                            }

                            @Override // tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader.UploadCallback
                            public void onUploadFailed(int code, String msg) {
                                BLog.e("NftCardDialog", "更换头像失败 onUploadFailed");
                                progressDialog.dismiss();
                                ToastHelper.showToastShort(this.getContext(), msg);
                            }
                        });
                        return;
                    }
                    return;
                case 1000:
                    ArrayList medias = Boxing.getResult(data);
                    ArrayList arrayList = medias;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z = false;
                    }
                    if (z || (authorImageUploadHelper = this.mImageUploadHelper) == null) {
                        return;
                    }
                    authorImageUploadHelper.uploadPicture((BaseMedia) medias.get(0));
                    return;
                default:
                    return;
            }
        }
    }

    private final boolean showUseTag(CardRightShow $this$showUseTag) {
        CardRightShow cardRightShow;
        if (showHeaderTag() || showAvatarTag()) {
            Pair<CardRightShow, CardRight> cardLimitInfo = getCardLimitInfo();
            return cardLimitInfo != null && (cardRightShow = (CardRightShow) cardLimitInfo.getFirst()) != null && DLCConstUtilKt.hasUseImgUrl(cardRightShow);
        }
        return false;
    }

    private final boolean showHeaderTag() {
        CardRightShow cardRightShow;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        Pair<CardRightShow, CardRight> cardLimitInfo = getCardLimitInfo();
        if ((cardLimitInfo == null || (cardRightShow2 = (CardRightShow) cardLimitInfo.getFirst()) == null || !DLCConstUtilKt.isHeaderValid(cardRightShow2)) ? false : true) {
            Pair<CardRightShow, CardRight> cardLimitInfo2 = getCardLimitInfo();
            if ((cardLimitInfo2 == null || (cardRight = (CardRight) cardLimitInfo2.getSecond()) == null || !DLCConstUtilKt.isLimitedHeader(cardRight)) ? false : true) {
                Pair<CardRightShow, CardRight> cardLimitInfo3 = getCardLimitInfo();
                if ((cardLimitInfo3 == null || (cardRightShow = (CardRightShow) cardLimitInfo3.getFirst()) == null || !DLCConstUtilKt.hasHeaderImgUrl(cardRightShow)) ? false : true) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean showAvatarTag() {
        CardRightShow cardRightShow;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        Pair<CardRightShow, CardRight> cardLimitInfo = getCardLimitInfo();
        if ((cardLimitInfo == null || (cardRightShow2 = (CardRightShow) cardLimitInfo.getFirst()) == null || !DLCConstUtilKt.isAvatarValid(cardRightShow2)) ? false : true) {
            Pair<CardRightShow, CardRight> cardLimitInfo2 = getCardLimitInfo();
            if ((cardLimitInfo2 == null || (cardRight = (CardRight) cardLimitInfo2.getSecond()) == null || !DLCConstUtilKt.isLimitedAvatar(cardRight)) ? false : true) {
                Pair<CardRightShow, CardRight> cardLimitInfo3 = getCardLimitInfo();
                if ((cardLimitInfo3 == null || (cardRightShow = (CardRightShow) cardLimitInfo3.getFirst()) == null || !DLCConstUtilKt.hasAvatarImgUrl(cardRightShow)) ? false : true) {
                    return true;
                }
            }
        }
        return false;
    }
}