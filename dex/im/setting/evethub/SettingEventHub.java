package im.setting.evethub;

import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: SettingEventHub.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lim/setting/evethub/SettingEventHub;", "", "<init>", "()V", "_refreshSettingsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lim/setting/evethub/SettingEventHubFlowData;", "refreshSettingsFlow", "Lkotlinx/coroutines/flow/Flow;", "getRefreshSettingsFlow$annotations", "getRefreshSettingsFlow", "()Lkotlinx/coroutines/flow/Flow;", "receiveChanged", "", "subPageData", "Lim/setting/model/IMSettingPageData;", "item", "Lim/setting/model/SettingItem$Setting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingEventHub {
    public static final SettingEventHub INSTANCE = new SettingEventHub();
    private static final MutableSharedFlow<SettingEventHubFlowData> _refreshSettingsFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private static final Flow<SettingEventHubFlowData> refreshSettingsFlow = FlowKt.asSharedFlow(_refreshSettingsFlow);
    public static final int $stable = 8;

    public static /* synthetic */ void getRefreshSettingsFlow$annotations() {
    }

    private SettingEventHub() {
    }

    public final Flow<SettingEventHubFlowData> getRefreshSettingsFlow() {
        return refreshSettingsFlow;
    }

    public final void receiveChanged(IMSettingPageData subPageData, SettingItem.Setting item) {
        Intrinsics.checkNotNullParameter(subPageData, "subPageData");
        Intrinsics.checkNotNullParameter(item, "item");
        Iterable $this$map$iv = SettingEventHubFlowData.Companion.initialize(subPageData, item);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SettingEventHubFlowData it = (SettingEventHubFlowData) item$iv$iv;
            destination$iv$iv.add(BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new SettingEventHub$receiveChanged$1$1(it, null), 3, (Object) null));
        }
        ArrayList arrayList = (List) destination$iv$iv;
    }
}