package im.setting.evethub;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KRedirectWindowSelect;
import com.bapis.bilibili.app.im.v1.KSelectItem;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingEventHub.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lim/setting/evethub/SettingEventHubFlowData;", "", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "changeDisplaySummary", "", "subPageData", "Lim/setting/model/IMSettingPageData;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Ljava/lang/String;Lim/setting/model/IMSettingPageData;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getChangeDisplaySummary", "()Ljava/lang/String;", "getSubPageData", "()Lim/setting/model/IMSettingPageData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingEventHubFlowData {
    private final String changeDisplaySummary;
    private final IMSettingPageData subPageData;
    private final KIMSettingType type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ SettingEventHubFlowData copy$default(SettingEventHubFlowData settingEventHubFlowData, KIMSettingType kIMSettingType, String str, IMSettingPageData iMSettingPageData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kIMSettingType = settingEventHubFlowData.type;
        }
        if ((i2 & 2) != 0) {
            str = settingEventHubFlowData.changeDisplaySummary;
        }
        if ((i2 & 4) != 0) {
            iMSettingPageData = settingEventHubFlowData.subPageData;
        }
        return settingEventHubFlowData.copy(kIMSettingType, str, iMSettingPageData);
    }

    public final KIMSettingType component1() {
        return this.type;
    }

    public final String component2() {
        return this.changeDisplaySummary;
    }

    public final IMSettingPageData component3() {
        return this.subPageData;
    }

    public final SettingEventHubFlowData copy(KIMSettingType kIMSettingType, String str, IMSettingPageData iMSettingPageData) {
        Intrinsics.checkNotNullParameter(kIMSettingType, "type");
        Intrinsics.checkNotNullParameter(iMSettingPageData, "subPageData");
        return new SettingEventHubFlowData(kIMSettingType, str, iMSettingPageData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingEventHubFlowData) {
            SettingEventHubFlowData settingEventHubFlowData = (SettingEventHubFlowData) obj;
            return Intrinsics.areEqual(this.type, settingEventHubFlowData.type) && Intrinsics.areEqual(this.changeDisplaySummary, settingEventHubFlowData.changeDisplaySummary) && Intrinsics.areEqual(this.subPageData, settingEventHubFlowData.subPageData);
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + (this.changeDisplaySummary == null ? 0 : this.changeDisplaySummary.hashCode())) * 31) + this.subPageData.hashCode();
    }

    public String toString() {
        KIMSettingType kIMSettingType = this.type;
        String str = this.changeDisplaySummary;
        return "SettingEventHubFlowData(type=" + kIMSettingType + ", changeDisplaySummary=" + str + ", subPageData=" + this.subPageData + ")";
    }

    public SettingEventHubFlowData(KIMSettingType type, String changeDisplaySummary, IMSettingPageData subPageData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subPageData, "subPageData");
        this.type = type;
        this.changeDisplaySummary = changeDisplaySummary;
        this.subPageData = subPageData;
    }

    public final KIMSettingType getType() {
        return this.type;
    }

    public final String getChangeDisplaySummary() {
        return this.changeDisplaySummary;
    }

    public final IMSettingPageData getSubPageData() {
        return this.subPageData;
    }

    /* compiled from: SettingEventHub.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lim/setting/evethub/SettingEventHubFlowData$Companion;", "", "<init>", "()V", "initialize", "", "Lim/setting/evethub/SettingEventHubFlowData;", "subPageData", "Lim/setting/model/IMSettingPageData;", "item", "Lim/setting/model/SettingItem$Setting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<SettingEventHubFlowData> initialize(IMSettingPageData subPageData, SettingItem.Setting item) {
            String str;
            Map $this$mapTo$iv$iv;
            Pair pair;
            SettingItem.Setting setting;
            KRedirectWindowSelect value;
            List item2;
            Object obj;
            String text;
            String text2;
            String text3;
            String text4;
            String text5;
            String text6;
            Intrinsics.checkNotNullParameter(subPageData, "subPageData");
            Intrinsics.checkNotNullParameter(item, "item");
            KIMSettingType type = item.getType();
            String str2 = "";
            if (type instanceof KIMSettingType.SETTING_TYPE_REPLY_ME) {
                KSetting.KSelect content = item.getSetting().getContent();
                KSetting.KSelect it = content instanceof KSetting.KSelect ? content : null;
                if (it != null) {
                    KIMSettingType type2 = item.getType();
                    Iterator it2 = it.getValue().getItem().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (((KSelectItem) next).getSelected()) {
                            r9 = next;
                            break;
                        }
                    }
                    KSelectItem kSelectItem = (KSelectItem) r9;
                    if (kSelectItem != null && (text6 = kSelectItem.getText()) != null) {
                        str2 = text6;
                    }
                    r9 = new SettingEventHubFlowData(type2, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_RECEIVE_LIKE) {
                KSetting.KSelect content2 = item.getSetting().getContent();
                KSetting.KSelect it3 = content2 instanceof KSetting.KSelect ? content2 : null;
                if (it3 != null) {
                    KIMSettingType type3 = item.getType();
                    Iterator it4 = it3.getValue().getItem().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        Object next2 = it4.next();
                        if (((KSelectItem) next2).getSelected()) {
                            r9 = next2;
                            break;
                        }
                    }
                    KSelectItem kSelectItem2 = (KSelectItem) r9;
                    if (kSelectItem2 != null && (text5 = kSelectItem2.getText()) != null) {
                        str2 = text5;
                    }
                    r9 = new SettingEventHubFlowData(type3, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_NEW_FANS) {
                KSetting.KSelect content3 = item.getSetting().getContent();
                KSetting.KSelect it5 = content3 instanceof KSetting.KSelect ? content3 : null;
                if (it5 != null) {
                    KIMSettingType type4 = item.getType();
                    Iterator it6 = it5.getValue().getItem().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        Object next3 = it6.next();
                        if (((KSelectItem) next3).getSelected()) {
                            r9 = next3;
                            break;
                        }
                    }
                    KSelectItem kSelectItem3 = (KSelectItem) r9;
                    if (kSelectItem3 != null && (text4 = kSelectItem3.getText()) != null) {
                        str2 = text4;
                    }
                    r9 = new SettingEventHubFlowData(type4, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_OLD_REPLY_ME) {
                KSetting.KSelect content4 = item.getSetting().getContent();
                KSetting.KSelect it7 = content4 instanceof KSetting.KSelect ? content4 : null;
                if (it7 != null) {
                    KIMSettingType type5 = item.getType();
                    Iterator it8 = it7.getValue().getItem().iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        Object next4 = it8.next();
                        if (((KSelectItem) next4).getSelected()) {
                            r9 = next4;
                            break;
                        }
                    }
                    KSelectItem kSelectItem4 = (KSelectItem) r9;
                    if (kSelectItem4 != null && (text3 = kSelectItem4.getText()) != null) {
                        str2 = text3;
                    }
                    r9 = new SettingEventHubFlowData(type5, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_OLD_AT_ME) {
                KSetting.KSelect content5 = item.getSetting().getContent();
                KSetting.KSelect it9 = content5 instanceof KSetting.KSelect ? content5 : null;
                if (it9 != null) {
                    KIMSettingType type6 = item.getType();
                    Iterator it10 = it9.getValue().getItem().iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            break;
                        }
                        Object next5 = it10.next();
                        if (((KSelectItem) next5).getSelected()) {
                            r9 = next5;
                            break;
                        }
                    }
                    KSelectItem kSelectItem5 = (KSelectItem) r9;
                    if (kSelectItem5 != null && (text2 = kSelectItem5.getText()) != null) {
                        str2 = text2;
                    }
                    r9 = new SettingEventHubFlowData(type6, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_OLD_RECEIVE_LIKE) {
                KSetting.KSelect content6 = item.getSetting().getContent();
                KSetting.KSelect it11 = content6 instanceof KSetting.KSelect ? content6 : null;
                if (it11 != null) {
                    KIMSettingType type7 = item.getType();
                    Iterator it12 = it11.getValue().getItem().iterator();
                    while (true) {
                        if (!it12.hasNext()) {
                            break;
                        }
                        Object next6 = it12.next();
                        if (((KSelectItem) next6).getSelected()) {
                            r9 = next6;
                            break;
                        }
                    }
                    KSelectItem kSelectItem6 = (KSelectItem) r9;
                    if (kSelectItem6 != null && (text = kSelectItem6.getText()) != null) {
                        str2 = text;
                    }
                    r9 = new SettingEventHubFlowData(type7, str2, subPageData);
                }
                return CollectionsKt.listOfNotNull(r9);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_RECEIVE) {
                KSetting.KSwitch content7 = item.getSetting().getContent();
                KSetting.KSwitch it13 = content7 instanceof KSetting.KSwitch ? content7 : null;
                return CollectionsKt.listOfNotNull(it13 != null ? new SettingEventHubFlowData(KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG.INSTANCE, it13.getValue().getSwitchOn() ? "接收消息" : "不接收消息", subPageData) : null);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_FOLD) {
                KSetting.KSwitch content8 = item.getSetting().getContent();
                return CollectionsKt.listOfNotNull((content8 instanceof KSetting.KSwitch ? content8 : null) != null ? new SettingEventHubFlowData(KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG.INSTANCE, null, subPageData) : null);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_RECEIVE) {
                KSetting.KSwitch content9 = item.getSetting().getContent();
                return CollectionsKt.listOfNotNull((content9 instanceof KSetting.KSwitch ? content9 : null) != null ? new SettingEventHubFlowData(KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG.INSTANCE, null, subPageData) : null);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_FOLD) {
                KSetting.KSwitch content10 = item.getSetting().getContent();
                return CollectionsKt.listOfNotNull((content10 instanceof KSetting.KSwitch ? content10 : null) != null ? new SettingEventHubFlowData(KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG.INSTANCE, null, subPageData) : null);
            } else if (type instanceof KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_SWITCH) {
                KSetting.KSwitch content11 = item.getSetting().getContent();
                return CollectionsKt.listOfNotNull((content11 instanceof KSetting.KSwitch ? content11 : null) != null ? new SettingEventHubFlowData(KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT.INSTANCE, null, subPageData) : null);
            } else if ((type instanceof KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_INTERACT_LIMITS) || Intrinsics.areEqual(type, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_DURATION.INSTANCE) || Intrinsics.areEqual(type, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_COMMENT_LIMITS.INSTANCE) || Intrinsics.areEqual(type, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_DANMU_LIMITS.INSTANCE) || Intrinsics.areEqual(type, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_IM_LIMITS.INSTANCE)) {
                KSetting.KRedirect content12 = item.getSetting().getContent();
                KSetting.KRedirect it14 = content12 instanceof KSetting.KRedirect ? content12 : null;
                if (it14 != null) {
                    KSettingRedirect.KWindowSelect content13 = it14.getValue().getContent();
                    KSettingRedirect.KWindowSelect kWindowSelect = content13 instanceof KSettingRedirect.KWindowSelect ? content13 : null;
                    if (kWindowSelect != null && (value = kWindowSelect.getValue()) != null && (item2 = value.getItem()) != null) {
                        Iterator it15 = item2.iterator();
                        while (true) {
                            if (!it15.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it15.next();
                            if (((KSelectItem) obj).getSelected()) {
                                break;
                            }
                        }
                        KSelectItem kSelectItem7 = (KSelectItem) obj;
                        if (kSelectItem7 != null) {
                            str = kSelectItem7.getText();
                        }
                    }
                    str = null;
                } else {
                    str = null;
                }
                String changeDisplaySummary = str;
                SettingEventHubFlowData[] settingEventHubFlowDataArr = new SettingEventHubFlowData[2];
                KSetting.KRedirect content14 = item.getSetting().getContent();
                settingEventHubFlowDataArr[0] = (content14 instanceof KSetting.KRedirect ? content14 : null) != null ? new SettingEventHubFlowData(item.getType(), changeDisplaySummary, subPageData) : null;
                KSetting.KRedirect content15 = item.getSetting().getContent();
                if ((content15 instanceof KSetting.KRedirect ? content15 : null) != null) {
                    KIMSettingType kIMSettingType = KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT.INSTANCE;
                    Map $this$map$iv = subPageData.getSettings$logic_debug();
                    boolean z = false;
                    Collection destination$iv$iv = new ArrayList($this$map$iv.size());
                    Map $this$mapTo$iv$iv2 = $this$map$iv;
                    for (Map.Entry item$iv$iv : $this$mapTo$iv$iv2.entrySet()) {
                        int key = item$iv$iv.getKey().intValue();
                        Map $this$map$iv2 = $this$map$iv;
                        SettingItem.Setting value2 = item$iv$iv.getValue();
                        boolean z2 = z;
                        int $i$f$map = item.getType().getValue();
                        if (key == $i$f$map) {
                            Integer valueOf = Integer.valueOf(key);
                            if (value2 != null) {
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                setting = SettingEventHubKt.access$update(value2, changeDisplaySummary);
                            } else {
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                setting = null;
                            }
                            pair = TuplesKt.to(valueOf, setting);
                        } else {
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                            pair = TuplesKt.to(Integer.valueOf(key), value2);
                        }
                        destination$iv$iv.add(pair);
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        $this$map$iv = $this$map$iv2;
                        z = z2;
                    }
                    r9 = new SettingEventHubFlowData(kIMSettingType, null, IMSettingPageData.copy$default(subPageData, null, null, MapsKt.toMap((List) destination$iv$iv), null, 11, null));
                }
                settingEventHubFlowDataArr[1] = r9;
                return CollectionsKt.listOfNotNull(settingEventHubFlowDataArr);
            } else {
                return CollectionsKt.emptyList();
            }
        }
    }
}