package tv.danmaku.bili.ui.splash.event;

import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashStorage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0014"}, d2 = {"TAG", "", "KEY_EVENT_SPLASH_DATA_LIST", "KEY_EVENT_SPLASH_SHOW_TIME_PREFIX", "SP_NAME", "POSTFIX_BIRTHDAY", "DOWNLOAD_TAG_BIRTH", "SP_KEY_BACKOFF_BIRTHDAY_IMAGE_TRANSFER", "backupBirthdayResourceUrl", "getBackupBirthdayResourceUrl", "()Ljava/lang/String;", "backupBirthdayResourceKey", "getBackupBirthdayResourceKey", "deleteResourceByHash", "", "key", "deleteResourceByUrl", "url", "fetchResourceLocalPathByHash", "fetchResourceLocalPathByUrl", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashStorageKt {
    private static final String DOWNLOAD_TAG_BIRTH = "event_splash_birth";
    private static final String KEY_EVENT_SPLASH_DATA_LIST = "splash.event.list.data.list";
    private static final String KEY_EVENT_SPLASH_SHOW_TIME_PREFIX = "splash.event.show.time.prefix.";
    private static final String POSTFIX_BIRTHDAY = "birthday";
    private static final String SP_KEY_BACKOFF_BIRTHDAY_IMAGE_TRANSFER = "sp_backoff_birthday_image_transfer";
    private static final String SP_NAME = "splash.event.splash.name";
    private static final String TAG = "[EventSplash]EventSplashStorage";

    public static final String getBackupBirthdayResourceUrl() {
        String imageUrl = AppResUtil.getImageUrl("core_ic_splash_birth.webp");
        Intrinsics.checkNotNullExpressionValue(imageUrl, "getImageUrl(...)");
        return imageUrl;
    }

    public static final String getBackupBirthdayResourceKey() {
        return "birthday_image_" + DigestUtils.md5(getBackupBirthdayResourceUrl());
    }

    public static final void deleteResourceByHash(String key) {
        if (key == null) {
            return;
        }
        ResManager.delete(new ResRequest((String) null, key));
    }

    public static final void deleteResourceByUrl(String url) {
        if (url == null) {
            return;
        }
        ResManager.delete(new ResRequest(url, (String) null));
    }

    public static final String fetchResourceLocalPathByHash(String key) {
        ResResponse fetch;
        if (key == null || (fetch = ResManager.fetch(new ResRequest((String) null, key))) == null) {
            return null;
        }
        return fetch.getPath();
    }

    public static final String fetchResourceLocalPathByUrl(String url) {
        ResResponse fetch;
        if (url == null || (fetch = ResManager.fetch(new ResRequest(url, (String) null))) == null) {
            return null;
        }
        return fetch.getPath();
    }
}