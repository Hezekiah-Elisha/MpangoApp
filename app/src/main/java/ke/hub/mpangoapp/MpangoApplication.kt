package ke.hub.mpangoapp

import android.app.Application
import ke.hub.mpangoapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MpangoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MpangoApplication)
            modules(appModule)
        }
    }
}
