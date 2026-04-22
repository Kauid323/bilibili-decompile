package im.session.service;

import im.setting.UtilsKt;
import kotlin.Metadata;

/* compiled from: IMSessionCacheService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\t\u001a\u00020\u0003H'¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lim/session/service/IMSessionDataCacheService;", "", "save", "", "forKey", "", UtilsKt.DATA_KEY, "", "load", "clearAll", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionDataCacheService {
    void clearAll();

    byte[] load(String str);

    void save(String str, byte[] bArr);
}