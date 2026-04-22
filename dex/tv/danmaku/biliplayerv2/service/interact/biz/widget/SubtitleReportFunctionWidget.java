package tv.danmaku.biliplayerv2.service.interact.biz.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.NewPlayerUtilsKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.R;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportSubtitle;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiService;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.EntryScannerKt;

/* compiled from: SubtitleReportFunctionWidget.kt */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00014\u0018\u0000 R2\u00020\u0001:\u0002RSB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u0003H\u0015J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0016J\b\u0010:\u001a\u000200H\u0016J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000200H\u0002J\u0018\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u000200H\u0016J\u0010\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020\u0016H\u0016J\b\u0010E\u001a\u000200H\u0002J&\u0010F\u001a\u0002002\b\u0010G\u001a\u0004\u0018\u00010\u001f2\b\u0010H\u001a\u0004\u0018\u00010\u001f2\b\u0010I\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010J\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0KH\u0002J\u0012\u0010L\u001a\u0002002\b\u0010M\u001a\u0004\u0018\u00010NH\u0003J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\u001fH\u0002J\b\u0010Q\u001a\u000200H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R#\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105¨\u0006T"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mImm", "Landroid/view/inputmethod/InputMethodManager;", "getMImm", "()Landroid/view/inputmethod/InputMethodManager;", "mImm$delegate", "Lkotlin/Lazy;", "mContentMain", "Landroid/widget/Button;", "mContentVice", "mCommitBtn", "mNewSubtitleEd", "Landroid/widget/EditText;", "mRadioButtons", "Ljava/util/ArrayList;", "Lcom/bilibili/magicasakura/widgets/TintCheckBox;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mPauseWhenInput", "", "mSubtitleMain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;", "mSubtitleVice", "mSubtitleChecked", "mSubtitleCheckMain", "tag", "", "getTag", "()Ljava/lang/String;", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "mFeedbackReasons", "", "getMFeedbackReasons", "()Ljava/util/List;", "mFeedbackReasons$delegate", "mOnCommitClickListener", "Landroid/view/View$OnClickListener;", "mOnMainContentClickListener", "mOnViceContentClickListener", "clearUserFeedback", "", "updataSubtitleEditor", "mRadioBtnOnClickListener", "mTextWatcher", "tv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget$mTextWatcher$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget$mTextWatcher$1;", "createContentView", "Landroid/view/View;", "adaptScreenType", "onWidgetShow", "onWidgetDismiss", "onConfigurationChanged", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "initSubtitleContent", "updateSubtitleCheck", "mainChecked", "viceChecked", "onRelease", "bindPlayerContainer", "playerContainer", "commit", "reportSubtitleFeedbackCommit", "rowId", "content", "lanCode", "getReasonsGroup", "Lkotlin/Pair;", "initReasons", "parent", "Landroid/widget/LinearLayout;", "showToast", "message", "checkButtonState", "SubtitleType", "Configuration", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SubtitleReportFunctionWidget extends AbsFunctionWidget {
    public static final String SUBTITLE_AI = "1";
    public static final String SUBTITLE_CC = "0";
    public static final SubtitleType SubtitleType = new SubtitleType(null);
    private Button mCommitBtn;
    private Button mContentMain;
    private Button mContentVice;
    private final Lazy mFeedbackReasons$delegate;
    private final Lazy mImm$delegate;
    private EditText mNewSubtitleEd;
    private final View.OnClickListener mOnCommitClickListener;
    private final View.OnClickListener mOnMainContentClickListener;
    private final View.OnClickListener mOnViceContentClickListener;
    private boolean mPauseWhenInput;
    private PlayerContainer mPlayerContainer;
    private final View.OnClickListener mRadioBtnOnClickListener;
    private ArrayList<TintCheckBox> mRadioButtons;
    private boolean mSubtitleCheckMain;
    private ReportSubtitle.SubtitleMeta mSubtitleChecked;
    private ReportSubtitle.SubtitleMeta mSubtitleMain;
    private ReportSubtitle.SubtitleMeta mSubtitleVice;
    private final SubtitleReportFunctionWidget$mTextWatcher$1 mTextWatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v10, types: [tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$mTextWatcher$1] */
    public SubtitleReportFunctionWidget(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mImm$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda0
            public final Object invoke() {
                InputMethodManager mImm_delegate$lambda$0;
                mImm_delegate$lambda$0 = SubtitleReportFunctionWidget.mImm_delegate$lambda$0(context);
                return mImm_delegate$lambda$0;
            }
        });
        this.mRadioButtons = new ArrayList<>();
        this.mFeedbackReasons$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda1
            public final Object invoke() {
                List mFeedbackReasons_delegate$lambda$0;
                mFeedbackReasons_delegate$lambda$0 = SubtitleReportFunctionWidget.mFeedbackReasons_delegate$lambda$0();
                return mFeedbackReasons_delegate$lambda$0;
            }
        });
        this.mOnCommitClickListener = new View.OnClickListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleReportFunctionWidget.mOnCommitClickListener$lambda$0(SubtitleReportFunctionWidget.this, view2);
            }
        };
        this.mOnMainContentClickListener = new View.OnClickListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleReportFunctionWidget.mOnMainContentClickListener$lambda$0(SubtitleReportFunctionWidget.this, view2);
            }
        };
        this.mOnViceContentClickListener = new View.OnClickListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleReportFunctionWidget.mOnViceContentClickListener$lambda$0(SubtitleReportFunctionWidget.this, view2);
            }
        };
        this.mRadioBtnOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleReportFunctionWidget.this.checkButtonState();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$mTextWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SubtitleReportFunctionWidget.this.checkButtonState();
            }
        };
    }

    private final InputMethodManager getMImm() {
        return (InputMethodManager) this.mImm$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputMethodManager mImm_delegate$lambda$0(Context $context) {
        Object systemService = $context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    /* compiled from: SubtitleReportFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget$SubtitleType;", "", "<init>", "()V", "SUBTITLE_CC", "", "SUBTITLE_AI", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubtitleType {
        public /* synthetic */ SubtitleType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private SubtitleType() {
        }
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

    private final List<String> getMFeedbackReasons() {
        return EnhancedUnmodifiabilityKt.unmodifiable((List) this.mFeedbackReasons$delegate.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mFeedbackReasons_delegate$lambda$0() {
        String configReason = BLRemoteConfig.getInstance().getString("subtitle_ai_feedback_new", (String) null);
        List reasons = configReason != null ? StringsKt.split$default(configReason, new String[]{","}, false, 0, 6, (Object) null) : null;
        boolean z = false;
        if (reasons != null && (!reasons.isEmpty())) {
            z = true;
        }
        if (!z) {
            return StringsKt.split$default("字幕不同步,字幕错字,单条字幕过长,单条字幕过短,数字展现效果不好", new String[]{","}, false, 0, 6, (Object) null);
        }
        return reasons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnCommitClickListener$lambda$0(SubtitleReportFunctionWidget this$0, View it) {
        this$0.commit();
        Button button = this$0.mCommitBtn;
        boolean z = false;
        if (button != null && button.isSelected()) {
            z = true;
        }
        if (z) {
            PlayerContainer playerContainer = this$0.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getFunctionWidgetService().hideWidget(this$0.getToken());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnMainContentClickListener$lambda$0(SubtitleReportFunctionWidget this$0, View it) {
        if (!this$0.mSubtitleCheckMain) {
            this$0.clearUserFeedback();
            this$0.mSubtitleChecked = this$0.mSubtitleMain;
            this$0.mSubtitleCheckMain = true;
            this$0.updateSubtitleCheck(true, false);
            this$0.updataSubtitleEditor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnViceContentClickListener$lambda$0(SubtitleReportFunctionWidget this$0, View it) {
        if (this$0.mSubtitleCheckMain) {
            this$0.clearUserFeedback();
            this$0.mSubtitleChecked = this$0.mSubtitleVice;
            this$0.mSubtitleCheckMain = false;
            this$0.updateSubtitleCheck(false, true);
            this$0.updataSubtitleEditor();
        }
    }

    private final void clearUserFeedback() {
        Iterable $this$forEach$iv = this.mRadioButtons;
        for (Object element$iv : $this$forEach$iv) {
            TintCheckBox it = (TintCheckBox) element$iv;
            if (it.isChecked()) {
                it.setChecked(false);
            }
        }
        EditText editText = this.mNewSubtitleEd;
        if (editText != null) {
            editText.setText("");
        }
    }

    private final void updataSubtitleEditor() {
        ReportSubtitle.SubtitleMeta subtitleMeta = this.mSubtitleChecked;
        if (Intrinsics.areEqual(subtitleMeta != null ? subtitleMeta.getSubtitleType() : null, "0")) {
            EditText editText = this.mNewSubtitleEd;
            if (editText != null) {
                editText.setVisibility(8);
                return;
            }
            return;
        }
        EditText editText2 = this.mNewSubtitleEd;
        if (editText2 != null) {
            editText2.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.res.ColorStateList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.Button] */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected View createContentView(Context context) {
        Context context2;
        Resources res;
        ColorStateList colorStateList;
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerContainer playerContainer = null;
        View content = LayoutInflater.from(context).inflate(R.layout.bili_player_chronos_ai_subtitle_report, (ViewGroup) null, false);
        this.mContentMain = content != null ? (Button) content.findViewById(R.id.subtitle_content_main) : null;
        this.mContentVice = content != null ? (Button) content.findViewById(R.id.subtitle_content_vice) : null;
        this.mCommitBtn = content != null ? (Button) content.findViewById(R.id.subtitle_commit) : null;
        this.mNewSubtitleEd = content != null ? (EditText) content.findViewById(R.id.subtitle_new) : null;
        LinearLayout reasonsGroupView = content != null ? (LinearLayout) content.findViewById(R.id.subtitle_reasons) : null;
        adaptScreenType();
        initReasons(reasonsGroupView);
        Button button = this.mCommitBtn;
        if (button != null && (context2 = button.getContext()) != null && (res = context2.getResources()) != null) {
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer = playerContainer2;
            }
            int theme = playerContainer.getPlayerParams().getConfig().getTheme();
            if (theme == 2) {
                colorStateList = res.getColorStateList(tv.danmaku.biliplayer.baseres.R.color.selector_bplayer_selector_panel_text_green);
            } else {
                colorStateList = res.getColorStateList(tv.danmaku.biliplayer.baseres.R.color.selector_bplayer_selector_panel_text_pink);
            }
            playerContainer = colorStateList;
        }
        ?? r2 = playerContainer;
        ?? r3 = this.mCommitBtn;
        if (r3 != 0) {
            r3.setTextColor(r2);
        }
        Intrinsics.checkNotNull(content);
        return content;
    }

    private final void adaptScreenType() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        if (playerContainer.getControlContainerService().getScreenModeType() == ScreenModeType.VERTICAL_FULLSCREEN) {
            Button button = this.mContentMain;
            ViewGroup.LayoutParams layoutParams = button != null ? button.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            layoutParams2.setMarginEnd((int) DpUtils.dp2px(playerContainer3.getContext(), 12.0f));
            Button button2 = this.mContentMain;
            if (button2 != null) {
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.mCommitBtn;
            ViewGroup.LayoutParams layoutParams3 = button3 != null ? button3.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            PlayerContainer playerContainer4 = this.mPlayerContainer;
            if (playerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer4;
            }
            ((ConstraintLayout.LayoutParams) layoutParams4).bottomMargin = (int) DpUtils.dp2px(playerContainer2.getContext(), 46.0f);
            Button button4 = this.mCommitBtn;
            if (button4 != null) {
                button4.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        super.onWidgetShow();
        Button button = this.mContentMain;
        if (button != null) {
            button.setOnClickListener(this.mOnMainContentClickListener);
        }
        Button button2 = this.mContentVice;
        if (button2 != null) {
            button2.setOnClickListener(this.mOnViceContentClickListener);
        }
        Button button3 = this.mCommitBtn;
        if (button3 != null) {
            button3.setOnClickListener(this.mOnCommitClickListener);
        }
        EditText editText = this.mNewSubtitleEd;
        if (editText != null) {
            editText.addTextChangedListener(this.mTextWatcher);
        }
        EditText editText2 = this.mNewSubtitleEd;
        if (editText2 != null) {
            editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$onWidgetShow$1
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    PlayerContainer playerContainer;
                    if (event == null || event.getKeyCode() != 66) {
                        return false;
                    }
                    if (event.getAction() == 1) {
                        playerContainer = SubtitleReportFunctionWidget.this.mPlayerContainer;
                        if (playerContainer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainer = null;
                        }
                        Object systemService = playerContainer.getContext().getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        InputMethodManager imm = (InputMethodManager) systemService;
                        imm.hideSoftInputFromWindow(v != null ? v.getWindowToken() : null, 0);
                    }
                    return true;
                }
            });
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        this.mPauseWhenInput = playerContainer.getPlayerCoreService().getState() == 4;
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        playerContainer2.getPlayerCoreService().pause();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        IBinder it;
        super.onWidgetDismiss();
        EditText editText = this.mNewSubtitleEd;
        PlayerContainer playerContainer = null;
        if (editText != null && (it = editText.getWindowToken()) != null) {
            getMImm().hideSoftInputFromWindow(it, 0, null);
        }
        if (this.mPauseWhenInput) {
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer = playerContainer2;
            }
            playerContainer.getPlayerCoreService().resume();
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public void onConfigurationChanged(AbsFunctionWidget.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration instanceof Configuration) {
            this.mSubtitleMain = ((Configuration) configuration).getSubtitleMain();
            this.mSubtitleVice = ((Configuration) configuration).getSubtitleVice();
        }
        initSubtitleContent();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initSubtitleContent() {
        ReportSubtitle.SubtitleMeta subtitleMeta;
        Button button = this.mContentMain;
        if (button != null) {
            ReportSubtitle.SubtitleMeta subtitleMeta2 = this.mSubtitleMain;
            button.setText(subtitleMeta2 != null ? subtitleMeta2.getContent() : null);
        }
        if (this.mSubtitleVice != null) {
            ReportSubtitle.SubtitleMeta subtitleMeta3 = this.mSubtitleVice;
            if (!TextUtils.isEmpty(subtitleMeta3 != null ? subtitleMeta3.getContent() : null)) {
                Button button2 = this.mContentVice;
                if (button2 != null) {
                    ReportSubtitle.SubtitleMeta subtitleMeta4 = this.mSubtitleVice;
                    button2.setText(subtitleMeta4 != null ? subtitleMeta4.getContent() : null);
                }
                Button button3 = this.mContentVice;
                if (button3 != null) {
                    button3.setVisibility(0);
                }
                this.mSubtitleChecked = this.mSubtitleVice;
                this.mSubtitleCheckMain = false;
                subtitleMeta = this.mSubtitleMain;
                if (!TextUtils.isEmpty(subtitleMeta != null ? subtitleMeta.getContent() : null)) {
                    Button button4 = this.mContentMain;
                    if (button4 != null) {
                        button4.setVisibility(8);
                    }
                    this.mSubtitleCheckMain = false;
                } else {
                    Button button5 = this.mContentMain;
                    if (button5 != null) {
                        button5.setVisibility(0);
                    }
                    this.mSubtitleCheckMain = true;
                    this.mSubtitleChecked = this.mSubtitleMain;
                }
                updateSubtitleCheck(this.mSubtitleCheckMain, true ^ this.mSubtitleCheckMain);
                updataSubtitleEditor();
            }
        }
        Button button6 = this.mContentVice;
        if (button6 != null) {
            button6.setVisibility(8);
        }
        subtitleMeta = this.mSubtitleMain;
        if (!TextUtils.isEmpty(subtitleMeta != null ? subtitleMeta.getContent() : null)) {
        }
        updateSubtitleCheck(this.mSubtitleCheckMain, true ^ this.mSubtitleCheckMain);
        updataSubtitleEditor();
    }

    private final void updateSubtitleCheck(boolean mainChecked, boolean viceChecked) {
        Button button = this.mContentMain;
        if (button != null) {
            button.setSelected(mainChecked);
        }
        Button button2 = this.mContentVice;
        if (button2 != null) {
            button2.setSelected(viceChecked);
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Resources resources = playerContainer.getContext().getResources();
        Drawable checkedBg = resources.getDrawable(tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_stroke_pink_4dp);
        Drawable unCheckedBg = resources.getDrawable(tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_stroke_gray_a10_4dp);
        Button button3 = this.mContentMain;
        boolean z = false;
        if (button3 != null && button3.isSelected()) {
            z = true;
        }
        if (z) {
            Button button4 = this.mContentMain;
            if (button4 != null) {
                button4.setBackground(checkedBg);
            }
            Button button5 = this.mContentVice;
            if (button5 != null) {
                button5.setBackground(unCheckedBg);
                return;
            }
            return;
        }
        Button button6 = this.mContentMain;
        if (button6 != null) {
            button6.setBackground(unCheckedBg);
        }
        Button button7 = this.mContentVice;
        if (button7 != null) {
            button7.setBackground(checkedBg);
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

    private final void commit() {
        Editable text;
        String obj;
        String subtitleType;
        Pair reasonsGroup = getReasonsGroup();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        ReportSubtitle.SubtitleMeta subtitleMeta = this.mSubtitleChecked;
        String subtitleId = (subtitleMeta == null || (subtitleId = subtitleMeta.getSubtitleId()) == null) ? "" : "";
        if (!StringsKt.isBlank(subtitleId)) {
            CharSequence charSequence = (CharSequence) reasonsGroup.getSecond();
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                EditText editText = this.mNewSubtitleEd;
                Editable text2 = editText != null ? editText.getText() : null;
                if (text2 == null || StringsKt.isBlank(text2)) {
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (displayParams == null) {
                return;
            }
            long cid = displayParams.getCid();
            long avid = displayParams.getAvid();
            ReportSubtitle.SubtitleMeta subtitleMeta2 = this.mSubtitleChecked;
            String subtitleType2 = (subtitleMeta2 == null || (subtitleType = subtitleMeta2.getSubtitleType()) == null) ? "" : subtitleType;
            String str = (String) reasonsGroup.getFirst();
            if (str == null) {
                str = "0";
            }
            String tagId = str;
            String str2 = (String) reasonsGroup.getSecond();
            String reasons = str2 == null ? "" : str2;
            ReportSubtitle.SubtitleMeta subtitleMeta3 = this.mSubtitleChecked;
            String content = subtitleMeta3 != null ? subtitleMeta3.getContent() : null;
            EditText editText2 = this.mNewSubtitleEd;
            String description = (editText2 == null || (text = editText2.getText()) == null || (obj = text.toString()) == null) ? null : StringsKt.trim(obj).toString();
            ReportSubtitle.SubtitleMeta subtitleMeta4 = this.mSubtitleChecked;
            String rowId = subtitleMeta4 != null ? subtitleMeta4.getRowId() : null;
            ReportSubtitle.SubtitleMeta subtitleMeta5 = this.mSubtitleChecked;
            String from = subtitleMeta5 != null ? subtitleMeta5.getFrom() : null;
            ReportSubtitle.SubtitleMeta subtitleMeta6 = this.mSubtitleChecked;
            String to = subtitleMeta6 != null ? subtitleMeta6.getTo() : null;
            ReportSubtitle.SubtitleMeta subtitleMeta7 = this.mSubtitleChecked;
            String lanCode = subtitleMeta7 != null ? subtitleMeta7.getLanguageCode() : null;
            BiliCall<GeneralResponse<String>> reportSubtitleV2 = ((InteractApiService) ServiceGenerator.createService(InteractApiService.class)).reportSubtitleV2(String.valueOf(cid), String.valueOf(avid), subtitleType2, subtitleId, tagId, reasons, content, description, rowId, from, to);
            if (reportSubtitleV2 != null) {
                reportSubtitleV2.enqueue(new BiliApiDataCallback<String>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget$commit$1
                    public void onDataSuccess(String data) {
                        Context mContext;
                        SubtitleReportFunctionWidget subtitleReportFunctionWidget = SubtitleReportFunctionWidget.this;
                        mContext = SubtitleReportFunctionWidget.this.getMContext();
                        String string = mContext.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1380);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        subtitleReportFunctionWidget.showToast(string);
                    }

                    public void onError(Throwable t) {
                        Context mContext;
                        SubtitleReportFunctionWidget subtitleReportFunctionWidget = SubtitleReportFunctionWidget.this;
                        mContext = SubtitleReportFunctionWidget.this.getMContext();
                        String string = mContext.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_948);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        subtitleReportFunctionWidget.showToast(string);
                    }
                });
            }
            reportSubtitleFeedbackCommit(rowId, content, lanCode);
        }
    }

    private final void reportSubtitleFeedbackCommit(String rowId, String content, String lanCode) {
        String isMainSubtitleCheck;
        if (this.mSubtitleVice == null) {
            isMainSubtitleCheck = "0";
        } else if (this.mSubtitleCheckMain) {
            isMainSubtitleCheck = "1";
        } else {
            isMainSubtitleCheck = "2";
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_subtitle_edit, "row_id", rowId == null ? "" : rowId, "subtitle_content", content == null ? "" : content, "language_code", lanCode == null ? "" : lanCode, "subtitles_rel", isMainSubtitleCheck));
    }

    private final Pair<String, String> getReasonsGroup() {
        CharSequence text;
        Object reasonsContent = null;
        Object reasonsTag = null;
        Iterable $this$forEach$iv = this.mRadioButtons;
        for (Object element$iv : $this$forEach$iv) {
            TintCheckBox it = (TintCheckBox) element$iv;
            if (it.isChecked()) {
                if (reasonsContent != null) {
                    Intrinsics.checkNotNullExpressionValue(it.getText(), "getText(...)");
                    reasonsContent = reasonsContent + "," + ((Object) StringsKt.trim(text));
                    reasonsTag = reasonsTag + "," + it.getTag();
                } else {
                    CharSequence text2 = it.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    reasonsContent = StringsKt.trim(text2).toString();
                    reasonsTag = it.getTag().toString();
                }
            }
        }
        return new Pair<>(reasonsTag, reasonsContent);
    }

    private final void initReasons(LinearLayout parent) {
        int i;
        if (parent == null || getMFeedbackReasons() == null) {
            return;
        }
        List<String> mFeedbackReasons = getMFeedbackReasons();
        Intrinsics.checkNotNull(mFeedbackReasons);
        int i2 = 2;
        int count = new BigDecimal(mFeedbackReasons.size()).divide(new BigDecimal(2), 4).intValue();
        ArrayList linearLayouts = new ArrayList(count);
        int i3 = 0;
        while (true) {
            i = 0;
            if (i3 >= count) {
                break;
            }
            LinearLayout content = new LinearLayout(getMContext());
            content.setHorizontalGravity(0);
            linearLayouts.add(content);
            i3++;
        }
        List<String> mFeedbackReasons2 = getMFeedbackReasons();
        Intrinsics.checkNotNull(mFeedbackReasons2);
        int i4 = 0;
        for (String text : mFeedbackReasons2) {
            int i5 = i4;
            i4++;
            TintCheckBox tintRadioButton = new TintCheckBox(getMContext(), (AttributeSet) null, 16842878);
            List textId = StringsKt.split$default(text, new String[]{EntryScannerKt.PATH_SEPARATOR}, false, 0, 6, (Object) null);
            tintRadioButton.setText("  " + textId.get(i));
            tintRadioButton.setTag(textId.get(1));
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            ColorStateList colorStateList = playerContainer.getContext().getResources().getColorStateList(tv.danmaku.biliplayer.baseres.R.color.selector_bplayer_wh0_u_pink);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "getColorStateList(...)");
            tintRadioButton.setTextColor(colorStateList);
            tintRadioButton.setBackground((Drawable) null);
            tintRadioButton.setButtonDrawable(tv.danmaku.biliplayer.baseres.R.drawable.selector_player_selector_panel_edit_switch);
            tintRadioButton.setGravity(16);
            tintRadioButton.setTextSize(i2, 14.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, NewPlayerUtilsKt.toPx(44.0f), 1.0f);
            layoutParams.gravity = 17;
            tintRadioButton.setLayoutParams(layoutParams);
            int paddingBtn = NewPlayerUtilsKt.toPx(13.0f);
            tintRadioButton.setPadding(0, paddingBtn, 0, paddingBtn);
            tintRadioButton.setChecked(false);
            tintRadioButton.setOnClickListener(this.mRadioBtnOnClickListener);
            Object obj = linearLayouts.get((int) Math.floor(i5 / 2.0f));
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            LinearLayout content2 = (LinearLayout) obj;
            content2.addView((View) tintRadioButton, layoutParams);
            if (i5 % 2 == 0) {
                List<String> mFeedbackReasons3 = getMFeedbackReasons();
                Intrinsics.checkNotNull(mFeedbackReasons3);
                if (i5 != mFeedbackReasons3.size() - 1) {
                    this.mRadioButtons.add(tintRadioButton);
                    i2 = 2;
                    i = 0;
                }
            }
            parent.addView(content2);
            this.mRadioButtons.add(tintRadioButton);
            i2 = 2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String message) {
        PlayerToast toast = new PlayerToast.Builder().toastItemType(17).location(33).duration(PlayerToastConfig.DURATION_2).setExtraString(PlayerToastConfig.EXTRA_TITLE, message).build();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getToastService().showToast(toast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkButtonState() {
        Editable text;
        String obj;
        String obj2;
        boolean selected = false;
        int i = 0;
        int size = this.mRadioButtons.size();
        while (true) {
            if (i >= size) {
                break;
            } else if (!this.mRadioButtons.get(i).isChecked()) {
                i++;
            } else {
                selected = true;
                break;
            }
        }
        if (!selected) {
            EditText editText = this.mNewSubtitleEd;
            boolean z = false;
            if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null && (obj2 = StringsKt.trim(obj).toString()) != null) {
                if (obj2.length() > 0) {
                    z = true;
                }
            }
            selected = z;
        }
        Button button = this.mCommitBtn;
        if (button != null) {
            button.setSelected(selected);
        }
    }

    /* compiled from: SubtitleReportFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget$Configuration;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "subtitleMain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;", "subtitleVice", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;)V", "getSubtitleMain", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;", "setSubtitleMain", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$SubtitleMeta;)V", "getSubtitleVice", "setSubtitleVice", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Configuration extends AbsFunctionWidget.Configuration {
        private ReportSubtitle.SubtitleMeta subtitleMain;
        private ReportSubtitle.SubtitleMeta subtitleVice;

        public Configuration(ReportSubtitle.SubtitleMeta subtitleMain, ReportSubtitle.SubtitleMeta subtitleVice) {
            this.subtitleMain = subtitleMain;
            this.subtitleVice = subtitleVice;
        }

        public final ReportSubtitle.SubtitleMeta getSubtitleMain() {
            return this.subtitleMain;
        }

        public final void setSubtitleMain(ReportSubtitle.SubtitleMeta subtitleMeta) {
            this.subtitleMain = subtitleMeta;
        }

        public final ReportSubtitle.SubtitleMeta getSubtitleVice() {
            return this.subtitleVice;
        }

        public final void setSubtitleVice(ReportSubtitle.SubtitleMeta subtitleMeta) {
            this.subtitleVice = subtitleMeta;
        }
    }
}