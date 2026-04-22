package tv.danmaku.bili.reg;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.bilibili.app.comm.baseres.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LoginRegHelper.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\b\u0010\f\u001a\u00020\nH\u0016R$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"tv/danmaku/bili/reg/LoginRegHelper$regPopRunnable$1", "Ljava/lang/Runnable;", "weakView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "updateView", "", "view", "run", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRegHelper$regPopRunnable$1 implements Runnable {
    private WeakReference<View> weakView;

    public final WeakReference<View> getWeakView() {
        return this.weakView;
    }

    public final void setWeakView(WeakReference<View> weakReference) {
        this.weakView = weakReference;
    }

    public final void updateView(View view) {
        this.weakView = new WeakReference<>(view);
    }

    @Override // java.lang.Runnable
    public void run() {
        View $this$run_u24lambda_u240;
        WeakReference<View> weakReference = this.weakView;
        if (weakReference != null && ($this$run_u24lambda_u240 = weakReference.get()) != null) {
            $this$run_u24lambda_u240.setVisibility(8);
            $this$run_u24lambda_u240.setAnimation(AnimationUtils.loadAnimation($this$run_u24lambda_u240.getContext(), R.anim.br_fade_out));
        }
    }
}