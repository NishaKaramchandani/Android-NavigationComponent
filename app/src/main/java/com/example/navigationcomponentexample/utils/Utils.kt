package com.example.navigationcomponentexample.utils

import androidx.navigation.NavController
import androidx.navigation.NavDirections


fun NavController.safeNavigate(direction: NavDirections) {
        //Log.d(MainFragment.TAG, "Click happened")
        currentDestination?.getAction(direction.actionId)?.run {
            //Log.d(MainFragment.TAG, "Click Propagated")
            navigate(direction)
        }
}
