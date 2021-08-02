package com.example.template_v2

@HiltAndroidApp
class TemplateApplication : MainApplication() {

    @Inject
    lateinit var connectWorkerFactory: ConnectWorkerFactory

    @Inject
    lateinit var engageWorkerFactory: EngageWorkerFactory

    @Inject
    lateinit var socialWorkerFactory: SocialWorkerFactory

    @Inject
    lateinit var stickerWorkerFactory: StickerWorkerFactory

    override fun getWorkerFactories(): List<WorkerFactory> {
        return listOf(
            connectWorkerFactory,
            engageWorkerFactory,
            socialWorkerFactory,
            stickerWorkerFactory
        )
    }
}