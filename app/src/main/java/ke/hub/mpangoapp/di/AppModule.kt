package ke.hub.mpangoapp.di

import androidx.room3.Room
import ke.hub.mpangoapp.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule =
    module {
        single { Dispatchers.IO }
        single {
            Room
                .databaseBuilder<AppDatabase>(
                    androidContext(),
                    "mpango_database",
                ).setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }
    }
