package kntr.app.im.chat.ui.utils;

import androidx.compose.runtime.Composer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: ChatPageController.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH&¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/utils/ChatPageController;", RoomRecommendViewModel.EMPTY_CURSOR, "showBottomSheet", RoomRecommendViewModel.EMPTY_CURSOR, "bottomSheetBuilder", "Lkotlin/Function1;", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatPageController {
    void showBottomSheet(Function3<? super BottomSheetScope, ? super Composer, ? super Integer, Unit> function3);
}