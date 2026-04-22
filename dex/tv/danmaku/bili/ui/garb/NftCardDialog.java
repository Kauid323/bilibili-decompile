package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bili.resource.space.R;
import com.bilibili.app.authorspace.ui.AuthorImageUploadHelper;
import com.bilibili.app.authorspace.ui.nft.utils.NftCardClipper;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.projection.internal.base.BaseProjectionDialogFragment;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import com.yalantis.ucrop.UCrop;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.FromType;
import tv.danmaku.bili.ui.garb.NftCardInfoGroup;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader;
import tv.danmaku.bili.ui.garb.api.BiliNftTransfer;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.NftReporterHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;

/* compiled from: NftCardDialog.kt */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u00019\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0014J\"\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u00020!H\u0016J\b\u00102\u001a\u00020!H\u0016J\b\u00103\u001a\u00020!H\u0016J\"\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u000107H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006<"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardDialog;", "Lcom/bilibili/lib/projection/internal/base/BaseProjectionDialogFragment;", "mNftCardModel", "Ltv/danmaku/bili/ui/garb/NftCardModel;", "mNftCardJsbCb", "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "<init>", "(Ltv/danmaku/bili/ui/garb/NftCardModel;Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;)V", "()V", "mFromType", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "mImageUploadHelper", "Lcom/bilibili/app/authorspace/ui/AuthorImageUploadHelper;", "mCloseBtn", "Landroid/view/View;", "mCardMp4Player", "Lcom/bilibili/bililive/uam/view/UAMView;", "mCardMp4Player2", "mCardNftButtonList", "Ltv/danmaku/bili/ui/garb/NftCardMenuButtonList;", "mCardInfoGroup", "Ltv/danmaku/bili/ui/garb/NftCardInfoGroup;", "mMid", "", "mIsMe", "", "mSpaceFromType", "Ltv/danmaku/bili/ui/garb/FromType;", "mNftInfoUrl", "", "getDialogViewRes", "", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initView", "initCardLayoutGroup", "ctx", "Landroid/content/Context;", "data", "refreshMenuListUI", "initMenuButtonList", "onStart", "compatDialogLayout", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "dismiss", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "mUploadStateInterface", "tv/danmaku/bili/ui/garb/NftCardDialog$mUploadStateInterface$1", "Ltv/danmaku/bili/ui/garb/NftCardDialog$mUploadStateInterface$1;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardDialog extends BaseProjectionDialogFragment {
    private static final int IMAGE_UPLOAD_CODE = 1000;
    private static final String KEY_FROM_TYPE = "from_type";
    public static final String NFT_INFO_URL = "https://alpha.upowerchain.com/tx/";
    public static final String TAG = "NftCardDialog";
    private NftCardInfoGroup mCardInfoGroup;
    private UAMView mCardMp4Player;
    private UAMView mCardMp4Player2;
    private NftCardMenuButtonList mCardNftButtonList;
    private View mCloseBtn;
    private NftCardFromType mFromType;
    private AuthorImageUploadHelper mImageUploadHelper;
    private boolean mIsMe;
    private long mMid;
    private final NftCardJsbCallback mNftCardJsbCb;
    private final NftCardModel mNftCardModel;
    private String mNftInfoUrl;
    private FromType mSpaceFromType;
    private final NftCardDialog$mUploadStateInterface$1 mUploadStateInterface;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.ui.garb.NftCardDialog$mUploadStateInterface$1] */
    public NftCardDialog(NftCardModel mNftCardModel, NftCardJsbCallback mNftCardJsbCb) {
        this.mNftCardModel = mNftCardModel;
        this.mNftCardJsbCb = mNftCardJsbCb;
        this.mFromType = NftCardFromType.SEE;
        this.mSpaceFromType = FromType.UNKNOWN;
        this.mNftInfoUrl = NFT_INFO_URL;
        this.mUploadStateInterface = new AuthorImageUploadHelper.IUploadStateInterface() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$mUploadStateInterface$1
            public void onCachePathInavailable() {
                BLog.e("NftCardDialog", "外部存储不可用");
                ToastHelper.showToastShort(NftCardDialog.this.getActivity(), NftCardDialog.this.getResources().getString(R.string.space_global_string_125));
            }

            public void onCompressFailed() {
                BLog.e("NftCardDialog", "图片压缩失败");
                ToastHelper.showToastShort(NftCardDialog.this.getActivity(), NftCardDialog.this.getResources().getString(bili.resource.following.R.string.following_global_string_752));
            }

            public void onUploadStart() {
            }

            public void onUploadSuccess(String url) {
            }

            public void onUploadFailed() {
                BLog.e("NftCardDialog", "图片上传失败");
                ToastHelper.showToastShort(NftCardDialog.this.getActivity(), NftCardDialog.this.getResources().getString(R.string.space_global_string_237));
            }

            public void onNotVerify(int responseCode, String message) {
            }
        };
    }

    public NftCardDialog() {
        this(null, null);
    }

    /* compiled from: NftCardDialog.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardDialog$Companion;", "", "<init>", "()V", "TAG", "", "KEY_FROM_TYPE", "IMAGE_UPLOAD_CODE", "", "NFT_INFO_URL", ReportEvent.EVENT_TYPE_SHOW, "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "model", "Ltv/danmaku/bili/ui/garb/NftCardModel;", "cb", "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Activity activity, NftCardModel nftCardModel, NftCardJsbCallback nftCardJsbCallback, int i, Object obj) {
            if ((i & 4) != 0) {
                nftCardJsbCallback = null;
            }
            companion.show(activity, nftCardModel, nftCardJsbCallback);
        }

        public final void show(Activity activity, NftCardModel model, NftCardJsbCallback cb) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            if (!activity.isFinishing() && !activity.isDestroyed() && (activity instanceof FragmentActivity)) {
                FragmentManager fm = ((FragmentActivity) activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(fm, "getSupportFragmentManager(...)");
                BaseProjectionDialogFragment fragment = fm.findFragmentByTag("NftCardDialog");
                if (fragment == null) {
                    fragment = (Fragment) new NftCardDialog(model, cb);
                }
                if ((fragment instanceof BaseProjectionDialogFragment) && !fragment.isAdded()) {
                    BLog.i("NftCardDialog", "展示集卡详情页");
                    fragment.showNow(fm, "NftCardDialog");
                }
            }
        }
    }

    protected int getDialogViewRes() {
        return tv.danmaku.bili.R.layout.bili_app_dialog_nft_card;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog $this$onViewCreated_u24lambda_u240 = getDialog();
        if ($this$onViewCreated_u24lambda_u240 != null) {
            $this$onViewCreated_u24lambda_u240.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NftCardDialog.onViewCreated$lambda$0$0(NftCardDialog.this, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0(NftCardDialog this$0, DialogInterface it) {
        BLog.d("NftCardDialog", "onDismiss, just notify");
        NftCardJsbCallback nftCardJsbCallback = this$0.mNftCardJsbCb;
        if (nftCardJsbCallback != null) {
            nftCardJsbCallback.toDismissDialog();
        }
        super.onDismiss(it);
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [tv.danmaku.bili.ui.garb.NftCardDialog$initView$$inlined$parseJson$1] */
    protected void initView(View view) {
        HashMap<String, String> extraMap;
        String str;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(view, "view");
        Context ctx = getContext();
        if (ctx == null) {
            return;
        }
        this.mNftInfoUrl = ConfigManager.Companion.getConfig("increment.nft_block_chain", NFT_INFO_URL);
        BLog.i("NftCardDialog", "get config " + this.mNftInfoUrl);
        NftCardModel nftCardModel = this.mNftCardModel;
        if (nftCardModel != null) {
            int it = nftCardModel.getType();
            this.mFromType = NftCardFromType.Companion.toType(it);
        }
        NftCardModel nftCardModel2 = this.mNftCardModel;
        this.mMid = nftCardModel2 != null ? nftCardModel2.getMid() : 0L;
        View view2 = null;
        try {
            NftCardModel nftCardModel3 = this.mNftCardModel;
            String extraString = Uri.decode(nftCardModel3 != null ? nftCardModel3.getExtra() : null);
            if (extraString == null) {
                hashMap = null;
            } else {
                Type type = new TypeToken<HashMap<String, String>>() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$initView$$inlined$parseJson$1
                }.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                hashMap = (HashMap) JsonUtilKt.parseJson(extraString, type);
            }
            HashMap jsonMap = hashMap;
            NftCardModel nftCardModel4 = this.mNftCardModel;
            if (nftCardModel4 != null) {
                nftCardModel4.setExtraMap(jsonMap);
            }
            BLog.i("NftCardDialog", "parse extra succeed, fromType " + (jsonMap != null ? jsonMap.get(KEY_FROM_TYPE) : null));
        } catch (Throwable e) {
            BLog.e("NftCardDialog", "parse extra error " + e.getMessage());
        }
        int i = 0;
        this.mIsMe = this.mMid == BiliAccounts.get(ctx).mid();
        FromType.Companion companion = FromType.Companion;
        NftCardModel nftCardModel5 = this.mNftCardModel;
        if (nftCardModel5 != null && (extraMap = nftCardModel5.getExtraMap()) != null && (str = extraMap.get(KEY_FROM_TYPE)) != null) {
            i = Integer.parseInt(str);
        }
        this.mSpaceFromType = companion.toType(i);
        View findViewById = view.findViewById(tv.danmaku.bili.R.id.nft_card_bottom_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCloseBtn = findViewById;
        UAMView findViewById2 = view.findViewById(tv.danmaku.bili.R.id.nft_card_mp4_player);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mCardMp4Player = findViewById2;
        UAMView findViewById3 = view.findViewById(tv.danmaku.bili.R.id.nft_card_mp4_player_2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mCardMp4Player2 = findViewById3;
        View view3 = this.mCloseBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                NftCardDialog.initView$lambda$1(NftCardDialog.this, view4);
            }
        });
        initCardLayoutGroup(ctx, view, this.mNftCardModel);
        initMenuButtonList(view);
        view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                NftCardDialog.initView$lambda$2(NftCardDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(NftCardDialog this$0, View it) {
        String fSource;
        NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
        NftCardModel nftCardModel = this$0.mNftCardModel;
        int actId = nftCardModel != null ? nftCardModel.getActId() : 0;
        NftCardInfoGroup nftCardInfoGroup = this$0.mCardInfoGroup;
        if (nftCardInfoGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
            nftCardInfoGroup = null;
        }
        long currentCardTypeId = nftCardInfoGroup.getCurrentCardTypeId();
        NftCardModel nftCardModel2 = this$0.mNftCardModel;
        String str = "";
        String str2 = (nftCardModel2 == null || (str2 = nftCardModel2.getFromWhere()) == null) ? "" : "";
        NftCardModel nftCardModel3 = this$0.mNftCardModel;
        String str3 = (nftCardModel3 == null || (str3 = nftCardModel3.getFromId()) == null) ? "" : "";
        NftCardModel nftCardModel4 = this$0.mNftCardModel;
        if (nftCardModel4 != null && (fSource = nftCardModel4.getFSource()) != null) {
            str = fSource;
        }
        long j = this$0.mMid;
        NftCardModel nftCardModel5 = this$0.mNftCardModel;
        nftReporterHelper.reportNftCardBottomButtonClick(actId, currentCardTypeId, str2, str3, str, 4, j, nftCardModel5 != null ? nftCardModel5.getSourceType() : 0);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(NftCardDialog this$0, View it) {
        NftCardInfoGroup nftCardInfoGroup = this$0.mCardInfoGroup;
        if (nftCardInfoGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
            nftCardInfoGroup = null;
        }
        nftCardInfoGroup.showMenu(false);
    }

    private final void initCardLayoutGroup(Context ctx, View view, NftCardModel data) {
        this.mCardInfoGroup = new NftCardInfoGroup((Fragment) this, view, NftCardFromType.Companion.toType(data != null ? data.getType() : NftCardFromType.SEE.getType()), this.mIsMe || this.mSpaceFromType == FromType.AVATAR, new NftCardInfoGroup.OnCardItemChangeListener() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$initCardLayoutGroup$1
            @Override // tv.danmaku.bili.ui.garb.NftCardInfoGroup.OnCardItemChangeListener
            public void onItemChanged() {
                NftCardDialog.this.refreshMenuListUI();
            }
        }, new NftCardJsbCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$initCardLayoutGroup$2
            @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
            public void toHolderList(long cardTypeId, long cardId, int actId) {
                NftCardJsbCallback nftCardJsbCallback;
                NftCardDialog.this.dismiss();
                nftCardJsbCallback = NftCardDialog.this.mNftCardJsbCb;
                if (nftCardJsbCallback != null) {
                    nftCardJsbCallback.toHolderList(cardTypeId, cardId, actId);
                }
            }

            @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
            public void toShare(long cardTypeId, long cardId, int actId) {
                NftCardJsbCallback nftCardJsbCallback;
                NftCardDialog.this.dismiss();
                nftCardJsbCallback = NftCardDialog.this.mNftCardJsbCb;
                if (nftCardJsbCallback != null) {
                    nftCardJsbCallback.toShare(cardTypeId, cardId, actId);
                }
            }

            @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
            public void toDrawAgain() {
                NftCardJsbCallback nftCardJsbCallback;
                NftCardDialog.this.dismiss();
                nftCardJsbCallback = NftCardDialog.this.mNftCardJsbCb;
                if (nftCardJsbCallback != null) {
                    nftCardJsbCallback.toDrawAgain();
                }
            }

            @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
            public void toDismissDialog() {
                NftCardDialog.this.dismiss();
            }
        });
        NftCardInfoGroup nftCardInfoGroup = this.mCardInfoGroup;
        if (nftCardInfoGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
            nftCardInfoGroup = null;
        }
        nftCardInfoGroup.init(ctx, view, data, this.mMid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshMenuListUI() {
        if (this.mCardNftButtonList != null) {
            NftCardMenuButtonList nftCardMenuButtonList = this.mCardNftButtonList;
            if (nftCardMenuButtonList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardNftButtonList");
                nftCardMenuButtonList = null;
            }
            nftCardMenuButtonList.refreshButton();
            NftCardMenuButtonList nftCardMenuButtonList2 = this.mCardNftButtonList;
            if (nftCardMenuButtonList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardNftButtonList");
                nftCardMenuButtonList2 = null;
            }
            View view = getView();
            nftCardMenuButtonList2.refreshMenu(view != null ? (ViewGroup) view.findViewById(tv.danmaku.bili.R.id.nft_card_menu_list) : null);
        }
    }

    private final void initMenuButtonList(View view) {
        final Activity activity = getActivity();
        if (activity != null) {
            BLog.i("NftCardDialog", "initMenuButtonList");
            this.mImageUploadHelper = new AuthorImageUploadHelper(activity, this.mUploadStateInterface);
            NftCardModel nftCardModel = this.mNftCardModel;
            long j = this.mMid;
            NftCardModel nftCardModel2 = this.mNftCardModel;
            NftCardMenuButtonList nftCardMenuButtonList = null;
            this.mCardNftButtonList = new NftCardMenuButtonList(activity, nftCardModel, j, nftCardModel2 != null ? nftCardModel2.getExtraMap() : null);
            NftCardMenuButtonList nftCardMenuButtonList2 = this.mCardNftButtonList;
            if (nftCardMenuButtonList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardNftButtonList");
            } else {
                nftCardMenuButtonList = nftCardMenuButtonList2;
            }
            nftCardMenuButtonList.init((ViewGroup) view.findViewById(tv.danmaku.bili.R.id.nft_card_menu_list), this.mFromType, new MenuButtonCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$initMenuButtonList$1$1
                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void setAvatar() {
                    NftCardInfoGroup nftCardInfoGroup;
                    BLog.i("NftCardDialog", "set avatar");
                    NftCardClipper nftCardClipper = NftCardClipper.INSTANCE;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    nftCardClipper.startCropActivityWithAvatar(nftCardInfoGroup.getCurrentCardAvatarUrl(), NftCardDialog.this);
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void setHeader() {
                    NftCardModel nftCardModel3;
                    String url;
                    NftCardModel nftCardModel4;
                    NftCardInfoGroup nftCardInfoGroup;
                    BLog.i("NftCardDialog", "set header");
                    nftCardModel3 = NftCardDialog.this.mNftCardModel;
                    if (nftCardModel3 != null && (url = nftCardModel3.getSpaceBgSetUrl()) != null) {
                        NftCardDialog nftCardDialog = NftCardDialog.this;
                        nftCardDialog.dismiss();
                        Map map = new LinkedHashMap();
                        nftCardModel4 = nftCardDialog.mNftCardModel;
                        map.put("biz_id", String.valueOf(nftCardModel4 != null ? nftCardModel4.getActId() : 0));
                        map.put("biz_type", "2");
                        nftCardInfoGroup = nftCardDialog.mCardInfoGroup;
                        if (nftCardInfoGroup == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                            nftCardInfoGroup = null;
                        }
                        map.put("biz_item_id", String.valueOf(nftCardInfoGroup.getCurrentCardTypeId()));
                        SpaceNftUtils.INSTANCE.routeWithMap(url, map, nftCardDialog.getContext());
                    }
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public boolean hasNftInfo() {
                    NftCardInfoGroup nftCardInfoGroup;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    boolean result = !TextUtils.isEmpty(nftCardInfoGroup.getCurrentCardHash());
                    BLog.i("NftCardDialog", "has nft info " + result);
                    return result;
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void seeNftInfo() {
                    String str;
                    NftCardInfoGroup nftCardInfoGroup;
                    str = NftCardDialog.this.mNftInfoUrl;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    String url = str + nftCardInfoGroup.getCurrentCardHash();
                    BLog.i("NftCardDialog", "see nft info " + url);
                    SpaceNftUtils.INSTANCE.routeTo(url, NftCardDialog.this.getContext());
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void savePic() {
                    NftCardInfoGroup nftCardInfoGroup;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    String url = nftCardInfoGroup.getCurrentCardAvatarUrl();
                    BLog.i("NftCardDialog", "save pic " + url);
                    SpaceNftUtils.INSTANCE.savePic(url, activity);
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void giveOther() {
                    NftCardModel nftCardModel3;
                    NftCardInfoGroup nftCardInfoGroup;
                    BLog.i("NftCardDialog", "give other");
                    BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
                    nftCardModel3 = NftCardDialog.this.mNftCardModel;
                    int actId = nftCardModel3 != null ? nftCardModel3.getActId() : 0;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    long currentCardId = nftCardInfoGroup.getCurrentCardId();
                    final FragmentActivity fragmentActivity = activity;
                    final NftCardDialog nftCardDialog = NftCardDialog.this;
                    biliNftApiManager.transfer(actId, currentCardId, new BiliApiDataCallback<BiliNftTransfer>() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$initMenuButtonList$1$1$giveOther$1
                        public void onError(Throwable t) {
                            BLog.e("NftCardDialog", "转赠失败 onError: " + t);
                            ToastHelper.showToast(fragmentActivity, "系统异常，请稍后处理", 0);
                        }

                        public void onDataSuccess(BiliNftTransfer data) {
                            if (data != null) {
                                NftCardDialog nftCardDialog2 = nftCardDialog;
                                Activity activity2 = fragmentActivity;
                                if (data.getStatus() == 0) {
                                    BLog.i("NftCardDialog", "转赠成功 onDataSuccess: " + data);
                                    Uri parse = Uri.parse(data.getJumpUrl());
                                    Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                                    BLRouter.routeTo(RouteRequestKt.toRouteRequest(parse), nftCardDialog2.getContext());
                                    return;
                                }
                                BLog.e("NftCardDialog", "转赠失败弹窗");
                                NftCardPresentErrorCardDialog.Companion.show(activity2, data.getTitle(), data.getContentTemplate(), data.getHighlightParams());
                            }
                        }
                    });
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void dismissDialog() {
                    NftCardDialog.this.dismiss();
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public void dismissMenu() {
                    NftCardInfoGroup nftCardInfoGroup;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    nftCardInfoGroup.showMenu(false);
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public long getCurrentCardId() {
                    NftCardInfoGroup nftCardInfoGroup;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    return nftCardInfoGroup.getCurrentCardId();
                }

                @Override // tv.danmaku.bili.ui.garb.MenuButtonCallback
                public Pair<CardRightShow, CardRight> getLimitInfo() {
                    NftCardInfoGroup nftCardInfoGroup;
                    nftCardInfoGroup = NftCardDialog.this.mCardInfoGroup;
                    if (nftCardInfoGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        nftCardInfoGroup = null;
                    }
                    return nftCardInfoGroup.getLimitInfo();
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStart() {
        long cardTypeId;
        ArrayList<NftCardDetailModel> cardList;
        NftCardDetailModel nftCardDetailModel;
        boolean z;
        ArrayList<NftCardDetailModel> cardList2;
        NftCardDetailModel nftCardDetailModel2;
        ArrayList<NftCardDetailIdModel> cardIdList;
        String fSource;
        String fromId;
        String fromWhere;
        compatDialogLayout();
        super.onStart();
        NftCardModel nftCardModel = this.mNftCardModel;
        ArrayList<NftCardDetailModel> cardList3 = nftCardModel != null ? nftCardModel.getCardList() : null;
        long j = 0;
        if (cardList3 == null || cardList3.isEmpty()) {
            cardTypeId = 0;
        } else {
            NftCardModel nftCardModel2 = this.mNftCardModel;
            if (nftCardModel2 != null && (cardList = nftCardModel2.getCardList()) != null && (nftCardDetailModel = cardList.get(0)) != null) {
                j = nftCardDetailModel.getCardTypeId();
            }
            cardTypeId = j;
        }
        if (this.mFromType == NftCardFromType.SCAN) {
            NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
            NftCardModel nftCardModel3 = this.mNftCardModel;
            nftReporterHelper.reportNftCardScanPageExposure(nftCardModel3 != null ? nftCardModel3.getActId() : 0, cardTypeId, this.mMid);
            return;
        }
        NftReporterHelper nftReporterHelper2 = NftReporterHelper.INSTANCE;
        NftCardModel nftCardModel4 = this.mNftCardModel;
        int actId = nftCardModel4 != null ? nftCardModel4.getActId() : 0;
        NftCardModel nftCardModel5 = this.mNftCardModel;
        String str = (nftCardModel5 == null || (fromWhere = nftCardModel5.getFromWhere()) == null) ? "" : fromWhere;
        NftCardModel nftCardModel6 = this.mNftCardModel;
        String str2 = (nftCardModel6 == null || (fromId = nftCardModel6.getFromId()) == null) ? "" : fromId;
        NftCardModel nftCardModel7 = this.mNftCardModel;
        String str3 = (nftCardModel7 == null || (fSource = nftCardModel7.getFSource()) == null) ? "" : fSource;
        long j2 = this.mMid;
        NftCardModel nftCardModel8 = this.mNftCardModel;
        ArrayList<NftCardDetailModel> cardList4 = nftCardModel8 != null ? nftCardModel8.getCardList() : null;
        if (!(cardList4 == null || cardList4.isEmpty())) {
            NftCardModel nftCardModel9 = this.mNftCardModel;
            if (!((nftCardModel9 == null || (cardList2 = nftCardModel9.getCardList()) == null || (nftCardDetailModel2 = cardList2.get(0)) == null || (cardIdList = nftCardDetailModel2.getCardIdList()) == null) ? true : cardIdList.isEmpty())) {
                z = true;
                NftCardModel nftCardModel10 = this.mNftCardModel;
                nftReporterHelper2.reportNftCardExposure(actId, cardTypeId, str, str2, str3, j2, z, nftCardModel10 != null ? nftCardModel10.getSourceType() : 0);
            }
        }
        z = false;
        NftCardModel nftCardModel102 = this.mNftCardModel;
        nftReporterHelper2.reportNftCardExposure(actId, cardTypeId, str, str2, str3, j2, z, nftCardModel102 != null ? nftCardModel102.getSourceType() : 0);
    }

    private final void compatDialogLayout() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window != null ? window.getAttributes() : null;
        if (lp != null) {
            lp.width = -1;
        }
        if (lp != null) {
            lp.height = -1;
        }
        if (window != null) {
            window.setAttributes(lp);
        }
    }

    public void onResume() {
        super.onResume();
        UAMView uAMView = this.mCardMp4Player;
        UAMView uAMView2 = null;
        if (uAMView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player");
            uAMView = null;
        }
        uAMView.onResume();
        UAMView uAMView3 = this.mCardMp4Player2;
        if (uAMView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player2");
        } else {
            uAMView2 = uAMView3;
        }
        uAMView2.onResume();
    }

    public void onPause() {
        super.onPause();
        UAMView uAMView = this.mCardMp4Player;
        UAMView uAMView2 = null;
        if (uAMView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player");
            uAMView = null;
        }
        uAMView.onPause();
        UAMView uAMView3 = this.mCardMp4Player2;
        if (uAMView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player2");
        } else {
            uAMView2 = uAMView3;
        }
        uAMView2.onPause();
    }

    public void onStop() {
        BLog.d("NftCardDialog", "onStop");
        super.onStop();
    }

    public void onDestroyView() {
        BLog.d("NftCardDialog", "onDestroyView");
        super.onDestroyView();
    }

    public void onDestroy() {
        BLog.d("NftCardDialog", "onDestroy");
        BiliCardPlayerManager.INSTANCE.remove((Fragment) this);
        super.onDestroy();
        UAMView uAMView = this.mCardMp4Player;
        UAMView uAMView2 = null;
        if (uAMView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player");
            uAMView = null;
        }
        uAMView.destroy();
        UAMView uAMView3 = this.mCardMp4Player2;
        if (uAMView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardMp4Player2");
        } else {
            uAMView2 = uAMView3;
        }
        uAMView2.destroy();
        AuthorImageUploadHelper authorImageUploadHelper = this.mImageUploadHelper;
        if (authorImageUploadHelper != null) {
            authorImageUploadHelper.onDestory();
        }
    }

    public void dismiss() {
        BLog.d("NftCardDialog", "dismiss");
        super.dismiss();
        NftCardJsbCallback nftCardJsbCallback = this.mNftCardJsbCb;
        if (nftCardJsbCallback != null) {
            nftCardJsbCallback.toDismissDialog();
        }
        NftCardInfoGroup nftCardInfoGroup = this.mCardInfoGroup;
        if (nftCardInfoGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
            nftCardInfoGroup = null;
        }
        nftCardInfoGroup.hideMask();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri output;
        String $this$onActivityResult_u24lambda_u240_u240;
        Context ctx;
        AuthorImageUploadHelper authorImageUploadHelper;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            boolean z = true;
            switch (requestCode) {
                case 20:
                    if (data != null && (output = UCrop.getOutput(data)) != null && ($this$onActivityResult_u24lambda_u240_u240 = output.getPath()) != null) {
                        Uri.parse($this$onActivityResult_u24lambda_u240_u240);
                        NftCardInfoGroup nftCardInfoGroup = null;
                        if (!StringsKt.startsWith$default($this$onActivityResult_u24lambda_u240_u240, BusinessSplashDefine.FILE_URI_PREFIX, false, 2, (Object) null)) {
                            Uri.parse(BusinessSplashDefine.FILE_URI_PREFIX + $this$onActivityResult_u24lambda_u240_u240);
                        }
                        if (requestCode != 20 || (ctx = getContext()) == null) {
                            return;
                        }
                        int width = data.getIntExtra("com.yalantis.ucrop.ImageWidth", 0);
                        int height = data.getIntExtra("com.yalantis.ucrop.ImageHeight", 0);
                        int offsetX = data.getIntExtra("com.yalantis.ucrop.OffsetX", 0);
                        int offsetY = data.getIntExtra("com.yalantis.ucrop.OffsetY", 0);
                        final TintProgressDialog progressDialog = TintProgressDialog.show(getContext(), (CharSequence) null, "正在提交...", true);
                        BiliNftAvatarUploader.Companion companion = BiliNftAvatarUploader.Companion;
                        NftCardInfoGroup nftCardInfoGroup2 = this.mCardInfoGroup;
                        if (nftCardInfoGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCardInfoGroup");
                        } else {
                            nftCardInfoGroup = nftCardInfoGroup2;
                        }
                        companion.uploadAvatar(ctx, width, height, offsetX, offsetY, nftCardInfoGroup.getCurrentCardId(), new BiliNftAvatarUploader.UploadCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardDialog$onActivityResult$1$1$1
                            @Override // tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader.UploadCallback
                            public void onUploadSuccess() {
                                BLog.i("NftCardDialog", "更换头像成功 onUploadSuccess");
                                progressDialog.dismiss();
                                ToastHelper.showToastShort(this.getActivity(), "更换头像成功");
                            }

                            @Override // tv.danmaku.bili.ui.garb.api.BiliNftAvatarUploader.UploadCallback
                            public void onUploadFailed(int code, String msg) {
                                BLog.e("NftCardDialog", "更换头像失败 onUploadFailed");
                                progressDialog.dismiss();
                                ToastHelper.showToastShort(this.getActivity(), msg);
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
}