package im.setting.service;

import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: SettingChangeService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lim/setting/service/SettingChangeService;", "", "change", "Lkotlin/Result;", "", "item", "Lim/setting/model/SettingItem$Setting;", "change-gIAlu-s", "(Lim/setting/model/SettingItem$Setting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingChangeService {
    /* renamed from: change-gIAlu-s */
    Object mo3403changegIAlus(SettingItem.Setting setting, Continuation<? super Result<String>> continuation);
}