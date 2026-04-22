package tv.danmaku.bili.utils.list;

import android.app.Application;
import bolts.Task;
import com.bapis.bilibili.gaia.gw.DeviceAppList;
import com.bapis.bilibili.gaia.gw.EncryptType;
import com.bapis.bilibili.gaia.gw.FetchPublicKeyReply;
import com.bapis.bilibili.gaia.gw.GaiaEncryptMsgReq;
import com.bapis.bilibili.gaia.gw.GaiaMoss;
import com.bapis.bilibili.gaia.gw.GaiaMsgHeader;
import com.bapis.bilibili.gaia.gw.PayloadType;
import com.bapis.bilibili.gaia.gw.UploadAppListReply;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.moss.api.CallOptions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppInfo;
import tv.danmaku.android.util.InstalledAppsUtils;
import tv.danmaku.bili.utils.passport.Encrypted;
import tv.danmaku.bili.utils.passport.InstallAppsSecurity;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InstalledListUploadUtil.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/utils/list/InstalledListUploadUtil;", "", "<init>", "()V", "TAG", "", "SP_KEY", "SAFE_MODE_REMOTE_KEY", "KEY_UPLOAD_GAP", "DEFAULT_GAP", "", "uploadAppsList", "", "isTodayNoUpload", "", "recordUploadTime", "getGaiaEncryptMsgReq", "Lcom/bapis/bilibili/gaia/gw/GaiaEncryptMsgReq;", "publicKey", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InstalledListUploadUtil {
    public static final int $stable = 0;
    private static final int DEFAULT_GAP = 86400000;
    public static final InstalledListUploadUtil INSTANCE = new InstalledListUploadUtil();
    private static final String KEY_UPLOAD_GAP = "main.risk_control_app_upload_gap";
    private static final String SAFE_MODE_REMOTE_KEY = "bili_app_startup_upload_app_list";
    private static final String SP_KEY = "bili_app_startup_upload_app_list_time";
    private static final String TAG = "InstalledListUploadUtil";

    private InstalledListUploadUtil() {
    }

    @JvmStatic
    public static final void uploadAppsList() {
        Boolean safeMode = (Boolean) ConfigManager.Companion.ab().get(SAFE_MODE_REMOTE_KEY, true);
        if (Intrinsics.areEqual(safeMode, false)) {
            return;
        }
        final boolean isFirstStart = EnvironmentManager.getInstance().isFirstStart();
        if (isFirstStart || INSTANCE.isTodayNoUpload()) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.utils.list.InstalledListUploadUtil$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Unit uploadAppsList$lambda$0;
                    uploadAppsList$lambda$0 = InstalledListUploadUtil.uploadAppsList$lambda$0(isFirstStart);
                    return uploadAppsList$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadAppsList$lambda$0(boolean $isFirstStart) {
        GaiaMoss moss;
        GaiaEncryptMsgReq request;
        try {
            moss = new GaiaMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            Empty build = Empty.newBuilder().build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            FetchPublicKeyReply publicKey = moss.executeExGetAxe(build);
            BLog.d(TAG, "get public key > " + publicKey + "?.publicKey");
            request = INSTANCE.getGaiaEncryptMsgReq(publicKey != null ? publicKey.getPublicKey() : null);
        } catch (Throwable t) {
            BLog.e(TAG, t);
        }
        if (request == null) {
            throw new Exception();
        }
        UploadAppListReply reply = moss.executeExClimbAppleTrees(request);
        BLog.d(TAG, "get upload reply " + (reply != null ? reply.getTraceId() : null));
        if (!$isFirstStart) {
            INSTANCE.recordUploadTime();
        }
        return Unit.INSTANCE;
    }

    private final boolean isTodayNoUpload() {
        Integer intOrNull;
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return true;
        }
        String str = (String) ConfigManager.Companion.config().get(KEY_UPLOAD_GAP, "86400000");
        int gap = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? DEFAULT_GAP : intOrNull.intValue();
        long record = BiliGlobalPreferenceHelper.getInstance(ctx).optLong(SP_KEY, -1L);
        return System.currentTimeMillis() > ((long) gap) + record;
    }

    private final void recordUploadTime() {
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return;
        }
        long time = System.currentTimeMillis();
        BiliGlobalPreferenceHelper.getInstance(ctx).edit().putLong(SP_KEY, time).apply();
    }

    private final GaiaEncryptMsgReq getGaiaEncryptMsgReq(String publicKey) {
        String source;
        if (publicKey == null) {
            return null;
        }
        List<AppInfo> list = InstalledAppsUtils.Companion.getInstalledApps();
        if (EnvironmentManager.getInstance().isFirstStart()) {
            source = "first_installation";
        } else {
            source = "first_open";
        }
        DeviceAppList.Builder deviceAppList = DeviceAppList.newBuilder().setSource(source);
        for (AppInfo app : list) {
            String packageName = app.packageName;
            if (StringUtil.isNotBlank(packageName)) {
                try {
                    if ((app.flags & 1) != 0) {
                        deviceAppList.addSystemAppList(packageName);
                    } else {
                        deviceAppList.addUserAppList(packageName);
                    }
                } catch (Throwable th) {
                }
            }
        }
        byte[] byteArray = deviceAppList.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        Encrypted encrypt = InstallAppsSecurity.encrypt$core_apinkDebug(byteArray, publicKey);
        if (encrypt == null) {
            return null;
        }
        GaiaMsgHeader gaiaMsgHeader = GaiaMsgHeader.newBuilder().setEncodeType(EncryptType.SERVER_RSA_AES).setPayloadType(PayloadType.DEVICE_APP_LIST).setEncodedAesKey(ByteString.copyFrom(encrypt.getEncryptedKey())).setTs(System.currentTimeMillis()).build();
        return GaiaEncryptMsgReq.newBuilder().setEncryptPayload(ByteString.copyFrom(encrypt.getEncryptedContent())).setHeader(gaiaMsgHeader).build();
    }
}