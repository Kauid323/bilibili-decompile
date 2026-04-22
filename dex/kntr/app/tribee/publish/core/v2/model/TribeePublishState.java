package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BSimpleLens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishState.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\b\t\u0003\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "", "getPublishContent", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "editToast", "Lcom/bilibili/blens/BSimpleLens;", "", "getEditToast", "()Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishClosing;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishEditContent;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishFailed;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishInitLoading;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishNewContent;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSucceed;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishUploading;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishState {
    BSimpleLens<TribeePublishState, String> getEditToast();

    TribeePublishContent getPublishContent();
}