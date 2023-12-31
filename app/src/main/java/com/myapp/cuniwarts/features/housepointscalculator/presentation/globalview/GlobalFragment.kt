package com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myapp.cuniwarts.features.housepointscalculator.domain.components.Operation
import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.CuniwardsHouses
import com.myapp.cuniwarts.features.housepointscalculator.presentation.utils.VibratorHelper
import com.myapp.cuniwarts.ui.theme.AccessGold
import com.myapp.cuniwarts.ui.theme.CuniwartsTheme
import com.myapp.cuniwarts.ui.theme.RelyDarkGold
import com.myapp.cuniwarts.ui.theme.hpSansFamily

@Composable
fun GlobalFragment(
    viewModel : GlobalViewModel = hiltViewModel(),
    navigateToResult: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AccessGold)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Cuniwarts",
            fontFamily = hpSansFamily,
            fontSize = 100.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        )

        PlusMinusButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 45.dp, end = 45.dp),
            onClick = {viewModel.selectedOperation(it)})

        ButtonHorizontalPager(
            items = intArrayOf(1,5,10,50,100),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 15.dp)
                .fillMaxWidth(),
            buttonSelected = {
                viewModel.addValue(it)
            },
            buttonUnelected ={
                viewModel.subValue(it)
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){

            HouseImage(house = CuniwardsHouses.BabiBlu()){
                viewModel.updateHouseValue(it)
            }

            HouseImage(house = CuniwardsHouses.CravaNe()){
                viewModel.updateHouseValue(it)
            }

        }

        Row(modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            HouseImage(house = CuniwardsHouses.GiariGris()){
                viewModel.updateHouseValue(it)
            }

            HouseImage(house = CuniwardsHouses.SuiruRos()){
                viewModel.updateHouseValue(it)
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp, bottom = 20.dp)
                .height(80.dp),
            colors = buttonColors(containerColor = RelyDarkGold),
            border = BorderStroke(8.dp, color = RelyDarkGold),
            onClick = { navigateToResult.invoke() }
        ) {
            Text(text = "View Results", color = AccessGold, fontWeight = FontWeight.Bold, fontSize = 40.sp, fontFamily = hpSansFamily)
        }

    }
}

@Composable
private fun HouseImage(
    house: CuniwardsHouses,
    modifier: Modifier = Modifier,
    clickAction: (CuniwardsHouses) -> Unit
){

    val vibratorHelper = VibratorHelper(LocalContext.current)

    Image(
        painter = painterResource(id = house.animal),
        contentDescription = stringResource(id = house.name),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .size(160.dp)
            .background(
                color = colorResource(id = house.color) ,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .clickable {
                vibratorHelper.vibrate(100L)
                clickAction.invoke(house)
            }
    )
}

@Composable
private fun ButtonHorizontalPager(
    items: IntArray,
    modifier: Modifier = Modifier,
    buttonSelected: (Int) -> Unit,
    buttonUnelected: (Int) -> Unit
){

    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        items.forEach {
            SelectableButton(
                text = "$it",
                internalValue = it,
                modifier = Modifier
                    .padding(10.dp)
                    .width(100.dp),
                selected = { value ->
                    (value as? Int)?.let {adder ->
                        buttonSelected(adder)
                    }
                },
                unselected ={ value ->
                    (value as? Int)?.let { subbed ->
                        buttonUnelected(subbed)
                    }
                }
            )
        }
    }
}

@Composable
private fun SelectableButton(
    text: String,
    internalValue: Any?,
    modifier: Modifier = Modifier,
    selected: (Any?) -> Unit,
    unselected: (Any?) -> Unit
){

    var isPressed : Boolean by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isPressed = !isPressed
            when(isPressed){
                true -> selected.invoke(internalValue)
                else -> unselected.invoke(internalValue)
            }
        },
        colors = buttonColors( containerColor = if (isPressed) RelyDarkGold else AccessGold),
        border = BorderStroke(5.dp, color = RelyDarkGold),
        modifier = modifier
    ) {

        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 30.sp, color = if (isPressed) AccessGold else RelyDarkGold)

    }
}

@Composable
private fun PlusMinusButtons(
    modifier: Modifier = Modifier,
    onClick: (Operation) -> Unit
){

    var isAddPressed : Boolean by remember { mutableStateOf(true) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        /**
         * Bottone che permette l'addizione
         */
        Button(
            colors = buttonColors( containerColor = if (isAddPressed) RelyDarkGold else AccessGold),
            border = BorderStroke(5.dp, color = RelyDarkGold),
            onClick = {
            isAddPressed = true
            onClick.invoke(Operation.SUM)
        }) {
            Text(text = "Somma", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = if (isAddPressed) AccessGold else RelyDarkGold)
        }

        /**
         * Bottone che permette la sottrazione
         */
        Button(
            colors = buttonColors( containerColor = if (!isAddPressed) RelyDarkGold else AccessGold),
            border = BorderStroke(5.dp, color = RelyDarkGold),
            onClick = {
            isAddPressed = false
            onClick.invoke(Operation.SUB)
        }) {
            Text(text = "Sottrai", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = if (!isAddPressed) AccessGold else RelyDarkGold)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GlobalFragmentPreview() {
    CuniwartsTheme {
        GlobalFragment {}
    }
}