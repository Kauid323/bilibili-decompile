package im.session.service;

import android.content.Context;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidDataCacheService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lim/session/service/AndroidDataCacheService;", "Lim/session/service/IMSessionDataCacheService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kv", "Lcom/bilibili/lib/blkv/RawKV;", "save", "", "forKey", "", UtilsKt.DATA_KEY, "", "load", "clearAll", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidDataCacheService implements IMSessionDataCacheService {
    private final RawKV kv;

    public AndroidDataCacheService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.kv = BLKV.getKvs$default(context, "im_session_list_cache", false, 0, 6, (Object) null);
    }

    @Override // im.session.service.IMSessionDataCacheService
    public void save(String forKey, byte[] data) {
        Intrinsics.checkNotNullParameter(forKey, "forKey");
        this.kv.set(forKey, data);
    }

    @Override // im.session.service.IMSessionDataCacheService
    public byte[] load(String forKey) {
        Intrinsics.checkNotNullParameter(forKey, "forKey");
        return (byte[]) this.kv.get(forKey, (Object) null);
    }

    @Override // im.session.service.IMSessionDataCacheService
    public void clearAll() {
        this.kv.clear();
    }
}