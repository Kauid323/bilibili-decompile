package bili.resource.relations;

import com.bilibili.crow.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\bì\u0001\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007R\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007R\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007R\u001b\u0010^\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\u0007R\u001b\u0010a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\u0007R\u001b\u0010d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0007R\u001b\u0010g\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\t\u001a\u0004\bh\u0010\u0007R\u001b\u0010j\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\t\u001a\u0004\bk\u0010\u0007R\u001b\u0010m\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\t\u001a\u0004\bn\u0010\u0007R\u001b\u0010p\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010\t\u001a\u0004\bq\u0010\u0007R\u001b\u0010s\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\t\u001a\u0004\bt\u0010\u0007R\u001b\u0010v\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\t\u001a\u0004\bw\u0010\u0007R\u001b\u0010y\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\t\u001a\u0004\bz\u0010\u0007R\u001b\u0010|\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\t\u001a\u0004\b}\u0010\u0007R\u001d\u0010\u007f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\t\u001a\u0005\b\u0080\u0001\u0010\u0007R\u001e\u0010\u0082\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\t\u001a\u0005\b\u0083\u0001\u0010\u0007R\u001e\u0010\u0085\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\t\u001a\u0005\b\u0086\u0001\u0010\u0007R\u001e\u0010\u0088\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\t\u001a\u0005\b\u0089\u0001\u0010\u0007R\u001e\u0010\u008b\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\t\u001a\u0005\b\u008c\u0001\u0010\u0007R\u001e\u0010\u008e\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\t\u001a\u0005\b\u008f\u0001\u0010\u0007R\u001e\u0010\u0091\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\t\u001a\u0005\b\u0092\u0001\u0010\u0007R\u001e\u0010\u0094\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\t\u001a\u0005\b\u0095\u0001\u0010\u0007R\u001e\u0010\u0097\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010\t\u001a\u0005\b\u0098\u0001\u0010\u0007R\u001e\u0010\u009a\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\t\u001a\u0005\b\u009b\u0001\u0010\u0007R\u001e\u0010\u009d\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010\t\u001a\u0005\b\u009e\u0001\u0010\u0007R\u001e\u0010 \u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¢\u0001\u0010\t\u001a\u0005\b¡\u0001\u0010\u0007R\u001e\u0010£\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010\t\u001a\u0005\b¤\u0001\u0010\u0007R\u001e\u0010¦\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\t\u001a\u0005\b§\u0001\u0010\u0007R\u001e\u0010©\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010\t\u001a\u0005\bª\u0001\u0010\u0007R\u001e\u0010¬\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010\t\u001a\u0005\b\u00ad\u0001\u0010\u0007R\u001e\u0010¯\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b±\u0001\u0010\t\u001a\u0005\b°\u0001\u0010\u0007R\u001e\u0010²\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\t\u001a\u0005\b³\u0001\u0010\u0007R\u001e\u0010µ\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b·\u0001\u0010\t\u001a\u0005\b¶\u0001\u0010\u0007R\u001e\u0010¸\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bº\u0001\u0010\t\u001a\u0005\b¹\u0001\u0010\u0007R\u001e\u0010»\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b½\u0001\u0010\t\u001a\u0005\b¼\u0001\u0010\u0007R\u001e\u0010¾\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\t\u001a\u0005\b¿\u0001\u0010\u0007R\u001e\u0010Á\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÃ\u0001\u0010\t\u001a\u0005\bÂ\u0001\u0010\u0007R\u001e\u0010Ä\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\t\u001a\u0005\bÅ\u0001\u0010\u0007R\u001e\u0010Ç\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÉ\u0001\u0010\t\u001a\u0005\bÈ\u0001\u0010\u0007R\u001e\u0010Ê\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÌ\u0001\u0010\t\u001a\u0005\bË\u0001\u0010\u0007R\u001e\u0010Í\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\t\u001a\u0005\bÎ\u0001\u0010\u0007R\u001e\u0010Ð\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÒ\u0001\u0010\t\u001a\u0005\bÑ\u0001\u0010\u0007R\u001e\u0010Ó\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÕ\u0001\u0010\t\u001a\u0005\bÔ\u0001\u0010\u0007R\u001e\u0010Ö\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bØ\u0001\u0010\t\u001a\u0005\b×\u0001\u0010\u0007R\u001e\u0010Ù\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\t\u001a\u0005\bÚ\u0001\u0010\u0007R\u001e\u0010Ü\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\t\u001a\u0005\bÝ\u0001\u0010\u0007R\u001e\u0010ß\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bá\u0001\u0010\t\u001a\u0005\bà\u0001\u0010\u0007R\u001e\u0010â\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bä\u0001\u0010\t\u001a\u0005\bã\u0001\u0010\u0007R\u001e\u0010å\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bç\u0001\u0010\t\u001a\u0005\bæ\u0001\u0010\u0007R\u001e\u0010è\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bê\u0001\u0010\t\u001a\u0005\bé\u0001\u0010\u0007R\u001e\u0010ë\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bí\u0001\u0010\t\u001a\u0005\bì\u0001\u0010\u0007R\u001e\u0010î\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bð\u0001\u0010\t\u001a\u0005\bï\u0001\u0010\u0007¨\u0006ñ\u0001"}, d2 = {"Lbili/resource/relations/CommonMainString0;", BuildConfig.FLAVOR, "<init>", "()V", "relations_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "getRelations_global_string_1", "()Lorg/jetbrains/compose/resources/StringResource;", "relations_global_string_1$delegate", "Lkotlin/Lazy;", "relations_global_string_10", "getRelations_global_string_10", "relations_global_string_10$delegate", "relations_global_string_11", "getRelations_global_string_11", "relations_global_string_11$delegate", "relations_global_string_12", "getRelations_global_string_12", "relations_global_string_12$delegate", "relations_global_string_13", "getRelations_global_string_13", "relations_global_string_13$delegate", "relations_global_string_14", "getRelations_global_string_14", "relations_global_string_14$delegate", "relations_global_string_15", "getRelations_global_string_15", "relations_global_string_15$delegate", "relations_global_string_16", "getRelations_global_string_16", "relations_global_string_16$delegate", "relations_global_string_17", "getRelations_global_string_17", "relations_global_string_17$delegate", "relations_global_string_18", "getRelations_global_string_18", "relations_global_string_18$delegate", "relations_global_string_19", "getRelations_global_string_19", "relations_global_string_19$delegate", "relations_global_string_2", "getRelations_global_string_2", "relations_global_string_2$delegate", "relations_global_string_20", "getRelations_global_string_20", "relations_global_string_20$delegate", "relations_global_string_22", "getRelations_global_string_22", "relations_global_string_22$delegate", "relations_global_string_23", "getRelations_global_string_23", "relations_global_string_23$delegate", "relations_global_string_24", "getRelations_global_string_24", "relations_global_string_24$delegate", "relations_global_string_25", "getRelations_global_string_25", "relations_global_string_25$delegate", "relations_global_string_26", "getRelations_global_string_26", "relations_global_string_26$delegate", "relations_global_string_27", "getRelations_global_string_27", "relations_global_string_27$delegate", "relations_global_string_28", "getRelations_global_string_28", "relations_global_string_28$delegate", "relations_global_string_29", "getRelations_global_string_29", "relations_global_string_29$delegate", "relations_global_string_3", "getRelations_global_string_3", "relations_global_string_3$delegate", "relations_global_string_31", "getRelations_global_string_31", "relations_global_string_31$delegate", "relations_global_string_32", "getRelations_global_string_32", "relations_global_string_32$delegate", "relations_global_string_33", "getRelations_global_string_33", "relations_global_string_33$delegate", "relations_global_string_34", "getRelations_global_string_34", "relations_global_string_34$delegate", "relations_global_string_35", "getRelations_global_string_35", "relations_global_string_35$delegate", "relations_global_string_36", "getRelations_global_string_36", "relations_global_string_36$delegate", "relations_global_string_37", "getRelations_global_string_37", "relations_global_string_37$delegate", "relations_global_string_38", "getRelations_global_string_38", "relations_global_string_38$delegate", "relations_global_string_39", "getRelations_global_string_39", "relations_global_string_39$delegate", "relations_global_string_4", "getRelations_global_string_4", "relations_global_string_4$delegate", "relations_global_string_40", "getRelations_global_string_40", "relations_global_string_40$delegate", "relations_global_string_41", "getRelations_global_string_41", "relations_global_string_41$delegate", "relations_global_string_42", "getRelations_global_string_42", "relations_global_string_42$delegate", "relations_global_string_43", "getRelations_global_string_43", "relations_global_string_43$delegate", "relations_global_string_44", "getRelations_global_string_44", "relations_global_string_44$delegate", "relations_global_string_45", "getRelations_global_string_45", "relations_global_string_45$delegate", "relations_global_string_46", "getRelations_global_string_46", "relations_global_string_46$delegate", "relations_global_string_47", "getRelations_global_string_47", "relations_global_string_47$delegate", "relations_global_string_48", "getRelations_global_string_48", "relations_global_string_48$delegate", "relations_global_string_49", "getRelations_global_string_49", "relations_global_string_49$delegate", "relations_global_string_5", "getRelations_global_string_5", "relations_global_string_5$delegate", "relations_global_string_50", "getRelations_global_string_50", "relations_global_string_50$delegate", "relations_global_string_51", "getRelations_global_string_51", "relations_global_string_51$delegate", "relations_global_string_52", "getRelations_global_string_52", "relations_global_string_52$delegate", "relations_global_string_53", "getRelations_global_string_53", "relations_global_string_53$delegate", "relations_global_string_54", "getRelations_global_string_54", "relations_global_string_54$delegate", "relations_global_string_55", "getRelations_global_string_55", "relations_global_string_55$delegate", "relations_global_string_56", "getRelations_global_string_56", "relations_global_string_56$delegate", "relations_global_string_57", "getRelations_global_string_57", "relations_global_string_57$delegate", "relations_global_string_58", "getRelations_global_string_58", "relations_global_string_58$delegate", "relations_global_string_59", "getRelations_global_string_59", "relations_global_string_59$delegate", "relations_global_string_6", "getRelations_global_string_6", "relations_global_string_6$delegate", "relations_global_string_60", "getRelations_global_string_60", "relations_global_string_60$delegate", "relations_global_string_61", "getRelations_global_string_61", "relations_global_string_61$delegate", "relations_global_string_62", "getRelations_global_string_62", "relations_global_string_62$delegate", "relations_global_string_63", "getRelations_global_string_63", "relations_global_string_63$delegate", "relations_global_string_64", "getRelations_global_string_64", "relations_global_string_64$delegate", "relations_global_string_65", "getRelations_global_string_65", "relations_global_string_65$delegate", "relations_global_string_66", "getRelations_global_string_66", "relations_global_string_66$delegate", "relations_global_string_67", "getRelations_global_string_67", "relations_global_string_67$delegate", "relations_global_string_68", "getRelations_global_string_68", "relations_global_string_68$delegate", "relations_global_string_69", "getRelations_global_string_69", "relations_global_string_69$delegate", "relations_global_string_7", "getRelations_global_string_7", "relations_global_string_7$delegate", "relations_global_string_70", "getRelations_global_string_70", "relations_global_string_70$delegate", "relations_global_string_71", "getRelations_global_string_71", "relations_global_string_71$delegate", "relations_global_string_72", "getRelations_global_string_72", "relations_global_string_72$delegate", "relations_global_string_73", "getRelations_global_string_73", "relations_global_string_73$delegate", "relations_global_string_74", "getRelations_global_string_74", "relations_global_string_74$delegate", "relations_global_string_75", "getRelations_global_string_75", "relations_global_string_75$delegate", "relations_global_string_76", "getRelations_global_string_76", "relations_global_string_76$delegate", "relations_global_string_77", "getRelations_global_string_77", "relations_global_string_77$delegate", "relations_global_string_78", "getRelations_global_string_78", "relations_global_string_78$delegate", "relations_global_string_8", "getRelations_global_string_8", "relations_global_string_8$delegate", "relations_global_string_80", "getRelations_global_string_80", "relations_global_string_80$delegate", "relations_global_string_82", "getRelations_global_string_82", "relations_global_string_82$delegate", "relations_global_string_9", "getRelations_global_string_9", "relations_global_string_9$delegate", "relations_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy relations_global_string_1$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource relations_global_string_1_delegate$lambda$0;
            relations_global_string_1_delegate$lambda$0 = CommonMainString0.relations_global_string_1_delegate$lambda$0();
            return relations_global_string_1_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_10$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda2
        public final Object invoke() {
            StringResource relations_global_string_10_delegate$lambda$0;
            relations_global_string_10_delegate$lambda$0 = CommonMainString0.relations_global_string_10_delegate$lambda$0();
            return relations_global_string_10_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_11$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda14
        public final Object invoke() {
            StringResource relations_global_string_11_delegate$lambda$0;
            relations_global_string_11_delegate$lambda$0 = CommonMainString0.relations_global_string_11_delegate$lambda$0();
            return relations_global_string_11_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_12$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda26
        public final Object invoke() {
            StringResource relations_global_string_12_delegate$lambda$0;
            relations_global_string_12_delegate$lambda$0 = CommonMainString0.relations_global_string_12_delegate$lambda$0();
            return relations_global_string_12_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_13$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda38
        public final Object invoke() {
            StringResource relations_global_string_13_delegate$lambda$0;
            relations_global_string_13_delegate$lambda$0 = CommonMainString0.relations_global_string_13_delegate$lambda$0();
            return relations_global_string_13_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_14$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda50
        public final Object invoke() {
            StringResource relations_global_string_14_delegate$lambda$0;
            relations_global_string_14_delegate$lambda$0 = CommonMainString0.relations_global_string_14_delegate$lambda$0();
            return relations_global_string_14_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_15$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda62
        public final Object invoke() {
            StringResource relations_global_string_15_delegate$lambda$0;
            relations_global_string_15_delegate$lambda$0 = CommonMainString0.relations_global_string_15_delegate$lambda$0();
            return relations_global_string_15_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_16$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda72
        public final Object invoke() {
            StringResource relations_global_string_16_delegate$lambda$0;
            relations_global_string_16_delegate$lambda$0 = CommonMainString0.relations_global_string_16_delegate$lambda$0();
            return relations_global_string_16_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_17$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda73
        public final Object invoke() {
            StringResource relations_global_string_17_delegate$lambda$0;
            relations_global_string_17_delegate$lambda$0 = CommonMainString0.relations_global_string_17_delegate$lambda$0();
            return relations_global_string_17_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_18$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda74
        public final Object invoke() {
            StringResource relations_global_string_18_delegate$lambda$0;
            relations_global_string_18_delegate$lambda$0 = CommonMainString0.relations_global_string_18_delegate$lambda$0();
            return relations_global_string_18_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_19$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda11
        public final Object invoke() {
            StringResource relations_global_string_19_delegate$lambda$0;
            relations_global_string_19_delegate$lambda$0 = CommonMainString0.relations_global_string_19_delegate$lambda$0();
            return relations_global_string_19_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_2$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda22
        public final Object invoke() {
            StringResource relations_global_string_2_delegate$lambda$0;
            relations_global_string_2_delegate$lambda$0 = CommonMainString0.relations_global_string_2_delegate$lambda$0();
            return relations_global_string_2_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_20$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda33
        public final Object invoke() {
            StringResource relations_global_string_20_delegate$lambda$0;
            relations_global_string_20_delegate$lambda$0 = CommonMainString0.relations_global_string_20_delegate$lambda$0();
            return relations_global_string_20_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_22$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda44
        public final Object invoke() {
            StringResource relations_global_string_22_delegate$lambda$0;
            relations_global_string_22_delegate$lambda$0 = CommonMainString0.relations_global_string_22_delegate$lambda$0();
            return relations_global_string_22_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_23$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda55
        public final Object invoke() {
            StringResource relations_global_string_23_delegate$lambda$0;
            relations_global_string_23_delegate$lambda$0 = CommonMainString0.relations_global_string_23_delegate$lambda$0();
            return relations_global_string_23_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_24$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda66
        public final Object invoke() {
            StringResource relations_global_string_24_delegate$lambda$0;
            relations_global_string_24_delegate$lambda$0 = CommonMainString0.relations_global_string_24_delegate$lambda$0();
            return relations_global_string_24_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_25$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda75
        public final Object invoke() {
            StringResource relations_global_string_25_delegate$lambda$0;
            relations_global_string_25_delegate$lambda$0 = CommonMainString0.relations_global_string_25_delegate$lambda$0();
            return relations_global_string_25_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_26$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda76
        public final Object invoke() {
            StringResource relations_global_string_26_delegate$lambda$0;
            relations_global_string_26_delegate$lambda$0 = CommonMainString0.relations_global_string_26_delegate$lambda$0();
            return relations_global_string_26_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_27$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda77
        public final Object invoke() {
            StringResource relations_global_string_27_delegate$lambda$0;
            relations_global_string_27_delegate$lambda$0 = CommonMainString0.relations_global_string_27_delegate$lambda$0();
            return relations_global_string_27_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_28$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource relations_global_string_28_delegate$lambda$0;
            relations_global_string_28_delegate$lambda$0 = CommonMainString0.relations_global_string_28_delegate$lambda$0();
            return relations_global_string_28_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_29$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda3
        public final Object invoke() {
            StringResource relations_global_string_29_delegate$lambda$0;
            relations_global_string_29_delegate$lambda$0 = CommonMainString0.relations_global_string_29_delegate$lambda$0();
            return relations_global_string_29_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_3$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda4
        public final Object invoke() {
            StringResource relations_global_string_3_delegate$lambda$0;
            relations_global_string_3_delegate$lambda$0 = CommonMainString0.relations_global_string_3_delegate$lambda$0();
            return relations_global_string_3_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_31$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda5
        public final Object invoke() {
            StringResource relations_global_string_31_delegate$lambda$0;
            relations_global_string_31_delegate$lambda$0 = CommonMainString0.relations_global_string_31_delegate$lambda$0();
            return relations_global_string_31_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_32$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda6
        public final Object invoke() {
            StringResource relations_global_string_32_delegate$lambda$0;
            relations_global_string_32_delegate$lambda$0 = CommonMainString0.relations_global_string_32_delegate$lambda$0();
            return relations_global_string_32_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_33$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda7
        public final Object invoke() {
            StringResource relations_global_string_33_delegate$lambda$0;
            relations_global_string_33_delegate$lambda$0 = CommonMainString0.relations_global_string_33_delegate$lambda$0();
            return relations_global_string_33_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_34$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda8
        public final Object invoke() {
            StringResource relations_global_string_34_delegate$lambda$0;
            relations_global_string_34_delegate$lambda$0 = CommonMainString0.relations_global_string_34_delegate$lambda$0();
            return relations_global_string_34_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_35$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda9
        public final Object invoke() {
            StringResource relations_global_string_35_delegate$lambda$0;
            relations_global_string_35_delegate$lambda$0 = CommonMainString0.relations_global_string_35_delegate$lambda$0();
            return relations_global_string_35_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_36$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda10
        public final Object invoke() {
            StringResource relations_global_string_36_delegate$lambda$0;
            relations_global_string_36_delegate$lambda$0 = CommonMainString0.relations_global_string_36_delegate$lambda$0();
            return relations_global_string_36_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_37$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda12
        public final Object invoke() {
            StringResource relations_global_string_37_delegate$lambda$0;
            relations_global_string_37_delegate$lambda$0 = CommonMainString0.relations_global_string_37_delegate$lambda$0();
            return relations_global_string_37_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_38$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda13
        public final Object invoke() {
            StringResource relations_global_string_38_delegate$lambda$0;
            relations_global_string_38_delegate$lambda$0 = CommonMainString0.relations_global_string_38_delegate$lambda$0();
            return relations_global_string_38_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_39$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda15
        public final Object invoke() {
            StringResource relations_global_string_39_delegate$lambda$0;
            relations_global_string_39_delegate$lambda$0 = CommonMainString0.relations_global_string_39_delegate$lambda$0();
            return relations_global_string_39_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_4$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda16
        public final Object invoke() {
            StringResource relations_global_string_4_delegate$lambda$0;
            relations_global_string_4_delegate$lambda$0 = CommonMainString0.relations_global_string_4_delegate$lambda$0();
            return relations_global_string_4_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_40$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda17
        public final Object invoke() {
            StringResource relations_global_string_40_delegate$lambda$0;
            relations_global_string_40_delegate$lambda$0 = CommonMainString0.relations_global_string_40_delegate$lambda$0();
            return relations_global_string_40_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_41$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda18
        public final Object invoke() {
            StringResource relations_global_string_41_delegate$lambda$0;
            relations_global_string_41_delegate$lambda$0 = CommonMainString0.relations_global_string_41_delegate$lambda$0();
            return relations_global_string_41_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_42$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda19
        public final Object invoke() {
            StringResource relations_global_string_42_delegate$lambda$0;
            relations_global_string_42_delegate$lambda$0 = CommonMainString0.relations_global_string_42_delegate$lambda$0();
            return relations_global_string_42_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_43$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda20
        public final Object invoke() {
            StringResource relations_global_string_43_delegate$lambda$0;
            relations_global_string_43_delegate$lambda$0 = CommonMainString0.relations_global_string_43_delegate$lambda$0();
            return relations_global_string_43_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_44$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda21
        public final Object invoke() {
            StringResource relations_global_string_44_delegate$lambda$0;
            relations_global_string_44_delegate$lambda$0 = CommonMainString0.relations_global_string_44_delegate$lambda$0();
            return relations_global_string_44_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_45$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda23
        public final Object invoke() {
            StringResource relations_global_string_45_delegate$lambda$0;
            relations_global_string_45_delegate$lambda$0 = CommonMainString0.relations_global_string_45_delegate$lambda$0();
            return relations_global_string_45_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_46$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda24
        public final Object invoke() {
            StringResource relations_global_string_46_delegate$lambda$0;
            relations_global_string_46_delegate$lambda$0 = CommonMainString0.relations_global_string_46_delegate$lambda$0();
            return relations_global_string_46_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_47$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda25
        public final Object invoke() {
            StringResource relations_global_string_47_delegate$lambda$0;
            relations_global_string_47_delegate$lambda$0 = CommonMainString0.relations_global_string_47_delegate$lambda$0();
            return relations_global_string_47_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_48$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda27
        public final Object invoke() {
            StringResource relations_global_string_48_delegate$lambda$0;
            relations_global_string_48_delegate$lambda$0 = CommonMainString0.relations_global_string_48_delegate$lambda$0();
            return relations_global_string_48_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_49$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda28
        public final Object invoke() {
            StringResource relations_global_string_49_delegate$lambda$0;
            relations_global_string_49_delegate$lambda$0 = CommonMainString0.relations_global_string_49_delegate$lambda$0();
            return relations_global_string_49_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_5$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda29
        public final Object invoke() {
            StringResource relations_global_string_5_delegate$lambda$0;
            relations_global_string_5_delegate$lambda$0 = CommonMainString0.relations_global_string_5_delegate$lambda$0();
            return relations_global_string_5_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_50$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda30
        public final Object invoke() {
            StringResource relations_global_string_50_delegate$lambda$0;
            relations_global_string_50_delegate$lambda$0 = CommonMainString0.relations_global_string_50_delegate$lambda$0();
            return relations_global_string_50_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_51$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda31
        public final Object invoke() {
            StringResource relations_global_string_51_delegate$lambda$0;
            relations_global_string_51_delegate$lambda$0 = CommonMainString0.relations_global_string_51_delegate$lambda$0();
            return relations_global_string_51_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_52$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda32
        public final Object invoke() {
            StringResource relations_global_string_52_delegate$lambda$0;
            relations_global_string_52_delegate$lambda$0 = CommonMainString0.relations_global_string_52_delegate$lambda$0();
            return relations_global_string_52_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_53$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda34
        public final Object invoke() {
            StringResource relations_global_string_53_delegate$lambda$0;
            relations_global_string_53_delegate$lambda$0 = CommonMainString0.relations_global_string_53_delegate$lambda$0();
            return relations_global_string_53_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_54$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda35
        public final Object invoke() {
            StringResource relations_global_string_54_delegate$lambda$0;
            relations_global_string_54_delegate$lambda$0 = CommonMainString0.relations_global_string_54_delegate$lambda$0();
            return relations_global_string_54_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_55$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda36
        public final Object invoke() {
            StringResource relations_global_string_55_delegate$lambda$0;
            relations_global_string_55_delegate$lambda$0 = CommonMainString0.relations_global_string_55_delegate$lambda$0();
            return relations_global_string_55_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_56$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda37
        public final Object invoke() {
            StringResource relations_global_string_56_delegate$lambda$0;
            relations_global_string_56_delegate$lambda$0 = CommonMainString0.relations_global_string_56_delegate$lambda$0();
            return relations_global_string_56_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_57$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda39
        public final Object invoke() {
            StringResource relations_global_string_57_delegate$lambda$0;
            relations_global_string_57_delegate$lambda$0 = CommonMainString0.relations_global_string_57_delegate$lambda$0();
            return relations_global_string_57_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_58$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda40
        public final Object invoke() {
            StringResource relations_global_string_58_delegate$lambda$0;
            relations_global_string_58_delegate$lambda$0 = CommonMainString0.relations_global_string_58_delegate$lambda$0();
            return relations_global_string_58_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_59$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda41
        public final Object invoke() {
            StringResource relations_global_string_59_delegate$lambda$0;
            relations_global_string_59_delegate$lambda$0 = CommonMainString0.relations_global_string_59_delegate$lambda$0();
            return relations_global_string_59_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_6$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda42
        public final Object invoke() {
            StringResource relations_global_string_6_delegate$lambda$0;
            relations_global_string_6_delegate$lambda$0 = CommonMainString0.relations_global_string_6_delegate$lambda$0();
            return relations_global_string_6_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_60$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda43
        public final Object invoke() {
            StringResource relations_global_string_60_delegate$lambda$0;
            relations_global_string_60_delegate$lambda$0 = CommonMainString0.relations_global_string_60_delegate$lambda$0();
            return relations_global_string_60_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_61$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda45
        public final Object invoke() {
            StringResource relations_global_string_61_delegate$lambda$0;
            relations_global_string_61_delegate$lambda$0 = CommonMainString0.relations_global_string_61_delegate$lambda$0();
            return relations_global_string_61_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_62$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda46
        public final Object invoke() {
            StringResource relations_global_string_62_delegate$lambda$0;
            relations_global_string_62_delegate$lambda$0 = CommonMainString0.relations_global_string_62_delegate$lambda$0();
            return relations_global_string_62_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_63$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda47
        public final Object invoke() {
            StringResource relations_global_string_63_delegate$lambda$0;
            relations_global_string_63_delegate$lambda$0 = CommonMainString0.relations_global_string_63_delegate$lambda$0();
            return relations_global_string_63_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_64$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda48
        public final Object invoke() {
            StringResource relations_global_string_64_delegate$lambda$0;
            relations_global_string_64_delegate$lambda$0 = CommonMainString0.relations_global_string_64_delegate$lambda$0();
            return relations_global_string_64_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_65$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda49
        public final Object invoke() {
            StringResource relations_global_string_65_delegate$lambda$0;
            relations_global_string_65_delegate$lambda$0 = CommonMainString0.relations_global_string_65_delegate$lambda$0();
            return relations_global_string_65_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_66$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda51
        public final Object invoke() {
            StringResource relations_global_string_66_delegate$lambda$0;
            relations_global_string_66_delegate$lambda$0 = CommonMainString0.relations_global_string_66_delegate$lambda$0();
            return relations_global_string_66_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_67$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda52
        public final Object invoke() {
            StringResource relations_global_string_67_delegate$lambda$0;
            relations_global_string_67_delegate$lambda$0 = CommonMainString0.relations_global_string_67_delegate$lambda$0();
            return relations_global_string_67_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_68$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda53
        public final Object invoke() {
            StringResource relations_global_string_68_delegate$lambda$0;
            relations_global_string_68_delegate$lambda$0 = CommonMainString0.relations_global_string_68_delegate$lambda$0();
            return relations_global_string_68_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_69$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda54
        public final Object invoke() {
            StringResource relations_global_string_69_delegate$lambda$0;
            relations_global_string_69_delegate$lambda$0 = CommonMainString0.relations_global_string_69_delegate$lambda$0();
            return relations_global_string_69_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_7$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda56
        public final Object invoke() {
            StringResource relations_global_string_7_delegate$lambda$0;
            relations_global_string_7_delegate$lambda$0 = CommonMainString0.relations_global_string_7_delegate$lambda$0();
            return relations_global_string_7_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_70$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda57
        public final Object invoke() {
            StringResource relations_global_string_70_delegate$lambda$0;
            relations_global_string_70_delegate$lambda$0 = CommonMainString0.relations_global_string_70_delegate$lambda$0();
            return relations_global_string_70_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_71$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda58
        public final Object invoke() {
            StringResource relations_global_string_71_delegate$lambda$0;
            relations_global_string_71_delegate$lambda$0 = CommonMainString0.relations_global_string_71_delegate$lambda$0();
            return relations_global_string_71_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_72$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda59
        public final Object invoke() {
            StringResource relations_global_string_72_delegate$lambda$0;
            relations_global_string_72_delegate$lambda$0 = CommonMainString0.relations_global_string_72_delegate$lambda$0();
            return relations_global_string_72_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_73$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda60
        public final Object invoke() {
            StringResource relations_global_string_73_delegate$lambda$0;
            relations_global_string_73_delegate$lambda$0 = CommonMainString0.relations_global_string_73_delegate$lambda$0();
            return relations_global_string_73_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_74$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda61
        public final Object invoke() {
            StringResource relations_global_string_74_delegate$lambda$0;
            relations_global_string_74_delegate$lambda$0 = CommonMainString0.relations_global_string_74_delegate$lambda$0();
            return relations_global_string_74_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_75$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda63
        public final Object invoke() {
            StringResource relations_global_string_75_delegate$lambda$0;
            relations_global_string_75_delegate$lambda$0 = CommonMainString0.relations_global_string_75_delegate$lambda$0();
            return relations_global_string_75_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_76$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda64
        public final Object invoke() {
            StringResource relations_global_string_76_delegate$lambda$0;
            relations_global_string_76_delegate$lambda$0 = CommonMainString0.relations_global_string_76_delegate$lambda$0();
            return relations_global_string_76_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_77$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda65
        public final Object invoke() {
            StringResource relations_global_string_77_delegate$lambda$0;
            relations_global_string_77_delegate$lambda$0 = CommonMainString0.relations_global_string_77_delegate$lambda$0();
            return relations_global_string_77_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_78$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda67
        public final Object invoke() {
            StringResource relations_global_string_78_delegate$lambda$0;
            relations_global_string_78_delegate$lambda$0 = CommonMainString0.relations_global_string_78_delegate$lambda$0();
            return relations_global_string_78_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_8$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda68
        public final Object invoke() {
            StringResource relations_global_string_8_delegate$lambda$0;
            relations_global_string_8_delegate$lambda$0 = CommonMainString0.relations_global_string_8_delegate$lambda$0();
            return relations_global_string_8_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_80$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda69
        public final Object invoke() {
            StringResource relations_global_string_80_delegate$lambda$0;
            relations_global_string_80_delegate$lambda$0 = CommonMainString0.relations_global_string_80_delegate$lambda$0();
            return relations_global_string_80_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_82$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda70
        public final Object invoke() {
            StringResource relations_global_string_82_delegate$lambda$0;
            relations_global_string_82_delegate$lambda$0 = CommonMainString0.relations_global_string_82_delegate$lambda$0();
            return relations_global_string_82_delegate$lambda$0;
        }
    });
    private static final Lazy relations_global_string_9$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.relations.CommonMainString0$$ExternalSyntheticLambda71
        public final Object invoke() {
            StringResource relations_global_string_9_delegate$lambda$0;
            relations_global_string_9_delegate$lambda$0 = CommonMainString0.relations_global_string_9_delegate$lambda$0();
            return relations_global_string_9_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_1_delegate$lambda$0() {
        StringResource init_relations_global_string_1;
        init_relations_global_string_1 = String0_commonMainKt.init_relations_global_string_1();
        return init_relations_global_string_1;
    }

    public final StringResource getRelations_global_string_1() {
        return (StringResource) relations_global_string_1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_10_delegate$lambda$0() {
        StringResource init_relations_global_string_10;
        init_relations_global_string_10 = String0_commonMainKt.init_relations_global_string_10();
        return init_relations_global_string_10;
    }

    public final StringResource getRelations_global_string_10() {
        return (StringResource) relations_global_string_10$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_11_delegate$lambda$0() {
        StringResource init_relations_global_string_11;
        init_relations_global_string_11 = String0_commonMainKt.init_relations_global_string_11();
        return init_relations_global_string_11;
    }

    public final StringResource getRelations_global_string_11() {
        return (StringResource) relations_global_string_11$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_12_delegate$lambda$0() {
        StringResource init_relations_global_string_12;
        init_relations_global_string_12 = String0_commonMainKt.init_relations_global_string_12();
        return init_relations_global_string_12;
    }

    public final StringResource getRelations_global_string_12() {
        return (StringResource) relations_global_string_12$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_13_delegate$lambda$0() {
        StringResource init_relations_global_string_13;
        init_relations_global_string_13 = String0_commonMainKt.init_relations_global_string_13();
        return init_relations_global_string_13;
    }

    public final StringResource getRelations_global_string_13() {
        return (StringResource) relations_global_string_13$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_14_delegate$lambda$0() {
        StringResource init_relations_global_string_14;
        init_relations_global_string_14 = String0_commonMainKt.init_relations_global_string_14();
        return init_relations_global_string_14;
    }

    public final StringResource getRelations_global_string_14() {
        return (StringResource) relations_global_string_14$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_15_delegate$lambda$0() {
        StringResource init_relations_global_string_15;
        init_relations_global_string_15 = String0_commonMainKt.init_relations_global_string_15();
        return init_relations_global_string_15;
    }

    public final StringResource getRelations_global_string_15() {
        return (StringResource) relations_global_string_15$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_16_delegate$lambda$0() {
        StringResource init_relations_global_string_16;
        init_relations_global_string_16 = String0_commonMainKt.init_relations_global_string_16();
        return init_relations_global_string_16;
    }

    public final StringResource getRelations_global_string_16() {
        return (StringResource) relations_global_string_16$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_17_delegate$lambda$0() {
        StringResource init_relations_global_string_17;
        init_relations_global_string_17 = String0_commonMainKt.init_relations_global_string_17();
        return init_relations_global_string_17;
    }

    public final StringResource getRelations_global_string_17() {
        return (StringResource) relations_global_string_17$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_18_delegate$lambda$0() {
        StringResource init_relations_global_string_18;
        init_relations_global_string_18 = String0_commonMainKt.init_relations_global_string_18();
        return init_relations_global_string_18;
    }

    public final StringResource getRelations_global_string_18() {
        return (StringResource) relations_global_string_18$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_19_delegate$lambda$0() {
        StringResource init_relations_global_string_19;
        init_relations_global_string_19 = String0_commonMainKt.init_relations_global_string_19();
        return init_relations_global_string_19;
    }

    public final StringResource getRelations_global_string_19() {
        return (StringResource) relations_global_string_19$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_2_delegate$lambda$0() {
        StringResource init_relations_global_string_2;
        init_relations_global_string_2 = String0_commonMainKt.init_relations_global_string_2();
        return init_relations_global_string_2;
    }

    public final StringResource getRelations_global_string_2() {
        return (StringResource) relations_global_string_2$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_20_delegate$lambda$0() {
        StringResource init_relations_global_string_20;
        init_relations_global_string_20 = String0_commonMainKt.init_relations_global_string_20();
        return init_relations_global_string_20;
    }

    public final StringResource getRelations_global_string_20() {
        return (StringResource) relations_global_string_20$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_22_delegate$lambda$0() {
        StringResource init_relations_global_string_22;
        init_relations_global_string_22 = String0_commonMainKt.init_relations_global_string_22();
        return init_relations_global_string_22;
    }

    public final StringResource getRelations_global_string_22() {
        return (StringResource) relations_global_string_22$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_23_delegate$lambda$0() {
        StringResource init_relations_global_string_23;
        init_relations_global_string_23 = String0_commonMainKt.init_relations_global_string_23();
        return init_relations_global_string_23;
    }

    public final StringResource getRelations_global_string_23() {
        return (StringResource) relations_global_string_23$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_24_delegate$lambda$0() {
        StringResource init_relations_global_string_24;
        init_relations_global_string_24 = String0_commonMainKt.init_relations_global_string_24();
        return init_relations_global_string_24;
    }

    public final StringResource getRelations_global_string_24() {
        return (StringResource) relations_global_string_24$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_25_delegate$lambda$0() {
        StringResource init_relations_global_string_25;
        init_relations_global_string_25 = String0_commonMainKt.init_relations_global_string_25();
        return init_relations_global_string_25;
    }

    public final StringResource getRelations_global_string_25() {
        return (StringResource) relations_global_string_25$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_26_delegate$lambda$0() {
        StringResource init_relations_global_string_26;
        init_relations_global_string_26 = String0_commonMainKt.init_relations_global_string_26();
        return init_relations_global_string_26;
    }

    public final StringResource getRelations_global_string_26() {
        return (StringResource) relations_global_string_26$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_27_delegate$lambda$0() {
        StringResource init_relations_global_string_27;
        init_relations_global_string_27 = String0_commonMainKt.init_relations_global_string_27();
        return init_relations_global_string_27;
    }

    public final StringResource getRelations_global_string_27() {
        return (StringResource) relations_global_string_27$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_28_delegate$lambda$0() {
        StringResource init_relations_global_string_28;
        init_relations_global_string_28 = String0_commonMainKt.init_relations_global_string_28();
        return init_relations_global_string_28;
    }

    public final StringResource getRelations_global_string_28() {
        return (StringResource) relations_global_string_28$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_29_delegate$lambda$0() {
        StringResource init_relations_global_string_29;
        init_relations_global_string_29 = String0_commonMainKt.init_relations_global_string_29();
        return init_relations_global_string_29;
    }

    public final StringResource getRelations_global_string_29() {
        return (StringResource) relations_global_string_29$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_3_delegate$lambda$0() {
        StringResource init_relations_global_string_3;
        init_relations_global_string_3 = String0_commonMainKt.init_relations_global_string_3();
        return init_relations_global_string_3;
    }

    public final StringResource getRelations_global_string_3() {
        return (StringResource) relations_global_string_3$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_31_delegate$lambda$0() {
        StringResource init_relations_global_string_31;
        init_relations_global_string_31 = String0_commonMainKt.init_relations_global_string_31();
        return init_relations_global_string_31;
    }

    public final StringResource getRelations_global_string_31() {
        return (StringResource) relations_global_string_31$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_32_delegate$lambda$0() {
        StringResource init_relations_global_string_32;
        init_relations_global_string_32 = String0_commonMainKt.init_relations_global_string_32();
        return init_relations_global_string_32;
    }

    public final StringResource getRelations_global_string_32() {
        return (StringResource) relations_global_string_32$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_33_delegate$lambda$0() {
        StringResource init_relations_global_string_33;
        init_relations_global_string_33 = String0_commonMainKt.init_relations_global_string_33();
        return init_relations_global_string_33;
    }

    public final StringResource getRelations_global_string_33() {
        return (StringResource) relations_global_string_33$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_34_delegate$lambda$0() {
        StringResource init_relations_global_string_34;
        init_relations_global_string_34 = String0_commonMainKt.init_relations_global_string_34();
        return init_relations_global_string_34;
    }

    public final StringResource getRelations_global_string_34() {
        return (StringResource) relations_global_string_34$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_35_delegate$lambda$0() {
        StringResource init_relations_global_string_35;
        init_relations_global_string_35 = String0_commonMainKt.init_relations_global_string_35();
        return init_relations_global_string_35;
    }

    public final StringResource getRelations_global_string_35() {
        return (StringResource) relations_global_string_35$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_36_delegate$lambda$0() {
        StringResource init_relations_global_string_36;
        init_relations_global_string_36 = String0_commonMainKt.init_relations_global_string_36();
        return init_relations_global_string_36;
    }

    public final StringResource getRelations_global_string_36() {
        return (StringResource) relations_global_string_36$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_37_delegate$lambda$0() {
        StringResource init_relations_global_string_37;
        init_relations_global_string_37 = String0_commonMainKt.init_relations_global_string_37();
        return init_relations_global_string_37;
    }

    public final StringResource getRelations_global_string_37() {
        return (StringResource) relations_global_string_37$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_38_delegate$lambda$0() {
        StringResource init_relations_global_string_38;
        init_relations_global_string_38 = String0_commonMainKt.init_relations_global_string_38();
        return init_relations_global_string_38;
    }

    public final StringResource getRelations_global_string_38() {
        return (StringResource) relations_global_string_38$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_39_delegate$lambda$0() {
        StringResource init_relations_global_string_39;
        init_relations_global_string_39 = String0_commonMainKt.init_relations_global_string_39();
        return init_relations_global_string_39;
    }

    public final StringResource getRelations_global_string_39() {
        return (StringResource) relations_global_string_39$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_4_delegate$lambda$0() {
        StringResource init_relations_global_string_4;
        init_relations_global_string_4 = String0_commonMainKt.init_relations_global_string_4();
        return init_relations_global_string_4;
    }

    public final StringResource getRelations_global_string_4() {
        return (StringResource) relations_global_string_4$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_40_delegate$lambda$0() {
        StringResource init_relations_global_string_40;
        init_relations_global_string_40 = String0_commonMainKt.init_relations_global_string_40();
        return init_relations_global_string_40;
    }

    public final StringResource getRelations_global_string_40() {
        return (StringResource) relations_global_string_40$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_41_delegate$lambda$0() {
        StringResource init_relations_global_string_41;
        init_relations_global_string_41 = String0_commonMainKt.init_relations_global_string_41();
        return init_relations_global_string_41;
    }

    public final StringResource getRelations_global_string_41() {
        return (StringResource) relations_global_string_41$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_42_delegate$lambda$0() {
        StringResource init_relations_global_string_42;
        init_relations_global_string_42 = String0_commonMainKt.init_relations_global_string_42();
        return init_relations_global_string_42;
    }

    public final StringResource getRelations_global_string_42() {
        return (StringResource) relations_global_string_42$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_43_delegate$lambda$0() {
        StringResource init_relations_global_string_43;
        init_relations_global_string_43 = String0_commonMainKt.init_relations_global_string_43();
        return init_relations_global_string_43;
    }

    public final StringResource getRelations_global_string_43() {
        return (StringResource) relations_global_string_43$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_44_delegate$lambda$0() {
        StringResource init_relations_global_string_44;
        init_relations_global_string_44 = String0_commonMainKt.init_relations_global_string_44();
        return init_relations_global_string_44;
    }

    public final StringResource getRelations_global_string_44() {
        return (StringResource) relations_global_string_44$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_45_delegate$lambda$0() {
        StringResource init_relations_global_string_45;
        init_relations_global_string_45 = String0_commonMainKt.init_relations_global_string_45();
        return init_relations_global_string_45;
    }

    public final StringResource getRelations_global_string_45() {
        return (StringResource) relations_global_string_45$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_46_delegate$lambda$0() {
        StringResource init_relations_global_string_46;
        init_relations_global_string_46 = String0_commonMainKt.init_relations_global_string_46();
        return init_relations_global_string_46;
    }

    public final StringResource getRelations_global_string_46() {
        return (StringResource) relations_global_string_46$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_47_delegate$lambda$0() {
        StringResource init_relations_global_string_47;
        init_relations_global_string_47 = String0_commonMainKt.init_relations_global_string_47();
        return init_relations_global_string_47;
    }

    public final StringResource getRelations_global_string_47() {
        return (StringResource) relations_global_string_47$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_48_delegate$lambda$0() {
        StringResource init_relations_global_string_48;
        init_relations_global_string_48 = String0_commonMainKt.init_relations_global_string_48();
        return init_relations_global_string_48;
    }

    public final StringResource getRelations_global_string_48() {
        return (StringResource) relations_global_string_48$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_49_delegate$lambda$0() {
        StringResource init_relations_global_string_49;
        init_relations_global_string_49 = String0_commonMainKt.init_relations_global_string_49();
        return init_relations_global_string_49;
    }

    public final StringResource getRelations_global_string_49() {
        return (StringResource) relations_global_string_49$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_5_delegate$lambda$0() {
        StringResource init_relations_global_string_5;
        init_relations_global_string_5 = String0_commonMainKt.init_relations_global_string_5();
        return init_relations_global_string_5;
    }

    public final StringResource getRelations_global_string_5() {
        return (StringResource) relations_global_string_5$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_50_delegate$lambda$0() {
        StringResource init_relations_global_string_50;
        init_relations_global_string_50 = String0_commonMainKt.init_relations_global_string_50();
        return init_relations_global_string_50;
    }

    public final StringResource getRelations_global_string_50() {
        return (StringResource) relations_global_string_50$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_51_delegate$lambda$0() {
        StringResource init_relations_global_string_51;
        init_relations_global_string_51 = String0_commonMainKt.init_relations_global_string_51();
        return init_relations_global_string_51;
    }

    public final StringResource getRelations_global_string_51() {
        return (StringResource) relations_global_string_51$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_52_delegate$lambda$0() {
        StringResource init_relations_global_string_52;
        init_relations_global_string_52 = String0_commonMainKt.init_relations_global_string_52();
        return init_relations_global_string_52;
    }

    public final StringResource getRelations_global_string_52() {
        return (StringResource) relations_global_string_52$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_53_delegate$lambda$0() {
        StringResource init_relations_global_string_53;
        init_relations_global_string_53 = String0_commonMainKt.init_relations_global_string_53();
        return init_relations_global_string_53;
    }

    public final StringResource getRelations_global_string_53() {
        return (StringResource) relations_global_string_53$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_54_delegate$lambda$0() {
        StringResource init_relations_global_string_54;
        init_relations_global_string_54 = String0_commonMainKt.init_relations_global_string_54();
        return init_relations_global_string_54;
    }

    public final StringResource getRelations_global_string_54() {
        return (StringResource) relations_global_string_54$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_55_delegate$lambda$0() {
        StringResource init_relations_global_string_55;
        init_relations_global_string_55 = String0_commonMainKt.init_relations_global_string_55();
        return init_relations_global_string_55;
    }

    public final StringResource getRelations_global_string_55() {
        return (StringResource) relations_global_string_55$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_56_delegate$lambda$0() {
        StringResource init_relations_global_string_56;
        init_relations_global_string_56 = String0_commonMainKt.init_relations_global_string_56();
        return init_relations_global_string_56;
    }

    public final StringResource getRelations_global_string_56() {
        return (StringResource) relations_global_string_56$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_57_delegate$lambda$0() {
        StringResource init_relations_global_string_57;
        init_relations_global_string_57 = String0_commonMainKt.init_relations_global_string_57();
        return init_relations_global_string_57;
    }

    public final StringResource getRelations_global_string_57() {
        return (StringResource) relations_global_string_57$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_58_delegate$lambda$0() {
        StringResource init_relations_global_string_58;
        init_relations_global_string_58 = String0_commonMainKt.init_relations_global_string_58();
        return init_relations_global_string_58;
    }

    public final StringResource getRelations_global_string_58() {
        return (StringResource) relations_global_string_58$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_59_delegate$lambda$0() {
        StringResource init_relations_global_string_59;
        init_relations_global_string_59 = String0_commonMainKt.init_relations_global_string_59();
        return init_relations_global_string_59;
    }

    public final StringResource getRelations_global_string_59() {
        return (StringResource) relations_global_string_59$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_6_delegate$lambda$0() {
        StringResource init_relations_global_string_6;
        init_relations_global_string_6 = String0_commonMainKt.init_relations_global_string_6();
        return init_relations_global_string_6;
    }

    public final StringResource getRelations_global_string_6() {
        return (StringResource) relations_global_string_6$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_60_delegate$lambda$0() {
        StringResource init_relations_global_string_60;
        init_relations_global_string_60 = String0_commonMainKt.init_relations_global_string_60();
        return init_relations_global_string_60;
    }

    public final StringResource getRelations_global_string_60() {
        return (StringResource) relations_global_string_60$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_61_delegate$lambda$0() {
        StringResource init_relations_global_string_61;
        init_relations_global_string_61 = String0_commonMainKt.init_relations_global_string_61();
        return init_relations_global_string_61;
    }

    public final StringResource getRelations_global_string_61() {
        return (StringResource) relations_global_string_61$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_62_delegate$lambda$0() {
        StringResource init_relations_global_string_62;
        init_relations_global_string_62 = String0_commonMainKt.init_relations_global_string_62();
        return init_relations_global_string_62;
    }

    public final StringResource getRelations_global_string_62() {
        return (StringResource) relations_global_string_62$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_63_delegate$lambda$0() {
        StringResource init_relations_global_string_63;
        init_relations_global_string_63 = String0_commonMainKt.init_relations_global_string_63();
        return init_relations_global_string_63;
    }

    public final StringResource getRelations_global_string_63() {
        return (StringResource) relations_global_string_63$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_64_delegate$lambda$0() {
        StringResource init_relations_global_string_64;
        init_relations_global_string_64 = String0_commonMainKt.init_relations_global_string_64();
        return init_relations_global_string_64;
    }

    public final StringResource getRelations_global_string_64() {
        return (StringResource) relations_global_string_64$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_65_delegate$lambda$0() {
        StringResource init_relations_global_string_65;
        init_relations_global_string_65 = String0_commonMainKt.init_relations_global_string_65();
        return init_relations_global_string_65;
    }

    public final StringResource getRelations_global_string_65() {
        return (StringResource) relations_global_string_65$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_66_delegate$lambda$0() {
        StringResource init_relations_global_string_66;
        init_relations_global_string_66 = String0_commonMainKt.init_relations_global_string_66();
        return init_relations_global_string_66;
    }

    public final StringResource getRelations_global_string_66() {
        return (StringResource) relations_global_string_66$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_67_delegate$lambda$0() {
        StringResource init_relations_global_string_67;
        init_relations_global_string_67 = String0_commonMainKt.init_relations_global_string_67();
        return init_relations_global_string_67;
    }

    public final StringResource getRelations_global_string_67() {
        return (StringResource) relations_global_string_67$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_68_delegate$lambda$0() {
        StringResource init_relations_global_string_68;
        init_relations_global_string_68 = String0_commonMainKt.init_relations_global_string_68();
        return init_relations_global_string_68;
    }

    public final StringResource getRelations_global_string_68() {
        return (StringResource) relations_global_string_68$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_69_delegate$lambda$0() {
        StringResource init_relations_global_string_69;
        init_relations_global_string_69 = String0_commonMainKt.init_relations_global_string_69();
        return init_relations_global_string_69;
    }

    public final StringResource getRelations_global_string_69() {
        return (StringResource) relations_global_string_69$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_7_delegate$lambda$0() {
        StringResource init_relations_global_string_7;
        init_relations_global_string_7 = String0_commonMainKt.init_relations_global_string_7();
        return init_relations_global_string_7;
    }

    public final StringResource getRelations_global_string_7() {
        return (StringResource) relations_global_string_7$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_70_delegate$lambda$0() {
        StringResource init_relations_global_string_70;
        init_relations_global_string_70 = String0_commonMainKt.init_relations_global_string_70();
        return init_relations_global_string_70;
    }

    public final StringResource getRelations_global_string_70() {
        return (StringResource) relations_global_string_70$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_71_delegate$lambda$0() {
        StringResource init_relations_global_string_71;
        init_relations_global_string_71 = String0_commonMainKt.init_relations_global_string_71();
        return init_relations_global_string_71;
    }

    public final StringResource getRelations_global_string_71() {
        return (StringResource) relations_global_string_71$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_72_delegate$lambda$0() {
        StringResource init_relations_global_string_72;
        init_relations_global_string_72 = String0_commonMainKt.init_relations_global_string_72();
        return init_relations_global_string_72;
    }

    public final StringResource getRelations_global_string_72() {
        return (StringResource) relations_global_string_72$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_73_delegate$lambda$0() {
        StringResource init_relations_global_string_73;
        init_relations_global_string_73 = String0_commonMainKt.init_relations_global_string_73();
        return init_relations_global_string_73;
    }

    public final StringResource getRelations_global_string_73() {
        return (StringResource) relations_global_string_73$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_74_delegate$lambda$0() {
        StringResource init_relations_global_string_74;
        init_relations_global_string_74 = String0_commonMainKt.init_relations_global_string_74();
        return init_relations_global_string_74;
    }

    public final StringResource getRelations_global_string_74() {
        return (StringResource) relations_global_string_74$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_75_delegate$lambda$0() {
        StringResource init_relations_global_string_75;
        init_relations_global_string_75 = String0_commonMainKt.init_relations_global_string_75();
        return init_relations_global_string_75;
    }

    public final StringResource getRelations_global_string_75() {
        return (StringResource) relations_global_string_75$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_76_delegate$lambda$0() {
        StringResource init_relations_global_string_76;
        init_relations_global_string_76 = String0_commonMainKt.init_relations_global_string_76();
        return init_relations_global_string_76;
    }

    public final StringResource getRelations_global_string_76() {
        return (StringResource) relations_global_string_76$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_77_delegate$lambda$0() {
        StringResource init_relations_global_string_77;
        init_relations_global_string_77 = String0_commonMainKt.init_relations_global_string_77();
        return init_relations_global_string_77;
    }

    public final StringResource getRelations_global_string_77() {
        return (StringResource) relations_global_string_77$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_78_delegate$lambda$0() {
        StringResource init_relations_global_string_78;
        init_relations_global_string_78 = String0_commonMainKt.init_relations_global_string_78();
        return init_relations_global_string_78;
    }

    public final StringResource getRelations_global_string_78() {
        return (StringResource) relations_global_string_78$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_8_delegate$lambda$0() {
        StringResource init_relations_global_string_8;
        init_relations_global_string_8 = String0_commonMainKt.init_relations_global_string_8();
        return init_relations_global_string_8;
    }

    public final StringResource getRelations_global_string_8() {
        return (StringResource) relations_global_string_8$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_80_delegate$lambda$0() {
        StringResource init_relations_global_string_80;
        init_relations_global_string_80 = String0_commonMainKt.init_relations_global_string_80();
        return init_relations_global_string_80;
    }

    public final StringResource getRelations_global_string_80() {
        return (StringResource) relations_global_string_80$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_82_delegate$lambda$0() {
        StringResource init_relations_global_string_82;
        init_relations_global_string_82 = String0_commonMainKt.init_relations_global_string_82();
        return init_relations_global_string_82;
    }

    public final StringResource getRelations_global_string_82() {
        return (StringResource) relations_global_string_82$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource relations_global_string_9_delegate$lambda$0() {
        StringResource init_relations_global_string_9;
        init_relations_global_string_9 = String0_commonMainKt.init_relations_global_string_9();
        return init_relations_global_string_9;
    }

    public final StringResource getRelations_global_string_9() {
        return (StringResource) relations_global_string_9$delegate.getValue();
    }
}