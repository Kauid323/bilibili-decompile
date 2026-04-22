package tv.danmaku.bili.core.test;

import android.content.Context;
import com.bilibili.app.comm.list.common.cache.PersistedPropertyKt;
import com.bilibili.app.comm.list.common.cache.PersistedValue;
import com.bilibili.list.test.AbsKvSwitchTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/core/test/PegasusConfigLog;", "Lcom/bilibili/list/test/AbsKvSwitchTestItem;", "<init>", "()V", "<set-?>", "", "switch", "getSwitch", "()Z", "setSwitch", "(Z)V", "switch$delegate", "Lcom/bilibili/app/comm/list/common/cache/PersistedValue;", "getButtonText", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PegasusConfigLog extends AbsKvSwitchTestItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PegasusConfigLog.class, "switch", "getSwitch()Z", 0))};
    public static final int $stable = AbsKvSwitchTestItem.$stable | PersistedValue.$stable;
    private final PersistedValue switch$delegate = PersistedPropertyKt.persistedBoolean$default("pegasus_config_debug_log", (String) null, true, 2, (Object) null);

    public boolean getSwitch() {
        return ((Boolean) this.switch$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public void setSwitch(boolean z) {
        this.switch$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "新天马config日志";
    }
}