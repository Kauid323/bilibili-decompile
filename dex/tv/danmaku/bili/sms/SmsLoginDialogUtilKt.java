package tv.danmaku.bili.sms;

import android.view.View;
import android.widget.EditText;
import com.bilibili.lib.blconfig.ConfigManager;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SmsLoginDialogUtil.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a(\u0010\n\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a+\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"FROM_HOME", "", "FROM_USER_CENTER", "KEY_FROM", "bindClearButton", "", "input", "Landroid/widget/EditText;", "close", "Landroid/view/View;", "bindLoginButton", "inputs", "", "Ljava/lang/ref/WeakReference;", "enableIfSatisfied", "what", "satisfied", "Ltv/danmaku/bili/sms/Satisfied;", "changeTextBgColorBeforeTextChange", "aim", "", "(Landroid/widget/EditText;Landroid/view/View;Ljava/lang/Integer;)V", "performClickAfterParseText", "showEulaDialog", "", "getShowEulaDialog", "()Z", "showEulaDialog$delegate", "Lkotlin/Lazy;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginDialogUtilKt {
    public static final String FROM_HOME = "home";
    public static final String FROM_USER_CENTER = "user_center";
    public static final String KEY_FROM = "from";
    private static final Lazy showEulaDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.sms.SmsLoginDialogUtilKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean showEulaDialog_delegate$lambda$0;
            showEulaDialog_delegate$lambda$0 = SmsLoginDialogUtilKt.showEulaDialog_delegate$lambda$0();
            return Boolean.valueOf(showEulaDialog_delegate$lambda$0);
        }
    });

    public static final void bindClearButton(final EditText input, View close) {
        if (close == null || input == null) {
            return;
        }
        close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogUtilKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsLoginDialogUtilKt.bindClearButton$lambda$0(input, view);
            }
        });
        input.addTextChangedListener(new ClearTextWatcher(input, close));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClearButton$lambda$0(EditText $input, View it) {
        $input.setText("");
    }

    public static final void bindLoginButton(List<? extends WeakReference<EditText>> list, View close) {
        if (list == null || close == null) {
            return;
        }
        List<? extends WeakReference<EditText>> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            WeakReference it = (WeakReference) element$iv;
            EditText editText = (EditText) it.get();
            if (editText != null) {
                editText.addTextChangedListener(new LoginButtonWatcher(list, close));
            }
        }
    }

    public static final void enableIfSatisfied(EditText input, View what, Satisfied satisfied) {
        Intrinsics.checkNotNullParameter(satisfied, "satisfied");
        if (input == null || what == null) {
            return;
        }
        input.addTextChangedListener(new EnableIfNotEmptyWatcher(input, what, satisfied));
    }

    public static final void changeTextBgColorBeforeTextChange(EditText input, View aim, Integer what) {
        if (input == null || aim == null || what == null) {
            return;
        }
        input.addTextChangedListener(new ChangeTextColorBeforeTextChange(input, aim, what));
    }

    public static final void performClickAfterParseText(EditText input, View aim) {
        if (input == null || aim == null) {
            return;
        }
        input.addTextChangedListener(new PerformClickAfterParseText(input, aim));
    }

    public static final boolean getShowEulaDialog() {
        return ((Boolean) showEulaDialog$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showEulaDialog_delegate$lambda$0() {
        return ConfigManager.Companion.isHitFF("login.show_eula_dialog");
    }
}