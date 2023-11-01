package com.myapp.cuniwarts.features.housepointscalculator.presentation.utils

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.myapp.cuniwarts.R
import com.myapp.cuniwarts.features.housepointscalculator.domain.components.House

sealed class CuniwardsHouses(@StringRes open val name: Int, @DrawableRes open val animal: Int, @ColorRes open val color: Int, open val id: String){

    data class BabiBlu(
        override val name: Int = R.string.BABI_BLU_NAME,
        override val animal: Int = R.drawable.babi_blu,
        override val color: Int = R.color.babi_blu,
        override val id: String = House.BABUBLU
    ):CuniwardsHouses(name, animal, color,id)

    data class CravaNe(
        override val name: Int = R.string.CRAVA_NE_NAME,
        override val animal: Int = R.drawable.crava_ne,
        override val color: Int = R.color.crava_ne,
        override val id: String = House.CRAVANE
    ):CuniwardsHouses(name, animal, color,id)

    data class GiariGris(
        override val name: Int = R.string.GIARI_GRIS_NAME,
        override val animal: Int = R.drawable.giari_gris,
        override val color: Int = R.color.giari_gris,
        override val id: String = House.GIARISGRIS
    ):CuniwardsHouses(name, animal, color,id)

    data class SuiruRos(
        override val name: Int = R.string.SUIRU_ROS_NAME,
        override val animal: Int = R.drawable.suiru_ros,
        override val color: Int = R.color.suiru_ros,
        override val id: String = House.SUIRURUS
    ):CuniwardsHouses(name, animal, color,id)

}
