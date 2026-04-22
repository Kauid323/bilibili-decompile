package tv.danmaku.bili.ui.clipboard;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.lib.accounts.BiliAccounts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0002R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010+\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001e\u0010.\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\t¨\u0006:"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RegexRule;", "", "<init>", "()V", "regex", "", "getRegex", "()Ljava/lang/String;", "setRegex", "(Ljava/lang/String;)V", "startType", "", "getStartType", "()I", "setStartType", "(I)V", "id", "", "getId", "()J", "setId", "(J)V", ChannelRoutes.CHANNEL_NAME, "getName", "setName", "priority", "getPriority", "setPriority", LoginSceneProcessor.BIZ_KEY, "getBusiness", "setBusiness", "userStatus", "getUserStatus", "setUserStatus", "innerCopy", "", "getInnerCopy", "()Z", "setInnerCopy", "(Z)V", "needDecode", "getNeedDecode", "setNeedDecode", "popupRule", "getPopupRule", "setPopupRule", "popupMode", "getPopupMode", "setPopupMode", "url", "getUrl", "setUrl", "check", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "checkUserStatus", "checkStartType", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RegexRule {
    public static final int ALL_START_TYPE = 3;
    public static final int ALL_STATUS = 1;
    public static final long BV_REGEX_ID = 1;
    public static final int COLD_START_TYPE = 2;
    public static final int FIRST_START_TYPE = 1;
    public static final int LOGIN_STATUS = 2;
    public static final int POP_MODE_SERVER_CONTROL = 3;
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "need_base64_decode")
    private boolean needDecode;
    @JSONField(name = "popup_mode")
    private int popupMode;
    @JSONField(name = "popup_rule")
    private int popupRule;
    @JSONField(name = "priority")
    private int priority;
    @JSONField(name = "start_pattern")
    private int startType;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JSONField(name = "regex")
    private String regex = "";
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    private String name = "";
    @JSONField(name = LoginSceneProcessor.BIZ_KEY)
    private String business = "";
    @JSONField(name = "user_status")
    private int userStatus = 1;
    @JSONField(name = "self_copied_active")
    private boolean innerCopy = true;
    @JSONField(name = "url")
    private String url = "";

    /* compiled from: ClipboardChecker.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RegexRule$Companion;", "", "<init>", "()V", "FIRST_START_TYPE", "", "COLD_START_TYPE", "ALL_START_TYPE", "ALL_STATUS", "LOGIN_STATUS", "BV_REGEX_ID", "", "POP_MODE_SERVER_CONTROL", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getRegex() {
        return this.regex;
    }

    public final void setRegex(String str) {
        this.regex = str;
    }

    public final int getStartType() {
        return this.startType;
    }

    public final void setStartType(int i) {
        this.startType = i;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final void setBusiness(String str) {
        this.business = str;
    }

    public final int getUserStatus() {
        return this.userStatus;
    }

    public final void setUserStatus(int i) {
        this.userStatus = i;
    }

    public final boolean getInnerCopy() {
        return this.innerCopy;
    }

    public final void setInnerCopy(boolean z) {
        this.innerCopy = z;
    }

    public final boolean getNeedDecode() {
        return this.needDecode;
    }

    public final void setNeedDecode(boolean z) {
        this.needDecode = z;
    }

    public final int getPopupRule() {
        return this.popupRule;
    }

    public final void setPopupRule(int i) {
        this.popupRule = i;
    }

    public final int getPopupMode() {
        return this.popupMode;
    }

    public final void setPopupMode(int i) {
        this.popupMode = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final boolean check(ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        return checkStartType(environment) && checkUserStatus(environment);
    }

    private final boolean checkUserStatus(ClipboardChecker.Environment environment) {
        return this.userStatus != 2 || BiliAccounts.get(environment.getContext()).isLogin();
    }

    private final boolean checkStartType(ClipboardChecker.Environment environment) {
        switch (this.startType) {
            case 1:
                return environment.getFirstStart();
            case 2:
                return environment.getColdStart();
            case 3:
                return true;
            default:
                return false;
        }
    }
}