package com.muhammadmayudin.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Created by Muhammad Mayudin on 13-Dec-22
 */
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        /*
        * MutableList yang dapat diobservasi
        * Fungsi mutableStateOf menampilkan objek berjenis MutableState<T>.
        * Fungsi mutableStateListOf dan toMutableStateList menampilkan objek berjenis SnapshotStateList<T>. Di bagian ini, istilah "yang dapat diamati MutableList" merujuk ke class ini.
        * */
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}

