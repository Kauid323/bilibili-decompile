package tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import com.bilibili.app.personinfo.R;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.dialog.BaseDialogFragment;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NickNameRetryDialog.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0014\u0010\u001f\u001a\u00020\t*\u00020\u00182\u0006\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\"H\u0014J\u0018\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/dialog/NickNameRetryDialog;", "Ltv/danmaku/bili/widget/dialog/BaseDialogFragment;", "names", "", "", "<init>", "(Ljava/util/List;)V", "confirmListener", "Lkotlin/Function1;", "", "getConfirmListener", "()Lkotlin/jvm/functions/Function1;", "setConfirmListener", "(Lkotlin/jvm/functions/Function1;)V", "cancelListener", "Lkotlin/Function0;", "getCancelListener", "()Lkotlin/jvm/functions/Function0;", "setCancelListener", "(Lkotlin/jvm/functions/Function0;)V", "submitName", "conformBtn", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "checkBox1", "Lcom/bilibili/magicasakura/widgets/TintCheckBox;", "checkBox2", "checkBox3", "initView", "view", "Landroid/view/View;", "initCheckBox", "setListener", "it", "getDialogViewRes", "", "requestWidth", "handleCheckStates", "box", "isChecked", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NickNameRetryDialog extends BaseDialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> cancelListener;
    private TintCheckBox checkBox1;
    private TintCheckBox checkBox2;
    private TintCheckBox checkBox3;
    private Function1<? super String, Unit> confirmListener;
    private TintTextView conformBtn;
    private final List<String> names;
    private String submitName;

    public NickNameRetryDialog(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "names");
        this.names = list;
        this.submitName = "";
    }

    public final Function1<String, Unit> getConfirmListener() {
        return this.confirmListener;
    }

    public final void setConfirmListener(Function1<? super String, Unit> function1) {
        this.confirmListener = function1;
    }

    public final Function0<Unit> getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(Function0<Unit> function0) {
        this.cancelListener = function0;
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected void initView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        initCheckBox(view2);
        view2.findViewById(R.id.common_dialog_nagetive_btn).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.NickNameRetryDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                NickNameRetryDialog.initView$lambda$0(NickNameRetryDialog.this, view3);
            }
        });
        TintTextView findViewById = view2.findViewById(R.id.common_dialog_positive_btn);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.bilibili.magicasakura.widgets.TintTextView");
        this.conformBtn = findViewById;
        TintTextView $this$initView_u24lambda_u241 = this.conformBtn;
        if ($this$initView_u24lambda_u241 != null) {
            $this$initView_u24lambda_u241.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.NickNameRetryDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    NickNameRetryDialog.initView$lambda$1$0(NickNameRetryDialog.this, view3);
                }
            });
            $this$initView_u24lambda_u241.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NickNameRetryDialog this$0, View it) {
        Function0<Unit> function0 = this$0.cancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$0(NickNameRetryDialog this$0, View it) {
        Function1<? super String, Unit> function1 = this$0.confirmListener;
        if (function1 != null) {
            function1.invoke(this$0.submitName);
        }
    }

    private final void initCheckBox(View view2) {
        String first = (String) CollectionsKt.getOrNull(this.names, 0);
        String second = (String) CollectionsKt.getOrNull(this.names, 1);
        String third = (String) CollectionsKt.getOrNull(this.names, 2);
        if (first != null) {
            TintCheckBox findViewById = view2.findViewById(R.id.nick_name_choice1);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.bilibili.magicasakura.widgets.TintCheckBox");
            this.checkBox1 = findViewById;
            TintCheckBox $this$initCheckBox_u24lambda_u240_u240 = this.checkBox1;
            if ($this$initCheckBox_u24lambda_u240_u240 != null) {
                setListener($this$initCheckBox_u24lambda_u240_u240, first);
            }
        }
        if (second != null) {
            TintCheckBox findViewById2 = view2.findViewById(R.id.nick_name_choice2);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.bilibili.magicasakura.widgets.TintCheckBox");
            this.checkBox2 = findViewById2;
            TintCheckBox $this$initCheckBox_u24lambda_u241_u240 = this.checkBox2;
            if ($this$initCheckBox_u24lambda_u241_u240 != null) {
                setListener($this$initCheckBox_u24lambda_u241_u240, second);
            }
        }
        if (third != null) {
            TintCheckBox findViewById3 = view2.findViewById(R.id.nick_name_choice3);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.bilibili.magicasakura.widgets.TintCheckBox");
            this.checkBox3 = findViewById3;
            TintCheckBox $this$initCheckBox_u24lambda_u242_u240 = this.checkBox3;
            if ($this$initCheckBox_u24lambda_u242_u240 != null) {
                setListener($this$initCheckBox_u24lambda_u242_u240, third);
            }
        }
    }

    private final void setListener(final TintCheckBox $this$setListener, String it) {
        $this$setListener.setVisibility(0);
        $this$setListener.setText(it);
        $this$setListener.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.NickNameRetryDialog$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NickNameRetryDialog.this.handleCheckStates($this$setListener, z);
            }
        });
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int getDialogViewRes() {
        return R.layout.bili_app_modify_name_nick_choose_dialog;
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int requestWidth() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(R.dimen.person_info_dialog_width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCheckStates(TintCheckBox box, boolean isChecked) {
        if (isChecked) {
            if (box == this.checkBox1) {
                this.submitName = this.names.get(0);
                TintCheckBox tintCheckBox = this.checkBox2;
                if (tintCheckBox != null) {
                    tintCheckBox.setChecked(false);
                }
                TintCheckBox tintCheckBox2 = this.checkBox3;
                if (tintCheckBox2 != null) {
                    tintCheckBox2.setChecked(false);
                }
            } else if (box == this.checkBox2) {
                this.submitName = this.names.get(1);
                TintCheckBox tintCheckBox3 = this.checkBox1;
                if (tintCheckBox3 != null) {
                    tintCheckBox3.setChecked(false);
                }
                TintCheckBox tintCheckBox4 = this.checkBox3;
                if (tintCheckBox4 != null) {
                    tintCheckBox4.setChecked(false);
                }
            } else {
                this.submitName = this.names.get(2);
                TintCheckBox tintCheckBox5 = this.checkBox1;
                if (tintCheckBox5 != null) {
                    tintCheckBox5.setChecked(false);
                }
                TintCheckBox tintCheckBox6 = this.checkBox2;
                if (tintCheckBox6 != null) {
                    tintCheckBox6.setChecked(false);
                }
            }
        }
        TintCheckBox tintCheckBox7 = this.checkBox1;
        if (!(tintCheckBox7 != null && tintCheckBox7.isChecked())) {
            TintCheckBox tintCheckBox8 = this.checkBox2;
            if (!(tintCheckBox8 != null && tintCheckBox8.isChecked())) {
                TintCheckBox tintCheckBox9 = this.checkBox3;
                if (!(tintCheckBox9 != null && tintCheckBox9.isChecked())) {
                    TintTextView $this$handleCheckStates_u24lambda_u240 = this.conformBtn;
                    if ($this$handleCheckStates_u24lambda_u240 != null) {
                        $this$handleCheckStates_u24lambda_u240.setEnabled(false);
                        this.submitName = "";
                        ColorStateList tint = ColorStateList.valueOf($this$handleCheckStates_u24lambda_u240.getContext().getResources().getColor(R.color.Brand_pink_alpha40));
                        Intrinsics.checkNotNullExpressionValue(tint, "valueOf(...)");
                        $this$handleCheckStates_u24lambda_u240.setTextColor(tint);
                        return;
                    }
                    return;
                }
            }
        }
        TintTextView $this$handleCheckStates_u24lambda_u241 = this.conformBtn;
        if ($this$handleCheckStates_u24lambda_u241 != null) {
            $this$handleCheckStates_u24lambda_u241.setEnabled(true);
            ColorStateList tint2 = ColorStateList.valueOf($this$handleCheckStates_u24lambda_u241.getContext().getResources().getColor(com.bilibili.lib.theme.R.color.Brand_pink));
            Intrinsics.checkNotNullExpressionValue(tint2, "valueOf(...)");
            $this$handleCheckStates_u24lambda_u241.setTextColor(tint2);
        }
    }
}