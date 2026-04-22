package tv.danmaku.bili;

import kotlin.Metadata;

/* compiled from: PResult.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/PResult;", "T", "", "<init>", "()V", "exist", "", "getExist", "()Z", "setExist", "(Z)V", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "onlineparam_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PResult<T> {
    private boolean exist;
    private T result;

    public final boolean getExist() {
        return this.exist;
    }

    public final void setExist(boolean z) {
        this.exist = z;
    }

    public final T getResult() {
        return this.result;
    }

    public final void setResult(T t) {
        this.result = t;
    }
}