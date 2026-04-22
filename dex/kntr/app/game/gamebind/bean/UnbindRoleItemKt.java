package kntr.app.game.gamebind.bean;

import com.bilibili.biligame.kntr.common.util.KtJsonKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: UnbindRoleItem.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"decodeFromString", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "str", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UnbindRoleItemKt {
    public static final UnbindRoleItem decodeFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Json this_$iv = KtJsonKt.getKtJson();
        this_$iv.getSerializersModule();
        return (UnbindRoleItem) this_$iv.decodeFromString(UnbindRoleItem.Companion.serializer(), str);
    }
}