package tv.danmaku.bili.utils;

import com.bilibili.homepage.AesEncryptService;
import com.bilibili.lib.blconfig.ConfigManager;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AesEncryptServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/AesEncryptServiceImpl;", "Lcom/bilibili/homepage/AesEncryptService;", "<init>", "()V", "getKey", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named("AesEncryptService")
public final class AesEncryptServiceImpl implements AesEncryptService {
    public static final int $stable = 0;

    public String getKey() {
        return (String) ConfigManager.Companion.config().get("cipher.aes_key", "fgjhloasyervopst");
    }
}