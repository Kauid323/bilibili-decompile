package im.setting.model;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\r0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001c\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u001c\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u001c\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010#\u001a\u0004\b\u000b\u0010$\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\r0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010#\u001a\u0004\b\u000f\u0010$\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010#\u001a\u0004\b\u0010\u0010$\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00110\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010#\u001a\u0004\b\u0013\u0010$¨\u0006%"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/setting/model/SettingItem$Setting;", "Lim/setting/model/SettingItem$Setting$Companion;", "getLens$annotations", "(Lim/setting/model/SettingItem$Setting$Companion;)V", "getLens", "(Lim/setting/model/SettingItem$Setting$Companion;)Lcom/bilibili/blens/BSimpleLens;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getType$annotations", "getType", "setting", "Lcom/bapis/bilibili/app/im/v1/KSetting;", "getSetting$annotations", "getSetting", "isDisabled", "", "isDisabled$annotations", "isLoading", "isLoading$annotations", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "typeNullable$annotations", "typeNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "settingNullable$annotations", "settingNullable", "isDisabledNullable$annotations", "isDisabledNullable", "isLoadingNullable$annotations", "isLoadingNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingLensKt {
    public static /* synthetic */ void getLens$annotations(SettingItem.Setting.Companion companion) {
    }

    public static /* synthetic */ void getSetting$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSetting$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSetting$annotations(SettingItem.Setting.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(SettingItem.Setting.Companion companion) {
    }

    public static /* synthetic */ void isDisabled$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isDisabled$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isDisabled$annotations(SettingItem.Setting.Companion companion) {
    }

    public static /* synthetic */ void isDisabledNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLoading$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isLoading$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLoading$annotations(SettingItem.Setting.Companion companion) {
    }

    public static /* synthetic */ void isLoadingNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void settingNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<SettingItem.Setting, SettingItem.Setting> getLens(SettingItem.Setting.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<SettingItem.Setting, SettingItem.Setting>() { // from class: im.setting.model.SettingLensKt$special$$inlined$invoke$1
            public SettingItem.Setting get(SettingItem.Setting setting) {
                SettingItem.Setting it = setting;
                return it;
            }

            public SettingItem.Setting set(SettingItem.Setting setting, SettingItem.Setting setting2) {
                SettingItem.Setting it = setting2;
                return it;
            }

            public SettingItem.Setting modify(SettingItem.Setting setting, Function1<? super SettingItem.Setting, ? extends SettingItem.Setting> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                SettingItem.Setting it = setting;
                return (SettingItem.Setting) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<SettingItem.Setting, KIMSettingType> getType(SettingItem.Setting.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<SettingItem.Setting, KIMSettingType>() { // from class: im.setting.model.SettingLensKt$special$$inlined$invoke$2
            public KIMSettingType get(SettingItem.Setting setting) {
                SettingItem.Setting it = setting;
                return it.getType();
            }

            public SettingItem.Setting set(SettingItem.Setting setting, KIMSettingType kIMSettingType) {
                KIMSettingType type = kIMSettingType;
                SettingItem.Setting it = setting;
                return SettingItem.Setting.copy$default(it, type, null, false, false, 14, null);
            }

            public SettingItem.Setting modify(SettingItem.Setting setting, Function1<? super KIMSettingType, ? extends KIMSettingType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                SettingItem.Setting it = setting;
                KIMSettingType type = (KIMSettingType) function1.invoke(it.getType());
                SettingItem.Setting it2 = setting;
                return SettingItem.Setting.copy$default(it2, type, null, false, false, 14, null);
            }
        };
    }

    public static final BSimpleLens<SettingItem.Setting, KSetting> getSetting(SettingItem.Setting.Companion $this$setting) {
        Intrinsics.checkNotNullParameter($this$setting, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<SettingItem.Setting, KSetting>() { // from class: im.setting.model.SettingLensKt$special$$inlined$invoke$3
            public KSetting get(SettingItem.Setting setting) {
                SettingItem.Setting it = setting;
                return it.getSetting();
            }

            public SettingItem.Setting set(SettingItem.Setting setting, KSetting kSetting) {
                KSetting setting2 = kSetting;
                SettingItem.Setting it = setting;
                return SettingItem.Setting.copy$default(it, null, setting2, false, false, 13, null);
            }

            public SettingItem.Setting modify(SettingItem.Setting setting, Function1<? super KSetting, ? extends KSetting> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                SettingItem.Setting it = setting;
                KSetting setting2 = (KSetting) function1.invoke(it.getSetting());
                SettingItem.Setting it2 = setting;
                return SettingItem.Setting.copy$default(it2, null, setting2, false, false, 13, null);
            }
        };
    }

    public static final BSimpleLens<SettingItem.Setting, Boolean> isDisabled(SettingItem.Setting.Companion $this$isDisabled) {
        Intrinsics.checkNotNullParameter($this$isDisabled, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<SettingItem.Setting, Boolean>() { // from class: im.setting.model.SettingLensKt$special$$inlined$invoke$4
            public Boolean get(SettingItem.Setting setting) {
                SettingItem.Setting it = setting;
                return Boolean.valueOf(it.isDisabled());
            }

            public SettingItem.Setting set(SettingItem.Setting setting, Boolean bool) {
                boolean isDisabled = bool.booleanValue();
                SettingItem.Setting it = setting;
                return SettingItem.Setting.copy$default(it, null, null, isDisabled, false, 11, null);
            }

            public SettingItem.Setting modify(SettingItem.Setting setting, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                SettingItem.Setting it = setting;
                boolean isDisabled = ((Boolean) function1.invoke(Boolean.valueOf(it.isDisabled()))).booleanValue();
                SettingItem.Setting it2 = setting;
                return SettingItem.Setting.copy$default(it2, null, null, isDisabled, false, 11, null);
            }
        };
    }

    public static final BSimpleLens<SettingItem.Setting, Boolean> isLoading(SettingItem.Setting.Companion $this$isLoading) {
        Intrinsics.checkNotNullParameter($this$isLoading, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<SettingItem.Setting, Boolean>() { // from class: im.setting.model.SettingLensKt$special$$inlined$invoke$5
            public Boolean get(SettingItem.Setting setting) {
                SettingItem.Setting it = setting;
                return Boolean.valueOf(it.isLoading());
            }

            public SettingItem.Setting set(SettingItem.Setting setting, Boolean bool) {
                boolean isLoading = bool.booleanValue();
                SettingItem.Setting it = setting;
                return SettingItem.Setting.copy$default(it, null, null, false, isLoading, 7, null);
            }

            public SettingItem.Setting modify(SettingItem.Setting setting, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                SettingItem.Setting it = setting;
                boolean isLoading = ((Boolean) function1.invoke(Boolean.valueOf(it.isLoading()))).booleanValue();
                SettingItem.Setting it2 = setting;
                return SettingItem.Setting.copy$default(it2, null, null, false, isLoading, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, KIMSettingType> getType(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getType(SettingItem.Setting.Companion));
    }

    public static final <T> BSimpleLens<T, KSetting> getSetting(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSetting(SettingItem.Setting.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isDisabled(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isDisabled(SettingItem.Setting.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isLoading(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isLoading(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, KIMSettingType> typeNullable(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getType(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, KSetting> settingNullable(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSetting(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isDisabledNullable(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isDisabled(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLoadingNullable(BSimpleLens<T, SettingItem.Setting> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isLoading(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, KIMSettingType> getType(BNullableLens<T, SettingItem.Setting> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getType(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, KSetting> getSetting(BNullableLens<T, SettingItem.Setting> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSetting(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isDisabled(BNullableLens<T, SettingItem.Setting> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isDisabled(SettingItem.Setting.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLoading(BNullableLens<T, SettingItem.Setting> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isLoading(SettingItem.Setting.Companion));
    }
}