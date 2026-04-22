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

/* compiled from: BiliAuthNewNameFragment.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/bili/auth/modify/BiliAuthNewNameFragment$afterClearFocus$1", "Ltv/danmaku/bili/auth/AuthBlockListener;", "isBlock", "", "result", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthNewNameFragment$afterClearFocus$1 implements AuthBlockListener {
    final /* synthetic */ EditText $view;
    final /* synthetic */ BiliAuthNewNameFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthNewNameFragment$afterClearFocus$1(EditText $view, BiliAuthNewNameFragment $receiver) {
        this.$view = $view;
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.auth.AuthBlockListener
    public void isBlock(final boolean result) {
        final EditText editText = this.$view;
        final BiliAuthNewNameFragment biliAuthNewNameFragment = this.this$0;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.BiliAuthNewNameFragment$afterClearFocus$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthNewNameFragment$afterClearFocus$1.isBlock$lambda$0(result, editText, biliAuthNewNameFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isBlock$lambda$0(boolean $result, EditText $view, BiliAuthNewNameFragment this$0) {
        BLog.d(BiliAuthFragment.TAG, "checkNameCardBlock isBlock = " + $result);
        if ($result) {
            $view.getText().clear();
            ToastHelper.showToastShort(this$0.getActivity(), R.string.account_global_string_429);
        }
        this$0.isChecking = false;
    }
}