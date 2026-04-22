package tv.danmaku.bili.ui.clipboard;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0006\u0010'\u001a\u00020\u001aJ\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResult;", "", "<init>", "()V", "rule", "", "getRule", "()I", "setRule", "(I)V", LoginReporterV2.Click.SIGNUP_KEY_MODE, "getMode", "setMode", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", LoginSceneProcessor.BIZ_KEY, "getBusiness", "setBusiness", InnerPushReceiverKt.KEY_EXTRA, NftCardJsBridgeCallHandler.GET_EXTRA, "setExtra", "isFissionUrl", "", "()Z", "setFissionUrl", "(Z)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "checkValid", "isRuleValid", "isModeValid", "checkPage", "checkPromoPage", "checkHomePage", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClipboardResult {
    public static final int ALL_PAGE_RULE = 4;
    public static final int DIALOG_POP_MODE = 2;
    public static final int HOME_TAB_RULE = 2;
    public static final int MAIN_PAGE_RULE = 3;
    public static final int PAGE_POP_MODE = 1;
    public static final int PROMO_TAB_RULE = 1;
    private static final String URL_MAIN = "bilibili://main/home";
    private boolean isFissionUrl;
    private long localId;
    @JSONField(name = "popup_mode")
    private int mode;
    @JSONField(name = "popup_rule")
    private int rule;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JSONField(name = "url")
    private String url = "";
    @JSONField(name = LoginSceneProcessor.BIZ_KEY)
    private String business = "";
    @JSONField(name = InnerPushReceiverKt.KEY_EXTRA)
    private String extra = "";

    /* compiled from: ClipboardChecker.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResult$Companion;", "", "<init>", "()V", "DIALOG_POP_MODE", "", "PAGE_POP_MODE", "PROMO_TAB_RULE", "HOME_TAB_RULE", "MAIN_PAGE_RULE", "ALL_PAGE_RULE", "URL_MAIN", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getRule() {
        return this.rule;
    }

    public final void setRule(int i) {
        this.rule = i;
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i) {
        this.mode = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final void setBusiness(String str) {
        this.business = str;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final boolean isFissionUrl() {
        return this.isFissionUrl;
    }

    public final void setFissionUrl(boolean z) {
        this.isFissionUrl = z;
    }

    public final long getLocalId() {
        return this.localId;
    }

    public final void setLocalId(long j) {
        this.localId = j;
    }

    public final boolean checkValid() {
        if (TextUtils.isEmpty(this.url) || !isRuleValid() || !isModeValid()) {
            return false;
        }
        return true;
    }

    private final boolean isRuleValid() {
        return this.rule == 1 || this.rule == 2 || this.rule == 3 || this.rule == 4;
    }

    private final boolean isModeValid() {
        return this.mode == 2 || this.mode == 1;
    }

    public final boolean checkPage() {
        Activity topActivity = BiliContext.topActivitiy();
        boolean mainPage = topActivity instanceof MainActivityV2;
        switch (this.rule) {
            case 1:
                return mainPage && checkHomePage() && checkPromoPage();
            case 2:
                return mainPage && checkHomePage();
            case 3:
                return mainPage;
            case 4:
                return true;
            default:
                return false;
        }
    }

    private final boolean checkPromoPage() {
        return BottomTabSelectedHelper.isRecommendPage;
    }

    private final boolean checkHomePage() {
        return UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
    }
}