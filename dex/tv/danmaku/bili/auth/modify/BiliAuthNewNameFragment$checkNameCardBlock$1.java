package tv.danmaku.bili.auth.modify;

import android.widget.EditText;
import bili.resource.account.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthBlockListener;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.auth.helper.AuthToastHelper;

/* compiled from: BiliAuthNewNameFragment.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/bili/auth/modify/BiliAuthNewNameFragment$checkNameCardBlock$1", "Ltv/danmaku/bili/auth/AuthBlockListener;", "isBlock", "", "result", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthNewNameFragment$checkNameCardBlock$1 implements AuthBlockListener {
    final /* synthetic */ BiliAuthNewNameFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthNewNameFragment$checkNameCardBlock$1(BiliAuthNewNameFragment $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.auth.AuthBlockListener
    public void isBlock(final boolean result) {
        final BiliAuthNewNameFragment biliAuthNewNameFragment = this.this$0;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$checkNameCardBlock$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthNewNameFragment$checkNameCardBlock$1.isBlock$lambda$0(BiliAuthNewNameFragment.this, result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isBlock$lambda$0(BiliAuthNewNameFragment this$0, boolean $result) {
        AuthToastHelper authToastHelper;
        EditText editText;
        authToastHelper = this$0.mAuthToastHelper;
        if (authToastHelper != null) {
            authToastHelper.dismissLoading();
        }
        BLog.d(BiliAuthFragment.TAG, "checkNameCardBlock isBlock = " + $result);
        if ($result) {
            editText = this$0.mName;
            if (editText != null) {
                editText.clearFocus();
            }
            ToastHelper.showToastShort(this$0.getActivity(), R.string.account_global_string_429);
            return;
        }
        this$0.isNameChecked = true;
        this$0.checkBlockFinish();
    }
}