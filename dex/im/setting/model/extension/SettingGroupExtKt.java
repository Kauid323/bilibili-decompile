package im.setting.model.extension;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import im.setting.model.SettingGroup;
import im.setting.model.SettingGroupTitleEnum;
import im.setting.model.SettingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingGroupExt.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a*\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\u001a$\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000¨\u0006\r"}, d2 = {"find", "Lim/setting/model/SettingItem$Setting;", "", "Lim/setting/model/SettingGroup;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "init", "Lim/setting/model/SettingGroup$Companion;", "items", "Lim/setting/model/SettingItem;", "title", "Lim/setting/model/SettingGroupTitleEnum;", "item", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingGroupExtKt {
    public static final SettingItem.Setting find(List<SettingGroup> list, KIMSettingType type) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        List<SettingGroup> $this$flatMap$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (SettingGroup it : $this$flatMap$iv) {
            Iterable list$iv$iv = it.getItems();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof SettingItem.Setting) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterator it2 = ((List) destination$iv$iv2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            SettingItem.Setting it3 = (SettingItem.Setting) obj;
            if (Intrinsics.areEqual(it3.getType(), type)) {
                break;
            }
        }
        return (SettingItem.Setting) obj;
    }

    public static /* synthetic */ SettingGroup init$default(SettingGroup.Companion companion, List list, SettingGroupTitleEnum settingGroupTitleEnum, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            settingGroupTitleEnum = null;
        }
        return init(companion, list, settingGroupTitleEnum);
    }

    public static final SettingGroup init(SettingGroup.Companion $this$init, List<? extends SettingItem> list, SettingGroupTitleEnum title) {
        Intrinsics.checkNotNullParameter($this$init, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        List it = CollectionsKt.filterNotNull(list);
        if (it.isEmpty()) {
            it = null;
        }
        if (it != null) {
            return new SettingGroup(title, it);
        }
        return null;
    }

    public static /* synthetic */ SettingGroup init$default(SettingGroup.Companion companion, SettingItem settingItem, SettingGroupTitleEnum settingGroupTitleEnum, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            settingGroupTitleEnum = null;
        }
        return init(companion, settingItem, settingGroupTitleEnum);
    }

    public static final SettingGroup init(SettingGroup.Companion $this$init, SettingItem item, SettingGroupTitleEnum title) {
        Intrinsics.checkNotNullParameter($this$init, "<this>");
        return init(SettingGroup.Companion, CollectionsKt.listOf(item), title);
    }
}