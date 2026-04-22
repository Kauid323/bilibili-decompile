package kntr.common.photonic.aphro.core;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroSelectOptionLens.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"0\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"*\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\",\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010&0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"*\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010/\u001a\u0004\b\u000b\u00100\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010/\u001a\u0004\b\u000e\u00100\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010/\u001a\u0004\b\u0012\u00100\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00140\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010/\u001a\u0004\b\u0016\u00100\"F\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u0002H-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010/\u001a\u0004\b\u001b\u00100\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010/\u001a\u0004\b\u001e\u00100\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010/\u001a\u0004\b!\u00100\"@\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010/\u001a\u0004\b$\u00100\"B\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010&0\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010/\u001a\u0004\b(\u00100\"@\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020*0\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010/\u001a\u0004\b,\u00100\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t01\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010/\u001a\u0004\b3\u00104\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t01\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010/\u001a\u0004\b6\u00104\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010/\u001a\u0004\b8\u00104\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001401\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010/\u001a\u0004\b:\u00104\"H\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u0002H-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001801\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010/\u001a\u0004\b<\u00104\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010/\u001a\u0004\b>\u00104\"B\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010/\u001a\u0004\b@\u00104\"B\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010/\u001a\u0004\bB\u00104\"D\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010&0\u0001\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010/\u001a\u0004\bD\u00100\"B\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020*01\"\b\b\u0000\u0010-*\u00020.*\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010/\u001a\u0004\bF\u00104\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t01\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010G\u001a\u0004\b\u000b\u0010H\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\t01\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010G\u001a\u0004\b\u000e\u0010H\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010G\u001a\u0004\b\u0012\u0010H\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001401\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010G\u001a\u0004\b\u0016\u0010H\"F\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u0002H-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001801\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010G\u001a\u0004\b\u001b\u0010H\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010G\u001a\u0004\b\u001e\u0010H\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010G\u001a\u0004\b!\u0010H\"@\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010G\u001a\u0004\b$\u0010H\"B\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u00010&0\u0001\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010G\u001a\u0004\b(\u0010I\"@\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020*01\"\b\b\u0000\u0010-*\u00020.*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010G\u001a\u0004\b,\u0010H¨\u0006J"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "Lkntr/common/photonic/aphro/core/AphroSelectOption$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/AphroSelectOption$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/AphroSelectOption$Companion;)Lcom/bilibili/blens/BSimpleLens;", "remainingSelectCount", "", "getRemainingSelectCount$annotations", "getRemainingSelectCount", "maxSelectCount", "getMaxSelectCount$annotations", "getMaxSelectCount", "autoDismiss", "", "getAutoDismiss$annotations", "getAutoDismiss", "galleryLoadConfig", "Lkntr/common/photonic/gallery/GalleryLoadConfig;", "getGalleryLoadConfig$annotations", "getGalleryLoadConfig", "selectableMediaTypes", "", "Lkntr/common/photonic/MimeType;", "getSelectableMediaTypes$annotations", "getSelectableMediaTypes", "showSelections", "getShowSelections$annotations", "getShowSelections", "confirmedOnDismissed", "getConfirmedOnDismissed$annotations", "getConfirmedOnDismissed", "dismissOnConfirm", "getDismissOnConfirm$annotations", "getDismissOnConfirm", "contentSizeLimit", "Lkntr/common/photonic/aphro/core/ContentSizeLimit;", "getContentSizeLimit$annotations", "getContentSizeLimit", "aspectRadioLimit", "Lkntr/common/photonic/aphro/core/AspectRadioLimit;", "getAspectRadioLimit$annotations", "getAspectRadioLimit", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "remainingSelectCountNullable$annotations", "remainingSelectCountNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "maxSelectCountNullable$annotations", "maxSelectCountNullable", "autoDismissNullable$annotations", "autoDismissNullable", "galleryLoadConfigNullable$annotations", "galleryLoadConfigNullable", "selectableMediaTypesNullable$annotations", "selectableMediaTypesNullable", "showSelectionsNullable$annotations", "showSelectionsNullable", "confirmedOnDismissedNullable$annotations", "confirmedOnDismissedNullable", "dismissOnConfirmNullable$annotations", "dismissOnConfirmNullable", "contentSizeLimitNullable$annotations", "contentSizeLimitNullable", "aspectRadioLimitNullable$annotations", "aspectRadioLimitNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroSelectOptionLensKt {
    public static /* synthetic */ void aspectRadioLimitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void autoDismissNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void confirmedOnDismissedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void contentSizeLimitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void dismissOnConfirmNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void galleryLoadConfigNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAspectRadioLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAspectRadioLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAspectRadioLimit$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getAutoDismiss$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAutoDismiss$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAutoDismiss$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getConfirmedOnDismissed$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getConfirmedOnDismissed$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getConfirmedOnDismissed$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getContentSizeLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContentSizeLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentSizeLimit$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getDismissOnConfirm$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDismissOnConfirm$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDismissOnConfirm$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getGalleryLoadConfig$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGalleryLoadConfig$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGalleryLoadConfig$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getMaxSelectCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMaxSelectCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMaxSelectCount$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getRemainingSelectCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRemainingSelectCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRemainingSelectCount$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getSelectableMediaTypes$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelectableMediaTypes$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelectableMediaTypes$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void getShowSelections$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getShowSelections$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getShowSelections$annotations(AphroSelectOption.Companion companion) {
    }

    public static /* synthetic */ void maxSelectCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void remainingSelectCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void selectableMediaTypesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void showSelectionsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroSelectOption, AphroSelectOption> getLens(AphroSelectOption.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, AphroSelectOption>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$1
            public AphroSelectOption get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return it;
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, AphroSelectOption aphroSelectOption2) {
                AphroSelectOption it = aphroSelectOption2;
                return it;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super AphroSelectOption, ? extends AphroSelectOption> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                return (AphroSelectOption) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Integer> getRemainingSelectCount(AphroSelectOption.Companion $this$remainingSelectCount) {
        Intrinsics.checkNotNullParameter($this$remainingSelectCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Integer>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$2
            public Integer get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Integer.valueOf(it.getRemainingSelectCount());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Integer num) {
                AphroSelectOption copy;
                int remainingSelectCount = num.intValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : remainingSelectCount, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Integer, ? extends Integer> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                int remainingSelectCount = ((Number) function1.invoke(Integer.valueOf(it.getRemainingSelectCount()))).intValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : remainingSelectCount, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Integer> getMaxSelectCount(AphroSelectOption.Companion $this$maxSelectCount) {
        Intrinsics.checkNotNullParameter($this$maxSelectCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Integer>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$3
            public Integer get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Integer.valueOf(it.getMaxSelectCount());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Integer num) {
                AphroSelectOption copy;
                int maxSelectCount = num.intValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : maxSelectCount, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Integer, ? extends Integer> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                int maxSelectCount = ((Number) function1.invoke(Integer.valueOf(it.getMaxSelectCount()))).intValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : maxSelectCount, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Boolean> getAutoDismiss(AphroSelectOption.Companion $this$autoDismiss) {
        Intrinsics.checkNotNullParameter($this$autoDismiss, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$4
            public Boolean get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Boolean.valueOf(it.getAutoDismiss());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Boolean bool) {
                AphroSelectOption copy;
                boolean autoDismiss = bool.booleanValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : autoDismiss, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                boolean autoDismiss = ((Boolean) function1.invoke(Boolean.valueOf(it.getAutoDismiss()))).booleanValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : autoDismiss, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, GalleryLoadConfig> getGalleryLoadConfig(AphroSelectOption.Companion $this$galleryLoadConfig) {
        Intrinsics.checkNotNullParameter($this$galleryLoadConfig, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, GalleryLoadConfig>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$5
            public GalleryLoadConfig get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return it.getGalleryLoadConfig();
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, GalleryLoadConfig galleryLoadConfig) {
                AphroSelectOption copy;
                GalleryLoadConfig galleryLoadConfig2 = galleryLoadConfig;
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : galleryLoadConfig2, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super GalleryLoadConfig, ? extends GalleryLoadConfig> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                GalleryLoadConfig galleryLoadConfig = (GalleryLoadConfig) function1.invoke(it.getGalleryLoadConfig());
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : galleryLoadConfig, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<AphroSelectOption, List<MimeType>> getSelectableMediaTypes(AphroSelectOption.Companion $this$selectableMediaTypes) {
        Intrinsics.checkNotNullParameter($this$selectableMediaTypes, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, List<? extends MimeType>>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$6
            public List<? extends MimeType> get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return it.getSelectableMediaTypes();
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, List<? extends MimeType> list) {
                AphroSelectOption copy;
                List<? extends MimeType> selectableMediaTypes = list;
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : selectableMediaTypes, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super List<? extends MimeType>, ? extends List<? extends MimeType>> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                List selectableMediaTypes = (List) function1.invoke(it.getSelectableMediaTypes());
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : selectableMediaTypes, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Boolean> getShowSelections(AphroSelectOption.Companion $this$showSelections) {
        Intrinsics.checkNotNullParameter($this$showSelections, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$7
            public Boolean get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Boolean.valueOf(it.getShowSelections());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Boolean bool) {
                AphroSelectOption copy;
                boolean showSelections = bool.booleanValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : showSelections, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                boolean showSelections = ((Boolean) function1.invoke(Boolean.valueOf(it.getShowSelections()))).booleanValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : showSelections, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Boolean> getConfirmedOnDismissed(AphroSelectOption.Companion $this$confirmedOnDismissed) {
        Intrinsics.checkNotNullParameter($this$confirmedOnDismissed, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$8
            public Boolean get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Boolean.valueOf(it.getConfirmedOnDismissed());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Boolean bool) {
                AphroSelectOption copy;
                boolean confirmedOnDismissed = bool.booleanValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : confirmedOnDismissed, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                boolean confirmedOnDismissed = ((Boolean) function1.invoke(Boolean.valueOf(it.getConfirmedOnDismissed()))).booleanValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : confirmedOnDismissed, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, Boolean> getDismissOnConfirm(AphroSelectOption.Companion $this$dismissOnConfirm) {
        Intrinsics.checkNotNullParameter($this$dismissOnConfirm, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$9
            public Boolean get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return Boolean.valueOf(it.getDismissOnConfirm());
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, Boolean bool) {
                AphroSelectOption copy;
                boolean dismissOnConfirm = bool.booleanValue();
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : dismissOnConfirm, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                boolean dismissOnConfirm = ((Boolean) function1.invoke(Boolean.valueOf(it.getDismissOnConfirm()))).booleanValue();
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : dismissOnConfirm, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, ContentSizeLimit> getContentSizeLimit(AphroSelectOption.Companion $this$contentSizeLimit) {
        Intrinsics.checkNotNullParameter($this$contentSizeLimit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, ContentSizeLimit>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$10
            public ContentSizeLimit get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return it.getContentSizeLimit();
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, ContentSizeLimit contentSizeLimit) {
                AphroSelectOption copy;
                ContentSizeLimit contentSizeLimit2 = contentSizeLimit;
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : contentSizeLimit2, (r22 & 512) != 0 ? it.aspectRadioLimit : null);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super ContentSizeLimit, ? extends ContentSizeLimit> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                ContentSizeLimit contentSizeLimit = (ContentSizeLimit) function1.invoke(it.getContentSizeLimit());
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : contentSizeLimit, (r22 & 512) != 0 ? it2.aspectRadioLimit : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroSelectOption, AspectRadioLimit> getAspectRadioLimit(AphroSelectOption.Companion $this$aspectRadioLimit) {
        Intrinsics.checkNotNullParameter($this$aspectRadioLimit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroSelectOption, AspectRadioLimit>() { // from class: kntr.common.photonic.aphro.core.AphroSelectOptionLensKt$special$$inlined$invoke$11
            public AspectRadioLimit get(AphroSelectOption aphroSelectOption) {
                AphroSelectOption it = aphroSelectOption;
                return it.getAspectRadioLimit();
            }

            public AphroSelectOption set(AphroSelectOption aphroSelectOption, AspectRadioLimit aspectRadioLimit) {
                AphroSelectOption copy;
                AspectRadioLimit aspectRadioLimit2 = aspectRadioLimit;
                AphroSelectOption it = aphroSelectOption;
                copy = it.copy((r22 & 1) != 0 ? it.remainingSelectCount : 0, (r22 & 2) != 0 ? it.maxSelectCount : 0, (r22 & 4) != 0 ? it.autoDismiss : false, (r22 & 8) != 0 ? it.galleryLoadConfig : null, (r22 & 16) != 0 ? it.selectableMediaTypes : null, (r22 & 32) != 0 ? it.showSelections : false, (r22 & 64) != 0 ? it.confirmedOnDismissed : false, (r22 & 128) != 0 ? it.dismissOnConfirm : false, (r22 & 256) != 0 ? it.contentSizeLimit : null, (r22 & 512) != 0 ? it.aspectRadioLimit : aspectRadioLimit2);
                return copy;
            }

            public AphroSelectOption modify(AphroSelectOption aphroSelectOption, Function1<? super AspectRadioLimit, ? extends AspectRadioLimit> function1) {
                AphroSelectOption copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroSelectOption it = aphroSelectOption;
                AspectRadioLimit aspectRadioLimit = (AspectRadioLimit) function1.invoke(it.getAspectRadioLimit());
                AphroSelectOption it2 = aphroSelectOption;
                copy = it2.copy((r22 & 1) != 0 ? it2.remainingSelectCount : 0, (r22 & 2) != 0 ? it2.maxSelectCount : 0, (r22 & 4) != 0 ? it2.autoDismiss : false, (r22 & 8) != 0 ? it2.galleryLoadConfig : null, (r22 & 16) != 0 ? it2.selectableMediaTypes : null, (r22 & 32) != 0 ? it2.showSelections : false, (r22 & 64) != 0 ? it2.confirmedOnDismissed : false, (r22 & 128) != 0 ? it2.dismissOnConfirm : false, (r22 & 256) != 0 ? it2.contentSizeLimit : null, (r22 & 512) != 0 ? it2.aspectRadioLimit : aspectRadioLimit);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, Integer> getRemainingSelectCount(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRemainingSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getMaxSelectCount(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMaxSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getAutoDismiss(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAutoDismiss(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, GalleryLoadConfig> getGalleryLoadConfig(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGalleryLoadConfig(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, List<MimeType>> getSelectableMediaTypes(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSelectableMediaTypes(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getShowSelections(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getShowSelections(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getConfirmedOnDismissed(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getConfirmedOnDismissed(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getDismissOnConfirm(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getDismissOnConfirm(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, ContentSizeLimit> getContentSizeLimit(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getContentSizeLimit(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, AspectRadioLimit> getAspectRadioLimit(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAspectRadioLimit(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Integer> remainingSelectCountNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRemainingSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Integer> maxSelectCountNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMaxSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> autoDismissNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAutoDismiss(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, GalleryLoadConfig> galleryLoadConfigNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGalleryLoadConfig(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, List<MimeType>> selectableMediaTypesNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSelectableMediaTypes(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> showSelectionsNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getShowSelections(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> confirmedOnDismissedNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getConfirmedOnDismissed(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> dismissOnConfirmNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getDismissOnConfirm(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, ContentSizeLimit> contentSizeLimitNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getContentSizeLimit(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, AspectRadioLimit> aspectRadioLimitNullable(BSimpleLens<T, AphroSelectOption> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAspectRadioLimit(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getRemainingSelectCount(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRemainingSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getMaxSelectCount(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMaxSelectCount(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getAutoDismiss(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAutoDismiss(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, GalleryLoadConfig> getGalleryLoadConfig(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGalleryLoadConfig(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, List<MimeType>> getSelectableMediaTypes(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSelectableMediaTypes(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getShowSelections(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getShowSelections(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getConfirmedOnDismissed(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getConfirmedOnDismissed(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getDismissOnConfirm(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getDismissOnConfirm(AphroSelectOption.Companion));
    }

    public static final <T> BSimpleLens<T, ContentSizeLimit> getContentSizeLimit(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getContentSizeLimit(AphroSelectOption.Companion));
    }

    public static final <T> BNullableLens<T, AspectRadioLimit> getAspectRadioLimit(BNullableLens<T, AphroSelectOption> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAspectRadioLimit(AphroSelectOption.Companion));
    }
}