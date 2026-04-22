package tv.danmaku.bili.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/AuthVersion;", "", "version", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "VERSION_1", "VERSION_2", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum AuthVersion {
    VERSION_1("1"),
    VERSION_2("2");
    
    private final String version;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AuthVersion> getEntries() {
        return $ENTRIES;
    }

    AuthVersion(String version) {
        this.version = version;
    }

    public final String getVersion() {
        return this.version;
    }
}