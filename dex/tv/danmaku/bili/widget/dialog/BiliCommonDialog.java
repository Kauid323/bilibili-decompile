package tv.danmaku.bili.widget.dialog;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.widget.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.style.BaseDialogContentStyle;
import tv.danmaku.bili.widget.dialog.style.DialogStyleCommon;
import tv.danmaku.bili.widget.dialog.style.DialogStyleContentCenter;
import tv.danmaku.bili.widget.dialog.style.DialogStyleLongEssay;
import tv.danmaku.bili.widget.dialog.style.DialogStyleNoTitle;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliCommonDialog.kt */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u00010\u0018\u0000 ]2\u00020\u0001:\u0003]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u0010H\u0014J\b\u0010:\u001a\u00020&H\u0014J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010?\u001a\u00020&H\u0002J=\u0010@\u001a\u00020&\"\b\b\u0000\u0010A*\u00020\u0010*\u0002HA2\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00152\b\b\u0002\u0010E\u001a\u00020,H\u0002¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020&H\u0002J \u0010H\u001a\u00020&*\u00020\t2\b\b\u0001\u0010I\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u000103H\u0002J \u0010K\u001a\u00020&*\u00020\t2\b\b\u0001\u0010L\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u000103H\u0002J\b\u0010M\u001a\u00020\u0015H\u0014J\b\u0010N\u001a\u00020\u0015H\u0014JW\u0010O\u001a\u00020&\"\b\b\u0000\u0010A*\u00020\u0010*\u0002HA2\b\u0010P\u001a\u0004\u0018\u00010\u00152\u0017\u0010Q\u001a\u0013\u0012\u0004\u0012\u0002HA\u0012\u0004\u0012\u00020&0R¢\u0006\u0002\bS2\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u0002HA\u0012\u0004\u0012\u00020&0R¢\u0006\u0002\bSH\u0002¢\u0006\u0002\u0010UJ%\u0010V\u001a\u00020&\"\b\b\u0000\u0010A*\u00020\t*\u0002HA2\b\u0010W\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010XJ/\u0010Y\u001a\u00020&\"\b\b\u0000\u0010A*\u00020\t*\u0002HA2\b\u0010Z\u001a\u0004\u0018\u00010(2\b\u0010[\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010\\R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "Ltv/danmaku/bili/widget/dialog/BaseDialogFragment;", "<init>", "()V", "mViewContent", "Landroid/view/ViewGroup;", "mDialogImage", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mDialogTitleTv", "Landroid/widget/TextView;", "mDialogContentTextSv", "Landroidx/core/widget/NestedScrollView;", "mDialogContentTextTv", "mDialogContentTipTv", "mDialogLinkTv", "mDialogDivider", "Landroid/view/View;", "mDialogBtnContainer", "mDialogNagetiveBtn", "mDialogPositiveBtn", "dialogBtnStyle", "", "Ljava/lang/Integer;", "dialogStyle", "Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;", "mPicUrl", "", "mPicRes", "mTitleStr", "mTitleColor", "mContentStr", "mContentTipStr", "mLinkStr", "", "mPositiveBtnStr", "mNegativeBtnStr", "mCancelListener", "Lkotlin/Function0;", "", "mLinkClickListener", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;", "mPositiveBtnClickListener", "mNagetiveBtnClickListener", "mPositiveBtnClickAutoDismiss", "", "mNagetiveBtnClickAutoDismiss", "mLinkClickAutoDismiss", "mLifecycleObserver", "tv/danmaku/bili/widget/dialog/BiliCommonDialog$mLifecycleObserver$1", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$mLifecycleObserver$1;", "mPositiveBtnInfo", "Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;", "mNegativeBtnInfo", "initConfig", "builder", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "initView", "view", "initSavedData", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "handleContent", "setVerticalMargin", "T", "dependent", "dependentShownMargin", "dependentHiddenMargin", "isMarginTop", "(Landroid/view/View;Landroid/view/View;IIZ)V", "handleButtons", "setButtonBackground", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "btnInfo", "setButtonTextColor", "textColor", "getDialogViewRes", "requestWidth", "setButtonType", "btnStyle", "fill", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "common", "(Landroid/view/View;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "setTextStr", "str", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "addOnClickListener", "clickListener", "autoDismiss", "(Landroid/widget/TextView;Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;Ljava/lang/Boolean;)V", "Companion", "OnDialogTextClickListener", "Builder", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliCommonDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final int DIALOG_BTN_HEIGHT_COMMON = 34;
    private static final int DIALOG_BTN_HEIGHT_FILL = 44;
    private static final int DIALOG_BTN_WHEN_COMMON_CONTAINER_MARGIN = 16;
    private static final int DIALOG_COMMON_GONE_MARGIN = 24;
    private static final int DIALOG_COMMON_TITLE_MARGIN_TOP = 20;
    private static final int DIALOG_LINK_LINEHEIGHT = 16;
    private static final int DIALOG_TITLE_LINEHEIGHT = 20;
    private static final int DIALOG_WIDTH = 280;
    private Integer dialogBtnStyle;
    private BaseDialogContentStyle dialogStyle;
    private Function0<Unit> mCancelListener;
    private String mContentStr;
    private String mContentTipStr;
    private View mDialogBtnContainer;
    private NestedScrollView mDialogContentTextSv;
    private TextView mDialogContentTextTv;
    private TextView mDialogContentTipTv;
    private View mDialogDivider;
    private BiliImageView mDialogImage;
    private TextView mDialogLinkTv;
    private TextView mDialogNagetiveBtn;
    private TextView mDialogPositiveBtn;
    private TextView mDialogTitleTv;
    private OnDialogTextClickListener mLinkClickListener;
    private CharSequence mLinkStr;
    private OnDialogTextClickListener mNagetiveBtnClickListener;
    private CustomButtonInfo mNegativeBtnInfo;
    private String mNegativeBtnStr;
    private int mPicRes;
    private String mPicUrl;
    private OnDialogTextClickListener mPositiveBtnClickListener;
    private CustomButtonInfo mPositiveBtnInfo;
    private String mPositiveBtnStr;
    private int mTitleColor;
    private String mTitleStr;
    private ViewGroup mViewContent;
    private boolean mPositiveBtnClickAutoDismiss = true;
    private boolean mNagetiveBtnClickAutoDismiss = true;
    private boolean mLinkClickAutoDismiss = true;
    private final BiliCommonDialog$mLifecycleObserver$1 mLifecycleObserver = new LifecycleObserver() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$mLifecycleObserver$1
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void showWhenCurrentActivityDestroy() {
            BiliCommonDialog.this.getLifecycle().removeObserver(this);
            BiliCommonDialog.this.dismiss();
        }
    };

    /* compiled from: BiliCommonDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;", "", "onDialogTextClicked", "", "view", "Landroid/view/View;", "dialog", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnDialogTextClickListener {
        void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog);
    }

    /* compiled from: BiliCommonDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Companion;", "", "<init>", "()V", "DIALOG_WIDTH", "", "DIALOG_BTN_HEIGHT_COMMON", "DIALOG_BTN_HEIGHT_FILL", "DIALOG_BTN_WHEN_COMMON_CONTAINER_MARGIN", "DIALOG_TITLE_LINEHEIGHT", "DIALOG_LINK_LINEHEIGHT", "DIALOG_COMMON_GONE_MARGIN", "DIALOG_COMMON_TITLE_MARGIN_TOP", "newInstance", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "builder", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliCommonDialog newInstance(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            BiliCommonDialog commonDialog = new BiliCommonDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("builder", builder);
            bundle.putCharSequence("link_span", builder.getLinkSpan$widget_debug());
            commonDialog.setArguments(bundle);
            return commonDialog;
        }
    }

    private final void initConfig(Builder builder) {
        setCancelableOnTouchOutside(builder.getCanceledOnTouchOutside$widget_debug());
        this.dialogStyle = builder.getDialogStyle$widget_debug();
        this.dialogBtnStyle = Integer.valueOf(builder.getDialogBtnStyle$widget_debug());
        this.mPicUrl = builder.getPicUrl$widget_debug();
        this.mPicRes = builder.getPicRes$widget_debug();
        this.mTitleStr = builder.getTitleStr$widget_debug();
        this.mTitleColor = builder.getTitleColor$widget_debug();
        this.mContentStr = builder.getContentStr$widget_debug();
        this.mContentTipStr = builder.getContentTipStr$widget_debug();
        this.mLinkStr = builder.getLinkStr$widget_debug();
        this.mLinkClickListener = builder.getLinkClickListener$widget_debug();
        this.mLinkClickAutoDismiss = builder.getLinkAutoDismiss$widget_debug();
        this.mPositiveBtnStr = builder.getPositiveStr$widget_debug();
        this.mPositiveBtnClickListener = builder.getPositiveClickListener$widget_debug();
        this.mPositiveBtnClickAutoDismiss = builder.getPositiveAutoDismiss$widget_debug();
        this.mNegativeBtnStr = builder.getNegativeStr$widget_debug();
        this.mNagetiveBtnClickListener = builder.getNegativeClickListener$widget_debug();
        this.mNagetiveBtnClickAutoDismiss = builder.getNegativeAutoDismiss$widget_debug();
        this.mPositiveBtnInfo = builder.getPositiveBtnInfo$widget_debug();
        this.mNegativeBtnInfo = builder.getNegativeBtnInfo$widget_debug();
        this.mCancelListener = builder.getCancelListener$widget_debug();
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected void initView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        BiliImageView findViewById = view2.findViewById(R.id.common_dialog_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mDialogImage = findViewById;
        View findViewById2 = view2.findViewById(R.id.common_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mDialogTitleTv = (TextView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.common_dialog_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mDialogContentTextTv = (TextView) findViewById3;
        View findViewById4 = view2.findViewById(R.id.common_dialog_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mDialogContentTipTv = (TextView) findViewById4;
        NestedScrollView findViewById5 = view2.findViewById(R.id.common_dialog_text_sv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mDialogContentTextSv = findViewById5;
        View findViewById6 = view2.findViewById(R.id.common_dialog_link);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mDialogLinkTv = (TextView) findViewById6;
        View findViewById7 = view2.findViewById(R.id.common_dialog_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mDialogDivider = findViewById7;
        View findViewById8 = view2.findViewById(R.id.common_dialog_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.mDialogBtnContainer = findViewById8;
        View findViewById9 = view2.findViewById(R.id.common_dialog_nagetive_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.mDialogNagetiveBtn = (TextView) findViewById9;
        View findViewById10 = view2.findViewById(R.id.common_dialog_positive_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.mDialogPositiveBtn = (TextView) findViewById10;
        View findViewById11 = view2.findViewById(R.id.common_dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.mViewContent = (ViewGroup) findViewById11;
        handleContent();
        handleButtons();
        getLifecycle().addObserver(this.mLifecycleObserver);
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected void initSavedData() {
        Bundle $this$initSavedData_u24lambda_u240 = getArguments();
        if ($this$initSavedData_u24lambda_u240 != null) {
            Builder $this$initSavedData_u24lambda_u240_u240 = (Builder) $this$initSavedData_u24lambda_u240.getParcelable("builder");
            if ($this$initSavedData_u24lambda_u240_u240 != null) {
                initConfig($this$initSavedData_u24lambda_u240_u240);
            }
            CharSequence $this$initSavedData_u24lambda_u240_u241 = $this$initSavedData_u24lambda_u240.getCharSequence("link_span");
            if ($this$initSavedData_u24lambda_u240_u241 != null) {
                this.mLinkStr = $this$initSavedData_u24lambda_u240_u241;
            }
        }
        if (this.dialogStyle == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.dialogStyle = new DialogStyleCommon(requireContext);
        }
        if (this.dialogBtnStyle == null) {
            this.dialogBtnStyle = 0;
        }
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getLifecycle().removeObserver(this.mLifecycleObserver);
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Function0<Unit> function0 = this.mCancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void handleContent() {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.mTitleStr) && (this.dialogStyle instanceof DialogStyleCommon)) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.dialogStyle = new DialogStyleNoTitle(requireContext);
        }
        BiliImageView $this$handleContent_u24lambda_u240 = this.mDialogImage;
        if ($this$handleContent_u24lambda_u240 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            $this$handleContent_u24lambda_u240 = null;
        }
        boolean isImageShow = this.mPicRes > 0 || !TextUtils.isEmpty(this.mPicUrl);
        CommonDialogUtilsKt.setVisibility((View) $this$handleContent_u24lambda_u240, isImageShow);
        if (isImageShow) {
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = $this$handleContent_u24lambda_u240.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(this.mPicUrl), this.mPicRes, (ScaleType) null, 2, (Object) null).into($this$handleContent_u24lambda_u240);
        }
        TextView textView = this.mDialogTitleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogTitleTv");
            textView = null;
        }
        TextView $this$handleContent_u24lambda_u241 = textView;
        $this$handleContent_u24lambda_u241.setTextColor(this.mTitleColor);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        TextViewCompat.setLineHeight($this$handleContent_u24lambda_u241, CommonDialogUtilsKt.dp2px(20, requireContext2));
        setTextStr($this$handleContent_u24lambda_u241, this.mTitleStr);
        TextView textView2 = $this$handleContent_u24lambda_u241;
        BiliImageView biliImageView = this.mDialogImage;
        if (biliImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            biliImageView = null;
        }
        setVerticalMargin$default(this, textView2, (View) biliImageView, 20, 24, false, 8, null);
        TextView $this$handleContent_u24lambda_u242 = this.mDialogLinkTv;
        if ($this$handleContent_u24lambda_u242 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogLinkTv");
            $this$handleContent_u24lambda_u242 = null;
        }
        setTextStr($this$handleContent_u24lambda_u242, this.mLinkStr);
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
        TextViewCompat.setLineHeight($this$handleContent_u24lambda_u242, CommonDialogUtilsKt.dp2px(16, requireContext3));
        if (this.mLinkStr instanceof String) {
            addOnClickListener($this$handleContent_u24lambda_u242, this.mLinkClickListener, Boolean.valueOf(this.mLinkClickAutoDismiss));
            $this$handleContent_u24lambda_u242.setTextColor(ContextCompat.getColor($this$handleContent_u24lambda_u242.getContext(), com.bilibili.lib.theme.R.color.Lb6));
        } else if (this.mLinkStr instanceof SpannableString) {
            $this$handleContent_u24lambda_u242.setMovementMethod(LinkMovementMethod.getInstance());
        }
        final TextView $this$handleContent_u24lambda_u243 = this.mDialogContentTextTv;
        if ($this$handleContent_u24lambda_u243 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentTextTv");
            $this$handleContent_u24lambda_u243 = null;
        }
        BaseDialogContentStyle baseDialogContentStyle = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle);
        $this$handleContent_u24lambda_u243.setTextColor(baseDialogContentStyle.getContentColor());
        BaseDialogContentStyle baseDialogContentStyle2 = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle2);
        $this$handleContent_u24lambda_u243.setTextSize(baseDialogContentStyle2.getContentTextSize());
        BaseDialogContentStyle baseDialogContentStyle3 = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle3);
        int contentTextLineHeight = baseDialogContentStyle3.getContentTextLineHeight();
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
        TextViewCompat.setLineHeight($this$handleContent_u24lambda_u243, CommonDialogUtilsKt.dp2px(contentTextLineHeight, requireContext4));
        BaseDialogContentStyle baseDialogContentStyle4 = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle4);
        $this$handleContent_u24lambda_u243.setGravity(baseDialogContentStyle4.getContentGravity());
        ViewGroup.LayoutParams layoutParams = $this$handleContent_u24lambda_u243.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        BaseDialogContentStyle baseDialogContentStyle5 = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle5);
        int contentTextMarginTop = baseDialogContentStyle5.getContentTextMarginTop();
        Context requireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext5, "requireContext(...)");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = CommonDialogUtilsKt.dp2px(contentTextMarginTop, requireContext5);
        setTextStr($this$handleContent_u24lambda_u243, this.mContentStr);
        $this$handleContent_u24lambda_u243.post(new Runnable() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliCommonDialog.handleContent$lambda$3$0($this$handleContent_u24lambda_u243, this);
            }
        });
        final TextView $this$handleContent_u24lambda_u244 = this.mDialogContentTipTv;
        if ($this$handleContent_u24lambda_u244 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentTipTv");
            $this$handleContent_u24lambda_u244 = null;
        }
        final BaseDialogContentStyle it = this.dialogStyle;
        if (it != null) {
            if (it.getContentTipColor() != 0) {
                $this$handleContent_u24lambda_u244.setTextColor(it.getContentTipColor());
            }
            $this$handleContent_u24lambda_u244.setTextSize(it.getContentTipSize());
            int contentTipLineHeight = it.getContentTipLineHeight();
            Context requireContext6 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext6, "requireContext(...)");
            TextViewCompat.setLineHeight($this$handleContent_u24lambda_u244, CommonDialogUtilsKt.dp2px(contentTipLineHeight, requireContext6));
            $this$handleContent_u24lambda_u244.setGravity(it.getContentTipGravity());
            ViewGroup.LayoutParams layoutParams2 = $this$handleContent_u24lambda_u244.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int contentTipMarginTop = it.getContentTipMarginTop();
            Context requireContext7 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext7, "requireContext(...)");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = CommonDialogUtilsKt.dp2px(contentTipMarginTop, requireContext7);
            setTextStr($this$handleContent_u24lambda_u244, this.mContentTipStr);
            $this$handleContent_u24lambda_u244.post(new Runnable() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BiliCommonDialog.handleContent$lambda$4$0$0($this$handleContent_u24lambda_u244, it);
                }
            });
        }
        NestedScrollView nestedScrollView = this.mDialogContentTextSv;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentTextSv");
            nestedScrollView = null;
        }
        NestedScrollView $this$handleContent_u24lambda_u245 = nestedScrollView;
        View view2 = (View) $this$handleContent_u24lambda_u245;
        TextView textView3 = this.mDialogTitleTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogTitleTv");
            textView3 = null;
        }
        BaseDialogContentStyle baseDialogContentStyle6 = this.dialogStyle;
        Intrinsics.checkNotNull(baseDialogContentStyle6);
        setVerticalMargin$default(this, view2, textView3, baseDialogContentStyle6.getContentMarginTop(), 24, false, 8, null);
        View view3 = (View) $this$handleContent_u24lambda_u245;
        TextView textView4 = this.mDialogLinkTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogLinkTv");
            textView4 = null;
        }
        setVerticalMargin(view3, textView4, 0, 24, false);
        ViewGroup.LayoutParams layoutParams3 = $this$handleContent_u24lambda_u245.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lps = (ViewGroup.MarginLayoutParams) layoutParams3;
        BiliImageView biliImageView2 = this.mDialogImage;
        if (biliImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            biliImageView2 = null;
        }
        if (biliImageView2.getVisibility() == 0) {
            TextView textView5 = this.mDialogTitleTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogTitleTv");
                textView5 = null;
            }
            if (textView5.getVisibility() == 8) {
                Context requireContext8 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext8, "requireContext(...)");
                lps.topMargin = CommonDialogUtilsKt.dp2px(20, requireContext8);
            }
        }
        Sequence $this$all$iv = ViewGroupKt.getChildren((ViewGroup) $this$handleContent_u24lambda_u245);
        Iterator it2 = $this$all$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                Object element$iv = it2.next();
                if (((View) element$iv).getVisibility() == 8) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            lps.topMargin = 0;
        }
    }

    public static final void handleContent$lambda$3$0(TextView $this_apply, BiliCommonDialog this$0) {
        if ($this_apply.getLineCount() <= 2) {
            BaseDialogContentStyle baseDialogContentStyle = this$0.dialogStyle;
            Intrinsics.checkNotNull(baseDialogContentStyle);
            if (baseDialogContentStyle.getSingleLineForceCenter()) {
                $this_apply.setGravity(17);
            }
        }
    }

    public static final void handleContent$lambda$4$0$0(TextView $this_apply, BaseDialogContentStyle $it) {
        if ($this_apply.getLineCount() < 2 && $it.getSingleLineForceCenter()) {
            $this_apply.setGravity(17);
        }
    }

    static /* synthetic */ void setVerticalMargin$default(BiliCommonDialog biliCommonDialog, View view2, View view3, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = true;
        }
        biliCommonDialog.setVerticalMargin(view2, view3, i, i2, z);
    }

    private final <T extends View> void setVerticalMargin(T t, View dependent, int dependentShownMargin, int dependentHiddenMargin, boolean isMarginTop) {
        ViewGroup.LayoutParams layoutParams = t.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lps = (ViewGroup.MarginLayoutParams) layoutParams;
        if (dependent.getVisibility() == 8) {
            if (isMarginTop) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                lps.topMargin = CommonDialogUtilsKt.dp2px(dependentHiddenMargin, requireContext);
                return;
            }
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            lps.bottomMargin = CommonDialogUtilsKt.dp2px(dependentHiddenMargin, requireContext2);
        } else if (isMarginTop) {
            Context requireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
            lps.topMargin = CommonDialogUtilsKt.dp2px(dependentShownMargin, requireContext3);
        } else {
            Context requireContext4 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
            lps.bottomMargin = CommonDialogUtilsKt.dp2px(dependentShownMargin, requireContext4);
        }
    }

    private final void handleButtons() {
        int i;
        Integer num = this.dialogBtnStyle;
        boolean z = false;
        boolean isBtnStyleFill = num != null && num.intValue() == 1;
        boolean hasBtnShow = (TextUtils.isEmpty(this.mPositiveBtnStr) && TextUtils.isEmpty(this.mNegativeBtnStr)) ? false : true;
        View $this$handleButtons_u24lambda_u240 = this.mDialogBtnContainer;
        TextView textView = null;
        if ($this$handleButtons_u24lambda_u240 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogBtnContainer");
            $this$handleButtons_u24lambda_u240 = null;
        }
        ViewGroup.LayoutParams layoutParams = $this$handleButtons_u24lambda_u240.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lps = (ViewGroup.MarginLayoutParams) layoutParams;
        if (isBtnStyleFill || !hasBtnShow) {
            i = 0;
        } else {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            i = CommonDialogUtilsKt.dp2px(16, requireContext);
        }
        lps.bottomMargin = i;
        View $this$handleButtons_u24lambda_u241 = this.mDialogDivider;
        if ($this$handleButtons_u24lambda_u241 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogDivider");
            $this$handleButtons_u24lambda_u241 = null;
        }
        if (isBtnStyleFill && hasBtnShow) {
            z = true;
        }
        CommonDialogUtilsKt.setVisibility($this$handleButtons_u24lambda_u241, z);
        TextView $this$handleButtons_u24lambda_u242 = this.mDialogPositiveBtn;
        if ($this$handleButtons_u24lambda_u242 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogPositiveBtn");
            $this$handleButtons_u24lambda_u242 = null;
        }
        setButtonType($this$handleButtons_u24lambda_u242, this.dialogBtnStyle, new Function1() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit handleButtons$lambda$2$0;
                handleButtons$lambda$2$0 = BiliCommonDialog.handleButtons$lambda$2$0(BiliCommonDialog.this, (TextView) obj);
                return handleButtons$lambda$2$0;
            }
        }, new Function1() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit handleButtons$lambda$2$1;
                handleButtons$lambda$2$1 = BiliCommonDialog.handleButtons$lambda$2$1(BiliCommonDialog.this, (TextView) obj);
                return handleButtons$lambda$2$1;
            }
        });
        setTextStr($this$handleButtons_u24lambda_u242, this.mPositiveBtnStr);
        addOnClickListener($this$handleButtons_u24lambda_u242, this.mPositiveBtnClickListener, Boolean.valueOf(this.mPositiveBtnClickAutoDismiss));
        TextView textView2 = this.mDialogNagetiveBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogNagetiveBtn");
        } else {
            textView = textView2;
        }
        TextView $this$handleButtons_u24lambda_u243 = textView;
        setButtonType($this$handleButtons_u24lambda_u243, this.dialogBtnStyle, new Function1() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit handleButtons$lambda$3$0;
                handleButtons$lambda$3$0 = BiliCommonDialog.handleButtons$lambda$3$0(BiliCommonDialog.this, (TextView) obj);
                return handleButtons$lambda$3$0;
            }
        }, new Function1() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit handleButtons$lambda$3$1;
                handleButtons$lambda$3$1 = BiliCommonDialog.handleButtons$lambda$3$1(BiliCommonDialog.this, (TextView) obj);
                return handleButtons$lambda$3$1;
            }
        });
        setTextStr($this$handleButtons_u24lambda_u243, this.mNegativeBtnStr);
        addOnClickListener($this$handleButtons_u24lambda_u243, this.mNagetiveBtnClickListener, Boolean.valueOf(this.mNagetiveBtnClickAutoDismiss));
    }

    public static final Unit handleButtons$lambda$2$0(BiliCommonDialog this$0, TextView $this$setButtonType) {
        Intrinsics.checkNotNullParameter($this$setButtonType, "$this$setButtonType");
        this$0.setButtonTextColor($this$setButtonType, R.color.selecor_common_dialog_positive_btn_full_text_color, this$0.mPositiveBtnInfo);
        $this$setButtonType.setBackground(ContextCompat.getDrawable(this$0.requireContext(), com.bilibili.lib.theme.R.color.Ga0_s));
        return Unit.INSTANCE;
    }

    public static final Unit handleButtons$lambda$2$1(BiliCommonDialog this$0, TextView $this$setButtonType) {
        Intrinsics.checkNotNullParameter($this$setButtonType, "$this$setButtonType");
        this$0.setButtonTextColor($this$setButtonType, R.color.selecor_common_dialog_positive_btn_text_color, this$0.mPositiveBtnInfo);
        this$0.setButtonBackground($this$setButtonType, R.drawable.selecor_common_dialog_positive_btn_bg, this$0.mPositiveBtnInfo);
        return Unit.INSTANCE;
    }

    public static final Unit handleButtons$lambda$3$0(BiliCommonDialog this$0, TextView $this$setButtonType) {
        Intrinsics.checkNotNullParameter($this$setButtonType, "$this$setButtonType");
        this$0.setButtonTextColor($this$setButtonType, R.color.selecor_common_dialog_negative_btn_full_text_color, this$0.mNegativeBtnInfo);
        $this$setButtonType.setBackground(ContextCompat.getDrawable(this$0.requireContext(), com.bilibili.lib.theme.R.color.Ga0_s));
        return Unit.INSTANCE;
    }

    public static final Unit handleButtons$lambda$3$1(BiliCommonDialog this$0, TextView $this$setButtonType) {
        Intrinsics.checkNotNullParameter($this$setButtonType, "$this$setButtonType");
        this$0.setButtonTextColor($this$setButtonType, R.color.selecor_common_dialog_negative_btn_text_color, this$0.mNegativeBtnInfo);
        this$0.setButtonBackground($this$setButtonType, R.drawable.selecor_common_dialog_negative_btn_bg, this$0.mNegativeBtnInfo);
        return Unit.INSTANCE;
    }

    private final void setButtonBackground(TextView $this$setButtonBackground, int background, CustomButtonInfo btnInfo) {
        if ((btnInfo != null ? btnInfo.getBtnBackground() : null) != null) {
            $this$setButtonBackground.setBackgroundResource(btnInfo.getBtnBackground().intValue());
        } else {
            $this$setButtonBackground.setBackgroundResource(background);
        }
    }

    private final void setButtonTextColor(TextView $this$setButtonTextColor, int textColor, CustomButtonInfo btnInfo) {
        if ((btnInfo != null ? btnInfo.getTextColor() : null) != null) {
            $this$setButtonTextColor.setTextColor(ThemeUtils.getThemeColorStateList(requireContext(), btnInfo.getTextColor().intValue()));
        } else {
            $this$setButtonTextColor.setTextColor(ThemeUtils.getThemeColorStateList(requireContext(), textColor));
        }
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int getDialogViewRes() {
        return R.layout.bili_app_dialog_common;
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int requestWidth() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        return CommonDialogUtilsKt.dp2px(DIALOG_WIDTH, requireContext);
    }

    private final <T extends View> void setButtonType(T t, Integer btnStyle, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        if (btnStyle != null && btnStyle.intValue() == 0) {
            function12.invoke(t);
            ViewGroup.LayoutParams layoutParams = t.getLayoutParams();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            layoutParams.height = CommonDialogUtilsKt.dp2px(34, requireContext);
            return;
        }
        function1.invoke(t);
        ViewGroup.LayoutParams layoutParams2 = t.getLayoutParams();
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        layoutParams2.height = CommonDialogUtilsKt.dp2px(44, requireContext2);
    }

    private final <T extends TextView> void setTextStr(T t, CharSequence str) {
        CommonDialogUtilsKt.setVisibility(t, !TextUtils.isEmpty(str));
        t.setText(str);
    }

    private final <T extends TextView> void addOnClickListener(T t, final OnDialogTextClickListener clickListener, final Boolean autoDismiss) {
        t.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.dialog.BiliCommonDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BiliCommonDialog.addOnClickListener$lambda$0(BiliCommonDialog.OnDialogTextClickListener.this, autoDismiss, this, view2);
            }
        });
    }

    public static final void addOnClickListener$lambda$0(OnDialogTextClickListener $clickListener, Boolean $autoDismiss, BiliCommonDialog this$0, View it) {
        if ($clickListener != null) {
            Intrinsics.checkNotNull(it);
            $clickListener.onDialogTextClicked(it, this$0);
        }
        if (Intrinsics.areEqual($autoDismiss, true)) {
            this$0.dismiss();
        }
    }

    /* compiled from: BiliCommonDialog.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010d\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010h\u001a\u00020\u00002\f\u0010]\u001a\b\u0012\u0004\u0012\u00020_0^J\u0010\u0010g\u001a\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0010J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010k\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u001fJ&\u0010l\u001a\u00020\u00002\u0006\u0010*\u001a\u00020.2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010m\u001a\u00020\nH\u0007J2\u0010n\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001f2\n\b\u0002\u0010<\u001a\u0004\u0018\u0001042\b\b\u0002\u0010m\u001a\u00020\n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010@H\u0007J4\u0010n\u001a\u00020\u00002\b\b\u0001\u00109\u001a\u00020\u00102\n\b\u0002\u0010<\u001a\u0004\u0018\u0001042\b\b\u0002\u0010m\u001a\u00020\n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010@H\u0007J2\u0010p\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u001f2\n\b\u0002\u0010H\u001a\u0004\u0018\u0001042\b\b\u0002\u0010m\u001a\u00020\n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010@H\u0007J4\u0010p\u001a\u00020\u00002\b\b\u0001\u0010E\u001a\u00020\u00102\n\b\u0002\u0010H\u001a\u0004\u0018\u0001042\b\b\u0002\u0010m\u001a\u00020\n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010@H\u0007J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u001fJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u0010J\u0010\u0010r\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u0010J\u0010\u0010s\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u0010J\u0006\u0010t\u001a\u00020\u0000J\u0006\u0010u\u001a\u00020vJ\u0018\u0010w\u001a\u00020_2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u0010H\u0016J\b\u0010y\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001c\u0010*\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\u001c\u0010<\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R\u001c\u0010H\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00106\"\u0004\bJ\u00108R\u001c\u0010K\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR\u001a\u0010N\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001a\u0010Q\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\f\"\u0004\bS\u0010\u000eR\u001a\u0010T\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\f\"\u0004\bV\u0010\u000eR\u001c\u0010W\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010!\"\u0004\bY\u0010#R\u001a\u0010Z\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0012\"\u0004\b\\\u0010\u0014R\"\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006{"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "Landroid/os/Parcelable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;Landroid/content/Context;)V", "canceledOnTouchOutside", "", "getCanceledOnTouchOutside$widget_debug", "()Z", "setCanceledOnTouchOutside$widget_debug", "(Z)V", "dialogBtnStyle", "", "getDialogBtnStyle$widget_debug", "()I", "setDialogBtnStyle$widget_debug", "(I)V", "dialogStyle", "Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;", "getDialogStyle$widget_debug", "()Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;", "setDialogStyle$widget_debug", "(Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;)V", "titleColor", "getTitleColor$widget_debug", "setTitleColor$widget_debug", "titleStr", "", "getTitleStr$widget_debug", "()Ljava/lang/String;", "setTitleStr$widget_debug", "(Ljava/lang/String;)V", "contentStr", "getContentStr$widget_debug", "setContentStr$widget_debug", "contentTipStr", "getContentTipStr$widget_debug", "setContentTipStr$widget_debug", "linkStr", "getLinkStr$widget_debug", "setLinkStr$widget_debug", "linkSpan", "", "getLinkSpan$widget_debug", "()Ljava/lang/CharSequence;", "setLinkSpan$widget_debug", "(Ljava/lang/CharSequence;)V", "linkClickListener", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;", "getLinkClickListener$widget_debug", "()Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;", "setLinkClickListener$widget_debug", "(Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$OnDialogTextClickListener;)V", "positiveStr", "getPositiveStr$widget_debug", "setPositiveStr$widget_debug", "positiveClickListener", "getPositiveClickListener$widget_debug", "setPositiveClickListener$widget_debug", "positiveBtnInfo", "Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;", "getPositiveBtnInfo$widget_debug", "()Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;", "setPositiveBtnInfo$widget_debug", "(Ltv/danmaku/bili/widget/dialog/CustomButtonInfo;)V", "negativeStr", "getNegativeStr$widget_debug", "setNegativeStr$widget_debug", "negativeClickListener", "getNegativeClickListener$widget_debug", "setNegativeClickListener$widget_debug", "negativeBtnInfo", "getNegativeBtnInfo$widget_debug", "setNegativeBtnInfo$widget_debug", "positiveAutoDismiss", "getPositiveAutoDismiss$widget_debug", "setPositiveAutoDismiss$widget_debug", "negativeAutoDismiss", "getNegativeAutoDismiss$widget_debug", "setNegativeAutoDismiss$widget_debug", "linkAutoDismiss", "getLinkAutoDismiss$widget_debug", "setLinkAutoDismiss$widget_debug", "picUrl", "getPicUrl$widget_debug", "setPicUrl$widget_debug", "picRes", "getPicRes$widget_debug", "setPicRes$widget_debug", "cancelListener", "Lkotlin/Function0;", "", "getCancelListener$widget_debug", "()Lkotlin/jvm/functions/Function0;", "setCancelListener$widget_debug", "(Lkotlin/jvm/functions/Function0;)V", "setButtonStyle", "setContentStyle", "setDialogContentStyle", "setTitle", "setCancelListener", "setCanceledOnTouchOutside", "setContentText", "setContentTip", "setLink", "autoDismiss", "setPositiveButton", "btnInfo", "setNegativeButton", "setDialogPicture", "setTitleColor", "setTitleColorRes", "titleUseThemeColor", "build", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "writeToParcel", "flags", "describeContents", "CREATOR", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        private Function0<Unit> cancelListener;
        private boolean canceledOnTouchOutside;
        private String contentStr;
        private String contentTipStr;
        private Context context;
        private int dialogBtnStyle;
        private BaseDialogContentStyle dialogStyle;
        private boolean linkAutoDismiss;
        private OnDialogTextClickListener linkClickListener;
        private CharSequence linkSpan;
        private String linkStr;
        private boolean negativeAutoDismiss;
        private CustomButtonInfo negativeBtnInfo;
        private OnDialogTextClickListener negativeClickListener;
        private String negativeStr;
        private int picRes;
        private String picUrl;
        private boolean positiveAutoDismiss;
        private CustomButtonInfo positiveBtnInfo;
        private OnDialogTextClickListener positiveClickListener;
        private String positiveStr;
        private int titleColor;
        private String titleStr;

        public final Builder setLink(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "linkStr");
            return setLink$default(this, charSequence, null, false, 6, null);
        }

        public final Builder setLink(CharSequence charSequence, OnDialogTextClickListener onDialogTextClickListener) {
            Intrinsics.checkNotNullParameter(charSequence, "linkStr");
            return setLink$default(this, charSequence, onDialogTextClickListener, false, 4, null);
        }

        public final Builder setNegativeButton(int i) {
            return setNegativeButton$default(this, i, (OnDialogTextClickListener) null, false, (CustomButtonInfo) null, 14, (Object) null);
        }

        public final Builder setNegativeButton(int i, OnDialogTextClickListener onDialogTextClickListener) {
            return setNegativeButton$default(this, i, onDialogTextClickListener, false, (CustomButtonInfo) null, 12, (Object) null);
        }

        public final Builder setNegativeButton(int i, OnDialogTextClickListener onDialogTextClickListener, boolean z) {
            return setNegativeButton$default(this, i, onDialogTextClickListener, z, (CustomButtonInfo) null, 8, (Object) null);
        }

        public final Builder setNegativeButton(String str) {
            Intrinsics.checkNotNullParameter(str, "negativeStr");
            return setNegativeButton$default(this, str, (OnDialogTextClickListener) null, false, (CustomButtonInfo) null, 14, (Object) null);
        }

        public final Builder setNegativeButton(String str, OnDialogTextClickListener onDialogTextClickListener) {
            Intrinsics.checkNotNullParameter(str, "negativeStr");
            return setNegativeButton$default(this, str, onDialogTextClickListener, false, (CustomButtonInfo) null, 12, (Object) null);
        }

        public final Builder setNegativeButton(String str, OnDialogTextClickListener onDialogTextClickListener, boolean z) {
            Intrinsics.checkNotNullParameter(str, "negativeStr");
            return setNegativeButton$default(this, str, onDialogTextClickListener, z, (CustomButtonInfo) null, 8, (Object) null);
        }

        public final Builder setPositiveButton(int i) {
            return setPositiveButton$default(this, i, (OnDialogTextClickListener) null, false, (CustomButtonInfo) null, 14, (Object) null);
        }

        public final Builder setPositiveButton(int i, OnDialogTextClickListener onDialogTextClickListener) {
            return setPositiveButton$default(this, i, onDialogTextClickListener, false, (CustomButtonInfo) null, 12, (Object) null);
        }

        public final Builder setPositiveButton(int i, OnDialogTextClickListener onDialogTextClickListener, boolean z) {
            return setPositiveButton$default(this, i, onDialogTextClickListener, z, (CustomButtonInfo) null, 8, (Object) null);
        }

        public final Builder setPositiveButton(String str) {
            Intrinsics.checkNotNullParameter(str, "positiveStr");
            return setPositiveButton$default(this, str, (OnDialogTextClickListener) null, false, (CustomButtonInfo) null, 14, (Object) null);
        }

        public final Builder setPositiveButton(String str, OnDialogTextClickListener onDialogTextClickListener) {
            Intrinsics.checkNotNullParameter(str, "positiveStr");
            return setPositiveButton$default(this, str, onDialogTextClickListener, false, (CustomButtonInfo) null, 12, (Object) null);
        }

        public final Builder setPositiveButton(String str, OnDialogTextClickListener onDialogTextClickListener, boolean z) {
            Intrinsics.checkNotNullParameter(str, "positiveStr");
            return setPositiveButton$default(this, str, onDialogTextClickListener, z, (CustomButtonInfo) null, 8, (Object) null);
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.canceledOnTouchOutside = true;
            this.dialogBtnStyle = 0;
            this.dialogStyle = new DialogStyleCommon(context);
            this.picUrl = null;
            this.picRes = 0;
            this.titleStr = null;
            this.titleColor = ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Ga10);
            this.contentStr = null;
            this.contentTipStr = null;
            this.linkStr = null;
            this.linkSpan = null;
            this.positiveStr = null;
            this.negativeStr = null;
            this.linkClickListener = null;
            this.positiveClickListener = null;
            this.negativeClickListener = null;
            this.positiveAutoDismiss = true;
            this.negativeAutoDismiss = true;
            this.linkAutoDismiss = false;
            this.positiveBtnInfo = null;
            this.negativeBtnInfo = null;
            this.cancelListener = null;
        }

        public final boolean getCanceledOnTouchOutside$widget_debug() {
            return this.canceledOnTouchOutside;
        }

        public final void setCanceledOnTouchOutside$widget_debug(boolean z) {
            this.canceledOnTouchOutside = z;
        }

        public final int getDialogBtnStyle$widget_debug() {
            return this.dialogBtnStyle;
        }

        public final void setDialogBtnStyle$widget_debug(int i) {
            this.dialogBtnStyle = i;
        }

        public final BaseDialogContentStyle getDialogStyle$widget_debug() {
            return this.dialogStyle;
        }

        public final void setDialogStyle$widget_debug(BaseDialogContentStyle baseDialogContentStyle) {
            Intrinsics.checkNotNullParameter(baseDialogContentStyle, "<set-?>");
            this.dialogStyle = baseDialogContentStyle;
        }

        public final int getTitleColor$widget_debug() {
            return this.titleColor;
        }

        public final void setTitleColor$widget_debug(int i) {
            this.titleColor = i;
        }

        public final String getTitleStr$widget_debug() {
            return this.titleStr;
        }

        public final void setTitleStr$widget_debug(String str) {
            this.titleStr = str;
        }

        public final String getContentStr$widget_debug() {
            return this.contentStr;
        }

        public final void setContentStr$widget_debug(String str) {
            this.contentStr = str;
        }

        public final String getContentTipStr$widget_debug() {
            return this.contentTipStr;
        }

        public final void setContentTipStr$widget_debug(String str) {
            this.contentTipStr = str;
        }

        public final String getLinkStr$widget_debug() {
            return this.linkStr;
        }

        public final void setLinkStr$widget_debug(String str) {
            this.linkStr = str;
        }

        public final CharSequence getLinkSpan$widget_debug() {
            return this.linkSpan;
        }

        public final void setLinkSpan$widget_debug(CharSequence charSequence) {
            this.linkSpan = charSequence;
        }

        public final OnDialogTextClickListener getLinkClickListener$widget_debug() {
            return this.linkClickListener;
        }

        public final void setLinkClickListener$widget_debug(OnDialogTextClickListener onDialogTextClickListener) {
            this.linkClickListener = onDialogTextClickListener;
        }

        public final String getPositiveStr$widget_debug() {
            return this.positiveStr;
        }

        public final void setPositiveStr$widget_debug(String str) {
            this.positiveStr = str;
        }

        public final OnDialogTextClickListener getPositiveClickListener$widget_debug() {
            return this.positiveClickListener;
        }

        public final void setPositiveClickListener$widget_debug(OnDialogTextClickListener onDialogTextClickListener) {
            this.positiveClickListener = onDialogTextClickListener;
        }

        public final CustomButtonInfo getPositiveBtnInfo$widget_debug() {
            return this.positiveBtnInfo;
        }

        public final void setPositiveBtnInfo$widget_debug(CustomButtonInfo customButtonInfo) {
            this.positiveBtnInfo = customButtonInfo;
        }

        public final String getNegativeStr$widget_debug() {
            return this.negativeStr;
        }

        public final void setNegativeStr$widget_debug(String str) {
            this.negativeStr = str;
        }

        public final OnDialogTextClickListener getNegativeClickListener$widget_debug() {
            return this.negativeClickListener;
        }

        public final void setNegativeClickListener$widget_debug(OnDialogTextClickListener onDialogTextClickListener) {
            this.negativeClickListener = onDialogTextClickListener;
        }

        public final CustomButtonInfo getNegativeBtnInfo$widget_debug() {
            return this.negativeBtnInfo;
        }

        public final void setNegativeBtnInfo$widget_debug(CustomButtonInfo customButtonInfo) {
            this.negativeBtnInfo = customButtonInfo;
        }

        public final boolean getPositiveAutoDismiss$widget_debug() {
            return this.positiveAutoDismiss;
        }

        public final void setPositiveAutoDismiss$widget_debug(boolean z) {
            this.positiveAutoDismiss = z;
        }

        public final boolean getNegativeAutoDismiss$widget_debug() {
            return this.negativeAutoDismiss;
        }

        public final void setNegativeAutoDismiss$widget_debug(boolean z) {
            this.negativeAutoDismiss = z;
        }

        public final boolean getLinkAutoDismiss$widget_debug() {
            return this.linkAutoDismiss;
        }

        public final void setLinkAutoDismiss$widget_debug(boolean z) {
            this.linkAutoDismiss = z;
        }

        public final String getPicUrl$widget_debug() {
            return this.picUrl;
        }

        public final void setPicUrl$widget_debug(String str) {
            this.picUrl = str;
        }

        public final int getPicRes$widget_debug() {
            return this.picRes;
        }

        public final void setPicRes$widget_debug(int i) {
            this.picRes = i;
        }

        public final Function0<Unit> getCancelListener$widget_debug() {
            return this.cancelListener;
        }

        public final void setCancelListener$widget_debug(Function0<Unit> function0) {
            this.cancelListener = function0;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Parcel parcel, Context context) {
            this(context);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Intrinsics.checkNotNullParameter(context, "context");
            this.canceledOnTouchOutside = parcel.readByte() != 0;
            this.dialogBtnStyle = parcel.readInt();
            this.titleColor = parcel.readInt();
            this.titleStr = parcel.readString();
            this.contentStr = parcel.readString();
            this.contentTipStr = parcel.readString();
            this.linkStr = parcel.readString();
            this.positiveStr = parcel.readString();
            this.negativeStr = parcel.readString();
            this.positiveAutoDismiss = parcel.readByte() != 0;
            this.negativeAutoDismiss = parcel.readByte() != 0;
            this.linkAutoDismiss = parcel.readByte() != 0;
            this.picUrl = parcel.readString();
            this.picRes = parcel.readInt();
        }

        public final Builder setButtonStyle(int dialogStyle) {
            this.dialogBtnStyle = dialogStyle;
            return this;
        }

        public final Builder setContentStyle(int dialogStyle) {
            switch (dialogStyle) {
                case 0:
                    this.dialogStyle = new DialogStyleCommon(this.context);
                    break;
                case 1:
                    this.dialogStyle = new DialogStyleLongEssay(this.context);
                    break;
                case 2:
                    this.dialogStyle = new DialogStyleContentCenter(this.context);
                    break;
            }
            return this;
        }

        public final Builder setDialogContentStyle(BaseDialogContentStyle dialogStyle) {
            Intrinsics.checkNotNullParameter(dialogStyle, "dialogStyle");
            this.dialogStyle = dialogStyle;
            return this;
        }

        public final Builder setTitle(String titleStr) {
            Intrinsics.checkNotNullParameter(titleStr, "titleStr");
            this.titleStr = titleStr;
            return this;
        }

        public final Builder setCancelListener(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "cancelListener");
            this.cancelListener = function0;
            return this;
        }

        public final Builder setTitle(int titleStr) {
            this.titleStr = this.context.getString(titleStr);
            return this;
        }

        public final Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public final Builder setContentText(String contentStr) {
            Intrinsics.checkNotNullParameter(contentStr, "contentStr");
            this.contentStr = contentStr;
            return this;
        }

        public final Builder setContentTip(String contentTipStr) {
            Intrinsics.checkNotNullParameter(contentTipStr, "contentTipStr");
            this.contentTipStr = contentTipStr;
            return this;
        }

        public static /* synthetic */ Builder setLink$default(Builder builder, CharSequence charSequence, OnDialogTextClickListener onDialogTextClickListener, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                onDialogTextClickListener = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return builder.setLink(charSequence, onDialogTextClickListener, z);
        }

        public final Builder setLink(CharSequence linkStr, OnDialogTextClickListener linkClickListener, boolean autoDismiss) {
            Intrinsics.checkNotNullParameter(linkStr, "linkStr");
            if (linkStr instanceof SpannableString) {
                this.linkSpan = linkStr;
            } else if (linkStr instanceof String) {
                this.linkStr = (String) linkStr;
                this.linkClickListener = linkClickListener;
                this.linkAutoDismiss = autoDismiss;
            }
            return this;
        }

        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, String str, OnDialogTextClickListener onDialogTextClickListener, boolean z, CustomButtonInfo customButtonInfo, int i, Object obj) {
            if ((i & 2) != 0) {
                onDialogTextClickListener = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                customButtonInfo = null;
            }
            return builder.setPositiveButton(str, onDialogTextClickListener, z, customButtonInfo);
        }

        public final Builder setPositiveButton(String positiveStr, OnDialogTextClickListener positiveClickListener, boolean autoDismiss, CustomButtonInfo btnInfo) {
            Intrinsics.checkNotNullParameter(positiveStr, "positiveStr");
            this.positiveStr = positiveStr;
            this.positiveClickListener = positiveClickListener;
            this.positiveAutoDismiss = autoDismiss;
            this.positiveBtnInfo = btnInfo;
            return this;
        }

        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, int i, OnDialogTextClickListener onDialogTextClickListener, boolean z, CustomButtonInfo customButtonInfo, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                onDialogTextClickListener = null;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                customButtonInfo = null;
            }
            return builder.setPositiveButton(i, onDialogTextClickListener, z, customButtonInfo);
        }

        public final Builder setPositiveButton(int positiveStr, OnDialogTextClickListener positiveClickListener, boolean autoDismiss, CustomButtonInfo btnInfo) {
            String string = this.context.getString(positiveStr);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setPositiveButton(string, positiveClickListener, autoDismiss, btnInfo);
        }

        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, String str, OnDialogTextClickListener onDialogTextClickListener, boolean z, CustomButtonInfo customButtonInfo, int i, Object obj) {
            if ((i & 2) != 0) {
                onDialogTextClickListener = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                customButtonInfo = null;
            }
            return builder.setNegativeButton(str, onDialogTextClickListener, z, customButtonInfo);
        }

        public final Builder setNegativeButton(String negativeStr, OnDialogTextClickListener negativeClickListener, boolean autoDismiss, CustomButtonInfo btnInfo) {
            Intrinsics.checkNotNullParameter(negativeStr, "negativeStr");
            this.negativeStr = negativeStr;
            this.negativeClickListener = negativeClickListener;
            this.negativeAutoDismiss = autoDismiss;
            this.negativeBtnInfo = btnInfo;
            return this;
        }

        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, int i, OnDialogTextClickListener onDialogTextClickListener, boolean z, CustomButtonInfo customButtonInfo, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                onDialogTextClickListener = null;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                customButtonInfo = null;
            }
            return builder.setNegativeButton(i, onDialogTextClickListener, z, customButtonInfo);
        }

        public final Builder setNegativeButton(int negativeStr, OnDialogTextClickListener negativeClickListener, boolean autoDismiss, CustomButtonInfo btnInfo) {
            String string = this.context.getString(negativeStr);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setNegativeButton(string, negativeClickListener, autoDismiss, btnInfo);
        }

        public final Builder setDialogPicture(String picUrl) {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            this.picUrl = picUrl;
            return this;
        }

        public final Builder setDialogPicture(int picRes) {
            this.picRes = picRes;
            return this;
        }

        public final Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public final Builder setTitleColorRes(int titleColor) {
            this.titleColor = ThemeUtils.getColorById(this.context, titleColor);
            return this;
        }

        public final Builder titleUseThemeColor() {
            this.titleColor = ThemeUtils.getColorById(this.context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
            return this;
        }

        public final BiliCommonDialog build() {
            return BiliCommonDialog.Companion.newInstance(this);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeByte(this.canceledOnTouchOutside ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.dialogBtnStyle);
            parcel.writeInt(this.titleColor);
            parcel.writeString(this.titleStr);
            parcel.writeString(this.contentStr);
            parcel.writeString(this.contentTipStr);
            parcel.writeString(this.linkStr);
            parcel.writeString(this.positiveStr);
            parcel.writeString(this.negativeStr);
            parcel.writeByte(this.positiveAutoDismiss ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.negativeAutoDismiss ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.linkAutoDismiss ? (byte) 1 : (byte) 0);
            parcel.writeString(this.picUrl);
            parcel.writeInt(this.picRes);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: BiliCommonDialog.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class CREATOR implements Parcelable.Creator<Builder> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public Builder createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Application application = BiliContext.application();
                Intrinsics.checkNotNull(application);
                return new Builder(parcel, application);
            }

            @Override // android.os.Parcelable.Creator
            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        }
    }
}