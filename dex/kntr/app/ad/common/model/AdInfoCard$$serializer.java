package kntr.app.ad.common.model;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdInfoCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdInfoCard.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdInfoCard;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdInfoCard$$serializer implements GeneratedSerializer<AdInfoCard> {
    public static final AdInfoCard$$serializer INSTANCE = new AdInfoCard$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdInfoCard", INSTANCE, 150);
        pluginGeneratedSerialDescriptor.addElement("enable_tag_move_up", true);
        pluginGeneratedSerialDescriptor.addElement("search_card_style", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CARD_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("jump_url", true);
        pluginGeneratedSerialDescriptor.addElement("live_bottom_icon_jump_url", true);
        pluginGeneratedSerialDescriptor.addElement("callup_url", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        pluginGeneratedSerialDescriptor.addElement("desc_type", true);
        pluginGeneratedSerialDescriptor.addElement("ori_price", true);
        pluginGeneratedSerialDescriptor.addElement("cur_price", true);
        pluginGeneratedSerialDescriptor.addElement("extra_desc", true);
        pluginGeneratedSerialDescriptor.addElement("rank", true);
        pluginGeneratedSerialDescriptor.addElement("hot_score", true);
        pluginGeneratedSerialDescriptor.addElement("covers", true);
        pluginGeneratedSerialDescriptor.addElement("button", true);
        pluginGeneratedSerialDescriptor.addElement("long_desc", true);
        pluginGeneratedSerialDescriptor.addElement("adver_logo", true);
        pluginGeneratedSerialDescriptor.addElement("adver_name", true);
        pluginGeneratedSerialDescriptor.addElement("adver_page_url", true);
        pluginGeneratedSerialDescriptor.addElement("video_barrage", true);
        pluginGeneratedSerialDescriptor.addElement("ad_tag", true);
        pluginGeneratedSerialDescriptor.addElement("short_title", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_title", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_life", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_begin", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_height", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_color", true);
        pluginGeneratedSerialDescriptor.addElement("fold_time", true);
        pluginGeneratedSerialDescriptor.addElement("good", true);
        pluginGeneratedSerialDescriptor.addElement("ad_tag_style", true);
        pluginGeneratedSerialDescriptor.addElement("ad_tag_style_full_screen", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_h5url", true);
        pluginGeneratedSerialDescriptor.addElement("feedback_panel", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_icon", true);
        pluginGeneratedSerialDescriptor.addElement("danmu_width", true);
        pluginGeneratedSerialDescriptor.addElement("imax_landing_page", true);
        pluginGeneratedSerialDescriptor.addElement("price_desc", true);
        pluginGeneratedSerialDescriptor.addElement("goods_cur_price", true);
        pluginGeneratedSerialDescriptor.addElement("price_symbol", true);
        pluginGeneratedSerialDescriptor.addElement("goods_ori_price", true);
        pluginGeneratedSerialDescriptor.addElement("live_streamer_name", true);
        pluginGeneratedSerialDescriptor.addElement("live_streamer_face", true);
        pluginGeneratedSerialDescriptor.addElement("live_room_popularity", true);
        pluginGeneratedSerialDescriptor.addElement("live_room_area", true);
        pluginGeneratedSerialDescriptor.addElement("live_room_title", true);
        pluginGeneratedSerialDescriptor.addElement("live_tag_show", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("quality_infos", true);
        pluginGeneratedSerialDescriptor.addElement("adver", true);
        pluginGeneratedSerialDescriptor.addElement("dynamic_text", true);
        pluginGeneratedSerialDescriptor.addElement("choose_button_list", true);
        pluginGeneratedSerialDescriptor.addElement("grade_level", true);
        pluginGeneratedSerialDescriptor.addElement("bg_img", true);
        pluginGeneratedSerialDescriptor.addElement("extreme_team_status", true);
        pluginGeneratedSerialDescriptor.addElement("extreme_team_icon", true);
        pluginGeneratedSerialDescriptor.addElement("nickname", true);
        pluginGeneratedSerialDescriptor.addElement("support_transition", true);
        pluginGeneratedSerialDescriptor.addElement("transition", true);
        pluginGeneratedSerialDescriptor.addElement("under_player_interaction_style", true);
        pluginGeneratedSerialDescriptor.addElement("jump_interaction_style", true);
        pluginGeneratedSerialDescriptor.addElement("left_cover_badge_style", true);
        pluginGeneratedSerialDescriptor.addElement("imax_landing_page_v2", true);
        pluginGeneratedSerialDescriptor.addElement("subcard_module", true);
        pluginGeneratedSerialDescriptor.addElement("fly_subcard_module", true);
        pluginGeneratedSerialDescriptor.addElement("thumbs_up_subcard_module", true);
        pluginGeneratedSerialDescriptor.addElement("treasure_hunt_ball", true);
        pluginGeneratedSerialDescriptor.addElement("game_rating", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("gameTags", true);
        pluginGeneratedSerialDescriptor.addElement("live_booking_population_threshold", true);
        pluginGeneratedSerialDescriptor.addElement("normal_mode_background_color", true);
        pluginGeneratedSerialDescriptor.addElement("night_mode_background_color", true);
        pluginGeneratedSerialDescriptor.addElement("bulletin", true);
        pluginGeneratedSerialDescriptor.addElement("gift", true);
        pluginGeneratedSerialDescriptor.addElement("star_level", true);
        pluginGeneratedSerialDescriptor.addElement("ori_mark_hidden", true);
        pluginGeneratedSerialDescriptor.addElement("wx_program_info", true);
        pluginGeneratedSerialDescriptor.addElement("android_game_page_res", true);
        pluginGeneratedSerialDescriptor.addElement("use_multi_cover", true);
        pluginGeneratedSerialDescriptor.addElement("product_source", true);
        pluginGeneratedSerialDescriptor.addElement("ip_video", true);
        pluginGeneratedSerialDescriptor.addElement("labels", true);
        pluginGeneratedSerialDescriptor.addElement("shop_window", true);
        pluginGeneratedSerialDescriptor.addElement("rcmd_reason_style", true);
        pluginGeneratedSerialDescriptor.addElement("easter_egg_video", true);
        pluginGeneratedSerialDescriptor.addElement("not_clickable_area", true);
        pluginGeneratedSerialDescriptor.addElement("custom_feedback_panels", true);
        pluginGeneratedSerialDescriptor.addElement("forward_reply", true);
        pluginGeneratedSerialDescriptor.addElement("story_goods", true);
        pluginGeneratedSerialDescriptor.addElement("story_anchor", true);
        pluginGeneratedSerialDescriptor.addElement("schema_name", true);
        pluginGeneratedSerialDescriptor.addElement("yellow_cart_pannel_version", true);
        pluginGeneratedSerialDescriptor.addElement("yellow_cart_pannel_pullup", true);
        pluginGeneratedSerialDescriptor.addElement("volume_desc", true);
        pluginGeneratedSerialDescriptor.addElement("product_infos", true);
        pluginGeneratedSerialDescriptor.addElement("coupon_desc", true);
        pluginGeneratedSerialDescriptor.addElement("coupon_price", true);
        pluginGeneratedSerialDescriptor.addElement("goods_item_id", true);
        pluginGeneratedSerialDescriptor.addElement("easter_egg_params", true);
        pluginGeneratedSerialDescriptor.addElement("av_content", true);
        pluginGeneratedSerialDescriptor.addElement("story_cart_delay_time", true);
        pluginGeneratedSerialDescriptor.addElement("comment_interaction_style", true);
        pluginGeneratedSerialDescriptor.addElement("comment_use_game_page", true);
        pluginGeneratedSerialDescriptor.addElement("form_info", true);
        pluginGeneratedSerialDescriptor.addElement("pasteboard_info", true);
        pluginGeneratedSerialDescriptor.addElement("anim_in_enable", true);
        pluginGeneratedSerialDescriptor.addElement("product_viewed_text", true);
        pluginGeneratedSerialDescriptor.addElement("product_source_short", true);
        pluginGeneratedSerialDescriptor.addElement("product_comments", true);
        pluginGeneratedSerialDescriptor.addElement("downloadArea", true);
        pluginGeneratedSerialDescriptor.addElement("card_style", true);
        pluginGeneratedSerialDescriptor.addElement("underframe_card_style", true);
        pluginGeneratedSerialDescriptor.addElement("grade_denominator", true);
        pluginGeneratedSerialDescriptor.addElement("left_cover_badge_new_style", true);
        pluginGeneratedSerialDescriptor.addElement("game_info", true);
        pluginGeneratedSerialDescriptor.addElement("game_rank", true);
        pluginGeneratedSerialDescriptor.addElement("story_video_finish_time", true);
        pluginGeneratedSerialDescriptor.addElement("paid_message", true);
        pluginGeneratedSerialDescriptor.addElement("goods_pannel_show", true);
        pluginGeneratedSerialDescriptor.addElement("show_pop_window", true);
        pluginGeneratedSerialDescriptor.addElement("lottery_text", true);
        pluginGeneratedSerialDescriptor.addElement("warm_up_text", true);
        pluginGeneratedSerialDescriptor.addElement("live_page_type", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.EXTRA_PARAMS, true);
        pluginGeneratedSerialDescriptor.addElement("story_interaction_style", true);
        pluginGeneratedSerialDescriptor.addElement("calendar_info", true);
        pluginGeneratedSerialDescriptor.addElement("live_auto_play", true);
        pluginGeneratedSerialDescriptor.addElement("story_float_show_rate", true);
        pluginGeneratedSerialDescriptor.addElement("story_float_show_period", true);
        pluginGeneratedSerialDescriptor.addElement("original_style_level", true);
        pluginGeneratedSerialDescriptor.addElement("half_panel_interaction_style", true);
        pluginGeneratedSerialDescriptor.addElement("half_panel_content_type", true);
        pluginGeneratedSerialDescriptor.addElement("search_show_adbutton", true);
        pluginGeneratedSerialDescriptor.addElement("live_card_show", true);
        pluginGeneratedSerialDescriptor.addElement("lottery_card", true);
        pluginGeneratedSerialDescriptor.addElement("combo_click_params", true);
        pluginGeneratedSerialDescriptor.addElement("outer_id", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.ITEM_SOURCE, true);
        pluginGeneratedSerialDescriptor.addElement("closed_loop_item", true);
        pluginGeneratedSerialDescriptor.addElement("story_item_static_info", true);
        pluginGeneratedSerialDescriptor.addElement("chronos_effect", true);
        pluginGeneratedSerialDescriptor.addElement("product_carousel", true);
        pluginGeneratedSerialDescriptor.addElement("playpage_card_style", true);
        pluginGeneratedSerialDescriptor.addElement("app_download_style", true);
        pluginGeneratedSerialDescriptor.addElement("heart_box", true);
        pluginGeneratedSerialDescriptor.addElement("story_style_selection_module", true);
        pluginGeneratedSerialDescriptor.addElement("descList", true);
        pluginGeneratedSerialDescriptor.addElement("use_engine_author", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdInfoCard$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = AdInfoCard.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[14].getValue()), BuiltinSerializersKt.getNullable(AdButton$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[20].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdGood$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdTagStyle$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdTagStyle$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdVideo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdFeedbackPanel$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdIMaxLandingPage$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[49].getValue()), BuiltinSerializersKt.getNullable(AdVer$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[52].getValue()), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdCoverBadge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdSubCardModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdFlySubCardModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdThumbsUpSubCardModule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdTreasureHuntBall$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[69].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[70].getValue()), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdBulletin$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGift$$serializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdWxProgramInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdAndroidGameInfo$$serializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdVideo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[83].getValue()), BuiltinSerializersKt.getNullable(AdShopWindow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdRcmdReasonStyle$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdVideo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdXYZ$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[88].getValue()), BuiltinSerializersKt.getNullable(AdForwardReply$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdStoryGoods$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdStoryGoods$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[96].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdEasterEggParams$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdFormInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPasteboardInfo$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[110].getValue()), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdCoverTopLeftBadge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdGameRank$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdCalendarInfo$$serializer.INSTANCE), BooleanSerializer.INSTANCE, FloatSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdLotteryCard$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdComboClickParams$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdChronosEffect$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdProductCarouselData$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdAppDownloadStyle$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdHeartBox$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AdStoryStyleSelection$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[148].getValue()), BooleanSerializer.INSTANCE};
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -85
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final kntr.app.ad.common.model.AdInfoCard deserialize(kotlinx.serialization.encoding.Decoder r187) {
        /*
            Method dump skipped, instructions count: 9032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.common.model.AdInfoCard$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):kntr.app.ad.common.model.AdInfoCard");
    }

    public final void serialize(Encoder encoder, AdInfoCard value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdInfoCard.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}