package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ModifyAllowBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/api/bean/ModifyAllowBean;", "", "<init>", "()V", "allow", "", "getAllow", "()Z", "setAllow", "(Z)V", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModifyAllowBean {
    @JSONField(name = "allow")
    private boolean allow;

    public final boolean getAllow() {
        return this.allow;
    }

    public final void setAllow(boolean z) {
        this.allow = z;
    }
}