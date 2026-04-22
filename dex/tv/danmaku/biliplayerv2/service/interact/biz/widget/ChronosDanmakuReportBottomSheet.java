package tv.danmaku.biliplayerv2.service.interact.biz.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.R;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.PlayerRadioGridGroup;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosDanmakuReportBottomSheet.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001?B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010(\u001a\u00020)H\u0016JJ\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020%2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0018J\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020%J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00107\u001a\u00020)H\u0002J\u0018\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J\u001a\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/ChronosDanmakuReportBottomSheet;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "context", "Landroid/content/Context;", "reportCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/IChronosDanmakuReportCallback;", "theme", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/biliplayerv2/service/interact/biz/widget/IChronosDanmakuReportCallback;I)V", "mCloseView", "Landroid/view/View;", "mDanmakuTextView", "Landroid/widget/TextView;", "mRadioGroup", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup;", "mShieldCheckBox", "Landroid/widget/CheckBox;", "mConfirmView", "mReportIndexArray", "", "", "[Ljava/lang/String;", "mCheckedPos", "mDanmakuId", "mType", "Ljava/lang/Integer;", "mText", "mAppearanceTime", "", "Ljava/lang/Long;", "mDuration", "mShieldUserId", "mShieldUser", "", "mOid", "mCloseReason", "show", "", "setReportedDanmaku", "danmakuId", "type", "text", "appearanceTime", "duration", "shieldUserId", "shieldUser", "oid", "getDismissReason", "getShieldUser", "onClick", "v", "commitReport", "onItemChecked", "oldChecked", "newChecked", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosDanmakuReportBottomSheet extends Dialog implements View.OnClickListener, PlayerRadioGridGroup.OnItemCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    public static final int CLOSE_BY_OTHER = 0;
    public static final int CLOSE_BY_SUBMIT = 1;
    public static final Companion Companion = new Companion(null);
    private Long mAppearanceTime;
    private int mCheckedPos;
    private int mCloseReason;
    private final View mCloseView;
    private final TextView mConfirmView;
    private String mDanmakuId;
    private final TextView mDanmakuTextView;
    private Long mDuration;
    private String mOid;
    private final PlayerRadioGridGroup mRadioGroup;
    private String[] mReportIndexArray;
    private final CheckBox mShieldCheckBox;
    private boolean mShieldUser;
    private String mShieldUserId;
    private String mText;
    private Integer mType;
    private final IChronosDanmakuReportCallback reportCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChronosDanmakuReportBottomSheet(Context context, IChronosDanmakuReportCallback reportCallback, int theme) {
        super(context);
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportCallback, "reportCallback");
        this.reportCallback = reportCallback;
        this.mCheckedPos = -1;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window3 = getWindow();
        WindowManager.LayoutParams layoutParams = window3 != null ? window3.getAttributes() : null;
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 80;
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setAttributes(layoutParams);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.bili_player_chronos_danmaku_halfscreen_report_bottom_dialog);
        View findViewById = findViewById(R.id.report_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCloseView = findViewById;
        View findViewById2 = findViewById(R.id.danmaku_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mDanmakuTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.radio_group);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mRadioGroup = (PlayerRadioGridGroup) findViewById3;
        View findViewById4 = findViewById(R.id.cb_shield_user);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mShieldCheckBox = (CheckBox) findViewById4;
        View findViewById5 = findViewById(R.id.confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mConfirmView = (TextView) findViewById5;
        this.mConfirmView.setEnabled(false);
        this.mRadioGroup.setSpanCount(2);
        this.mRadioGroup.setBoxTextColor(com.bilibili.lib.theme.R.color.Ga8);
        if (theme == 2) {
            this.mConfirmView.setBackgroundResource(tv.danmaku.biliplayer.baseres.R.drawable.chronos_halfscreen_danmaku_report_comfirm_green_bg);
            this.mShieldCheckBox.setButtonDrawable(tv.danmaku.biliplayer.baseres.R.drawable.selector_checkbox_player_green);
        } else {
            this.mShieldCheckBox.setButtonDrawable(tv.danmaku.biliplayer.baseres.R.drawable.selector_checkbox_player);
            this.mConfirmView.setBackgroundResource(tv.danmaku.biliplayer.baseres.R.drawable.chronos_halfscreen_danmaku_report_comfirm_bg);
        }
        this.mShieldCheckBox.setOnCheckedChangeListener(this);
        this.mRadioGroup.setItemCheckedChangeListener(this);
        this.mConfirmView.setOnClickListener(this);
        this.mCloseView.setOnClickListener(this);
    }

    public /* synthetic */ ChronosDanmakuReportBottomSheet(Context context, IChronosDanmakuReportCallback iChronosDanmakuReportCallback, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iChronosDanmakuReportCallback, (i2 & 4) != 0 ? 1 : i);
    }

    /* compiled from: ChronosDanmakuReportBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/ChronosDanmakuReportBottomSheet$Companion;", "", "<init>", "()V", "CLOSE_BY_OTHER", "", "CLOSE_BY_SUBMIT", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mRadioGroup.clearCheckState();
        this.mConfirmView.setEnabled(false);
    }

    public static /* synthetic */ void setReportedDanmaku$default(ChronosDanmakuReportBottomSheet chronosDanmakuReportBottomSheet, String str, int i, String str2, long j, long j2, String str3, boolean z, String str4, int i2, Object obj) {
        String str5;
        if ((i2 & 128) == 0) {
            str5 = str4;
        } else {
            str5 = null;
        }
        chronosDanmakuReportBottomSheet.setReportedDanmaku(str, i, str2, j, j2, str3, z, str5);
    }

    public final void setReportedDanmaku(String danmakuId, int type, String text, long appearanceTime, long duration, String shieldUserId, boolean shieldUser, String oid) {
        Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        this.mDanmakuId = danmakuId;
        this.mType = Integer.valueOf(type);
        this.mText = text;
        this.mAppearanceTime = Long.valueOf(appearanceTime);
        this.mDuration = Long.valueOf(duration);
        this.mShieldUserId = shieldUserId;
        this.mShieldUser = shieldUser;
        this.mOid = oid;
        this.mShieldCheckBox.setChecked(this.mShieldUser);
        this.mDanmakuTextView.setText(text);
        String[] danmakuReportReson = getContext().getResources().getStringArray(tv.danmaku.biliplayer.baseres.R.array.danmaku_report_reason);
        Intrinsics.checkNotNullExpressionValue(danmakuReportReson, "getStringArray(...)");
        this.mReportIndexArray = getContext().getResources().getStringArray(tv.danmaku.biliplayer.baseres.R.array.danmaku_report_index);
        this.mRadioGroup.setData(danmakuReportReson);
    }

    public final int getDismissReason() {
        return this.mCloseReason;
    }

    public final boolean getShieldUser() {
        return this.mShieldUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.report_close;
        if (valueOf != null && valueOf.intValue() == i) {
            dismiss();
            return;
        }
        int i2 = R.id.confirm;
        if (valueOf != null && valueOf.intValue() == i2) {
            this.mCloseReason = 1;
            commitReport();
        }
    }

    private final void commitReport() {
        int checkedPos = this.mCheckedPos;
        if (this.mReportIndexArray == null) {
            return;
        }
        if (checkedPos >= 0) {
            String[] strArr = this.mReportIndexArray;
            Intrinsics.checkNotNull(strArr);
            if (checkedPos < strArr.length) {
                String[] strArr2 = this.mReportIndexArray;
                Intrinsics.checkNotNull(strArr2);
                String reason = strArr2[checkedPos];
                IChronosDanmakuReportCallback iChronosDanmakuReportCallback = this.reportCallback;
                String str = this.mDanmakuId;
                if (str == null) {
                    str = "";
                }
                String str2 = this.mShieldUserId;
                if (str2 == null) {
                    str2 = "";
                }
                iChronosDanmakuReportCallback.onChronosDanmakuReport(str, reason, str2, this.mShieldUser, this.mOid);
            }
        }
        dismiss();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.widget.PlayerRadioGridGroup.OnItemCheckedChangeListener
    public void onItemChecked(int oldChecked, int newChecked) {
        this.mConfirmView.setEnabled(true);
        this.mCheckedPos = newChecked;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.mShieldUser = isChecked;
    }
}