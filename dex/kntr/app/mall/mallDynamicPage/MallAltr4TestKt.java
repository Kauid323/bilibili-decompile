package kntr.app.mall.mallDynamicPage;

import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MallAltr4Test.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"antlrTestExpressions", RoomRecommendViewModel.EMPTY_CURSOR, "vm", "Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MallAltr4TestKt {
    public static final void antlrTestExpressions(MallDynamicPageViewModel vm) {
        Intrinsics.checkNotNullParameter(vm, "vm");
        Map dataObject = MapsKt.mapOf(new Pair[]{TuplesKt.to("user", MapsKt.mapOf(new Pair[]{TuplesKt.to("name", "Alice"), TuplesKt.to("age", 25), TuplesKt.to("addresses", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(TuplesKt.to("city", "New York")), MapsKt.mapOf(TuplesKt.to("city", "Los Angeles"))}))})), TuplesKt.to("numbers", CollectionsKt.listOf(new Integer[]{1, 2, 3, 4, 5})), TuplesKt.to("message", "Hello, World!"), TuplesKt.to("value", -3), TuplesKt.to("threshold", 10)});
        List<Pair> testCases = CollectionsKt.listOf(new Pair[]{TuplesKt.to("3 + 5", 8), TuplesKt.to("10 - 4", 6), TuplesKt.to("2 * 3", 6), TuplesKt.to("8 / 2", 4), TuplesKt.to("9 % 2", 1), TuplesKt.to("true && false", false), TuplesKt.to("true || false", true), TuplesKt.to("!true", false), TuplesKt.to("5 > 3", true), TuplesKt.to("5 < 3", false), TuplesKt.to("5 >= 5", true), TuplesKt.to("5 <= 4", false), TuplesKt.to("5 == 5", true), TuplesKt.to("5 != 3", true), TuplesKt.to("abs(-5)", 5), TuplesKt.to("ceil(4.3)", 5), TuplesKt.to("floor(4.8)", 4), TuplesKt.to("round(4.5)", 5), TuplesKt.to("len(`Hello`)", 5), TuplesKt.to("count(data(`numbers`))", 5), TuplesKt.to("indexOf(`Hello`, `e`)", 1), TuplesKt.to("substring(`Hello`, 1, 3)", "el"), TuplesKt.to("includes(data(`numbers`), 3)", true), TuplesKt.to("data(`user.name`)", "Alice"), TuplesKt.to("data(`user.age`)", 25), TuplesKt.to("data(`user.addresses.0.city`)", "New York"), TuplesKt.to("data(`numbers.2`)", 3), TuplesKt.to("abs(data(`value`)) + 3", 6), TuplesKt.to("len(data(`message`)) > 10", true), TuplesKt.to("(3 + 5) * 2", 16)});
        for (Pair pair : testCases) {
            String expression = (String) pair.component1();
            Object expected = pair.component2();
            Object result = vm.getValueBridge().invoke("execAntlr", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", expression), TuplesKt.to("data", dataObject)}));
            System.out.println((Object) ("wbw---mallAntlrUtTest-----Expression: " + expression + ", Result: " + result + ", Expected: " + expected));
        }
    }
}