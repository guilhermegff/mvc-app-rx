package com.project.hotmartservice

class HotMartRepository(private val hotMartDataSource: HotMartDataSource) : HotMartDataSource {

    companion object {
        private var INSTANCE: HotMartRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param remoteDataSource the backend data source
         * *
         * @return the [RemoteRepository] instance
         */
        @JvmStatic
        fun getInstance(hotMartDataSource: HotMartDataSource) = INSTANCE
            ?: synchronized(HotMartRepository::class.java) {
                INSTANCE
                    ?: HotMartRepository(hotMartDataSource)
                        .also { INSTANCE = it }
            }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun locations() = hotMartDataSource.locations()
}