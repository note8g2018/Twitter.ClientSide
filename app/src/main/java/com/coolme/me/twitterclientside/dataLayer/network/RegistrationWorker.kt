package com.coolme.me.twitterclientside.dataLayer.network

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.coolme.me.twitterclientside.R
import com.coolme.me.twitterclientside.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

private const val CHANNEL_ID = "VERBOSE_NOTIFICATION"

@HiltWorker
class RegistrationExpeditedWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val registrationNetwork: RegistrationNetwork,
                                                             )
    : CoroutineWorker(appContext, workerParams)
{
//    override suspend fun getForegroundInfo(): ForegroundInfo
//    {
//        return ForegroundInfo(
//            NOTIFICATION_ID, createNotification()
//                             )
//    }

    override suspend fun doWork(): Result
    {
        withContext(Dispatchers.IO) {
            val appContext2 = applicationContext

            makeStatusNotification(message = "Registration User",
                                  context = appContext2)

            val regJson: String? =
                inputData.getString("regJson")
            val registrationUiState: RegistrationUiState =
                Json.decodeFromString(
                    deserializer = RegistrationUiState.serializer(),
                    string = regJson!!
                                     )
            registrationNetwork.registerUser(registrationUiState)

            //return Result.success()
        }
        return Result.success()
    }

//    private fun createNotification() : Notification
//    {
//        TODO()
//    }

    private fun makeStatusNotification(message: String, context: Context)
    {

        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            val name = "Verbose WorkManager Notifications"
            val description = "Shows notifications whenever work starts"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description

            // Add the channel
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager?

            notificationManager?.createNotificationChannel(channel)
        }

        // Create the notification
        val builder = NotificationCompat
                .Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("WorkRequest Starting")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(LongArray(0))

        // Show the notification
        NotificationManagerCompat
                .from(context).notify(1, builder.build())
    }

}