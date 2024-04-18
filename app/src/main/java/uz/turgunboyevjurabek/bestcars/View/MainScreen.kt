@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.bestcars.View

import android.annotation.SuppressLint
import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.bestcars.R
import uz.turgunboyevjurabek.bestcars.madels.CarInfo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AutoboxingStateCreation")
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                MediumTopAppBar(
                    title = { Text(text = "Best cars", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Serif) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    scrollBehavior = scrollBehavior
                )
            }
        ) {innerPadding->
            Column(modifier = Modifier
                .padding(innerPadding)
            ) {
                val list=ArrayList<CarInfo>()
                list.addAll(listOf(
                    CarInfo("Tesla S",
                        painterResource(id = R.drawable.tesla_logo),
                        painterResource(id = R.drawable.tesla_sedan_red)
                    ),
                    CarInfo("Mercedes-benz",
                        painterResource(id = R.drawable.mers_logo),
                        painterResource(id = R.drawable.mers_oldtimer)
                    ),
                    CarInfo("Bmw x5",
                        painterResource(id = R.drawable.bmw_logo),
                        painterResource(id = R.drawable.bmw_x5)
                    ),
                    CarInfo("Ferrari",
                        painterResource(id = R.drawable.ferrari_logo),
                        painterResource(id = R.drawable.ferrari_sideview)
                    ),
                    CarInfo("Ford Mustang",
                        painterResource(id = R.drawable.mustang_logo),
                        painterResource(id = R.drawable.ford_mustang)
                    ),
                    CarInfo("Mercedes-benz G class",
                        painterResource(id = R.drawable.mers_logo),
                        painterResource(id = R.drawable.gelik)
                    ),
                    CarInfo("Hummer",
                        painterResource(id = R.drawable.hummer_logo),
                        painterResource(id = R.drawable.hummer)
                    ),


                    ))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(list.size){
                        MainListUI(list[it])
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainUI() {
    MainScreen()
}

@Composable
fun MainListUI(carInfo: CarInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(170.dp)
    ) {
       Row(modifier = Modifier
           .fillMaxSize()
       ) {
           Column(
               modifier = Modifier
                   .weight(0.7f)
                   .fillMaxSize()                ,
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceAround
           ) {

                   Text(
                       text = carInfo.name,
                       fontFamily = FontFamily.Serif,
                       fontWeight = FontWeight.SemiBold,
                       fontSize = 15.sp

                   )
                  Image(
                      painter = carInfo.logo,
                      contentDescription = "Car logo",
                      modifier = Modifier
                          .size(40.dp),
                      contentScale = ContentScale.Fit
                  )
               }
           Column(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
               Image(
                   painter = carInfo.img,
                   contentDescription = null,
                   modifier = Modifier
                       .size(200.dp)
               )
           }
       }
    }
}

@Preview
@Composable
private fun ListUI() {
//    MainListUI()
}