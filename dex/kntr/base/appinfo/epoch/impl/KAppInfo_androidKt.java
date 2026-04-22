package kntr.base.appinfo.epoch.impl;

import com.bilibili.gripper.api.foundation.GFoundation;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.IAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.AppBuildConfig;

/* compiled from: KAppInfo.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"mPlatformAppInfo", "Lkntr/base/appinfo/IAppInfo;", "getMPlatformAppInfo", "()Lkntr/base/appinfo/IAppInfo;", "appinfo_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAppInfo_androidKt {
    private static final IAppInfo mPlatformAppInfo = new IAppInfo() { // from class: kntr.base.appinfo.epoch.impl.KAppInfo_androidKt$mPlatformAppInfo$1
        private final boolean debug;
        private final GFoundation gFoundation;
        private final String mobiApp;
        private final int versionCode;
        private final String versionName;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GFoundation.class, (String) null, 2, (Object) null);
            Intrinsics.checkNotNull(suspendProducer);
            this.gFoundation = (GFoundation) suspendProducer.get();
            this.mobiApp = this.gFoundation.getMobiApp();
            this.versionName = this.gFoundation.getVersionName();
            this.versionCode = this.gFoundation.getVersionCode();
            this.debug = AppBuildConfig.Companion.getDebug();
        }

        @Override // kntr.base.appinfo.IAppInfo
        public String getMobiApp() {
            return this.mobiApp;
        }

        @Override // kntr.base.appinfo.IAppInfo
        public String getVersionName() {
            return this.versionName;
        }

        @Override // kntr.base.appinfo.IAppInfo
        public int getVersionCode() {
            return this.versionCode;
        }

        @Override // kntr.base.appinfo.IAppInfo
        public boolean getDebug() {
            return this.debug;
        }
    };

    public static final IAppInfo getMPlatformAppInfo() {
        return mPlatformAppInfo;
    }
}