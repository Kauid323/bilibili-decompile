package kntr.base.dd.impl.internal.container;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.dd.impl.IDDConstArgs;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DDDefault.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"DEFAULT_PREFERENCES_NAME", "", "DEFAULT_NULL_VALUE", "provideDDDefault", "Lkntr/base/dd/internal/IDeviceDecisionDefault;", "defaultArgs", "Lkntr/base/dd/impl/IDDConstArgs;", "getLocalKV", "key", "sp", "Lkntr/base/config/SharedPreferences;", "setLocalKV", "", "value", "subProcessKey", "Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;", "getSubProcessKey", "(Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;)Ljava/lang/String;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDefaultKt {
    private static final String DEFAULT_NULL_VALUE = "__DD_DEFAULT_NULL_VALUE__";
    private static final String DEFAULT_PREFERENCES_NAME = "dd-default-config";

    public static final IDeviceDecisionDefault provideDDDefault(final IDDConstArgs defaultArgs) {
        Intrinsics.checkNotNullParameter(defaultArgs, "defaultArgs");
        return new IDeviceDecisionDefault(defaultArgs) { // from class: kntr.base.dd.impl.internal.container.DDDefaultKt$provideDDDefault$1
            private final boolean isMainProcess;
            private final SharedPreferences sp = new SharedPreferences("dd-default-config", true);

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.isMainProcess = defaultArgs.isMainProcess();
            }

            @Override // kntr.base.dd.internal.IDeviceDecisionDefault
            public String get(IDeviceDecisionDefault.Key key) {
                String subProcessKey;
                String subProcessKey2;
                Intrinsics.checkNotNullParameter(key, "key");
                if (!this.isMainProcess) {
                    subProcessKey = DDDefaultKt.getSubProcessKey(key);
                    return DDDefaultKt.getLocalKV(subProcessKey, this.sp);
                }
                String it = DDDefaultKt.getLocalKV(key.getRawValue(), this.sp);
                subProcessKey2 = DDDefaultKt.getSubProcessKey(key);
                DDDefaultKt.setLocalKV(subProcessKey2, it, this.sp);
                return it;
            }

            @Override // kntr.base.dd.internal.IDeviceDecisionDefault
            public void set(IDeviceDecisionDefault.Key key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                DDDefaultKt.setLocalKV(key.getRawValue(), value, this.sp);
            }
        };
    }

    public static final String getLocalKV(String key, SharedPreferences sp) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(sp, "sp");
        String it = SharedPreferences.getString$default(sp, key, null, 2, null);
        if (it == null || Intrinsics.areEqual(it, DEFAULT_NULL_VALUE)) {
            return null;
        }
        return it;
    }

    public static final void setLocalKV(String key, String value, SharedPreferences sp) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(sp, "sp");
        sp.setString(key, value == null ? DEFAULT_NULL_VALUE : value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSubProcessKey(IDeviceDecisionDefault.Key $this$subProcessKey) {
        return $this$subProcessKey.getRawValue() + "::to_sub_process";
    }
}