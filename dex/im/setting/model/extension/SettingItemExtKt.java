package im.setting.model.extension;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KRedirectWindowSelect;
import com.bapis.bilibili.app.im.v1.KSelectItem;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bapis.bilibili.app.im.v1.KSettingSelect;
import com.bapis.bilibili.app.im.v1.KSettingSwitch;
import com.bapis.bilibili.app.im.v1.KSwitchConfirmDialog;
import im.setting.model.SettingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItemExt.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a6\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0000\u001a(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0003*\u00020\u0001H\u0000¨\u0006\u0011"}, d2 = {"transformWithSwitch", "Lim/setting/model/SettingItem$Setting;", "on", "", "transformWithSelect", "selectType", "", "initialize", "Lim/setting/model/SettingItem$Setting$Companion;", "settings", "", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "isDisabled", "toSettingItemsMap", "Lcom/bapis/bilibili/app/im/v1/KSetting;", "needCloseWindowWhenSelect", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingItemExtKt {
    public static final SettingItem.Setting transformWithSwitch(SettingItem.Setting $this$transformWithSwitch, boolean on) {
        Intrinsics.checkNotNullParameter($this$transformWithSwitch, "<this>");
        if (!($this$transformWithSwitch.getSetting().getContent() instanceof KSetting.KSwitch)) {
            return $this$transformWithSwitch;
        }
        KSetting setting = $this$transformWithSwitch.getSetting();
        KSetting.KSwitch content = $this$transformWithSwitch.getSetting().getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KSwitch");
        KSetting.KSwitch content2 = $this$transformWithSwitch.getSetting().getContent();
        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KSwitch");
        return SettingItem.Setting.copy$default($this$transformWithSwitch, null, setting.copy(content.copy(KSettingSwitch.copy$default(content2.getValue(), on, (String) null, (String) null, (KSwitchConfirmDialog) null, (KSwitchConfirmDialog) null, 30, (Object) null))), false, false, 13, null);
    }

    public static final SettingItem.Setting transformWithSelect(SettingItem.Setting $this$transformWithSelect, int selectType) {
        Intrinsics.checkNotNullParameter($this$transformWithSelect, "<this>");
        if ($this$transformWithSelect.getSetting().getContent() instanceof KSetting.KSelect) {
            KSetting setting = $this$transformWithSelect.getSetting();
            KSetting.KSelect content = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KSelect");
            KSetting.KSelect kSelect = content;
            KSetting.KSelect content2 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KSelect");
            KSettingSelect value = content2.getValue();
            KSetting.KSelect content3 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KSelect");
            Iterable $this$map$iv = content3.getValue().getItem();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KSelectItem it = (KSelectItem) item$iv$iv;
                destination$iv$iv.add(KSelectItem.copy$default(it, 0, (String) null, it.getItemType() == selectType, 3, (Object) null));
            }
            return SettingItem.Setting.copy$default($this$transformWithSelect, null, setting.copy(kSelect.copy(value.copy((List) destination$iv$iv))), false, false, 13, null);
        } else if ($this$transformWithSelect.getSetting().getContent() instanceof KSetting.KRedirect) {
            KSetting setting2 = $this$transformWithSelect.getSetting();
            KSetting.KRedirect content4 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSetting.KRedirect kRedirect = content4;
            KSetting.KRedirect content5 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content5, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSettingRedirect value2 = content5.getValue();
            KSetting.KRedirect content6 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content6, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSettingRedirect.KWindowSelect content7 = content6.getValue().getContent();
            Intrinsics.checkNotNull(content7, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSettingRedirect.KWindowSelect");
            KSettingRedirect.KWindowSelect kWindowSelect = content7;
            KSetting.KRedirect content8 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content8, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSettingRedirect.KWindowSelect content9 = content8.getValue().getContent();
            Intrinsics.checkNotNull(content9, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSettingRedirect.KWindowSelect");
            KRedirectWindowSelect value3 = content9.getValue();
            KSetting.KRedirect content10 = $this$transformWithSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content10, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSettingRedirect.KWindowSelect content11 = content10.getValue().getContent();
            Intrinsics.checkNotNull(content11, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSettingRedirect.KWindowSelect");
            Iterable $this$map$iv2 = content11.getValue().getItem();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                KSelectItem it2 = (KSelectItem) item$iv$iv2;
                destination$iv$iv2.add(KSelectItem.copy$default(it2, 0, (String) null, it2.getItemType() == selectType, 3, (Object) null));
            }
            return SettingItem.Setting.copy$default($this$transformWithSelect, null, setting2.copy(kRedirect.copy(KSettingRedirect.copy$default(value2, kWindowSelect.copy(KRedirectWindowSelect.copy$default(value3, (String) null, (List) destination$iv$iv2, 1, (Object) null)), (String) null, (String) null, (String) null, 14, (Object) null))), false, false, 13, null);
        } else {
            return $this$transformWithSelect;
        }
    }

    public static /* synthetic */ SettingItem.Setting initialize$default(SettingItem.Setting.Companion companion, Map map, KIMSettingType kIMSettingType, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return initialize(companion, map, kIMSettingType, z);
    }

    public static final SettingItem.Setting initialize(SettingItem.Setting.Companion $this$initialize, Map<Integer, SettingItem.Setting> map, KIMSettingType type, boolean isDisabled) {
        Intrinsics.checkNotNullParameter($this$initialize, "<this>");
        Intrinsics.checkNotNullParameter(map, "settings");
        Intrinsics.checkNotNullParameter(type, "type");
        SettingItem.Setting it = map.get(Integer.valueOf(type.getValue()));
        if (it != null) {
            return new SettingItem.Setting(type, it.getSetting(), isDisabled, false, 8, null);
        }
        return null;
    }

    public static final Map<Integer, SettingItem.Setting> toSettingItemsMap(Map<Integer, KSetting> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterable $this$associateByTo$iv$iv$iv = map.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry entry = (Map.Entry) element$iv$iv$iv;
            int key2 = ((Number) entry.getKey()).intValue();
            KSetting value = (KSetting) entry.getValue();
            destination$iv$iv.put(key, value != null ? new SettingItem.Setting(KIMSettingType.Companion.fromValue(key2), value, false, false, 12, null) : null);
        }
        return destination$iv$iv;
    }

    public static final boolean needCloseWindowWhenSelect(SettingItem.Setting $this$needCloseWindowWhenSelect) {
        Intrinsics.checkNotNullParameter($this$needCloseWindowWhenSelect, "<this>");
        if ($this$needCloseWindowWhenSelect.getSetting().getContent() instanceof KSetting.KRedirect) {
            KSetting.KRedirect content = $this$needCloseWindowWhenSelect.getSetting().getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            if (content.getValue().getContent() instanceof KSettingRedirect.KWindowSelect) {
                return true;
            }
        }
        return false;
    }
}