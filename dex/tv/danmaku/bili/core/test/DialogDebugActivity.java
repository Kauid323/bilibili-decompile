package tv.danmaku.bili.core.test;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: DialogDebugActivity.kt */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001A\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0010\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020DH\u0002J\b\u0010K\u001a\u00020\u0006H\u0002J\u001b\u0010L\u001a\u00020\u0006\"\b\b\u0000\u0010M*\u00020\b*\u0002HMH\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0002J#\u0010Q\u001a\u00020D\"\b\b\u0000\u0010M*\u00020I*\u0002HM2\u0006\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010SJ\f\u0010T\u001a\u00020U*\u00020UH\u0002J\f\u0010V\u001a\u00020U*\u00020UH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001b\u0010\u0010\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\nR\u001b\u0010\u0013\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\nR\u001b\u0010\u0016\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001b\u0010\u0019\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b\"\u0010\u001fR\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b*\u0010\nR\u001b\u0010,\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b-\u0010'R\u001b\u0010/\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b0\u0010'R\u001b\u00102\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b3\u0010'R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b;\u00108R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010B¨\u0006W"}, d2 = {"Ltv/danmaku/bili/core/test/DialogDebugActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "TAG", "", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "mTvTitle$delegate", "Lkotlin/Lazy;", "mTvContent", "getMTvContent", "mTvContent$delegate", "mTvContentCp", "getMTvContentCp", "mTvContentCp$delegate", "mTvLink", "getMTvLink", "mTvLink$delegate", "mTvPositive", "getMTvPositive", "mTvPositive$delegate", "mTvNegative", "getMTvNegative", "mTvNegative$delegate", "mBtnShowDialog", "Landroid/widget/Button;", "getMBtnShowDialog", "()Landroid/widget/Button;", "mBtnShowDialog$delegate", "mBtnClearImageUrl", "getMBtnClearImageUrl", "mBtnClearImageUrl$delegate", "mSwitchShowPic", "Landroid/widget/Switch;", "getMSwitchShowPic", "()Landroid/widget/Switch;", "mSwitchShowPic$delegate", "mTvPicUrl", "getMTvPicUrl", "mTvPicUrl$delegate", "mSwitchOutClickCancel", "getMSwitchOutClickCancel", "mSwitchOutClickCancel$delegate", "mSwitchBtnClickCancel", "getMSwitchBtnClickCancel", "mSwitchBtnClickCancel$delegate", "mSwitchTitleColor", "getMSwitchTitleColor", "mSwitchTitleColor$delegate", "mContentRadioGroup", "Landroid/widget/RadioGroup;", "getMContentRadioGroup", "()Landroid/widget/RadioGroup;", "mContentRadioGroup$delegate", "mBtnRadioGroup", "getMBtnRadioGroup", "mBtnRadioGroup$delegate", "contentStyle", "", "btnStyle", "clickListener", "tv/danmaku/bili/core/test/DialogDebugActivity$clickListener$1", "Ltv/danmaku/bili/core/test/DialogDebugActivity$clickListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "showCommonDialog", "createDialogContentStr", "getDialogText", "T", "(Landroid/widget/TextView;)Ljava/lang/String;", "getLinkStr", "", "displayToast", "string", "(Landroid/view/View;Ljava/lang/String;)V", "addPic", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog$Builder;", "setTitleColor", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DialogDebugActivity extends BaseAppCompatActivity implements View.OnClickListener {
    public static final int $stable = 8;
    private int contentStyle;
    private final String TAG = "DialogDebugActivity";
    private final Lazy mTvTitle$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda11
        public final Object invoke() {
            TextView mTvTitle_delegate$lambda$0;
            mTvTitle_delegate$lambda$0 = DialogDebugActivity.mTvTitle_delegate$lambda$0(DialogDebugActivity.this);
            return mTvTitle_delegate$lambda$0;
        }
    });
    private final Lazy mTvContent$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda17
        public final Object invoke() {
            TextView mTvContent_delegate$lambda$0;
            mTvContent_delegate$lambda$0 = DialogDebugActivity.mTvContent_delegate$lambda$0(DialogDebugActivity.this);
            return mTvContent_delegate$lambda$0;
        }
    });
    private final Lazy mTvContentCp$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda1
        public final Object invoke() {
            TextView mTvContentCp_delegate$lambda$0;
            mTvContentCp_delegate$lambda$0 = DialogDebugActivity.mTvContentCp_delegate$lambda$0(DialogDebugActivity.this);
            return mTvContentCp_delegate$lambda$0;
        }
    });
    private final Lazy mTvLink$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda2
        public final Object invoke() {
            TextView mTvLink_delegate$lambda$0;
            mTvLink_delegate$lambda$0 = DialogDebugActivity.mTvLink_delegate$lambda$0(DialogDebugActivity.this);
            return mTvLink_delegate$lambda$0;
        }
    });
    private final Lazy mTvPositive$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda3
        public final Object invoke() {
            TextView mTvPositive_delegate$lambda$0;
            mTvPositive_delegate$lambda$0 = DialogDebugActivity.mTvPositive_delegate$lambda$0(DialogDebugActivity.this);
            return mTvPositive_delegate$lambda$0;
        }
    });
    private final Lazy mTvNegative$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda4
        public final Object invoke() {
            TextView mTvNegative_delegate$lambda$0;
            mTvNegative_delegate$lambda$0 = DialogDebugActivity.mTvNegative_delegate$lambda$0(DialogDebugActivity.this);
            return mTvNegative_delegate$lambda$0;
        }
    });
    private final Lazy mBtnShowDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda5
        public final Object invoke() {
            Button mBtnShowDialog_delegate$lambda$0;
            mBtnShowDialog_delegate$lambda$0 = DialogDebugActivity.mBtnShowDialog_delegate$lambda$0(DialogDebugActivity.this);
            return mBtnShowDialog_delegate$lambda$0;
        }
    });
    private final Lazy mBtnClearImageUrl$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda6
        public final Object invoke() {
            Button mBtnClearImageUrl_delegate$lambda$0;
            mBtnClearImageUrl_delegate$lambda$0 = DialogDebugActivity.mBtnClearImageUrl_delegate$lambda$0(DialogDebugActivity.this);
            return mBtnClearImageUrl_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchShowPic$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda7
        public final Object invoke() {
            Switch mSwitchShowPic_delegate$lambda$0;
            mSwitchShowPic_delegate$lambda$0 = DialogDebugActivity.mSwitchShowPic_delegate$lambda$0(DialogDebugActivity.this);
            return mSwitchShowPic_delegate$lambda$0;
        }
    });
    private final Lazy mTvPicUrl$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda8
        public final Object invoke() {
            TextView mTvPicUrl_delegate$lambda$0;
            mTvPicUrl_delegate$lambda$0 = DialogDebugActivity.mTvPicUrl_delegate$lambda$0(DialogDebugActivity.this);
            return mTvPicUrl_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchOutClickCancel$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda12
        public final Object invoke() {
            Switch mSwitchOutClickCancel_delegate$lambda$0;
            mSwitchOutClickCancel_delegate$lambda$0 = DialogDebugActivity.mSwitchOutClickCancel_delegate$lambda$0(DialogDebugActivity.this);
            return mSwitchOutClickCancel_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchBtnClickCancel$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda13
        public final Object invoke() {
            Switch mSwitchBtnClickCancel_delegate$lambda$0;
            mSwitchBtnClickCancel_delegate$lambda$0 = DialogDebugActivity.mSwitchBtnClickCancel_delegate$lambda$0(DialogDebugActivity.this);
            return mSwitchBtnClickCancel_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchTitleColor$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda14
        public final Object invoke() {
            Switch mSwitchTitleColor_delegate$lambda$0;
            mSwitchTitleColor_delegate$lambda$0 = DialogDebugActivity.mSwitchTitleColor_delegate$lambda$0(DialogDebugActivity.this);
            return mSwitchTitleColor_delegate$lambda$0;
        }
    });
    private final Lazy mContentRadioGroup$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda15
        public final Object invoke() {
            RadioGroup mContentRadioGroup_delegate$lambda$0;
            mContentRadioGroup_delegate$lambda$0 = DialogDebugActivity.mContentRadioGroup_delegate$lambda$0(DialogDebugActivity.this);
            return mContentRadioGroup_delegate$lambda$0;
        }
    });
    private final Lazy mBtnRadioGroup$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda16
        public final Object invoke() {
            RadioGroup mBtnRadioGroup_delegate$lambda$0;
            mBtnRadioGroup_delegate$lambda$0 = DialogDebugActivity.mBtnRadioGroup_delegate$lambda$0(DialogDebugActivity.this);
            return mBtnRadioGroup_delegate$lambda$0;
        }
    });
    private int btnStyle = 1;
    private DialogDebugActivity$clickListener$1 clickListener = new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$clickListener$1
        public void onDialogTextClicked(View view, BiliCommonDialog dialog) {
            String dialogText;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            if (view instanceof TextView) {
                DialogDebugActivity dialogDebugActivity = DialogDebugActivity.this;
                dialogText = DialogDebugActivity.this.getDialogText((TextView) view);
                dialogDebugActivity.displayToast(view, dialogText);
            }
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    private final TextView getMTvTitle() {
        Object value = this.mTvTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvTitle_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.title);
    }

    private final TextView getMTvContent() {
        Object value = this.mTvContent$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvContent_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.contenttext);
    }

    private final TextView getMTvContentCp() {
        Object value = this.mTvContentCp$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvContentCp_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.contenttextcopy);
    }

    private final TextView getMTvLink() {
        Object value = this.mTvLink$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvLink_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.link);
    }

    private final TextView getMTvPositive() {
        Object value = this.mTvPositive$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvPositive_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.et_positive);
    }

    private final TextView getMTvNegative() {
        Object value = this.mTvNegative$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvNegative_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.et_negative);
    }

    private final Button getMBtnShowDialog() {
        Object value = this.mBtnShowDialog$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button mBtnShowDialog_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.show_dialog);
    }

    private final Button getMBtnClearImageUrl() {
        Object value = this.mBtnClearImageUrl$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button mBtnClearImageUrl_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_clear_url);
    }

    private final Switch getMSwitchShowPic() {
        Object value = this.mSwitchShowPic$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchShowPic_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.pic_switch);
    }

    private final TextView getMTvPicUrl() {
        Object value = this.mTvPicUrl$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvPicUrl_delegate$lambda$0(DialogDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.pic_url_et);
    }

    private final Switch getMSwitchOutClickCancel() {
        Object value = this.mSwitchOutClickCancel$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchOutClickCancel_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.outcancel_switch);
    }

    private final Switch getMSwitchBtnClickCancel() {
        Object value = this.mSwitchBtnClickCancel$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchBtnClickCancel_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.btncancel_switch);
    }

    private final Switch getMSwitchTitleColor() {
        Object value = this.mSwitchTitleColor$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchTitleColor_delegate$lambda$0(DialogDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.title_color_switch);
    }

    private final RadioGroup getMContentRadioGroup() {
        Object value = this.mContentRadioGroup$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (RadioGroup) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RadioGroup mContentRadioGroup_delegate$lambda$0(DialogDebugActivity this$0) {
        return (RadioGroup) this$0.findViewById(R.id.radio_content_style);
    }

    private final RadioGroup getMBtnRadioGroup() {
        Object value = this.mBtnRadioGroup$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (RadioGroup) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RadioGroup mBtnRadioGroup_delegate$lambda$0(DialogDebugActivity this$0) {
        return (RadioGroup) this$0.findViewById(R.id.radio_btn_style);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_debug);
        getMBtnShowDialog().setOnClickListener(this);
        getMBtnClearImageUrl().setOnClickListener(this);
        getMContentRadioGroup().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogDebugActivity.onCreate$lambda$0(DialogDebugActivity.this, radioGroup, i);
            }
        });
        getMBtnRadioGroup().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda9
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                DialogDebugActivity.onCreate$lambda$1(DialogDebugActivity.this, radioGroup, i);
            }
        });
        getMSwitchShowPic().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$$ExternalSyntheticLambda10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DialogDebugActivity.onCreate$lambda$2(DialogDebugActivity.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DialogDebugActivity this$0, RadioGroup group, int checkedId) {
        if (checkedId != R.id.common) {
            if (checkedId != R.id.long_essay) {
                if (checkedId == R.id.content_center) {
                    this$0.contentStyle = 2;
                    return;
                }
                return;
            }
            this$0.contentStyle = 1;
            return;
        }
        this$0.contentStyle = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(DialogDebugActivity this$0, RadioGroup group, int checkedId) {
        if (checkedId != R.id.btn_common) {
            if (checkedId == R.id.btn_fill) {
                this$0.btnStyle = 1;
                return;
            }
            return;
        }
        this$0.btnStyle = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(DialogDebugActivity this$0, CompoundButton buttonView, boolean isChecked) {
        if (isChecked && TextUtils.isEmpty(this$0.getDialogText(this$0.getMTvPicUrl()))) {
            this$0.getMTvPicUrl().setText("http://i0.hdslb.com/bfs/archive/c935c82392e95069a3e7eae5c78889454d6fa47c.jpg@1080w_540h_85q_!pegasus-android-v1.webp");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id != R.id.show_dialog) {
            if (id == R.id.btn_clear_url) {
                getMTvPicUrl().setText((CharSequence) null);
                return;
            }
            return;
        }
        showCommonDialog();
    }

    private final void showCommonDialog() {
        BiliCommonDialog build = BiliCommonDialog.Builder.setNegativeButton$default(BiliCommonDialog.Builder.setPositiveButton$default(BiliCommonDialog.Builder.setLink$default(setTitleColor(addPic(new BiliCommonDialog.Builder((Context) this).setContentStyle(this.contentStyle).setButtonStyle(this.btnStyle))).setCanceledOnTouchOutside(getMSwitchOutClickCancel().isChecked()).setTitle(getDialogText(getMTvTitle())).setContentText(createDialogContentStr()), getLinkStr(), (BiliCommonDialog.OnDialogTextClickListener) null, false, 6, (Object) null), getDialogText(getMTvPositive()), this.clickListener, getMSwitchBtnClickCancel().isChecked(), (CustomButtonInfo) null, 8, (Object) null), getDialogText(getMTvNegative()), this.clickListener, getMSwitchBtnClickCancel().isChecked(), (CustomButtonInfo) null, 8, (Object) null).build();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        build.show(supportFragmentManager, this.TAG);
    }

    private final String createDialogContentStr() {
        try {
            int number = Integer.parseInt(getDialogText(getMTvContentCp()));
            StringBuilder builder = new StringBuilder();
            int index = 1;
            if (1 <= number) {
                while (true) {
                    if (index == number) {
                        builder.append(getDialogText(getMTvContent()));
                    } else {
                        builder.append(getDialogText(getMTvContent())).append("\n");
                    }
                    if (index == number) {
                        break;
                    }
                    index++;
                }
            }
            String sb = builder.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return sb;
        } catch (Exception e) {
            return getDialogText(getMTvContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends TextView> String getDialogText(T t) {
        return StringsKt.trim(t.getText().toString()).toString();
    }

    private final CharSequence getLinkStr() {
        SpannableString spannableString = new SpannableString("我只是测试一下link");
        spannableString.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.core.test.DialogDebugActivity$getLinkStr$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ToastHelper.showToastShort(widget.getContext(), "我只是测试一下");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor((Context) DialogDebugActivity.this, com.bilibili.lib.theme.R.color.Lb6));
            }
        }, 3, spannableString.length() - 1, 18);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends View> void displayToast(T t, String string) {
        ToastHelper.showToast(t.getContext(), string, 0);
    }

    private final BiliCommonDialog.Builder addPic(BiliCommonDialog.Builder $this$addPic) {
        if (getMSwitchShowPic().isChecked()) {
            if (!TextUtils.isEmpty(getDialogText(getMTvPicUrl()))) {
                $this$addPic.setDialogPicture(getDialogText(getMTvPicUrl()));
            } else {
                $this$addPic.setDialogPicture(com.bilibili.app.comm.baseres.R.drawable.ic_22_cry);
            }
        }
        return $this$addPic;
    }

    private final BiliCommonDialog.Builder setTitleColor(BiliCommonDialog.Builder $this$setTitleColor) {
        if (getMSwitchTitleColor().isChecked()) {
            $this$setTitleColor.titleUseThemeColor();
        }
        return $this$setTitleColor;
    }
}