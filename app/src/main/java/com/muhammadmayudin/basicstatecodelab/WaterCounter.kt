package com.muhammadmayudin.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Muhammad Mayudin on 13-Dec-22
 */
/*
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
*/
/*
    Column(modifier = modifier.padding(16.dp)) {
        *//*
*/
/*var count = 0
        Text("You've had $count glasses.")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }*//*
*/
/*

        // Changes to count are now tracked by Compose
        var count by remember { mutableStateOf(0) }

        *//*
*/
/*Text("You've had $count glasses.")*//*
*/
/*

       *//*
*/
/* if (count > 0) {
            // This text is present if the button has been clicked
            // at least once; absent otherwise
            Text("You've had $count glasses.")
        }*//*
*/
/*

        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { },
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }
            Text("You've had $count glasses.")
        }

        *//*
*/
/*
        * Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
        * *//*
*/
/*

        *//*
*/
/*
        * State drives which elements are present in the UI at a given moment.
        * *//*
*/
/*
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10){
            Text("Add one")
        }


    }*//*


    Column(modifier = modifier.padding(16.dp)) {

        //var count by remember { mutableStateOf(0) }
        */
/*
        * Gunakan rememberSaveable untuk memulihkan status UI Anda setelah suatu Aktivitas atau proses dibuat ulang. Selain mempertahankan status dalam berbagai rekomposisi, rememberSaveable juga mempertahankan status dalam seluruh pembuatan ulang Aktivitas dan proses.
        * *//*

        var count by rememberSaveable { mutableStateOf(0) }




        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }
            Text("You've had $count glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }
        }
    }
}
*/


/*
* Stateful vs Stateless
* Jika semua status dapat diekstrak dari fungsi composable, fungsi composable yang dihasilkan akan disebut stateless.
* Fungsi composable stateless adalah fungsi composable yang tidak memiliki status apa pun, yang berarti fungsi tersebut tidak memiliki atau menentukan atau mengubah status baru.
* Composable stateful adalah composable yang memiliki bagian status yang dapat berubah dari waktu ke waktu.
* Dalam aplikasi yang sebenarnya, memiliki composable stateless 100% bisa jadi sulit dicapai bergantung pada tanggung jawab composable. Anda harus mendesain composable dengan cara yang akan memungkinkan sesedikit mungkin status dan memungkinkan status diangkat, jika memungkinkan, dengan mengeksposnya di API composable.
* */

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}