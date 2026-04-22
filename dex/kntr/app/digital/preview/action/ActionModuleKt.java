package kntr.app.digital.preview.action;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ActionModule.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u001f\b\u0004\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"ActionModule", "Lkntr/app/digital/preview/action/ActionModule;", "Data", RoomRecommendViewModel.EMPTY_CURSOR, "block", "Lkotlin/Function1;", "Lkntr/app/digital/preview/action/Action;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionModuleKt {
    public static final /* synthetic */ <Data> ActionModule<?> ActionModule(final Function1<? super Action<Data>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Intrinsics.needClassReification();
        return (ActionModule) ((ActionModule<Data>) new ActionModule<Data>() { // from class: kntr.app.digital.preview.action.ActionModuleKt$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<Data> getActionType() {
                Intrinsics.reifiedOperationMarker(4, "Data");
                return Reflection.getOrCreateKotlinClass(Object.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<Data> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                function1.invoke(action);
            }
        });
    }
}