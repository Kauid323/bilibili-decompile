package tv.danmaku.bili.sms;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogUtil.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J*\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J*\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/sms/EnableIfNotEmptyWatcher;", "Landroid/text/TextWatcher;", "input", "Landroid/widget/EditText;", "what", "Landroid/view/View;", "satisfied", "Ltv/danmaku/bili/sms/Satisfied;", "<init>", "(Landroid/widget/EditText;Landroid/view/View;Ltv/danmaku/bili/sms/Satisfied;)V", "mInputRef", "Ljava/lang/ref/WeakReference;", "mViewRef", "mSatisfiedRef", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EnableIfNotEmptyWatcher implements TextWatcher {
    private WeakReference<EditText> mInputRef;
    private WeakReference<Satisfied> mSatisfiedRef;
    private WeakReference<View> mViewRef;

    public EnableIfNotEmptyWatcher(EditText input, View what, Satisfied satisfied) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(what, "what");
        Intrinsics.checkNotNullParameter(satisfied, "satisfied");
        this.mInputRef = new WeakReference<>(input);
        this.mViewRef = new WeakReference<>(what);
        this.mSatisfiedRef = new WeakReference<>(satisfied);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        EditText input;
        View view;
        View view2;
        Satisfied satisfied;
        WeakReference<EditText> weakReference = this.mInputRef;
        if (weakReference == null || (input = weakReference.get()) == null) {
            return;
        }
        WeakReference<Satisfied> weakReference2 = this.mSatisfiedRef;
        boolean enable = (weakReference2 == null || (satisfied = weakReference2.get()) == null) ? true : satisfied.isSatisfied(input);
        WeakReference<View> weakReference3 = this.mViewRef;
        if (weakReference3 != null && (view2 = weakReference3.get()) != null) {
            view2.setEnabled(enable);
        }
        WeakReference<View> weakReference4 = this.mViewRef;
        if (weakReference4 == null || (view = weakReference4.get()) == null) {
            return;
        }
        view.setClickable(enable);
    }
}