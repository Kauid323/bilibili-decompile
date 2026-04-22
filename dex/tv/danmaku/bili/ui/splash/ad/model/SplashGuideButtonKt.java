package tv.danmaku.bili.ui.splash.ad.model;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashGuideButton.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u000e\u0010\u0011\u001a\u00020\u0003*\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\"\u0018\u0010\u000b\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0018\u0010\u000f\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006\" \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013*\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"TAG", "", "hitBrandRotateCardStyle", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "getHitBrandRotateCardStyle", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;)Z", "hitShopCardClickStyle", "getHitShopCardClickStyle", "hitShopCardTwistStyle", "getHitShopCardTwistStyle", "hitCountdownStyleV2", "getHitCountdownStyleV2", "hitWebpTwistStyle", "getHitWebpTwistStyle", "hitWebpSlideStyle", "getHitWebpSlideStyle", "isValidSecondPageButtonType", "allResHashSet", "", "getAllResHashSet", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;)Ljava/util/Set;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashGuideButtonKt {
    private static final String TAG = "[Splash]SplashGuideButton";

    public static final boolean getHitBrandRotateCardStyle(SplashGuideButton $this$hitBrandRotateCardStyle) {
        Intrinsics.checkNotNullParameter($this$hitBrandRotateCardStyle, "<this>");
        return $this$hitBrandRotateCardStyle.getInteractStyle() == 12 || $this$hitBrandRotateCardStyle.getInteractStyle() == 13;
    }

    public static final boolean getHitShopCardClickStyle(SplashGuideButton $this$hitShopCardClickStyle) {
        List cardList;
        Iterable $this$any$iv;
        SplashShopCard it;
        Intrinsics.checkNotNullParameter($this$hitShopCardClickStyle, "<this>");
        if ($this$hitShopCardClickStyle.getInteractStyle() == 22 && (cardList = $this$hitShopCardClickStyle.getCards()) != null) {
            if (cardList.size() == 2 || cardList.size() == 3) {
                List $this$any$iv2 = cardList;
                if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                    Iterator<T> it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv = it2.next();
                            SplashShopCard it3 = (SplashShopCard) element$iv;
                            if (BusinessSplashResHelperKt.getMd5ToFile(it3.getImageHash()) == null) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                return $this$any$iv == null;
            }
            return false;
        }
        return false;
    }

    public static final boolean getHitShopCardTwistStyle(SplashGuideButton $this$hitShopCardTwistStyle) {
        List cardList;
        Iterable $this$any$iv;
        SplashShopCard it;
        Intrinsics.checkNotNullParameter($this$hitShopCardTwistStyle, "<this>");
        if ($this$hitShopCardTwistStyle.getInteractStyle() == 21 && (cardList = $this$hitShopCardTwistStyle.getCards()) != null) {
            if (cardList.size() == 2 || cardList.size() == 3) {
                List $this$any$iv2 = cardList;
                if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                    Iterator<T> it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv = it2.next();
                            SplashShopCard it3 = (SplashShopCard) element$iv;
                            if (BusinessSplashResHelperKt.getMd5ToFile(it3.getImageHash()) == null) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                return $this$any$iv == null;
            }
            return false;
        }
        return false;
    }

    public static final boolean getHitCountdownStyleV2(SplashGuideButton $this$hitCountdownStyleV2) {
        Intrinsics.checkNotNullParameter($this$hitCountdownStyleV2, "<this>");
        return $this$hitCountdownStyleV2.getInteractStyle() == 14;
    }

    public static final boolean getHitWebpTwistStyle(SplashGuideButton $this$hitWebpTwistStyle) {
        Intrinsics.checkNotNullParameter($this$hitWebpTwistStyle, "<this>");
        return $this$hitWebpTwistStyle.getInteractStyle() == 17;
    }

    public static final boolean getHitWebpSlideStyle(SplashGuideButton $this$hitWebpSlideStyle) {
        Intrinsics.checkNotNullParameter($this$hitWebpSlideStyle, "<this>");
        return $this$hitWebpSlideStyle.getInteractStyle() == 18;
    }

    public static final boolean isValidSecondPageButtonType(SplashGuideButton $this$isValidSecondPageButtonType) {
        if ($this$isValidSecondPageButtonType == null) {
            return false;
        }
        return $this$isValidSecondPageButtonType.getInteractStyle() == 6 || $this$isValidSecondPageButtonType.getInteractStyle() == 3;
    }

    public static final Set<String> getAllResHashSet(SplashGuideButton $this$allResHashSet) {
        Set sets = new LinkedHashSet();
        if ($this$allResHashSet == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(SetsKt.emptySet());
        }
        String it = $this$allResHashSet.getLogoImageMD5();
        String str = it;
        if (str == null || StringsKt.isBlank(str)) {
            it = null;
        }
        if (it != null) {
            sets.add(it);
        }
        String it2 = $this$allResHashSet.getGuideImageMD5();
        String str2 = it2;
        if (str2 == null || StringsKt.isBlank(str2)) {
            it2 = null;
        }
        if (it2 != null) {
            sets.add(it2);
        }
        String it3 = $this$allResHashSet.getJumpImageMD5();
        String str3 = it3;
        if (str3 == null || StringsKt.isBlank(str3)) {
            it3 = null;
        }
        if (it3 != null) {
            sets.add(it3);
        }
        String it4 = $this$allResHashSet.getSchemaImageMD5();
        String str4 = it4;
        String it5 = str4 == null || StringsKt.isBlank(str4) ? null : it4;
        if (it5 != null) {
            sets.add(it5);
        }
        List $this$fastForEach$iv = $this$allResHashSet.getCards();
        if ($this$fastForEach$iv != null) {
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                SplashShopCard it6 = (SplashShopCard) item$iv;
                String imageHash = it6.getImageHash();
                if (imageHash != null && (StringsKt.isBlank(imageHash) ^ true)) {
                    String imageHash2 = it6.getImageHash();
                    Intrinsics.checkNotNull(imageHash2);
                    sets.add(imageHash2);
                }
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(sets);
    }
}