package tv.danmaku.bili.auth;

import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.AuthContentCheckBean;

/* compiled from: BiliAuthContentCheck.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/auth/AuthBlockChecker;", "", "<init>", "()V", "TAG", "", "mLoading", "", "checkBlock", "", "content", "listener", "Ltv/danmaku/bili/auth/AuthBlockListener;", "checkBlockInternal", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthBlockChecker {
    private final String TAG = "AuthBlackListChecker";
    private boolean mLoading;

    public final void checkBlock(final String content, final AuthBlockListener listener) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.AuthBlockChecker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthBlockChecker.checkBlock$lambda$0(AuthBlockChecker.this, content, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlock$lambda$0(AuthBlockChecker this$0, String $content, AuthBlockListener $listener) {
        if (this$0.mLoading) {
            return;
        }
        this$0.mLoading = true;
        if (StringsKt.isBlank($content)) {
            $listener.isBlock(false);
            this$0.mLoading = false;
            return;
        }
        this$0.checkBlockInternal($content, $listener);
    }

    private final void checkBlockInternal(String content, final AuthBlockListener listener) {
        BiliAuthServiceHelper.getBiliPassportServiceHelper().contentCheck(content, new BiliApiDataCallback<AuthContentCheckBean>() { // from class: tv.danmaku.bili.auth.AuthBlockChecker$checkBlockInternal$1
            public void onError(Throwable t) {
                String str;
                str = AuthBlockChecker.this.TAG;
                BLog.e(str, "isBlock request error :: " + (t != null ? t.getMessage() : null));
                listener.isBlock(false);
                AuthBlockChecker.this.mLoading = false;
            }

            public void onDataSuccess(AuthContentCheckBean data) {
                String str;
                str = AuthBlockChecker.this.TAG;
                BLog.i(str, "isBlock request onDataSuccess :: " + data);
                if (data == null) {
                    listener.isBlock(false);
                } else {
                    listener.isBlock(!data.pass);
                }
                AuthBlockChecker.this.mLoading = false;
            }
        });
    }
}