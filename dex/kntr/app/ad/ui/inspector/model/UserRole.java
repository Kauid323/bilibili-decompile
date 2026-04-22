package kntr.app.ad.ui.inspector.model;

import androidx.compose.ui.graphics.ColorKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: UserRole.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/model/UserRole;", RoomRecommendViewModel.EMPTY_CURSOR, "displayName", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getDisplayName", "()Ljava/lang/String;", "getColor-0d7_KjU", "()J", "J", "OPERATOR", "PRODUCT", "TESTER", "DEVELOPER", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum UserRole {
    OPERATOR("运营", ColorKt.Color(4294286859L)),
    PRODUCT("产品", ColorKt.Color(4287245282L)),
    TESTER("测试", ColorKt.Color(4279286145L)),
    DEVELOPER("开发", ColorKt.Color(4282090230L));
    
    private final long color;
    private final String displayName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<UserRole> getEntries() {
        return $ENTRIES;
    }

    UserRole(String displayName, long color) {
        this.displayName = displayName;
        this.color = color;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m353getColor0d7_KjU() {
        return this.color;
    }
}