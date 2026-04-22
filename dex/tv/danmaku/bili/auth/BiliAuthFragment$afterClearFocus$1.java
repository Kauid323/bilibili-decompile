package tv.danmaku.bili.auth;

import android.widget.EditText;
import bili.resource.account.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthFragment.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/bili/auth/BiliAuthFragment$afterClearFocus$1", "Ltv/danmaku/bili/auth/AuthBlockListener;", "isBlock", "", "result", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFragment$afterClearFocus$1 implements AuthBlockListener {
    final /* synthetic */ EditText $view;
    final /* synthetic */ BiliAuthFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthFragment$afterClearFocus$1(BiliAuthFragment $receiver, EditText $view) {
        this.this$0 = $receiver;
        this.$view = $view;
    }

    @Override // tv.danmaku.bili.auth.AuthBlockListener
    public void isBlock(final boolean result) {
        final BiliAuthFragment biliAuthFragment = this.this$0;
        final EditText editText = this.$view;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFragment$afterClearFocus$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFragment$afterClearFocus$1.isBlock$lambda$0(BiliAuthFragment.this, result, editText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isBlock$lambda$0(BiliAuthFragment this$0, boolean $result, EditText $view) {
        boolean z;
        this$0.dismissLoading();
        BLog.d(BiliAuthFragment.TAG, "checkNameCardBlock isBlock = " + $result);
        if (!$result) {
            z = this$0.mDelayEnterAfterCheck;
            if (z) {
                this$0.mDelayEnterAfterCheck = false;
                this$0.enterFacialInternal();
            }
        } else {
            $view.getText().clear();
            ToastHelper.showToastShort(this$0.getActivity(), R.string.account_global_string_429);
        }
        this$0.isChecking = false;
    }
}