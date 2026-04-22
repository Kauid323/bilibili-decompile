package tv.danmaku.bili.update.api.supplier;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LaserWarpUpgradeInfoSupplier.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/update/api/supplier/LaserWarpUpgradeInfoSupplier;", "Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "infoSupplier", "<init>", "(Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;)V", "getInfoSupplier", "()Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "setInfoSupplier", "get", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "context", "Landroid/content/Context;", "Companion", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class LaserWarpUpgradeInfoSupplier implements UpgradeInfoSupplier {
    private UpgradeInfoSupplier infoSupplier;
    public static final Companion Companion = new Companion(null);
    private static String KEY_TIME = "time";
    private static String LASER_UPGRADE_INFO_SUPPLIER = "laser_upgradeInfoSupplier";
    private static long VALIDITY_TIME = 172800000;
    private static String KEY_DATA = "data";

    public LaserWarpUpgradeInfoSupplier(UpgradeInfoSupplier infoSupplier) {
        Intrinsics.checkNotNullParameter(infoSupplier, "infoSupplier");
        this.infoSupplier = infoSupplier;
    }

    public final UpgradeInfoSupplier getInfoSupplier() {
        return this.infoSupplier;
    }

    public final void setInfoSupplier(UpgradeInfoSupplier upgradeInfoSupplier) {
        Intrinsics.checkNotNullParameter(upgradeInfoSupplier, "<set-?>");
        this.infoSupplier = upgradeInfoSupplier;
    }

    /* compiled from: LaserWarpUpgradeInfoSupplier.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/update/api/supplier/LaserWarpUpgradeInfoSupplier$Companion;", "", "<init>", "()V", "KEY_TIME", "", "LASER_UPGRADE_INFO_SUPPLIER", "VALIDITY_TIME", "", "KEY_DATA", "injectBiliUpgradeInfo", "", "data", "time", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/Long;Landroid/content/Context;)V", "getInjectBiliUpgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void injectBiliUpgradeInfo(String data, Long time, Context context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            RawKV toKvs = BLKV.toKvs$default(new File(context.getCacheDir(), LaserWarpUpgradeInfoSupplier.LASER_UPGRADE_INFO_SUPPLIER), false, 0, 3, (Object) null);
            long t = time != null ? time.longValue() : LaserWarpUpgradeInfoSupplier.VALIDITY_TIME;
            toKvs.putLong(LaserWarpUpgradeInfoSupplier.KEY_TIME, System.currentTimeMillis() + t);
            toKvs.putString(LaserWarpUpgradeInfoSupplier.KEY_DATA, data);
        }

        public final BiliUpgradeInfo getInjectBiliUpgradeInfo(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            RawKV toKvs = BLKV.toKvs$default(new File(context.getCacheDir(), LaserWarpUpgradeInfoSupplier.LASER_UPGRADE_INFO_SUPPLIER), false, 0, 3, (Object) null);
            String get = toKvs.getString(LaserWarpUpgradeInfoSupplier.KEY_DATA, "");
            long time = toKvs.getLong(LaserWarpUpgradeInfoSupplier.KEY_TIME, System.currentTimeMillis());
            if (System.currentTimeMillis() < time && !TextUtils.isEmpty(get)) {
                try {
                    return (BiliUpgradeInfo) RuntimeHelper.INSTANCE.parseObject(get, BiliUpgradeInfo.class);
                } catch (Throwable th) {
                }
            }
            return null;
        }
    }

    @Override // tv.danmaku.bili.update.api.supplier.UpgradeInfoSupplier
    public BiliUpgradeInfo get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            BiliUpgradeInfo info = this.infoSupplier.get(context);
            BiliUpgradeInfo laserInfo = Companion.getInjectBiliUpgradeInfo(context);
            if (laserInfo != null && laserInfo.getVersion_code() > RuntimeHelper.versionCode()) {
                if (laserInfo.getVersion_code() > info.getVersion_code()) {
                    return laserInfo;
                }
            }
            return info;
        } catch (Throwable e) {
            BiliUpgradeInfo laserInfo2 = Companion.getInjectBiliUpgradeInfo(context);
            if (laserInfo2 != null && laserInfo2.getVersion_code() > RuntimeHelper.versionCode()) {
                return laserInfo2;
            }
            throw e;
        }
    }
}