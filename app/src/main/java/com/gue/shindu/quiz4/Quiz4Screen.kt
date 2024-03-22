package com.gue.shindu.quiz4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gue.shindu.quiz4.ui.AwalScreen
import com.gue.shindu.quiz4.ui.CVScreen
import com.gue.shindu.quiz4.ui.GambarBulat
import com.gue.shindu.quiz4.ui.MediasiScreen
import com.gue.shindu.quiz4.ui.MenikahScreen
import com.gue.shindu.quiz4.ui.theme.BodyBackground
import com.gue.shindu.quiz4.ui.theme.GrayHSITaaruf
import com.gue.shindu.quiz4.ui.theme.PinkHSITaaruf

enum class Quiz4Screen {
    Awal,
    IsiCV,
    Mediator,
    Menikah
}

@Composable
fun Quiz4App(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Quiz4Screen.valueOf(
        backStackEntry?.destination?.route ?: Quiz4Screen.Awal.name
    )

    Scaffold(
        topBar = {
            Quiz4AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateBack = { navController.navigateUp() }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Quiz4Screen.Awal.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Quiz4Screen.Awal.name) {
                AwalScreen(
                    onNextButtonClicked = {
                        navController.navigate(Quiz4Screen.IsiCV.name)
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            composable(route = Quiz4Screen.IsiCV.name) {
                CVScreen(
                    onNextButtonClicked = {
                        navController.navigate(Quiz4Screen.Mediator.name)
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            composable(route = Quiz4Screen.Mediator.name) {
                MediasiScreen(
                    onNextButtonClicked = {
                        navController.navigate(Quiz4Screen.Menikah.name)
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            composable(route = Quiz4Screen.Menikah.name) {
                MenikahScreen(
                    onNextButtonClicked = {
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun Quiz4AppBar(
    currentScreen: Quiz4Screen,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (currentScreen == Quiz4Screen.Awal) {
        AwalAppBar(modifier)
    }
    else {
        DefaultAppBar(currentScreen.ordinal, canNavigateBack, navigateBack, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    pageIndex: Int,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                GambarBulat(
                    color = if (pageIndex == 1) PinkHSITaaruf else GrayHSITaaruf,
                    size = 16.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                GambarBulat(
                    color = if (pageIndex == 2) PinkHSITaaruf else GrayHSITaaruf,
                    size = 16.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                GambarBulat(
                    color = if (pageIndex == 3) PinkHSITaaruf else GrayHSITaaruf,
                    size = 16.dp
                )
            }
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                        tint = BodyBackground
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AwalAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(R.drawable.title),
                    contentDescription = stringResource(R.string.app_name),
                    contentScale = ContentScale.None,
                )
                Text(
                    text = "v.2312–3101",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
        modifier = modifier,
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun PreviewAppBarAwal() {
    Quiz4AppBar(
        currentScreen = Quiz4Screen.Awal,
        navigateBack = { },
        canNavigateBack = false
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun PreviewAppBarOther() {
    Quiz4AppBar(
        currentScreen = Quiz4Screen.Mediator,
        navigateBack = { },
        canNavigateBack = false
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun PreviewApp() {
    Quiz4App()
}