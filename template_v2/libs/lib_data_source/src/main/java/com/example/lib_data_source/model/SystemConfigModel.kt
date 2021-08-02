package com.example.lib_data_source.model

import com.squareup.moshi.Json

data class SystemConfigModel(
    @Json(name = "server:version")
    val serverVersion: String?,

    @Json(name = "ad")
    val ads: List<Ad>?,

    @Json(name = "site")
    val site: Site?,

    @Json(name = "float_menu")
    val floatMenu: FloatMenu?,

    @Json(name = "registerSettings")
    val registerSettings: RegisterSettings?,

    @Json(name = "currency")
    val currency: Currency?,

    @Json(name = "wallet")
    val wallet: Wallet?,

    @Json(name = "limit")
    val limit: Int?,

    @Json(name = "reward-validate-user-password")
    val rewardValidateUserPassword: Boolean?,

    @Json(name = "transfer-validate-user-password")
    val transferValidateUserPassword: Boolean?,

    @Json(name = "wave-url")
    val waveUrl: String?,

    @Json(name = "wave-abstract-video-url")
    val waveAbstractVideoUrl: String?,

    @Json(name = "wave-blue-video-url")
    val waveBlueVideoUrl: String?,

    @Json(name = "referral-url-prefix")
    val referralUrlPrefix: String?,

    @Json(name = "share-url-prefix")
    val shareUrlPrefix: String?,

    @Json(name = "modules")
    val modules: List<Module>?,

    @Json(name = "yippi-ads")
    val yippiAds: YippiAds?,

    @Json(name = "features")
    val features: Features?,

    @Json(name = "httpdns")
    val httpdns: Httpdns?,

    @Json(name = "huawei-version-migrate")
    val huaweiVersionMigrate: Boolean?,

    @Json(name = "Q&A")
    val qa: QA?,

    @Json(name = "plus-appversion")
    val plusAppVersion: PlusAppVersion?,

    @Json(name = "checkin")
    val checkin: Checkin?,

    @Json(name = "feed")
    val feed: Feed?,

    @Json(name = "news")
    val news: News?,

    @Json(name = "group:create")
    val groupCreate: GroupCreate?,

    @Json(name = "group:reward")
    val groupReward: GroupReward?
) {

    data class Ad(
        @Json(name = "id")
        val id: Int?,

        @Json(name = "space_id")
        val spaceId: Int?,

        @Json(name = "title")
        val title: String?,

        @Json(name = "type")
        val type: String?,

        @Json(name = "data")
        val `data`: Data?,

        @Json(name = "sort")
        val sort: Int?,

        @Json(name = "created_at")
        val createdAt: String?,

        @Json(name = "updated_at")
        val updatedAt: String?,

        @Json(name = "lang")
        val lang: String?,

        @Json(name = "ad_start")
        val adStart: String?,

        @Json(name = "ad_end")
        val adEnd: String?,

        @Json(name = "ads_dates")
        val adsDates: String?
    ) {

        data class Data(
            @Json(name = "image")
            val image: String?,

            @Json(name = "duration")
            val duration: Int?,

            @Json(name = "link")
            val link: String?
        )
    }

    data class Site(
        @Json(name = "anonymous")
        val anonymous: Anonymous?,

        @Json(name = "gold")
        val gold: Gold?,

        @Json(name = "reserved_nickname")
        val reservedNickname: String?,

        @Json(name = "reward")
        val reward: Reward?,

        @Json(name = "reward_list")
        val rewardForTipList: List<RewardForTip>?,

        @Json(name = "live_reward")
        val liveReward: LiveReward?,

        @Json(name = "user_invite_template")
        val userInviteTemplate: String?,

        @Json(name = "live_egg")
        val liveEgg: LiveEgg?,

        @Json(name = "session_interval")
        val sessionInterval: Int?,

        @Json(name = "gold_name")
        val goldName: GoldName?,

        @Json(name = "currency_name")
        val currencyName: CurrencyName?
    ) {

        data class Anonymous(
            @Json(name = "status")
            val status: Boolean?
        )

        data class Gold(
            @Json(name = "status")
            val status: Boolean?
        )

        data class Reward(
            @Json(name = "status")
            val status: Boolean?,
            @Json(name = "amounts")
            val amounts: String?
        )

        data class RewardForTip(
            @Json(name = "id")
            val id: Long,

            @Json(name = "image_url")
            val imageUrl: String?,

            @Json(name = "live_animation")
            val liveAnimation: String?,

            @Json(name = "live_animation_toggle")
            val liveAnimationToggle: Int?,

            @Json(name = "amount")
            val amount: String?,

            @Json(name = "sort")
            val sort: Int?,

            @Json(name = "created_at")
            val createdAt: String?,

            @Json(name = "updated_at")
            val updatedAt: String?
        ) {

            fun getAmountInDouble(): Double = amount?.toDoubleOrNull() ?: 0.0
        }

        data class LiveReward(
            @Json(name = "status")
            val status: Boolean?,

            @Json(name = "amounts")
            val amounts: String?
        )

        data class LiveEgg(
            @Json(name = "countdown_options")
            val countdownOptions: CountdownOptions?,

            @Json(name = "reward_options")
            val rewardOptions: RewardOptions?
        ) {

            data class CountdownOptions(
                @Json(name = "status")
                val status: Boolean?,

                @Json(name = "countdown")
                val countdown: String?
            )

            data class RewardOptions(
                @Json(name = "status")
                val status: Boolean?,

                @Json(name = "amounts")
                val amounts: String?
            )
        }

        data class GoldName(
            @Json(name = "name")
            val name: String?,

            @Json(name = "unit")
            val unit: String?
        )

        data class CurrencyName(
            @Json(name = "id")
            val id: Int?,

            @Json(name = "name")
            val name: String?,

            @Json(name = "enable")
            val enable: Int?
        )
    }

    data class FloatMenu(
        @Json(name = "show_trt")
        val showTrt: Boolean?
    )

    data class RegisterSettings(
        @Json(name = "showTerms")
        val showTerms: Boolean?,

        @Json(name = "showReferral")
        val showReferral: Boolean?,

        @Json(name = "method")
        val method: String?,

        @Json(name = "content")
        val content: String?,

        @Json(name = "fixed")
        val fixed: String?,

        @Json(name = "type")
        val type: String?
    )

    data class Currency(
        @Json(name = "IAP")
        val iAP: IAP?,

        @Json(name = "cash")
        val cash: Cash?,

        @Json(name = "recharge")
        val recharge: Recharge?,

        @Json(name = "rule")
        val rule: String?,

        @Json(name = "settings")
        val settings: Settings?
    ) {

        data class IAP(
            @Json(name = "only")
            val only: Boolean?
        )

        data class Cash(
            @Json(name = "rule")
            val rule: String?,

            @Json(name = "status")
            val status: Boolean?
        )

        data class Recharge(
            @Json(name = "rule")
            val rule: String?,

            @Json(name = "status")
            val status: Boolean?
        )

        data class Settings(
            @Json(name = "recharge-ratio")
            val rechargeRatio: Int?,

            @Json(name = "recharge-options")
            val rechargeOptions: String?,

            @Json(name = "recharge-max")
            val rechargeMax: Int?,

            @Json(name = "recharge-min")
            val rechargeMin: Int?,

            @Json(name = "cash-max")
            val cashMax: Int?,

            @Json(name = "cash-min")
            val cashMin: Int?
        )
    }

    data class Wallet(
        @Json(name = "ratio")
        val ratio: Int?,

        @Json(name = "cash")
        val cash: Cash?,

        @Json(name = "recharge")
        val recharge: Recharge?,

        @Json(name = "transform-currency")
        val transformCurrency: Boolean?
    ) {

        data class Cash(
            @Json(name = "min-amount")
            val minAmount: Int?,

            @Json(name = "status")
            val status: Boolean?
        )

        data class Recharge(
            @Json(name = "status")
            val status: Boolean?
        )
    }

    data class Module(
        @Json(name = "id")
        val id: Int?,

        @Json(name = "module")
        val module: String?,

        @Json(name = "status")
        val status: Boolean?
    )

    data class YippiAds(
        @Json(name = "ads_count")
        val adsCount: String?,

        @Json(name = "ads_list")
        val adsList: List<Ads>?
    ) {

        data class Ads(
            @Json(name = "name")
            val name: String?,

            @Json(name = "url")
            val url: String?,

            @Json(name = "type")
            val type: String?
        )
    }

    data class Features(
        @Json(name = "cdn-resize-url")
        val cdnResizeUrl: String?,

        @Json(name = "enable_external_rtmp")
        val enableExternalRtmp: Boolean?,

        @Json(name = "eshop_banner_interval")
        val eshopBannerInterval: String?,

        @Json(name = "is_enabled_mini_video")
        val isEnabledMiniVideo: Boolean?,

        @Json(name = "live")
        val live: Boolean?,

        @Json(name = "live_banner_interval")
        val liveBannerInterval: String?,

        @Json(name = "message_request")
        val messageRequest: Boolean?,

        @Json(name = "token")
        val token: Boolean?
    )

    data class Httpdns(
        @Json(name = "pull-stream")
        val pullStream: Boolean?,

        @Json(name = "push-stream")
        val pushStream: Boolean?
    )

    data class QA(
        @Json(name = "switch")
        val switch: Boolean?,

        @Json(name = "apply_amount")
        val applyAmount: Int?,

        @Json(name = "onlookers_amount")
        val onlookersAmount: Int?,

        @Json(name = "anonymity_rule")
        val anonymityRule: String?,

        @Json(name = "reward_rule")
        val rewardRule: String?
    )

    data class PlusAppVersion(
        @Json(name = "open")
        val `open`: Boolean?
    )

    data class Checkin(
        @Json(name = "switch")
        val switch: Boolean?,

        @Json(name = "balance")
        val balance: Int?
    )

    data class Feed(
        @Json(name = "reward")
        val reward: Boolean?,

        @Json(name = "paycontrol")
        val payControl: Boolean?,

        @Json(name = "items")
        val items: List<Int>?,

        @Json(name = "limit")
        val limit: Int?
    )

    data class News(
        @Json(name = "contribute")
        val contribute: Contribute?,

        @Json(name = "pay_contribute")
        val payContribute: Int?
    ) {

        data class Contribute(
            @Json(name = "pay")
            val pay: Boolean?,

            @Json(name = "verified")
            val verified: Boolean?
        )
    }

    data class GroupCreate(
        @Json(name = "need_verified")
        val needVerified: Boolean?
    )

    data class GroupReward(
        @Json(name = "status")
        val status: Boolean?
    )

    companion object {
        //for divider purpose only
        const val DIVIDER = 0

        // MATCH WITH ID RETURN BY BACKEND
        const val TOGA_NEWS = 1
        const val TOGA_GAMES = 2
        const val PEOPLE_NEARBY = 3
        const val STICKER = 4
        const val WAVE = 5
        const val YIPPI_EVENT = 6
        const val REWARD_LINK = 7
        const val TA_MALL = 8
        const val SHOPPING = 9
        const val EDUCATION = 10
        const val PAID_STICKER = 11
        const val FU_TOOL = 12
        const val SCAN_AND_TRANFER = 13
        const val TOGA_VIP_SUBCRIBE = 14
        const val HOTEL_FLIGHT = 15
        const val HUNGRY_BEAR = 16
        const val REPORT = 17
        const val LIVE = 18
        const val CUSTOMER_SUPPORT = 19
        const val IN_APP_PURCHASE = 20
        const val HALL_OF_FAME = 21
        const val LEVEL_PRIVILEGE = 22
        const val REST_N_GO = 23
        const val MOBILE_TOPUP = 24
        const val FEED_BLOCK = 25 // IOS ONLY
        const val MINI_PROGRAM = 26
        const val UTILITIES_BILL = 27
        const val YIPPS_WANTED_QR_ENTRY = 28

        // ONLY LOCAL INDICATOR PURPOSE
        const val WALLET = 1000
        const val COMMENT = 1001
        const val SETTING = 1002
        const val SCAN_PROFILE = 1003
        const val INCUBATOR = 1004
        const val ESHOP = 1005
        const val SUPPORT_SYSTEM = 1006
        const val NOTIFICATION = 1007
    }
}