package kntr.watch.later.watchlater.api;

import com.bapis.bilibili.app.translation.v1.KTranslationBusiness;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TranslateApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/watch/later/watchlater/api/TranslatableData;", "", "bizType", "Lcom/bapis/bilibili/app/translation/v1/KTranslationBusiness;", "getBizType", "()Lcom/bapis/bilibili/app/translation/v1/KTranslationBusiness;", "bizId", "", "getBizId", "()Ljava/lang/String;", "originTitle", "getOriginTitle", "translateStatus", "", "getTranslateStatus", "()I", "setTranslateStatus", "(I)V", "translateTitle", "getTranslateTitle", "setTranslateTitle", "(Ljava/lang/String;)V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TranslatableData {
    String getBizId();

    KTranslationBusiness getBizType();

    String getOriginTitle();

    int getTranslateStatus();

    String getTranslateTitle();

    void setTranslateStatus(int i);

    void setTranslateTitle(String str);
}