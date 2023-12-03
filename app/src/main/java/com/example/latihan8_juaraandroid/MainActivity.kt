package com.example.latihan8_juaraandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.latihan8_juaraandroid.ui.theme.Latihan8_juaraandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan8_juaraandroidTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }

//                membuat composable AplikasiLemon()
                AplikasiLemon()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AplikasiLemon(){
//    membuat composable remember dan fungsi mutableStateOf()
    var langkahSekarang by remember {mutableStateOf(1) }
    var hitungTekanan by remember { mutableStateOf(0) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                       Text(text = "APlikasi Lemon", fontWeight = FontWeight.Bold)
                    },
            colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }){
        innerPadding ->
    Surface(
        modifier = Modifier.fillMaxSize().padding(innerPadding).background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ){
     when(langkahSekarang){
         1->{
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center,
                 modifier = Modifier.fillMaxSize()
             ){
                 Text(text = stringResource(R.string.tap_the_lemon_tree_to_select))
                 Spacer(modifier = Modifier.height(32.dp))
                 Image(
                     painter = painterResource(R.drawable.lemon_tree),
                     contentDescription = stringResource(R.string.lemon_tree),
                     modifier = Modifier
                         .wrapContentSize()
                         .clickable {
                             langkahSekarang = 2
                             hitungTekanan = (2..4).random()
                         }
                 )

             }
         }

         2->{
             Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                 Text(text = stringResource(R.string.keep_tapping_the_lemon))
                 Spacer(modifier = Modifier.height(32.dp))
                 Image(
                     painter = painterResource(R.drawable.lemon_squeeze),
                     contentDescription = stringResource(R.string.lemon),
                     modifier = Modifier
                         .wrapContentSize()
                         .clickable {
                             hitungTekanan--
                             if (hitungTekanan == 0) {
                                 langkahSekarang = 3
                             }
                         }
                 )
             }
         }

         3->{
             Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                 Text(text = stringResource(R.string.tap_the_lemonade))
                 Spacer(modifier = Modifier.height(32.dp))
                 Image(
                     painter = painterResource(R.drawable.lemon_drink),
                     contentDescription = stringResource(R.string.glass_of),
                     modifier = Modifier
                         .wrapContentSize()
                         .clickable {
                             langkahSekarang = 4
                         }
                 )
             }
         }
         4->{
             Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                 Text(text = stringResource(R.string.tap_the_empty_glass))
                 Spacer(modifier = Modifier.height(32.dp))
                 Image(
                     painter = painterResource(R.drawable.lemon_restart),
                     contentDescription = stringResource(R.string.empty_glass),
                     modifier = Modifier
                         .wrapContentSize()
                         .clickable {
                             langkahSekarang = 1
                         }
                 )
             }
         }

     }
    }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Latihan8_juaraandroidTheme {
        AplikasiLemon()
    }
}