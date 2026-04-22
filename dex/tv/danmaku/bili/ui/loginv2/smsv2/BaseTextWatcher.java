package tv.danmaku.bili.ui.loginv2.smsv2;

import android.text.TextWatcher;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TextChangeListenersV2.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/loginv2/smsv2/BaseTextWatcher;", "Landroid/text/TextWatcher;", "fragment", "Ltv/danmaku/bili/ui/loginv2/smsv2/SmsLoginFragmentV2;", "<init>", "(Ltv/danmaku/bili/ui/loginv2/smsv2/SmsLoginFragmentV2;)V", "mFragmentRef", "Ljava/lang/ref/WeakReference;", "getMFragmentRef", "()Ljava/lang/ref/WeakReference;", "setMFragmentRef", "(Ljava/lang/ref/WeakReference;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseTextWatcher implements TextWatcher {
    public static final int $stable = 8;
    private WeakReference<SmsLoginFragmentV2> mFragmentRef;

    public BaseTextWatcher(SmsLoginFragmentV2 fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mFragmentRef = new WeakReference<>(fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WeakReference<SmsLoginFragmentV2> getMFragmentRef() {
        return this.mFragmentRef;
    }

    protected final void setMFragmentRef(WeakReference<SmsLoginFragmentV2> weakReference) {
        this.mFragmentRef = weakReference;
    }
}