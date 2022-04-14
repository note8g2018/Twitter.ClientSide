package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SnackBarController(
    private val coroutineScope: CoroutineScope,
                        )
{
    private var snackBarJob: Job? = null

    init
    {
        cancelActiveJob()
    }

    fun getScope() = coroutineScope
    fun showSnackBar(
        scaffoldState: ScaffoldState,
        message: String,
        actionLabel: String,
        duration: SnackbarDuration = SnackbarDuration.Short
                    )
    {
        if (snackBarJob == null)
        {
            snackBarJob = coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLabel,
                    duration = duration,
                                                            )
                cancelActiveJob()
            }
        }
        else
        {
            cancelActiveJob()
            snackBarJob = coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLabel,
                    duration = duration,
                                                            )
                cancelActiveJob()
            }
        }
    }

    private fun cancelActiveJob()
    {
        snackBarJob?.let { job->
            job.cancel()
            snackBarJob = Job()
        }
    }
}