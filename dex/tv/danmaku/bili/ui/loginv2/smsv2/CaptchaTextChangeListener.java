package tv.danmaku.bili.ui.loginv2.smsv2;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.theme.R;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TextChangeListenersV2.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J*\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J*\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/loginv2/smsv2/CaptchaTextChangeListener;", "Ltv/danmaku/bili/ui/loginv2/smsv2/BaseTextWatcher;", "fragment", "Ltv/danmaku/bili/ui/loginv2/smsv2/SmsLoginFragmentV2;", "<init>", "(Ltv/danmaku/bili/ui/loginv2/smsv2/SmsLoginFragmentV2;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CaptchaTextChangeListener extends BaseTextWatcher {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaTextChangeListener(SmsLoginFragmentV2 fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
        if (android.text.TextUtils.isEmpty(r4 != null ? r4.getText() : null) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(Editable s) {
        SmsLoginFragmentV2 fragment;
        boolean z;
        TintTextView tintTextView;
        WeakReference<SmsLoginFragmentV2> mFragmentRef = getMFragmentRef();
        if (mFragmentRef == null || (fragment = mFragmentRef.get()) == null) {
            return;
        }
        boolean z2 = true;
        if (s != null) {
            if (s.length() == 0) {
                z = true;
                if (!z) {
                    ImageView imageView = fragment.clearCaptcha;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                } else {
                    ImageView imageView2 = fragment.clearCaptcha;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                }
                tintTextView = fragment.mSubmitBtn;
                if (tintTextView == null) {
                    EditText editText = fragment.mEtPhoneNum;
                    if (!TextUtils.isEmpty(editText != null ? editText.getText() : null)) {
                        EditText editText2 = fragment.mEtCaptcha;
                    }
                    z2 = false;
                    tintTextView.setEnabled(z2);
                    return;
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
        tintTextView = fragment.mSubmitBtn;
        if (tintTextView == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        SmsLoginFragmentV2 fragment;
        Context context;
        EditText editText;
        WeakReference<SmsLoginFragmentV2> mFragmentRef = getMFragmentRef();
        if (mFragmentRef == null || (fragment = mFragmentRef.get()) == null || (context = fragment.getContext()) == null || (editText = fragment.mEtCaptcha) == null) {
            return;
        }
        editText.setTextColor(ContextCompat.getColor(context, R.color.Ga10));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}