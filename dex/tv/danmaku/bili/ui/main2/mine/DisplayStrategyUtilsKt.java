package tv.danmaku.bili.ui.main2.mine;

import com.bapis.bilibili.app.mine.v1.DisplayPos;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import tv.danmaku.bili.BR;

/* compiled from: DisplayStrategyUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"displayInfoJson", "Lkotlinx/serialization/json/Json;", "toDisplayStrategyPositionType", "Ltv/danmaku/bili/ui/main2/mine/DisplayStrategyPositionType;", "", "toDisplayPos", "Lcom/bapis/bilibili/app/mine/v1/DisplayPos;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DisplayStrategyUtilsKt {
    private static final Json displayInfoJson = JsonKt.Json$default((Json) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.DisplayStrategyUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit displayInfoJson$lambda$0;
            displayInfoJson$lambda$0 = DisplayStrategyUtilsKt.displayInfoJson$lambda$0((JsonBuilder) obj);
            return displayInfoJson$lambda$0;
        }
    }, 1, (Object) null);

    /* compiled from: DisplayStrategyUtils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayStrategyPositionType.values().length];
            try {
                iArr[DisplayStrategyPositionType.DYNAMIC_ICON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DisplayStrategyPositionType.STATIC_ICON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DisplayStrategyPositionType.BACKGROUND_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DisplayStrategyPositionType.BIRTHDAY_ICON.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DisplayStrategyPositionType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayInfoJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public static final DisplayStrategyPositionType toDisplayStrategyPositionType(int $this$toDisplayStrategyPositionType) {
        return $this$toDisplayStrategyPositionType == DisplayStrategyPositionType.DYNAMIC_ICON.getType() ? DisplayStrategyPositionType.DYNAMIC_ICON : $this$toDisplayStrategyPositionType == DisplayStrategyPositionType.STATIC_ICON.getType() ? DisplayStrategyPositionType.STATIC_ICON : $this$toDisplayStrategyPositionType == DisplayStrategyPositionType.BACKGROUND_IMAGE.getType() ? DisplayStrategyPositionType.BACKGROUND_IMAGE : $this$toDisplayStrategyPositionType == DisplayStrategyPositionType.BIRTHDAY_ICON.getType() ? DisplayStrategyPositionType.BIRTHDAY_ICON : DisplayStrategyPositionType.UNKNOWN;
    }

    public static final DisplayPos toDisplayPos(DisplayStrategyPositionType $this$toDisplayPos) {
        Intrinsics.checkNotNullParameter($this$toDisplayPos, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toDisplayPos.ordinal()]) {
            case 1:
                return DisplayPos.VIP_BUTTON_DYNAMIC;
            case 2:
                return DisplayPos.VIP_BUTTON_STATIC;
            case 3:
                return DisplayPos.VIP_BACKGROUND;
            case 4:
                return DisplayPos.VIP_BUTTON_BIRTHDAY;
            case 5:
                return DisplayPos.UNKNOWN_DISPLAYTYPE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}