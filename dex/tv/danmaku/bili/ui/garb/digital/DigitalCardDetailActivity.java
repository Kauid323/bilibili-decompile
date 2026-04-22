package tv.danmaku.bili.ui.garb.digital;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarChooser;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarUploader;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.digital.PageInfo;
import com.bilibili.digital.card.DigitalPageFragment;
import com.bilibili.digital.card.depercated.DLCPlayModel;
import com.bilibili.digital.card.depercated.DLCTagModel;
import com.bilibili.digital.card.depercated.DigitalCardDetail;
import com.bilibili.digital.card.page.card.cardmodule.web.WebCard;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.DigitalCardDetail;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseView;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;

/* compiled from: DigitalCardDetailActivity.kt */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001*\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\"\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020*8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "mid", "", "cardId", "useScene", "", "isMe", "", "playerManager", "Lcom/bili/digital/common/player/DigitalCardPlayerManager;", "previewView", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "getPreviewView", "()Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseView;", "previewView$delegate", "Lkotlin/Lazy;", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "routerInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "useNew", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "onPostCreate", NftCardJsBridgeCallHandler.GET_EXTRA, "parseRouteInfo", "args", "initViews", "loadDetailApi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "mUploadCallback", "tv/danmaku/bili/ui/garb/digital/DigitalCardDetailActivity$mUploadCallback$1", "Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailActivity$mUploadCallback$1;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailActivity extends BaseAppCompatActivity {
    public static final String KEY_EXTRA_BUNDLE = "digital_key_extra_bundle";
    public static final String KEY_PARAMS = "digital_detail_info";
    private long cardId;
    private long mid;
    private ConstraintLayout rootView;
    private DigitalCardDetailRouterInfo routerInfo;
    private final boolean useNew;
    private int useScene;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private boolean isMe = true;
    private final DigitalCardPlayerManager playerManager = DigitalCardPlayerManager.Companion.buildManager$default(DigitalCardPlayerManager.Companion, (Fragment) null, (FragmentActivity) this, true, 1, (Object) null);
    private final Lazy previewView$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$$ExternalSyntheticLambda0
        public final Object invoke() {
            DigitalCardDetailPreviewView previewView_delegate$lambda$0;
            previewView_delegate$lambda$0 = DigitalCardDetailActivity.previewView_delegate$lambda$0(DigitalCardDetailActivity.this);
            return previewView_delegate$lambda$0;
        }
    });
    private final DigitalCardDetailActivity$mUploadCallback$1 mUploadCallback = new DigitalCardDetailActivity$mUploadCallback$1(this);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DigitalCardDetailBaseView getPreviewView() {
        return (DigitalCardDetailBaseView) this.previewView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DigitalCardDetailPreviewView previewView_delegate$lambda$0(DigitalCardDetailActivity this$0) {
        return new DigitalCardDetailPreviewView(this$0, this$0.mUploadCallback, this$0.playerManager);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.useNew) {
            setContentView(getPreviewView().resId());
            initViews();
        }
        getExtra();
        loadDetailApi();
    }

    protected void onResume() {
        super.onResume();
        getPreviewView().onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        getPreviewView().onDestroy();
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText);
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(-16777216);
    }

    private final void getExtra() {
        Bundle extras = getIntent().getExtras();
        Object bundle = extras != null ? extras.get(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE) : null;
        if (bundle instanceof Bundle) {
            this.routerInfo = parseRouteInfo((Bundle) bundle);
            DigitalCardDetailRouterInfo it = this.routerInfo;
            if (it != null) {
                this.mid = it.getMid();
                this.cardId = it.getCardId();
                this.useScene = it.getUseScene();
                this.isMe = it.isMe();
            }
        }
    }

    private final DigitalCardDetailRouterInfo parseRouteInfo(Bundle args) {
        int useScene = args.getInt("useScene", 0);
        long mid = args.getLong("mid", 0L);
        long cardId = args.getLong("cardId", 0L);
        String pendantTitle = args.getString("pendantTitle", "");
        String pendantUrl = args.getString("pendantUrl", "");
        String digitalText = args.getString("digitalText", "");
        boolean showDigital = args.getBoolean("showDigital", false);
        boolean isMe = args.getBoolean("isMe", true);
        boolean showArchiveEntrance = args.getBoolean("showArchiveEntrance", false);
        return new DigitalCardDetailRouterInfo(useScene, mid, cardId, pendantTitle, pendantUrl, digitalText, showDigital, isMe, showArchiveEntrance);
    }

    private final void initViews() {
        ConstraintLayout findViewById = findViewById(R.id.nft_cards_rootview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.rootView = findViewById;
        DigitalCardDetailBaseView previewView = getPreviewView();
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            constraintLayout = null;
        }
        previewView.initViews((ViewGroup) constraintLayout);
    }

    private final void loadDetailApi() {
        Long t_mid;
        Long t_vmid;
        Long.valueOf(0L);
        Long.valueOf(0L);
        if (this.isMe) {
            t_mid = Long.valueOf(this.mid);
            t_vmid = null;
        } else {
            t_mid = null;
            t_vmid = Long.valueOf(this.mid);
        }
        BiliNftApiManager.INSTANCE.detail(t_mid, t_vmid, this.cardId, this.useScene, new BiliApiDataCallback<DigitalCardDetail>() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$loadDetailApi$1
            public void onError(Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r8v1, types: [tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$lambda$0$$inlined$parseJson$1] */
            public void onDataSuccess(DigitalCardDetail data) {
                boolean z;
                DigitalCardDetailBaseView previewView;
                ViewGroup viewGroup;
                DigitalCardDetailRouterInfo digitalCardDetailRouterInfo;
                DigitalCardDetailRouterInfo info;
                if (!DigitalCardDetailActivity.this.isFinishing() && !DigitalCardDetailActivity.this.isDestroyed() && data != null) {
                    DigitalCardDetailActivity digitalCardDetailActivity = DigitalCardDetailActivity.this;
                    z = digitalCardDetailActivity.useNew;
                    ViewGroup viewGroup2 = null;
                    if (!z) {
                        previewView = digitalCardDetailActivity.getPreviewView();
                        viewGroup = digitalCardDetailActivity.rootView;
                        if (viewGroup == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rootView");
                        } else {
                            viewGroup2 = viewGroup;
                        }
                        DigitalFromType digitalFromType = DigitalFromType.DETAIL;
                        DigitalCardDetailContainerRenderData digitalCardDetailContainerRenderData = new DigitalCardDetailContainerRenderData(data);
                        digitalCardDetailRouterInfo = digitalCardDetailActivity.routerInfo;
                        DigitalCardDetailBaseView.initData$default(previewView, viewGroup2, digitalFromType, digitalCardDetailContainerRenderData, digitalCardDetailRouterInfo, null, 0, false, false, 0, BR.rightBottomBadgeUrl, null);
                        return;
                    }
                    String $this$parseJson$iv = GsonKt.toJsonString(data);
                    Type type = new TypeToken<com.bilibili.digital.card.depercated.DigitalCardDetail>() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$lambda$0$$inlined$parseJson$1
                    }.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    Object cardDetail = JsonUtilKt.parseJson($this$parseJson$iv, type);
                    info = digitalCardDetailActivity.routerInfo;
                    if (info != null) {
                        cardDetail = com.bilibili.digital.card.depercated.DigitalCardDetail.copy$default((com.bilibili.digital.card.depercated.DigitalCardDetail) cardDetail, 0L, 0L, 0, 0, (String) null, 0L, (String) null, 0L, 0, (String) null, (String) null, (ArrayList) null, false, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, (String) null, false, (DLCPlayModel) null, (WebCard) null, (DLCTagModel) null, new DigitalCardDetail.RouterInfo(info.getUseScene(), info.getMid(), info.getPendantUrl(), info.getDigitalText(), info.getShowDigital()), -1, 1, (Object) null);
                    }
                    Fragment digitalPageFragment = new DigitalPageFragment();
                    digitalPageFragment.getPageJsonFlow().setValue(new PageInfo(GsonKt.toJsonString(cardDetail), "collectionAvatarDetails"));
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) digitalPageFragment), (CoroutineContext) null, (CoroutineStart) null, new DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1(digitalPageFragment, digitalCardDetailActivity, null), 3, (Object) null);
                    digitalCardDetailActivity.getSupportFragmentManager().beginTransaction().add(16908290, digitalPageFragment).commit();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 1001:
                    AvatarUploader.Companion.uploadAvatar(AvatarChooser.PhotoSource.TAKE, (Uri) null, this.mUploadCallback);
                    return;
                case 1002:
                    ArrayList result = Boxing.getResult(data);
                    if (result == null || result.isEmpty()) {
                        return;
                    }
                    Object obj = result.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bilibili.boxing.model.entity.impl.ImageMedia");
                    ImageMedia cropMedia = (ImageMedia) obj;
                    AvatarUploader.Companion.uploadAvatar(AvatarChooser.PhotoSource.CHOOSE, cropMedia.getImageUri(), this.mUploadCallback);
                    return;
                case 1017:
                    setResult(-1);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: DigitalCardDetailActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailActivity$Companion;", "", "<init>", "()V", "KEY_PARAMS", "", "KEY_EXTRA_BUNDLE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}