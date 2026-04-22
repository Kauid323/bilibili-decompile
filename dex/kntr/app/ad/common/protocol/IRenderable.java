package kntr.app.ad.common.protocol;

import java.util.List;
import kntr.app.ad.common.model.AdAndroidGameInfo;
import kntr.app.ad.common.model.AdAppDownloadStyle;
import kntr.app.ad.common.model.AdBulletin;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdCalendarInfo;
import kntr.app.ad.common.model.AdChronosEffect;
import kntr.app.ad.common.model.AdComboClickParams;
import kntr.app.ad.common.model.AdCover;
import kntr.app.ad.common.model.AdCoverBadge;
import kntr.app.ad.common.model.AdCoverTopLeftBadge;
import kntr.app.ad.common.model.AdCustomFeedbackPanel;
import kntr.app.ad.common.model.AdEasterEggParams;
import kntr.app.ad.common.model.AdFeedbackPanel;
import kntr.app.ad.common.model.AdFlySubCardModule;
import kntr.app.ad.common.model.AdFormInfo;
import kntr.app.ad.common.model.AdForwardReply;
import kntr.app.ad.common.model.AdGameInfo;
import kntr.app.ad.common.model.AdGameRank;
import kntr.app.ad.common.model.AdGift;
import kntr.app.ad.common.model.AdGood;
import kntr.app.ad.common.model.AdHeartBox;
import kntr.app.ad.common.model.AdIMaxLandingPage;
import kntr.app.ad.common.model.AdLotteryCard;
import kntr.app.ad.common.model.AdPasteboardInfo;
import kntr.app.ad.common.model.AdProductCarouselData;
import kntr.app.ad.common.model.AdProductComment;
import kntr.app.ad.common.model.AdProductInfo;
import kntr.app.ad.common.model.AdQualityInfo;
import kntr.app.ad.common.model.AdRcmdReasonStyle;
import kntr.app.ad.common.model.AdShopWindow;
import kntr.app.ad.common.model.AdStoryGoods;
import kntr.app.ad.common.model.AdStoryStyleSelection;
import kntr.app.ad.common.model.AdSubCardModule;
import kntr.app.ad.common.model.AdTagStyle;
import kntr.app.ad.common.model.AdTextBean;
import kntr.app.ad.common.model.AdThumbsUpSubCardModule;
import kntr.app.ad.common.model.AdTreasureHuntBall;
import kntr.app.ad.common.model.AdVer;
import kntr.app.ad.common.model.AdVideo;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.common.model.AdXYZ;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IRenderable.kt */
@Metadata(d1 = {"\u0000þ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0014\u0010 \u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u001c\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u0004\u0018\u00010(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u0014\u0010-\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u0014\u0010/\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\rR\u0014\u00101\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u001c\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010&R\u0014\u00105\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\rR\u0014\u00107\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\rR\u0014\u00109\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\rR\u0012\u0010;\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0005R\u0012\u0010=\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0005R\u0012\u0010?\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u0014\u0010A\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\rR\u0012\u0010C\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0005R\u0014\u0010E\u001a\u0004\u0018\u00010FX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u0004\u0018\u00010JX¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u0004\u0018\u00010JX¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010LR\u0014\u0010O\u001a\u0004\u0018\u00010PX¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\rR\u0014\u0010U\u001a\u0004\u0018\u00010VX¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\rR\u0012\u0010[\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0005R\u0014\u0010]\u001a\u0004\u0018\u00010^X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010a\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\rR\u0014\u0010c\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\rR\u0014\u0010e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\rR\u0014\u0010g\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\rR\u0014\u0010i\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\rR\u0014\u0010k\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\rR\u0012\u0010m\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0014\u0010o\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\rR\u0014\u0010q\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010\rR\u0012\u0010s\u001a\u00020tX¦\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010\rR\u001c\u0010y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010z\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010&R\u0014\u0010|\u001a\u0004\u0018\u00010}X¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\rR\u001e\u0010\u0082\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010&R\u0014\u0010\u0084\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u0005R\u0016\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\rR\u0014\u0010\u0088\u0001\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010vR\u0016\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\rR\u0016\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010\rR\u0014\u0010\u008e\u0001\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010vR\u0016\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\rR\u0014\u0010\u0092\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\u0005R\u0014\u0010\u0094\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u0005R\u0018\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0016\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\rR\u0018\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X¦\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010¬\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010\rR\u001e\u0010®\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010&R\u001e\u0010°\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010&R\u0016\u0010²\u0001\u001a\u00030³\u0001X¦\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u0016\u0010¶\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010\rR\u0016\u0010¸\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010\rR\u0018\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001R\u0018\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0014\u0010Â\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010\u0005R\u0014\u0010Ä\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010\u0005R\u0018\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0014\u0010Î\u0001\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010vR\u0016\u0010Ð\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010\rR\u0016\u0010Ò\u0001\u001a\u0004\u0018\u00010PX¦\u0004¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010RR\u001e\u0010Ô\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\bÕ\u0001\u0010&R\u0018\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X¦\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0018\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÜ\u0001\u0010Ý\u0001R\u0016\u0010Þ\u0001\u001a\u0004\u0018\u00010PX¦\u0004¢\u0006\u0007\u001a\u0005\bß\u0001\u0010RR\u0018\u0010à\u0001\u001a\u0005\u0018\u00010á\u0001X¦\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u001f\u0010ä\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010å\u0001\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010&R\u0018\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001X¦\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u0018\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u0001X¦\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0018\u0010ï\u0001\u001a\u0005\u0018\u00010ì\u0001X¦\u0004¢\u0006\b\u001a\u0006\bð\u0001\u0010î\u0001R\u0016\u0010ñ\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bò\u0001\u0010\rR\u0014\u0010ó\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bô\u0001\u0010\u0005R\u0014\u0010õ\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bö\u0001\u0010\u0005R\u0016\u0010÷\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bø\u0001\u0010\rR\u001f\u0010ù\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010ú\u0001\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\bû\u0001\u0010&R\u0016\u0010ü\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bý\u0001\u0010\rR\u0016\u0010þ\u0001\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bÿ\u0001\u0010\rR\u0016\u0010\u0080\u0002\u001a\u00030³\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010µ\u0001R\u0018\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0016\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0002\u0010\rR\u0016\u0010\u0088\u0002\u001a\u00030³\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0089\u0002\u0010µ\u0001R\u0014\u0010\u008a\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0002\u0010\u0005R\u0014\u0010\u008c\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0002\u0010\u0005R\u0018\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0018\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002R\u0014\u0010\u0096\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0002\u0010\u0005R\u0016\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0002\u0010\rR\u0016\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0002\u0010\rR\u001f\u0010\u009c\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u009d\u0002\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0002\u0010&R\u0014\u0010\u009f\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b \u0002\u0010\u0005R\u0014\u0010¡\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¢\u0002\u0010\u0005R\u0014\u0010£\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¤\u0002\u0010\u0005R\u0014\u0010¥\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¦\u0002\u0010\u0005R\u0018\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002X¦\u0004¢\u0006\b\u001a\u0006\b©\u0002\u0010ª\u0002R\u0018\u0010«\u0002\u001a\u0005\u0018\u00010¬\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u0018\u0010¯\u0002\u001a\u0005\u0018\u00010°\u0002X¦\u0004¢\u0006\b\u001a\u0006\b±\u0002\u0010²\u0002R\u0014\u0010³\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b´\u0002\u0010\u0005R\u0016\u0010µ\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b¶\u0002\u0010\rR\u0014\u0010·\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¸\u0002\u0010\u0005R\u0014\u0010¹\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bº\u0002\u0010\u0005R\u0016\u0010»\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b¼\u0002\u0010\rR\u0016\u0010½\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\b¾\u0002\u0010\rR\u0014\u0010¿\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÀ\u0002\u0010\u0005R\u0016\u0010Á\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bÂ\u0002\u0010\rR\u0014\u0010Ã\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0002\u0010\u0005R\u0018\u0010Å\u0002\u001a\u0005\u0018\u00010Æ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R\u0014\u0010É\u0002\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\bÊ\u0002\u0010vR\u0016\u0010Ë\u0002\u001a\u00030Ì\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÍ\u0002\u0010Î\u0002R\u0016\u0010Ï\u0002\u001a\u00030³\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÐ\u0002\u0010µ\u0001R\u0014\u0010Ñ\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÒ\u0002\u0010\u0005R\u0014\u0010Ó\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÔ\u0002\u0010\u0005R\u0014\u0010Õ\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bÖ\u0002\u0010\u0005R\u0014\u0010×\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bØ\u0002\u0010\u0005R\u0014\u0010Ù\u0002\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\bÚ\u0002\u0010vR\u0018\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÝ\u0002\u0010Þ\u0002R\u0018\u0010ß\u0002\u001a\u0005\u0018\u00010à\u0002X¦\u0004¢\u0006\b\u001a\u0006\bá\u0002\u0010â\u0002R\u0016\u0010ã\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bä\u0002\u0010\rR\u0014\u0010å\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bæ\u0002\u0010\u0005R\u0014\u0010ç\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bè\u0002\u0010\u0005R\u0016\u0010é\u0002\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0007\u001a\u0005\bê\u0002\u0010\rR\u0018\u0010ë\u0002\u001a\u0005\u0018\u00010ì\u0002X¦\u0004¢\u0006\b\u001a\u0006\bí\u0002\u0010î\u0002R\u0018\u0010ï\u0002\u001a\u0005\u0018\u00010ð\u0002X¦\u0004¢\u0006\b\u001a\u0006\bñ\u0002\u0010ò\u0002R\u0014\u0010ó\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bô\u0002\u0010\u0005R\u0018\u0010õ\u0002\u001a\u0005\u0018\u00010ö\u0002X¦\u0004¢\u0006\b\u001a\u0006\b÷\u0002\u0010ø\u0002R\u0018\u0010ù\u0002\u001a\u0005\u0018\u00010ú\u0002X¦\u0004¢\u0006\b\u001a\u0006\bû\u0002\u0010ü\u0002R\u0018\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÿ\u0002\u0010\u0080\u0003R\u001f\u0010\u0081\u0003\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u0003\u0018\u00010#X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0003\u0010&R\u0014\u0010\u0084\u0003\u001a\u00020tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0003\u0010v¨\u0006\u0086\u0003À\u0006\u0003"}, d2 = {"Lkntr/app/ad/common/protocol/IRenderable;", RoomRecommendViewModel.EMPTY_CURSOR, "enableTagPosition", RoomRecommendViewModel.EMPTY_CURSOR, "getEnableTagPosition", "()I", "enableSearchWeaken", "getEnableSearchWeaken", "cardType", "getCardType", "title", RoomRecommendViewModel.EMPTY_CURSOR, "getTitle", "()Ljava/lang/String;", "jumpUrl", "getJumpUrl", "liveBottomIconJumpUrl", "getLiveBottomIconJumpUrl", "callUpUrl", "getCallUpUrl", "desc", "getDesc", "descType", "getDescType", "oriPrice", "getOriPrice", "curPrice", "getCurPrice", "extraDesc", "getExtraDesc", "rank", "getRank", "hotScore", "getHotScore", "covers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdCover;", "getCovers", "()Ljava/util/List;", "button", "Lkntr/app/ad/common/model/AdButton;", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "longDesc", "getLongDesc", "adverLogo", "getAdverLogo", "adverName", "getAdverName", "adverPageUrl", "getAdverPageUrl", "videoBarrage", "getVideoBarrage", "adTag", "getAdTag", "shortTitle", "getShortTitle", "danmuTitle", "getDanmuTitle", "danmuLife", "getDanmuLife", "danmuBegin", "getDanmuBegin", "danmuHeight", "getDanmuHeight", "danmuColor", "getDanmuColor", "foldTime", "getFoldTime", "good", "Lkntr/app/ad/common/model/AdGood;", "getGood", "()Lkntr/app/ad/common/model/AdGood;", "adTagStyle", "Lkntr/app/ad/common/model/AdTagStyle;", "getAdTagStyle", "()Lkntr/app/ad/common/model/AdTagStyle;", "adTagStyleFullScreen", "getAdTagStyleFullScreen", "video", "Lkntr/app/ad/common/model/AdVideo;", "getVideo", "()Lkntr/app/ad/common/model/AdVideo;", "danmuPanelUrl", "getDanmuPanelUrl", "feedbackPanel", "Lkntr/app/ad/common/model/AdFeedbackPanel;", "getFeedbackPanel", "()Lkntr/app/ad/common/model/AdFeedbackPanel;", "danmuIcon", "getDanmuIcon", "danmuWidth", "getDanmuWidth", "iMaxPageInfo", "Lkntr/app/ad/common/model/AdIMaxLandingPage;", "getIMaxPageInfo", "()Lkntr/app/ad/common/model/AdIMaxLandingPage;", "priceDesc", "getPriceDesc", "goodsCurPrice", "getGoodsCurPrice", "priceSymbol", "getPriceSymbol", "goodsOriPrice", "getGoodsOriPrice", "liveStreamerName", "getLiveStreamerName", "liveStreamerFace", "getLiveStreamerFace", "liveRoomPopularity", "getLiveRoomPopularity", "liveRoomArea", "getLiveRoomArea", "liveRoomTitle", "getLiveRoomTitle", "liveTagShow", RoomRecommendViewModel.EMPTY_CURSOR, "getLiveTagShow", "()Z", "duration", "getDuration", "qualityInfos", "Lkntr/app/ad/common/model/AdQualityInfo;", "getQualityInfos", "adVer", "Lkntr/app/ad/common/model/AdVer;", "getAdVer", "()Lkntr/app/ad/common/model/AdVer;", "dynamicText", "getDynamicText", "chooseBtnList", "getChooseBtnList", "gradeLevel", "getGradeLevel", "bgImg", "getBgImg", "extremeTeamStatus", "getExtremeTeamStatus", "extremeTeamIcon", "getExtremeTeamIcon", "nickname", "getNickname", "hasTransition", "getHasTransition", "transitionParams", "getTransitionParams", "underPlayerInteractionStyle", "getUnderPlayerInteractionStyle", "jumpInteractionStyle", "getJumpInteractionStyle", "coverBadge", "Lkntr/app/ad/common/model/AdCoverBadge;", "getCoverBadge", "()Lkntr/app/ad/common/model/AdCoverBadge;", "iMaxPageInfoV2", "getIMaxPageInfoV2", "subCardModule", "Lkntr/app/ad/common/model/AdSubCardModule;", "getSubCardModule", "()Lkntr/app/ad/common/model/AdSubCardModule;", "flySubCardModule", "Lkntr/app/ad/common/model/AdFlySubCardModule;", "getFlySubCardModule", "()Lkntr/app/ad/common/model/AdFlySubCardModule;", "thumbsUpSubCardModule", "Lkntr/app/ad/common/model/AdThumbsUpSubCardModule;", "getThumbsUpSubCardModule", "()Lkntr/app/ad/common/model/AdThumbsUpSubCardModule;", "treasureHuntBall", "Lkntr/app/ad/common/model/AdTreasureHuntBall;", "getTreasureHuntBall", "()Lkntr/app/ad/common/model/AdTreasureHuntBall;", "gameRating", "getGameRating", "tags", "getTags", "gameTags", "getGameTags", "liveBookingPopulationThreshold", RoomRecommendViewModel.EMPTY_CURSOR, "getLiveBookingPopulationThreshold", "()J", "immerseBg", "getImmerseBg", "immerseBgNight", "getImmerseBgNight", "bulletin", "Lkntr/app/ad/common/model/AdBulletin;", "getBulletin", "()Lkntr/app/ad/common/model/AdBulletin;", "gift", "Lkntr/app/ad/common/model/AdGift;", "getGift", "()Lkntr/app/ad/common/model/AdGift;", "starLevel", "getStarLevel", "oriMarkHidden", "getOriMarkHidden", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "getWxProgramInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "adGameDetailInfo", "Lkntr/app/ad/common/model/AdAndroidGameInfo;", "getAdGameDetailInfo", "()Lkntr/app/ad/common/model/AdAndroidGameInfo;", "useMultiCover", "getUseMultiCover", "productSource", "getProductSource", "ipVideo", "getIpVideo", "labels", "getLabels", "shopWindow", "Lkntr/app/ad/common/model/AdShopWindow;", "getShopWindow", "()Lkntr/app/ad/common/model/AdShopWindow;", "rcmdReasonStyle", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "getRcmdReasonStyle", "()Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "easterEggVideo", "getEasterEggVideo", "xyz", "Lkntr/app/ad/common/model/AdXYZ;", "getXyz", "()Lkntr/app/ad/common/model/AdXYZ;", "customFeedbackPanel", "Lkntr/app/ad/common/model/AdCustomFeedbackPanel;", "getCustomFeedbackPanel", "forwardReply", "Lkntr/app/ad/common/model/AdForwardReply;", "getForwardReply", "()Lkntr/app/ad/common/model/AdForwardReply;", "storyGoods", "Lkntr/app/ad/common/model/AdStoryGoods;", "getStoryGoods", "()Lkntr/app/ad/common/model/AdStoryGoods;", "storyAnchor", "getStoryAnchor", "schemaName", "getSchemaName", "yellowCartPanelVersion", "getYellowCartPanelVersion", "yellowCartPanelPullUp", "getYellowCartPanelPullUp", "volumeDesc", "getVolumeDesc", "productInfos", "Lkntr/app/ad/common/model/AdProductInfo;", "getProductInfos", "couponDesc", "getCouponDesc", "couponPrice", "getCouponPrice", "goodsItemId", "getGoodsItemId", "easterEggParams", "Lkntr/app/ad/common/model/AdEasterEggParams;", "getEasterEggParams", "()Lkntr/app/ad/common/model/AdEasterEggParams;", "avContent", "getAvContent", "storyCartDelayTime", "getStoryCartDelayTime", "commentInteractionStyle", "getCommentInteractionStyle", "commentUseAdGame", "getCommentUseAdGame", "formInfo", "Lkntr/app/ad/common/model/AdFormInfo;", "getFormInfo", "()Lkntr/app/ad/common/model/AdFormInfo;", "pasteboardInfo", "Lkntr/app/ad/common/model/AdPasteboardInfo;", "getPasteboardInfo", "()Lkntr/app/ad/common/model/AdPasteboardInfo;", "animInEnable", "getAnimInEnable", "productViewedText", "getProductViewedText", "productSourceShort", "getProductSourceShort", "productComments", "Lkntr/app/ad/common/model/AdProductComment;", "getProductComments", "downloadArea", "getDownloadArea", "cardStyle", "getCardStyle", "underPlayerCardStyle", "getUnderPlayerCardStyle", "gradeDenominator", "getGradeDenominator", "coverTopLeftBadge", "Lkntr/app/ad/common/model/AdCoverTopLeftBadge;", "getCoverTopLeftBadge", "()Lkntr/app/ad/common/model/AdCoverTopLeftBadge;", "gameInfo", "Lkntr/app/ad/common/model/AdGameInfo;", "getGameInfo", "()Lkntr/app/ad/common/model/AdGameInfo;", "gameRank", "Lkntr/app/ad/common/model/AdGameRank;", "getGameRank", "()Lkntr/app/ad/common/model/AdGameRank;", "storyVideoFinishTime", "getStoryVideoFinishTime", "paidMessage", "getPaidMessage", "goodsPanelShow", "getGoodsPanelShow", "showPopWindow", "getShowPopWindow", "lotteryText", "getLotteryText", "warmUpText", "getWarmUpText", "livePageType", "getLivePageType", "extraParams", "getExtraParams", "storyInteractionStyle", "getStoryInteractionStyle", "calendarInfo", "Lkntr/app/ad/common/model/AdCalendarInfo;", "getCalendarInfo", "()Lkntr/app/ad/common/model/AdCalendarInfo;", "liveAutoPlay", "getLiveAutoPlay", "storyFloatShowRate", RoomRecommendViewModel.EMPTY_CURSOR, "getStoryFloatShowRate", "()F", "storyFloatShowPeriod", "getStoryFloatShowPeriod", "originalStyleLevel", "getOriginalStyleLevel", "halfPanelInteractionStyle", "getHalfPanelInteractionStyle", "halfPanelContentType", "getHalfPanelContentType", "searchShowAdButton", "getSearchShowAdButton", "liveCardShow", "getLiveCardShow", "lotteryCard", "Lkntr/app/ad/common/model/AdLotteryCard;", "getLotteryCard", "()Lkntr/app/ad/common/model/AdLotteryCard;", "comboClickParams", "Lkntr/app/ad/common/model/AdComboClickParams;", "getComboClickParams", "()Lkntr/app/ad/common/model/AdComboClickParams;", "outerId", "getOuterId", "goodsItemSource", "getGoodsItemSource", "closedLoopItem", "getClosedLoopItem", "storyItemStaticInfo", "getStoryItemStaticInfo", "chronosEffect", "Lkntr/app/ad/common/model/AdChronosEffect;", "getChronosEffect", "()Lkntr/app/ad/common/model/AdChronosEffect;", "productCarousel", "Lkntr/app/ad/common/model/AdProductCarouselData;", "getProductCarousel", "()Lkntr/app/ad/common/model/AdProductCarouselData;", "playpageCardStyle", "getPlaypageCardStyle", "appDownloadStyle", "Lkntr/app/ad/common/model/AdAppDownloadStyle;", "getAppDownloadStyle", "()Lkntr/app/ad/common/model/AdAppDownloadStyle;", "heartBox", "Lkntr/app/ad/common/model/AdHeartBox;", "getHeartBox", "()Lkntr/app/ad/common/model/AdHeartBox;", "storyStyleSelection", "Lkntr/app/ad/common/model/AdStoryStyleSelection;", "getStoryStyleSelection", "()Lkntr/app/ad/common/model/AdStoryStyleSelection;", "descList", "Lkntr/app/ad/common/model/AdTextBean;", "getDescList", "useEngineAuthor", "getUseEngineAuthor", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRenderable {
    AdAndroidGameInfo getAdGameDetailInfo();

    String getAdTag();

    AdTagStyle getAdTagStyle();

    AdTagStyle getAdTagStyleFullScreen();

    AdVer getAdVer();

    String getAdverLogo();

    String getAdverName();

    String getAdverPageUrl();

    int getAnimInEnable();

    AdAppDownloadStyle getAppDownloadStyle();

    String getAvContent();

    String getBgImg();

    AdBulletin getBulletin();

    AdButton getButton();

    AdCalendarInfo getCalendarInfo();

    String getCallUpUrl();

    int getCardStyle();

    int getCardType();

    List<AdButton> getChooseBtnList();

    AdChronosEffect getChronosEffect();

    int getClosedLoopItem();

    AdComboClickParams getComboClickParams();

    int getCommentInteractionStyle();

    int getCommentUseAdGame();

    String getCouponDesc();

    String getCouponPrice();

    AdCoverBadge getCoverBadge();

    AdCoverTopLeftBadge getCoverTopLeftBadge();

    List<AdCover> getCovers();

    String getCurPrice();

    List<AdCustomFeedbackPanel> getCustomFeedbackPanel();

    int getDanmuBegin();

    String getDanmuColor();

    int getDanmuHeight();

    String getDanmuIcon();

    int getDanmuLife();

    String getDanmuPanelUrl();

    String getDanmuTitle();

    int getDanmuWidth();

    String getDesc();

    List<AdTextBean> getDescList();

    int getDescType();

    int getDownloadArea();

    String getDuration();

    String getDynamicText();

    AdEasterEggParams getEasterEggParams();

    AdVideo getEasterEggVideo();

    int getEnableSearchWeaken();

    int getEnableTagPosition();

    String getExtraDesc();

    String getExtraParams();

    String getExtremeTeamIcon();

    boolean getExtremeTeamStatus();

    AdFeedbackPanel getFeedbackPanel();

    AdFlySubCardModule getFlySubCardModule();

    int getFoldTime();

    AdFormInfo getFormInfo();

    AdForwardReply getForwardReply();

    AdGameInfo getGameInfo();

    AdGameRank getGameRank();

    String getGameRating();

    List<String> getGameTags();

    AdGift getGift();

    AdGood getGood();

    String getGoodsCurPrice();

    long getGoodsItemId();

    int getGoodsItemSource();

    String getGoodsOriPrice();

    int getGoodsPanelShow();

    int getGradeDenominator();

    int getGradeLevel();

    int getHalfPanelContentType();

    int getHalfPanelInteractionStyle();

    boolean getHasTransition();

    AdHeartBox getHeartBox();

    String getHotScore();

    AdIMaxLandingPage getIMaxPageInfo();

    String getIMaxPageInfoV2();

    String getImmerseBg();

    String getImmerseBgNight();

    AdVideo getIpVideo();

    int getJumpInteractionStyle();

    String getJumpUrl();

    List<String> getLabels();

    boolean getLiveAutoPlay();

    long getLiveBookingPopulationThreshold();

    String getLiveBottomIconJumpUrl();

    boolean getLiveCardShow();

    int getLivePageType();

    String getLiveRoomArea();

    int getLiveRoomPopularity();

    String getLiveRoomTitle();

    String getLiveStreamerFace();

    String getLiveStreamerName();

    boolean getLiveTagShow();

    String getLongDesc();

    AdLotteryCard getLotteryCard();

    String getLotteryText();

    String getNickname();

    int getOriMarkHidden();

    String getOriPrice();

    int getOriginalStyleLevel();

    String getOuterId();

    String getPaidMessage();

    AdPasteboardInfo getPasteboardInfo();

    int getPlaypageCardStyle();

    String getPriceDesc();

    String getPriceSymbol();

    AdProductCarouselData getProductCarousel();

    List<AdProductComment> getProductComments();

    List<AdProductInfo> getProductInfos();

    String getProductSource();

    String getProductSourceShort();

    String getProductViewedText();

    List<AdQualityInfo> getQualityInfos();

    String getRank();

    AdRcmdReasonStyle getRcmdReasonStyle();

    String getSchemaName();

    int getSearchShowAdButton();

    AdShopWindow getShopWindow();

    String getShortTitle();

    int getShowPopWindow();

    int getStarLevel();

    AdStoryGoods getStoryAnchor();

    long getStoryCartDelayTime();

    long getStoryFloatShowPeriod();

    float getStoryFloatShowRate();

    AdStoryGoods getStoryGoods();

    int getStoryInteractionStyle();

    String getStoryItemStaticInfo();

    AdStoryStyleSelection getStoryStyleSelection();

    int getStoryVideoFinishTime();

    AdSubCardModule getSubCardModule();

    List<String> getTags();

    AdThumbsUpSubCardModule getThumbsUpSubCardModule();

    String getTitle();

    String getTransitionParams();

    AdTreasureHuntBall getTreasureHuntBall();

    int getUnderPlayerCardStyle();

    int getUnderPlayerInteractionStyle();

    boolean getUseEngineAuthor();

    boolean getUseMultiCover();

    AdVideo getVideo();

    List<String> getVideoBarrage();

    String getVolumeDesc();

    String getWarmUpText();

    AdWxProgramInfo getWxProgramInfo();

    AdXYZ getXyz();

    int getYellowCartPanelPullUp();

    int getYellowCartPanelVersion();
}