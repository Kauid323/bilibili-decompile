package kntr.app.cheese.space.aggregate;

import com.bilibili.ogv.operation3.module.aggregate.MonoModulesModule;
import com.bilibili.ogv.operation3.module.concept.ModulesScope;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import kntr.app.cheese.space.PerLoadScope;
import kntr.app.cheese.space.SpaceCheesePerLoadUiService;
import kntr.app.cheese.space.api.PageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: SpaceCheesePagePerLoadComponent.kt */
@ModulesScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "uiService", "Lkntr/app/cheese/space/SpaceCheesePerLoadUiService;", "Factory", "Impl", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Subcomponent(modules = {Impl.class, MonoModulesModule.class})
@PerLoadScope
public interface SpaceCheesePagePerLoadComponent {

    /* compiled from: SpaceCheesePagePerLoadComponent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent;", "pageData", "Lkntr/app/cheese/space/api/PageData;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        SpaceCheesePagePerLoadComponent create(@BindsInstance PageData pageData, @BindsInstance KomponentScope<? super Unit> komponentScope);
    }

    SpaceCheesePerLoadUiService uiService();

    /* compiled from: SpaceCheesePagePerLoadComponent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent$Impl;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Module
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Impl {
        public static final int $stable = 0;
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }
    }
}