package im.setting.stateMachine;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMToast;
import im.setting.IMSettingAction;
import im.setting.IMSettingDialogCancelAction;
import im.setting.IMSettingDialogConfirmAction;
import im.setting.IMSettingState;
import im.setting.evethub.SettingEventHub;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import im.setting.service.SettingNotifyService;
import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\n\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082\b¨\u0006\u000f"}, d2 = {"childStateMapper", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", "notifyService", "Lim/setting/service/SettingNotifyService;", "pageState", "Lcom/freeletics/flowredux/dsl/State;", "itemStatus", "Lim/setting/stateMachine/IMSettingItemStatus;", "childActionMapper", "Lim/setting/stateMachine/IMSettingItemAction;", "T", "Lcom/bapis/bilibili/app/im/v1/KSetting$IContent;", AuthActivity.ACTION_KEY, "Lim/setting/IMSettingAction;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingStateMachineKt {
    public static final ChangedState<IMSettingState> childStateMapper(SettingNotifyService notifyService, State<IMSettingState> state, IMSettingItemStatus itemStatus) {
        SettingItem.Setting setting;
        KLog_androidKt.getKLog().i("IMSetting", "子状态机映射类型: " + itemStatus);
        IMSettingState iMSettingState = (IMSettingState) state.getSnapshot();
        IMSettingPageData data = ((IMSettingState) state.getSnapshot()).getData();
        Map $this$mapValues$iv = ((IMSettingState) state.getSnapshot()).getData().getSettings$logic_debug();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        Iterator<T> it = $this$associateByTo$iv$iv$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                IMSettingPageData copy$default = IMSettingPageData.copy$default(data, null, null, destination$iv$iv, null, 11, null);
                IMSettingItemStatus.Done done = itemStatus instanceof IMSettingItemStatus.Done ? (IMSettingItemStatus.Done) itemStatus : null;
                IMToast toast = done != null ? done.getToast() : null;
                IMSettingItemStatus.Pending pending = itemStatus instanceof IMSettingItemStatus.Pending ? (IMSettingItemStatus.Pending) itemStatus : null;
                final IMSettingState changedPageState = IMSettingState.copy$default(iMSettingState, null, copy$default, toast, null, null, pending != null ? pending.getDialog() : null, 25, null);
                KIMSettingType kIMSettingType = itemStatus instanceof IMSettingItemStatus.Done ? (IMSettingItemStatus.Done) itemStatus : null;
                if (kIMSettingType != null) {
                    KIMSettingType kIMSettingType2 = kIMSettingType;
                    SettingEventHub.INSTANCE.receiveChanged(changedPageState.getData(), kIMSettingType2.getResultItem());
                    if (kIMSettingType2.getSuccess()) {
                        notifyService.notify(changedPageState.getData(), kIMSettingType2.getResultItem());
                    }
                }
                return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachineKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMSettingState childStateMapper$lambda$2;
                        childStateMapper$lambda$2 = SettingStateMachineKt.childStateMapper$lambda$2(IMSettingState.this, (IMSettingState) obj);
                        return childStateMapper$lambda$2;
                    }
                });
            }
            Object element$iv$iv$iv = it.next();
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            SettingItem.Setting value = (SettingItem.Setting) ((Map.Entry) element$iv$iv$iv).getValue();
            Map $this$mapValues$iv2 = $this$mapValues$iv;
            if (Intrinsics.areEqual(value != null ? value.getType() : null, itemStatus.getType()) && !(itemStatus instanceof IMSettingItemStatus.Pending)) {
                if (itemStatus instanceof IMSettingItemStatus.Loading) {
                    setting = SettingItem.Setting.copy$default(value, null, null, false, true, 7, null);
                } else if (itemStatus instanceof IMSettingItemStatus.Done) {
                    setting = ((IMSettingItemStatus.Done) itemStatus).getResultItem();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                setting = value;
            }
            destination$iv$iv.put(key, setting);
            $this$mapValues$iv = $this$mapValues$iv2;
        }
    }

    public static final IMSettingState childStateMapper$lambda$2(IMSettingState $changedPageState, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return $changedPageState;
    }

    private static final /* synthetic */ <T extends KSetting.IContent> IMSettingItemAction childActionMapper(IMSettingAction action) {
        if (action instanceof IMSettingDialogConfirmAction) {
            ((IMSettingDialogConfirmAction) action).getItem().getSetting().getContent();
            Intrinsics.reifiedOperationMarker(2, "T");
            return IMSettingItemAction.Confirm.INSTANCE;
        } else if (action instanceof IMSettingDialogCancelAction) {
            ((IMSettingDialogCancelAction) action).getItem().getSetting().getContent();
            Intrinsics.reifiedOperationMarker(2, "T");
            return IMSettingItemAction.Cancel.INSTANCE;
        } else {
            return null;
        }
    }
}