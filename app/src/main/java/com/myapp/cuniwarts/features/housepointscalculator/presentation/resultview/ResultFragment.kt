package com.myapp.cuniwarts.features.housepointscalculator.presentation.resultview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.CuniwardsHouses
import com.myapp.cuniwarts.ui.theme.AccessGold
import com.myapp.cuniwarts.ui.theme.hpSansFamily

@Composable
fun ResultFragment(
    viewModel: ResultViewModel = hiltViewModel()
){

    val houseList by viewModel.houses.collectAsState()

    LaunchedEffect(Unit){
        viewModel.returnHousesWithPoints()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AccessGold)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 10.dp, bottom = 10.dp, end = 50.dp)
            .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = hpSansFamily,
                text = "Posizione"
            )
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = hpSansFamily,
                text = "Casata")
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = hpSansFamily,
                text = "Punteggio")
            
        }
        
        houseList.forEachIndexed { index, houseWithResult ->
            houseWithResult.house?.let {
                ResultHouseRow(
                    house = it,
                    points = houseWithResult.points,
                    position = index+1)
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))

    }

}

@Composable
private fun ResultHouseRow(house: CuniwardsHouses, points: Int, position: Int){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 80.dp,top = 10.dp, bottom = 10.dp, end = 75.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = hpSansFamily,
            text = "$position°"
        )
        Box(Modifier.align(Alignment.CenterVertically)) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    modifier = Modifier.padding(end = 10.dp).align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = hpSansFamily,
                    text = stringResource(id = house.name)
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = colorResource(id = house.color),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(start = 8.dp),
                    painter = painterResource(id = house.animal),
                    contentDescription = stringResource(id = house.name))
            }
        }
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = hpSansFamily,
            text = "$points"
        )
    }

}