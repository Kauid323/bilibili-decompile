package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.bilibili.app.comm.list.common.cache.PersistedPropertyKt;
import com.bilibili.app.comm.list.common.cache.PersistedValue;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/core/test/PegasusConfigDialog;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "config", "", "getConfig", "()Ljava/lang/String;", "config$delegate", "Lcom/bilibili/app/comm/list/common/cache/PersistedValue;", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PegasusConfigDialog extends AbsButtonTestItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PegasusConfigDialog.class, "config", "getConfig()Ljava/lang/String;", 0))};
    public static final int $stable = AbsButtonTestItem.$stable | PersistedValue.$stable;
    private final PersistedValue config$delegate = PersistedPropertyKt.persistedString$default("pegasus_config_debug", (String) null, (String) null, 6, (Object) null);

    private final String getConfig() {
        return (String) this.config$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "查看新天马config";
    }

    public void onClick(View v) {
        Context context;
        if (v != null && (context = v.getContext()) != null) {
            new AlertDialog.Builder(context).setTitle("新天马config").setMessage(getConfig()).setCancelable(true).create().show();
        }
    }
}