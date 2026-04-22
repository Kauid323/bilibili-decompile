package tv.danmaku.biliplayerv2.service.interact.biz.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.R;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.PlayerRadioGridGroup;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosReportFunctionWidget.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001HB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u00102\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u00104\u001a\u00020,2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00105\u001a\u00020,H\u0016J\b\u00106\u001a\u00020,H\u0016J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020,H\u0016J\u0010\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020\u0012H\u0016J\u0012\u0010>\u001a\u00020,2\b\u0010?\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010@\u001a\u00020,2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020*H\u0016J\b\u0010D\u001a\u00020*H\u0002J\u0018\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020&H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010$\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/X\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u000e\u00101\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/ChronosReportFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "Landroid/view/View$OnClickListener;", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mConfirm", "Landroid/widget/TextView;", "mTitle", "mReportDanmakuText", "mNestedScrollView", "Landroidx/core/widget/NestedScrollView;", "mReportContentView", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup;", "mShieldDmCheckBox", "Landroid/widget/CheckBox;", "mDanmakuId", "mDanmakuText", "mAppearanceTime", "", "mDuration", "mDanmakuUserId", "mOid", "mDismissCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "reason", "", "shieldUser", "", "mCloseReason", "mReportIndexArray", "", "[Ljava/lang/String;", "mCheckedPos", "createContentView", "Landroid/view/View;", "initContent", "onWidgetShow", "onWidgetDismiss", "onConfigurationChanged", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "initReportPanel", "onRelease", "bindPlayerContainer", "playerContainer", "onClick", "v", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "getSettingChecked", "onItemChecked", "oldChecked", "newChecked", "Configuration", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosReportFunctionWidget extends AbsFunctionWidget implements View.OnClickListener, PlayerRadioGridGroup.OnItemCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    private long mAppearanceTime;
    private int mCheckedPos;
    private int mCloseReason;
    private TextView mConfirm;
    private String mDanmakuId;
    private String mDanmakuText;
    private String mDanmakuUserId;
    private Function2<? super Integer, ? super Boolean, Unit> mDismissCallback;
    private long mDuration;
    private NestedScrollView mNestedScrollView;
    private String mOid;
    private PlayerContainer mPlayerContainer;
    private PlayerRadioGridGroup mReportContentView;
    private TextView mReportDanmakuText;
    private String[] mReportIndexArray;
    private CheckBox mShieldDmCheckBox;
    private TextView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChronosReportFunctionWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCheckedPos = -1;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public String getTag() {
        return "SubtitleReportFunctionWidget";
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public FunctionWidgetConfig getFunctionWidgetConfig() {
        FunctionWidgetConfig.Builder builder = new FunctionWidgetConfig.Builder();
        builder.dismissWhenActivityStop(true);
        builder.dismissWhenScreenModeChange(true);
        builder.dismissWhenVideoChange(true);
        builder.dismissWhenVideoCompleted(true);
        builder.persistent(false);
        builder.changeOrientationDisableWhenShow(true);
        return builder.build();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected View createContentView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerContainer playerContainer = null;
        View content = LayoutInflater.from(context).inflate(R.layout.bili_player_chronos_danmaku_report, (ViewGroup) null, false);
        this.mReportDanmakuText = (TextView) content.findViewById(R.id.danmaku_text);
        this.mNestedScrollView = content.findViewById(R.id.nested_report_group);
        this.mTitle = (TextView) content.findViewById(R.id.nested_report_title);
        this.mConfirm = (TextView) content.findViewById(R.id.confirm);
        TextView textView = this.mConfirm;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.mConfirm;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
        this.mReportContentView = (PlayerRadioGridGroup) content.findViewById(R.id.radio_group);
        PlayerRadioGridGroup playerRadioGridGroup = this.mReportContentView;
        if (playerRadioGridGroup != null) {
            playerRadioGridGroup.setSpanCount(2);
        }
        PlayerRadioGridGroup playerRadioGridGroup2 = this.mReportContentView;
        if (playerRadioGridGroup2 != null) {
            playerRadioGridGroup2.setItemCheckedChangeListener(this);
        }
        this.mShieldDmCheckBox = (CheckBox) content.findViewById(R.id.danmaku_report_cb_shield_user);
        CheckBox checkBox = this.mShieldDmCheckBox;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(this);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer = playerContainer2;
        }
        int theme = playerContainer.getPlayerParams().getConfig().getTheme();
        if (theme == 2) {
            CheckBox checkBox2 = this.mShieldDmCheckBox;
            if (checkBox2 != null) {
                checkBox2.setButtonDrawable(tv.danmaku.biliplayer.baseres.R.drawable.selector_checkbox_player_green);
            }
        } else {
            CheckBox checkBox3 = this.mShieldDmCheckBox;
            if (checkBox3 != null) {
                checkBox3.setButtonDrawable(tv.danmaku.biliplayer.baseres.R.drawable.selector_checkbox_player);
            }
        }
        initContent(context);
        Intrinsics.checkNotNull(content);
        return content;
    }

    private final void initContent(Context context) {
        if (context == null) {
            return;
        }
        String[] danmakuReportReson = context.getResources().getStringArray(tv.danmaku.biliplayer.baseres.R.array.danmaku_report_reason);
        Intrinsics.checkNotNullExpressionValue(danmakuReportReson, "getStringArray(...)");
        this.mReportIndexArray = context.getResources().getStringArray(tv.danmaku.biliplayer.baseres.R.array.danmaku_report_index);
        PlayerRadioGridGroup playerRadioGridGroup = this.mReportContentView;
        if (playerRadioGridGroup != null) {
            playerRadioGridGroup.setData(danmakuReportReson);
        }
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(bili.resource.playerbaseres.R.string.playerbaseres_global_string_105);
        }
        PlayerRadioGridGroup playerRadioGridGroup2 = this.mReportContentView;
        Intrinsics.checkNotNull(playerRadioGridGroup2);
        ViewGroup.LayoutParams layoutParams = playerRadioGridGroup2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        PlayerRadioGridGroup playerRadioGridGroup3 = this.mReportContentView;
        Intrinsics.checkNotNull(playerRadioGridGroup3);
        layoutParams2.topMargin = -((int) DpUtils.dp2px(playerRadioGridGroup3.getContext(), 5.0f));
        PlayerRadioGridGroup playerRadioGridGroup4 = this.mReportContentView;
        if (playerRadioGridGroup4 != null) {
            playerRadioGridGroup4.setLayoutParams(layoutParams2);
        }
        CheckBox checkBox = this.mShieldDmCheckBox;
        if (checkBox != null) {
            checkBox.setVisibility(0);
        }
        this.mCheckedPos = -1;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        super.onWidgetShow();
        this.mCloseReason = 0;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        super.onWidgetDismiss();
        PlayerRadioGridGroup playerRadioGridGroup = this.mReportContentView;
        if (playerRadioGridGroup != null) {
            playerRadioGridGroup.clearCheckState();
        }
        TextView textView = this.mConfirm;
        if (textView != null) {
            textView.setEnabled(false);
        }
        TextView textView2 = this.mConfirm;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(getMContext(), com.bilibili.app.comm.baseres.R.color.white_alpha20));
        }
        Function2<? super Integer, ? super Boolean, Unit> function2 = this.mDismissCallback;
        if (function2 != null) {
            Integer valueOf = Integer.valueOf(this.mCloseReason);
            CheckBox checkBox = this.mShieldDmCheckBox;
            function2.invoke(valueOf, checkBox != null ? Boolean.valueOf(checkBox.isChecked()) : null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public void onConfigurationChanged(AbsFunctionWidget.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration instanceof Configuration) {
            this.mDanmakuId = ((Configuration) configuration).getDanmakuId();
            this.mDanmakuText = ((Configuration) configuration).getText();
            this.mAppearanceTime = ((Configuration) configuration).getAppearanceTime();
            this.mDuration = ((Configuration) configuration).getDuration();
            this.mDanmakuUserId = ((Configuration) configuration).getDanmakuUserId();
            this.mOid = ((Configuration) configuration).getOid();
            this.mDismissCallback = ((Configuration) configuration).getOnDismiss();
            initReportPanel();
        }
    }

    private final void initReportPanel() {
        PlayerRadioGridGroup playerRadioGridGroup = this.mReportContentView;
        if (playerRadioGridGroup != null) {
            playerRadioGridGroup.clearCheckState();
        }
        this.mCheckedPos = -1;
        if (this.mConfirm != null) {
            TextView textView = this.mConfirm;
            if (textView != null) {
                textView.setEnabled(false);
            }
            TextView textView2 = this.mConfirm;
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.getColor(getMContext(), com.bilibili.app.comm.baseres.R.color.white_alpha20));
            }
        }
        TextView textView3 = this.mReportDanmakuText;
        if (textView3 != null) {
            String str = this.mDanmakuText;
            if (str == null) {
                str = "";
            }
            textView3.setText(str);
        }
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, 0);
        }
        boolean isChecked = getSettingChecked();
        CheckBox checkBox = this.mShieldDmCheckBox;
        if (checkBox != null) {
            checkBox.setChecked(isChecked);
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onRelease() {
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int checkedPos;
        if (!TextUtils.isEmpty(this.mDanmakuId) && this.mReportIndexArray != null && (checkedPos = this.mCheckedPos) >= 0) {
            String[] strArr = this.mReportIndexArray;
            Intrinsics.checkNotNull(strArr);
            if (checkedPos >= strArr.length) {
                return;
            }
            CheckBox checkBox = this.mShieldDmCheckBox;
            boolean shieldUser = checkBox != null ? checkBox.isChecked() : false;
            PlayerContainer playerContainer = this.mPlayerContainer;
            PlayerContainer playerContainer2 = null;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            IInteractLayerService interactLayerService = playerContainer.getInteractLayerService();
            String str = this.mDanmakuId;
            Intrinsics.checkNotNull(str);
            String[] strArr2 = this.mReportIndexArray;
            Intrinsics.checkNotNull(strArr2);
            String str2 = strArr2[checkedPos];
            String str3 = this.mDanmakuUserId;
            if (str3 == null) {
                str3 = "";
            }
            IInteractLayerService.CC.reportDanmaku$default(interactLayerService, str, str2, shieldUser, str3, this.mOid, false, false, null, null, 480, null);
            this.mCloseReason = 1;
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer3;
            }
            playerContainer2.getFunctionWidgetService().hideWidget(getToken());
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, isChecked);
    }

    private final boolean getSettingChecked() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        return playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, true);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.widget.PlayerRadioGridGroup.OnItemCheckedChangeListener
    public void onItemChecked(int oldChecked, int newChecked) {
        TextView textView = this.mConfirm;
        if (textView != null) {
            textView.setText(getMContext().getString(bili.resource.common.R.string.common_global_string_202));
        }
        TextView textView2 = this.mConfirm;
        if (textView2 != null) {
            textView2.setEnabled(true);
        }
        TextView textView3 = this.mConfirm;
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.getColor(getMContext(), 17170443));
        }
        this.mCheckedPos = newChecked;
    }

    /* compiled from: ChronosReportFunctionWidget.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\r¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019RC\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/ChronosReportFunctionWidget$Configuration;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "reportType", "", "danmakuId", "", "oid", "text", "appearanceTime", "", "duration", "danmakuUserId", "onDismiss", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "reason", "", "shildUser", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getReportType", "()I", "getDanmakuId", "()Ljava/lang/String;", "getOid", "getText", "getAppearanceTime", "()J", "getDuration", "getDanmakuUserId", "getOnDismiss", "()Lkotlin/jvm/functions/Function2;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Configuration extends AbsFunctionWidget.Configuration {
        private final long appearanceTime;
        private final String danmakuId;
        private final String danmakuUserId;
        private final long duration;
        private final String oid;
        private final Function2<Integer, Boolean, Unit> onDismiss;
        private final int reportType;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public Configuration(int reportType, String danmakuId, String oid, String text, long appearanceTime, long duration, String danmakuUserId, Function2<? super Integer, ? super Boolean, Unit> function2) {
            Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(danmakuUserId, "danmakuUserId");
            Intrinsics.checkNotNullParameter(function2, "onDismiss");
            this.reportType = reportType;
            this.danmakuId = danmakuId;
            this.oid = oid;
            this.text = text;
            this.appearanceTime = appearanceTime;
            this.duration = duration;
            this.danmakuUserId = danmakuUserId;
            this.onDismiss = function2;
        }

        public final int getReportType() {
            return this.reportType;
        }

        public final String getDanmakuId() {
            return this.danmakuId;
        }

        public final String getOid() {
            return this.oid;
        }

        public final String getText() {
            return this.text;
        }

        public final long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final String getDanmakuUserId() {
            return this.danmakuUserId;
        }

        public final Function2<Integer, Boolean, Unit> getOnDismiss() {
            return this.onDismiss;
        }
    }
}