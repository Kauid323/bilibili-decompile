package kntr.app.im.chat.sticker.di;

import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.im.chat.sticker.viewModel.StickerManagerViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: StickerComponent.kt */
@Subcomponent(modules = {})
@StickerScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/di/StickerComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "stickerManagerViewModel", "Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel;", "stickerManagerService", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "Builder", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface StickerComponent {

    /* compiled from: StickerComponent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/di/StickerComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.BUILD, "Lkntr/app/im/chat/sticker/di/StickerComponent;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        StickerComponent build();
    }

    StickerManagerService stickerManagerService();

    StickerManagerViewModel stickerManagerViewModel();
}