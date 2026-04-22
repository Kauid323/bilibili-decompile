package tv.danmaku.bili.ui.notice;

import android.app.Application;
import com.bilibili.app.comm.list.common.cache.ICacheService;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: NoticeCacheService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0000J\u0006\u0010\u0015\u001a\u00020\u0000J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/notice/NoticeCacheService;", "Lcom/bilibili/app/comm/list/common/cache/ICacheService;", "", "fileKey", "", "<init>", "(Ljava/lang/String;)V", "kvFile", "Lcom/bilibili/lib/blkv/RawKV;", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "remove", "", "key", "put", "value", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "get", "defValue", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "isTipsHide", "hideTips", "showTips", "markAsShown", "id", "isShown", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NoticeCacheService implements ICacheService<Boolean> {
    private RawKV kvFile;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public NoticeCacheService(String fileKey) {
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        Application application = BiliContext.application();
        this.kvFile = BLKV.toKvs$default(new File(application != null ? application.getCacheDir() : null, fileKey), false, 0, 3, (Object) null);
    }

    public boolean clear() {
        this.kvFile.clear();
        return true;
    }

    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.kvFile.remove(key);
    }

    public void put(String key, Boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.kvFile.putBoolean(key, value != null ? value.booleanValue() : false);
    }

    public Boolean get(String key, Boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (Boolean) this.kvFile.get(key, defValue);
    }

    public final boolean isTipsHide() {
        return Intrinsics.areEqual(get("key_hidden_all_tips", (Boolean) false), true);
    }

    public final NoticeCacheService hideTips() {
        put("key_hidden_all_tips", (Boolean) true);
        return this;
    }

    public final NoticeCacheService showTips() {
        remove("key_hidden_all_tips");
        return this;
    }

    public final NoticeCacheService markAsShown(String id) {
        if (id == null) {
            return this;
        }
        put("key_shown_tip_" + id, (Boolean) true);
        return this;
    }

    public final boolean isShown(String id) {
        Boolean bool;
        if (id == null || (bool = get("key_shown_tip_" + id, (Boolean) false)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* compiled from: NoticeCacheService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/notice/NoticeCacheService$Companion;", "", "<init>", "()V", "ofTips", "Ltv/danmaku/bili/ui/notice/NoticeCacheService;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NoticeCacheService ofTips() {
            return new NoticeCacheService("mine_notice_tips");
        }
    }

    @JvmStatic
    public static final NoticeCacheService ofTips() {
        return Companion.ofTips();
    }
}