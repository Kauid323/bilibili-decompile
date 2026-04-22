package kntr.app.ad.domain.click.internal.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.bilibili.droid.RomUtils;
import java.util.Locale;
import kntr.app.ad.domain.click.internal.util.MarketResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketHelper.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\f\u001a\u00020\rJ;\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\r2\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0016H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/MarketHelper;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "isSmartisanRom", RoomRecommendViewModel.EMPTY_CURSOR, "currentBrand", RoomRecommendViewModel.EMPTY_CURSOR, "getCurrentBrand", "()Ljava/lang/String;", "currentBrand$delegate", "Lkotlin/Lazy;", "getSystemMarket", "Lkntr/app/ad/domain/click/internal/util/AbsMarket;", "launchAppDetail", "Lkntr/app/ad/domain/click/internal/util/MarketResponse;", "context", "Landroid/content/Context;", "appPkg", "market", "intentAction", "Lkotlin/Function1;", "Landroid/content/Intent;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "goToMarketIntent", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarketHelper {
    public static final MarketHelper INSTANCE = new MarketHelper();
    private static final Lazy currentBrand$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.click.internal.util.MarketHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            String currentBrand_delegate$lambda$0;
            currentBrand_delegate$lambda$0 = MarketHelper.currentBrand_delegate$lambda$0();
            return currentBrand_delegate$lambda$0;
        }
    });

    private MarketHelper() {
    }

    private final boolean isSmartisanRom() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "BRAND");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual("smartisan", lowerCase)) {
            String str2 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(str2, "MANUFACTURER");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!Intrinsics.areEqual("smartisan", lowerCase2)) {
                return false;
            }
        }
        return true;
    }

    private final String getCurrentBrand() {
        return (String) currentBrand$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currentBrand_delegate$lambda$0() {
        if (RomUtils.isHuaweiRom()) {
            return "HUAWEI";
        }
        if (RomUtils.isHonorRom()) {
            return "HONOR";
        }
        if (RomUtils.isMiuiRom()) {
            return "Xiaomi";
        }
        if (RomUtils.isOppoRom()) {
            return "OPPO";
        }
        if (RomUtils.isOnePlusRom()) {
            return "OnePlus";
        }
        if (RomUtils.isRealmeRom()) {
            return "realme";
        }
        if (RomUtils.isVivoRom()) {
            return "vivo";
        }
        if (RomUtils.isMeizuRom()) {
            return "Meizu";
        }
        if (RomUtils.isSamsungRom()) {
            return "samsung";
        }
        if (RomUtils.isLenovoRom()) {
            return "lenovo";
        }
        if (INSTANCE.isSmartisanRom()) {
            return "smartisan";
        }
        if (RomUtils.isZTERom()) {
            return "zte";
        }
        return null;
    }

    public final AbsMarket getSystemMarket() {
        return MarketHelperKt.access$getSystemMarket(getCurrentBrand());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketResponse launchAppDetail$default(MarketHelper marketHelper, Context context, String str, AbsMarket absMarket, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            absMarket = marketHelper.getSystemMarket();
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: kntr.app.ad.domain.click.internal.util.MarketHelper$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit launchAppDetail$lambda$0;
                    launchAppDetail$lambda$0 = MarketHelper.launchAppDetail$lambda$0((Intent) obj2);
                    return launchAppDetail$lambda$0;
                }
            };
        }
        return marketHelper.launchAppDetail(context, str, absMarket, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchAppDetail$lambda$0(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.setFlags(268468224);
        return Unit.INSTANCE;
    }

    public final MarketResponse launchAppDetail(Context context, String appPkg, AbsMarket market, Function1<? super Intent, Unit> function1) {
        String[] marketPkgs;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appPkg, "appPkg");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(function1, "intentAction");
        String marketUrl = market.marketProtocol(appPkg);
        Intent goToMarketIntent = new Intent("android.intent.action.VIEW", Uri.parse(marketUrl));
        function1.invoke(goToMarketIntent);
        if (!(market.getMarketPkgs().length == 0)) {
            for (String str : market.getMarketPkgs()) {
                MarketHelper marketHelper = INSTANCE;
                goToMarketIntent.setPackage(str);
                Unit unit = Unit.INSTANCE;
                if (marketHelper.launchAppDetail(context, goToMarketIntent)) {
                    return new MarketResponse.Success(marketUrl, str);
                }
            }
        } else if (launchAppDetail(context, goToMarketIntent)) {
            return new MarketResponse.Success(marketUrl, null, 2, null);
        }
        if (market instanceof HONORMarket) {
            return launchAppDetail(context, appPkg, new HUWEIMarket(), function1);
        }
        return new MarketResponse.Failed(marketUrl);
    }

    private final boolean launchAppDetail(Context context, Intent goToMarketIntent) {
        try {
            context.startActivity(goToMarketIntent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}