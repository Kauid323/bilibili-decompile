package tv.danmaku.bili.sms;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogUtil.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J*\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J*\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/sms/LoginButtonWatcher;", "Landroid/text/TextWatcher;", "input", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/EditText;", "btn", "Landroid/view/View;", "<init>", "(Ljava/util/List;Landroid/view/View;)V", "mInputRef", "mBtnRef", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginButtonWatcher implements TextWatcher {
    private WeakReference<View> mBtnRef;
    private List<? extends WeakReference<EditText>> mInputRef;

    public LoginButtonWatcher(List<? extends WeakReference<EditText>> list, View btn) {
        Intrinsics.checkNotNullParameter(list, "input");
        Intrinsics.checkNotNullParameter(btn, "btn");
        this.mInputRef = list;
        this.mBtnRef = new WeakReference<>(btn);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        View view;
        Editable text;
        List inputs = this.mInputRef;
        if (inputs == null) {
            return;
        }
        boolean enable = true;
        Iterator<? extends WeakReference<EditText>> it = inputs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference input = it.next();
            EditText editText = input.get();
            boolean z = false;
            if (editText != null && (text = editText.getText()) != null) {
                if (text.length() == 0) {
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
            if (z) {
                enable = false;
                break;
            }
        }
        WeakReference<View> weakReference = this.mBtnRef;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setEnabled(enable);
    }
}