package tv.danmaku.bili.auth;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: AuthLoginModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/auth/AuthPermissionModel;", "Ltv/danmaku/bili/auth/AuthLoginModel;", "<init>", "()V", "isChecked", "", "()Ljava/lang/Integer;", "setChecked", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "scope", "getScope", "setScope", "isPermissionChecked", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthPermissionModel implements AuthLoginModel {
    public static final int $stable = 8;
    private String content;
    private Integer isChecked;
    private String scope;
    private String title;

    public final Integer isChecked() {
        return this.isChecked;
    }

    public final void setChecked(Integer num) {
        this.isChecked = num;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void setScope(String str) {
        this.scope = str;
    }

    public final boolean isPermissionChecked() {
        Integer num = this.isChecked;
        if (num != null && num.intValue() == 1) {
            return true;
        }
        Integer num2 = this.isChecked;
        return num2 != null && num2.intValue() == -1;
    }
}