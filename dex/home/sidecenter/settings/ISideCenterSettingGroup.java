package home.sidecenter.settings;

import java.util.List;
import kotlin.Metadata;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingGroup;", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "items", "", "getItems", "()Ljava/util/List;", "setItemChecked", "item", "isChecked", "", "isTypeChecked", "type", "Lhome/sidecenter/settings/SideCenterSettingType;", "Lhome/sidecenter/settings/SideCenterSettingGroup;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISideCenterSettingGroup extends ISideCenterSettingItem {
    List<ISideCenterSettingItem> getItems();

    boolean isTypeChecked(SideCenterSettingType sideCenterSettingType);

    ISideCenterSettingGroup setItemChecked(ISideCenterSettingItem iSideCenterSettingItem, boolean z);
}