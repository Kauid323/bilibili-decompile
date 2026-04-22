package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;

/* compiled from: IPlatformConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/config/IPlatformConfig;", "", "ff", "", "key", "", "defaultValue", RedirectImpKt.REDIRECT_KV_CONFIG, "config_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformConfig {
    String config(String str, String str2);

    boolean ff(String str, boolean z);

    /* compiled from: IPlatformConfig.kt */
    /* renamed from: kntr.base.config.IPlatformConfig$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean ff$default(IPlatformConfig iPlatformConfig, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return iPlatformConfig.ff(str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ff");
        }

        public static /* synthetic */ String config$default(IPlatformConfig iPlatformConfig, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return iPlatformConfig.config(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: config");
        }
    }

    /* compiled from: IPlatformConfig.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}