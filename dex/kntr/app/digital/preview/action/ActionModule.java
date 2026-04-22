package kntr.app.digital.preview.action;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: ActionModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00028\u00000\tH&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/action/ActionModule;", "Data", RoomRecommendViewModel.EMPTY_CURSOR, "actionType", "Lkotlin/reflect/KClass;", "getActionType", "()Lkotlin/reflect/KClass;", "run", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/action/Action;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ActionModule<Data> {
    KClass<Data> getActionType();

    void run(Action<Data> action);
}